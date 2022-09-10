package com.example.fpbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "professeur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur extends Personne{

    @Column(name = "grade")
    private String grade;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=Filiere.class, mappedBy="professeur")
    private Collection<Filiere> filieres;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=Jury.class, mappedBy="professeur")
    private Collection<Jury> juries;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity = LieuDeTravail.class)
    private LieuDeTravail lieuDeTravail;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="professeur")
    private Collection<ProfesseurHasModule> professeurHasModules;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity = Extern.class)
    private Extern extern;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = Surveillant.class, mappedBy = "professeur")
    private Collection<Surveillant> surveillants;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = Soutenance.class, mappedBy = "professeur")
    private Collection<Soutenance> soutenances;

    public Professeur(long id, String email, List<Role> roles, String username, String password, String cin, String cne, String nom, String prenom, Date dateDeNaissance, String address, String telephone, String grade, Collection<Filiere> filieres, Collection<Jury> juries, LieuDeTravail lieuDeTravail, Collection<ProfesseurHasModule> professeurHasModules, Extern extern, Collection<Surveillant> surveillants, Collection<Soutenance> soutenances) {
        super(id, email,roles,username, password, cin, cne, nom, prenom, dateDeNaissance, address, telephone);
        this.grade = grade;
        this.filieres = filieres;
        this.juries = juries;
        this.lieuDeTravail = lieuDeTravail;
        this.professeurHasModules = professeurHasModules;
        this.extern = extern;
        this.surveillants = surveillants;
        this.soutenances = soutenances;
    }
}
