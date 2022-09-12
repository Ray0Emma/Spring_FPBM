package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.PHDStudent;
import com.example.fpbm.repositories.entitiesRepository.PhdStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhdStudentServiceImpl implements PhdStudentService {
    @Autowired
    private PhdStudentRepository phdStudentRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public PHDStudent savePHDStudent(PHDStudent phdStudent) {
        phdStudent.setPassword(passwordEncoder.encode(phdStudent.getPassword()));
        return phdStudentRepository.save(phdStudent);
    }

    @Override
    public List<PHDStudent> fetchAllPHDStudent() {
        return phdStudentRepository.findAll();
    }

    @Override
    public PHDStudent fetchOnePHDStudent(Long id) {
        return phdStudentRepository.findById(id).get();
    }

    @Override
    public PHDStudent updatePHDStudent(PHDStudent phdStudent, Long id) {
        phdStudent.setId(id);
        return phdStudentRepository.save(phdStudent);
    }

    @Override
    public void deletePHDStudent(Long id) {
        phdStudentRepository.deleteById(id);
    }
}
