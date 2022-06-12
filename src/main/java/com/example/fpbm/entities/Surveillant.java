package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "surveillant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surveillant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=Examen.class)
    private Examen surveillantCollectionExamen;
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur surveillantCollectionProfesseur;

}
