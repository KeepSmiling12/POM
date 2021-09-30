package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	public LoginPage(ChromeDriver driver) {	
		this.driver = driver;
	}
	
	public LoginPage enterUsername(String username) throws IOException {
		
		try {
			driver.findElement(By.id("username")).sendKeys(username);
			reportStep("username is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("username is not entered successfully", "fail");
			//e.printStackTrace();
		}
		return this;			
	}
	
	public LoginPage enterPassword(String password) throws IOException {
		
		try {
			driver.findElement(By.id("password")).sendKeys(password);
			reportStep("password is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("password  is not entered successfully", "fail");
		}
		return this;			
	}
	
	public HomePage clickLoginButton() throws IOException {
		try {
			driver.findElement(By.xpath("//input[@class ='decorativeSubmit']")).click();
			reportStep("login Button is clicked successfully", "pass");
		} catch (Exception e) {
			reportStep("login Button is not clicked successfully", "fail");
		}
		return new HomePage(driver);
	}
}
