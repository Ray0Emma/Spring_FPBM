package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "examen_has_professeur_has_module_has_etudiant")
@NoArgsConstructor
@AllArgsConstructor
public class ExamenHasProfesseurHasModuleHasEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_examen_has_professeur_has_module_has_etudiant;
}
