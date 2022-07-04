package com.example.fpbm.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "salle")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany( targetEntity=Soutenance.class, mappedBy="salle" )
    private Collection<Soutenance> soutenances;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany( targetEntity=Examen.class, mappedBy="salle" )
    private Collection<Examen> examens;
}

