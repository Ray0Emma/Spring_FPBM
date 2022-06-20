package com.example.fpbm.services;

import com.example.fpbm.entities.Surveillant;
import com.example.fpbm.repositories.SurveillantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
