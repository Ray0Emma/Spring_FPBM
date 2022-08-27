package com.example.fpbm.services.PvServices;

import com.example.fpbm.components.UploadUtil;
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
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Surveillant> surveillants=getFreeSurveillant(time);
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

    @Override
    public List<Surveillant> getFreeSurveillant(String time) {
        List<Surveillant> surveillants=surveillantService.fetchAllSurveillant();
        List<Surveillant> surveillantsOcup=surveillantRepository.getSurveillantOcup(time);

        List<Surveillant> surveillantsFree =new ArrayList<>();

        for (int i = 0; i < surveillants.size(); i++) {

            Boolean isEptey=true;
            Long surveillantid = surveillants.get(i).getId();
            //System.out.println("totale salle id: "+salleid);
            for (int j = 0; j < surveillantsOcup.size(); j++) {
                // System.out.println("salle occp id:"+salleOcup.get(j).getId());
                if (surveillantid==surveillantsOcup.get(j).getId()){
                    // System.out.println("bhal bhal");
                    isEptey=false;
                    //sallesFree.add(salles.get(j));
                }
            }
            if (isEptey){
                //System.out.println("salle empty");
                surveillantsFree.add(surveillants.get(i));
            }else {
                //System.out.println("salle not empty");
            }

        }

        return surveillantsFree;
    }

    @Override
    public List<Pv> generatePvs(String filiere, String semestre, String module, String time) {
        List<Pv> pvsResult = pvRepository.getAllByFilierAndSemesterAndModuleAndLocalDateTime(filiere,semestre,module,time);
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
    public List<Map<String, String>> convertXslToMap(MultipartFile file) throws Exception {
        Path tempDir = Files.createTempDirectory("");

        File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();

        file.transferTo(tempFile);

        Workbook workbook = WorkbookFactory.create(tempFile);

        Sheet sheet = workbook.getSheetAt(0);

        Supplier<Stream<Row>> rowStreamSupplier = uploadUtil.getRowStreamSupplier(sheet);

        Row headerRow = rowStreamSupplier.get().findFirst().get();

        List<String> headerCells = uploadUtil.getStream(headerRow)
                .map(Cell::getNumericCellValue)
                .map(String::valueOf)
                .collect(Collectors.toList());

        int colCount = headerCells.size();

        return rowStreamSupplier.get()
                .skip(1)
                .map(row -> {

                    List<String> cellList = uploadUtil.getStream(row)
                            .map(Cell::getStringCellValue)
                            .collect(Collectors.toList());

                    return uploadUtil.cellIteratorSupplier(colCount)
                            .get()
                            .collect(toMap(headerCells::get, cellList::get));
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Pv> xslToPvs(MultipartFile file) throws Exception {
        return null;
    }


}
