package com.example.fpbm.services;

import com.example.fpbm.entities.Semester;

import java.util.List;

public interface SemesterService {

    Semester saveSemester(Semester semester);

    List<Semester> saveListSemester(List<Semester> semesters);

    Semester fetchOneSemester(Long semesterId);

    List<Semester> fetchAllSemester();

    Semester updateSemester(Semester semester, Long semesterId);

    void deleteSemester(Long semesterId);
}
