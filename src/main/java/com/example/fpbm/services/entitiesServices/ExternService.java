package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Extern;

import java.util.List;

public interface ExternService {

    Extern saveExtern(Extern extern);

    Extern fetchOneExtern(Long externId);

    List<Extern> fetchAllExtern();

    Extern updateExtern(Extern extern, Long externId);

    void deleteExtern(Long externId);
    Extern getExtern(Long id) ;

    }
