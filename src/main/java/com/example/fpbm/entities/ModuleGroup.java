package com.example.fpbm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private ProfesseurHasModule professeurHasModule;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Etudiant.class)
    private Etudiant etudiant;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity= ExamenGroup.class, mappedBy="moduleGroup")
    private Collection<ExamenGroup> examenGroups ;
}