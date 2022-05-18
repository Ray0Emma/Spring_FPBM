package com.example.fpbm.entities;

import javax.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsalle;
    @Column(name = "name")
    private String name;
    @Column(name = "capaciteEtudiant")
    private long capaciteEtudiant;
    @Column(name = "NombreSurveillant")
    private long NombreSurveillant;
}