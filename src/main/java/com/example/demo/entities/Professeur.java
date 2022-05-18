package com.example.demo.entities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "professeur")
@NoArgsConstructor
@AllArgsConstructor
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idprofesseur;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "grade")
    private String grade;
    @Column(name = "cin")
    private String cin;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(targetEntity=Filiere.class, mappedBy="responsable_idprofesseur")
    private Collection<Filiere> filiereCollection;
}