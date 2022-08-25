package com.example.fpbm.entities;


import com.example.fpbm.modeles.Pv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "surveillant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surveillant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Examen.class)
    private Examen examen;
    
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Professeur.class)
    private Professeur professeur;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "Surveillant_ExamenTime",
            joinColumns = @JoinColumn(name = "surveillant_id"),
            inverseJoinColumns = @JoinColumn(name = "examenTime_id"))
    private List<ExamenTime> examenTimes;


    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "Pv_Surveillant",
            joinColumns = @JoinColumn(name = "surveillant_id"),
            inverseJoinColumns = @JoinColumn(name = "pv_id"))
    private List<Pv> pvs;

}
