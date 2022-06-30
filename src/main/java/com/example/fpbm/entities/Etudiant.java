package com.example.fpbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

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
    private Filiere filiere;

    @OneToMany(targetEntity= ModuleGroup.class, mappedBy="professeurHasModuleHasEtudiantCollectionEtudiant")
    private Collection<ModuleGroup> professeurHasModuleHasEtudiantCollectionEtudiant;

    public Etudiant(long id, String email, String password, String cin, String cne, String nom, String prenom, Date dateDeNaissance, String address, String telephone, String nbApogee, Filiere filiere, Collection<ModuleGroup> professeurHasModuleHasEtudiantCollectionEtudiant) {
        super(id, email, password, cin, cne, nom, prenom, dateDeNaissance, address, telephone);
        this.nbApogee = nbApogee;
        this.filiere = filiere;
        this.professeurHasModuleHasEtudiantCollectionEtudiant = professeurHasModuleHasEtudiantCollectionEtudiant;
    }
}
