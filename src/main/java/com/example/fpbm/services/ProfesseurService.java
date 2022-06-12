package com.example.fpbm.services;

import com.example.fpbm.entities.Professeur;

import java.util.List;

public interface ProfesseurService {

    Professeur saveProfesseur(Professeur professeur);

    Professeur fetchOneProfesseur(Long professeurId);

    List<Professeur> fetchAllProfesseur();

    Professeur updateProfesseur(Professeur professeur, Long professeurId);

    void deleteProfesseur(Long professeurId);
}
