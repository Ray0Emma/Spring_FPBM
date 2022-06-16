package com.example.fpbm.services;

import com.example.fpbm.entities.ExamenGroup;

import java.util.List;

public interface ExamenGroupService {
    ExamenGroup saveExamenGroup(ExamenGroup examenGroup);

    ExamenGroup fetchOneExamenGroup(Long id);

    List<ExamenGroup> fetchAllExamenGroup();

    ExamenGroup updateExamenGroup(ExamenGroup examenGroup, Long id);

    void deleteExamenGroup(Long id);
}
