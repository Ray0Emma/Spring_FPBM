package com.example.fpbm.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "salle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "capaciteEtudiant")
    private long capaciteEtudiant;
    @Column(name = "NombreSurveillant")
    private long NombreSurveillant;
    @OneToMany( targetEntity=Soutenance.class, mappedBy="soutenance_idsoutenance" )
    private Collection<Soutenance> soutenance_idsoutenance;
    @OneToMany( targetEntity=Examen.class, mappedBy="examen_module" )
    private Collection<Examen> examen_module;
}