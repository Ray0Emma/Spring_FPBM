package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "professeur_has_module_has_etudiant")
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurHasModuleHasEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long professeur_has_module_has_etudiantcol;
}
