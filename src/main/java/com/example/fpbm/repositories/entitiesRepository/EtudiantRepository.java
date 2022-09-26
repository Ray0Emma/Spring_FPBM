package com.example.fpbm.repositories.entitiesRepository;

import com.example.fpbm.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    @Query("select e from Etudiant e join e.filiere f join f.semesters s join s.modules m where f.name=?1 and s.name=?2 and m.name=?3 ")
    List<Etudiant> getEtudiantsByFiliere(String f, String s, String m);

    Etudiant getEtudiantByCin(String cin);

    @Query("select e from Etudiant e join e.etudiantHasModules ex where ex.module.name=:name")
    public List<Etudiant> getEtudiantByModule(@PathVariable(name = "name") String name);


}
