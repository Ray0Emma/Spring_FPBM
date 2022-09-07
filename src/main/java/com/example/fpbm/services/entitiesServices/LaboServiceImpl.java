package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Labo;
import com.example.fpbm.repositories.entitiesRepository.LaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboServiceImpl implements LaboService {
    @Autowired
    private LaboRepository laboRepository;

    @Override
    public Labo saveLabo(Labo labo) {
        return laboRepository.save(labo);
    }

    @Override
    public Labo fetchOneLabo(Long id) {
        return laboRepository.findById(id).get();
    }

    @Override
    public List<Labo> fetchAllLabo() {
        return laboRepository.findAll();
    }

    @Override
    public Labo updateLabo(Labo labo, Long id) {
        labo.setId(id);
        return laboRepository.save(labo);
    }

    @Override
    public void deleteLabo(Long id) {
        laboRepository.deleteById(id);
    }
}
