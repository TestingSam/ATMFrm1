package src.DriverPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class KeywordClass {
	public WebDriver driver;
	
	KeywordClass(WebDriver driver){
		this.driver=driver;
	}
	
	public void NavigateTo(String url, String thinktime) {
		driver.get(url);
		System.out.println(thinktime);
	}
	
	public void explicitwait(String url, String thinktime) throws InterruptedException {
		
		System.out.println("URLCalled");
		driver.manage().window().maximize();
		driver.get(url);		
		Thread.sleep(Integer.parseInt(thinktime));
		System.out.println("ExplicitWaitcalled");
	}
	
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
	public void implicitwait(String url, String implicitwait) throws InterruptedException {
		
		System.out.println("URLCalled");
		driver.manage().window().maximize();
		driver.get(url);		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println("ImplicitWaitcalled");
	}
	/*public void CLICK(String value) {
		System.out.println("Inside CLICK");
	}
	
	public void SENDKEYS(String value) {
		System.out.println("Inside SENDKEYS");
	}
	
	public void TAPPING(String value) {
		System.out.println("Inside TAPPING");
	}*/
}
