package com.example.fpbm.services.entitiesServices;
import com.example.fpbm.entities.PHDStudent;

import java.util.List;

public interface PhdStudentService {
    PHDStudent savePHDStudent(PHDStudent phdStudent);

    List<PHDStudent> fetchAllPHDStudent();

    PHDStudent fetchOnePHDStudent(Long id);

    PHDStudent updatePHDStudent(PHDStudent phdStudent, Long id);

    void deletePHDStudent(Long id);
}
