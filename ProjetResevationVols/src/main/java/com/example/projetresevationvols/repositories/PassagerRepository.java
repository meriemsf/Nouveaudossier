package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Aeroport;
import com.example.projetresevationvols.entities.Passager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagerRepository extends JpaRepository<Passager,Long> {
}
