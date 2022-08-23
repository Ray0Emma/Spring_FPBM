package com.example.fpbm.controller;
import com.example.fpbm.entities.Salle;
import com.example.fpbm.repositories.SalleRepository;
import com.example.fpbm.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/Salle")
public class SalleController {
    @Autowired
    private SalleService salleService;

    @Autowired
    private SalleRepository salleRepository;
    @GetMapping()
    public List<Salle> fetchAllSalle(){
        return salleService.fetchAllSalle();
    }

    @GetMapping("/{id}")
    public Salle fetchOneSalle(@PathVariable(name = "id") Long id){
        return salleService.fetchOneSalle(id);
    }

    @PostMapping()
    public Salle saveSalle(@RequestBody Salle salle){
        return salleService.saveSalle(salle);
    }

    @PutMapping("/{id}")
    public Salle updateEquipe(@RequestBody Salle salle, @PathVariable(name = "id") Long id){
        return salleService.updateSalle(salle,id);
    }

    @DeleteMapping("/{id}")
    public String deleteSalle(@PathVariable(name = "id") Long id){
        salleService.deleteSalle(id);
        return "Deleted Successfully";
    }

    @GetMapping("/occuper/{time}")
    public List<Salle> fetchSalle(@PathVariable(name = "time") String time){
        return salleRepository.demandeDocByPersonne(time);
    }
}
