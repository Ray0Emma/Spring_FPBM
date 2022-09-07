package com.example.fpbm.repositories.entitiesRepository;

import com.example.fpbm.entities.ExamenGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ExamenHasProfesseurHasModuleHasEtudiantRepository == ExamenGroupRepository
@Repository
public interface ExamenGroupRepository extends JpaRepository<ExamenGroup, Long> {
}
