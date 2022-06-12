package com.example.fpbm.repositories;

import com.example.fpbm.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ExamenRepository extends JpaRepository<Examen, Long> {
}
