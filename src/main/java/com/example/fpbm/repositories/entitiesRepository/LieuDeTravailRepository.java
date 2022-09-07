package com.example.fpbm.repositories.entitiesRepository;

import com.example.fpbm.entities.LieuDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuDeTravailRepository extends JpaRepository<LieuDeTravail, Long> {
}
