package com.example.fpbm.services.ExcelServices;

import com.example.fpbm.entities.Professeur;
import com.example.fpbm.modeles.Pv;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    public void importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            List<Pv> pvs = new ArrayList<>();
            DataFormatter formatter = new DataFormatter();
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

                    XSSFSheet sheet = workBook.getSheetAt(0);
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) ; rowIndex++) {
                        Pv pv = new Pv();
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }
                        String dateSessionRattrapage = row.getCell(0).getStringCellValue();
                        String filier = row.getCell(1).getStringCellValue();
                        String semester = row.getCell(2).getStringCellValue();
                        String section = row.getCell(3).getStringCellValue();
                        String module = row.getCell(4).getStringCellValue();
                        String responsableDeModule = row.getCell(5).getStringCellValue();
                        String heur = row.getCell(6).getStringCellValue();
                        System.out.println("::::::::::::::::: Result index :"+rowIndex+":::::::::::::::::::::::::::::");
                        System.out.println("0)-Session Date::::"+dateSessionRattrapage+"::::::::::::::::::/n/n");
                        System.out.println("1)-Filier::::"+filier+"::::::::::::::::::/n/n");
                        System.out.println("2)-Semester::::"+semester+"::::::::::::::::::/n/n");
                        System.out.println("3)-Section::::"+section+"::::::::::::::::::/n/n");
                        System.out.println("4)-Module::::"+module+"::::::::::::::::::/n/n");
                        System.out.println("4)-Responsable de module::::"+responsableDeModule+"::::::::::::::::::/n/n");
                        System.out.println("4)-Heur::::"+heur+"::::::::::::::::::/n/n");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!! End of Result !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        pvs.add(pv);

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
