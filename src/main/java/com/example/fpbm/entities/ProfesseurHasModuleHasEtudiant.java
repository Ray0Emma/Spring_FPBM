package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "professeur_has_module_has_etudiant")
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurHasModuleHasEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private ProfesseurHasModule professeurHasModule;
    @ManyToOne(targetEntity=Etudiant.class)
    private Etudiant professeurHasModuleHasEtudiantCollectionEtudiant;
    @OneToMany(targetEntity=ExamenHasProfesseurHasModuleHasEtudiant.class, mappedBy="examens")
    private Collection<ExamenHasProfesseurHasModuleHasEtudiant> examens ;
}
