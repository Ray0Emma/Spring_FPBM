package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Departement;
import com.example.fpbm.repositories.entitiesRepository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService{

    @Autowired
    private DepartementRepository departementRepository;


    @Override
    public Departement saveDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public List<Departement> saveListDepartement(List<Departement> departements) {
        return departementRepository.saveAll(departements);
    }

    @Override
    public List<Departement> fetchDepartementAll() {
        return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Departement fetchOneDepartement(Long departementId) {
        return departementRepository.findById(departementId).get();
    }


    @Override
    public Departement updateDepartement(Departement departement, Long departementId) {
        departement.setId(departementId);
        return departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(Long departementId) {
        departementRepository.deleteById(departementId);
    }
}
