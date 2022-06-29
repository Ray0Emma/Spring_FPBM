package com.example.fpbm.controller;

import com.example.fpbm.entities.Courstdtp;
import com.example.fpbm.services.CoursTdTpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courstdtp")
public class CoursTdTpController {

    @Autowired
    private CoursTdTpService coursTdTpService;

    @GetMapping()
    public List<Courstdtp> fetchAllCourstdtp(){
        return coursTdTpService.fetchAllCourstdtp();
    }

    @GetMapping("/{id}")
    public Courstdtp fetchOneCourstdtp(@PathVariable(name = "id") Long courstdtpId){
        return coursTdTpService.fetchOneCourstdtp(courstdtpId);
    }

    @PostMapping()
    public Courstdtp saveCourstdtp(@RequestBody Courstdtp courstdtp){
        return coursTdTpService.saveCourstdtp(courstdtp);
    }

    @PostMapping("/list")
    public List<Courstdtp> saveListCourstdtp(@RequestBody List<Courstdtp> courstdtps){
        return coursTdTpService.saveListCourstdtp(courstdtps);
    }

    @PatchMapping("/{id}")
    public Courstdtp updateCourstdtp(@RequestBody Courstdtp courstdtp, @PathVariable(name = "id") Long courstdtpId){
        return coursTdTpService.updateCourstdtp(courstdtp,courstdtpId);
    }

    @DeleteMapping("/{id}")
    public String deleteCourstdtp(@PathVariable(name = "id") Long courstdtpId){
        coursTdTpService.deleteCourstdtp(courstdtpId);
        return "Deleted Successfully";
    }
}
