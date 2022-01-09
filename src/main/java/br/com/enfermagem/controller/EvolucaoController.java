package br.com.enfermagem.controller;

import br.com.enfermagem.dto.EvolucaoDTO;
import br.com.enfermagem.dto.EvolucaoDetalheDTO;
import br.com.enfermagem.service.EvolucaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/evolucoes")
public class EvolucaoController {

    private final EvolucaoService service;

    public EvolucaoController(EvolucaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<EvolucaoDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(this.service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvolucaoDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.findEvolucaoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody @Valid EvolucaoDetalheDTO dto) {
        return new ResponseEntity<>(this.service.save(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody @Valid EvolucaoDetalheDTO dto) {
        return new ResponseEntity<>(this.service.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        this.service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
