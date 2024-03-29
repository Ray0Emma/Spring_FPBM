package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Departement;

import java.util.List;

public interface DepartementService {

    Departement saveDepartement(Departement departement);

    List<Departement> saveListDepartement(List<Departement> departements);

    List<Departement> fetchDepartementAll();

    Departement fetchOneDepartement(Long departementId);

    Departement updateDepartement(Departement departement, Long departementId);

    void deleteDepartement(Long departementId);
}
