package com.example.fpbm.services.planningServices;

import com.example.fpbm.modeles.TimeTable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanningServiceImpl implements PlanningService {

    @Override
    public List<TimeTable> examPlanning(String[] examDate) {
        TimeTable timeTable = new TimeTable();
        List<TimeTable> timeTableList = new ArrayList<TimeTable>();
        for (String date:examDate
             ) {
            timeTable.setDate(date);
            timeTableList.add(timeTable);
        }
        return timeTableList;
    }
}
