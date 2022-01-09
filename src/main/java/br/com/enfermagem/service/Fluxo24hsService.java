package br.com.enfermagem.service;

import br.com.enfermagem.dto.Fluxo24hsDTO;
import br.com.enfermagem.dto.Fluxo24hsDetalheDTO;
import br.com.enfermagem.dto.Fluxo24hsEditarDTO;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Fluxo24hs;
import br.com.enfermagem.repository.Fluxo24hsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class Fluxo24hsService implements DefaultService {

    private final Fluxo24hsRepository repository;

    public Fluxo24hsService(Fluxo24hsRepository repository) {
        this.repository = repository;
    }

    public Page<Fluxo24hsDTO> findAll(Pageable pageable) {
        Page<Fluxo24hs> page = this.repository.findAll(pageable);
        List<Fluxo24hsDTO> fluxo24hsDTOList = page.stream().map(this::convertToDto).collect(Collectors.toList());

        return new PageImpl<>(fluxo24hsDTOList, pageable, fluxo24hsDTOList.size());
    }

    public Fluxo24hsDTO findFluxoById(Long id) {
        return this.convertToEditarDto(this.repository.findById(id).orElseThrow(() -> new NotFoundException("Fluxo24hs não encontrado!")));
    }

    public Long save(Fluxo24hsDetalheDTO dto) {
        return this.repository.save(this.convertToEntity(dto)).getId();
    }

    public Long update(Fluxo24hsDetalheDTO dto) {
        this.findFluxoById(dto.getId());
        return this.repository.save(this.convertToEntity(dto)).getId();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    private Fluxo24hsDTO convertToDto(final Fluxo24hs entity) {
        return this.getModelMapper().map(entity, Fluxo24hsDTO.class);
    }

    private Fluxo24hsEditarDTO convertToEditarDto(final Fluxo24hs entity) {
        return this.getModelMapper().map(entity, Fluxo24hsEditarDTO.class);
    }

    private Fluxo24hs convertToEntity(final Fluxo24hsDetalheDTO dto) {
        if (Objects.isNull(dto.getDataHora())) {
            dto.setDataHora(LocalDateTime.now());
        }

        return this.getModelMapper().map(dto, Fluxo24hs.class);
    }
}
