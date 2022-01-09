package br.com.enfermagem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.dto.PacienteDTO;
import br.com.enfermagem.dto.PacienteEditarDTO;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.repository.PacienteRepository;

@Service
public class PacienteService implements DefaultService {

    private final PacienteRepository repository;

    public PacienteService(final PacienteRepository repository) {
        this.repository = repository;
    }

    public Page<PacienteDTO> findAll(final Pageable pageable) {
         final Page<Paciente> page = repository.findAll(pageable);
         final List<PacienteDTO> pageDto = page.stream()
                                               .map(this::convertToDto)
                                               .collect(Collectors.toList());
         return new PageImpl<PacienteDTO>(pageDto, pageable, pageDto.size());
    }

    public PacienteEditarDTO findById(final Long id) {
        return this.findPacienteById(id);
    }

    public Long save(final PacienteEditarDTO dto) {
        if (Objects.isNull(dto.getDataHora())) {
            dto.setDataHora(LocalDateTime.now());
        }
        return repository.save(this.convertToEntity(dto)).getId();
    }

    public Long update(final PacienteEditarDTO dto) {
        this.findPacienteById(dto.getId());
        return repository.save(this.convertToEntity(dto)).getId();
    }

    public Long delete(Long id) {
        this.findPacienteById(id);
        this.repository.deleteById(id);
        return id;
    }

    private PacienteEditarDTO findPacienteById(final Long id) {
        return this.convertToEditarDto(repository.findById(id)
                                                 .orElseThrow(() -> new NotFoundException("Paciente não encontrado!")));
    }

    public List<PacienteDTO> findPacientesByIdUsuario(final Long idUsuario) {
        final Spliterator<Paciente> spliterator = repository.findAll().spliterator();
        final List<PacienteDTO> pacienteList = StreamSupport.stream(spliterator, false)
                                                            .filter(paciente -> Objects.equals(paciente.getUsuario().getId(), idUsuario))
                                                            .map(this::convertToDto)
                                                            .collect(Collectors.toList());

        if (pacienteList.isEmpty()) {
            throw new NotFoundException("Não foi encontrado nenhum paciente com o ID de usuário informado!");
        }

        return pacienteList;
    }

    public List<PacienteDTO> findPacientesByIdCaso(final Long idCaso) {
        //TODO Substituir por filtroDTO o processo está extramamente oneroso.
        final Spliterator<Paciente> spliterator = repository.findAll().spliterator();
        return StreamSupport.stream(spliterator, false)
                            .filter(paciente -> Objects.equals(paciente.getCaso().getId(), idCaso))
                            .map(this::convertToDto)
                            .collect(Collectors.toList());
    }

    private PacienteDTO convertToDto(final Paciente entity) {
        return this.getModelMapper().map(entity, PacienteDTO.class);
     }

    private PacienteEditarDTO convertToEditarDto(final Paciente entity) {
        return this.getModelMapper().map(entity, PacienteEditarDTO.class);
     }

    private Paciente convertToEntity(final PacienteDTO dto) {
      return this.getModelMapper().map(dto, Paciente.class);
    }
}
