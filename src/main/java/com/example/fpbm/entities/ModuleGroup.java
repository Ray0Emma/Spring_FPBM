package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "module_group")
@Data
@NoArgsConstructor
@AllArgsConstructor
// ProfesseurHasModuleHasEtudiant == ModuleGroup
public class ModuleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private ProfesseurHasModule professeurHasModule;
    @ManyToOne(targetEntity=Etudiant.class)
    private Etudiant etudiant;
    @OneToMany(targetEntity= ExamenGroup.class, mappedBy="moduleGroup")
    private Collection<ExamenGroup> examenGroups ;
}