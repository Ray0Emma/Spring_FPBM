package com.example.fpbm.services;

import com.example.fpbm.entities.Filiere;

import java.util.List;

public interface FiliereService {

    Filiere saveFiliere(Filiere filiere);

    List<Filiere> saveListFiliere(List<Filiere> filieres);

    Filiere fetchOneFiliere(Long filiereId);

    List<Filiere> fetchAllFiliere();

    Filiere updateFiliere(Filiere filiere, Long filiereId);

    void deleteFiliere(Long filiereId);
}
