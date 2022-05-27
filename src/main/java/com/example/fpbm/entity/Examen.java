package com.example.fpbm.entity;


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
    private long idexamen;
    @Column(name = "jour")
    private String jour;
    @Column(name = "heure")
    private String heure;
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private ProfesseurHasModule examenCollectionProfesseurHasModule;
    @OneToMany(targetEntity=ExamenHasProfesseurHasModuleHasEtudiant.class, mappedBy="examenHasProfesseur")
    private Collection<ExamenHasProfesseurHasModuleHasEtudiant> examenHasProfesseur;
    @ManyToOne(targetEntity=Salle.class)
    private Salle examenCollectionSalle;
    @OneToMany(targetEntity=Surveillant.class, mappedBy="surveillantCollectionExamen")
    private Collection<Surveillant> surveillantCollectionExamen;
}
