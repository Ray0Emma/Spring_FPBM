package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "labo")
@NoArgsConstructor
@AllArgsConstructor
public class Labo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne( targetEntity=CED.class)
    private CED ced_idced;
}
