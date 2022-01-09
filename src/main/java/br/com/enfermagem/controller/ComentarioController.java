package br.com.enfermagem.controller;

import br.com.enfermagem.dto.ComentarioDTO;
import br.com.enfermagem.dto.ComentarioDetalheDTO;
import br.com.enfermagem.service.ComentarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public ResponseEntity<Page<ComentarioDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(this.comentarioService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.comentarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody @Valid ComentarioDetalheDTO dto) {
        return new ResponseEntity<>(this.comentarioService.save(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody @Valid ComentarioDetalheDTO dto) {
        return new ResponseEntity<>(this.comentarioService.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        this.comentarioService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
