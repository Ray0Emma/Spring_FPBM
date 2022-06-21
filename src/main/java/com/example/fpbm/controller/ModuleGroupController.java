package com.example.fpbm.controller;
import com.example.fpbm.entities.ModuleGroup;
import com.example.fpbm.services.ModuleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/ModuleGroup")
public class ModuleGroupController {
    @Autowired
    private ModuleGroupService moduleGroupService;

    @GetMapping()
    public List<ModuleGroup> fetchAllModuleGroup(){
        return moduleGroupService.fetchAllModuleGroup();
    }

    @GetMapping("/{id}")
    public ModuleGroup fetchOneModuleGroup(@PathVariable(name = "id") Long id){
        return moduleGroupService.fetchOneModuleGroup(id);
    }

    @PostMapping()
    public ModuleGroup saveModuleGroup(@RequestBody ModuleGroup moduleGroup){
        return moduleGroupService.saveModuleGroup(moduleGroup);
    }

    @PutMapping("/{id}")
    public ModuleGroup updateModuleGroup(@RequestBody ModuleGroup moduleGroup, @PathVariable(name = "id") Long id){
        return moduleGroupService.updateModuleGroup(moduleGroup,id);
    }

    @DeleteMapping("/{id}")
    public String deleteModuleGroup(@PathVariable(name = "id") Long id){
        moduleGroupService.deleteModuleGroup(id);
        return "Deleted Successfully";
    }
}
