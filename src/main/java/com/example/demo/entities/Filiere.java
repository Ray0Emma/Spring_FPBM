package com.example.demo.entities;


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
    private long idfiliere;

    @Column(name = "name")
    private String name;

    // May be this <name = "iddepartement"> will make a problem
    @ManyToOne(targetEntity=Departement.class)
    private Departement departement_iddepartement;

    @ManyToOne( targetEntity=Type.class)
    private Type type_idtype1;

    @ManyToOne(targetEntity=Professeur.class)
    private Professeur responsable_idprofesseur;

    @ManyToOne(targetEntity=Semester.class)
    private Semester filiere_idfiliere;

    @OneToMany( targetEntity=Etudiant.class, mappedBy="etudiantList" )
    private Collection<Etudiant> etudiantList;


}