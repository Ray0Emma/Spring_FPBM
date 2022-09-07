package com.example.fpbm.controller.entitiesController;
import com.example.fpbm.entities.Jury;
import com.example.fpbm.services.entitiesServices.JuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/Jury")
public class JuryController {
    @Autowired
    private JuryService juryService;
    @GetMapping()
    public List<Jury> fetchAllJury(){
        return juryService.fetchAllJury();
    }

    @GetMapping("/{id}")
    public Jury fetchOneJury(@PathVariable(name = "id") Long id){
        return juryService.fetchOneJury(id);
    }

    @PostMapping()
    public Jury saveJury(@RequestBody Jury jury){
        return juryService.saveJury(jury);
    }

    @PutMapping("/{id}")
    public Jury updateJury(@RequestBody Jury jury, @PathVariable(name = "id") Long id){
        return juryService.updateJury(jury,id);
    }

    @DeleteMapping("/{id}")
    public String deleteJury(@PathVariable(name = "id") Long id){
        juryService.deleteJury(id);
        return "Deleted Successfully";
    }
}
