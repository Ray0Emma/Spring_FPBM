package com.example.fpbm.repositories.pvRepository;

import com.example.fpbm.modeles.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PvRepository extends JpaRepository<Pv, Long> {

    List<Pv> getAllByFilierAndSemesterAndModuleAndLocalDateTime(String filiere, String semestre, String module, String time);

}
