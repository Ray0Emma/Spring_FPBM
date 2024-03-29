package com.example.fpbm.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
@Builder
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom")
    private String nom;
    @JsonIgnore
    @OneToMany( targetEntity=Filiere.class, mappedBy="departement" )
    private List<Filiere> filieres;

}
