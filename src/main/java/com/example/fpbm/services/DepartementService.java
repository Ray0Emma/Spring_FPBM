package com.example.fpbm.services;

import com.example.fpbm.entities.Departement;

import java.util.List;

public interface DepartementService {

    Departement saveDepartement(Departement departement);

    List<Departement> fetchDepartementAll();

    Departement fetchOneDepartement(Long departementId);

    Departement updateDepartement(Departement departement, Long departementId);

    void deleteDepartement(Long departementId);
}
