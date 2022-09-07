package com.example.fpbm.controller.entitiesController;

import com.example.fpbm.entities.PHDStudent;
import com.example.fpbm.services.entitiesServices.PhdStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
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
