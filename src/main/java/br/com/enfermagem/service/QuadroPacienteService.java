package br.com.enfermagem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.dto.QuadroPacienteDTO;
import br.com.enfermagem.dto.QuadroPacienteEditarDTO;
import br.com.enfermagem.exception.InvalidFieldException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.QuadroPaciente;
import br.com.enfermagem.repository.QuadroPacienteRepository;

@Service
public class QuadroPacienteService implements DefaultService {

    private final QuadroPacienteRepository repository;

    public QuadroPacienteService(QuadroPacienteRepository repository) {
        this.repository = repository;
    }

    public Page<QuadroPacienteDTO> findAll(Pageable pageable) {
        Page<QuadroPaciente> page = repository.findAll(pageable);
        List<QuadroPacienteDTO> pagedto = page.stream()
                                              .map(this::convertToDto)
                                              .collect(Collectors.toList());

        return new PageImpl<QuadroPacienteDTO>(pagedto, pageable, pagedto.size());
    }

    public QuadroPacienteEditarDTO findById(Long id) {
        return this.findQuadroPacienteById(id);
    }

    public Long save(QuadroPacienteEditarDTO dto) {
        validateFields(dto);

        if (Objects.isNull(dto.getDataHora())) {
            dto.setDataHora(LocalDateTime.now());
        }

        return repository.save(this.convertToEntity(dto)).getId();
    }

    public Long update(QuadroPacienteEditarDTO dto) {
        validateFields(dto);
        findQuadroPacienteById(dto.getId());
        return repository.save(this.convertToEntity(dto)).getId();
    }

    public Long delete(Long id) {
        findQuadroPacienteById(id);
        repository.deleteById(id);
        return id;
    }

    private QuadroPacienteEditarDTO findQuadroPacienteById(Long id) {
        return this.convertToEditarDto(repository.findById(id)
                                                 .orElseThrow(() -> new NotFoundException("Quadro paciente não encontrado!")));
    }

    private void validateFields(QuadroPacienteEditarDTO dto) {
        if (StringUtils.isBlank(dto.getDescricao())) {
            throw new InvalidFieldException("O campo descrição deve ser preenchido");
        }
    }

    private QuadroPacienteDTO convertToDto(final QuadroPaciente entity) {
        return this.getModelMapper().map(entity, QuadroPacienteDTO.class);
     }

    private QuadroPacienteEditarDTO convertToEditarDto(final QuadroPaciente entity) {
        return this.getModelMapper().map(entity, QuadroPacienteEditarDTO.class);
     }

    private QuadroPaciente convertToEntity(final QuadroPacienteDTO dto) {
      return this.getModelMapper().map(dto, QuadroPaciente.class);
    }
}
