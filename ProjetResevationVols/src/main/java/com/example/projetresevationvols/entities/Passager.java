package com.example.projetresevationvols.entities;

import com.example.projetresevationvols.entities.Personne;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passager extends Personne {


    private String numpasseport;

    @OneToMany(mappedBy = "passager")
    private List<Reservation> reservations;
}
