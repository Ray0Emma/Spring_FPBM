package com.example.fpbm.services.ExcelServices;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.repositories.entitiesRepository.EtudiantRepository;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelDataServiceImpl implements IExcelDataService{

    @Value("${app.upload.file:${user.home}}")
    public String EXCEL_FILE_PATH;

    @Autowired
    EtudiantRepository repo;

    Workbook workbook;

    @Override
    public List<Etudiant> getExcelDataAsList() {
        List<String> list = new ArrayList<String>();

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // Create the Workbook
        try {
            workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        // Retrieving the number of sheets in the Workbook
        System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Getting number of columns in the Sheet
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        System.out.println("-------Sheet has '"+noOfColumns+"' columns------");

        // Using for-each loop to iterate over the rows and columns
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                list.add(cellValue);
            }
        }

        // filling excel data and creating list as List<Invoice>
        List<Etudiant> etudiantList = createList(list, noOfColumns);

        // Closing the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return etudiantList;
    }

    private List<Etudiant> createList(List<String> excelData, int noOfColumns) {

        ArrayList<Etudiant> etudiantList = new ArrayList<Etudiant>();

        int i = noOfColumns;
        do {
            Etudiant etudiant = new Etudiant();

            etudiant.setNom(excelData.get(i));
            etudiant.setPrenom(excelData.get(i + 1));
            etudiant.setCin(excelData.get(i + 2));
            etudiant.setNbApogee(excelData.get(i + 3));
            etudiant.setCne(excelData.get(i + 4));
//            etudiant.setEtudiantCollectionFiliere(excelData.get(i + 3));

            etudiantList.add(etudiant);
            i = i + (noOfColumns);

        } while (i < excelData.size());
        return etudiantList;
    }

    @Override
    public int saveExcelData(List<Etudiant> etudiants) {
        etudiants = repo.saveAll(etudiants);
        return etudiants.size();
    }
}
