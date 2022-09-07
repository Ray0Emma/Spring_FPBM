package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.ExamenGroup;
import com.example.fpbm.repositories.entitiesRepository.ExamenGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenGroupServiceImpl implements ExamenGroupService{
    @Autowired
    private ExamenGroupRepository examenGroupRepository;
    @Override
    public ExamenGroup saveExamenGroup(ExamenGroup examenGroup) {
        return examenGroupRepository.save(examenGroup);
    }

    @Override
    public ExamenGroup fetchOneExamenGroup(Long id) {
        return examenGroupRepository.findById(id).get();
    }

    @Override
    public List<ExamenGroup> fetchAllExamenGroup() {
        return examenGroupRepository.findAll();
    }

    @Override
    public ExamenGroup updateExamenGroup(ExamenGroup examenGroup, Long id) {
        examenGroup.setId(id);
        return examenGroupRepository.save(examenGroup);
    }

    @Override
    public void deleteExamenGroup(Long id) {
        examenGroupRepository.deleteById(id);
    }
}
