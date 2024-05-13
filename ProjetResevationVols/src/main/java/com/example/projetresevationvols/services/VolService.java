package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Vol;
import com.example.projetresevationvols.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolService {

    private final VolRepository volRepository;

    @Autowired
    public VolService(VolRepository volRepository) {
        this.volRepository = volRepository;
    }

    public Vol getVolById(Long id) {
        return volRepository.findById(id).orElse(null);
    }

    public List<Vol> getAllVols() {
        return volRepository.findAll();
    }

    public Vol saveVol(Vol vol) {
        return volRepository.save(vol);
    }

    public Vol updateVol(Long id, Vol updatedVol) {
        Vol existingVol = volRepository.findById(id).orElse(null);
        if (existingVol != null) {
            // Update fields if needed
            // For example:
            existingVol.setDateDepart(updatedVol.getDateDepart());
            existingVol.setDateArrive(updatedVol.getDateArrive());
            existingVol.setHeureDepart(updatedVol.getHeureDepart());
            existingVol.setHeureArrive(updatedVol.getHeureArrive());
            existingVol.setDepart(updatedVol.getDepart());
            existingVol.setArrive(updatedVol.getArrive());
            existingVol.setCompagnie(updatedVol.getCompagnie());
            // Update other fields as needed
            return volRepository.save(existingVol);
        }
        return null;
    }

    public void deleteVol(Long id) {
        volRepository.deleteById(id);
    }
}
