package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.TypeJury;

import java.util.List;

public interface TypeJuryService {
    TypeJury saveTypeJury(TypeJury typeJury);
    List<TypeJury> fetchAllTypeJury();
    TypeJury fetchOneTypeJury(Long id);
    TypeJury updateTypeJury(TypeJury typeJury, Long id);
    void deleteTypeJury(Long id);
}
