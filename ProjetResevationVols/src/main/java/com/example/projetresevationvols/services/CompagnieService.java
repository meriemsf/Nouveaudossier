package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Compagnie;
import com.example.projetresevationvols.repositories.CompagnieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompagnieService {

    private final CompagnieRepository compagnieRepository;

    @Autowired
    public CompagnieService(CompagnieRepository compagnieRepository) {
        this.compagnieRepository = compagnieRepository;
    }

    public Compagnie getCompagnieById(Long id) {
        return compagnieRepository.findById(id).orElse(null);
    }

    public List<Compagnie> getAllCompagnies() {
        return compagnieRepository.findAll();
    }

    public Compagnie saveCompagnie(Compagnie compagnie) {
        return compagnieRepository.save(compagnie);
    }

    public Compagnie updateCompagnie(Long id, Compagnie updatedCompagnie) {
        Compagnie existingCompagnie = compagnieRepository.findById(id).orElse(null);
        if (existingCompagnie != null) {
            // Update fields if needed
            // For example:
            existingCompagnie.setNom(updatedCompagnie.getNom());
            // Update other fields as needed
            return compagnieRepository.save(existingCompagnie);
        }
        return null;
    }

    public void deleteCompagnie(Long id) {
        compagnieRepository.deleteById(id);
    }
}
