package com.example.fpbm.repositories.entitiesRepository;

import com.example.fpbm.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ExamenRepository extends JpaRepository<Examen, Long> {
}
