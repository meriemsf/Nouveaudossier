package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Aeroport;
import com.example.projetresevationvols.repositories.AeroportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeroportService {

    private final AeroportRepository aeroportRepository;

    @Autowired
    public AeroportService(AeroportRepository aeroportRepository) {
        this.aeroportRepository = aeroportRepository;
    }

    public Aeroport getAeroportById(Long id) {
        return aeroportRepository.findById(id).orElse(null);
    }

    public List<Aeroport> getAllAeroports() {
        return aeroportRepository.findAll();
    }

    public Aeroport saveAeroport(Aeroport aeroport) {
        return aeroportRepository.save(aeroport);
    }

    public Aeroport updateAeroport(Long id, Aeroport updatedAeroport) {
        Aeroport existingAeroport = aeroportRepository.findById(id).orElse(null);
        if (existingAeroport != null) {
            existingAeroport.setNom(updatedAeroport.getNom());
            // Update other fields as needed
            return aeroportRepository.save(existingAeroport);
        }
        return null;
    }

    public void deleteAeroport(Long id) {
        aeroportRepository.deleteById(id);
    }
}
