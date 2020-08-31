package src.DriverPkg;

import java.io.File;
import java.util.concurrent.TimeUnit;

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
	
	public void NavigateTo(String Epath, String testdata) throws Exception {
		driver.manage().window().maximize();
	//	System.out.println(Epath + testdata );
		driver.get(testdata);
		takeSnapShot(driver);
			}
	
	public void explicitwait(String Epath, String testdata) throws Exception {
		
		System.out.println("Explicit wait called");
		//System.out.println(Epath + testdata );
		//driver.manage().window().maximize();
	//	driver.get(url);		
		Thread.sleep(Integer.parseInt(testdata));
		takeSnapShot(driver);
	
	}
	
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
	public void implicitwait(String Epath, String testdata) throws InterruptedException {
		
//		System.out.println("Maximize and Implicit wait called");
//		driver.manage().window().maximize();
//		driver.get(url);		
		System.out.println("ImplicitWaitcalled");
	//	System.out.println(Epath + testdata );
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(testdata),TimeUnit.SECONDS) ;
		
	}
	
//	public void CLICK(String value) {
//		System.out.println("Inside CLICK");
//	}
	
	public void SendKeys(String Epath, String testdata) throws Exception {
		
		System.out.println("Inside SENDKEYS");
		System.out.println(Epath + testdata );
		WebElement SK= driver.findElement(By.xpath(Epath));
		SK.click();
		SK.sendKeys(testdata);
		takeSnapShot(driver);
				
	}
	
	public void Click(String Epath, String testdata) throws Exception {
		
		System.out.println("Inside Click");
		//System.out.println(Epath + testdata );
		
		WebElement cl= driver.findElement(By.xpath(Epath));
		cl.click();
		takeSnapShot(driver);
			
	}
	
	 public static void takeSnapShot(WebDriver driver) throws Exception{

	       try {
	    	   //Convert web driver object to TakeScreenshot
	    	   
	    	   TakesScreenshot TS =((TakesScreenshot)driver);

		        File SrcFile=TS.getScreenshotAs(OutputType.FILE);

		      
		        
		     //   FileUtils.CopyFile(SrcFile, new File("D:\\downloads\\Screenshots\\SH.Jpeg"));
	       }
	       catch (Exception e) {
	    	   throw(e);
		}

	       

	        

	    }
	
	
}
