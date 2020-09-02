package src.DriverPkg;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeywordClass {
	public WebDriver driver;
	
	KeywordClass(WebDriver driver){
		this.driver=driver;
	}
	
	public void NavigateTo(String Epath, String testdata,String Stepinfo) throws Exception {
		driver.manage().window().maximize();
		System.out.println(Stepinfo);
		driver.get(testdata);
		takeSnapShot(driver,Stepinfo);
			}
	
	public void explicitwait(String Epath, String testdata,String Stepinfo) throws Exception {
		
		System.out.println(Stepinfo);
		//System.out.println(Epath + testdata );
		//driver.manage().window().maximize();
	//	driver.get(url);		
		Thread.sleep(Integer.parseInt(testdata));
		takeSnapShot(driver,Stepinfo);
	
	}
	
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
	public void implicitwait(String Epath, String testdata,String Stepinfo) throws InterruptedException {
		
//		System.out.println("Maximize and Implicit wait called");
//		driver.manage().window().maximize();
//		driver.get(url);		
		System.out.println(Stepinfo);
	//	System.out.println(Epath + testdata );
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(testdata),TimeUnit.SECONDS) ;
		
	}
	
//	public void CLICK(String value) {
//		System.out.println("Inside CLICK");
//	}
	
	public void SendKeys(String Epath, String testdata,String Stepinfo) throws Exception {
		
		System.out.println(Stepinfo);
		
		WebElement SK= driver.findElement(By.xpath(Epath));
		SK.click();
		SK.sendKeys(testdata);
		takeSnapShot(driver,Stepinfo);
				
	}
	
	public void Click(String Epath, String testdata,String Stepinfo) throws Exception {
		
		System.out.println(Stepinfo);
		//System.out.println(Epath + testdata );
		
		WebElement cl= driver.findElement(By.xpath(Epath));
		cl.click();
		takeSnapShot(driver,Stepinfo);
			
	}
	
	 public static void takeSnapShot(WebDriver driver,String Stepinfo) throws Exception{

	       try {
	    	   //Convert web driver object to TakeScreenshot
	    	   
	    	   TakesScreenshot TS =((TakesScreenshot)driver);

		        File SrcFile=TS.getScreenshotAs(OutputType.FILE);

		        //FileUtils.copyFile(SrcFile, new File("C:/selenium/error.png"));
		        
		        
		     FileUtils.copyFile(SrcFile, new File("C:\\downloads\\Screenshots\\"+ Stepinfo+ System.currentTimeMillis() +".Jpeg"));
	       }
	       catch (Exception e) {
	    	   throw(e);
		}	    
	    }
	}
