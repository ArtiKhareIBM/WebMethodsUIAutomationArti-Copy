package com.webMethodsFlowUI.testsuites.ACL_WF33565;

import org.testng.annotations.Test;

import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class ACL_WF33565  extends TestBase {
	
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
	
	@Test(priority = 1, groups = "sanity", description = "ensure login workd fine",  testName="login test case")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
	
	
	@Test(priority = 2, groups = "ACL Runtimes", description = "Validate admin able to Register private ERT", testName ="Verify in Register Edge runtime page Access private is listing properly for admin user.")
	public void registerPrivateERT() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		locator.switchIntegrationRuntimes();
		//Thread.sleep(8000);
		locator.addNewERT();
		locator.validateAccessPermission();
		
	}
	
		
    @Test(priority = 3, groups = "ACL Runtimes", description = "Validate Registering ERT with admin user ", testName ="Validate Registering ERT with admin user ")
	public void registerNewERT() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		//locator.enable_Disable();
		locator.sendERTName(ACLERT);
		locator.startDockerContainer(adminport);
		Thread.sleep(180000);
		locator.ERTSuccess();
		
	}
	
	
	@Test(priority = 4, groups = "ACL Runtimes", description = "validate private icon for Private Runtime visible" , testName = "validate private icon for Private Runtime visible ")
	public void privateIcon() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		locator.accesspermisionafterERTRegisterPrivate(ACLERT);
		locator.checkERTEnable(ACLERT);
		locator.ERTmanageAdmin(ACLERT);
		
	}
	
	@Test(priority = 5,groups = "ACL Runtimes", description = "create project ",  testName ="Create a project")
	public void createProject() throws Exception 
	{
		locator =  new ACL_WF33565_Locators(driver);
		workflowPage = locator.createProject(projectName);
		//homePage.searchProject(projectName);
		//locator =  new ACL_WF33565_Locators(driver);
		//locator.openProject(projectName);
		
	}
	
	@Test(priority = 6, groups = "ACL Runtimes", description = "Flow service creation sync and execution", testName = "Flow service creation sync and execution" )
	public void createAndExecuteFlowService() throws Exception {
		locator.createFlowService();
		locator.enterFlowServiceTitle(flowName);
		locator.selectRuntimes(ACLERT);
		locator.selectService(serviceName);
		locator.saveButton();
		locator.flowsericeSyncAndRun();
		Thread.sleep(4000);
		locator.successMessage();
		
	}
	

}
