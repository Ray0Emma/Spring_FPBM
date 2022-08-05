package com.example.fpbm.modeles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeTable {
    private String local;
    private String time;
    private String date;
    private String filier;
    private String model;
    private String semister;
}
