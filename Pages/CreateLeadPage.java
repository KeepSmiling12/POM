package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods{

	public CreateLeadPage(ChromeDriver driver) {	
		this.driver = driver;
	}
	
	
	public CreateLeadPage enterCompanyName(String compnyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compnyName);
		 return this;		
	}
	
	public CreateLeadPage enterFirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		 return this;
		
	}
	
	public CreateLeadPage enterLastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		 return this;
		
	}
	
	
	public ViewLeadPage clickOnSubmit() {
		driver.findElement(By.name("submitButton")).click();
		 return new ViewLeadPage(driver);
		
	}	
	
}
