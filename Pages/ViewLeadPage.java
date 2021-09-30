package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{

	public ViewLeadPage(ChromeDriver driver) {	
		this.driver = driver;
	}
		
	public ViewLeadPage verifyCreatelead() {
			
			String txt = driver.findElement(By.xpath("//span[contains(text(),'Rider12')]")).getText();
			if(txt.contains("Rider12")){				
				System.out.println(" Create Lead added: " + txt + "successfully");			
			}			
			return this;					
	}
	
	public EditLeadPage clickOnEditButton() {
		driver.findElement(By.linkText("Edit")).click();
		return new EditLeadPage(driver);
	}
	
	public MyLeadsPage clickOnDeleteButton() {
		driver.findElement(By.linkText("Delete")).click();
		return new MyLeadsPage(driver);
	}
	
	public DuplicateLeadPage clickOnDuplicateButton() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage(driver);
	}

	

	/*public MyLeadsPage verifyCountOfRecords() {
		// check no of records
				String text = driver.findElement(By.className("x-paging-info")).getText();
				if (text.equals("No records to display")) {
					System.out.println("Text matched");
				} else {
					System.out.println("Text not matched");
				}
				return new MyLeadsPage(driver);
		
	}*/

	public MyLeadsPage clickOnAlertMessage() {
		
			driver.switchTo().alert().accept();
			return new MyLeadsPage(driver);
	}
	
	
	
	
}
