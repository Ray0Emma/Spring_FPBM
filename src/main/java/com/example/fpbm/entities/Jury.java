package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "jury")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity=Professeur.class)
    private Professeur professeur;

    @ManyToOne( targetEntity=TypeJury.class)
    private TypeJury typeJury;

    @ManyToOne( targetEntity=Soutenance.class)
    private Soutenance soutenance;

}
