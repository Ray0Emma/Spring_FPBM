package com.example.fpbm.services;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.Professeur;

import java.util.List;

public interface ProfesseurService {

    Professeur saveProfesseur(Professeur professeur);

    List<Professeur> saveListProfesseur(List<Professeur> professeurs);

    Professeur fetchOneProfesseur(Long professeurId);

    List<Professeur> fetchAllProfesseur();

    Professeur updateProfesseur(Professeur professeur, Long professeurId);

    void deleteProfesseur(Long professeurId);

    void saveAll(List<Professeur> professeurs);

}
