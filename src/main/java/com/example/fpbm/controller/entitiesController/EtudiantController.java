package com.example.fpbm.controller.entitiesController;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.services.entitiesServices.EtudiantService;
import com.example.fpbm.services.ExcelServices.EtudiantExcelImport;
import com.example.fpbm.services.entitiesServices.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/students")
public class EtudiantController {



    @Autowired
    private FiliereService filiereService;

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping(path="/uploadFile")
//    @ResponseBody
    public String importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
        if(file.isEmpty()){
            System.out.println("Empty File");
            return "empty";
        }
        EtudiantExcelImport a= new EtudiantExcelImport(etudiantService,filiereService);
        a.importToDb(file);
        return "redirect:/";

    }

    @GetMapping()
    public List<Etudiant> fetchAllEtudiant(){
        return etudiantService.fetchAllEtudiant();
    }

    @GetMapping("/{id}")
    public Etudiant fetchOneEtudiant(@PathVariable(name = "id") Long id){
        return etudiantService.fetchOneEtudiant(id);
    }

    @PostMapping()
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.saveEtudiant(etudiant);
    }

    @PatchMapping("/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable(name = "id") Long id){
        return etudiantService.updateEtudiant(etudiant,id);
    }

    @DeleteMapping("/{id}")
    public String deleteEtudiant(@PathVariable(name = "id") Long id){
        etudiantService.deleteEtudiant(id);
        return "Deleted Successfully";
    }
}
