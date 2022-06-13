package com.example.fpbm.services;

import com.example.fpbm.entities.CED;
import com.example.fpbm.entities.Equipe;

import java.util.List;

public interface EquipeService {
    Equipe saveEquipe(Equipe equipe);

    List<Equipe> fetchAllEquipe();

    Equipe fetchOneEquipe(Long id);

    Equipe updateEquipe(Equipe equipe, Long id);

    void deleteEquipe(Long id);
}
