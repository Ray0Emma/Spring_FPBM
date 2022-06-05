package com.example.fpbm.entities;


import javax.persistence.*;

@Entity
@Table(name = "labo")
public class Labo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne( targetEntity=CED.class)
    private CED ced_idced;
}
