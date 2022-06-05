package com.example.fpbm.entities;
import javax.persistence.*;

@Entity
@Table(name = "equipe")

public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne( targetEntity=CED.class)
    private CED equipe_idequipe;
}
