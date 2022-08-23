package com.example.fpbm.repositories;

import com.example.fpbm.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {

    @Query("select s from Salle s join s.examenTimes ex where ex.time=:time")
    public List<Salle> demandeDocByPersonne(@PathVariable(name = "time") String time);



    //SELECT c FROM Craftsman c JOIN c.skillList sl WHERE sl.id = :skillId


}
