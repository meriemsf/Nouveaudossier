package com.example.projetresevationvols.contollers;

import com.example.projetresevationvols.entities.Passager;
import com.example.projetresevationvols.services.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagers")
public class PassagerController {

    private final PassagerService passagerService;

    @Autowired
    public PassagerController(PassagerService passagerService) {
        this.passagerService = passagerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passager> getPassagerById(@PathVariable Long id) {
        Passager passager = passagerService.getPassagerById(id);
        if (passager != null) {
            return new ResponseEntity<>(passager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Passager>> getAllPassagers() {
        List<Passager> passagers = passagerService.getAllPassagers();
        return new ResponseEntity<>(passagers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passager> savePassager(@RequestBody Passager passager) {
        Passager savedPassager = passagerService.savePassager(passager);
        return new ResponseEntity<>(savedPassager, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passager> updatePassager(@PathVariable Long id, @RequestBody Passager updatedPassager) {
        Passager updated = passagerService.updatePassager(id, updatedPassager);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassager(@PathVariable Long id) {
        passagerService.deletePassager(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
