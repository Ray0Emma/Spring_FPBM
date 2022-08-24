package com.example.fpbm.services.PvServices;

import com.example.fpbm.entities.*;
import com.example.fpbm.entities.Module;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.repositories.EtudiantRepository;
import com.example.fpbm.repositories.FiliereRepository;
import com.example.fpbm.repositories.ModuleRepository;
import com.example.fpbm.repositories.SemesterRepository;
import com.example.fpbm.repositories.pvRepository.PvRepository;
import com.example.fpbm.repositories.*;
import com.example.fpbm.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PvServiceImp implements PvService{
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private SurveillantService surveillantService;
    @Autowired
    private SalleService salleService;

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private SemesterService semestreService;
    @Autowired
    private ModuleService moduleService;

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private PvRepository pvRepository;

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private ExamenTimeRepository examenTimeRepository;



    @Override
    public List<Etudiant> getEtudiantsByFiliere(String f, String s, String m) {
        return etudiantRepository.getEtudiantsByFiliere(f,s, m);
    }

    @Override
    public List<Pv> getAllPv() {
        return pvRepository.findAll();
    }

    @Override
    public List<Pv> makePv(String filiere, String semestre, String module, String time) {
        int nbEtudiantsCourants=0;
        int nbSurveillantsCourants=0;

        Filiere f=  filiereRepository.findByName(filiere);
        Semester s= semesterRepository.findByName(semestre);
        Module m= moduleRepository.findByName(module);
        List<Salle> salles=getFreeSalle(time);
        ExamenTime examenTime = examenTimeRepository.findByTime(time);
        System.out.println("time: "+examenTime.getTime());
        List<Pv> pvs=new ArrayList<Pv>();
        List<Surveillant> surveillants=surveillantService.getSurveillantNames();
        System.out.println(f.getName()+"   "+s.getName()+"  "+m.getName());
        List<Etudiant> etudiants=etudiantService.getEtudiantsByFiliere(f.getName(), s.getName(),m.getName());

        //Le nombre d'etudiants qui pas encore affecter à une salle d'examen
        int restEtud=etudiants.size();
        // indice de la salle dans la base
        int index=0;

        //Le nombre des Surveillants qui pas encore affecter à une salle d'examen
        //int restSurveillants=surveillants.size();

        // rest sale
        int restSalles = salles.size();

        // time list
        List<ExamenTime> timeList = new ArrayList<>();
        timeList.add(examenTime);

        while(restEtud>0 && restSalles>0 ){

            Pv pv = new Pv();
            pv.setLocal(salles.get(index).getName());

            pv.setModule(m.getName());
            pv.setFilier(f.getName());
            pv.setSemester(s.getName());
            pv.setLocalDateTime(time);
            //distrubier les etudiants dans les salles disponibles
            if(restEtud>salles.get(index).getCapaciteEtudiant()){
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants, (int) (salles.get(index).getCapaciteEtudiant()+nbEtudiantsCourants)));
                List<Etudiant> etuds = etudiants.subList(nbEtudiantsCourants, (int) (salles.get(index).getCapaciteEtudiant()+nbEtudiantsCourants));
                nbEtudiantsCourants+=salles.get(index).getCapaciteEtudiant();
                System.out.println("salle id"+salles.get(index).getId());
                System.out.println("salle time"+salles.get(index).getExamenTimes());
                System.out.println("list time"+timeList);
                salles.get(index).setExamenTimes(timeList);
                salleService.updateSalle(salles.get(index),salles.get(index).getId());
                System.out.println("salle time 2"+salles.get(index).getExamenTimes());
                for (Etudiant et:etuds
                     ) {
                    et.setPv(pv);
                }

            }else{
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants,etudiants.size()));
                List<Etudiant> etuds = etudiants.subList(nbEtudiantsCourants,etudiants.size());
                salles.get(index).setExamenTimes(timeList);
                salleService.updateSalle(salles.get(index),salles.get(index).getId());
                System.out.println("or salle id"+salles.get(index).getId());
                for (Etudiant et:etuds
                ) {
                    et.setPv(pv);
                }
            }
            //distrubier les surveillants dans les salles disponibles
            /*if(restSurveillants>salles.get(index).getNombreSurveillant()){
                pv.setSurveillants(surveillants.subList(nbSurveillantsCourants, (salles.get(index).getNombreSurveillant()+nbSurveillantsCourants)));
                nbSurveillantsCourants+=salles.get(index).getNombreSurveillant();
            }
            else{
                pv.setSurveillants(surveillants.subList(nbSurveillantsCourants,surveillants.size()));

            }

             */



            //restSurveillants-=salles.get(index).getNombreSurveillant();
            restEtud -=salles.get(index).getCapaciteEtudiant();
            restSalles-= 1;
            //restSurveillants -= salles.get(index).getNombreSurveillant();

            index++;

            pvs.add(pv);
            pvRepository.save(pv);
        }
        //si les salles ne sont pas suffisantes
        if(restEtud>0){
            System.out.println("affecter : "+restEtud+" étudinats à la salle X sont: "+etudiants.subList(nbEtudiantsCourants,etudiants.size()));
        }
        return pvs;
    }

    @Override
    public List<Salle> getFreeSalle(String time) {
        List<Salle> salles=salleService.fetchAllSalle();
        List<Salle> salleOcup=salleRepository.demandeDocByPersonne(time);

        List<Salle> sallesFree =new ArrayList<>();

        for (int i = 0; i < salles.size(); i++) {

            Boolean isEptey=true;
            Long salleid = salles.get(i).getId();
            //System.out.println("totale salle id: "+salleid);
            for (int j = 0; j < salleOcup.size(); j++) {
               // System.out.println("salle occp id:"+salleOcup.get(j).getId());
                if (salleid==salleOcup.get(j).getId()){
                   // System.out.println("bhal bhal");
                    isEptey=false;
                    //sallesFree.add(salles.get(j));
                }
            }
            if (isEptey){
                //System.out.println("salle empty");
                sallesFree.add(salles.get(i));
            }else {
                //System.out.println("salle not empty");
            }

        }

        return sallesFree;
    }
}
