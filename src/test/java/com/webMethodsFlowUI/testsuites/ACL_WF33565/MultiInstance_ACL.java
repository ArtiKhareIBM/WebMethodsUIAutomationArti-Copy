package com.webMethodsFlowUI.testsuites.ACL_WF33565;

import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;

public class MultiInstance_ACL extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ACL_WF33565_Locators locator;
	public String ACLERT ="ERTWithAdminUser";
	public String ERTWithDevUser;
	String projectName = "ICUI_AutomationProjectACL";
	WorkflowsPage workflowPage;
	String serviceName = "getCurrentDate";
	String flowName = "ERTwithSync";
	String adminport = "4567";
	String adminport1 = "4568";
	String devport = "3456";
	
	
	
	@Test(priority = 1, groups = "ACL Runtimes", description = "ensure login workedd fine",  testName="login test case")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
	
	
	@Test(priority = 2, groups = "ACL Runtimes", description = "Create multi instance and verify", testName = "Multi instance verification")
	public void addMultiInstance() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		locator.switchIntegrationRuntimes();
		locator.AddNewInstance(ACLERT);
		locator.startDockerContainer(adminport1);
		Thread.sleep(12000);
		
	}
	
	@Test(priority = 3, groups = "ACL Runtimes", description = "Verify multi instances", testName = "Verify multi instances")
	public void validateMultiInstance() throws Exception {
		locator.openERT(ACLERT);
		locator.instanceValidation();
		locator.returnIntegrationRuntime(ACLERT);
		Thread.sleep(1200000);
		locator.multiInstanceManageERT(ACLERT);
	}
	
	

}
