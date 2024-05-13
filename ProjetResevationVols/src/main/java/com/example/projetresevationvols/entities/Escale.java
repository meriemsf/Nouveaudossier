package com.example.projetresevationvols.entities;

import com.example.projetresevationvols.entities.Vol;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Escale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String heureDepart;

    private Date dateArrivee;

    @ManyToOne
    private Vol vol;
}
