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

import br.com.enfermagem.dto.QuadroPacienteDTO;
import br.com.enfermagem.dto.QuadroPacienteEditarDTO;
import br.com.enfermagem.service.QuadroPacienteService;

@RestController
@RequestMapping("/quadroPaciente")
public class QuadroPacienteController {

    private final QuadroPacienteService service;

    public QuadroPacienteController(QuadroPacienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<QuadroPacienteDTO>> findAll(Pageable pageable){
        return new ResponseEntity<>(this.service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuadroPacienteEditarDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@Valid @RequestBody QuadroPacienteEditarDTO dto){
        return new ResponseEntity<>(this.service.save(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@Valid @RequestBody QuadroPacienteEditarDTO dto){
        return new ResponseEntity<>(this.service.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
       return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
    }

}
