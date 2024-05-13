package com.example.projetresevationvols.contollers;

import com.example.projetresevationvols.entities.Aeroport;
import com.example.projetresevationvols.services.AeroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeroports")
public class AeroportController {

    private final AeroportService aeroportService;

    @Autowired
    public AeroportController(AeroportService aeroportService) {
        this.aeroportService = aeroportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeroport> getAeroportById(@PathVariable Long id) {
        Aeroport aeroport = aeroportService.getAeroportById(id);
        return aeroport != null ?
                new ResponseEntity<>(aeroport, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Aeroport>> getAllAeroports() {
        List<Aeroport> aeroports = aeroportService.getAllAeroports();
        return new ResponseEntity<>(aeroports, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Aeroport> saveAeroport(@RequestBody Aeroport aeroport) {
        Aeroport savedAeroport = aeroportService.saveAeroport(aeroport);
        return new ResponseEntity<>(savedAeroport, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeroport> updateAeroport(@PathVariable Long id, @RequestBody Aeroport updatedAeroport) {
        Aeroport aeroport = aeroportService.updateAeroport(id, updatedAeroport);
        return aeroport != null ?
                new ResponseEntity<>(aeroport, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeroport(@PathVariable Long id) {
        aeroportService.deleteAeroport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
