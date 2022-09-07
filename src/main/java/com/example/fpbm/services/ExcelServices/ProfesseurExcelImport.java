package com.example.fpbm.services.ExcelServices;

import com.example.fpbm.entities.*;
import com.example.fpbm.services.entitiesServices.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfesseurExcelImport {
    private ProfesseurService professeurService;
    private FiliereService filiereService;

    private JuryService juryService;

    private LieuDeTravailService lieuDeTravailService;

    private ProfesseurHasModule professeurHasModule;

    private ExternService externService;

    private SurveillantService surveillantService;

    private SoutenanceService soutenanceService;


    public ProfesseurExcelImport(FiliereService filiereService, JuryService juryService, LieuDeTravailService lieuDeTravailService, ProfesseurHasModule professeurHasModule, ExternService externService, SurveillantService surveillantService, SoutenanceService soutenanceService) {
        this.filiereService = filiereService;
        this.juryService = juryService;
        this.lieuDeTravailService = lieuDeTravailService;
        this.professeurHasModule = professeurHasModule;
        this.externService = externService;
        this.surveillantService = surveillantService;
        this.soutenanceService = soutenanceService;
    }

    public void importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            List<Professeur> professeurs = new ArrayList<>();
            DataFormatter formatter = new DataFormatter();
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

                    XSSFSheet sheet = workBook.getSheetAt(0);
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) ; rowIndex++) {
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }
                        String email = row.getCell(0).getStringCellValue();
                        String password = row.getCell(1).getStringCellValue();
                        String address = row.getCell(2).getStringCellValue();
                        String cin = row.getCell(3).getStringCellValue();
                        String cne = row.getCell(4).getStringCellValue();
                        System.out.println(formatter.formatCellValue(row.getCell(5)));
                        String myDate = String.valueOf(formatter.formatCellValue(row.getCell(5)));
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date birthdate =  sdf.parse(myDate);
                        String nom = row.getCell(6).getStringCellValue();
                        String prenom = row.getCell(7).getStringCellValue();
                        String tel = formatter.formatCellValue(row.getCell(8));
                        String grade = formatter.formatCellValue(row.getCell(9));
                        Long lieudetravail= (long) row.getCell(10).getNumericCellValue();
                        Long extern= (long) row.getCell(11).getNumericCellValue();

                        Professeur professeur = new Professeur();
                        professeur.setEmail(email);
                        professeur.setPassword(password);
                        professeur.setAddress(address);
                        professeur.setCin(cin);
                        professeur.setCne(cne);
                        professeur.setDateDeNaissance(birthdate);
                        professeur.setNom(nom);
                        professeur.setPrenom(prenom);
                        professeur.setTelephone(tel);
                        professeur.setGrade(grade);
                        professeur.setLieuDeTravail(lieuDeTravailService.getLieuDeTravail(lieudetravail));
                        professeur.setExtern(externService.getExtern(extern));

                        professeurs.add(professeur);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            });

            if (!professeurs.isEmpty()) {
                // save to database
                professeurService.saveAll(professeurs);
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
