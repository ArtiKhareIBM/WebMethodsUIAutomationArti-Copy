package com.webMethodsFlowUI.testsuites.WF_33814_PublishDeploy;

import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;
import com.webMethodsUI.origin.pageObjects.WF_16746_Notification.WF_16746_Notification_Locator;
import com.webMethodsUI.origin.pageObjects.WF_33814_PublishDeploy.WF_33814_Locators;

public class WF_33814_Testcase extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ACL_WF33565_Locators locator;
	WF_16746_Notification_Locator Notification_Locator;
	WF_33814_Locators publishdeploy_locator;
	public String ACLERT ="PDTestSource";
	String adminport = "4222";
	String projectName = "Auto_IC_OriginTestPD";
	String flowName="EmitNotification";
	String url ="https://github.com/ak879753/AbhiPackages";
	String packageName = "AbhiPackages";
	String accountName ="abhk";
	String runtime = "CloudDesignTime";
	String removeConnection = "CloudDesignTime";
	
	String ProjectpackageName1 = "Auto_IC_OriginTestPDProject";
	String packageName2 = "aTest_Caching";
	String packageName3 ="AbhiPackages";
	
	
	@Test(priority = 1, groups = "Publish Deploy", description = "ensure login workd fine",  testName="login test case")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
	
	@Test(priority = 2, groups ="Publish Deploy", description = "Open Existing project", testName = "Verify project visible")
	public void verifyProjectExist() throws Exception {
		locator = new ACL_WF33565_Locators(driver);
		locator.searchProject(projectName);
	}
	
	@Test(priority = 3, groups ="Publish Deploy", description = "Packages Exist", testName = "Verify Package available")
	public void verifyExisitingPackage() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.packageTab();
		publishdeploy_locator.packagesVisible(ProjectpackageName1);
		publishdeploy_locator.packagesVisible(packageName2);
		publishdeploy_locator.packagesVisible(packageName3);
		
	}
	
	@Test(priority = 4, groups ="Publish Deploy", description = "Publish the project", testName = "Verify publish project")
	public void verifyDeployment() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.deploymentTabvisible();
		publishdeploy_locator.publishhistoryTab();
		publishdeploy_locator.publishproject();
		publishdeploy_locator.assetsCheckbox();
		publishdeploy_locator.assetDetails("Workflows");
		publishdeploy_locator.assetDetails("Flow services");
		publishdeploy_locator.assetDetails("Messaging subscribers");
		publishdeploy_locator.assetDetails("Soap APIs");
		publishdeploy_locator.assetDetails("Rest APIs");
		publishdeploy_locator.nextButtonclick();
		publishdeploy_locator.dependencyDetails();
		publishdeploy_locator.assetDetails("Assets Name");
		publishdeploy_locator.assetDetails("Dependent Assets");
		publishdeploy_locator.dependencyAssetName("PDWFUsingPS");
		publishdeploy_locator.dependencyAssetName("PDFSUsingPS");
		publishdeploy_locator.dependencyAssetName("PDRESTAPITest");
		publishdeploy_locator.dependencyAssetName("MessagePublish");
		publishdeploy_locator.dependencyAssetName("SubscriberTopic");
		publishdeploy_locator.scrollpageToButton();
		Thread.sleep(5000);
		publishdeploy_locator.confirmnextButton();
		publishdeploy_locator.publishSettingConfirm();
		publishdeploy_locator.publishAccountName();
		publishdeploy_locator.entersubdomain(ObjectReader.reader.targetSubdomain());
		publishdeploy_locator.enterUserName(ObjectReader.reader.getTargetUserName());
		publishdeploy_locator.enterPassword(ObjectReader.reader.getTargetPassword());
		//publishdeploy_locator.publishbutton();
		
	}
	@Test(priority = 5, groups ="Publish Deploy", description = "Publish the project to other tenant" , testName = "Verify Publishing project")
	public void publishProject() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.VerifyProjectPublished();
		
	}
	
	
	
	
	

}
