package com.example.fpbm.services.PvServices;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.modeles.Pv;

import java.util.List;

public interface PvService {
    List<Etudiant> getEtudiantsByFiliere(String f, String s, String m);
    List<Pv> makePv(String filiere, String semestre, String module);
}
