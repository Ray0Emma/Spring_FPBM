package com.example.fpbm.services.planningServices;

import com.example.fpbm.modeles.TimeTable;

import java.util.List;

public interface PlanningService {
    List<TimeTable> examPlanning(String[] examDate);
}
