package com.example.projetresevationvols.contollers;

import com.example.projetresevationvols.entities.Personne;
import com.example.projetresevationvols.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable Long id) {
        Personne personne = personneService.getPersonneById(id);
        if (personne != null) {
            return new ResponseEntity<>(personne, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Personne>> getAllPersonnes() {
        List<Personne> personnes = personneService.getAllPersonnes();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Personne> savePersonne(@RequestBody Personne personne) {
        Personne savedPersonne = personneService.savePersonne(personne);
        return new ResponseEntity<>(savedPersonne, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personne> updatePersonne(@PathVariable Long id, @RequestBody Personne updatedPersonne) {
        Personne updated = personneService.updatePersonne(id, updatedPersonne);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
