package DriverPkg;

import org.openqa.selenium.WebDriver;

public class KeywordClass {
	public WebDriver driver;
	
	KeywordClass(WebDriver driver){
		this.driver=driver;
	}
	
	public void NavigateTo(String url, String testData) {
		driver.get(url);
		System.out.println(testData);
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
