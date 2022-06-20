package com.example.fpbm.repositories;

import com.example.fpbm.entities.ProfesseurHasModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurHasModuleRepository extends JpaRepository<ProfesseurHasModule, Long> {
}
