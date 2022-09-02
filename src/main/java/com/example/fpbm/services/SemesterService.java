package com.example.fpbm.services;

import com.example.fpbm.entities.Filiere;
import com.example.fpbm.entities.Semester;

import java.util.List;

public interface SemesterService {

    Semester saveSemester(Semester semester);

    List<Semester> saveListSemester(List<Semester> semesters);

    List<Semester> fetchAllSemesterByFiliere(Filiere filiereId);

    Semester fetchOneSemester(Long semesterId);

    List<Semester> fetchAllSemester();

    Semester getSemesterByName(String semesterName);

    Semester updateSemester(Semester semester, Long semesterId);

    void deleteSemester(Long semesterId);
}
