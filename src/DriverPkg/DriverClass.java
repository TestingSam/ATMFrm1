package src.DriverPkg;
import java.io.File;
import java.util.*;

import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.FileHandler;

import org.apache.commons.collections4.FactoryUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    int noofcol = 0;
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
    	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
    	WebDriver driver;
    	driver= new ChromeDriver();
    	DriverClass objExcelFile = new DriverClass();
	    KeywordClass keywordClass= new KeywordClass(driver);
	    Class cls = keywordClass.getClass();
	   
	    //Method[] methods = cls.getMethods();
	    String filePath = System.getProperty("user.dir")+"\\src\\Resources";
	    objExcelFile.readExcel(filePath,"TestCase.xlsx","Sheet1");
	   Iterator<String> itr= DriverClass.Keyword.iterator();
	   Iterator<String> itr1= DriverClass.TestData.iterator();
	   Iterator<String> itr2= DriverClass.ObjectIdentifier.iterator();//Description
	   Iterator<String> itr3= DriverClass.Description.iterator();
	   Iterator<String> StepNo= DriverClass.StepNo.iterator();
	   

	    
	    
	    /**** First Approach *******/
	    
	  /*  while(itr.hasNext() && itr1.hasNext() && itr2.hasNext()) {
	    	
	    		String currentKeyword=itr.next();
	    		String Epath=itr2.next();
	    		String testdata=itr1.next();
	    		String Stepinfo=itr3.next();
	    			    		    		
	    		Method methodcall1 = cls.getDeclaredMethod(currentKeyword.toString().trim(), String.class, String.class,String.class); 
	    		methodcall1.invoke(keywordClass, Epath,testdata,Stepinfo); 
	    	}*/
	    
	    /*** Second Approach****/ 
	    for ( int stepno =0; stepno <DriverClass.StepNo.size();stepno++)
	    {
	    
	    		String currentKeyword=DriverClass.Keyword.get(stepno);
	    		String testdata=DriverClass.TestData.get(stepno);
	    		String Epath=DriverClass.ObjectIdentifier.get(stepno);
	    		String Stepinfo=DriverClass.Description.get(stepno);

    		
    		Method methodcall1 = cls.getDeclaredMethod(currentKeyword.toString().trim(), String.class, String.class,String.class); 
	    	methodcall1.invoke(keywordClass, Epath,testdata,Stepinfo); 
	    	

    }
	    
	    
	    driver.close();
	    }

}