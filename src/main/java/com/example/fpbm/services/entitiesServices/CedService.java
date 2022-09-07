package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.CED;

import java.util.List;

public interface CedService {
    CED saveCed(CED ced);

    List<CED> fetchAllCed();

    CED fetchOneCed(Long id);

    CED updateCed(CED ced, Long id);

    void deleteCed(Long id);
}
