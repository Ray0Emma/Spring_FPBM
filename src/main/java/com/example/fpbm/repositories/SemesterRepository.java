package com.example.fpbm.repositories;

import com.example.fpbm.entities.Filiere;
import com.example.fpbm.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    Semester findByName(String name);
}
