package com.example.fpbm.controller.pvControler;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.services.PvServices.PvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class PvController {
    @Autowired
    private PvService pvService;
    @GetMapping()
    public List<Etudiant> getEtudiantsByFiliere(){
        return pvService.getEtudiantsByFiliere("ISI","S1","Spring");
    }

    @GetMapping("/{filiere}/{semestre}/{module}")
    public List<Pv> makePv(@PathVariable String filiere,@PathVariable String semestre,@PathVariable String module){
            return  pvService.makePv(filiere,semestre,module);
    }
}
