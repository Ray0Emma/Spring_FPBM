package com.example.fpbm.controller;

import com.example.fpbm.entities.Professeur;
import com.example.fpbm.entities.ProfesseurHasModule;
import com.example.fpbm.services.*;
import com.example.fpbm.services.ExcelServices.EtudiantExcelImport;
import com.example.fpbm.services.ExcelServices.ProfesseurExcelImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/professors")
public class ProfesseurController {
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private JuryService juryService;
    @Autowired
    private LieuDeTravailService lieuDeTravailService;

    private ProfesseurHasModule professeurHasModule;
    @Autowired
    private ExternService externService;
    @Autowired
    private SurveillantService surveillantService;
    @Autowired
    private SoutenanceService soutenanceService;
    @Autowired
    private ProfesseurService professeurService;

    @PostMapping(path="/uploadFile")
//    @ResponseBody
    public String importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
        if(file.isEmpty()){
            System.out.println("Empty File");
            return "empty";
        }
        ProfesseurExcelImport a= new ProfesseurExcelImport( filiereService,  juryService,  lieuDeTravailService,  professeurHasModule,  externService,  surveillantService,  soutenanceService);
        a.importToDb(file);
        return "redirect:/";

    }
    @PostMapping()
    public Professeur saveProfesseur(@RequestBody Professeur professeur){
        return professeurService.saveProfesseur(professeur);
    }

    @PostMapping("/list")
    public List<Professeur> saveListProfesseur(@RequestBody List<Professeur> professeurs){
        return professeurService.saveListProfesseur(professeurs);
    }

    @GetMapping("/{id}")
    public Professeur fetchOneProfesseur(@PathVariable(name = "id") Long professeurId){
        return professeurService.fetchOneProfesseur(professeurId);
    }


    @GetMapping()
    public List<Professeur> fetchAllProfesseur(){
        return professeurService.fetchAllProfesseur();
    }

    @PatchMapping("/{id}")
    public Professeur updateProfesseur(@RequestBody Professeur professeur, @PathVariable(name = "id") Long professeurId){
        return professeurService.updateProfesseur(professeur,professeurId);
    }

    @DeleteMapping("/{id}")
    public String deleteProfesseur(@PathVariable(name = "id") Long professeurId){
        professeurService.deleteProfesseur(professeurId);
        return "Deleted Successfully";
    }
}
