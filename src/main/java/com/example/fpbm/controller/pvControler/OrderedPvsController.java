package com.example.fpbm.controller.pvControler;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.OrderedPvs;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.services.EtudiantService;
import com.example.fpbm.services.PvServices.OrderedPvsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderPv")
public class OrderedPvsController {
    @Autowired
    private OrderedPvsService orderedPvsService;
    @Autowired
    private EtudiantService etudiantService;
    @GetMapping()
    public List<OrderedPvs> findAll(){
        return orderedPvsService.fetchAllOrderPvs();
    }
    @GetMapping("/order/{etudiant}/{pv}")
    public OrderedPvs findByEtudiantAndPv(@PathVariable(name = "etudiant") Etudiant etudiant,@PathVariable(name = "pv") Pv pv){
        return orderedPvsService.findOrderByEtudiantAndPV(etudiant,pv);
    }
}
