package com.example.fpbm.entities;


import lombok.*;

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

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Examen.class)
    private Examen examen;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur professeur;

}
