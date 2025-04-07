package com.webMethodsUI.origin.pageObjects.WF_33814_PublishDeploy;

import static org.testng.Assert.assertNotEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.origin.pageObjects.ACL_WF33565.ACL_WF33565_Locators;

public class WF_33814_Locators extends CommonActions {

	private Logger log = LogManager.getLogger(WF_33814_Locators.class);
	WebDriver driver;
	ACL_WF33565_Locators ACLlocator;
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	// private static String targetSunbdomainValue =
	// ObjectReader.reader.targetSubdomain();
	// private static String targetUSernameValue =
	// ObjectReader.reader.getTargetUserName();
	// private static String tagetPasswordValue =
	// ObjectReader.reader.getTargetPassword();
	public WF_33814_Locators(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@aid='deployments-publishes']")
	@CacheLookup
	WebElement deploymentTab;

	@FindBy(xpath = "//div[@class='tab-options active']")
	@CacheLookup
	WebElement deploymentversionTab;

	@FindBy(xpath = "//div[normalize-space()='Publish history']")
	@CacheLookup
	WebElement PublishHistoryTab;

	@FindBy(xpath = "//h3[normalize-space()='Publish history']")
	@CacheLookup
	WebElement publishHistoryText;

	@FindBy(xpath = "//a[normalize-space()='Publish project']")
	@CacheLookup
	WebElement publishProjectbutton;

	// div[@class='row
	// mar-btm']//a[contains(@class,'deployment-check-deploy')][normalize-space()='Deploy']
	// div[@aid='PublishTestssssss-deployment']//a[contains(@class,'deployment-check-deploy')][normalize-space()='Deploy']

	@FindBy(xpath = "//span[@title='Git Accounts']")
	@CacheLookup
	WebElement gitaccountText;

	@FindBy(xpath = "//span[@title='Integration Runtimes']")
	@CacheLookup
	WebElement runtimeText;

	@FindBy(xpath = "//span[normalize-space()='All assets']")
	@CacheLookup
	WebElement allassets;

	@FindBy(xpath = "//span[@class='used-in']")
	@CacheLookup
	WebElement usedBy;

	@FindBy(xpath = "//h3[normalize-space()='Configure Git accounts']")
	@CacheLookup
	WebElement gitconfigaccount;

	public void gitaccountPage() throws Exception {
		waitForElementVisible(gitconfigaccount, driver, "Verify Congfigure git account visible");
	}

	@FindBy(xpath = "//span[normalize-space()='Package name']")
	@CacheLookup
	WebElement packagenametab;

	@FindBy(xpath = "//span[normalize-space()='Git URL']")
	@CacheLookup
	WebElement gitURLtab;

	@FindBy(xpath = "//span[normalize-space()='Account details*']")
	@CacheLookup
	WebElement AccountDetails;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	@CacheLookup
	WebElement nextButton;

	@FindBy(xpath = "//button[normalize-space()='Deploy']")
	@CacheLookup
	WebElement deployButton;

	@FindBy(xpath = "//h3[normalize-space()='Configure Integration Runtimes']")
	@CacheLookup
	WebElement configureIntegrationRuntimeText;

	public void accountPAge() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");
		WebElement ele = findElement("//h3[normalize-space()='Configure accounts']", driver);
		waitForElementVisible(ele, driver, "Wait for Configure account page visble");

	}

	public void accountPageDetails() throws Exception {
		WebElement ele = findElement("//span[normalize-space()='Connector name']", driver);
		elementContainsText(ele, "Connector name", driver, "Verify account name visible");
		WebElement ele2 = findElement("//span[@class='accounts-title account_detail']", driver);
		elementContainsText(ele2, "Account details", driver, "Account details visble");

	}

	public void triggerPageDetails(String Name) throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele = findElement("//h3[normalize-space()='" + Name + "']", driver);
		waitForElementVisible(ele, driver, "Wait for trigger page to loaded");
		elementContainsText(ele, Name, driver, "verify Configure Trigger visbke");
		WebElement ele2 = findElement("//span[@class='triggers-title trigger_detail']", driver);
		elementContainsText(ele2, "Account details", driver, "Account details page visible");

	}

	public void deployPage() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele = findElement("//h3[normalize-space()='Configure parameters']", driver);
		waitForElementVisible(ele, driver, "Wait for Configure parameters visble");
		elementContainsText(ele, "Configure parameters", driver, "verify configure param visible");

	}

	public void integrationRuntimeText() throws Exception {
		waitForElementVisible(configureIntegrationRuntimeText, driver, "Verify integration times visble");

	}

	public void verifyAssetsNameAtIntegrationPage(String name) throws Exception {
		WebElement ele = findElement("//span[normalize-space()='" + name + "']", driver);
		elementContainsText(ele, name, driver, loader);
	}

	public void verifyAssetsTypeAtIntegrationPage(String name) throws Exception {
		WebElement ele = findElement("//span[normalize-space()='" + name + "']", driver);
		elementContainsText(ele, name, driver, loader);
	}

	public void verifyAssetsServicesAtIntegrationPage(String name) throws Exception {
		WebElement ele = findElement("//span[normalize-space()='" + name + "']", driver);
		elementContainsText(ele, name, driver, loader);
	}

	public void verifyAssetsSITAtIntegrationPage(String name) throws Exception {
		List<WebElement> ele = findElements("//span[normalize-space()='" + name + "']", driver);
		elementContainsText(ele.get(0), name, driver, loader);
		elementContainsText(ele.get(1), name, driver, loader);
		elementContainsText(ele.get(2), name, driver, loader);
		elementContainsText(ele.get(3), name, driver, loader);
	}

	@FindBy(xpath = "//span[normalize-space()='Source Integration Runtime']")
	@CacheLookup
	WebElement sourceIntegrationRuntimeTab;

	@FindBy(xpath = "//span[@class='parameters-value']")
	@CacheLookup
	WebElement syncAllERT_inTargetRuntime;

	@FindBy(xpath = "//label[@class='truncate mts']")
	@CacheLookup
	WebElement Restartcheckbox;

	@FindBy(xpath = "//h3[normalize-space()='Configure accounts']")
	@CacheLookup
	WebElement configureAccount;

	@FindBy(xpath = "//span[normalize-space()='Packages']")
	@CacheLookup
	WebElement packageTab;

	@FindBy(xpath = "//button[normalize-space()='Add package']")
	@CacheLookup
	WebElement packageaddButton;

	@FindBy(xpath = "//span[@class='steps']")
	// WebElement ele = findElement("//span[@class='steps']", driver);
	@CacheLookup
	WebElement Publishsteps;

	@FindBy(xpath = "//button[normalize-space()='Publish']")
	@CacheLookup
	WebElement publishButton;

	@FindBy(xpath = "//div[contains(text(),'Project Published Successfully')]")
	@CacheLookup
	WebElement publishMessage;

	@FindBy(xpath = "//h3[normalize-space()='Name the Project']")
	@CacheLookup
	WebElement NametheProject;

	public void verifyNameTheProject() throws Exception {
		waitForElementVisible(NametheProject, driver, "Verify Name the project visible");
	}

	public void saveAndContinueProject() throws Exception {
		WebElement button = findElement("//button[normalize-space()='Save and continue']", driver);
		click(button, driver, "Click on Save and continue button");
	}

	public void skipAssetpage() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele = findElement("//h3[normalize-space()='Skip Assets']", driver);
		waitForElementVisible(ele, driver, "Wait for Skip assets visible");
		WebElement descriptElement = findElement("//span[@class='step-desc']", driver);
		elementContainsText(descriptElement,
				"The Skip Assets option is unavailable during the initial deployment associated with a project.",
				driver, "verify descriotpn");
		isElementEnabled(nextButton, driver, "Verify next button is enabled");

	}

	public void VerifyProjectPublished() throws Exception {
		isElementEnabled(publishButton, driver, "Publish button enabled");
		click(publishButton, driver, "click on publish button");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		waitForElementVisible(publishMessage, driver, "wait for publish message visible");
		elementContainsText(publishMessage, "Project Published Successfully", driver, "Verify message");

	}

	public void deploymentTabvisible() throws Exception {
		waitForElementVisible(deploymentTab, driver, "Wait for deployment tab is visible");
		click(deploymentTab, driver, "Click on Deployment tab");
		waitForElementVisible(PublishHistoryTab, driver, "Wait for publish history visible");
	}

	public void publishhistoryTab() throws Exception {
		click(PublishHistoryTab, driver, "Click on publish history tab");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		waitForElementVisible(publishHistoryText, driver, "Wait for publish history visible");
		waitForElementVisible(publishProjectbutton, driver, "Wait for publish button visble");
	}

	public void publishproject() throws Exception {
		click(publishProjectbutton, driver, "Click on publish project");
		waitForElementVisible(Publishsteps, driver, "Wait for Select assets visible");
		elementContainsText(Publishsteps, "Select assets", driver, loader);
		isElementEnabled(nextButton, driver, "verify is Next button enabled");
	}
	@FindBy(xpath = "//input[@state='unchecked'][@id='assets']")
	@CacheLookup
	WebElement  checkboxUnChecked;
	
	@FindBy(xpath = "//span[@class='new-checkbox-label-text'][contains(text(),'Assets')]")
	@CacheLookup
	WebElement  checkCheckbox;
	
	//WebElement ele = findElement(" //span[@class='new-checkbox-label-text'][contains(text(),'"+NameOfAsset+"')]",driver);
   // click(ele, driver, "Selecting checkbox of assets.."+NameOfAsset);
	
	
	public void assetsCheckbox() {
		
			try
			{
				waitForElementVisible(checkCheckbox, driver, "Wait for checkbox to visible");
				if (!checkboxUnChecked.isSelected()) {
			    click(checkCheckbox, driver, "Selecting checkbox of assets..");
				}
			}
			
			catch(Exception e)
			{

			}
		
	}

	public void nextButtonclick() throws Exception {
		click(nextButton, driver, "Click on next button");
	}

	public void confirmnextButton() throws Exception {
		WebElement ele = findElement("//button[@class='btn primary-btn']", driver);
		click(ele, driver, "Click on button at confirm dependencies");
	}

	public void confirmnextButton2() throws Exception {
		WebElement ele = findElement("//button[@class='btn btn-sm btn-primary']", driver);
		click(ele, driver, "Click on button at confirm dependencies");
	}

	public void confirmdeployment() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele = findElement("//h1[normalize-space()='Confirm ?']", driver);
		elementContainsText(ele, "Confirm ?", driver, "Verify confirm button visible");
		WebElement ele2 = findElement("//p[@class='nova-regular']", driver);
		waitForElementVisible(ele2, driver, "Verify warning message visble");
		// elementContainsText(ele2, "Deploying the assets may affect running workflows,
		// Flow services, APIs, and Messaging triggers. Would you like to proceed with
		// the deployment?", driver, "Verify warning meesage");
		WebElement ele3 = findElement("//button[normalize-space()='Yes']", driver);
		isElementEnabled(ele3, driver, "Verify Yes button enabled");
		click(ele3, driver, "Click on confirm to deploy");
	}

	public void deploySuccessMessage() throws Exception {
		Thread.sleep(10000);
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele = findElement("//div[contains(text(),'Project deployed successfully')]", driver);
		waitForElementVisible(ele, driver, "Wait for success message ", 30);
		elementContainsText(ele, "Project deployed successfully", driver, "Verify success message");

	}

	public void connectorDetails() throws Exception {
		WebElement ele = findElement("//span[normalize-space()='Connectors']", driver);
		click(ele, driver, "Click on Connector tab");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");

	}

	public void messagingAccount() throws Exception {
		WebElement ele = findElement("//span[@title='Messaging']", driver);
		waitForElementVisible(ele, driver, "Wait for element is visible");
		elementContainsText(ele, "Messaging", driver, "Verify message test visble");
		WebElement ele2 = findElement("//span[normalize-space()='1 Account configured']", driver);
		elementContainsText(ele2, "1 Account configured", driver, "Verify account configured");

	}
	@FindBy(xpath = "//button[contains(text(),'New Account')]")
	@CacheLookup
	WebElement NewAccountButton;

	public void RestConnector() throws Exception{
		WebElement ele = findElement("//a[normalize-space()='REST']", driver);
		click(ele, driver, "Click on rest connector");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");
        WebElement ele2 =findElement("//a[normalize-space()='RestConnector']", driver);
        waitForElementVisible(ele2, driver, "Wait for Element visible");
        elementContainsText(ele2, "RestConnector", driver, "Verify connector visible");
        WebElement element = findElement("//a[contains(text(),'RestConnector')]/parent::div/span[2]/img",driver);
		mousehover(element,driver,"mousehover on created REST connector RestConnector");

		waitForElementVisible(NewAccountButton,driver,"Verify NewAccountButton is present");
		click(NewAccountButton,driver,"Clicked on NewAccount Button...");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");
		WebElement ele4 = findElement("//h1[normalize-space()='Add Account']", driver);
		waitForElementVisible(ele4, driver, "Wait for add account visible");
		WebElement ele5 = findElement("//button[normalize-space()='Add']", driver);
		click(ele5, driver, "Click on add button");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader");
		WebElement ele6 = findElement("//div[normalize-space()='1 Account(s) configured']", driver);
		waitForElementVisible(ele6, driver, "Wait for 1 Account(s) configured visible ");
		
	}
	
	public void SoapConnector() throws Exception{
		WebElement ele = findElement("//a[normalize-space()='SOAP']", driver);
		click(ele, driver, "Click on SOAP connector");
		WebElement ele2 =findElement("//a[normalize-space()='SoapConnector']", driver);
	    waitForElementVisible(ele2, driver, "Wait for Element visible");
	    elementContainsText(ele2, "SoapConnector", driver, "Verify connector visible");
	    WebElement element = findElement("//a[contains(text(),'SoapConnector')]/parent::div/span[2]/img",driver);
		mousehover(element,driver,"mousehover on created SOAP connector SoapConnector");
		waitForElementVisible(NewAccountButton,driver,"Verify NewAccountButton is present");
		click(NewAccountButton,driver,"Clicked on NewAccount Button...");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");
		WebElement ele4 = findElement("//h1[normalize-space()='Add Account']", driver);
		waitForElementVisible(ele4, driver, "Wait for add account visible");
		
		WebElement portbindign = findElement("//div[contains(text(),'Please Select')]", driver);
		click(portbindign, driver, "Click on dropdown of port binding");
		 WebElement temp = findElement("//div[contains(text(),'TemperatureConversionsSoap')]", driver);
		 click(temp, driver, "Click dropdown list");
		 WebElement ele5 = findElement("//button[normalize-space()='Add']", driver);
		 isElementEnabled(ele5, driver, "Wait for add button to enabled");
		 click(ele5, driver, "Click on add button");
		 waitForElementLoaderNotVisible(loader, driver, "Wait for loader");
		 WebElement ele6 = findElement("//div[normalize-space()='1 Account(s) configured']", driver);
		 waitForElementVisible(ele6, driver, "Wait for 1 Account(s) configured visible ");
		 
	}
	
	public void deployAnywhereConnector() throws Exception {
		WebElement ele = findElement("//a[normalize-space()='Deploy Anywhere']", driver);
		click(ele, driver, "Click on Deploy Anywhere connector");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visble");
		WebElement ele2 = findElement("//span[@title='Salesforce CRM']", driver);
		waitForElementVisible(ele2, driver, "Wait for element visbkle");
		elementContainsText(ele2, "Salesforce CRM", driver, "Verify connection lsiting");
		WebElement ele3 = findElement("//div[normalize-space()='1 Account configured']", driver);
		elementContainsText(ele3, "1 Account configured", driver, "Verify account configured"); 
	}
	
	public void MessagingEvents() throws Exception {
		WebElement ele = findElement("//span[normalize-space()='Events']", driver);
		click(ele, driver, "Click on Events");
		waitForElementLoaderNotVisible(loader, driver, "Verify loader is not visble");
		WebElement ele2 = findElement("//span[@data-testid='toggle-button-Messaging']", driver);
		click(ele2, driver, "Click message toggle button");
		
		List<WebElement> ele3 = findElements("//a[normalize-space()='SubscriberTopic']", driver);
		elementContainsText(ele3.get(0), "SubscriberTopic", driver, "subscriber visble");
		//elementContainsText(ele3.get(1), "SubscriberTopic", driver, "subscriber visble");
		WebElement ele4 = findElement("(//div[@class='messaging-list-table-cell ellipsis'][normalize-space()='ENABLED'])[1]", driver);
		elementContainsText(ele4, "enabled", driver, "Ebaled");
		
		WebElement ele5 = findElement("//button[normalize-space()='Messaging destinations']", driver);
		click(ele5, driver, "Click on messaging destination");
		waitForElementLoaderNotVisible(loader, driver, "Verify loader is not visble");
		WebElement ele6 = findElement("//a[normalize-space()='QueuePDTest']", driver);
		elementContainsText(ele6, "QueuePDTest", driver, "Verify Queue is visble");
		WebElement ele7 = findElement("//a[normalize-space()='Topics']", driver);
		click(ele7, driver, "Click on Topics");
		waitForElementLoaderNotVisible(loader, driver, "Verify loader is not visble");
		WebElement ele8 = findElement("//a[normalize-space()='TopicPDTest']", driver);
		elementContainsText(ele8, "TopicPDTest", driver, "Verify Queue is visble");
		
	}
	
	public void RestAPI() throws Exception {
		WebElement ele = findElement("//span[normalize-space()='APIs']", driver);
		click(ele, driver, "Click on APIS");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele2 = findElement("//span[@title='PDRESTAPITest']", driver);
		elementContainsText(ele2, "PDRESTAPITest", driver, "Verify rest API visble");
		
	}
	
	public void Integrations() throws Exception {
		WebElement ele = findElement("//span[normalize-space()='Integrations']", driver);
		click(ele, driver, "Click on Integration");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");

	}
	
	public void workflowTest() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//body//div[@id='activationmesage']//div[@title='PDWFUsingPS']//i[@class='flow-icons edit-workflow icons8-edit-workflow']")).click();
		//mouseHoverAndClick(ele, driver, "Click on Workflow service to open");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		Thread.sleep(5000);
		WebElement ele1 = findElement("//div[@data-eventmap='metadata-clickedActivity- (ChildService)']", driver);
		waitForElementVisible(ele1, driver, "wait for service name visible");
		doubleClick(ele1, driver, "Click on configure action");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visible");
		click(nextButton, driver, "Click on next button");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele2 = findElement("//span[@class='section-wrapper-arrow-wrapper']//div", driver);
		click(ele2, driver, "Click to verify input values");
		WebElement inpu1 = findElement("//span[@title='Input1']", driver);
		elementContainsText(inpu1, "Input1", driver, "Verify input1 visible");
		WebElement inpu2 = findElement("//span[@title='Input2']", driver);
		elementContainsText(inpu2, "Input2", driver, "Verify input2 visible");
		click(nextButton, driver, "Click on next button");
		WebElement ele3 = findElement("//button[normalize-space()='Sync']", driver);
		isElementEnabled(ele3, driver, "Verify sync button enabled");
		click(ele3, driver, "Click on Sync button");
		//WebElement ele4 = findElement("//span[normalize-space()='Syncing...']", driver);
		//waitForElementNotVisible(ele4, driver, "Wait for element not visble", 30);
		Thread.sleep(8000);
		WebElement synctitle = findElement("//span[@class='syn-title']", driver);
		waitForElementVisible(synctitle, driver, "Wait for sync tiltle visble", 30);
		elementContainsText(synctitle, "Successfully synced", driver, "verify sync success");
		WebElement close = findElement("//button[normalize-space()='Close']", driver);
		click(close, driver, "Click on close button");
		WebElement testbutton =  findElement("//button[normalize-space()='Test']", driver);
		click(testbutton, driver, "Click on test button");
		WebElement messagepostTest = findElement("//h1[normalize-space()='Message posted successfully']", driver);
		elementContainsText(messagepostTest, "Message posted successfully", driver, "Verify message post test");
		WebElement result = findElement("//span[@class='string-val'][normalize-space()='\"24\"']", driver);
		waitForElementVisible(result, driver, "result value visisble");
		WebElement donebutton =  findElement("//button[normalize-space()='Done']", driver);
		click(donebutton, driver, "Click on done button");
		Thread.sleep(4000);
		WebElement savebutton= findElement("//span[@data-eventmap='metadata-canvasSaveWorkflow-PDWFUsingPS']", driver);
		click(savebutton, driver, "Click on save button");
		Thread.sleep(5000);
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visble");
		//WebElement savesMessage = findElement("//div[contains(text(),'Workflow saved.')]", driver);
		//waitForElementVisible(savesMessage, driver, "Wait for saved message visible");
		Thread.sleep(7000);
		WebElement runbutton = findElement("//i[@class='run-play-icon']", driver);
		click(runbutton, driver, "Click on runbutton");
		Thread.sleep(13000);
		WebElement executionResult = findElement("//button[@id='debug-panel-icon']//span", driver);
		click(executionResult, driver, "Click on execution result");
		Thread.sleep(6000);
		WebElement eleer = findElement("//a[normalize-space()='Execution history']", driver);
		waitForElementVisible(eleer, driver, "Wait for execution History");
		click(eleer, driver, "Click on execution History");
		WebElement resultstatus = findElement("(//span[@class='single-workflow-title active-success'][contains(text(),'success')])[1]", driver);
		waitForElementVisible(resultstatus, driver, "Result visble");
		driver.navigate().back();
		Thread.sleep(6000);
		
		softAssert.assertAll();
	}
	
	public void flowserviceTest() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visible");
		WebElement ele = findElement("//a[normalize-space()='Flow services']", driver);
		click(ele, driver, "Click on flow service");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement connectorCOmbination = findElement("//span[normalize-space()='ConnectorCombination']", driver);
		waitForElementVisible(connectorCOmbination, driver, "wait for flow services visible");
		click(connectorCOmbination, driver, "Click on connector Combinor");
		waitForElementLoaderNotVisible(loader, driver, "wait for loader is not visble");
		WebElement ele2 = findElement("//li[@data-flow-title='Run']//a", driver);
		click(ele2, driver, "Click run flow service");
		Thread.sleep(8000);
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visible");
		WebElement result = findElement("//span[normalize-space()='Run Successful']", driver);
		elementContainsText(result, "Run Successful", driver, "verify execution result");
		WebElement ele3 = findElement("//div[normalize-space()='ISInternal']", driver);
		elementContainsText(ele3, "ISInternal", driver, "verify ISInternal visible");

	}
	
	public void runMessagingService() throws Exception {
		WebElement ele = findElement("//a[@title='Go back']", driver);
		click(ele, driver, "Click back arrow");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele2 = findElement("//span[normalize-space()='MessagePublish']", driver);
		click(ele2, driver, "Open message flow");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele3 = findElement("//li[@data-flow-title='Run']//a", driver);
		click(ele3, driver, "Click run flow service");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		Thread.sleep(8000);
		WebElement result = findElement("//span[normalize-space()='Run Successful']", driver);
		elementContainsText(result, "Run Successful", driver, "verify execution result");
		WebElement ele4 = findElement("//div[normalize-space()='TopicPDTest']", driver);
		elementContainsText(ele4, "TopicPDTest", driver, "verify destination name visible");
		
	}
	public void pakageServiceTest() throws Exception {
		WebElement ele = findElement("//a[@title='Go back']", driver);
		click(ele, driver, "Click back arrow");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele2 = findElement("//span[normalize-space()='PDFSUsingPS']", driver);
		click(ele2, driver, "Open flow service using package service");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele3 = findElement("//li[@data-flow-title='Run']//a", driver);
		click(ele3, driver, "Click run flow service");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		Thread.sleep(8000);
		WebElement result = findElement("//span[normalize-space()='Run Successful']", driver);
		elementContainsText(result, "Run Successful", driver, "verify execution result");
		WebElement ele4 = findElement("//div[normalize-space()='66']", driver);
		elementContainsText(ele4, "66", driver, "Verify result");
		
	}
	
	public void scrollpageToButton() {
		scrollPageDown2(driver, 4);
	}

	public void scrollpageToButton2() {
		scrollPageDown2(driver, 1);
	}

	public void assetDetails(String Name) throws Exception {
		WebElement Ele = findElement("//span[normalize-space()='" + Name + "']", driver);
		elementContainsText(Ele, Name, driver, "Verify assets name Visble");

	}

	public void dependencyAssetName(String Name) throws Exception {
		WebElement Ele = findElement("//span[contains(text(),'" + Name + "')]", driver);
		waitForElementVisible(Ele, driver, "verify element visble");

	}

	public void dependentAssets(String Name) throws Exception {
		WebElement Ele = findElement("//span[contains(text(),'" + Name + "')]", driver);
		waitForElementVisible(Ele, driver, "verify element visble");

	}

	public void publishSettingConfirm() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele = findElement("//span[@class='steps'][contains(text(),'Publish settings')]", driver);
		waitForElementVisible(ele, driver, "Wait for Publish Setting visible");
		elementContainsText(ele, "Publish settings", driver, "verify text");

	}

	public void publishAccountName() throws Exception {
		WebElement inputdeploymentName = findElement("//input[@placeholder='Name']", driver);
		enterValue(inputdeploymentName, "DeploymentTesting", driver, "Enter deployment Name");
	}

	public void entersubdomain(String Name) throws Exception {
		WebElement enviromentNametextfield = findElement("//div[contains(text(),'Select Environment')]", driver);
		click(enviromentNametextfield, driver, "Click on dropdown");
		WebElement inpuvalue = findElement("//input[@autocapitalize='none']", driver);
		System.out.println(Name + "  Target subdoamin");
		enterValue(inpuvalue, Name, driver, "Enter environment Name");
		Thread.sleep(7000);
		WebElement listvalue = findElement("(//div[contains(text(),'" + Name + "')])[2]", driver);
		click(listvalue, driver, "Click on drop down value");

	}

	public void enterUserName(String Name) throws Exception {
		WebElement user = findElement("//input[@placeholder='Username']", driver);
		enterValue(user, Name, driver, "Enter target tenant user Name");
	}

	public void enterPassword(String Name) throws Exception {
		WebElement pass = findElement("//input[@placeholder='Password']", driver);
		enterValue(pass, Name, driver, "Enter target tenant password");

	}

	public void publishbutton() throws Exception {
		WebElement button = findElement("//button[normalize-space()='Publish']", driver);
		isElementDisplayed(button, driver, "Verify publish button enabled");
		// click(button, driver, "Click on publish Button");
	}

	public void dependencyDetails() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele = findElement("//span[@class='steps'][contains(text(),'Confirm dependencies')]", driver);
		waitForElementVisible(ele, driver, "Wait for publish steps visible");
		elementContainsText(ele, "Confirm dependencies", driver, "verify dependency details");
	}

	public void packageTab() throws Exception {
		waitForElementVisible(packageTab, driver, "Wait for package tab visible");
		click(packageTab, driver, "Click on package tab");
		waitForElementVisible(packageaddButton, driver, "Wait for package add button visible");
		// WebElement ele = findElement("//span[normalize-space()='aTest_Caching']",
		// driver);

	}

	public void packagesVisible(String packageName) throws Exception {
		WebElement ele = findElement("//span[normalize-space()='" + packageName + "']", driver);
		isElementDisplayed(ele, driver, "Verify package visbile");
		elementContainsText(ele, packageName, driver, "Verify package vsible");

	}

	public void restartRuntimeOptions(String ERTName) throws Exception {
		SoftAssert softAssert = new SoftAssert();
		waitForElementVisible(Restartcheckbox, driver, "Wait for restart checkbox is visible ");
		click(Restartcheckbox, driver, "Click on restart checkbox");
		WebElement restartoptions = findElement("//span[normalize-space()='Restart options']", driver);
		click(restartoptions, driver, "Click on restart option so select runtims");
		WebElement restartoptionpopup = findElement("//h1[normalize-space()='Selected target integration runtimes to restart']", driver);
		waitForElementVisible(restartoptionpopup, driver, "Wait for new popup and varify text visble");
		//WebElement targetRuntime = findElement("//span[normalize-space()='Target Integration Runtimes']", driver);
		//elementContainsText(targetRuntime, "Target Integration Runtimes", driver, "Verify target runtimes visble");
		WebElement targetRuntimeselected = findElement("//span[normalize-space()='" + ERTName + "']", driver);
		elementContainsText(targetRuntimeselected, ERTName, driver, "verify " + ERTName + " visible");
		click(targetRuntimeselected, driver, "Click on target runtime");
		WebElement runtimeinfomessage = findElement("//span[@class='highlight-txt']", driver);
		elementContainsText(runtimeinfomessage,
				"Integrations may fail during a runtime restart if the runtime has single instance.", driver,
				"Verify warning message");
		WebElement Ele = findElement("//button[normalize-space()='Done']", driver);
		// isElementDisabled(Ele, driver, "Verify done is disabled");
		click(syncAllERT_inTargetRuntime, driver, "Click on sync all ERT");
		isElementEnabled(Ele, driver, "Verify done button is enabled");
		click(Ele, driver, "Click on done button");
		softAssert.assertAll();

	}

	public void selectTartgetRuntimes(String ERTname, String name) throws Exception {
		WebElement element = findElement(
				"//span[normalize-space()='" + name
						+ "']/following::div[@class='react-select2-common__single-value css-1uccc91-singleValue']",
				driver);
		click(element, driver, "Click on git account list drop down");
		List<WebElement> list = findElements("//div[@class='edgeserver']", driver);
		for (int i = 0; i < list.size(); i++) {
			if (list.size() > 1) {
				log.info(list.get(i).getText());

				if (list.get(i).getAttribute("title").equalsIgnoreCase(ERTname)) {
					// String accounttitle = list.get(i).getText();
					click(list.get(i), driver, "Click on exisitng runtime" + ERTname);
					break;
				}
			}

		}
	}

	public void verifyExisitnggitAccountList() throws Exception {
		WebElement element = findElement("//div[@class='react-select2-modal css-2b097c-container']", driver);
		click(element, driver, "Click on git account list drop down");
		List<WebElement> list = findElements("//div[@class='edgeserver']", driver);
		for (int i = 0; i < list.size(); i++) {
			if (list.size() > 1) {
				log.info(list.get(i).getText());

				/*
				 * if(list.get(i).getAttribute("title")=="Git account is expired") { String
				 * accounttitle = list.get(i).getText();
				 * log.info("Expired Git acount listing "+accounttitle); }
				 */
				String gitaccountList = list.get(i).getAttribute("title");
				Assert.assertTrue(gitaccountList != null, "Verify that account listing");
				log.info(gitaccountList, "This account already exist");
			}
		}

	}

	public void prevousButton() throws Exception {
		WebElement ele = findElement("//button[normalize-space()='Previous']", driver);
		click(ele, driver, "Click on previous button");
	}

	public void selectExisitnggitAccountList(String packageName) throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement element = findElement(
				"//span[normalize-space()='" + packageName
						+ "']/following::div[@class='react-select2-common__single-value css-1uccc91-singleValue']",
				driver);
		click(element, driver, "Click on git account list drop down");
		List<WebElement> list = findElements("//div[@class='edgeserver']", driver);
		for (int i = 0; i < list.size(); i++) {
			if (list.size() > 1) {
				log.info(list.get(i).getText());

				if (list.get(i).getAttribute("title").equalsIgnoreCase("Git account is expired")) {
					String accounttitle = list.get(i).getText();
					log.info("Expired Git acount listing " + accounttitle);
					continue;
				}
				String gitaccountList = list.get(i).getAttribute("title");
				click(list.get(i), driver, "Click on exisitng git accoint");
				break;
			}
		}

	}

	public void accountNotExist() throws Exception {
		WebElement ele = findElement("//span[@class='err-text']", driver);
		isElementDisplayed(ele, driver, "Verify error is visble");
		isElementDisabled(nextButton, driver, "Verify next button is disabled");
	}

	public void verifyExisitngRuntimesList() throws Exception {
		WebElement element = findElement("//div[@class='react-select2-modal css-2b097c-container']", driver);
		click(element, driver, "Click on Runtime list drop down");
		List<WebElement> list = findElements("//div[@class='edgeserver']", driver);
		for (int i = 0; i < list.size(); i++) {
			if (list.size() > 1) {
				log.info(list.get(i).getText());

				/*
				 * if(list.get(i).getAttribute("title")=="Git account is expired") { String
				 * accounttitle = list.get(i).getText();
				 * log.info("Expired Git acount listing "+accounttitle); } else
				 */

				String IntegrationRuntimeList = list.get(i).getAttribute("title");
				log.info(IntegrationRuntimeList, "Integration runtimes listing");
				Assert.assertTrue(IntegrationRuntimeList != null, "Verify that runtimes listing");

			}
		}

	}

	public void sourceERTName(String ERTName) throws Exception {
		WebElement ele = findElement("//span[normalize-space()='" + ERTName + "']", driver);
		elementContainsText(ele, ERTName, driver, ERTName + " Visible");

	}

	public boolean packageNameVisible(String packageName) throws Exception {
		WebElement packagevisble = findElement("//span[normalize-space()='" + packageName + "']", driver);
		boolean result = packagevisble.isEnabled();
		return result;
	}

	public void serviceName(String ServiceName) throws Exception {
		WebElement ele = findElement("//span[normalize-space()='" + ServiceName + "']", driver);
		elementContainsText(ele, ServiceName, driver, "Verify service name is visible");
	}

	public void gitaccountAddbutton(String gitaccountName) throws Exception {
		WebElement addbutton = findElement(
				"//div[@data-testid='" + gitaccountName + "']//span[@class='material-icons'][normalize-space()='add']",
				driver);
		elementContainsText(addbutton, "add", driver, "Verify add button visible");

	}

	public void configureGitaccount(String packageName, String userName, String token) throws Exception {
		WebElement addbutton = findElement(
				"//div[@data-testid='" + packageName + "']//span[@class='material-icons'][normalize-space()='add']",
				driver);
		elementContainsText(addbutton, "add", driver, "Verify add button visible");
		click(addbutton, driver, "Click on add git account");
		WebElement addaccount = findElement("//h1[normalize-space()='Add git account']", driver);
		waitForElementVisible(addaccount, driver, "Wait for add git account visible");
		WebElement inputSourceControl = findElement("//input[@id='display-name']", driver);
		enterValue(inputSourceControl, "gitaccountTest", driver, "Enter source control name");
		WebElement inputuserName = findElement("//input[@id='user-name']", driver);
		enterValue(inputuserName, userName, driver, "Enter git account user name");
		WebElement usrtoken = findElement("//input[@id='new-token']", driver);
		enterValue(usrtoken, token, driver, "Enter git user token");

		WebElement validateToken = findElement("//button[normalize-space()='Validate']", driver);
		isElementEnabled(validateToken, driver, "Verify Valdate token button enabled");
		click(validateToken, driver, "Click on validate token");

		WebElement message = findElement("//div[@class='notification-message']", driver);
		waitForElementVisible(message, driver, "wait for success message visible");
		elementContainsText(message, "Git Account validated successfully.", driver, "verify success  message");
		Thread.sleep(8000);
		WebElement addtokenbutton = findElement("//button[normalize-space()='Add']", driver);
		isElementEnabled(addtokenbutton, driver, "Verify add token button enabled");
		click(addtokenbutton, driver, "Click on add token button");

		WebElement message2 = findElement("//div[@class='notification-message']", driver);
		waitForElementLoaderNotVisible(loader, driver, "wait for loader is not visible");
		waitForElementVisible(message2, driver, "Wait for success message visible");
		elementContainsText(message2, "Git Account created successfully.", driver, "Verify add success message");

	}

	public void githuburl(String packageName, String giturl) throws Exception {
		WebElement giturlelement = findElement(
				"//div[@data-testid='" + packageName + "']//span[contains(text(),'" + giturl + "')]", driver);
		elementContainsText(giturlelement, giturl, driver, "Verify git url visible");

	}

	public void typeofService(String serviceType) throws Exception {
		WebElement ele = findElement("//span[@class='single-title case-title'][contains(text(),'" + serviceType + "')]",
				driver);
		elementContainsText(ele, "Flowservice", driver, "FlowService visible");
	}

	public void OpenProject(String projetcName) throws Exception {
		ACLlocator = new ACL_WF33565_Locators(driver);
		ACLlocator.searchProject(projetcName);

	}

	public void nextButton() throws Exception {
		waitForElementVisible(nextButton, driver, "wait for next button visible");
		isElementEnabled(nextButton, driver, "Verify next button is enabled");
		click(nextButton, driver, "Click on next button");
	}

	public void deployButton() throws Exception {
		waitForElementVisible(deployButton, driver, "wait for next button visible");
		isElementEnabled(deployButton, driver, "Verify next button is enabled");
		click(deployButton, driver, "Click on next button");
	}

	public void deploybutton(String NameOfPublisher) throws Exception {
		WebElement deployButtonEle = findElement(
				"//div[@aid='" + NameOfPublisher
						+ "-deployment']//a[contains(@class,'deployment-check-deploy')][normalize-space()='Deploy']",
				driver);
		waitForElementVisible(deployButtonEle, driver, "Wait for element to visble");
	}

}
