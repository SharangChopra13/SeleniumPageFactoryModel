package utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadExcel {

    @DataProvider(name = "getExcelData")
    public Object[][] readExcel(Method method) throws IOException {
        //this will get the name of method where we will be calling this data provider
        //So have to keep the sheet name same as method name where we will be using it
        String excelSheetName = method.getName();
        File file = new File(System.getProperty("user.dir")+"/src/test/testData/testdata.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);
        // will store total number of rows
        int totalRows = sheetName.getLastRowNum();
        //will store total number of cells in a row
        Row rowCells = sheetName.getRow(0);
        //will store total number of columns
       int totalCols = rowCells.getLastCellNum();

        DataFormatter format = new DataFormatter();

        Object [][] testData = new Object [totalRows][totalCols];
        for (int i=1; i <=totalRows;i++){
            for (int j =0; j<totalCols; j++){
                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
            }
        }
        System.out.println(testData);
        return testData;
    }
}
