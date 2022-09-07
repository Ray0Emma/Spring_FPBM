package com.example.fpbm.controller.entitiesController;
import com.example.fpbm.entities.ExamenTime;
import com.example.fpbm.entities.Salle;
import com.example.fpbm.repositories.entitiesRepository.ExamenTimeRepository;
import com.example.fpbm.repositories.entitiesRepository.SalleRepository;
import com.example.fpbm.services.entitiesServices.SalleService;
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
    @Autowired
    private ExamenTimeRepository examenTimeRepository;
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

    @GetMapping("/salle/time/{time}")
    public List<Salle> getAllByExamenTimesNotContains(@PathVariable(name = "time") String time){
        ExamenTime examenTime = examenTimeRepository.findByTime(time);
        return salleRepository.getAllByExamenTimesNotContains(examenTime);

    }
}
