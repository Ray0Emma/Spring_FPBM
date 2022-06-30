package com.example.fpbm.controller;


import com.example.fpbm.entities.Extern;
import com.example.fpbm.services.ExternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extern")
public class ExternController {

    @Autowired
    private ExternService externService;

    @PostMapping()
    public Extern saveExtern(@RequestBody Extern extern){
        return externService.saveExtern(extern);
    }

    @GetMapping()
    public List<Extern> fetchAllExtern(){
        return externService.fetchAllExtern();
    }

    @GetMapping("/{id}")
    public Extern fetchOneExtern(@PathVariable(name = "id") Long externId){
        return externService.fetchOneExtern(externId);
    }

    @PatchMapping("/{id}")
    public Extern updateExtern(@RequestBody Extern extern, @PathVariable(name = "id") Long externId){
        extern.setId(externId);
        return externService.updateExtern(extern, externId);
    }

    @DeleteMapping("/{id}")
    public String deleteType(@PathVariable(name = "id") Long externId){
        externService.deleteExtern(externId);
        return "Deleted Successfully";
    }
}
