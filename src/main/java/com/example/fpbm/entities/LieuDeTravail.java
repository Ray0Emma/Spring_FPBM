package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany(targetEntity=Professeur.class, mappedBy="professeurCollectionLieu")
    private Collection<Professeur> professeurCollectionLieu ;

}
