package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods {

	public EditLeadPage(ChromeDriver driver) {	
		this.driver = driver;
	}
	
	public EditLeadPage updateCompanyName(String company) {
		
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
		return this;
	}
	
	public ViewLeadPage updateButton() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
		
	}
	
}
