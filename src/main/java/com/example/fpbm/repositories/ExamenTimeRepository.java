package com.example.fpbm.repositories;



import com.example.fpbm.entities.ExamenTime;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ExamenTimeRepository extends JpaRepository<ExamenTime, Long> {

    ExamenTime findByTime(String time);

    @Query("select ex from ExamenTime ex join ex.salles s where s.id=:id")
    public List<ExamenTime> getSalleTimes(@PathVariable(name = "id") Long id);

    @Query("select ex from ExamenTime ex join ex.surveillants s where s.id=:id")
    public List<ExamenTime> getSurveillantTimes(@PathVariable(name = "id") Long id);

}
