package com.example.fpbm.repositories;


import com.example.fpbm.entities.PHDStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhdStudentRepository extends JpaRepository<PHDStudent, Long> {
}
