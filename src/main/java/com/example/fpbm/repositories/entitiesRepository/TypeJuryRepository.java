package com.example.fpbm.repositories.entitiesRepository;


import com.example.fpbm.entities.TypeJury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeJuryRepository extends JpaRepository<TypeJury, Long> {
}
