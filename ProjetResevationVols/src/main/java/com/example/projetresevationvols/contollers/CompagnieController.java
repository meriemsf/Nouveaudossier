package com.example.projetresevationvols.contollers;

import com.example.projetresevationvols.entities.Compagnie;
import com.example.projetresevationvols.services.CompagnieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compagnies")
public class CompagnieController {

    private final CompagnieService compagnieService;

    @Autowired
    public CompagnieController(CompagnieService compagnieService) {
        this.compagnieService = compagnieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compagnie> getCompagnieById(@PathVariable Long id) {
        Compagnie compagnie = compagnieService.getCompagnieById(id);
        if (compagnie != null) {
            return new ResponseEntity<>(compagnie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Compagnie>> getAllCompagnies() {
        List<Compagnie> compagnies = compagnieService.getAllCompagnies();
        return new ResponseEntity<>(compagnies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Compagnie> saveCompagnie(@RequestBody Compagnie compagnie) {
        Compagnie savedCompagnie = compagnieService.saveCompagnie(compagnie);
        return new ResponseEntity<>(savedCompagnie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compagnie> updateCompagnie(@PathVariable Long id, @RequestBody Compagnie updatedCompagnie) {
        Compagnie updated = compagnieService.updateCompagnie(id, updatedCompagnie);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompagnie(@PathVariable Long id) {
        compagnieService.deleteCompagnie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
