package com.example.fpbm.repositories;

import com.example.fpbm.entities.Extern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternRepository extends JpaRepository<Extern, Long> {
}
