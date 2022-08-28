package com.example.fpbm.services;

import com.example.fpbm.entities.Etudiant;

import java.util.List;

public interface EtudiantService {

    Etudiant saveEtudiant(Etudiant etudiant);

    List<Etudiant> fetchAllEtudiant();

    Etudiant fetchOneEtudiant(Long id);

    Etudiant updateEtudiant(Etudiant etudiant, Long id);

    void deleteEtudiant(Long id);

    List<Etudiant> getEtudiantsByFiliere(String f,String s,String m);

    void saveAll(List<Etudiant> etudiants);

    Etudiant getEtudientByCin(String cin);
}
