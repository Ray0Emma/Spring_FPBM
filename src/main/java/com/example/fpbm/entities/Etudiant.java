package com.example.fpbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "etudiant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Personne{
    @Column(name = "nbApogee")
    private String nbApogee;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere filiere;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity= ModuleGroup.class, mappedBy="etudiant")
    private Collection<ModuleGroup> moduleGroups;

    public Etudiant(long id, String email, String password, String cin, String cne, String nom, String prenom, Date dateDeNaissance, String address, String telephone, String nbApogee, Filiere filiere, Collection<ModuleGroup> moduleGroups) {
        super(id, email, password, cin, cne, nom, prenom, dateDeNaissance, address, telephone);
        this.nbApogee = nbApogee;
        this.filiere = filiere;
        this.moduleGroups = moduleGroups;
    }
}
