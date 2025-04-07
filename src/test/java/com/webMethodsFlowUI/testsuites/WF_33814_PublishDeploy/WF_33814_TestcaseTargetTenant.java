package com.webMethodsFlowUI.testsuites.WF_33814_PublishDeploy;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;
import com.webMethodsUI.origin.pageObjects.WF_16746_Notification.WF_16746_Notification_Locator;
import com.webMethodsUI.origin.pageObjects.WF_33814_PublishDeploy.WF_33814_Locators;

public class WF_33814_TestcaseTargetTenant extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ACL_WF33565_Locators locator;
	WF_16746_Notification_Locator Notification_Locator;
	WF_33814_Locators publishdeploy_locator;
	public String ACLERT ="PDTestTarget";
	String adminport = "4262";
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
	@Test(priority = 2, groups = "Publish Deploy", description = "Register ERT in Target tenant",  testName="Register ERT")
	public void ERTRegister() throws Exception 
	{
		locator =  new ACL_WF33565_Locators(driver);
		locator.switchIntegrationRuntimes();
		//Thread.sleep(8000);
		locator.addNewERT();
		locator.sendERTName(ACLERT);
		locator.startDockerContainer(adminport);
		Thread.sleep(150000);
		locator.ERTSuccess();
	}
	
	
	@Test(priority = 3, groups ="Publish Deploy", description = "Open Existing project", testName = "Verify project visible")
	public void verifyProjectExist() throws Exception {
		locator = new ACL_WF33565_Locators(driver);
		locator.searchProject(projectName);
		//locator.openProject(projectName);
	}
	
	@Test(priority = 4, groups ="Publish Deploy", description = "Open published project", testName = "Verify published project visible")
	public void verifyPublishedProjetcVisible() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.saveAndContinueProject();
		publishdeploy_locator.skipAssetpage();
		publishdeploy_locator.scrollpageToButton2();
		publishdeploy_locator.nextButton();
		
	}
	
	@Test(priority = 5, groups = "publish deploy", description = "Git account validation", testName = "verify git accoiutn page")
	public void verifyGitAccountDetails() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.gitaccountPage();
		boolean result = publishdeploy_locator.packageNameVisible(packageName2);
		Assert.assertTrue(result);
		boolean result2 = publishdeploy_locator.packageNameVisible(packageName3);
		Assert.assertTrue(result2);
		publishdeploy_locator.githuburl(packageName2, url1);
		publishdeploy_locator.githuburl(packageName3, url);
	}
	@Test(priority = 6, groups = "publish deploy" , description = "Verify Git account Listing for target tenant", testName = "Listing git account")
	public void verifyListingofGitAccounts() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.verifyExisitnggitAccountList();
	}
	
	@Test(priority = 7, groups = "publish deploy" , description = "Verify Git account not available in target tenant", testName = "git account not visble")
	public void verifyGitAccountNotExist() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.accountNotExist();
	}
	
	//@Test(priority = 8, groups = "publish deploy" , description = "Create new git account in target tenant", testName = "create git account ")
	public void configureGitAccount() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.configureGitaccount(packageName2, "rajka", gittoken);
		
	}
	
	@Test(priority = 9, groups="publish deploy", description = "change git account to deploy", testName = "Verify deploying exisitng git account")
	public void selectExistingGitAccount() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.prevousButton();
		publishdeploy_locator.nextButton();
		publishdeploy_locator.selectExisitnggitAccountList(packageName2);
		Thread.sleep(3000);
		publishdeploy_locator.confirmnextButton2();;

	}
	
	@Test(priority = 10, groups="publish deploy", description = "Verify Integration runtimes page assets", testName = "Verify Integration runtimes asstes")
	public void VerifyIntegrationRuntimesPageDetails() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.integrationRuntimeText();
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("PDFSUsingPS");
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("ConnectorCombination");
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("PDRESTAPITest");
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("PDWFUsingPS");
		publishdeploy_locator.verifyAssetsTypeAtIntegrationPage("Workflow");
		publishdeploy_locator.verifyAssetsTypeAtIntegrationPage("REST API");
		publishdeploy_locator.verifyAssetsTypeAtIntegrationPage("Flowservice");
		publishdeploy_locator.verifyAssetsServicesAtIntegrationPage("flow2");
		publishdeploy_locator.verifyAssetsServicesAtIntegrationPage("getJDBCAliasStatus");
		publishdeploy_locator.verifyAssetsServicesAtIntegrationPage("ChildService_/test_POST");
		publishdeploy_locator.verifyAssetsServicesAtIntegrationPage("ChildService");
		publishdeploy_locator.verifyAssetsSITAtIntegrationPage("Cloud Designtime");
			
	}
	
	@Test(priority = 11, groups="publish deploy", description = "Verify Integration runtimes listing", testName = "Verify Integration runtimes listing")
	public void verifyRuntimesListing() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.verifyExisitngRuntimesList();
	}
	
	
	@Test(priority = 12, groups="publish deploy", description = "select Integration runtimes listing", testName = "sleect Integration runtimes listing")
	public void selectExistingRuntimesListing() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.prevousButton();
		publishdeploy_locator.confirmnextButton2();
		Thread.sleep(4000);
		publishdeploy_locator.selectTartgetRuntimes(ACLERT,"PDFSUsingPS");
		Thread.sleep(3000);
		publishdeploy_locator.selectTartgetRuntimes(ACLERT,"ConnectorCombination");
		Thread.sleep(3000);
		publishdeploy_locator.selectTartgetRuntimes(ACLERT,"PDRESTAPITest");
		Thread.sleep(3000);
		publishdeploy_locator.selectTartgetRuntimes(ACLERT,"PDWFUsingPS");
	}
	
	@Test(priority = 13, groups="publish deploy", description = "Sync to Integration runtimes", testName = "Sync to Integration runtimes")
	public void syncToRuntimes() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.restartRuntimeOptions(ACLERT);
	}
	
	@Test(priority = 14, groups="publish deploy", description = "Account setting page ", testName = "Account setting page")
	public void accountSettingPage() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.confirmnextButton2();
		publishdeploy_locator.accountPAge();
		publishdeploy_locator.accountPageDetails();
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("Messaging");
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("Salesforce® CRM SOAP");
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("MessagePublish");
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("ConnectorCombination");
		publishdeploy_locator.confirmnextButton2();
	}
	

	@Test(priority = 15, groups="publish deploy", description = "Trigger setting page ", testName = "Trigger setting page")
	public void triggerSettingPage() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.triggerPageDetails("Configure triggers");
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("Connector name");
		publishdeploy_locator.verifyAssetsNameAtIntegrationPage("Type");
		publishdeploy_locator.confirmnextButton2();
	}
	
	@Test(priority = 16, groups="publish deploy", description = "Verify Deployment success ", testName = "Verify deployment success")
	public void verifyDeployemtne() throws Exception {
		publishdeploy_locator =  new WF_33814_Locators(driver);
		publishdeploy_locator.deployPage();
		publishdeploy_locator.confirmnextButton2();
		publishdeploy_locator.confirmdeployment();
		publishdeploy_locator.deploySuccessMessage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
