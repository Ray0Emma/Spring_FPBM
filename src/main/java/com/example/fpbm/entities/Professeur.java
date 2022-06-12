package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "professeur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur extends Personne{

    @Column(name = "grade")
    private String grade;

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
