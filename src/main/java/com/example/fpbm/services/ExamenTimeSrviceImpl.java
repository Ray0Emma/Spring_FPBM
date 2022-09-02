package com.example.fpbm.services;

import com.example.fpbm.entities.ExamenTime;
import com.example.fpbm.repositories.ExamenTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenTimeSrviceImpl implements ExamenTimeService{
    @Autowired
    private ExamenTimeRepository examenTimeRepository;
    @Override
    public List<ExamenTime> fetchAllExamenTime() {
        return examenTimeRepository.findAll();
    }
}
