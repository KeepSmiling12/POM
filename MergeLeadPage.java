package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class MergeLeadPage extends ProjectSpecificMethods{

	public static List<String> allhandles;
	
	
	public MergeLeadPage(ChromeDriver driver) {	
		this.driver = driver;
	}
	
	
	public MergeLeadPage clickOnLookUpFromLead() {
		
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		return new MergeLeadPage(driver);
	}
	
	public MergeLeadPage clickOnLookUpToLead() {
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		return new MergeLeadPage(driver);
	}
	
	public ViewLeadPage clickMergeLeadButton() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();		
		return new ViewLeadPage(driver);
	}
	
	
	public FindLeadsPage switchWindowHandle1() {
		Set<String> allWindows =  driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		
		return new FindLeadsPage(driver);
	}
	
	public MergeLeadPage switchWindowHandleToMain() {
		driver.switchTo().window(allhandles.get(0));
		return this;
		
	}
	
	
	
}
