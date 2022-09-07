package com.example.fpbm.controller.entitiesController;

import com.example.fpbm.entities.Soutenance;
import com.example.fpbm.services.entitiesServices.SoutenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/Soutenance")
public class SoutenanceController {
    @Autowired
    private SoutenanceService soutenanceService;
    @GetMapping()
    public List<Soutenance> fetchAllSoutenance(){
        return soutenanceService.fetchAllSoutenance();
    }

    @GetMapping("/{id}")
    public Soutenance fetchOneSoutenance(@PathVariable(name = "id") Long id){
        return soutenanceService.fetchOneSoutenance(id);
    }

    @PostMapping()
    public Soutenance saveSoutenance(@RequestBody Soutenance soutenance){
        return soutenanceService.saveSoutenance(soutenance);
    }

    @PutMapping("/{id}")
    public Soutenance updateSoutenance(@RequestBody Soutenance soutenance, @PathVariable(name = "id") Long id){
        return soutenanceService.updateSoutenance(soutenance,id);
    }

    @DeleteMapping("/{id}")
    public String deleteSoutenance(@PathVariable(name = "id") Long id){
        soutenanceService.deleteSoutenance(id);
        return "Deleted Successfully";
    }
}
