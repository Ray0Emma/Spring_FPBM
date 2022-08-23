package com.example.fpbm.repositories;



import com.example.fpbm.entities.ExamenTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenTimeRepository extends JpaRepository<ExamenTime, Long> {
}
