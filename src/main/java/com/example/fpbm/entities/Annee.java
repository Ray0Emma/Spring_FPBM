package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "annee")
@NoArgsConstructor
@AllArgsConstructor
public class Annee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "annee")
    private String annee;
    @OneToMany( targetEntity=ProfesseurHasModule.class, mappedBy="professeurHasModuleCollectionAnnee" )
    private Collection<ProfesseurHasModule> professeurHasModuleCollectionAnnee;
}
