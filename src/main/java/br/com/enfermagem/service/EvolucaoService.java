package br.com.enfermagem.service;

import br.com.enfermagem.dto.EvolucaoDTO;
import br.com.enfermagem.dto.EvolucaoDetalheDTO;
import br.com.enfermagem.dto.EvolucaoEditarDTO;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Evolucao;
import br.com.enfermagem.repository.EvolucaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EvolucaoService implements DefaultService {

    private final EvolucaoRepository repository;

    public EvolucaoService(EvolucaoRepository repository) {
        this.repository = repository;
    }

    public Page<EvolucaoDTO> findAll(Pageable pageable) {
        Page<Evolucao> page = this.repository.findAll(pageable);
        List<EvolucaoDTO> evolucoesDTOList = page.stream().map(this::convertToDto).collect(Collectors.toList());

        return new PageImpl<>(evolucoesDTOList, pageable, evolucoesDTOList.size());
    }

    public EvolucaoDTO findEvolucaoById(Long id) {
        return this.convertToEditarDto(this.repository.findById(id).orElseThrow(() -> new NotFoundException("Evolução não encontrada!")));
    }

    public Long save(EvolucaoDetalheDTO dto) {
        return this.repository.save(this.convertToEntity(dto)).getId();
    }

    public Long update(EvolucaoDetalheDTO dto) {
        this.findEvolucaoById(dto.getId());
        return this.repository.save(this.convertToEntity(dto)).getId();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    private EvolucaoDTO convertToDto(final Evolucao entity) {
        return this.getModelMapper().map(entity, EvolucaoDTO.class);
    }

    private EvolucaoEditarDTO convertToEditarDto(final Evolucao entity) {
        return this.getModelMapper().map(entity, EvolucaoEditarDTO.class);
    }

    private Evolucao convertToEntity(final EvolucaoDetalheDTO dto) {
        if (Objects.isNull(dto.getDataHora())) {
            dto.setDataHora(LocalDateTime.now());
        }

        return this.getModelMapper().map(dto, Evolucao.class);
    }
}
