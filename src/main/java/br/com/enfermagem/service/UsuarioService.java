package br.com.enfermagem.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.enfermagem.dto.UsuarioDTO;
import br.com.enfermagem.dto.UsuarioEditarDTO;
import br.com.enfermagem.exception.MessageListException;
import br.com.enfermagem.exception.NotFoundException;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.repository.UsuarioRepository;

@Service
public class UsuarioService implements DefaultService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<UsuarioDTO> findAll(final Pageable pageable) {
       Page<Usuario> page = usuarioRepository.findAll(pageable);
       List<UsuarioDTO> pagedto = page.stream()
                                      .map(this::convertToDto)
                                      .collect(Collectors.toList());

       return new PageImpl<UsuarioDTO>(pagedto, pageable, pagedto.size());
    }

    public UsuarioEditarDTO findById(Long id) {
        return this.convertToEditarDto(findUsuarioById(id));
    }

    public Long save(final UsuarioEditarDTO dto) {
        this.validateFields(dto);

        if (Objects.isNull(dto.getDataHora())) {
            dto.setDataHora(LocalDateTime.now());
        }

        return usuarioRepository.save(this.convertToEntity(dto)).getId();
    }

    public Long update(UsuarioEditarDTO dto) {
        findUsuarioById(dto.getId());
        this.validateFields(dto);
        return usuarioRepository.save(this.convertToEntity(dto)).getId();
    }

    public void delete(Long id) {
        findUsuarioById(id);
        usuarioRepository.deleteById(id);
    }

    private Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
    }

    private void validateFields(final UsuarioEditarDTO dto) {
        List<String> exceptions = new ArrayList<>();

        if (StringUtils.isBlank(dto.getLogin())) {
            exceptions.add("O campo login deve ser preenchido");
        }

        if (StringUtils.isBlank(dto.getSenha())) {
            exceptions.add("O campo senha deve ser preenchido");
        }

        if (StringUtils.isBlank(dto.getNome())) {
            exceptions.add("O campo nome deve ser preenchido");
        }

        if (StringUtils.isBlank(dto.getEmail())) {
            exceptions.add("O campo e-mail deve ser preenchido");
        }

        if (!exceptions.isEmpty()) {
            throw new MessageListException(exceptions);
        }
    }

    private UsuarioDTO convertToDto(final Usuario entity) {
        return this.getModelMapper().map(entity, UsuarioDTO.class);
     }

    private UsuarioEditarDTO convertToEditarDto(final Usuario entity) {
        return this.getModelMapper().map(entity, UsuarioEditarDTO.class);
     }

    private Usuario convertToEntity(final UsuarioDTO dto) {
      return this.getModelMapper().map(dto, Usuario.class);
    }
}
