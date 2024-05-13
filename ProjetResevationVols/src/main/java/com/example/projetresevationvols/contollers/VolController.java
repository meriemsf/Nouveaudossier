package com.example.projetresevationvols.contollers;

import com.example.projetresevationvols.entities.Vol;
import com.example.projetresevationvols.services.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vols")
public class VolController {

    private final VolService volService;

    @Autowired
    public VolController(VolService volService) {
        this.volService = volService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vol> getVolById(@PathVariable Long id) {
        Vol vol = volService.getVolById(id);
        if (vol != null) {
            return new ResponseEntity<>(vol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Vol>> getAllVols() {
        List<Vol> vols = volService.getAllVols();
        return new ResponseEntity<>(vols, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vol> saveVol(@RequestBody Vol vol) {
        Vol savedVol = volService.saveVol(vol);
        return new ResponseEntity<>(savedVol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vol> updateVol(@PathVariable Long id, @RequestBody Vol updatedVol) {
        Vol updated = volService.updateVol(id, updatedVol);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVol(@PathVariable Long id) {
        volService.deleteVol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
