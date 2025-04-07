package com.webMethodsFlowUI.testsuites.ACL_WF33565;

import org.testng.annotations.Test;

import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class ACL_WF33566Cleanup  extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ACL_WF33565_Locators locator;
	public String ACLERT ="ERTWithAdminUser";
	public String ACLERTDev = "ERTWithDevUser";
	String projectName = "ICUI_AutomationProjectACL";
	WorkflowsPage workflowPage;
	String serviceName = "getCurrentDate";
	String flowName1 = "ERTwithSync";
	String flowName2 = "ERTwithSyncDevUSer";
	
	
	@Test(priority = 1, groups = "sanity", description = "ensure login workd fine",  testName="login test case")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
	
	
	@Test(priority = 2, groups = "ACL Runtimes", description = "Deregister the Admin ERTs created", testName ="Deregister the ERTs")
	public void deRegisterAdminPrivateERT() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		locator.switchIntegrationRuntimes();
		locator.deregisterERT(ACLERT);
		Thread.sleep(10000);
		//locator.deregisterERT(ACLERTDev);

		
	}
	
	@Test(priority = 3, groups = "ACL Runtimes", description = "Deregister the Dev ERTs created", testName ="Deregister the ERTs")
	public void deRegisterDevPrivateERT() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		Thread.sleep(10000);
		locator.deregisterERT(ACLERTDev);

		
	}
	
	@Test(priority = 4, groups = "ACL Runtimes", description = "Delete container from local", testName ="Deregister the ERTs")
	public void deleteContainerRunninglocal() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		locator.stopDockerContainer(ACLERT);
		locator.stopDockerContainer(ACLERTDev);
		locator.stopspecificContainer(ACLERT);
		
	}
	
	@Test(priority = 5, groups = "ACL Runtimes", description = "project deletion and flowservices", testName ="project deletion and flowservices")
	public void deleteProject() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		locator.searchProject(projectName);
		locator.openFlowService();
		locator.deleteFlowService(flowName1);
		Thread.sleep(5000);
		locator.deleteFlowService(flowName2);
		locator.deleteProject2(projectName);
		locator.deleteProject(projectName);
	}
	
	
	

}
