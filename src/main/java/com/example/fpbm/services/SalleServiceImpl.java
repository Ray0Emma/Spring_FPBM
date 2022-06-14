package com.example.fpbm.services;

import com.example.fpbm.entities.Salle;
import com.example.fpbm.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalleServiceImpl implements SalleService{
    @Autowired
    private SalleRepository salleRepository;

    @Override
    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public List<Salle> fetchAllSalle() {
        return salleRepository.findAll();
    }

    @Override
    public Salle fetchOneSalle(Long id) {
        return salleRepository.findById(id).get();
    }

    @Override
    public Salle updateSalle(Salle salle, Long id) {
        salle.setId(id);
        return salleRepository.save(salle);
    }

    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }
}
