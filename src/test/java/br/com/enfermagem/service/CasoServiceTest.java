package br.com.enfermagem.service;

import static java.util.Optional.of;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.enfermagem.dto.CasoEditarDTO;
import br.com.enfermagem.exception.InvalidFieldException;
import br.com.enfermagem.model.Caso;
import br.com.enfermagem.repository.CasoRepository;

@ExtendWith(MockitoExtension.class)
public class CasoServiceTest {

	@InjectMocks
	private CasoService casoService;

    @Mock
	private CasoRepository repository;

    private static Long ID = 1L;

	@Test
	public void deveRetornarPageCasoDto() {
		Pageable page = mock(Pageable.class);
		given(repository.findAll(page)).willReturn(mockPageCaso());
		assertNotNull(casoService.findAll(page));
	}

	@Test
	public void deveBuscaCasoDto() {
		given(repository.findById(ID)).willReturn(of(mockCaso()));
		assertNotNull(casoService.findById(ID));
	}

	@Test
	public void deveRetornarErroInvalidFieldException() {
		assertThrows(InvalidFieldException.class, () -> {
			casoService.save( new CasoEditarDTO());
		});
	}

	private Page<Caso> mockPageCaso() {
		Page<Caso> pageCaso = new PageImpl<Caso>(new ArrayList<Caso>());
		return pageCaso;
	}

	private Caso mockCaso() {
		return new Caso();
	}

}
