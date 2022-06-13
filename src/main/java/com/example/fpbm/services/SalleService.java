package com.example.fpbm.services;

import com.example.fpbm.entities.Salle;

import java.util.List;

public interface SalleService {
    Salle saveSalle(Salle salle);

    List<Salle> fetchAllSalle();

    Salle fetchOneSalle(Long id);

    Salle updateSalle(Salle salle, Long id);

    void deleteSalle(Long id);
}
