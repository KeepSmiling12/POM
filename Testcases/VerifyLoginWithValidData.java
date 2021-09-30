package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class VerifyLoginWithValidData extends ProjectSpecificMethods {

	@BeforeTest
	public void setDetails() {
		excelFileName ="Login";
		testName = " LoginWithValidData";
		testDescription = "Verify login for valid data";
		testAuthor = "Uma";
		testCategory = "Functional";

	}
	
	@Test (dataProvider = "fetchData")
	public void loginAndLogout(String username, String password) throws IOException {
		
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.verifyHomePage();
	}
}
