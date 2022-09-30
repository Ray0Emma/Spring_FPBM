package com.example.fpbm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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

    @Column(name = "name", unique = true)
    private String name;

    // May be this <name = "iddepartement"> will make a problem

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Departement.class)
    private Departement departement;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne( targetEntity=Type.class)
    private Type type;


    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur professeur;


    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany( targetEntity=Semester.class, mappedBy="filiere" )
    private Collection<Semester> semesters;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany( targetEntity=Etudiant.class, mappedBy="filiere" )
    private Collection<Etudiant> etudiants;


}

