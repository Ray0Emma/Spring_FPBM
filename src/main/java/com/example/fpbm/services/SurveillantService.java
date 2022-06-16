package com.example.fpbm.services;

import com.example.fpbm.entities.Surveillant;

import java.util.List;

public interface SurveillantService {
    Surveillant saveSurveillant(Surveillant surveillant);
    List<Surveillant> fetchAllSurveillant();
    Surveillant fetchOneSurveillant(Long id);
    Surveillant updateSurveillant(Surveillant surveillant, Long id);
    void deleteSurveillant(Long id);
}
