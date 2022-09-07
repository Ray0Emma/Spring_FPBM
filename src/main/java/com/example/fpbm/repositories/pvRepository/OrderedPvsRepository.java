package com.example.fpbm.repositories.pvRepository;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.OrderedPvs;
import com.example.fpbm.modeles.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedPvsRepository extends JpaRepository<OrderedPvs, Long> {
    OrderedPvs findOrderedPvsByEtudiantAndPv(Etudiant etudiant, Pv pv);
}
