package com.webMethodsFlowUI.testsuites.DeployAnywhereConnector;

import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;


public class ServiceConnectorListSuite extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	WorkflowsPage workflowPage;
	NavigationMenu navigationMenuPage;
	PackageConnectorPage packageConnectorPage;
	GenericHelper genericHelperPage;
	
	
	String projectName = "Auto_IC_Origin_Project1";
	String url ="https://github.com/ak879753/AbhiPackages";
	String packageName = "AbhiPackages";
	String accountName ="abhk";
	String runtime = "Cloud Designtime";
	String removeConnection = "Cloud Designtime";

	boolean status;

	@Test(groups = "sanity", description = "ensure login workd fine", priority = 1)
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}

	@Test(groups = "sanity", description = "create project ", priority = 2)
	public void createProject() throws Exception 
	{
		homePage.searchProject(projectName);
	}

	@Test(groups = "sanity", description = "Navigate to Package and Add Packages", priority = 3)
	public void AddGitPackagestoPackagePage() throws Exception {

		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Packages");
        packageConnectorPage = new PackageConnectorPage(driver);
        packageConnectorPage.clickOnButton("Add package");
        packageConnectorPage.AddGitAccount();
        packageConnectorPage.enterGitUrl(url);
        Thread.sleep(5000);
        packageConnectorPage.selectSourceControl(accountName);
        packageConnectorPage.clickOnButton("Next");
        packageConnectorPage.ClickOnDropdown("Select an option");
        packageConnectorPage.ClickOnDropdown("main");
        packageConnectorPage.clickOnButton("Pull");
        Thread.sleep(3000);
	}
	@Test(groups = "sanity", description = "Navigate to Deployanywhere connector page", priority = 4)
	public void VerifyDeployAnywherePage() throws Exception {

		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Connectors ");
		navigationMenuPage.clickOnLeftPanalMainMenu("Deploy Anywhere");
        packageConnectorPage = new PackageConnectorPage(driver);
        packageConnectorPage.VerifyLebelIsVisible("Connector");
        //packageConnectorPage.VerifyLebelIsVisible("Type");
        packageConnectorPage.VerifyLebelIsVisible("Configured accounts");
        packageConnectorPage.clickOnDownIcon();
        packageConnectorPage.VerifyLebels("53");
        packageConnectorPage.verifylabels1("Abhi_conn");
        packageConnectorPage.verifylabels1("Salesforce CRM");
        packageConnectorPage.VerifyLebels("1 Account configured");
	}
	@Test(groups = "sanity", description = "Navigate to Deployanywhere connector page", priority = 5)
	public void VerifyFilterInDeployAnywherePage() throws Exception {

		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Connectors ");
		navigationMenuPage.clickOnLeftPanalMainMenu("Deploy Anywhere");
        packageConnectorPage = new PackageConnectorPage(driver);
        packageConnectorPage.VerifyLebelIsVisible("Connector");
        packageConnectorPage.clickOnFilterIcon();
        packageConnectorPage.VerifyDisabledButton("Reset");
        packageConnectorPage.VerifyDisabledButton("Apply");
        packageConnectorPage.ClickOnDropdown("Select account");
        packageConnectorPage.ClickOnDropdown("Abhi_conn");
        packageConnectorPage.clickOnButton("Apply");
        packageConnectorPage.clickOnButton("Reset");
        packageConnectorPage.ClickOnDropdown("Select connector");
        packageConnectorPage.ClickOnDropdown("Salesforce CRM");
        packageConnectorPage.clickOnButton("Apply");
        packageConnectorPage.clickOnButton("Reset");
	}
	@Test(groups = "sanity", description = "Verify Manage runtime page for connector", priority = 6)
	public void VerifyManageRuntimeForConnector() throws Exception {

		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Connectors ");
		navigationMenuPage.clickOnLeftPanalMainMenu("Deploy Anywhere");
        packageConnectorPage = new PackageConnectorPage(driver);
        packageConnectorPage.VerifyLebelIsVisible("Connector");
        packageConnectorPage.clickOnDownIcon();
        packageConnectorPage.clickManageRuntime();
        //packageConnectorPage.VerifyElementVisible("No runtimes");
        packageConnectorPage.clickOnButton("Runtime");
        Thread.sleep(6000);
        packageConnectorPage.SelectRuntime(runtime);
        packageConnectorPage.clickOnButton("Add");
        packageConnectorPage.ClickOnIcon(runtime);
        packageConnectorPage.VerifyElementVisible("Server URL");
       // packageConnectorPage.enterUserName("aditya@live.in");
      //  packageConnectorPage.enterPassword("test1234O4cWMpykPFJ2Nl3QnixQCWUid");
      //  packageConnectorPage.clickOnButton("Save");
     //  packageConnectorPage.ClickOnIcon("Sync connection");
        packageConnectorPage.closeaccountConfigPage();
        Thread.sleep(7000);
        packageConnectorPage.ClickOnIcon1(removeConnection);
        packageConnectorPage.clickOnButton("Delete");
        Thread.sleep(4000);
	}
	@Test(groups = "sanity", description = "Delete added packages", priority = 8)
	public void DeleteAddedPackages() throws Exception {

		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Packages");
		Thread.sleep(3000);
        packageConnectorPage = new PackageConnectorPage(driver);
        packageConnectorPage.RemovePackages(packageName);
        packageConnectorPage.clickOnButton("Delete");
        Thread.sleep(3000);
        packageConnectorPage.validateElementNotVisible();
	}

}