package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Reservation;
import com.example.projetresevationvols.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            // Update fields if needed
            // For example:
            existingReservation.setDate(updatedReservation.getDate());
            existingReservation.setPersonne(updatedReservation.getPersonne());
            existingReservation.setClient(updatedReservation.getClient());
            existingReservation.setPassager(updatedReservation.getPassager());
            // Update other fields as needed
            return reservationRepository.save(existingReservation);
        }
        return null;
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
