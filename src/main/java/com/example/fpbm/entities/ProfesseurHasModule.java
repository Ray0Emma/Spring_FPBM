package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "professeur_has_module")
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurHasModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long professeur_has_modulecol;
    @ManyToOne(targetEntity=Annee.class)
    private Annee professeurHasModuleCollectionAnnee;
    @ManyToOne(targetEntity=Courstdtp.class)
    private Courstdtp professeurHasModuleCollectionCoursTDTP;
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur professeurHasModuleCollectionProfesseur;
    @ManyToOne(targetEntity= Module.class)
    private Module professeurHasModuleCollectionModule;
    @OneToMany(targetEntity=Examen.class, mappedBy="examenCollectionProfesseurHasModule")
    private Collection<Examen> examenCollectionProfesseurHasModule;
    @OneToMany(targetEntity=ProfesseurHasModuleHasEtudiant.class, mappedBy="professeurHasModule")
    private Collection<ProfesseurHasModuleHasEtudiant> professeurHasModule;
}
