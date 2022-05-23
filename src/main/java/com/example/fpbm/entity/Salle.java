package com.example.fpbm.entity;


import javax.persistence.*;
import java.util.Collection;

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
    @OneToMany(targetEntity=Examen.class, mappedBy="examenCollectionSalle")
    private Collection<Examen> examenCollectionSalle;
}
