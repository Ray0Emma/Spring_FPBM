package com.example.fpbm.repositories;


import com.example.fpbm.entities.Soutenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoutenanceRepository extends JpaRepository<Soutenance, Long> {
}
