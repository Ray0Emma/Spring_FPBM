package com.example.fpbm.controller;

import com.example.fpbm.entities.Equipe;
import com.example.fpbm.entities.PHDStudent;
import com.example.fpbm.services.PhdStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PhdStudent")
public class PhdStudentController {
    @Autowired
    private PhdStudentService phdStudentService;
    @GetMapping()
    public List<PHDStudent> fetchAllPHDStudent(){
        return phdStudentService.fetchAllPHDStudent();
    }

    @GetMapping("/{id}")
    public PHDStudent fetchOnePHDStudent(@PathVariable(name = "id") Long id){
        return phdStudentService.fetchOnePHDStudent(id);
    }

    @PostMapping()
    public PHDStudent savePHDStudent(@RequestBody PHDStudent phdStudent){
        return phdStudentService.savePHDStudent(phdStudent);
    }

    @PutMapping("/{id}")
    public PHDStudent updatePHDStudent(@RequestBody PHDStudent phdStudent, @PathVariable(name = "id") Long id){
        return phdStudentService.updatePHDStudent(phdStudent,id);
    }

    @DeleteMapping("/{id}")
    public String deletePHDStudent(@PathVariable(name = "id") Long id){
        phdStudentService.deletePHDStudent(id);
        return "Deleted Successfully";
    }
}
