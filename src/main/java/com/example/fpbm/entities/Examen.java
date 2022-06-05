package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "examen")
@NoArgsConstructor
@AllArgsConstructor
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "jour")
    private String jour;
    @Column(name = "heure")
    private String heure;
    @ManyToOne(targetEntity=Salle.class)
    private Salle examen_module;
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private Salle examen_prof;
    @OneToMany(targetEntity=ExamenHasProfesseurHasModuleHasEtudiant.class, mappedBy="examenHasProfesseur")
    private Collection<ExamenHasProfesseurHasModuleHasEtudiant> examenHasProfesseur;
    @OneToMany(targetEntity=Surveillant.class, mappedBy="surveillantCollectionExamen")
    private Collection<Surveillant> surveillantCollectionExamen;
}