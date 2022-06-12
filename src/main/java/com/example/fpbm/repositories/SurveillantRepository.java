package com.example.fpbm.repositories;

import com.example.fpbm.entities.Surveillant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveillantRepository extends JpaRepository<Surveillant, Long> {
}
