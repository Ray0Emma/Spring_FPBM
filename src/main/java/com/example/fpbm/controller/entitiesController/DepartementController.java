package com.example.fpbm.controller.entitiesController;


import com.example.fpbm.entities.Departement;
import com.example.fpbm.services.entitiesServices.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/departments")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping()
    public List<Departement> fetchDepartementAll(){
        return departementService.fetchDepartementAll();
    }

    @GetMapping("/{id}")
    public Departement fetchOneDepartement(@PathVariable(name = "id") Long departementId){
        return departementService.fetchOneDepartement(departementId);
    }

    @PostMapping()
    public Departement saveDepartement(@RequestBody Departement departement){
        return departementService.saveDepartement(departement);
    }

    @PostMapping("/list")
    public List<Departement> saveListDepartement(@RequestBody List<Departement> departements){
        return departementService.saveListDepartement(departements);
    }

    @PatchMapping("/{id}")
    public Departement updateDepartement(@RequestBody Departement departement, @PathVariable(name = "id") Long departementId){
        return departementService.updateDepartement(departement,departementId);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartement(@PathVariable(name = "id") Long departementId){
        departementService.deleteDepartement(departementId);
        return "Deleted Successfully";
    }
}