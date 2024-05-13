package com.example.projetresevationvols.entities;

import com.example.projetresevationvols.entities.Vol;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aeroport {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "depart")
    private List<Vol> departList = new ArrayList<>();

    @OneToMany(mappedBy = "arrive")
    private List<Vol> arriveList = new ArrayList<>();
}
