package com.webMethodsFlowUI.LoginToApplication;
import org.testng.annotations.Test;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.TestBase;

public class LoginApplication extends TestBase 
{
    LoginPage loginPage;
    HomePage homePage;
    

	
	@Test( priority = 1, groups = "sanity", description = "Ensure login works fine")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		homePage.logOutApplication();
	}
}
