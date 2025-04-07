package com.webMethodsFlowUI.testsuites.basic;

import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.assertion.AssertionHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.TestBase;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	@Test(description = "ensure login workd fine")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}

}
