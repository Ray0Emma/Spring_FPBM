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
    private Salle salle;
    @ManyToOne(targetEntity=ProfesseurHasModule.class)
    private ProfesseurHasModule professeurHasModule;
    @OneToMany(targetEntity= ExamenGroup.class, mappedBy="examen")
    private Collection<ExamenGroup> examenGroups;
    @OneToMany(targetEntity=Surveillant.class, mappedBy="examen")
    private Collection<Surveillant> surveillants;
}
