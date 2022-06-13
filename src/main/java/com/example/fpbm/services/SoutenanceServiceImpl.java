package com.example.fpbm.services;

import com.example.fpbm.entities.Soutenance;
import com.example.fpbm.repositories.SoutenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SoutenanceServiceImpl implements SoutenanceService{
    @Autowired
    private SoutenanceRepository soutenanceRepository;
    @Override
    public Soutenance saveSoutenance(Soutenance soutenance) {
        return soutenanceRepository.save(soutenance);
    }

    @Override
    public List<Soutenance> fetchAllSoutenance() {
        return soutenanceRepository.findAll();
    }

    @Override
    public Soutenance fetchOneSoutenance(Long id) {
        return soutenanceRepository.findById(id).get();
    }

    @Override
    public Soutenance updateSoutenance(Soutenance soutenance, Long id) {
        soutenance.setId(id);
        return soutenanceRepository.save(soutenance);
    }

    @Override
    public void deleteSoutenance(Long id) {
        soutenanceRepository.deleteById(id);
    }
}
