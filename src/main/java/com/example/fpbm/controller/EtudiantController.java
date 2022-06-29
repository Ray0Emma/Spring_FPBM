package com.example.fpbm.controller;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.services.EtudiantService;
import com.example.fpbm.services.ExcelServices.IExcelDataService;
import com.example.fpbm.services.ExcelServices.IFileUploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/Etudiant")
public class EtudiantController {

    @Autowired
    IFileUploaderService fileService;

    @Autowired
    IExcelDataService excelservice;
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message",
                "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/saveData")
    public String saveExcelData(Model model) {

        List<Etudiant> excelDataAsList = excelservice.getExcelDataAsList();
        int noOfRecords = excelservice.saveExcelData(excelDataAsList);
        model.addAttribute("noOfRecords",noOfRecords);
        return "success";
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

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable(name = "id") Long id){
        return etudiantService.updateEtudiant(etudiant,id);
    }

    @DeleteMapping("/{id}")
    public String deleteEtudiant(@PathVariable(name = "id") Long id){
        etudiantService.deleteEtudiant(id);
        return "Deleted Successfully";
    }
}
