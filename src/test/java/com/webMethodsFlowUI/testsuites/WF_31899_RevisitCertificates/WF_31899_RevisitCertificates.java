package com.webMethodsFlowUI.testsuites.WF_31899_RevisitCertificates;

import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;
import com.webMethodsUI.origin.pageObjects.WF_31899_RevisitCertificates.Locators;

public class WF_31899_RevisitCertificates extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	WorkflowsPage workflowPage;
	NavigationMenu navigationMenuPage;
	PackageConnectorPage packageConnectorPage;
	GenericHelper genericHelperPage;
	Locators locator;
	ACL_WF33565_Locators locator1;
	String StoreName = "ICRuntimeStore";
	public String ACLERT ="RuntimStoreTest";
	String adminport = "4507";
	
	String projectName = "rajkaprojetc2";
	String certpath ="\\src\\main\\resources\\importfiles\\329364933.jks";
	String truststorePath ="\\src\\main\\resources\\importfiles\\IStruststore2024_AWS 2.jks"; 
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
	
	//@Test(groups = "sanity", description = "ensure login workd fine", priority = 2)
	public void valdateRuntimeStore() throws Exception {
		locator = new Locators(driver);
		locator.clickOnProfile();
		locator.validateCertificateTab();
		
	}
	//@Test(groups = "sanity", description = "Add new Runtime Store", priority = 3)
	public void addNewRuntimeStore() throws Exception {
		locator = new Locators(driver);
		locator.addNewRuntimeStore(StoreName);
		locator.validateCertificatePage(StoreName);
	}
	
	//@Test(groups = "sanity", description = "ensure password not empty for keystore", priority = 4)
	public void validatePasswordforKeyStroe() throws Exception {
		locator = new Locators(driver);
		locator.emptyCertforKeystorPassword();
		Thread.sleep(2000);
		
	}

	//@Test(groups = "sanity", description = "ensure password not empty for Trust Store", priority = 5)
	public void validatePasswordforTrustStroe() throws Exception {
		locator = new Locators(driver);
		locator.emptyCertforTruststorPassword();
		
	}
	//@Test(groups = "sanity", description = "Add new Cerificate for Keystore", priority = 6)
	public void addkeyStoreToRuntime() throws Exception {
		locator = new Locators(driver);
		locator.addKeyStore(certpath);
	}
	
	//@Test(groups = "sanity", description = "Add new Certificate for Trust Store ", priority = 7)
	public void addTrustStoreToRuntime() throws Exception {
		locator = new Locators(driver);
		locator.addTrustStore(truststorePath);
		locator.completeKey_Trust_StoreCreation();
	}
	
	
	
	//@Test(groups = "sanity", description = "Delete create Runtime store", priority = 8)
	public void selectDefaultStore() throws Exception {
		locator = new Locators(driver);
		locator.defaultTruststore(StoreName);
		
	}
	
	@Test(priority = 9, groups = "Notification", description = "Validate admin able to Register private ERT", testName ="Verify in Register Edge runtime page Access private is listing properly for admin user.")
	public void registerPrivateERT() throws Exception {
		locator1 =  new ACL_WF33565_Locators(driver);
		locator1.switchIntegrationRuntimes();
		//Thread.sleep(8000);
		locator1.addNewERT();
		locator1.sendERTName(ACLERT);
		locator1.startDockerContainer(adminport);
		Thread.sleep(150000);
		locator1.ERTSuccess();
		
	}
	
	@Test(groups = "sanity", description = "create project ", priority = 10)
	public void createProject() throws Exception 
	{
		locator = new Locators(driver);
		locator.opneProjetc();		
		homePage.searchProject(projectName);
	}
	
	@Test(groups = "sanity", description = "create Connection", priority = 11)
	public void createConnection() throws Exception {
		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Connectors ");
		navigationMenuPage.clickOnLeftPanalMainMenu("Deploy Anywhere");
        packageConnectorPage = new PackageConnectorPage(driver);
        packageConnectorPage.VerifyLebelIsVisible("Connector");
        packageConnectorPage.clickOnDownIcon();
       // packageConnectorPage.clickManageRuntime2();
        packageConnectorPage.clickOnButton("Runtime");
       Thread.sleep(6000);
        packageConnectorPage.SelectRuntime(ACLERT);
       packageConnectorPage.clickOnButton("Add");
        packageConnectorPage.ClickOnIcon(ACLERT);
        
	}
	
	//@Test(groups ="Sanity", priority = 12, description = "Edit connection" )
	public void edittheconnection() throws Exception{
		 //packageConnectorPage = new PackageConnectorPage(driver);
		 packageConnectorPage.ClickOnIcon(runtime);
		
	}
	
	@Test(groups = "sanity", description = "Configure the Connection", priority = 13)
	public void configureConnection() throws Exception {
		locator = new Locators(driver);
		locator.configureJDBCConnection();
		
	}
	
	/*
	 * @Test(groups = "sanity", description = "Delete create Runtime store",
	 * priority = 8) public void syncToConnectionToDRT() {
	 * 
	 * }
	 * 
	 * @Test(groups = "sanity", description = "Delete create Runtime store",
	 * priority = 8) public void openRuntimeIntegration() {
	 * 
	 * }
	 * 
	 * @Test(groups = "sanity", description = "Delete create Runtime store",
	 * priority = 8) public void openERT_VerifyConnetion() {
	 * 
	 * }
	 * 
	 * @Test(groups = "sanity", description = "Delete create Runtime store",
	 * priority = 8) public void enableConnection() {
	 * 
	 * }
	 * 
	 * @Test(groups = "sanity", description = "Delete create Runtime store",
	 * priority = 8) public void editConnection() {
	 * 
	 * }
	 * 
	 * @Test(groups = "sanity", description = "Delete create Runtime store",
	 * priority = 8) public void enableConnectionAfterEdit() {
	 * 
	 * }
	 * 
	 * @Test(groups = "sanity", description = "Delete create Runtime store",
	 * priority = 8) public void disableConnection() {
	 * 
	 * }
	 * 
	 * 
	 * @Test(groups = "sanity", description = "Delete create Runtime store",
	 * priority = 8) public void deleteRuntimeStoreCreated() throws Exception {
	 * locator = new Locators(driver); locator.deleteRuntimeStore(StoreName); }
	 */

}
