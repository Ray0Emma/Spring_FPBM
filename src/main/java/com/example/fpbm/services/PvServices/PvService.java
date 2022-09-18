package com.example.fpbm.services.PvServices;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.Salle;
import com.example.fpbm.entities.Surveillant;
import com.example.fpbm.modeles.Pv;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface PvService {
    List<Etudiant> getEtudiantsByFiliere(String f, String s, String m);
    List<Pv> getAllPv();
    List<Pv> makePv(String filiere, String semestre, String module, String time);

    List<Pv> makePv2(String filiere, String semestre, String module, String time, String date);
    Pv findById(long id);

    List<Pv> generatePvs(String filiere, String semestre, String module, String time);

    List<Pv> generatePvs2(String filiere, String semestre, String module, String time, String date);
    List<Pv> getPvByEtudient(String etudiantCin);

    List<Pv> getPvBySurveillant(Long surveillantId);

}
