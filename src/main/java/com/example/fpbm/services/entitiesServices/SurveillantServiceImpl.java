package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Professeur;
import com.example.fpbm.entities.Surveillant;
import com.example.fpbm.repositories.entitiesRepository.SurveillantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SurveillantServiceImpl implements SurveillantService{
    @Autowired
    private SurveillantRepository surveillantRepository;
    @Override
    public Surveillant saveSurveillant(Surveillant surveillant) {
        return surveillantRepository.save(surveillant);
    }

    @Override
    public List<Surveillant> fetchAllSurveillant() {
        return surveillantRepository.findAll();
    }

    @Override
    public Surveillant fetchOneSurveillant(Long id) {
        return surveillantRepository.findById(id).get();
    }

    @Override
    public Surveillant updateSurveillant(Surveillant surveillant, Long id) {
        surveillant.setId(id);
        return surveillantRepository.save(surveillant);
    }

    @Override
    public void deleteSurveillant(Long id) {
        surveillantRepository.deleteById(id);
    }

    @Override
    public List<Surveillant> getSurveillantNames() {
        List<Surveillant> surveillants=new ArrayList<>();
        List<Object[]> result=surveillantRepository.getSurveillantNames();
        for (Object o[] : result){
            Surveillant s=(Surveillant) o[0];
            Professeur p=(Professeur) o[1];
            s.setName(p.getNom());
            s.setLastname(p.getPrenom());
            surveillants.add(s);
        }
        return surveillants;
    }
}
