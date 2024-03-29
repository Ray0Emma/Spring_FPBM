package com.example.fpbm.controller.entitiesController;

import com.example.fpbm.entities.ExamenGroup;
import com.example.fpbm.services.entitiesServices.ExamenGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/ExamenGroup")
public class ExamenGroupController {
    @Autowired
    private ExamenGroupService examenGroupService;

    @GetMapping()
    public List<ExamenGroup> fetchAllExamenGroup(){
        return examenGroupService.fetchAllExamenGroup();
    }

    @GetMapping("/{id}")
    public ExamenGroup fetchOneExamenGroup(@PathVariable(name = "id") Long id){
        return examenGroupService.fetchOneExamenGroup(id);
    }

    @PostMapping()
    public ExamenGroup saveExamenGroup(@RequestBody ExamenGroup examenGroup){
        return examenGroupService.saveExamenGroup(examenGroup);
    }

    @PutMapping("/{id}")
    public ExamenGroup updateLabo(@RequestBody ExamenGroup examenGroup, @PathVariable(name = "id") Long id){
        return examenGroupService.updateExamenGroup(examenGroup,id);
    }

    @DeleteMapping("/{id}")
    public String deleteExamenGroup(@PathVariable(name = "id") Long id){
        examenGroupService.deleteExamenGroup(id);
        return "Deleted Successfully";
    }
}
