package com.example.fpbm.controller;


import com.example.fpbm.entities.Filiere;
import com.example.fpbm.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/filiere")
public class FiliereController {


    @Autowired
    private FiliereService filiereService;

    @PostMapping()
    public Filiere saveFiliere(@RequestBody Filiere filiere) {
        return filiereService.saveFiliere(filiere);
    }

    @PostMapping("/list")
    public List<Filiere> saveListFiliere(@RequestBody List<Filiere> filieres) {
        return filiereService.saveListFiliere(filieres);
    }

    @GetMapping("/{id}")
    public Filiere fetchOneFiliere(@PathVariable(name = "id") Long filiereId) {
        return filiereService.fetchOneFiliere(filiereId);
    }


    @GetMapping()
    public List<Filiere> fetchAllFiliere() {
        return filiereService.fetchAllFiliere();
    }

    @PatchMapping("/{id}")
    public Filiere updateFiliere(@RequestBody Filiere filiere, @PathVariable(name = "id") Long filiereId) {
        return filiereService.updateFiliere(filiere, filiereId);
    }

    @DeleteMapping("/{id}")
    public String deleteFiliere(@PathVariable(name = "id") Long filiereId) {
        filiereService.deleteFiliere(filiereId);
        return "Deleted Successfully";
    }
}