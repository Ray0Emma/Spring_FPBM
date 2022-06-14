package com.example.fpbm.controller;

import com.example.fpbm.entities.TypeJury;
import com.example.fpbm.services.TypeJuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TypeJury")
public class TypeJuryController {
    @Autowired
    private TypeJuryService typeJuryService;

    @GetMapping()
    public List<TypeJury> fetchAllTypeJury(){
        return typeJuryService.fetchAllTypeJury();
    }

    @GetMapping("/{id}")
    public TypeJury fetchOneTypeJury(@PathVariable(name = "id") Long id){
        return typeJuryService.fetchOneTypeJury(id);
    }

    @PostMapping()
    public TypeJury saveTypeJury(@RequestBody TypeJury typeJury){
        return typeJuryService.saveTypeJury(typeJury);
    }

    @PutMapping("/{id}")
    public TypeJury updateTypeJury(@RequestBody TypeJury typeJury, @PathVariable(name = "id") Long id){
        return typeJuryService.updateTypeJury(typeJury,id);
    }

    @DeleteMapping("/{id}")
    public String deleteTypeJury(@PathVariable(name = "id") Long id){
        typeJuryService.deleteTypeJury(id);
        return "Deleted Successfully";
    }
}
