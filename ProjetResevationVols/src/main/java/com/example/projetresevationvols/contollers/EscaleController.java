package com.example.projetresevationvols.contollers;

import com.example.projetresevationvols.entities.Escale;
import com.example.projetresevationvols.services.EscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escales")
public class EscaleController {

    private final EscaleService escaleService;

    @Autowired
    public EscaleController(EscaleService escaleService) {
        this.escaleService = escaleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escale> getEscaleById(@PathVariable Long id) {
        Escale escale = escaleService.getEscaleById(id);
        if (escale != null) {
            return new ResponseEntity<>(escale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Escale>> getAllEscales() {
        List<Escale> escales = escaleService.getAllEscales();
        return new ResponseEntity<>(escales, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Escale> saveEscale(@RequestBody Escale escale) {
        Escale savedEscale = escaleService.saveEscale(escale);
        return new ResponseEntity<>(savedEscale, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escale> updateEscale(@PathVariable Long id, @RequestBody Escale updatedEscale) {
        Escale updated = escaleService.updateEscale(id, updatedEscale);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEscale(@PathVariable Long id) {
        escaleService.deleteEscale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
