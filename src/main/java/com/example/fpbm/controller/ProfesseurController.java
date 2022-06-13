package com.example.fpbm.controller;

import com.example.fpbm.entities.Professeur;
import com.example.fpbm.services.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @PostMapping()
    public Professeur saveProfesseur(@RequestBody Professeur professeur){
        return professeurService.saveProfesseur(professeur);
    }

    @PostMapping("/list")
    public List<Professeur> saveListProfesseur(@RequestBody List<Professeur> professeurs){
        return professeurService.saveListProfesseur(professeurs);
    }

    @GetMapping("/{id}")
    public Professeur fetchOneProfesseur(@PathVariable(name = "id") Long professeurId){
        return professeurService.fetchOneProfesseur(professeurId);
    }


    @GetMapping()
    public List<Professeur> fetchAllProfesseur(){
        return professeurService.fetchAllProfesseur();
    }

    @PutMapping("/{id}")
    public Professeur updateProfesseur(@RequestBody Professeur professeur, @PathVariable(name = "id") Long professeurId){
        return professeurService.updateProfesseur(professeur,professeurId);
    }

    @DeleteMapping("/{id}")
    public String deleteProfesseur(@PathVariable(name = "id") Long professeurId){
        professeurService.deleteProfesseur(professeurId);
        return "Deleted Successfully";
    }
}
