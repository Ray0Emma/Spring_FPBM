package com.example.fpbm.controller.entitiesController;


import com.example.fpbm.entities.LieuDeTravail;
import com.example.fpbm.services.entitiesServices.LieuDeTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lieuDeTravail")
public class LieuDeTravailController {

    @Autowired
    private LieuDeTravailService lieuDeTravailService;

    @PostMapping()
    public LieuDeTravail saveLieuDeTravail(@RequestBody LieuDeTravail lieuDeTravail){
        return lieuDeTravailService.saveLieuDeTravail(lieuDeTravail);
    }

    @GetMapping()
    public List<LieuDeTravail> fetchAllLieuDeTravail(){
        return lieuDeTravailService.fetchAllLieuDeTravail();
    }

    @GetMapping("/{id}")
    public LieuDeTravail fetchOneLieuDeTravail(@PathVariable(name = "id") Long lieuDeTravailId){
        return lieuDeTravailService.fetchOneLieuDeTravail(lieuDeTravailId);
    }

    @PatchMapping("/{id}")
    public LieuDeTravail updateLieuDeTravail(@RequestBody LieuDeTravail lieuDeTravail, @PathVariable(name = "id") Long lieuDeTravailId){
        return lieuDeTravailService.updateLieuDeTravail(lieuDeTravail, lieuDeTravailId);
    }

    @DeleteMapping("/{id}")
    public String deleteLieuDeTravail(@PathVariable(name = "id") Long lieuDeTravailId){
        lieuDeTravailService.deleteLieuDeTravail(lieuDeTravailId);
        return "Deleted Successfully";
    }
}
