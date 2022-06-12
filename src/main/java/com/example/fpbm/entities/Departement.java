package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "departement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany( targetEntity=Filiere.class, mappedBy="departement_iddepartement" )
    private List<Filiere> departement_iddepartement = new ArrayList<>();
}
