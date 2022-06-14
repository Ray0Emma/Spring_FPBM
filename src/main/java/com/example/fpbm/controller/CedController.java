package com.example.fpbm.controller;

import com.example.fpbm.entities.CED;
import com.example.fpbm.entities.Departement;
import com.example.fpbm.services.CedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ced")
public class CedController {
    @Autowired
    private CedService cedService;
    @GetMapping()
    public List<CED> fetchAllCed(){
        return cedService.fetchAllCed();
    }

    @GetMapping("/{id}")
    public CED fetchOneCed(@PathVariable(name = "id") Long id){
        return cedService.fetchOneCed(id);
    }

    @PostMapping()
    public CED saveCed(@RequestBody CED ced){
        return cedService.saveCed(ced);
    }

    @PutMapping("/{id}")
    public CED updateCed(@RequestBody CED ced, @PathVariable(name = "id") Long id){
        return cedService.updateCed(ced,id);
    }

    @DeleteMapping("/{id}")
    public String deleteCed(@PathVariable(name = "id") Long id){
        cedService.deleteCed(id);
        return "Deleted Successfully";
    }
}
