package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "departement")
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iddepartement;
    @Column(name = "name")
    private String name;
    @OneToMany( targetEntity=Filiere.class, mappedBy="departement_iddepartement" )
    private Collection<Filiere> filiereCollection;


}
