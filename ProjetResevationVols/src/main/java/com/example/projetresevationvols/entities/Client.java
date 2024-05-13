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
public class Client extends Personne {


    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
}
