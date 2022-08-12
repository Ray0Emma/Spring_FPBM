package com.example.fpbm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "lieuDeTravail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LieuDeTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=Professeur.class, mappedBy="lieuDeTravail")
    private Collection<Professeur> professeurs ;

}
