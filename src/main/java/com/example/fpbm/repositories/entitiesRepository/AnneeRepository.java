package com.example.fpbm.repositories.entitiesRepository;

import com.example.fpbm.entities.Annee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeRepository extends JpaRepository<Annee, Long> {
}
