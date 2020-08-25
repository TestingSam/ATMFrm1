package DriverPkg;
import java.io.File;
import java.util.*;

import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {
	public static List<String> StepNo= new ArrayList<>();
	public static List<String> Description= new ArrayList<>();
	public static List<String> Keyword= new ArrayList<>();
	public static List<String> ObjectIdentifier= new ArrayList<>();
	public static List<String> TestData= new ArrayList<>();
    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
    File file =    new File(filePath+"\\"+fileName);
    FileInputStream inputStream = new FileInputStream(file);
    Workbook Workbook = null;
    String fileExtensionName = fileName.substring(fileName.indexOf("."));
    if(fileExtensionName.equals(".xlsx")){
    	Workbook = new XSSFWorkbook(inputStream);
    }
    else if(fileExtensionName.equals(".xls")){
    	Workbook = new HSSFWorkbook(inputStream);
    }
    Sheet Sheet = Workbook.getSheet(sheetName);
    int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
    for (int i = 1; i < rowCount+1; i++) {
        Row row = Sheet.getRow(i);
        for (int j = 0; j < row.getLastCellNum(); j++) {
        	switch(j) {
        	case 0:
        		StepNo.add(row.getCell(j).getStringCellValue());
        		break;
        	case 1:
        		Description.add(row.getCell(j).getStringCellValue());
        		break;
        	case 2:
        		Keyword.add(row.getCell(j).getStringCellValue());
        		break;
        	case 3:
        		ObjectIdentifier.add(row.getCell(j).getStringCellValue());
        		break;
        	case 4:
        		TestData.add(row.getCell(j).getStringCellValue());
        		break;
        	}
        }
      } 
    }
    
    public static void main(String...strings) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
    	System.setProperty("webdriver.chrome.driver", "D:\\downloads\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver;
    	driver= new ChromeDriver();
    	DriverClass objExcelFile = new DriverClass();
	    KeywordClass keywordClass= new KeywordClass(driver);
	    Class cls = keywordClass.getClass();
	    //Method[] methods = cls.getMethods();
	    String filePath = System.getProperty("user.dir")+"\\src\\Resources";
	    objExcelFile.readExcel(filePath,"TestCase.xlsx","Sheet1");
	    Iterator<String> itr= DriverClass.Keyword.iterator();
	    while(itr.hasNext()) {
	    	String currentKeyword=itr.next();
	    	System.out.println(currentKeyword);
	    	Method methodcall1 = cls.getDeclaredMethod(currentKeyword.toString().trim(), String.class, String.class); 
			methodcall1.invoke(keywordClass, "https://www.google.com/", "Sample"); 
	    	}
	    }

}