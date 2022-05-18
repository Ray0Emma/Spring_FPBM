package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "etudiant")
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idetudiant;
    @Column(name = "cne")
    private String cne;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "date_naissance")
    private String date_naissance;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere etudiantList;
}