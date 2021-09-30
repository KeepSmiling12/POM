package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class Duplicateleadtest extends ProjectSpecificMethods {

	
	@BeforeTest
	public void setFileName() {
		excelFileName ="DuplicateLeadTestData";
	}
	
	@Test(dataProvider = "fetchData")
	public void runDuplicateLead(String username, String password, String phoneNum) throws InterruptedException, IOException {
		
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickCrmsfaLink()
		.clickOnLeads()
		.clickFindLeadsOption()
		.clickPhoneTab()
		.enterPhoneNumber(phoneNum)
		.clickFindLeadsOnFindBy()
		.clickFirstOptionOnlist()
		.clickOnDuplicateButton()
		.clickCreateleadToDuplicate();
	}
}
