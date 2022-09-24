package com.example.fpbm.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "examen_group")
@Data
@NoArgsConstructor
@AllArgsConstructor
// ExamenHasProfesseurHasModuleHasEtudiant == ExamenGroup
public class ExamenGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=Examen.class)
    private Examen examen;
}

