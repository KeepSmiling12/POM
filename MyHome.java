package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class MyHome extends ProjectSpecificMethods {

	public MyHome(ChromeDriver driver) {	
		this.driver = driver;
	}
			
	public MyLeadsPage clickOnLeads() {
		
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadsPage(driver);
				
	}
	
}
