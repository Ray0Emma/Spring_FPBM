package com.example.fpbm.repositories;

import com.example.fpbm.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {

    @Query("select s from Salle s join s.examenTimes ex where ex.idTime=1")
    public List<Salle> demandeDocByPersonne();



    //SELECT c FROM Craftsman c JOIN c.skillList sl WHERE sl.id = :skillId


}
