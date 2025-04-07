package com.webMethodsFlowUI.testsuites.WF_16746_Notification;

import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;
import com.webMethodsUI.origin.pageObjects.WF_16746_Notification.WF_16746_Notification_Locator;

public class WF_16746_Notification_TestCase extends TestBase{

	
	LoginPage loginPage;
	HomePage homePage;
	ACL_WF33565_Locators locator;
	WF_16746_Notification_Locator Notification_Locator;
	public String ACLERT ="WF_16746_Notification";
	String adminport = "4527";
	String projectName = "Auto_IC_Origin_Project1";
	String flowName="EmitNotification";
	
	@Test(priority = 1, groups = "Notification", description = "ensure login workd fine",  testName="login test case")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
	
	
	@Test(priority = 2, groups = "Notification", description = "Validate admin able to Register private ERT", testName ="Verify in Register Edge runtime page Access private is listing properly for admin user.")
	public void registerPrivateERT() throws Exception {
		locator =  new ACL_WF33565_Locators(driver);
		locator.switchIntegrationRuntimes();
		//Thread.sleep(8000);
		locator.addNewERT();
		locator.sendERTName(ACLERT);
		locator.startDockerContainer(adminport);
		Thread.sleep(150000);
		locator.ERTSuccess();
		
	}
	
	@Test(priority = 3, groups = "Notification", description = "Enable the notification subscription", testName = "Enable the notification subscription")
	public void enableSubscription() throws Exception {
		Notification_Locator =  new WF_16746_Notification_Locator(driver);
		Notification_Locator.subscribeNotification();
	}
	
		
    @Test(priority = 4, groups = "Notification", description = "Execute flow service to create Notification", testName ="Execute flow service to create Notification ")
	public void executeFlowServiceToValidateNotification() throws Exception {
		/*
		 * locator = new ACL_WF33565_Locators(driver); //locator.enable_Disable();
		 * locator.searchProject(projectName); locator.openFlowService();
		 * Notification_Locator = new WF_16746_Notification_Locator(driver);
		 * Notification_Locator.openFlowEditor(flowName); locator = new
		 * ACL_WF33565_Locators(driver); locator.selectRuntimes(ACLERT);
		 * locator.flowsericeSyncAndRun(); Thread.sleep(4000); locator.successMessage();
		 * Notification_Locator = new WF_16746_Notification_Locator(driver);
		 * Notification_Locator.responseResult();
		 */
    	ExecuteFlowServiceFromAPI executeFlow = new ExecuteFlowServiceFromAPI();
    	executeFlow.getAuthTokenAndCookie();
    	executeFlow.getProjectID(projectName);
    	executeFlow.getERTToken(ACLERT);
    	executeFlow.sync1();
    	executeFlow.syncERT();
    	executeFlow.sync2();
    	executeFlow.sync3();
    	Thread.sleep(11000);
    	//executeFlow.syncConfirmtoERT();
    	executeFlow.ececuteFlowService();
    	driver.navigate().refresh();
    	Thread.sleep(150000);
    	
    	

	}
    
   @Test(priority = 5, groups = "Notification", description = "Verify notification created", testName = "Verify notification created")
    public void validateNotificationCreated() throws Exception {
    	Notification_Locator =  new WF_16746_Notification_Locator(driver);
     //   Notification_Locator.backToNotificationPage();	
        Notification_Locator.validateNotifiaction(ACLERT);
    }
    
   @Test(priority = 6, groups = "Notification", description = "Unsubscribe all the topics", testName = "unsubscribe topics")
    public void unsubscribe() throws Exception {
    	Notification_Locator =  new WF_16746_Notification_Locator(driver);
    	Notification_Locator.unSubscribeNotification();
    	
    }
    
    @Test(priority = 7, groups = "Notification", description = "Deregister ERT", testName = "Deregister ERT")
    public void deregisterERT() throws Exception {
    	locator =  new ACL_WF33565_Locators(driver);
    	locator.stopDockerContainer(ACLERT);
    	locator.switchIntegrationRuntimes();
    	locator.deregisterERT(ACLERT);
    	
    }
}
