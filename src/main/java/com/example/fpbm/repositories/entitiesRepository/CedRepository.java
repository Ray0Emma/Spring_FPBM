package com.example.fpbm.repositories.entitiesRepository;


import com.example.fpbm.entities.CED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CedRepository extends JpaRepository<CED, Long> {
}
