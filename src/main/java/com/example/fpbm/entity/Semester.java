package com.example.fpbm.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "semester")
@NoArgsConstructor
@AllArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsemester;
    @Column(name = "name_semester")
    private String name_semester;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere filiereCollectionSemester;
    @OneToMany(targetEntity= Module.class, mappedBy="moduleCollectionSemester")
    private Collection<Module> moduleCollectionSemester;
}
