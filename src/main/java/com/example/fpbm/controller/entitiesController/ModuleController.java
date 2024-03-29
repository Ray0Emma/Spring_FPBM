package com.example.fpbm.controller.entitiesController;
import com.example.fpbm.entities.Module;
import com.example.fpbm.entities.Semester;
import com.example.fpbm.services.entitiesServices.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    @GetMapping()
    public List<Module> fetchAllModule(){
        return moduleService.fetchAllModule();
    }

    @GetMapping("/{id}")
    public Module fetchOneModule(@PathVariable(name = "id") Long id){
        return moduleService.fetchOneModule(id);
    }

    @GetMapping("filiere/{id}")
    public List<Module> moduleBySemester(@PathVariable(name = "id") Semester semester){
        return moduleService.findBySemester(semester);
    }

    @PostMapping()
    public Module saveModule(@RequestBody Module module){
        return moduleService.saveModule(module);
    }

    @PutMapping("/{id}")
    public Module updateModule(@RequestBody Module module, @PathVariable(name = "id") Long id){
        return moduleService.updateModule(module,id);
    }

    @DeleteMapping("/{id}")
    public String deleteModule(@PathVariable(name = "id") Long id){
        moduleService.deleteModule(id);
        return "Deleted Successfully";
    }
}
