package com.example.fpbm.repositories;


import com.example.fpbm.entities.ExamenTime;
import com.example.fpbm.entities.Surveillant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface SurveillantRepository extends JpaRepository<Surveillant, Long> {
    @Query("select s,p from Surveillant s join s.professeur p where s.professeur.id=p.id ")
    List<Object[]> getSurveillantNames();

    @Query("select s from Surveillant s join s.examenTimes ex where ex.time=:time")
    public List<Surveillant> getSurveillantOcup(@PathVariable(name = "time") String time);

    List<Surveillant> getAllByExamenTimesNotContains(ExamenTime examenTime);
}
