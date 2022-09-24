package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "etudiant_has_module")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantHasModule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=Annee.class)
    private Annee annee;
    @ManyToOne(targetEntity=Etudiant.class)
    private Etudiant etudiant;
    @ManyToOne(targetEntity=Module.class)
    private Module module;

    public EtudiantHasModule(Annee annee, Etudiant etudiant, Module module) {
        this.annee = annee;
        this.etudiant = etudiant;
        this.module = module;
    }
}
