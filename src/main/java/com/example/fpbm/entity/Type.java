package com.example.fpbm.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type")
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtype;
    @Column(name = "name")
    private String name;
    @OneToMany(targetEntity = Filiere.class, mappedBy = "filiereCollectionType")
    private Collection<Filiere> filiereCollectionType;

}
