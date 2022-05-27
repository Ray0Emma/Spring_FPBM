package com.example.fpbm.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "module")
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idmodule;
    @Column(name = "Groupe")
    private String Groupe;
    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="professeurHasModuleCollectionModule")
    private Collection<ProfesseurHasModule> professeurHasModuleCollection;
    @ManyToOne(targetEntity=Semester.class)
    private Semester moduleCollectionSemester;
}
