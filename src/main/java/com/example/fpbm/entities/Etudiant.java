package com.example.fpbm.entities;

import com.example.fpbm.modeles.Pv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "etudiant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Personne{
    @Column(name = "nbApogee")
    private String nbApogee;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Filiere.class, fetch = FetchType.EAGER)
    private Filiere filiere;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity= ModuleGroup.class, mappedBy="etudiant")
    private Collection<ModuleGroup> moduleGroups;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    private List<Pv> pvs;

    public Etudiant(long id, String email, String password, String cin, String cne, String nom, String prenom, Date dateDeNaissance, String address, String telephone, String nbApogee, Filiere filiere, Collection<ModuleGroup> moduleGroups, List<Pv> pv) {
        super(id, email, password, cin, cne, nom, prenom, dateDeNaissance, address, telephone);
        this.nbApogee = nbApogee;
        this.filiere = filiere;
        this.moduleGroups = moduleGroups;
        this.pvs = pv;
    }
}
