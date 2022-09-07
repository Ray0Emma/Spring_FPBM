package com.example.fpbm.controller.entitiesController;


import com.example.fpbm.entities.Filiere;
import com.example.fpbm.entities.Semester;
import com.example.fpbm.services.entitiesServices.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/semester")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @PostMapping()
    public Semester saveSemester(@RequestBody Semester semester){
        return semesterService.saveSemester(semester);
    }

    @PostMapping("/list")
    public List<Semester> saveListSemester(@RequestBody List<Semester> semesters){
        return semesterService.saveListSemester(semesters);
    }

    @GetMapping("/{id}")
    public Semester fetchOneSemester(@PathVariable(name = "id") Long semesterId){
        return semesterService.fetchOneSemester(semesterId);
    }

    @GetMapping("filiere/{id}")
    public List<Semester> SemesterByFiliere(@PathVariable(name = "id") Filiere filiereId){
        return semesterService.fetchAllSemesterByFiliere(filiereId);
    }

    @GetMapping()
    public List<Semester> fetchAllSemester(){
        return semesterService.fetchAllSemester();
    }

    @PutMapping("/{id}")
    public Semester updateSemester(@RequestBody Semester semester, @PathVariable(name = "id") Long semesterId){
        return semesterService.updateSemester(semester,semesterId);
    }

    @DeleteMapping("/{id}")
    public String deleteSemester(@PathVariable(name = "id") Long semesterId){
        semesterService.deleteSemester(semesterId);
        return "Deleted Successfully";
    }
}
