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

    @PostMapping
    public Professeur saveProfesseur(@RequestBody Professeur professeur){
        return professeurService.saveProfesseur(professeur);
    }

    @GetMapping("/{id}")
    public Professeur fetchOneProfesseur(@PathVariable Long professeurId){
        return professeurService.fetchOneProfesseur(professeurId);
    }


    @GetMapping()
    public List<Professeur> fetchAllProfesseur(){
        return professeurService.fetchAllProfesseur();
    }
}
