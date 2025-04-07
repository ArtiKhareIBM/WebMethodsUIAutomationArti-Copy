package com.webMethodsUI.flow.pageObjects.flowService;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webMethodsUI.flow.helper.assertion.VerificationHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.javaScript.JavaScriptHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddAccountPage;
import com.webMethodsUI.flow.pageObjects.restapi.RestApiHomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class FlowServiceCanvasPage extends CommonActions {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(FlowServiceCanvasPage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//input[@id='ut-input-field-displayname']")
	@CacheLookup
	WebElement flowServiceTitleElement;

	@FindBy(xpath = "//input[@id='ut-flowservice-desc']")
	@CacheLookup
	WebElement flowServiceDescElement;

	@FindBy(xpath = "//button[@class='driver-close-btn']")
	@CacheLookup
	WebElement DescribeFlowInfoDialogElement;

	@FindBy(xpath = "//input[contains(@class,'flow-step-new')]")
	@CacheLookup
	WebElement flowServiceFirstStepElement;

	@FindBy(xpath = "//input[contains(@class, 'filter-text-input')]")
	@CacheLookup
	WebElement flowServiceFirstStepElementclick;
	
	@FindBy(xpath = "//span[@id= 'step-desc-1']")
	@CacheLookup
	WebElement flowFirstStep;

	@FindBy(xpath = "//input[@id='step-dropdown-input']")
	@CacheLookup
	List<WebElement> selectOperationDropDownElemnt;

	@FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='container']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ut-flow-editor[1]/flow-editor[1]/div[3]/div[1]/editor-tree[1]/flow-step-tree[1]/div[1]/step-ui[1]/div[1]/div[1]/step-ui[1]/div[1]/div[1]/div[1]/span[3]/flow-application-template[1]/div[1]/div[1]/flow-step-dropdown[1]/div[1]/div[1]/i[1]")
	@CacheLookup           ////body/div[@id='activationmesage']/div[@id='container']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ut-flow-editor[1]/flow-editor[1]/div[3]/div[1]/editor-tree[1]/flow-step-tree[1]/div[1]/flow-auto-complete[1]/div[1]/div[1]/div[1]/div[1]/i[1]
	WebElement selectConnectorDropDownElemnt;

	String connectorNameInList_1 = "//*[@class='item-name']";

//	public String selectOperationDropDown = "//input[@id='step-dropdown-input'][@placeholder='Type to choose action']";

	@FindBy(xpath = "//span[@class='custom-action-label']")
	@CacheLookup
	WebElement addCustomOperationLinkElement;

	@FindBy(xpath = "//h1[contains(text(),'Add Custom Action')]")
	@CacheLookup
	WebElement AddCustomActionLabelElemnt;

	@FindBy(xpath = "//a[contains(@class,'icon-action-bar_run')]")
	@CacheLookup
	public WebElement runButtonElement;

	@FindBy(xpath = "//h2[contains(text(),'Start creating the Flow service')]")
	@CacheLookup
	WebElement flowServiceSubTitleElement;

	@FindBy(xpath = "//i[@title='Select account']")
	@CacheLookup
	WebElement addAccountIcon;
	
	@FindBy(xpath = "//a[@title='Add new step']")
	@CacheLookup
	WebElement addNewStep;
	
	@FindBy(xpath = "//span[@class=\"capitalize bold-text ut-step-content ng-star-inserted\"]")
	@CacheLookup
	WebElement clickoncustomconn;

//	@FindBy(xpath = "//span[contains(@ng-reflect-text,'View/Edit Pipeline')]")
//	@CacheLookup
//	WebElement editMappingElement;

	@FindBy(xpath = "//img[contains(@class,'view-pipeline')]")
	@CacheLookup
	List<WebElement> editMappingElement;

	@FindBy(xpath = "//div[@title='Configure or Create a new Account']")
	@CacheLookup
	WebElement configureAccountLinkElemnt;

	@FindBy(xpath = "//span[contains(text(),' Run Successful ')]")
	@CacheLookup
	WebElement runSuccessMessage;

	@FindBy(xpath = "//span[contains(text(),' Failure ')]")
	@CacheLookup
	WebElement failureMessage;

	@FindBy(xpath = "//a[@class='ut-back-btn dlt-icon-arrow-left']")
	@CacheLookup
	WebElement backArrowLinkElement;

	@FindBy(xpath = "//a[@class='ut-icon-action-bar_io ng-star-inserted']")
	@CacheLookup
	WebElement defineInputOutputElement;

	@FindBy(xpath = "//button[contains(text(),'Run')]")
	@CacheLookup
	WebElement RunButton;

	@FindBy(xpath = "//a[contains(@class,'ut-icon-action-bar_save')]")
	@CacheLookup
	WebElement SaveButton;

	@FindBy(xpath = "//p[@aria-label='Flow service created']")
	@CacheLookup
	WebElement SuccessMessage;
	
	@FindBy(xpath = "//p[@aria-label='Account deleted successfully']")
	@CacheLookup
	WebElement AccountDeletedMessage;

        @FindBy(xpath = "//li[@data-flow-title='Run']")
	@CacheLookup
	WebElement runButtonText;

	@FindBy(xpath = "//a[contains(text(),'Create account manually')]")
	@CacheLookup
	WebElement CofigureButton;

	@FindBy(xpath = "//a[@class='ut-icon-action-bar_run ng-star-inserted']")
	@CacheLookup
	public WebElement ExecuteButton;
	
	@FindBy(xpath = "//span[@class='ut-flow-status ng-star-inserted']")
	@CacheLookup
	WebElement verifySuccessMessage;
		
	@FindBy(xpath = "//span[.=' Failure ']")
	@CacheLookup
	WebElement verifySFailureMessage;

	JavaScriptHelper javaScriptHelper;

	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public WebElement notificationMessage;

	public String FlowServiceCreatedMessage = "//*[contains(text(),'Flow service created')]";
	public String FlowServiceUpdatedMessage = "//*[contains(text(),'Flow service updated')]";
	
	public String AccountDeletedNotification = "//p[@aria-label='Account deleted successfully']";
	
	public String FlowRunLoader = "//div[contains(@class,'ut-test-loader')]//div[@aria-label='Loading']";
	public String FlowSaveLoader = "//div[contains(@class,'ut-page-loader')]//div[@aria-label='Loading']";

	// input[@id='first-flow-step']

	public FlowServiceCanvasPage(WebDriver driver) throws Exception
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("flowService Canvas page Object created");
		logExtentReport("flowService Canvas page Object created");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

//	public void clickOnAddFlowServiceButton()
//	{
//		 log.info("Clicking on Flow service button:  " +
//		 addFlowServicePlusIconElement);
//		 logExtentReport("Clicking on Flow service button:  " +
//		 addFlowServicePlusIconElement); addFlowServicePlusIconElement.click();
//		 waitHelper = new WaitHelper(driver);
//		 waitHelper.waitForElement(flowServiceTitleElement,
//		 ObjectReader.reader.getExplicitWait());
//	}

	public void closeFlowServiceInfoDialogIfExists() throws Exception
	{
		try
		{
			if (DescribeFlowInfoDialogElement.isDisplayed())
				click(DescribeFlowInfoDialogElement,driver,"Closing the info dialog");
		}
		catch(Exception e)
		{

		}
	}

	public String getTenantID() throws Exception
	{
		WebElement menuIcon = findElement("//ul[@id='mainbar-actions']//a[contains(@class,'icon-more-menu')]",driver);
		click(menuIcon,driver,"Click on more menu Icon");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement About = findElement("//a[@title='About']",driver);
		click(About,driver,"Click on About");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement AboutPage = findElement("//*[text()='About Flow service Editor']",driver);
		waitForElementVisible(AboutPage,driver,"Verify About Flow service Editor is visible");
		WebElement tenantID = findElement("//*[contains(text(),'Tenant ID')]//following-sibling::div[contains(@class,'value')]",driver);
		String tenantid = tenantID.getText();
		WebElement closeIcon = findElement("//a[@title='close modal']",driver);
		click(closeIcon, driver, "Click on cloe icon");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return tenantid;
	}

	public void enterFlowServiceTitle(String flowServicetitle) throws Exception
	{
		clearAndEnterText(flowServiceTitleElement,flowServicetitle,driver,"Entering flow service title:  " + flowServicetitle);
	}

//                public boolean verifyRunButtonIsEnabled() {
//		log.info("element is visible now...." + runButtonElement);
//		logExtentReport("runButtonElement Object created");
//		runButtonText.isEnabled();
//		return false;
//
//	}
	public void enterFlowSeviceDescription(String flowServiceDescription) throws Exception
	{
		clearAndEnterText(flowServiceDescElement,flowServiceDescription,driver,"Entering flowServiceDescription: " + flowServiceDescription);
	}

	// toDo
	public void enterFlowFirstStepAndSelect(String nameOfFirstStep,String optionName) throws Exception
	{
		Thread.sleep(2000);
		enterValue(flowServiceFirstStepElement,nameOfFirstStep,driver,"Entering nameOfFirstStep:  "+ nameOfFirstStep);
		waitForElementNotVisible(loader, driver, "wait for page load");
		clickOnALLLinkAndSelectOption(optionName);
		WebElement conenctorNameInList = findElement(connectorNameInList_1,driver);
		waitForElementVisible(conenctorNameInList,driver,"Wait for conenctor name to be visible in List");
		elementContainsText(conenctorNameInList,nameOfFirstStep,driver,"verify connector name is matching");
		click(conenctorNameInList,driver,"Clicking on connector name... " +nameOfFirstStep);
	}
	
	public void VerifyDeassociatedProjectisNotListing(String projectName,String optionName) throws Exception
	{
		Thread.sleep(2000);
		enterValue(flowServiceFirstStepElement,projectName,driver,"Entering nameOfFirstStep:  "+ projectName);
		waitForElementNotVisible(loader, driver, "wait for page load");
		clickOnALLLinkAndSelectOption(optionName);
		waitForElementNotVisible("//span[@class='item-name'][text()='"+projectName+" ']",driver,"Verify de-associated projects are not listing");
	}

	public void enterFlowFirstStepAndSelectFromDownKey(String nameOfFirstStep) throws InterruptedException {

		try {
			log.info("Entering nameOfFirstStep :  " + nameOfFirstStep);
			logExtentReport("Entering nameOfFirstStep:  " + nameOfFirstStep);
			flowServiceFirstStepElement.sendKeys(nameOfFirstStep + Keys.DOWN + "\n");
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			log.info("Clicked on first step name ..." + nameOfFirstStep);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// id for CONNECTORS is 'APPS' for all other options its same as option name
	public void clickOnALLLinkAndSelectOption(String optionName) throws Exception
	{
//		click(flowServiceFirstStepElement,driver,"Clicking on First flow step");
		WebElement dropDownelement = driver.findElement(By.xpath("//i[@class='ut-autocomplete-dropdown dlt-icon-caret-down']"));
		click(dropDownelement,driver,"Clicking on ALL drop down link");
		WebElement optionelement = driver.findElement(By.xpath("//div[@id='" + optionName + "']"));
		click(optionelement,driver,"Clicking on option link.." + optionName);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public CustomActionAccountPage navigateToCustomOperation() throws Exception
	{
		click(selectOperationDropDownElemnt.get(0),driver,"Clicking selection operation dropdown");
		click(addCustomOperationLinkElement,driver,"Clicking on add custom operation link");
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementNotVisible(loader, driver, "wait for page load");
//		waitForElementVisible(AddCustomActionLabelElemnt,driver,"Verify Add Custom Action label is visible");
		return new CustomActionAccountPage(driver);
	}

	public void selectService(String serviceName) throws Exception
	{
		click(selectOperationDropDownElemnt.get(0),driver,"Clicking on select operation dropdown...");
		WebElement element = findElement("//span[contains(text(),'" + serviceName + "')]",driver);
		waitForElementVisible(element,driver,"Wait for operation list");
		click(element,driver,"selecting custom service...."+element);
	}

	public String getFirstStepName(String selectedStepName) {

		WebElement element = null;
		try {
			log.info("Gelecting the first step name....");
			logExtentReport("Gelecting the first step name....");
			element = driver.findElement(By.xpath("//span/b[contains(text(),'" + selectedStepName + "')]"));
			log.info("first step elemnt is........." + element + "And elemt text is  " + element.getText());
			logExtentReport("first step elemnt is........." + element);
			return element.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("No elemnt displayed " + element);
			return null;
		}

	}

	  public void clickAddNewStep() throws Exception
	    {
	    	WebElement element = driver.findElement(By.xpath("//a[@title='Add new step']"));
			click(element, driver, "Click on Add new step");
		}


	public void clickOnRunButton() throws Exception
	{
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(runButtonElement,driver,"Click on runButton");	
		waitForElementNotVisible(FlowRunLoader, driver, "wait for page load");
	}

	public boolean isRunSuccessMessageDisplayed() throws Exception
	{
		waitForElementVisible(runSuccessMessage,driver,"Verify runSuccessMessage is displayed",60);
		return true;
	}

	public boolean isFailureMessageDisplayed() throws Exception
	{
		waitForElementVisible(failureMessage,driver,"Verify failed is displayed",60);
		return true;
	}

	public String getflowServiceSubTitle() {
		return flowServiceSubTitleElement.getText();
	}

	public boolean isSelectActionDropDownVisibleForConnector() {

		waitHelper.waitForElement(selectConnectorDropDownElemnt, ObjectReader.reader.getExplicitWait());
		return new VerificationHelper(driver).isDisplayed(selectConnectorDropDownElemnt);
	}


	public boolean isSelectOperationDropDownVisible(int index) throws Exception
	{
    	waitForElementVisible(selectOperationDropDownElemnt.get(index),driver,"Verify Select Operation dropdown is visible");
    	return true;
	}

	public void selectAccount(String accountName) throws Exception
	{
		click(addAccountIcon,driver,"Clicking on Add account Icon....");
		WebElement element = findElement("//span[contains(text(),'"+accountName+"')]",driver);
		click(element,driver,"Selecting account.. "+element);
	}

	public boolean isEditMappingIconVisible() throws Exception
	{
		waitForElementVisible(editMappingElement.get(0),driver,"Verify editMapping is displayed");
		return true;
	}

	public EditMappingPage clickOnEditMappingIcon() throws Exception
	{
		click(editMappingElement.get(0),driver,"Click on edit mapping");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new EditMappingPage(driver);
	}

	public EditMappingPage clickOnEditMappingIconWithIndex(int index) throws Exception
	{
		click(editMappingElement.get(index),driver,"Click on edit mapping");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new EditMappingPage(driver);
	}

	public boolean verifyDirectResultValue(String paramName, String paramValue) throws Exception
	{
		// this will verify the elements without parent root elemnt
		WebElement element = findElement(
				"//div[contains(text(),'" + paramName + "')]/parent::div/div[contains(text(),'" + paramValue + "')]",driver);

		waitForElementVisible(element,driver,"Verify "+paramName+ " "+paramValue+" is visible");
		return true;
	}

	public boolean verifyfailureMessage(String value) throws Exception
	{
		// this will verify the elements without parent root elemnt
		WebElement element = findElement(
				"//span[contains(text(),'ERROR : ')]/parent::span[contains(text(),'"+value+"')]",driver);

		waitForElementVisible(element,driver,"Verify error message: "+value+" is visible");
		return true;
	}

	public FlowServicePage clickOnBackArrowLink() throws Exception
	{
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(backArrowLinkElement,driver,"clicking on Back arrowLink...");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new FlowServicePage(driver);
	}
	
	public void clickOnBackArrowLink1() throws Exception
	{
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(backArrowLinkElement,driver,"clicking on Back arrowLink...");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public void selectOperationFromDropDown(String operationName,int index) throws Exception
	{
		click(selectOperationDropDownElemnt.get(index),driver,"clicking on Select Operation dropdown");
		WebElement element = findElement("//span[contains(text(),'" + operationName + "')]",driver);
		click(element,driver,"selecting operation..." + operationName);
	}

	public DefineInputFieldsPage clickDefineInputOutputElement() throws Exception
	{
		click(defineInputOutputElement,driver,"clicking on defineInputOutput Element");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new DefineInputFieldsPage(driver);
	}

	public void verifyResultAfterScoll(String paramName, String paramValue) throws InterruptedException
	{

		JavascriptExecutor exe = (JavascriptExecutor) driver;

		log.info("Scrolling down the page to click plus icon......");
		logExtentReport("Scrolling down the page to click plus icon.........");
//		WebElement element1 = driver.findElement(By.xpath(
//				"/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ut-flow-editor[1]/flow-editor[1]/div[3]/flow-test[1]/div[1]/div[1]/div[1]/div[2]/div[2]/flow-tree[1]/div[1]/div[3]/div[1]/span[1]/i[1]"));	
		
		WebElement element1 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ut-flow-editor[1]/flow-editor[1]/div[3]/flow-test[1]/div[1]/div[1]/div[1]/div[2]/div[2]/flow-tree[1]/div[1]/div[1]/div[1]/cdk-virtual-scroll-viewport/div[1]/div[3]/div[1]/span[1]/i[1]"));
		
		exe.executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();
		log.info("Scrolling down the page to  verify output ........");
		logExtentReport("Scrolling down the page to  verify  output ............");
		WebElement element2 = driver.findElement(By.xpath(
				"//div[contains(text(),'" + paramName + "')]/parent::div/div[contains(text(),'" + paramValue + "')]"));
		exe.executeScript("arguments[0].scrollIntoView(true);", element2);
	}

	public void SaveFlowService() throws Exception
	{
		click(SaveButton,driver,"Clicking on Save Flow Service button");
		WebElement element = findElement(FlowServiceCreatedMessage,driver);
		elementContainsText(element,"Flow service created",driver,"Verify Flow service created message is visible");
		waitForElementNotVisible(FlowSaveLoader, driver, "wait for page load");
	}

	public void updateFlowService() throws Exception
	{
		click(SaveButton,driver,"Clicking on Save Flow Service button");
		WebElement element = findElement(FlowServiceUpdatedMessage,driver);
		elementContainsText(element,"Flow service updated",driver,"Verify Flow service updated message is visible");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public void clicksavebutton()
	{
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", backArrowLinkElement);
		log.info("clicking on back arrow link...");
		logExtentReport("clicking on Back arrowLink...");
		WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		ele.click();
		
	}

	public boolean getSuccesMessage(){
		log.info("Getting successMessage...");
		logExtentReport("Getting successMessage...");
		return SuccessMessage.isDisplayed();
	}

	public void EditServiceName(){
		log.info("Click on ServiceName" );
		logExtentReport("Click on ServiceName" );
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//span[@title='Click to edit']"));
		//waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		exe.executeScript("arguments[0].click();", element);
		//element.click();
	}

	public RestApiHomePage clickOnBackArrowLinkAfterEditing() throws Exception 
	{
		click(backArrowLinkElement, driver, "clicking on back arrow link...");
		return new RestApiHomePage (driver);
	}

	public void EnterConnectorNameWithversion(String Version,String nameOfFirstStep) {
		try {
			log.info("Entering nameOfFirstStep :  " + nameOfFirstStep);
			logExtentReport("Entering nameOfFirstStep:  " + nameOfFirstStep);
			waitHelper.waitForElement(flowServiceFirstStepElement, ObjectReader.reader.getExplicitWait());
			flowServiceFirstStepElement.sendKeys(nameOfFirstStep);
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+nameOfFirstStep+"')]"));
			waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
			log.info("tab Visible" + nameOfFirstStep);
			logExtentReport("tab Visible" + nameOfFirstStep);
			element.click();
//			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'- version: "+Version+"')]/parent::span[@class='item-name'][contains(text(),'"+nameOfFirstStep+"')]"));
//			waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
//			System.out.println("Clicking on elemnt " + element);
//			WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait() );
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//			element.click();
//			Actions action = new Actions(driver);
//			action.sendKeys(Keys.ENTER).perform();

			log.info("Clicked on first step name ..." + nameOfFirstStep);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EnterConnectorNameWithversiondev(String Version,String nameOfFirstStep,String optionName) throws Exception
	{
			enterValue(flowServiceFirstStepElement,nameOfFirstStep,driver,"Entering nameOfFirstStep:  "+ nameOfFirstStep);
			waitForElementNotVisible(loader, driver, "wait for page load");
			clickOnALLLinkAndSelectOption(optionName);
		     WebElement element = findElement("//span[contains(text(),'- version: "+Version+"')]/parent::span[@class='item-name'][contains(text(),'"+nameOfFirstStep+"')]",driver);
		     click(element, driver,"Selecting on connector name... " +nameOfFirstStep);
	}

	public void clickingAccounttabForManualcreation() throws Exception
	{
		click(addNewStep, driver,"Add new step");
		click(clickoncustomconn, driver,"Clicking on custom connector name for visibility of add account icon");
		click(addAccountIcon, driver, "Clicking on Add account icon");
		Thread.sleep(2000);
		WebElement element = findElement("//span[contains(text(),'Configure Accounts')]",driver);
		click(element, driver, "Click on configure Account link");
		WebElement ele = findElement("//a[contains(text(),'Create account manually')]",driver);
        click(ele, driver, "Click on Create account manually link");
	    waitForElementNotVisible(loader, driver, "wait for page load");
	    
	}
	
	public void clickingAccounttabForManualcreation1() throws Exception
	{
		click(addAccountIcon, driver, "Clicking on Add account icon");
		Thread.sleep(2000);
		WebElement element = findElement("//span[contains(text(),'Configure Accounts')]",driver);
		click(element, driver, "Click on configure Account link");
		WebElement ele = findElement("//a[contains(text(),'Create account manually')]",driver);
        click(ele, driver, "Click on Create account manually link");
	    waitForElementNotVisible(loader, driver, "wait for page load");
	    
	}

    public void closeexecutiontab()
    {
		log.info("Clicking on close icon");
		logExtentReport("Clicking on close Icon.....");
		WebElement element = driver.findElement(By.xpath("dlt-icon-close flow-results-action-item flow-results-close-btn"));
		element.click();
	}

    public void closePipelineView() throws Exception
    {
    	WebElement element = driver.findElement(By.xpath("//a[@title='Close pipeline view']"));
		click(element, driver, "Click on close pipelone view");
	}

	public void DeleteCreatedAccount(String AccountName) throws Exception
	{
		click(addAccountIcon, driver, "Clicking on Add account icon");
		WebElement element = findElement("//div[@title='"+AccountName+"']/label/div/span[@title='Delete account']",driver);
		click(element, driver, "Click on delete button");
		waitForElementNotVisible(loader, driver, "wait for page load",30);
		Thread.sleep(1000);
		element = findElement("//img[contains(@src,'icon-warning')]/ancestor::div[contains(text(),'Warning')]",driver);
		element = findElement("//button[contains(text(),'Ok')]",driver);
		click(element,driver,"Clicking on Ok Button.. ");
		//waitForElementNotVisible(loader, driver, "wait for page load",30);
		waitForElementVisible(AccountDeletedMessage, driver, "Wait for account deleted message is visible");
		waitForElementNotVisible(AccountDeletedNotification, driver, "Wait for notification to be disappear", 5);
	}

	public void selectOperation(String operationName,int index) throws Exception
	{
		click(selectOperationDropDownElemnt.get(index),driver,"Clicking selection operation dropdown");
		WebElement element = findElement("//span[contains(text(),'" + operationName + "')]/ancestor::div/label",driver);
		click(element, driver, "selecting operation..." + operationName);
	}
        public boolean verifyRunButtonIsEnabled() 
        {
		log.info("element is visible now...." + runButtonElement);
		logExtentReport("runButtonElement Object created");
		runButtonText.isEnabled();
		return false;

	}
	public void clickdropdown(){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ObjectReader.reader.getExplicitWait()) );
		wait.until(ExpectedConditions.elementToBeClickable(selectConnectorDropDownElemnt));
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", selectConnectorDropDownElemnt);
//		selectConnectorDropDownElemnt.click();
	}

	public void editcustomOperation(String operationName){
		log.info("Edit cutom operation" + operationName);
		logExtentReport("Edit cutom operation" + operationName);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+operationName+"')]/parent::label/div/span[@class='dlt-icon-edit']"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

	}
	public void addcustomoperation(){
		log.info("Creating custom operation......");
		logExtentReport("Creating custom operation.....");
		log.info("clicking on elemnt..." + selectConnectorDropDownElemnt);
		selectConnectorDropDownElemnt.click();
		log.info("Clicking on elemnt...." + selectConnectorDropDownElemnt);
		addCustomOperationLinkElement.click();
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(AddCustomActionLabelElemnt, ObjectReader.reader.getExplicitWait());
		log.info("add custom operation window is visible now...." + AddCustomActionLabelElemnt);

	}

	public boolean IsCreatedflowserviceVisibleorNot(String Flowname) throws InterruptedException{
		log.info("Verify is flowservice is created or not ");
		logExtentReport("Verify is flowservice is created or not ");
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'"+Flowname+"')]"));
		return element.isDisplayed();

	}

	public void accountConfigurationNotFound(int index) throws Exception
	{
		//WebElement accountConfigurationIcon = findElement("(//span[@data-flow-title='Account configured is not found'])["+index+"]",driver);
		WebElement accountConfigurationIcon = findElement("//span[@data-flow-title='Account configured is not found']",driver);
		waitForElementVisible(accountConfigurationIcon, driver, "Verify Account configured Icon is visible");
		click(runButtonElement,driver,"Click on runButton");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement errorIcon = findElement("//div/img[contains(@class,'error-icon')]",driver);
		waitForElementVisible(errorIcon, driver, "Verify Error Icon is visible");
		WebElement OKButton = findElement("//button[contains(text(),'Ok')]",driver);
		click(OKButton, driver, "Click on OK button");
	}
	
	public void flowStepError(String errorMessage,int index) throws Exception
	{
		WebElement accountConfigurationIcon = findElement("(//span[@data-flow-title='"+errorMessage+"'])["+index+"]",driver);
		waitForElementVisible(accountConfigurationIcon, driver, "Verify flow step error Icon is visible");
		click(runButtonElement,driver,"Click on runButton");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement errorIcon = findElement("//div/img[contains(@class,'error-icon')]",driver);
		waitForElementVisible(errorIcon, driver, "Verify Error Icon is visible");
		WebElement OKButton = findElement("//button[contains(text(),'Ok')]",driver);
		click(OKButton, driver, "Click on OK button");
	}

	public void hoverOnFlowStep(String Service) throws Exception
	{
		WebElement stepName = findElement("//*[contains(text(),'"+Service+"')]/ancestor::span[contains(@class,'ut-step-inactive')]",driver);
		mousehover(stepName, driver, "Mouse hover on the step "+Service);

	}
	

	public void navigateToFlow(String flow) throws Exception
	{
		click(flowFirstStep, driver, "Click on flow first step");
		WebElement ele = findElement("//i[@title='Go to Flow service: "+flow+"']",driver);
		click(ele, driver, "click on go to flow service link");
		waitForElementNotVisible(loader, driver, "wait for page load");

	}
	
	public void flowName(String flow) throws Exception
	{
		WebElement ele = findElement("//h2[@id='ut-input-field-displayname'][text()='"+flow+"']",driver);
		waitForElementVisible(ele, driver, "Verify flow name is visible");
		waitForElementNotVisible(loader, driver, "wait for page load");

	}
	
	public void selectedServiceName(String serviceName) throws Exception
	{
		click(flowFirstStep, driver, "Click on flow first step");
		WebElement ele = findElement("//div[contains(@class,'step-inline')]/span[contains(text(),'"+serviceName+"')]",driver);
		waitForElementVisible(ele, driver, "Verify selected service is visible "+serviceName);
	}
	
	public void clickOnFlowServiceRunButton() throws Exception
	{
		
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(ExecuteButton,driver,"Click on flowservicerunButton");	
		waitForElementNotVisible(FlowRunLoader, driver, "wait for page load");
	}
	
	public boolean VerifySuccessMessageDisplayed() throws Exception
	{
		waitForElementVisible(verifySuccessMessage,driver,"Verify runSuccessMessage is displayed",30);
		return true;
	}
	
	public void exitWithOutSavingFlowService()throws Exception
	{
		WebElement ele = findElement("//button[.=' Exit without saving ']",driver);
		click(ele, driver, "click on exit without saving button");
	}
	
	public void clickOnBackArrow() throws Exception
	{
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(backArrowLinkElement,driver,"clicking on Back arrowLink...");
		waitForElementNotVisible(loader, driver, "wait for page load");
		
	}
	
	public boolean VerifyFailureMessageDisplayed() throws Exception
	{
		waitForElementVisible(verifySFailureMessage,driver,"Verify runSuccessMessage is displayed",30);
		return true;
	}
	
	public void clickOnRunButtonn() throws Exception
	{
		
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement element = findElement("//a[@class='ut-icon-action-bar_run ng-star-inserted']",driver);
		element.click();
		Thread.sleep(2000);
	}
	
	
	
}
