package src.DriverPkg;

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
		driver.get(url);		
		Thread.sleep(Integer.parseInt(thinktime));
		System.out.println("ExplicitWaitcalled");
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
