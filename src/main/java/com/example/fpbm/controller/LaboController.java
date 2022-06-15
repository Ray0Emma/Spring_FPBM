package com.example.fpbm.controller;
import com.example.fpbm.entities.Labo;
import com.example.fpbm.services.LaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Labo")
public class LaboController {
    @Autowired
    private LaboService laboService;

    @GetMapping()
    public List<Labo> fetchAllLabo(){
        return laboService.fetchAllLabo();
    }

    @GetMapping("/{id}")
    public Labo fetchOneLabo(@PathVariable(name = "id") Long id){
        return laboService.fetchOneLabo(id);
    }

    @PostMapping()
    public Labo saveLabo(@RequestBody Labo labo){
        return laboService.saveLabo(labo);
    }

    @PutMapping("/{id}")
    public Labo updateLabo(@RequestBody Labo labo, @PathVariable(name = "id") Long id){
        return laboService.updateLabo(labo,id);
    }

    @DeleteMapping("/{id}")
    public String deleteLabo(@PathVariable(name = "id") Long id){
        laboService.deleteLabo(id);
        return "Deleted Successfully";
    }
}
