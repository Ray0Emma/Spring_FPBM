package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "professeur_has_module")
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurHasModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long professeur_has_modulecol;
    @ManyToOne(targetEntity=Annee.class)
    private Annee professeurHasModuleCollectionAnnee;
    @ManyToOne(targetEntity=Courstdtp.class)
    private Courstdtp professeurHasModuleCollectionCoursTDTP;
}
