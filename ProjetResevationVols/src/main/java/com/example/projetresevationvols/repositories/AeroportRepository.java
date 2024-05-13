package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Aeroport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroportRepository extends JpaRepository<Aeroport,Long> {
}
