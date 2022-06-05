package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "filiere")
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {
    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    // May be this <name = "iddepartement"> will make a problem
    @ManyToOne(targetEntity=Departement.class)
    private Departement departement_iddepartement;

    @ManyToOne( targetEntity=Type.class)
    private Type filiereCollectionType;

    @ManyToOne(targetEntity=Professeur.class)
    private Professeur filiereCollectionProfesseur;


    @OneToMany( targetEntity=Semester.class, mappedBy="filiereCollectionSemester" )
    private Collection<Semester> filiereCollectionSemester;


    @OneToMany( targetEntity=Etudiant.class, mappedBy="etudiantCollectionFiliere" )
    private Collection<Etudiant> etudiantCollectionFiliere;


}
