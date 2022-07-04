package com.example.fpbm.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "annee")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Annee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "annee")
    private String annee;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany( targetEntity=ProfesseurHasModule.class, mappedBy="annee" )
    private Collection<ProfesseurHasModule> professeurHasModules;
}

