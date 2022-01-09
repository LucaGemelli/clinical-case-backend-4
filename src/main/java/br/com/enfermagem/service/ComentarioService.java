package br.com.enfermagem.service;

import br.com.enfermagem.dto.ComentarioDTO;
import br.com.enfermagem.dto.ComentarioDetalheDTO;
import br.com.enfermagem.dto.ComentarioEditarDTO;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Comentario;
import br.com.enfermagem.repository.ComentarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService implements DefaultService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Page<ComentarioDTO> findAll(Pageable pageable) {
        Page<Comentario> page = this.comentarioRepository.findAll(pageable);
        List<ComentarioDTO> comentarioDTOList = page.stream().map(this::convertToDto).collect(Collectors.toList());

        return new PageImpl<>(comentarioDTOList, pageable, comentarioDTOList.size());
    }

    public ComentarioDTO findById(Long id) {
        return findComentarioById(id);
    }

    private ComentarioDTO findComentarioById(Long id) {
        return this.convertToEditarDto(this.comentarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comentário não encontrado!")));
    }

    public Long save(ComentarioDetalheDTO dto) {
        return this.comentarioRepository.save(this.convertToEntity(dto)).getId();
    }

    public Long update(ComentarioDetalheDTO dto) {
        this.findComentarioById(dto.getId());
        return this.comentarioRepository.save(this.convertToEntity(dto)).getId();
    }

    public void delete(Long id) {
        this.comentarioRepository.deleteById(id);
    }

    private ComentarioDTO convertToDto(final Comentario entity) {
        return this.getModelMapper().map(entity, ComentarioDTO.class);
    }

    private ComentarioEditarDTO convertToEditarDto(final Comentario entity) {
        return this.getModelMapper().map(entity, ComentarioEditarDTO.class);
    }

    private Comentario convertToEntity(final ComentarioDetalheDTO dto) {
        return this.getModelMapper().map(dto, Comentario.class);
    }
}
