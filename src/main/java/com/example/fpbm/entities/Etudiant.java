package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "etudiant")
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Personne{
    @Column(name = "nbApogee")
    private String nbApogee;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere etudiantCollectionFiliere;
    @OneToMany(targetEntity=ProfesseurHasModuleHasEtudiant.class, mappedBy="professeurHasModuleHasEtudiantCollectionEtudiant")
    private Collection<ProfesseurHasModuleHasEtudiant> professeurHasModuleHasEtudiantCollectionEtudiant;
}
