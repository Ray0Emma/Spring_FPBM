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
    private Annee professeurHasModuleCollectionAnnee;
    @ManyToOne(targetEntity=Courstdtp.class)
    private Courstdtp professeurHasModuleCollectionCoursTDTP;
    @ManyToOne(targetEntity=Section.class)
    private Section professeurHasModuleCollectionSection;
    @OneToMany( targetEntity=Examen.class, mappedBy="examen_prof" )
    private Collection<Examen> examen_prof;
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur prof_module;
    @ManyToOne(targetEntity=Module.class)
    private Module professeurHasModuleCollection;
    @OneToMany(targetEntity= ModuleGroup.class, mappedBy="professeurHasModule")
    private Collection<ModuleGroup> professeurHasModule;
}
