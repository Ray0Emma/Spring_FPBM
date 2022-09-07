package com.example.fpbm.controller.entitiesController;


import com.example.fpbm.entities.Section;
import com.example.fpbm.services.entitiesServices.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping()
    public List<Section> fetchAllSection(){
        return sectionService.fetchAllSection();
    }

    @GetMapping("/{id}")
    public Section fetchOneSection(@PathVariable(name = "id") Long sectionId){
        return sectionService.fetchOneSection(sectionId);
    }

    @PostMapping()
    public Section saveSection(@RequestBody Section section){
        return sectionService.saveSection(section);
    }

    @PostMapping("/list")
    public List<Section> saveListSection(@RequestBody List<Section> sections){
        return sectionService.saveListSection(sections);
    }

    @PatchMapping("/{id}")
    public Section updateSection(@RequestBody Section section, @PathVariable(name = "id") Long sectionId){
        return sectionService.updateSection(section,sectionId);
    }

    @DeleteMapping("/{id}")
    public String deleteSection(@PathVariable(name = "id") Long sectionId){
        sectionService.deleteSection(sectionId);
        return "Deleted Successfully";
    }
}
