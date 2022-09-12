package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Professeur;
import com.example.fpbm.repositories.entitiesRepository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService{

    @Autowired
    private ProfesseurRepository professeurRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Professeur saveProfesseur(Professeur professeur) {
        professeur.setPassword(passwordEncoder.encode(professeur.getPassword()));
        return professeurRepository.save(professeur);
    }

    @Override
    public List<Professeur> saveListProfesseur(List<Professeur> professeurs) {
        return professeurRepository.saveAll(professeurs);
    }

    @Override
    public Professeur fetchOneProfesseur(Long professeurId) {
        return professeurRepository.findById(professeurId).get();
    }

    @Override
    public List<Professeur> fetchAllProfesseur() {
        return (List<Professeur>) professeurRepository.findAll();
    }

    @Override
    public Professeur updateProfesseur(Professeur professeur, Long professeurId) {
        professeur.setId(professeurId);
        return professeurRepository.save(professeur);
    }

    @Override
    public void deleteProfesseur(Long professeurId) {
        professeurRepository.deleteById(professeurId);
    }

    @Override
    public void saveAll(List<Professeur> professeurs) {
        professeurRepository.saveAll(professeurs);
    }
}
