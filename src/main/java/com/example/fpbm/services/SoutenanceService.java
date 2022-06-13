package com.example.fpbm.services;
import com.example.fpbm.entities.Soutenance;

import java.util.List;

public interface SoutenanceService {
    Soutenance saveSoutenance(Soutenance soutenance);
    List<Soutenance> fetchAllSoutenance();
    Soutenance fetchOneSoutenance(Long id);
    Soutenance updateSoutenance(Soutenance soutenance, Long id);
    void deleteSoutenance(Long id);
}
