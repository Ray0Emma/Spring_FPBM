package com.example.fpbm.entities;


import com.example.fpbm.entities.Professeur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity= Professeur.class, mappedBy="extern")
    private Collection<Professeur> professeurs ;
}

