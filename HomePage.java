package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	
	public HomePage(ChromeDriver driver) {	
		this.driver = driver;
	}

	public LoginPage clickLogoutButton() {
		
		driver.findElement(By.xpath("//input[@class ='decorativeSubmit']")).click();
		return new LoginPage(driver);	
	}
	
	
	public MyHome clickCrmsfaLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();

		return new MyHome(driver);
	}
	
	public HomePage verifyHomePage() {
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if(displayed) {
			System.out.println("Home Page Loaded");
		}
		return this;
	}
	
}
