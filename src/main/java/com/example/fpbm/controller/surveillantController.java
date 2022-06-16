package com.example.fpbm.controller;
import com.example.fpbm.entities.Surveillant;
import com.example.fpbm.services.SurveillantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveillant")
public class surveillantController {
    @Autowired
    private SurveillantService surveillantService;
    @PostMapping()
    public Surveillant saveSurveillant(@RequestBody Surveillant surveillant){
        return surveillantService.saveSurveillant(surveillant);
    }

    @GetMapping()
    public List<Surveillant> fetchAllSurveillant(){
        return surveillantService.fetchAllSurveillant();
    }

    @GetMapping("/{id}")
    public Surveillant fetchOneSurveillant(@PathVariable(name = "id") Long id){
        return surveillantService.fetchOneSurveillant(id);
    }

    @PutMapping("/{id}")
    public Surveillant updateSurveillant(@RequestBody Surveillant surveillant, @PathVariable(name = "id") Long id){
        return surveillantService.updateSurveillant(surveillant, id);
    }

    @DeleteMapping("/{id}")
    public String deleteSurveillant(@PathVariable(name = "id") Long id){
        surveillantService.deleteSurveillant(id);
        return "Deleted Successfully";
    }
}
