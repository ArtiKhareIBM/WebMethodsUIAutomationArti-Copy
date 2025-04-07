package com.webMethodsUI.flow.pageObjects.UserManagement;


import com.webMethodsUI.flow.pageObjects.flowService.CustomActionAccountPage;
import com.webMethodsUI.flow.pageObjects.flowService.DefineInputFieldsPage;
import com.webMethodsUI.flow.pageObjects.flowService.EditMappingPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServicePage;
import com.webMethodsUI.flow.pageObjects.restapi.RestApiHomePage;

import java.time.Duration;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.assertion.VerificationHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.javaScript.JavaScriptHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoleFlowserviceCanvasPage extends CommonActions{
	private WebDriver driver;
	private Logger log = LogManager.getLogger(RoleFlowserviceCanvasPage.class);
	TestBase test;

	WaitHelper waitHelper;
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	@FindBy(xpath = "//input[@id='ut-input-field-displayname']")
	@CacheLookup
	WebElement flowServiceTitleElement;

	@FindBy(xpath = "//input[@id='ut-flowservice-desc']")
	@CacheLookup
	WebElement flowServiceDescElement;

	@FindBy(xpath = "//button[@class='driver-close-btn']")
	@CacheLookup
	WebElement DescribeFlowInfoDialogElement;

	@FindBy(xpath = "//input[@id='first-flow-step']")
	@CacheLookup
	WebElement flowServiceFirstStepElement;

	@FindBy(xpath = "//input[@id='step-dropdown-input']")
	@CacheLookup
	WebElement selectOperationDropDownElemnt;
	
	@FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='container']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ut-flow-editor[1]/flow-editor[1]/div[3]/div[1]/editor-tree[1]/flow-step-tree[1]/div[1]/step-ui[1]/div[1]/div[1]/step-ui[1]/div[1]/div[1]/div[1]/span[3]/flow-application-template[1]/div[1]/div[1]/flow-step-dropdown[1]/div[1]/div[1]/i[1]")
	@CacheLookup           ////body/div[@id='activationmesage']/div[@id='container']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ut-flow-editor[1]/flow-editor[1]/div[3]/div[1]/editor-tree[1]/flow-step-tree[1]/div[1]/flow-auto-complete[1]/div[1]/div[1]/div[1]/div[1]/i[1]
	WebElement selectConnectorDropDownElemnt;

	@FindBy(xpath = "//span[@class='custom-action-label']")
	@CacheLookup
	WebElement addCustomOperationLinkElement;

	@FindBy(xpath = "//h1[contains(text(),'Add Custom Action')]")
	@CacheLookup
	WebElement AddCustomActionLabelElemnt;

	@FindBy(xpath = "//li[@data-flow-title='Run']")
	@CacheLookup
	WebElement runButtonElement;

	@FindBy(xpath = "//h2[contains(text(),'Start creating the FlowService')]")
	@CacheLookup
	WebElement flowServiceSubTitleElement;

	@FindBy(xpath = "//i[@title='Select account']")
	@CacheLookup
	WebElement addAccountIcon;

	@FindBy(xpath = "//span[@title='Edit Mapping']")
	@CacheLookup
	WebElement editMappingElement;

	@FindBy(xpath = "//div[@title='Configure or Create a new Account']")
	@CacheLookup
	WebElement configureAccountLinkElemnt;

	@FindBy(xpath = "//span[contains(text(),' Run Successful ')]")
	@CacheLookup
	WebElement runSuccessMessage;

	@FindBy(xpath = "//a[@class='ut-back-btn dlt-icon-arrow-left']")
	@CacheLookup
	WebElement backArrowLinkElement;

	@FindBy(xpath = "//a[@class='ut-icon-action-bar_io']")
	@CacheLookup
	WebElement defineInputOutputElement;

	@FindBy(xpath = "//button[contains(text(),'Run')]")
	@CacheLookup
	WebElement RunButton;

	@FindBy(xpath = "//a[@class='ut-icon-action-bar_save dropdown']")
	@CacheLookup
	WebElement SaveButton;

	@FindBy(xpath = "//p[@aria-label='FlowService created']")
	@CacheLookup
	WebElement SuccessMessage;

        @FindBy(xpath = "//li[@data-flow-title='Run']")
	@CacheLookup
	WebElement runButtonText;

	JavaScriptHelper javaScriptHelper;

	// input[@id='first-flow-step']

	public RoleFlowserviceCanvasPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(runButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + runButtonElement);
		logExtentReport("runButtonElement Object created");
	}

	/*
	 * public void clickOnAddFlowServiceButton() {
	 * log.info("Clicking on Flow service button:  " +
	 * addFlowServicePlusIconElement);
	 * logExtentReport("Clicking on Flow service button:  " +
	 * addFlowServicePlusIconElement); addFlowServicePlusIconElement.click();
	 * waitHelper = new WaitHelper(driver);
	 * waitHelper.waitForElement(flowServiceTitleElement,
	 * ObjectReader.reader.getExplicitWait());
	 * 
	 * }
	 */
	public void closeFlowServiceInfoDialogIfExists() {
		if (DescribeFlowInfoDialogElement.isEnabled()) {
			log.info("Closing the info dislog");
			logExtentReport("Closing the info dislog");
			DescribeFlowInfoDialogElement.click();

		} else {
			log.info("Flow Description dialog not exists");
			logExtentReport("Flow Description dialog not exists");
		}

	}

	public void enterFlowServiceTitle(String flowServicetitle) throws InterruptedException {

		log.info("Entering flow service title:  " + flowServicetitle);
		logExtentReport("Entering flow service title:  " + flowServicetitle);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",flowServiceTitleElement);
		//flowServiceTitleElement.click();
		Thread.sleep(2000);
		flowServiceTitleElement.clear();
		Thread.sleep(1000);
		flowServiceTitleElement.sendKeys(flowServicetitle);

	}

//                public boolean verifyRunButtonIsEnabled() {
//		log.info("element is visible now...." + runButtonElement);
//		logExtentReport("runButtonElement Object created");
//		runButtonText.isEnabled();
//		return false;
//
//	}
	public void enterFlowSeviceDescription(String flowServiceDescription) throws InterruptedException {

		log.info("Entering flowServiceDescription:  " + flowServiceDescription);
		logExtentReport("Entering flowServiceDescription:  " + flowServiceDescription);
		Thread.sleep(1000);
		flowServiceDescElement.sendKeys(flowServiceDescription);

	}

	// toDo
	public void enterFlowFirstStepAndSelect(String nameOfFirstStep) throws InterruptedException {

		try {
			log.info("Entering nameOfFirstStep :  " + nameOfFirstStep);
			logExtentReport("Entering nameOfFirstStep:  " + nameOfFirstStep);
			flowServiceFirstStepElement.sendKeys(nameOfFirstStep);
			Thread.sleep(5000);
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + nameOfFirstStep + "')]"));
			System.out.println("Clicking on elemnt " + element);
			waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
			element.click();
			log.info("Clicked on first step name ..." + nameOfFirstStep);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public void clickOnALLLinkAndSelectOption(String optionName) {

		flowServiceFirstStepElement.click();
		log.info("Clicking on ALL link");
		logExtentReport("Clicking on ALL drop down link");

		driver.findElement(By.xpath("//i[@class='ut-autocomplete-dropdown dlt-icon-caret-down']")).click();

		log.info("Clicking on option link...." + optionName);
		logExtentReport("Clicking on option link...." + optionName);
		WebElement element = driver.findElement(By.xpath("//div[@id='" + optionName + "']"));
		log.info("Clicked on element..." + element);
		element.click();

	}

	public CustomActionAccountPage addCustomOperation(String operationName) throws Exception {

		log.info("Creating custom operation......");
		logExtentReport("Creating custom operation.....");
		log.info("clicking on elemnt..." + selectOperationDropDownElemnt);
		selectOperationDropDownElemnt.click();
		log.info("Clicking on elemnt...." + addCustomOperationLinkElement);
		addCustomOperationLinkElement.click();
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(AddCustomActionLabelElemnt, ObjectReader.reader.getExplicitWait());
		log.info("add custom operation window is visible now...." + AddCustomActionLabelElemnt);
		return new CustomActionAccountPage(driver);

	}

	public void selectService(String serviceName) {
		log.info("selecting custom service......");
		logExtentReport("selecting custom service......");
		log.info("clicking on elemnt..." + selectOperationDropDownElemnt);
		selectOperationDropDownElemnt.click();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + serviceName + "')]"));
		element.click();

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

	public void clickOnRunButton() throws InterruptedException {

		log.info("Clicking on Run Button..........");
		logExtentReport("Clicking on Run Button.........");
		//waitHelper.waitForElementClickable(runButtonElement,20);
		runButtonElement.click();
		Thread.sleep(5000);
	}

	public boolean isRunSuccessMessageDisplayed() {
		log.info("verifying is Run success message is displayed.....");
		logExtentReport("verifying is Run success message is displayed.....");
		return runSuccessMessage.isDisplayed();

	}

	public String getflowServiceSubTitle() {
		return flowServiceSubTitleElement.getText();
	}

	public boolean isSelectActionDropDownVisibleForConnector() {
		
		waitHelper.waitForElement(selectConnectorDropDownElemnt, ObjectReader.reader.getExplicitWait());
		return new VerificationHelper(driver).isDisplayed(selectConnectorDropDownElemnt);
	}


	public boolean isSelectActionDropDownVisible() {
        WebElement element = driver.findElement(By.xpath("//div[@class='drop-down-input-section']/input"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		return new VerificationHelper(driver).isDisplayed(element);
	}

	public void selectAccount(String accountName) {
		try {
			log.info("Clicking on Add account icon");
			logExtentReport("Clicking on Add account Icon.....");
			addAccountIcon.click();
//			Thread.sleep(2000);
			log.info("selecting account...." + accountName);

			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+accountName+"')]"));
			waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
			Actions action = new Actions(driver);
			action.click(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isEditMappingIconVisible() {
		try {
			log.info("edit mapping is displayed?................." + editMappingElement.isDisplayed());
			logExtentReport("edit mapping is displayed?................." + editMappingElement.isDisplayed());
			return new VerificationHelper(driver).isDisplayed(editMappingElement);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		log.info("editMappingElement" + editMappingElement);
		return false;

	}

	public EditMappingPage clickOnEditMappingIcon() throws Exception {
		log.info("Clicking on edit mapping....");
		logExtentReport("clicking on editmapping....");
		editMappingElement.click();
		return new EditMappingPage(driver);
	}

	public boolean verifyDirectResultValue(String paramName, String paramValue) {

		// this will verify the elements without parent root elemnt
		WebElement element = driver.findElement(By.xpath(
				"//div[contains(text(),'" + paramName + "')]/parent::div/div[contains(text(),'" + paramValue + "')]"));
		log.info("Verifying elemnt for " + element);
		return element.isDisplayed();

	}

	public FlowServicePage clickOnBackArrowLink() throws Exception 
	{
		click(backArrowLinkElement,driver,"clicking on Back arrowLink...");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new FlowServicePage(driver);
	}

	public void selectOperationFromDropDown(String operationName) throws InterruptedException {


		selectOperationDropDownElemnt.click();
		//
		//exe.executeScript("arguments[0].click();", selectOperationDropDownElemnt);
		log.info("selecting operation..." + operationName);
		logExtentReport("selecting operation..." + operationName);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + operationName + "')]"));
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		//exe.executeScript("arguments[0].click();", element1);
		element.click();
		log.info("selected operation..." + operationName);
		logExtentReport("selected operation..." + operationName);
		Thread.sleep(1000);

	}
	
	public void selectConnectorFromDropDown(String operationName) throws InterruptedException {


		selectConnectorDropDownElemnt.click();
		//
		//exe.executeScript("arguments[0].click();", selectOperationDropDownElemnt);
		log.info("selecting operation..." + operationName);
		logExtentReport("selecting operation..." + operationName);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + operationName + "')]"));
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		//exe.executeScript("arguments[0].click();", element1);
		element.click();
		log.info("selected operation..." + operationName);
		logExtentReport("selected operation..." + operationName);
		Thread.sleep(1000);

	}


	public DefineInputFieldsPage clickDefineInputOutputElement() throws Exception {
		log.info("clicking on  i/o icon......");
		logExtentReport("clicking on i/o field .....");
		defineInputOutputElement.click();
		return new DefineInputFieldsPage(driver);

	}

	public void verifyResultAfterScoll(String paramName, String paramValue) throws InterruptedException {

		JavascriptExecutor exe = (JavascriptExecutor) driver;

		log.info("Scrolling down the page to click plus icon......");
		logExtentReport("Scrolling down the page to click plus icon.........");
		WebElement element1 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ut-flow-editor[1]/flow-editor[1]/div[3]/flow-test[1]/div[1]/div[1]/div[1]/div[2]/div[2]/flow-tree[1]/div[1]/div[3]/div[1]/span[1]/i[1]"));

		exe.executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();
		log.info("Scrolling down the page to  verify output ........");
		logExtentReport("Scrolling down the page to  verify  output ............");
		WebElement element2 = driver.findElement(By.xpath(
				"//div[contains(text(),'" + paramName + "')]/parent::div/div[contains(text(),'" + paramValue + "')]"));

		exe.executeScript("arguments[0].scrollIntoView(true);", element2);
		

	}

	public void SaveFlowService() throws InterruptedException{
		log.info("Save Flowservice......");
		logExtentReport("Save Flowservice.........");
		//WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Done')]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ObjectReader.reader.getExplicitWait()) );
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", SaveButton);
		Thread.sleep(2000);
		//SaveButton.click();
	}


	public void clicksavebutton(){
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
		WebElement element = driver.findElement(By.xpath("//span[@title='Click to edit']"));
		element.click();
	}

	public RestApiHomePage clickOnBackArrowLinkAfterEditing() throws InterruptedException {
		log.info("clicking on back arrow link...");
		logExtentReport("clicking on Back arrowLink...");
		backArrowLinkElement.click();
		//Thread.sleep(2000);
		return new RestApiHomePage (driver);
	}

	public void EnterConnectorNameWithversion(String Version,String nameOfFirstStep) {
		try {
			log.info("Entering nameOfFirstStep :  " + nameOfFirstStep);
			logExtentReport("Entering nameOfFirstStep:  " + nameOfFirstStep);
			flowServiceFirstStepElement.sendKeys(nameOfFirstStep);
			Thread.sleep(5000);
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'- version: "+Version+"')]/parent::span[@class='item-name'][contains(text(),'"+nameOfFirstStep+"')]"));
			waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
			System.out.println("Clicking on elemnt " + element);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ObjectReader.reader.getExplicitWait()) );
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			log.info("Clicked on first step name ..." + nameOfFirstStep);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickingAccounttabForManualcreation() throws InterruptedException {
		log.info("Clicking on Add account icon");
		logExtentReport("Clicking on Add account Icon.....");
		addAccountIcon.click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Configure Accounts')]"));
		element.click();
        WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Create account manually')]"));
        ele.click();
	}

    public void closeexecutiontab(){
		log.info("Clicking on close icon");
		logExtentReport("Clicking on close Icon.....");
		WebElement element = driver.findElement(By.xpath("dlt-icon-close flow-results-action-item flow-results-close-btn"));
		element.click();
	}
	public void DeleteCreatedAccount(String AccountName){
		log.info("Clicking on Add account icon");
		logExtentReport("Clicking on Add account Icon.....");
		addAccountIcon.click();
		WebElement element = driver.findElement(By.xpath("//div[@title='"+AccountName+"']/label/div/span[@title='Delete account']"));
		element.click();
	}


	public void selectOperation(String operationName) throws InterruptedException {
		selectConnectorDropDownElemnt.click();
		log.info("selecting operation..." + operationName);
		logExtentReport("selecting operation..." + operationName);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + operationName + "')]/ancestor::div/label"));
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		//exe.executeScript("arguments[0].click();", element1);
		element.click();
		log.info("selected operation..." + operationName);
		logExtentReport("selected operation..." + operationName);
		Thread.sleep(1000);
	}
        public boolean verifyRunButtonIsEnabled() {
		log.info("element is visible now...." + runButtonElement);
		logExtentReport("runButtonElement Object created");
		runButtonText.isEnabled();
		return false;
		
	}

}
