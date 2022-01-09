package br.com.enfermagem.controller;

import java.util.List;

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

import br.com.enfermagem.dto.PacienteDTO;
import br.com.enfermagem.dto.PacienteEditarDTO;
import br.com.enfermagem.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> findAll(final Pageable pageable) {
        return new ResponseEntity<>(pacienteService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteEditarDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@Valid @RequestBody PacienteEditarDTO dto) {
        return new ResponseEntity<>(pacienteService.save(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@Valid @RequestBody PacienteEditarDTO dto) {
        return new ResponseEntity<>(pacienteService.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<List<PacienteDTO>> findPacientesByIdUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.findPacientesByIdUsuario(id), HttpStatus.OK);
    }
}
