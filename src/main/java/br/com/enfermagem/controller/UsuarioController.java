package br.com.enfermagem.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enfermagem.dto.UsuarioDTO;
import br.com.enfermagem.dto.UsuarioEditarDTO;
import br.com.enfermagem.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService usuarioService) {
        this.service = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> findAll(final Pageable pageable) {
    	return new ResponseEntity<>(this.service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEditarDTO> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@Valid @RequestBody final UsuarioEditarDTO usuario) {
        return new ResponseEntity<>(this.service.save(usuario), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@Valid @RequestBody final UsuarioEditarDTO usuario) {
        return new ResponseEntity<>(this.service.update(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable final Long id) {
        this.service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
