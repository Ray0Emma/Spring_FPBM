package com.example.fpbm.services;

import com.example.fpbm.entities.Annee;
import com.example.fpbm.repositories.AnneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeServiceImpl implements AnneeService{

    @Autowired
    private AnneeRepository anneeRepository;


    @Override
    public Annee saveAnnee(Annee annee) {
        return anneeRepository.save(annee);
    }

    @Override
    public List<Annee> saveListAnnee(List<Annee> annees) {
        return anneeRepository.saveAll(annees);
    }

    @Override
    public List<Annee> fetchAllAnnee() {
        return anneeRepository.findAll();
    }

    @Override
    public Annee fetchOneAnnee(Long anneeId) {
        return anneeRepository.findById(anneeId).get();
    }

    @Override
    public Annee updateAnnee(Annee annee, Long anneeId) {
        annee.setId(anneeId);
        return anneeRepository.save(annee);
    }

    @Override
    public void deleteAnnee(Long anneeId) {
        anneeRepository.deleteById(anneeId);
    }
}
