package com.example.fpbm.repositories;


import com.example.fpbm.entities.InInscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InInscriptionRepository extends JpaRepository<InInscription, Long> {
}
