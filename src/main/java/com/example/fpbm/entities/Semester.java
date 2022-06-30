package com.example.fpbm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "semester")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_semester")
    private String name_semester;
    @JsonIgnore
    @OneToMany(targetEntity= Module.class, mappedBy="moduleCollectionSemester")
    private Collection<Module> moduleCollectionSemester;
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere filiereCollectionSemester;
}

