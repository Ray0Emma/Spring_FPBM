package com.example.fpbm.controller.examenPlanning;

import com.example.fpbm.modeles.TimeTable;
import com.example.fpbm.services.planningServices.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planning")
public class PlanningController {
    @Autowired
    private PlanningService planningService;
    @GetMapping()
    public List<TimeTable> allExamPlanning(@RequestBody String[] examDate){
        return planningService.examPlanning(examDate);
    }
}
