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

     List<Salle> getFreeSalle(String time);

    List<Surveillant> getFreeSurveillant(String time);

    List<Pv> generatePvs(String filiere, String semestre, String module, String time);

    List<Map<String,String>> convertXslToMap(MultipartFile file) throws Exception;

    List<Pv> xslToPvs(MultipartFile file)throws Exception;

    List<Pv> getPvByEtudient(String etudiantCin);

}
