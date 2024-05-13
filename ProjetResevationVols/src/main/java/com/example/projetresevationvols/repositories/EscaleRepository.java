package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Aeroport;
import com.example.projetresevationvols.entities.Escale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscaleRepository extends JpaRepository<Escale,Long> {
}
