package com.example.fpbm.repositories.entitiesRepository;

import com.example.fpbm.entities.Jury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuryRepository extends JpaRepository<Jury, Long> {
}
