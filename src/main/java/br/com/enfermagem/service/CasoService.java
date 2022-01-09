package br.com.enfermagem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.dto.CasoDTO;
import br.com.enfermagem.dto.CasoEditarDTO;
import br.com.enfermagem.exception.BusinessException;
import br.com.enfermagem.exception.InvalidFieldException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Caso;
import br.com.enfermagem.repository.CasoRepository;

@Service
public class CasoService implements DefaultService {

    private final CasoRepository repository;

    private final PacienteService pacienteService;

    public CasoService(final CasoRepository repository,
                       final PacienteService pacienteService) {
        this.pacienteService = pacienteService;
        this.repository = repository;
    }

    public Page<CasoDTO> findAll(final Pageable pageable) {
        final Page<Caso> page = this.repository.findAll(pageable);
        final List<CasoDTO> casoDto = page.stream()
                                    .map(this::convertToDto)
                                    .collect(Collectors.toList());
        return new PageImpl<CasoDTO>(casoDto, pageable, casoDto.size());
    }

    public CasoEditarDTO findById(final Long id) {
        return findCasoById(id);
    }

    public Long save(final CasoEditarDTO dto) {
        this.validateFields(dto);

        if (Objects.isNull(dto.getDataHora())) {
            dto.setDataHora(LocalDateTime.now());
        }

        this.setCodeCaso(dto);
        return this.repository.save(this.convertToEntity(dto)).getId();
    }

    public Long update(final CasoEditarDTO dto) {
        this.findCasoById(dto.getId());
        this.validateFields(dto);
        this.setCodeCaso(dto);
        return this.repository.save(this.convertToEntity(dto)).getId();
    }

    public void delete(final Long id) {
        this.findCasoById(id);

        if (!this.pacienteService.findPacientesByIdCaso(id).isEmpty()) {
            throw new BusinessException("Não é possível excluir um caso referente a um paciente");
        }

        this.repository.deleteById(id);
    }

    private void setCodeCaso(final CasoEditarDTO caso) {
        caso.setCode(UUID.randomUUID().toString().toUpperCase().substring(0, 5));
    }

    private CasoEditarDTO findCasoById(final Long id) {
        return this.convertToEditarDto(this.repository
                                           .findById(id)
                                           .orElseThrow(() -> new NotFoundException("Caso não encontrado!")));
    }

    private void validateFields(final CasoEditarDTO dto) {
        if (StringUtils.isBlank(dto.getIdentificacao())) {
            throw new InvalidFieldException("O campo Identificação deve ser preenchido");
        }
    }

    private CasoDTO convertToDto(final Caso entity) {
        return this.getModelMapper().map(entity, CasoDTO.class);
     }

    private CasoEditarDTO convertToEditarDto(final Caso entity) {
        return this.getModelMapper().map(entity, CasoEditarDTO.class);
     }

    private Caso convertToEntity(final CasoDTO dto) {
      return this.getModelMapper().map(dto, Caso.class);
    }
}
