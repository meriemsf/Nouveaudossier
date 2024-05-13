package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Aeroport;
import com.example.projetresevationvols.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
