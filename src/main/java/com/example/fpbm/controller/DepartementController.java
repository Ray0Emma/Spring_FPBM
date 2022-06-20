package com.example.fpbm.controller;


import com.example.fpbm.entities.Departement;
import com.example.fpbm.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
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
