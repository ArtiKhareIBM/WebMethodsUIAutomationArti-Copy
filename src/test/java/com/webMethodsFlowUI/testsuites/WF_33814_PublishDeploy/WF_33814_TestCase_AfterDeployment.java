package com.webMethodsFlowUI.testsuites.WF_33814_PublishDeploy;

import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;
import com.webMethodsUI.origin.pageObjects.WF_16746_Notification.WF_16746_Notification_Locator;
import com.webMethodsUI.origin.pageObjects.WF_33814_PublishDeploy.WF_33814_Locators;

public class WF_33814_TestCase_AfterDeployment extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ACL_WF33565_Locators locator;
	WF_16746_Notification_Locator Notification_Locator;
	WF_33814_Locators publishdeploy_locator;
	public String ACLERT ="PDTestTarget";
	String adminport = "4222";
	String projectName = "Auto_IC_OriginTestPD";
	String flowName="EmitNotification";
	String url ="https://github.com/ak879753";
	String url1 ="https://github.webmethods.io/rajka";
	String packageName = "AbhiPackages";
	String accountName ="abhk";
	String runtime = "CloudDesignTime";
	String removeConnection = "CloudDesignTime";
	String gittoken = "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";
	
	
	String ProjectpackageName1 = "Auto_IC_OriginTestPDProject";
	String packageName2 = "aTest_Caching";
	String packageName3 ="AbhiPackages";
	
	
	@Test(priority = 1, groups = "Publish Deploy", description = "ensure login workd fine",  testName="login test case")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.GetdeployURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getTargetUserName(), ObjectReader.reader.getTargetPassword());
	}

	@Test(priority = 2, groups ="Publish Deploy", description = "Open Deployed project", testName = "Verify project visible")
	public void verifyProjectExist() throws Exception {
		locator = new ACL_WF33565_Locators(driver);
		locator.searchProject(projectName);
	}
	@Test(priority = 3, groups ="Publish Deploy", description = "Verify Packages after deployment", testName = "Verify Package available")
	public void verifyDeployedPackage() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.packageTab();
		publishdeploy_locator.packagesVisible(ProjectpackageName1);
		publishdeploy_locator.packagesVisible(packageName2);
		publishdeploy_locator.packagesVisible(packageName3);
		
	}
	@Test(priority = 4, groups ="Publish Deploy", description = "Verify Predefind Connectors after deployment", testName = "Verify Predefind Connectors available")
	public void verifyDeployedPredefindConnectors() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.connectorDetails();
		publishdeploy_locator.messagingAccount();

				
	}
	
	@Test(priority = 5, groups ="Publish Deploy", description = "Verify RestConnector after deployment", testName = "Verify RestConnector available")
	public void verifyDeployedRestConnector() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);

		publishdeploy_locator.RestConnector();
		Thread.sleep(6000);

				
	}
	
	@Test(priority = 6, groups ="Publish Deploy", description = "Verify SoapConnector after deployment", testName = "Verify SoapConnector available")
	public void verifyDeployedSoapConnector() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.SoapConnector();
		Thread.sleep(6000);
	
	}
	
	@Test(priority = 7, groups ="Publish Deploy", description = "Verify deployAnywhereConnector after deployment", testName = "Verify deployAnywhereConnector available")
	public void verifyDeployeddeployAnywhereConnector() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);

		publishdeploy_locator.deployAnywhereConnector();

				
	}
	@Test(priority = 8, groups ="Publish Deploy", description = "Verify MessagingEvents after deployment", testName = "Verify MessagingEvents available")
	public void verifyDeployedMessagingEvents() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.MessagingEvents(); 
		 
				
	}
	@Test(priority = 9, groups ="Publish Deploy", description = "Verify RestAPI after deployment", testName = "Verify RestAPI available")
	public void verifyDeployedRestAPI() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		 publishdeploy_locator.RestAPI();		
	}
	
	@Test(priority = 10, groups ="Publish Deploy", description = "Verify WorkFlow after deployment", testName = "Verify WorkFlow available")
	public void verifyDeployedWorkFlow() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.Integrations();
		 publishdeploy_locator.workflowTest();		
	}
	
	@Test(priority = 11, groups ="Publish Deploy", description = "Verify Flowservie using connector after deployment", testName = "Verify Flowservices available")
	public void verifyDeployedFlowserviceUSingConnector() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.flowserviceTest();
				
	}
	@Test(priority = 12, groups ="Publish Deploy", description = "Verify Flowservies using messaging after deployment", testName = "Verify Flowservices available")
	public void verifyDeployedFlowserviceUSingMessaging() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.runMessagingService();
		 		
	}
	@Test(priority = 13, groups ="Publish Deploy", description = "Verify Flowservies after deployment", testName = "Verify Flowservices available")
	public void verifyDeployedFlowserviceUsingPackageService() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.pakageServiceTest();	
	}
	
	@Test(priority = 14, groups = "Notification", description = "Deregister ERT", testName = "Deregister ERT")
    public void deregisterERT() throws Exception {
    	locator =  new ACL_WF33565_Locators(driver);
    	locator.afterExecutionBackToProject();
    	locator.stopDockerContainer(ACLERT);
    	locator.switchIntegrationRuntimes();
    	locator.deregisterERT(ACLERT);
    	
    }
	
	

}
