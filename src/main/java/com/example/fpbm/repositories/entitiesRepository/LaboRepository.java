package com.example.fpbm.repositories.entitiesRepository;


import com.example.fpbm.entities.Labo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboRepository extends JpaRepository<Labo, Long> {
}
