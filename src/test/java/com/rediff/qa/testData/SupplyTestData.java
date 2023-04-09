package com.rediff.qa.testData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SupplyTestData {
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	//this one is for regular thing if you want to do  
	@DataProvider(name = "RediffDataProviderSupply")
	public static Object[][] dataSupplyFrom2DimensionalObjectArray() {

		Object[][] data = { { "seleniumpanda@rediffmail.com", "Selenium@123" },
				{ "Mohamedboudgui@rediffmail.com", "Medbdgo7o7@" }, 
				{ "seleniumpanda1@rediffmail.com", "Donkey@123" },
				{ "seleniumpanda3@rediffmail.com", "monday1234" } };

		return data;
	}
	
	//this is for purely dominant for excel sheet
	@DataProvider(name = "RediffExcelDataWithDataProvider")
	public static Object[][] excelSheetDataSupply() throws Exception {
		Object[][]data = SupplyTestData.getRediffTestDataFromExcelSheet("Login");
		return data;
	}

	public static Object[][] getRediffTestDataFromExcelSheet(String sheetName) throws Exception {
		// step 1- you have to create the object of FileInputStream
		ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\rediff\\qa\\testData\\RediffTestData.xlsx");

		// step 2 - you have to create the object of XSSFWorkbook
		workbook = new XSSFWorkbook(ip);

		// step 3- XSSFSheet
		sheet = workbook.getSheet(sheetName);

		// step 4 = you have to determine number of rows and cols
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j]= Integer.toString((int) cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;

	}
}
