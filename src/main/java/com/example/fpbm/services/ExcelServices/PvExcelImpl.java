package com.example.fpbm.services.ExcelServices;

import com.example.fpbm.repositories.entitiesRepository.ExamenTimeRepository;
import com.example.fpbm.repositories.entitiesRepository.FiliereRepository;
import com.example.fpbm.repositories.entitiesRepository.ModuleRepository;
import com.example.fpbm.repositories.entitiesRepository.SemesterRepository;
import com.example.fpbm.services.PvServices.PvService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String genaratePvsFromExcel(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            var ref = new Object() {
                String result = "PVs created Successfully :)";
            };
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());
                    XSSFSheet sheet = workBook.getSheetAt(0);
                    String dateS = null;
                    String dateH = null;
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) ; rowIndex++) {
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }

                        String dateSessionRattrapage = row.getCell(0).getStringCellValue();
                        String filier = row.getCell(1).getStringCellValue();
                        // TODO: semester name is : S1_ISI :
                        String semestere = row.getCell(2).getStringCellValue()+"_"+filier;
                        String section = row.getCell(3).getStringCellValue();
                        String module = row.getCell(4).getStringCellValue();
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
                        System.out.println("4)-Module::::"+module+"::::::::::::::::::/n/n");
                        System.out.println("4)-Responsable de module::::"+responsableDeModule+"::::::::::::::::::/n/n");
                        System.out.println("4)-Heur::::"+heur+"::::::::::::::::::/n/n");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!! End of Result"+ filiereRepository.findByName(filier)+" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        // TODO: all info above showld be existe in db not hir :::
                        if (filiereRepository.findByName(filier) == null || semesterRepository.findByName(semestere)== null || moduleRepository.findByName(module) == null || examenTimeRepository.findByTime(heur) == null){
                            System.out.println("Data NOT FOUND !! For index"+rowIndex+"::: Check the null value !!!");
                            System.out.println("Filier : "+filier+":::::::::::::"+filiereRepository.findByName(filier)+" ::::::::::::::::::");
                            System.out.println("Module : "+module+":::::::::::::"+moduleRepository.findByName(module)+" ::::::::::::::::::");
                            System.out.println("Heur : "+heur+":::::::::::::"+examenTimeRepository.findByTime(heur)+"::::::::::::::::::");
                            System.out.println("Semister : "+semestere+":::::::::::::"+semesterRepository.findByName(semestere)+"::::::::::::::::::");
                            ref.result = "Data NOT FOUND ::: For row index "+rowIndex+" ::: Check the null value !!!";
                            return;
                        }
                        pvService.generatePvs(filier,semestere,module,heur);
                        System.out.println("::::::::::::::::: PV index :=> "+rowIndex+" Generated <=:::::::::::::::::::::::::::::::");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    ref.result = e.getMessage();
                    return;
                }
            });
            return ref.result;
        }
        return "file is Empty !";
    }

    public String genaratePvsFromExcel2(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            var ref = new Object() {
                String result = "PVs created Successfully :)";
            };
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());
                    XSSFSheet sheet = workBook.getSheetAt(0);
                    String dateS = null;
                    String dateH = null;
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) ; rowIndex++) {
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }

                        String dateSessionRattrapage = row.getCell(0).getStringCellValue();
                        String filier = row.getCell(1).getStringCellValue();
                        // TODO: semester name is : S1_ISI :
                        String semestere = row.getCell(2).getStringCellValue()+"_"+filier;
                        String section = row.getCell(3).getStringCellValue();
                        String module = row.getCell(4).getStringCellValue();
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
                        System.out.println("4)-Module::::"+module+"::::::::::::::::::/n/n");
                        System.out.println("4)-Responsable de module::::"+responsableDeModule+"::::::::::::::::::/n/n");
                        System.out.println("4)-Heur::::"+heur+"::::::::::::::::::/n/n");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!! End of Result"+ filiereRepository.findByName(filier)+" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        // TODO: all info above showld be existe in db not hir :::
                        if (filiereRepository.findByName(filier) == null || semesterRepository.findByName(semestere)== null || moduleRepository.findByName(module) == null || examenTimeRepository.findByTime(heur) == null){
                            System.out.println("Data NOT FOUND !! For index"+rowIndex+"::: Check the null value !!!");
                            System.out.println("Filier : "+filier+":::::::::::::"+filiereRepository.findByName(filier)+" ::::::::::::::::::");
                            System.out.println("Module : "+module+":::::::::::::"+moduleRepository.findByName(module)+" ::::::::::::::::::");
                            System.out.println("Heur : "+heur+":::::::::::::"+examenTimeRepository.findByTime(heur)+"::::::::::::::::::");
                            System.out.println("Semister : "+semestere+":::::::::::::"+semesterRepository.findByName(semestere)+"::::::::::::::::::");
                            ref.result = "Data NOT FOUND ::: For row index "+rowIndex+" ::: Check the null value !!!";
                            return;
                        }
                        pvService.generatePvs2(filier,semestere,module,heur,dateSessionRattrapage);
                        System.out.println("::::::::::::::::: PV index :=> "+rowIndex+" Generated <=:::::::::::::::::::::::::::::::");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    ref.result = e.getMessage();
                    return;
                }
            });
            return ref.result;
        }
        return "file is Empty !";
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
