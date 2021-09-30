package testcases;

import java.io.IOException;

import org.testng.annotations.*;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class EditLeadTest extends ProjectSpecificMethods{

	
	@BeforeTest
	public void setFileName() {
		excelFileName ="EditLeadTestData";
	}
	
	@Test(dataProvider = "fetchData")
	public void runEditLeadTest(String username, String password, String phoneNum, String company) throws InterruptedException, IOException {
		
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
		.clickOnEditButton()
		.updateCompanyName(company)
		.updateButton();
		
	}
	
	
}
