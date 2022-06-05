package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "extern")
@NoArgsConstructor
@AllArgsConstructor
public class Extern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(targetEntity=Professeur.class, mappedBy="professeurCollectionExtern")
    private Collection<Professeur> professeurCollectionExtern ;
}
