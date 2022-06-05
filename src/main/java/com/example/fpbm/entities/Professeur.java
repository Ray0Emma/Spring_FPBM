package com.example.fpbm.entities;

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
    private long id;
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

    @OneToMany(targetEntity=Filiere.class, mappedBy="filiereCollectionProfesseur")
    private Collection<Filiere> filiereCollectionProfesseur;
    @OneToMany(targetEntity=Jury.class, mappedBy="membrejury_idprofesseur")
    private Collection<Jury> membrejury_idprofesseur;
    @ManyToOne(targetEntity = LieuDeTravail.class)
    private LieuDeTravail professeurCollectionLieu;
    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="prof_module")
    private Collection<ProfesseurHasModule> prof_module;
    @ManyToOne(targetEntity = Extern.class)
    private Extern professeurCollectionExtern;
    @OneToMany(targetEntity = Surveillant.class, mappedBy = "surveillantCollectionProfesseur")
    private Collection<Surveillant> surveillantCollectionProfesseur;
    @OneToMany(targetEntity = Soutenance.class, mappedBy = "soutenanceCollectionProfesseur")
    private Collection<Soutenance> soutenanceCollectionProfesseur;

}