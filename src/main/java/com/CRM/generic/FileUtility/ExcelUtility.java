package com.CRM.generic.FileUtility;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
    public String getDataFromExcel(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
    	FileInputStream fis = new FileInputStream("./configAppData/details.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
    	wb.close();
    	return data;
    }
    public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
    	FileInputStream fis = new FileInputStream("./configAppData/details.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	int rownum = wb.getSheet(sheetname).getLastRowNum();
    	wb.close();
    	return rownum;
    }
    public void setDataIntoExcel(String sheetname, int row, int cell) throws IOException {
    	FileInputStream fis = new FileInputStream("./configAppData/excel.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	wb.getSheet(sheetname).getRow(row).createCell(cell);
    	FileOutputStream fos = new FileOutputStream("./configAppData/excel.xlsx");
    	wb.write(fos);
    	wb.close();
    }
}
