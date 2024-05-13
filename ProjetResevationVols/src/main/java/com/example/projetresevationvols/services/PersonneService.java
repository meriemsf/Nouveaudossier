package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Personne;
import com.example.projetresevationvols.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    private final PersonneRepository personneRepository;

    @Autowired
    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public Personne getPersonneById(Long id) {
        return personneRepository.findById(id).orElse(null);
    }

    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    public Personne savePersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    public Personne updatePersonne(Long id, Personne updatedPersonne) {
        Personne existingPersonne = personneRepository.findById(id).orElse(null);
        if (existingPersonne != null) {
            // Update common fields
            existingPersonne.setNomPrenom(updatedPersonne.getNomPrenom());
            existingPersonne.setCin(updatedPersonne.getCin());
            existingPersonne.setEmail(updatedPersonne.getEmail());
            // Update other fields as needed
            return personneRepository.save(existingPersonne);
        }
        return null;
    }

    public void deletePersonne(Long id) {
        personneRepository.deleteById(id);
    }
}
