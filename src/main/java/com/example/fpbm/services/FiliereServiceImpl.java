package com.example.fpbm.services;

import com.example.fpbm.entities.Filiere;
import com.example.fpbm.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FiliereServiceImpl implements FiliereService{

    @Autowired
    private FiliereRepository filiereRepository;

    @Override
    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public List<Filiere> saveListFiliere(List<Filiere> filieres) {
        return filiereRepository.saveAll(filieres);
    }

    @Override
    public Filiere fetchOneFiliere(Long filiereId) {
        return filiereRepository.findById(filiereId).get();
    }

    @Override
    public List<Filiere> fetchAllFiliere() {
        return filiereRepository.findAll();
    }

    @Override
    public Filiere updateFiliere(Filiere filiere, Long filiereId) {
        filiere.setId(filiereId);
        return filiereRepository.save(filiere);
    }

    @Override
    public void deleteFiliere(Long filiereId) {
        filiereRepository.deleteById(filiereId);
    }
}
