package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.CED;
import com.example.fpbm.repositories.entitiesRepository.CedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CedServiceImpl implements CedService{
    @Autowired
    private CedRepository cedRepository;

    @Override
    public CED saveCed(CED ced) {
        return cedRepository.save(ced);
    }

    @Override
    public List<CED> fetchAllCed() {
        return cedRepository.findAll();
    }

    @Override
    public CED fetchOneCed(Long id) {
        return cedRepository.findById(id).get();
    }

    @Override
    public CED updateCed(CED ced, Long id) {
        ced.setId(id);
        return cedRepository.save(ced);
    }

    @Override
    public void deleteCed(Long id) {
        cedRepository.deleteById(id);
    }
}
