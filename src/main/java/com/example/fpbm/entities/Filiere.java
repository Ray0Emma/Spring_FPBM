package com.example.fpbm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "filiere")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {
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


    @JsonIgnore
    @OneToMany( targetEntity=Semester.class, mappedBy="filiereCollectionSemester" )
    private Collection<Semester> filiereCollectionSemester;
    @JsonIgnore
    @OneToMany( targetEntity=Etudiant.class, mappedBy="etudiantCollectionFiliere" )
    private Collection<Etudiant> etudiantCollectionFiliere;


}
