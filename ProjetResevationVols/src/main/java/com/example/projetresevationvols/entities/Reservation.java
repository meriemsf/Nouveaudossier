package com.example.projetresevationvols.entities;

import com.example.projetresevationvols.entities.Client;
import com.example.projetresevationvols.entities.Passager;
import com.example.projetresevationvols.entities.Personne;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @ManyToOne
    private Personne personne;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Passager passager;
}
