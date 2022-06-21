package com.example.fpbm.controller;


import com.example.fpbm.entities.CED;
import com.example.fpbm.entities.Equipe;
import com.example.fpbm.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/Equipe")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;
    @GetMapping()
    public List<Equipe> fetchAllEquipe(){
        return equipeService.fetchAllEquipe();
    }

    @GetMapping("/{id}")
    public Equipe fetchOneEquipe(@PathVariable(name = "id") Long id){
        return equipeService.fetchOneEquipe(id);
    }

    @PostMapping()
    public Equipe saveEquipe(@RequestBody Equipe equipe){
        return equipeService.saveEquipe(equipe);
    }

    @PutMapping("/{id}")
    public Equipe updateEquipe(@RequestBody Equipe equipe, @PathVariable(name = "id") Long id){
        return equipeService.updateEquipe(equipe,id);
    }

    @DeleteMapping("/{id}")
    public String deleteEquipe(@PathVariable(name = "id") Long id){
        equipeService.deleteEquipe(id);
        return "Deleted Successfully";
    }
}
