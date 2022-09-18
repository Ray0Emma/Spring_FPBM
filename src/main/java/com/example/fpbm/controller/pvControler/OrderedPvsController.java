package com.example.fpbm.controller.pvControler;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.OrderedPvs;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.services.PvServices.PvService;
import com.example.fpbm.services.entitiesServices.EtudiantService;
import com.example.fpbm.services.PvServices.OrderedPvsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/orderPv")
public class OrderedPvsController {
    @Autowired
    private OrderedPvsService orderedPvsService;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private PvService pvService;
    @GetMapping()
    public List<OrderedPvs> findAll(){
        return orderedPvsService.fetchAllOrderPvs();
    }
    @GetMapping("/order/{etudiant}/{pv}")
    public OrderedPvs findByEtudiantAndPv(@PathVariable(name = "etudiant") Etudiant etudiant,@PathVariable(name = "pv") Pv pv){
        return orderedPvsService.findOrderByEtudiantAndPV(etudiant,pv);
    }
}
