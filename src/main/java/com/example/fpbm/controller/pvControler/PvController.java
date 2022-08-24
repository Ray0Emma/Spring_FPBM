package com.example.fpbm.controller.pvControler;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.Salle;
import com.example.fpbm.entities.Surveillant;
import com.example.fpbm.modeles.Pv;
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
    private SurveillantRepository surveillantRepository;

    @GetMapping("all")
    public List<Pv> getAllPv(){
        return pvService.getAllPv();
    }
    @GetMapping()
    public List<Etudiant> getEtudiantsByFiliere(){
        return pvService.getEtudiantsByFiliere("ISI","S1","Spring");
    }

    @GetMapping("/{filiere}/{semestre}/{module}/{time}")
    public List<Pv> makePv(@PathVariable String filiere,@PathVariable String semestre,@PathVariable String module,@PathVariable(name = "time") String time){
            return  pvService.makePv(filiere,semestre,module,time);
    }

    @GetMapping("/{time}")
    public List<Surveillant> getFreeSurveillant(@PathVariable(name = "time") String time){
        return pvService.getFreeSurveillant(time);
    }
}
