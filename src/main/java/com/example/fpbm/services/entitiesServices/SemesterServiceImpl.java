package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Filiere;
import com.example.fpbm.entities.Semester;
import com.example.fpbm.repositories.entitiesRepository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class SemesterServiceImpl implements SemesterService{

    @Autowired
    private SemesterRepository semesterRepository;

    @Override
    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    @Override
    public List<Semester> saveListSemester(List<Semester> semesters) {
        return semesterRepository.saveAll(semesters);
    }

    @Override
    public Semester fetchOneSemester(Long semesterId) {
        return semesterRepository.findById(semesterId).get();
    }

    @Override
    public List<Semester> fetchAllSemester() {
        return semesterRepository.findAll();
    }

    @Override
    public List<Semester> fetchAllSemesterByFiliere(Filiere filiereId) {
        return semesterRepository.findByFiliere(filiereId);
    }

    @Override
    public Semester getSemesterByName(String semesterName) {
        return semesterRepository.findByName(semesterName);
    }

    @Override
    public Semester updateSemester(Semester semester, Long semesterId) {
        semester.setId(semesterId);
        return semesterRepository.save(semester);
    }

    @Override
    public void deleteSemester(Long semesterId) {
        semesterRepository.deleteById(semesterId);
    }
}
