package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Aeroport;
import com.example.projetresevationvols.entities.Compagnie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompagnieRepository extends JpaRepository<Compagnie,Long> {
}
