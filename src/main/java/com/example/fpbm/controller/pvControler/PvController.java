package com.example.fpbm.controller.pvControler;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.ExamenTime;
import com.example.fpbm.entities.Surveillant;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.repositories.ExamenTimeRepository;
import com.example.fpbm.services.ExcelServices.ProfesseurExcelImport;
import com.example.fpbm.services.ExcelServices.PvExcelImpl;
import com.example.fpbm.services.PvServices.PvService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/pv")
public class PvController {
    @Autowired
    private PvService pvService;
    @Autowired
    private PvExcelImpl pvExcelpv;

   @Autowired
   private ExamenTimeRepository examenTimeRepository;
    @GetMapping("all")
    public List<Pv> getAllPv(){
        return pvService.getAllPv();
    }
    @GetMapping()
    public List<Etudiant> getEtudiantsByFiliere(){
        return pvService.getEtudiantsByFiliere("ISI","S1","Spring");
    }

    @GetMapping("/{filiere}/{semestre}/{module}/{time}")
    public List<Pv> generatePvs(@PathVariable String filiere,@PathVariable String semestre,@PathVariable String module,@PathVariable(name = "time") String time){
            return  pvService.generatePvs(filiere,semestre,module,time);
    }

    /*@GetMapping("/{time}")
    public List<Surveillant> getFreeSurveillant(@PathVariable(name = "time") String time){
        return pvService.getFreeSurveillant(time);
    }*/

    @GetMapping("/salleTimes/{id}")
    public List<ExamenTime> getSalleTimes(@PathVariable(name = "id") Long id){
        return examenTimeRepository.getSurveillantTimes(id);
    }

   /* @SneakyThrows
//    @RequestMapping(value = "/xmap/pv", method = RequestMethod.POST, consumes = "multipart/form-data")
    @PostMapping(path = "/xmap/pv")
    public void convertXslToMap(@RequestParam(name = "file") MultipartFile file){
        if(file.isEmpty()) {
            System.out.println(":::::::::::::::::::: Empty File ::::::::::::::::::");
            return;
        }
        System.out.println(":::::::::::::::::::: Converting File ::::::::::::::::::");
        pvService.convertXslToMap(file);
        System.out.println(":::::::::::::::::::: Fenished Converting File ::::::::::::::::::");
    }*/

    @GetMapping(path = "/etudient/{cin}")
    public List<Pv> getPvsByEtudent(@PathVariable(name = "cin") String cin){
        return pvService.getPvByEtudient(cin);
    }


    @PostMapping(path="/upload")
//    @ResponseBody
    public String importTransactionsFromExcelToPvGenerater(@RequestParam("file") List<MultipartFile> file) {
        if(file.isEmpty()){
            System.out.println("Empty File");
            return "empty";
        }
        pvExcelpv.importToDb(file);
        return "redirect:/";

    }
}
