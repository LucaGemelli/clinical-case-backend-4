package br.com.enfermagem.service;

import static java.util.Optional.of;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.enfermagem.dto.EvolucaoDetalheDTO;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Evolucao;
import br.com.enfermagem.repository.EvolucaoRepository;

@ExtendWith(MockitoExtension.class)
public class EvolucaoServiceTest {

	@InjectMocks
	private EvolucaoService service;

	@Mock
	private EvolucaoRepository repository;

	private static Long ID = 1L;
	private static LocalDateTime DATE = LocalDateTime.now();

	@Test
	public void deveRetornarPageEvolucaoDto() {
		Pageable page = mock(Pageable.class);
		given(repository.findAll(page)).willReturn(mockPageEvolucao());
		assertNotNull(service.findAll(page));
	}

	@Test
	public void deveBuscaEvolucaoDto() {
		given(repository.findById(ID)).willReturn(of(mockEvolucao()));
		assertNotNull(service.findEvolucaoById(ID));
	}

	@Test
	public void deveRetornarErroNotFoundException() {
		assertThrows(NotFoundException.class, () -> {
			service.findEvolucaoById(2L);
		});
	}

	@Test
	public void deveSalvaEvolucao() {
		given(repository.save(mockEvolucao())).willReturn(mockEvolucao());
		assertNotNull(service.save(mockEvolucaoDto()));
	}


	@Test
	public void deveAtualizarEvolucao() {
		// given
		Evolucao evo = mockEvolucao();
		given(repository.findById(ID)).willReturn(of(evo));
		given(repository.save(evo)).willReturn(evo);
		
		// when
		service.update(mockEvolucaoDto());

		// then
		then(repository).should().findById(ID);
		then(repository).should().save(evo);
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void deveDeletarEvolucao() {
		// given
		service.delete(ID);

		then(repository).should().deleteById(ID);
		verifyNoMoreInteractions(repository);
	}

	private EvolucaoDetalheDTO mockEvolucaoDto() {
		EvolucaoDetalheDTO evolucaoDto = new EvolucaoDetalheDTO();
		evolucaoDto.setId(ID);
		evolucaoDto.setDataHora(DATE);
		return evolucaoDto;
	}

	private Evolucao mockEvolucao() {
		Evolucao evo = new Evolucao();
		evo.setId(ID);
		evo.setDataHora(DATE);
		return evo;
	}

	private Page<Evolucao> mockPageEvolucao() {
		return new PageImpl<Evolucao>(new ArrayList<Evolucao>());
	}

}
