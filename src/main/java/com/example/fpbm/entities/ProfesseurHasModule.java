package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "professeur_has_module")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurHasModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=Annee.class)
    private Annee annee;
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur professeur;
    @ManyToOne(targetEntity=Module.class)
    private Module module;
    @OneToMany(targetEntity= ModuleGroup.class, mappedBy="professeurHasModule")
    private Collection<ModuleGroup> moduleGroups;
}
