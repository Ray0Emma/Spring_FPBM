package com.example.fpbm.repositories;

import com.example.fpbm.entities.Courstdtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursTdTpRepository extends JpaRepository<Courstdtp, Long> {
}
