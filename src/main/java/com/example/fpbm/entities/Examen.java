package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "examen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "jour")
    private String jour;
    @Column(name = "heure")
    private String heure;
    @ManyToOne(targetEntity=Salle.class)
    private Salle examen_module;
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private Salle examen_prof;
    @OneToMany(targetEntity= ExamenGroup.class, mappedBy="examenHasProfesseur")
    private Collection<ExamenGroup> examenHasProfesseur;
    @OneToMany(targetEntity=Surveillant.class, mappedBy="surveillantCollectionExamen")
    private Collection<Surveillant> surveillantCollectionExamen;
}
