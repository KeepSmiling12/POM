package testcases;

import base.ProjectSpecificMethods;
import pages.LoginPage;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLeadTest extends ProjectSpecificMethods {

	@BeforeTest
	public void setDetails() {
		excelFileName ="CreateLead";
		testName = " LoginWithValidData";
		testDescription = "Verify Create Lead";
		testAuthor = "Uma";
		testCategory = "Functional";

	}
	
	
	@Test(dataProvider = "fetchData")
	public void runCreateLead(String username, String password, String company, String firstName, String lastName) throws IOException {
		
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickCrmsfaLink()
		.clickOnLeads()
		.clickCreateLead()
		.enterCompanyName(company)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.clickOnSubmit();
	}
}
