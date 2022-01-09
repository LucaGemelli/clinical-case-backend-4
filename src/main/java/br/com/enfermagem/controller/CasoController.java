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

import br.com.enfermagem.dto.CasoDTO;
import br.com.enfermagem.dto.CasoEditarDTO;
import br.com.enfermagem.service.CasoService;

@RestController
@RequestMapping("/casos")
public class CasoController {

    private final CasoService service;

    public CasoController(CasoService casoService) {
        this.service = casoService;
    }

    @GetMapping
    public ResponseEntity<Page<CasoDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(this.service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoDTO> findById(@PathVariable Long id) {
    	return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@Valid @RequestBody CasoEditarDTO dto) {
        return new ResponseEntity<>(this.service.save(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@Valid @RequestBody CasoEditarDTO dto){
        return new ResponseEntity<>(this.service.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        this.service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
