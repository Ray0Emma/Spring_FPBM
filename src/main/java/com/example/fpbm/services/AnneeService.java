package com.example.fpbm.services;



import com.example.fpbm.entities.Annee;

import java.util.List;

public interface AnneeService {

    Annee saveAnnee(Annee annee);

    List<Annee> saveListAnnee(List<Annee> annees);

    List<Annee> fetchAllAnnee();

    Annee fetchOneAnnee(Long anneeId);

    Annee updateAnnee(Annee annee, Long anneeId);

    void deleteAnnee(Long anneeId);
}
