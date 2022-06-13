package com.example.fpbm.services;

import com.example.fpbm.entities.Jury;

import java.util.List;

public interface JuryService {
    Jury saveJury(Jury jury);

    Jury fetchOneJury(Long id);

    List<Jury> fetchAllJury();

    Jury updateJury(Jury jury, Long id);

    void deleteJury(Long id);
}
