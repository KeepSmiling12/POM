package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods{
	
	public static String leadID;
	
	public FindLeadsPage(ChromeDriver driver) {	
		this.driver = driver;
	}
	
	public FindLeadsPage clickPhoneTab() {		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;		
	}
	
	public FindLeadsPage enterPhoneNumber(String phoneNum) {		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNum);
		return this;		
	}
	
	public FindLeadsPage enterFirstNameOption(String phoneNum) {		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("rider");
		return this;
	}
	
	
	public FindLeadsPage clickFindLeadsOnFindBy() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	
		
	public FindLeadsPage leadID() throws InterruptedException {
		Thread.sleep(3000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		return this;
		
	}
	
	public FindLeadsPage verifyleadId() {
		driver.findElement(By.name("id")).sendKeys(leadID);
		return this;
	}
	/*public FindLeadsPage clickOnAlertMessage() {
		driver.switchTo().alert().accept();
		return this;
		
	}*/
	
	public ViewLeadPage clickFirstOptionOnlist() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();		
		return new ViewLeadPage(driver);		
	}
	
	public MergeLeadPage clickFirstOptionOnlistInWindow() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();		
		return new MergeLeadPage(driver);		
	}

	public MyLeadsPage verifyCountOfRecords() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		return new MyLeadsPage(driver);
		
	}
	
}
