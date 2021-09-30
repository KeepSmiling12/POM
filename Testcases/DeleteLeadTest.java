package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class DeleteLeadTest extends ProjectSpecificMethods{

	/*@BeforeTest
	public void setFileName() {
		excelFileName ="DeleteLead";

	}*/
	
	public void runDeleteLead(String username, String password, String phoneNum) throws InterruptedException, IOException {
		
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
		.clickOnDeleteButton();
	}
	
}
