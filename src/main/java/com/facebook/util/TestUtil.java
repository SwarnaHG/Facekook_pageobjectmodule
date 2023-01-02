package com.facebook.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.logging.FileHandler;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.facebook.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH ="C:\\Users\\punit\\eclipse-workspace\\facebookpom\\src\\main\\java\\com\\facebook\\testdata\\logindata.xlsx";

	static Workbook book;
	static Sheet sheet;

	

	public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
	file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	try {
	book = WorkbookFactory.create(file);
	} catch (IOException e) {
	e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
	for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	}

	}
	return data;


	}

	
	public void failedTest(String fname) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\punit\\eclipse-workspace\\facebookpom\\Screenshots\\" + fname +".png");
		FileHandler.copy(source,destination);
		}


}
