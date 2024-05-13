package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Aeroport;
import com.example.projetresevationvols.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
