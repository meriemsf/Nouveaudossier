package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Escale;
import com.example.projetresevationvols.repositories.EscaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscaleService {

    private final EscaleRepository escaleRepository;

    @Autowired
    public EscaleService(EscaleRepository escaleRepository) {
        this.escaleRepository = escaleRepository;
    }

    public Escale getEscaleById(Long id) {
        return escaleRepository.findById(id).orElse(null);
    }

    public List<Escale> getAllEscales() {
        return escaleRepository.findAll();
    }

    public Escale saveEscale(Escale escale) {
        return escaleRepository.save(escale);
    }

    public Escale updateEscale(Long id, Escale updatedEscale) {
        Escale existingEscale = escaleRepository.findById(id).orElse(null);
        if (existingEscale != null) {
            // Update fields if needed
            // For example:
            existingEscale.setDate(updatedEscale.getDate());
            existingEscale.setHeureDepart(updatedEscale.getHeureDepart());
            existingEscale.setDateArrivee(updatedEscale.getDateArrivee());
            // Update other fields as needed
            return escaleRepository.save(existingEscale);
        }
        return null;
    }

    public void deleteEscale(Long id) {
        escaleRepository.deleteById(id);
    }
}
