package com.example.fpbm.services.PvServices;

import com.example.fpbm.entities.*;
import com.example.fpbm.entities.Module;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.repositories.EtudiantRepository;
import com.example.fpbm.repositories.FiliereRepository;
import com.example.fpbm.repositories.ModuleRepository;
import com.example.fpbm.repositories.SemesterRepository;
import com.example.fpbm.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    @Override
    public List<Etudiant> getEtudiantsByFiliere(String f, String s, String m) {
        return etudiantRepository.getEtudiantsByFiliere(f,s, m);
    }

    public List<Pv> makePv(String filiere,String semestre, String module){
        int nbEtudiantsCourants=0;
        int nbSurveillantsCourants=0;

        Filiere f=  filiereRepository.findByName(filiere);
        Semester s= semesterRepository.findByName(semestre);
        Module m= moduleRepository.findByName(module);
        List<Salle> salles=salleService.fetchAllSalle();
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

        while(restEtud>0 && restSalles>0 ){

            Pv pv=new Pv();
            pv.setLocal(salles.get(index).getName());

            pv.setModule(m.getName());
            //distrubier les etudiants dans les salles disponibles
            if(restEtud>salles.get(index).getCapaciteEtudiant()){
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants, (int) (salles.get(index).getCapaciteEtudiant()+nbEtudiantsCourants)));
                nbEtudiantsCourants+=salles.get(index).getCapaciteEtudiant();

            }else{
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants,etudiants.size()));

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



        }
        //si les salles ne sont pas suffisantes
        if(restEtud>0){
            System.out.println("affecter : "+restEtud+" étudinats à la salle X sont: "+etudiants.subList(nbEtudiantsCourants,etudiants.size()));
        }




        return pvs;



    }
}
