package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.repositories.entitiesRepository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService{

    @Autowired
    private EtudiantRepository  etudiantRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        etudiant.setPassword(passwordEncoder.encode(etudiant.getPassword()));
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> fetchAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant fetchOneEtudiant(Long id) {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant, Long id) {
        etudiant.setId(id);
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> getEtudiantsByFiliere(String f, String s, String m) {
        return etudiantRepository.getEtudiantsByFiliere(f,s,m);
    }

    public void saveAll(List<Etudiant> etudiants) {
        etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant getEtudientByCin(String cin) {
        return etudiantRepository.getEtudiantByCin(cin);
    }
}
