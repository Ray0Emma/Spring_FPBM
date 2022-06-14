package com.example.fpbm.controller;


import com.example.fpbm.entities.Semester;
import com.example.fpbm.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
