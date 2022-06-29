package com.example.fpbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "professeur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur extends Personne{

    @Column(name = "grade")
    private String grade;

    @JsonIgnore
    @OneToMany(targetEntity=Filiere.class, mappedBy="filiereCollectionProfesseur")
    private Collection<Filiere> filiereCollectionProfesseur;
    @OneToMany(targetEntity=Jury.class, mappedBy="membrejury_idprofesseur")
    private Collection<Jury> membrejury_idprofesseur;
    @JsonIgnore
    @ManyToOne(targetEntity = LieuDeTravail.class)
    private LieuDeTravail professeurCollectionLieu;
    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="prof_module")
    private Collection<ProfesseurHasModule> prof_module;
    @JsonIgnore
    @ManyToOne(targetEntity = Extern.class)
    private Extern professeurCollectionExtern;
    @OneToMany(targetEntity = Surveillant.class, mappedBy = "surveillantCollectionProfesseur")
    private Collection<Surveillant> surveillantCollectionProfesseur;
    @OneToMany(targetEntity = Soutenance.class, mappedBy = "soutenanceCollectionProfesseur")
    private Collection<Soutenance> soutenanceCollectionProfesseur;

    public Professeur(long id, String email, String password, String cin, String cne, String nom, String prenom, Date dateDeNaissance, String address, String telephone, String grade, Collection<Filiere> filiereCollectionProfesseur, Collection<Jury> membrejury_idprofesseur, LieuDeTravail professeurCollectionLieu, Collection<ProfesseurHasModule> prof_module, Extern professeurCollectionExtern, Collection<Surveillant> surveillantCollectionProfesseur, Collection<Soutenance> soutenanceCollectionProfesseur) {
        super(id, email, password, cin, cne, nom, prenom, dateDeNaissance, address, telephone);
        this.grade = grade;
        this.filiereCollectionProfesseur = filiereCollectionProfesseur;
        this.membrejury_idprofesseur = membrejury_idprofesseur;
        this.professeurCollectionLieu = professeurCollectionLieu;
        this.prof_module = prof_module;
        this.professeurCollectionExtern = professeurCollectionExtern;
        this.surveillantCollectionProfesseur = surveillantCollectionProfesseur;
        this.soutenanceCollectionProfesseur = soutenanceCollectionProfesseur;
    }
}
