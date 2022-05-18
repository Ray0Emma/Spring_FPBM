package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "annee")
public class Annee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idannee;
    @Column(name = "annee")
    private String annee;
    @OneToMany( targetEntity=ProfesseurHasModule.class, mappedBy="professeurHasModuleCollectionAnnee" )
    private Collection<ProfesseurHasModule> professeurHasModuleCollectionAnnee;
}