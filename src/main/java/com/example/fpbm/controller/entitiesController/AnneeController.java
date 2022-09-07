package com.example.fpbm.controller.entitiesController;


import com.example.fpbm.entities.Annee;
import com.example.fpbm.services.entitiesServices.AnneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annee")
public class AnneeController {

    @Autowired
    private AnneeService anneeService;

    @GetMapping()
    public List<Annee> fetchAnneeAll(){
        return anneeService.fetchAllAnnee();
    }

    @GetMapping("/{id}")
    public Annee fetchOneAnnee(@PathVariable(name = "id") Long anneeId){
        return anneeService.fetchOneAnnee(anneeId);
    }

    @PostMapping()
    public Annee saveAnnee(@RequestBody Annee annee){
        return anneeService.saveAnnee(annee);
    }

    @PostMapping("/list")
    public List<Annee> saveListAnnee(@RequestBody List<Annee> annees){
        return anneeService.saveListAnnee(annees);
    }

    @PatchMapping("/{id}")
    public Annee updateAnnee(@RequestBody Annee annee, @PathVariable(name = "id") Long anneeId){
        return anneeService.updateAnnee(annee,anneeId);
    }

    @DeleteMapping("/{id}")
    public String deleteAnnee(@PathVariable(name = "id") Long anneeId){
        anneeService.deleteAnnee(anneeId);
        return "Deleted Successfully";
    }

}
