package com.example.fpbm.controller.entitiesController;

import com.example.fpbm.entities.InInscription;
import com.example.fpbm.services.entitiesServices.InInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/InInscription")
public class InInscriptionController {
    @Autowired
    private InInscriptionService inInscriptionService;

    @GetMapping()
    public List<InInscription> fetchAllInInscription(){
        return inInscriptionService.fetchAllInInscription();
    }

    @GetMapping("/{id}")
    public InInscription fetchOneInInscription(@PathVariable(name = "id") Long id){
        return inInscriptionService.fetchOneInInscription(id);
    }

    @PostMapping()
    public InInscription saveInInscription(@RequestBody InInscription inInscription){
        return inInscriptionService.saveInInscription(inInscription);
    }

    @PutMapping("/{id}")
    public InInscription updateInInscription(@RequestBody InInscription inInscription, @PathVariable(name = "id") Long id){
        return inInscriptionService.updateInInscription(inInscription,id);
    }

    @DeleteMapping("/{id}")
    public String deleteInInscription(@PathVariable(name = "id") Long id){
        inInscriptionService.deleteInInscription(id);
        return "Deleted Successfully";
    }

}
