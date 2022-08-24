package com.example.fpbm.repositories.pvRepository;

import com.example.fpbm.modeles.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PvRepository extends JpaRepository<Pv, Long> {
}
