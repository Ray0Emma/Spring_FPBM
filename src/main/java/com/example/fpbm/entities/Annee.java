package com.example.fpbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany( targetEntity=ProfesseurHasModule.class, mappedBy="annee" )
    private Collection<ProfesseurHasModule> professeurHasModules;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany( targetEntity=EtudiantHasModule.class, mappedBy="annee" )
    private Collection<EtudiantHasModule> etudiantHasModules;
}

