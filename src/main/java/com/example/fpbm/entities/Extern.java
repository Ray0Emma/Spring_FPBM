package com.example.fpbm.entities;


import com.example.fpbm.entities.Professeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "extern")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Extern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(targetEntity= Professeur.class, mappedBy="extern")
    private Collection<Professeur> professeurs ;
}

