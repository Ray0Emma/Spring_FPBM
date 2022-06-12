package com.example.fpbm.repositories;

import com.example.fpbm.entities.ModuleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// ProfesseurHasModuleHasEtudiantRepository == ModuleGroupRepository
@Repository
public interface ModuleGroupRepository extends JpaRepository<ModuleGroup, Long> {
}
