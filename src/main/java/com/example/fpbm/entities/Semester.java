package com.example.fpbm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "semester")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_semester")
    private String name_semester;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity= Module.class, mappedBy="semester")
    private Collection<Module> modules;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Filiere.class)
    private Filiere filiere;
}

