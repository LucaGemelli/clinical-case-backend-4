package br.com.enfermagem.controller;

import br.com.enfermagem.dto.Fluxo24hsDTO;
import br.com.enfermagem.dto.Fluxo24hsDetalheDTO;
import br.com.enfermagem.service.Fluxo24hsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fluxo24hs")
public class Fluxo24hsController {

    private final Fluxo24hsService fluxo24hsService;

    public Fluxo24hsController(Fluxo24hsService fluxo24hsService) {
        this.fluxo24hsService = fluxo24hsService;
    }

    @GetMapping
    public ResponseEntity<Page<Fluxo24hsDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(this.fluxo24hsService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fluxo24hsDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.fluxo24hsService.findFluxoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody @Valid Fluxo24hsDetalheDTO dto) {
        return new ResponseEntity<>(this.fluxo24hsService.save(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody @Valid Fluxo24hsDetalheDTO dto) {
        return new ResponseEntity<>(this.fluxo24hsService.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        this.fluxo24hsService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
