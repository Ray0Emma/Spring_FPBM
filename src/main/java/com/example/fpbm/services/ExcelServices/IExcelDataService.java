package com.example.fpbm.services.ExcelServices;

import com.example.fpbm.entities.Etudiant;

import java.util.List;

public interface IExcelDataService {

    List<Etudiant> getExcelDataAsList();

    int saveExcelData(List<Etudiant> etudiants);
}
