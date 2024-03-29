package com.example.fpbm.controller.entitiesController;

import com.example.fpbm.entities.Type;
import com.example.fpbm.services.entitiesServices.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping()
    public Type saveType(@RequestBody Type type){
        return typeService.saveType(type);
    }

    @GetMapping()
    public List<Type> fetchAllType(){
        return typeService.fetchAllType();
    }

    @GetMapping("/{id}")
    public Type fetchOneType(@PathVariable(name = "id") Long typeId){
        return typeService.fetchOneType(typeId);
    }

    @PatchMapping("/{id}")
    public Type updateType(@RequestBody Type type, @PathVariable(name = "id") Long typeId){
        return typeService.updateType(type, typeId);
    }

    @DeleteMapping("/{id}")
    public String deleteType(@PathVariable(name = "id") Long typeId){
        typeService.deleteType(typeId);
        return "Deleted Successfully";
    }
}