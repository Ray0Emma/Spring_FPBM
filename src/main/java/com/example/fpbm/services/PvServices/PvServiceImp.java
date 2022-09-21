package com.example.fpbm.services.PvServices;

import com.example.fpbm.components.UploadUtil;
import com.example.fpbm.entities.*;
import com.example.fpbm.entities.Module;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.repositories.entitiesRepository.*;
import com.example.fpbm.repositories.pvRepository.PvRepository;
import com.example.fpbm.services.entitiesServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toMap;

@Service
public class PvServiceImp implements PvService{
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private SurveillantService surveillantService;
    @Autowired
    private SalleService salleService;

    @Autowired
    private UploadUtil uploadUtil;

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

    @Autowired
    private SurveillantRepository surveillantRepository;
    @Autowired
    private OrderedPvsService orderedPvsService;



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

        ExamenTime examenTime = examenTimeRepository.findByTime(time);
        List<Salle> salles=salleRepository.getAllByExamenTimesNotContains(examenTime);
        if (f == null || s== null || m == null || examenTime == null || salles == null){
            System.out.println("Data NOT FOUND !! For index::: Check the null value !!!");
            System.out.println("Filier : "+f+":::::::::::::"+filiere+" ::::::::::::::::::");
            System.out.println("Module : "+m+":::::::::::::"+module+" ::::::::::::::::::");
            System.out.println("Heur : "+examenTime+":::::::::::::"+time+"::::::::::::::::::");
            System.out.println("Semister : "+s+":::::::::::::"+semestre+"::::::::::::::::::");
            System.out.println("Semister : "+salles+":::::::::::::"+salles+"::::::::::::::::::");
            //ref.result = "Data NOT FOUND ::: For row index  ::: Check the null value !!!";
            return null;
        }

        System.out.println("time: "+examenTime.getTime());
        List<Pv> pvs=new ArrayList<Pv>();
        List<Surveillant> surveillants= surveillantRepository.getAllByExamenTimesNotContains(examenTime);
        System.out.println(f.getName()+"   "+s.getName()+"  "+m.getName());
        List<Etudiant> etudiants=etudiantService.getEtudiantsByFiliere(f.getName(), s.getName(),m.getName());

        //Le nombre d'etudiants qui pas encore affecter à une salle d'examen
        int restEtud=etudiants.size();
        // indice de la salle dans la base
        int index=0;

        //Le nombre des Surveillants qui pas encore affecter à une salle d'examen
        int restSurveillants=surveillants.size();

        // rest sale
        int restSalles = salles.size();

        // time list
        List<ExamenTime> timeList = new ArrayList<>();
        timeList.add(examenTime);
        AtomicLong order = new AtomicLong(1);
        
        while(restEtud>0 && restSalles>0 ){

            Pv pv = new Pv();

            //ExamenTime examenTime1 = new ExamenTime();

            pv.setLocal(salles.get(index).getName());
            pv.setModule(m.getName());
            pv.setFilier(f.getName());
            pv.setSemester(s.getName());
            pv.setLocalDateTime(time);
            //distrubier les etudiants dans les salles disponibles
            if(restEtud>salles.get(index).getCapaciteEtudiant()){
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants, (int) (salles.get(index).getCapaciteEtudiant()+nbEtudiantsCourants)));

                nbEtudiantsCourants+=salles.get(index).getCapaciteEtudiant();
                List<ExamenTime> examenTimes = examenTimeRepository.getSalleTimes(salles.get(index).getId());
                examenTimes.add(examenTime);
                salles.get(index).setExamenTimes(examenTimes);
                salleService.updateSalle(salles.get(index),salles.get(index).getId());


            }else{
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants,etudiants.size()));
                List<ExamenTime> examenTimes = examenTimeRepository.getSalleTimes(salles.get(index).getId());
                examenTimes.add(examenTime);
                salles.get(index).setExamenTimes(examenTimes);
                salleService.updateSalle(salles.get(index),salles.get(index).getId());
            }
            //distrubier les surveillants dans les salles disponibles

            if (restSurveillants>0){
                if(restSurveillants>salles.get(index).getNombreSurveillant()){
                    pv.setSurveillants(surveillants.subList(nbSurveillantsCourants, (salles.get(index).getNombreSurveillant()+nbSurveillantsCourants)));
                    List<Surveillant> surveillantList =surveillants.subList(nbSurveillantsCourants, (salles.get(index).getNombreSurveillant()+nbSurveillantsCourants));
                    for (Surveillant sv: surveillantList
                         ) {
                        List<ExamenTime> times = examenTimeRepository.getSurveillantTimes(sv.getId());
                        times.add(examenTime);
                        sv.setExamenTimes(times);
                        surveillantService.updateSurveillant(sv,sv.getId());
                    }
                    nbSurveillantsCourants+=salles.get(index).getNombreSurveillant();
                }
                else{
                    pv.setSurveillants(surveillants.subList(nbSurveillantsCourants,surveillants.size()));
                    List<Surveillant> surveillantList =surveillants.subList(nbSurveillantsCourants,surveillants.size());
                    for (Surveillant sv: surveillantList
                    ) {
                        List<ExamenTime> times = examenTimeRepository.getSurveillantTimes(sv.getId());
                        times.add(examenTime);
                        sv.setExamenTimes(times);
                        surveillantService.updateSurveillant(sv,sv.getId());
                    }
                    nbSurveillantsCourants+=salles.get(index).getNombreSurveillant();

                }
            }else {
                pv.setSurveillants(null);

            }
            restSurveillants-=salles.get(index).getNombreSurveillant();
            restEtud -=salles.get(index).getCapaciteEtudiant();
            restSalles-= 1;
            restSurveillants -= salles.get(index).getNombreSurveillant();

            index++;

            pvs.add(pv);
            pvRepository.save(pv);
            System.out.println("PV id :::::::::"+pv.getId()+"::::::::::::::::::::::::");



            pv.getEtudiants().forEach(etudiant -> {
                OrderedPvs orderedPvs = new OrderedPvs();
                orderedPvs.setPv(pv);
                orderedPvs.setEtudiant(etudiant);
                orderedPvs.setEtudientOrder(order.get());
                orderedPvsService.saveOrderPv(orderedPvs);
                order.getAndIncrement();

            });

        }
        //si les salles ne sont pas suffisantes
        if(restEtud>0){
            System.out.println("affecter : "+restEtud+" étudinats à la salle X sont: "+etudiants.subList(nbEtudiantsCourants,etudiants.size()));
        }
        return pvs;
    }

    @Override
    public List<Pv> makePv2(String filiere, String semestre, String module, String heur, String date) {
        int nbEtudiantsCourants=0;
        int nbSurveillantsCourants=0;
        String time = heur+"_"+date;
        if (examenTimeRepository.findByTime(time)== null){
            ExamenTime time1 = new ExamenTime();
            time1.setTime(time);
            examenTimeRepository.save(time1);
        }

        Filiere f=  filiereRepository.findByName(filiere);
        Semester s= semesterRepository.findByName(semestre);
        Module m= moduleRepository.findByName(module);

        ExamenTime examenTime = examenTimeRepository.findByTime(time);
        List<Salle> salles=salleRepository.getAllByExamenTimesNotContains(examenTime);
        if (f == null || s== null || m == null || examenTime == null || salles == null){
            System.out.println("Data NOT FOUND !! For index::: Check the null value !!!");
            System.out.println("Filier : "+f+":::::::::::::"+filiere+" ::::::::::::::::::");
            System.out.println("Module : "+m+":::::::::::::"+module+" ::::::::::::::::::");
            System.out.println("Heur : "+examenTime+":::::::::::::"+time+"::::::::::::::::::");
            System.out.println("Semister : "+s+":::::::::::::"+semestre+"::::::::::::::::::");
            System.out.println("Semister : "+salles+":::::::::::::"+salles+"::::::::::::::::::");
            //ref.result = "Data NOT FOUND ::: For row index  ::: Check the null value !!!";
            return null;
        }

        System.out.println("time: "+examenTime.getTime());
        List<Pv> pvs=new ArrayList<Pv>();
        List<Surveillant> surveillants= surveillantRepository.getAllByExamenTimesNotContains(examenTime);
        System.out.println(f.getName()+"   "+s.getName()+"  "+m.getName());
        List<Etudiant> etudiants=etudiantService.getEtudiantsByFiliere(f.getName(), s.getName(),m.getName());

        //Le nombre d'etudiants qui pas encore affecter à une salle d'examen
        int restEtud=etudiants.size();
        // indice de la salle dans la base
        int index=0;

        //Le nombre des Surveillants qui pas encore affecter à une salle d'examen
        int restSurveillants=surveillants.size();

        // rest sale
        int restSalles = salles.size();

        // time list
        List<ExamenTime> timeList = new ArrayList<>();
        timeList.add(examenTime);
        AtomicLong order = new AtomicLong(1);

        while(restEtud>0 && restSalles>0 ){

            Pv pv = new Pv();

            //ExamenTime examenTime1 = new ExamenTime();

            pv.setLocal(salles.get(index).getName());
            pv.setModule(m.getName());
            pv.setFilier(f.getName());
            pv.setSemester(s.getName());
            pv.setLocalDateTime(heur);
            pv.setLocalDate(date);
            //distrubier les etudiants dans les salles disponibles
            if(restEtud>salles.get(index).getCapaciteEtudiant()){
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants, (int) (salles.get(index).getCapaciteEtudiant()+nbEtudiantsCourants)));

                nbEtudiantsCourants+=salles.get(index).getCapaciteEtudiant();
                List<ExamenTime> examenTimes = examenTimeRepository.getSalleTimes(salles.get(index).getId());
                examenTimes.add(examenTime);
                salles.get(index).setExamenTimes(examenTimes);
                salleService.updateSalle(salles.get(index),salles.get(index).getId());


            }else{
                pv.setEtudiants(etudiants.subList(nbEtudiantsCourants,etudiants.size()));
                List<ExamenTime> examenTimes = examenTimeRepository.getSalleTimes(salles.get(index).getId());
                examenTimes.add(examenTime);
                salles.get(index).setExamenTimes(examenTimes);
                salleService.updateSalle(salles.get(index),salles.get(index).getId());
            }
            //distrubier les surveillants dans les salles disponibles

            if (restSurveillants>0){
                if(restSurveillants>salles.get(index).getNombreSurveillant()){
                    pv.setSurveillants(surveillants.subList(nbSurveillantsCourants, (salles.get(index).getNombreSurveillant()+nbSurveillantsCourants)));
                    List<Surveillant> surveillantList =surveillants.subList(nbSurveillantsCourants, (salles.get(index).getNombreSurveillant()+nbSurveillantsCourants));
                    for (Surveillant sv: surveillantList
                    ) {
                        List<ExamenTime> times = examenTimeRepository.getSurveillantTimes(sv.getId());
                        times.add(examenTime);
                        sv.setExamenTimes(times);
                        surveillantService.updateSurveillant(sv,sv.getId());
                    }
                    nbSurveillantsCourants+=salles.get(index).getNombreSurveillant();
                }
                else{
                    pv.setSurveillants(surveillants.subList(nbSurveillantsCourants,surveillants.size()));
                    List<Surveillant> surveillantList =surveillants.subList(nbSurveillantsCourants,surveillants.size());
                    for (Surveillant sv: surveillantList
                    ) {
                        List<ExamenTime> times = examenTimeRepository.getSurveillantTimes(sv.getId());
                        times.add(examenTime);
                        sv.setExamenTimes(times);
                        surveillantService.updateSurveillant(sv,sv.getId());
                    }
                    nbSurveillantsCourants+=salles.get(index).getNombreSurveillant();

                }
            }else {
                pv.setSurveillants(null);

            }
            restSurveillants-=salles.get(index).getNombreSurveillant();
            restEtud -=salles.get(index).getCapaciteEtudiant();
            restSalles-= 1;
            restSurveillants -= salles.get(index).getNombreSurveillant();

            index++;

            pvs.add(pv);
            pvRepository.save(pv);
            System.out.println("PV id :::::::::"+pv.getId()+"::::::::::::::::::::::::");



            pv.getEtudiants().forEach(etudiant -> {
                OrderedPvs orderedPvs = new OrderedPvs();
                orderedPvs.setPv(pv);
                orderedPvs.setEtudiant(etudiant);
                orderedPvs.setEtudientOrder(order.get());
                orderedPvsService.saveOrderPv(orderedPvs);
                order.getAndIncrement();

            });

        }
        //si les salles ne sont pas suffisantes
        if(restEtud>0){
            System.out.println("affecter : "+restEtud+" étudinats à la salle X sont: "+etudiants.subList(nbEtudiantsCourants,etudiants.size()));
        }
        return pvs;
    }

    @Override
    public Pv findById(long id) {
        return pvRepository.findById(id);
    }

    @Override
    public List<Pv> generatePvs(String filiere, String semestre, String module, String time) {
        List<Pv> pvsResult = pvRepository.getAllByFilierAndSemesterAndModule(filiere,semestre,module);
        if (!pvsResult.isEmpty()){
            System.out.println("I get an existe PV :::::::::::::");
            return pvsResult;
        }
        else {
            System.out.println("I get create new PV :::::::::::::");
            return makePv(filiere, semestre, module, time);
        }
    }

    @Override
    public List<Pv> generatePvs2(String filiere, String semestre, String module, String time, String date) {
        List<Pv> pvsResult = pvRepository.getAllByFilierAndSemesterAndModule(filiere,semestre,module);
        if (!pvsResult.isEmpty()){
            System.out.println("I get an existe PV :::::::::::::");
            return pvsResult;
        }
        else {
            System.out.println("I get create new PV :::::::::::::");
            return makePv2(filiere, semestre, module, time, date);
        }
    }

    @Override
    public List<Pv> getPvByEtudient(String etudiantCin) {
        Etudiant etudiant = etudiantService.getEtudientByCin(etudiantCin);
        return pvRepository.getByEtudiants(etudiant);
    }

    @Override
    public List<Pv> getPvBySurveillant(Long surveillantId) {
        Surveillant surveillant = surveillantService.fetchOneSurveillant(surveillantId);
        return pvRepository.getBySurveillants(surveillant);
    }


}
