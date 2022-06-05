package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "etudiant")
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cne")
    private String cne;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "date_naissance")
    private String date_naissance;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere etudiantCollectionFiliere;
    @OneToMany(targetEntity=ProfesseurHasModuleHasEtudiant.class, mappedBy="professeurHasModuleHasEtudiantCollectionEtudiant")
    private Collection<ProfesseurHasModuleHasEtudiant> professeurHasModuleHasEtudiantCollectionEtudiant;
}
