package com.example.fpbm.services.ExcelServices;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.services.entitiesServices.EtudiantService;
import com.example.fpbm.services.entitiesServices.FiliereService;
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

public class EtudiantExcelImport {
    private EtudiantService etudiantService;
    private FiliereService filiereService;

    public EtudiantExcelImport(EtudiantService etudiantService, FiliereService filiereService) {
        this.etudiantService = etudiantService;
        this.filiereService = filiereService;
    }

    public void importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            List<Etudiant> etudiants = new ArrayList<>();
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
//                        String email = row.getCell(0).getStringCellValue();
//                        String password = row.getCell(1).getStringCellValue();
//                        String address = row.getCell(2).getStringCellValue();
                        String cin = formatter.formatCellValue(row.getCell(1));
                        String cne = formatter.formatCellValue(row.getCell(5));
                        String myDate = String.valueOf(formatter.formatCellValue(row.getCell(4)));
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date birthdate =  sdf.parse(myDate);
                        String nom = row.getCell(2).getStringCellValue();
                        String prenom = row.getCell(3).getStringCellValue();
//                        String tel = formatter.formatCellValue(row.getCell(8));
                        String apogee = formatter.formatCellValue(row.getCell(0));
//                        long filiere= (long) row.getCell(10).getNumericCellValue();

                        Etudiant etudiant = new Etudiant();
//                        etudiant.setEmail(email);
//                        etudiant.setPassword(password);
//                        etudiant.setAddress(address);
                        etudiant.setCin(cin);
                        etudiant.setCne(cne);
                        etudiant.setDateDeNaissance(birthdate);
                        etudiant.setNom(nom);
                        etudiant.setPrenom(prenom);
//                        etudiant.setTelephone(tel);
                        etudiant.setNbApogee(apogee);
                        etudiant.setFiliere(filiereService.getFiliere(6L));

                        etudiants.add(etudiant);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            });

            if (!etudiants.isEmpty()) {
                // save to database
                etudiantService.saveAll(etudiants);
            }
        }
    }


    public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
        int numOfNonEmptyCells = 0;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
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
