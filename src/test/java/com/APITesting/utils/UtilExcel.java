package com.APITesting.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {


    static Workbook book;

    static Sheet sheet;

    public static String File_Name = "src/test/resources/TestDataSheet.xlsx";

    public static Object[][]getTestData(String sheetName){

        FileInputStream file = null;

        try{

            file = new FileInputStream(File_Name);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }
try{
    book= WorkbookFactory.create(file);


} catch (IOException e) {
    throw new RuntimeException(e);
}

sheet=book.getSheet(sheetName);
Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i <sheet.getLastRowNum() ; i++) {

            for (int j = 0; j <sheet.getRow(0).getLastCellNum() ; j++) {
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();

            }
            
        }
return data;
    }
@DataProvider

    public Object[][]getData(){

        return getTestData("Sheet1");
}
}
