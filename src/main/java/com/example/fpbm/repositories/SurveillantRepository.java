package com.example.fpbm.repositories;

import com.example.fpbm.entities.Surveillant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveillantRepository extends JpaRepository<Surveillant, Long> {
    @Query("select s,p from Surveillant s join s.professeur p where s.professeur.id=p.id ")
    List<Object[]> getSurveillantNames();
}
