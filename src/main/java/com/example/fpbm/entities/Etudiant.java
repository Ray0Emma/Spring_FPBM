package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "etudiant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Personne{
    @Column(name = "nbApogee")
    private String nbApogee;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere etudiantCollectionFiliere;
    @OneToMany(targetEntity= ModuleGroup.class, mappedBy="professeurHasModuleHasEtudiantCollectionEtudiant")
    private Collection<ModuleGroup> professeurHasModuleHasEtudiantCollectionEtudiant;
}
