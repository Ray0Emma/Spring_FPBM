package com.example.fpbm.controller;

import com.example.fpbm.entities.ExamenTime;
import com.example.fpbm.services.ExamenTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RequestMapping("/ExamenTime")
public class ExamenTimeController {
    @Autowired
    private ExamenTimeService examenTimeService;
    @GetMapping()
    public List<ExamenTime> findAllData(){
        return examenTimeService.fetchAllExamenTime();
    }
}
