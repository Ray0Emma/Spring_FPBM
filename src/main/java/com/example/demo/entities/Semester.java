package com.example.demo.entities;

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
    @OneToMany( targetEntity=Filiere.class, mappedBy="filiere_idfiliere" )
    private Collection<Filiere> filiereCollection;
}