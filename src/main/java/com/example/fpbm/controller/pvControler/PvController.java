package com.example.fpbm.controller.pvControler;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.ExamenTime;
import com.example.fpbm.entities.Salle;
import com.example.fpbm.entities.Surveillant;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.repositories.ExamenTimeRepository;
import com.example.fpbm.repositories.SurveillantRepository;
import com.example.fpbm.services.PvServices.PvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/test")
public class PvController {
    @Autowired
    private PvService pvService;

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

    @GetMapping("/{time}")
    public List<Surveillant> getFreeSurveillant(@PathVariable(name = "time") String time){
        return pvService.getFreeSurveillant(time);
    }

    @GetMapping("/salleTimes/{id}")
    public List<ExamenTime> getSalleTimes(@PathVariable(name = "id") Long id){
        return examenTimeRepository.getSurveillantTimes(id);
    }
}
