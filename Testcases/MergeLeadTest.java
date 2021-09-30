package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class MergeLeadTest extends ProjectSpecificMethods {

	@BeforeTest
	public void setFileName() {
		excelFileName ="MergeLead";
	}
	

	@Test (dataProvider = "fetchData")
	public void runMergeLead(String username, String password,String fromLeadName, String toLeadName) throws InterruptedException, IOException {
		
		new LoginPage(driver).enterUsername(username)
		.enterPassword(password).clickLoginButton()
		.clickCrmsfaLink().clickOnLeads()
		.clickMergeLeadsOption()
		.clickOnLookUpFromLead()
		.switchWindowHandle1()
		.enterFirstNameOption(fromLeadName).clickFindLeadsOnFindBy()
		.leadID().clickFirstOptionOnlistInWindow()
		.switchWindowHandleToMain()
		.clickOnLookUpToLead()
		.switchWindowHandle1()
		.enterFirstNameOption(toLeadName)
		.clickFindLeadsOnFindBy()
		.leadID().clickFirstOptionOnlistInWindow()
		.switchWindowHandleToMain()
		.clickMergeLeadButton().clickOnAlertMessage()
		.clickFindLeadsOption().leadID().verifyCountOfRecords();
		
	
		
	}
	
}
