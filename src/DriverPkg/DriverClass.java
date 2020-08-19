package DriverPkg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DriverClass {

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
    for (int i = 0; i < rowCount+1; i++) {

        Row row = Sheet.getRow(i);
        for (int j = 0; j < row.getLastCellNum(); j++) {
            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
        }
        System.out.println();
    } 
    }  

    public static void main(String...strings) throws IOException{
	    DriverClass objExcelFile = new DriverClass();
	    String filePath = "C:\\Users\\samir\\eclipse-workspace\\ATMFramework\\src\\Resources\\";
	    objExcelFile.readExcel(filePath,"TestCase.xlsx","Sheet1");
    }

}