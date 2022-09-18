package com.example.fpbm.repositories.pvRepository;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.Surveillant;
import com.example.fpbm.modeles.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PvRepository extends JpaRepository<Pv, Long> {

    List<Pv> getAllByFilierAndSemesterAndModule(String filiere, String semestre, String module);
    List<Pv> getByEtudiants(Etudiant etudiants);

    List<Pv> getBySurveillants(Surveillant surveillant);

    Pv findById(long id);

    //@Query(value = "select p from Pv p join p.etudiants e where p.etudiants = e and e=?1")
    //List<Pv> getEtudian(Etudiant etudiants);

}
