package com.example.fpbm.services.ExcelServices;

import com.example.fpbm.entities.ExamenTime;
import com.example.fpbm.entities.Filiere;
import com.example.fpbm.entities.Module;
import com.example.fpbm.entities.Professeur;
import com.example.fpbm.entities.Semester;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.repositories.ExamenTimeRepository;
import com.example.fpbm.repositories.FiliereRepository;
import com.example.fpbm.repositories.ModuleRepository;
import com.example.fpbm.repositories.SemesterRepository;
import com.example.fpbm.services.PvServices.PvService;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PvExcelImpl {

    @Autowired
    private PvService pvService;
    @Autowired
    private ExamenTimeRepository examenTimeRepository;
    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    public void importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            List<Pv> pvs = new ArrayList<>();
            DataFormatter formatter = new DataFormatter();
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

                    XSSFSheet sheet = workBook.getSheetAt(0);
                    String dateS = null;
                    String dateH = null;
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) ; rowIndex++) {

                        ExamenTime examenTime = new ExamenTime();
                        Filiere filiere = new Filiere();
                        Semester semester = new Semester();
                        Module module = new Module();
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }

                        String dateSessionRattrapage = row.getCell(0).getStringCellValue();
                        String filier = row.getCell(1).getStringCellValue();
                        String semestere = row.getCell(2).getStringCellValue();
                        String section = row.getCell(3).getStringCellValue();
                        String modulee = row.getCell(4).getStringCellValue();
                        String responsableDeModule = row.getCell(5).getStringCellValue();
                        String heur = row.getCell(6).getStringCellValue();
                        if (!dateSessionRattrapage.isEmpty()){
                            dateS = dateSessionRattrapage;
                        }
                        if (dateSessionRattrapage.isEmpty()){
                            dateSessionRattrapage = dateS;
                        }
                        if (!heur.isEmpty()){
                            dateH = heur;
                        }
                        if (heur.isEmpty()){
                            heur = dateH;
                        }
                        System.out.println("::::::::::::::::: Result index :"+rowIndex+":::::::::::::::::::::::::::::");
                        System.out.println("0)-Session Date::::"+dateSessionRattrapage+"::::::::::::::::::/n/n");
                        System.out.println("1)-Filier::::"+filier+"::::::::::::::::::/n/n");
                        System.out.println("2)-Semester::::"+semestere+"::::::::::::::::::/n/n");
                        System.out.println("3)-Section::::"+section+"::::::::::::::::::/n/n");
                        System.out.println("4)-Module::::"+modulee+"::::::::::::::::::/n/n");
                        System.out.println("4)-Responsable de module::::"+responsableDeModule+"::::::::::::::::::/n/n");
                        System.out.println("4)-Heur::::"+heur+"::::::::::::::::::/n/n");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!! End of Result !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        // TODO: all info above showld be existe in db not hir :::
                        if (filiereRepository.findByName(filier).toString().isEmpty() || semesterRepository.findByName(semestere).toString().isEmpty() || moduleRepository.findByName(modulee).toString().isEmpty() || examenTimeRepository.findByTime(heur).toString().isEmpty()){
                            System.out.println(":::::::::::::"+filiereRepository.findByName(filier)+" ::::::::::::::::::");
                            System.out.println(":::::::::::::"+moduleRepository.findByName(modulee)+" ::::::::::::::::::");
                            System.out.println(":::::::::::::"+examenTimeRepository.findByTime(heur)+"::::::::::::::::::");
                            System.out.println(":::::::::::::"+semesterRepository.findByName(semestere)+"::::::::::::::::::");
                            return;
                        }
                        /*filiere.setName(filier);
                        semester.setName(semestere);
                        semester.setFiliere(filiere);
                        module.setName(modulee);
                        module.setSemester(semester);

                        filiereRepository.save(filiere);
                        semesterRepository.save(semester);
                        moduleRepository.save(module);*/
                        // TODO: AND ::::
                        pvService.generatePvs(filier,semestere,modulee,heur);
                        System.out.println("::::::::::::::::: PV index Generated :"+rowIndex+":::::::::::::::::::::::::::::");


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            if (!pvs.isEmpty()) {
                // save to database
                System.out.println("Succes !!!!");
            }
        }
    }
    public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
        int numOfNonEmptyCells = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell cell = row.getCell(columnIndex);
                if (cell != null) {
                    numOfNonEmptyCells++;
                }
            }
        }
        return numOfNonEmptyCells;
    }
}
