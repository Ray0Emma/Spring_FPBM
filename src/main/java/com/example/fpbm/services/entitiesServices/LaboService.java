package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Labo;
import java.util.List;

public interface LaboService {
    Labo saveLabo(Labo labo);

    Labo fetchOneLabo(Long id);

    List<Labo> fetchAllLabo();

    Labo updateLabo(Labo labo, Long id);

    void deleteLabo(Long id);
}
