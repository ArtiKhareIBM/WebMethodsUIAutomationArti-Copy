package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class SOAPConnectorHomePage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(SOAPConnectorHomePage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//span[contains(text(),'SOAP Connectors')]")
	@CacheLookup
	WebElement soapConnectorTitleElement;

	@FindBy(xpath = "//button[contains(text(),'Add Connector')]")
	@CacheLookup
	WebElement addConnectorButtonElement;

	@FindBy(xpath = "//button[contains(text(),'New Account')]")
	@CacheLookup
	WebElement newAccountButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Operations')]")
	@CacheLookup
	WebElement operationButtonElement;

// three dot icon
	@FindBy(xpath = "//i[@data-eventmap='actions-edit-dropdown']")
	@CacheLookup
	WebElement editDropdownElement;


	@FindBy(xpath = "//li[@data-eventmap='actions-edit-button']")
	@CacheLookup
	WebElement EditButtonElement;

//	@FindBy(xpath = "//li[@data-eventmap='actions-remove-button']")
//	@CacheLookup
//	WebElement removeButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	WebElement deleteButtonElement;

	@FindBy(xpath = "//div[@class='no-table-data']")
	@CacheLookup
	WebElement noConnectorTitleElement;

	@FindBy(xpath = "//div[contains(text(),'No connector(s) created yet!')]")
	@CacheLookup
	WebElement EmptyConnectormessage;

	@FindBy(xpath = "//h1[contains(text(),'Delete SOAP Connector')]")
	@CacheLookup
	WebElement DeletesoapconnectorTest;


	String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public SOAPConnectorHomePage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForElementVisible(soapConnectorTitleElement, driver, "Wait for soap connector title element visible");
	}

	public boolean verifyAddConnectorButton()
	{
		log.info("Verifying the Add connector button is visible....");
		logExtentReport(" Verifying the Add connector button is visible....");

		return addConnectorButtonElement.isDisplayed();
	}

	public void clickOnAddAccount(String soapConnectorName) {
		log.info("Clicking on Soap connector name " + soapConnectorName);
		logExtentReport("Clicking on Soap connector name " + soapConnectorName);
		WebElement element = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));

		//WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+soapConnectorName+"')]/parent::div/span[2]/img"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
//		Actions actions = new Actions(driver);
//
//          //Hovering on main menu
//		actions.moveToElement(element);
		element.click();

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(newAccountButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("NewAccountButton button is visible");
		logExtentReport("NewAccountButton button is visible");
		newAccountButtonElement.click();

	}

	public void clickOnAddAccount1(String soapConnectorName) throws Exception
	{
		WebElement element = findElement("//a[contains(text(),'"+soapConnectorName+"')]/parent::div/span[2]/img[contains(@class,'SOAP-icon')]",driver);
		mousehover(element,driver,"mousehover on created REST connector " + soapConnectorName);

		waitForElementVisible(newAccountButtonElement,driver,"Verify NewAccountButton is present");
		click(newAccountButtonElement,driver,"Clicked on NewAccount Button...");

	}

	public void clickOnOperationButton(String soapConnectorName) throws Exception
	{

		WebElement element = findElement("//a[contains(text(),'"+soapConnectorName+"')]/parent::div/span[2]/img[contains(@class,'SOAP-icon')]",driver);
		mousehover(element,driver,"mousehover on created REST connector " + soapConnectorName);

		waitForElementVisible(operationButtonElement,driver,"Verify NewAccountButton is present");
		click(operationButtonElement,driver,"Clicked on NewAccount Button...");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public void removeConnector(String soapConnectorName) throws InterruptedException

	{

		log.info("Clicking on Soap connector name " + soapConnectorName);
		logExtentReport("Clicking on Soap connector name " + soapConnectorName);
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + soapConnectorName + "')]"));
		WebElement element = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));
		element.click();
        
		Thread.sleep(2000);
//		waitHelper.waitForElement(editDropdownElement, ObjectReader.reader.getExplicitWait());

		log.info("Three dot actions element is visible.....");
		logExtentReport("Three dot actions element is visible.....");
		editDropdownElement.click();
		Thread.sleep(2000);
		log.info("Clicking on remove button........");
		logExtentReport("Clicking on remove button........");
		WebElement removeButtonElement = driver.findElement(By.xpath("//a[@class='view-a ']/ancestor::li[@data-eventmap='actions-remove-button']"));
		removeButtonElement.click();
//		waitHelper.waitForElement(deleteButtonElement, ObjectReader.reader.getExplicitWait());
    	Thread.sleep(2000);
		log.info("Clicking on delete button........");
		logExtentReport("Clicking on delete  button........");
		deleteButtonElement.click();
        Thread.sleep(3000);
//		waitHelper.waitForElement(noConnectorTitleElement,40);

	}

	public void EditConnector(String soapConnectorName) throws Exception

	{

		log.info("Clicking on Soap connector name " + soapConnectorName);
		logExtentReport("Clicking on Soap connector name " + soapConnectorName);
		waitForElementNotVisible(loader, driver, "wait for page load");
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + soapConnectorName + "')]"));
		WebElement element = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));
		element.click();
		
		//waitHelper.waitForElement(editDropdownElement, ObjectReader.reader.getExplicitWait());
		WebElement element1 = driver.findElement(By.xpath("//i[@data-eventmap='actions-edit-dropdown']"));

		log.info("Three dot actions element is visible.....");
		logExtentReport("Three dot actions element is visible.....");
		element1.click();
		log.info("Clicking on remove button........");
		logExtentReport("Clicking on remove button........");
		EditButtonElement.click();
		
	}
	
	public void clickOnapplicontiondetailicon(String ApplicationName) throws Exception
    {
        WebElement element = findElement("//a[contains(text(), '"+ApplicationName+"')]/parent::div/span[@class='delite-icon dlt-icon-chevron-down icon-chevron-down']",driver);
        click(element, driver, "click on detailicon....");
    }
	
	public void EditAccount(String AccountName) throws Exception{
		WebElement element = findElement("//span[contains(text(),'"+AccountName+"')]/parent::div",driver);
		mousehover(element,driver,"mousehover on created SOAP connector " + AccountName);
		
		WebElement element1 = findElement("//span[contains(text(), '"+AccountName+"')]/following::div/span[@class='edit-pencil-icon delite-icon dlt-icon-edit ']",driver);
        click(element1, driver, "click on editicon");
        //return new AccountPage(driver);
		
	}
	
	
	public Boolean verifyURL(String url) throws Exception {
		log.info("Verifying the operation name  element is visible.... " + url);
		logExtentReport(" Verifying the operation name  element is visible.... " + url);
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'URL')]/following::input[@value='"+ url +"']"));
		
		return element.isDisplayed();

	}
	
	

	public String getSoapConnectorEmptyMessage() {
		log.info("Checking if  soap connector  are empty");
		logExtentReport("Checking if  soap connector are empty...");
		return noConnectorTitleElement.getText();

	}


	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement SuccessMessage;


	public String getSuccesMessageofImportfile() {
		log.info("Getting successMessage...");
		logExtentReport("Getting successMessage...");
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
		return SuccessMessage.getText();
	}

	public void waittillitappears() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ObjectReader.reader.getExplicitWait()));
		wait.until(ExpectedConditions.not(
				ExpectedConditions.textToBePresentInElement(SuccessMessage, SuccessMessage.getText())));
	}



	public void AddAccountButton(){

		log.info("Clicking on Soap connector name " );
		logExtentReport("Clicking on Soap connector name ");
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + soapConnectorName + "')]"));
		WebElement element = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));
		element.click();
//		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+soapConnectorName+"')]/preceding-sibling::span[1]"));
//		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
//        element.click();
//		waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElement(newAccountButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("NewAccountButton button is visible");
		logExtentReport("NewAccountButton button is visible");

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", newAccountButtonElement);

	}

	public void WaitTillElementappears(String soapConnectorName) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ObjectReader.reader.getExplicitWait()) );
		WebElement element = findElement("//a[contains(text(),'"+soapConnectorName+"')]",driver);
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		waitForElementVisible(element, driver, "waiting for the soap connector to be visible");
		//log.info("Expected Element is visible");
		//logExtentReport("Expected Element is visible");
		WebElement element1 = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));
//		waitHelper.waitForElement(element1, ObjectReader.reader.getExplicitWait());
		element1.click();
		log.info("NewAccountButton button is visible");
		logExtentReport("NewAccountButton button is visible");

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", newAccountButtonElement);
	}

	public boolean EnsureAccountCreated(String CreatedAccountNo) throws Exception{
		WebElement element = findElement("//div[contains(text(),'"+CreatedAccountNo+" Account(s) configured')]",driver);
		waitForElementVisible(element,driver,"Verify CreatedAccount is visible");
		return element.isDisplayed();
	}

        public boolean verifySoapConnectorName(String soapConnectorName) {
		log.info("Verifying the Soap connector name is visible....");
		logExtentReport(" Verifying the soap connector name is visible....");
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + soapConnectorName + "')]"));
		return element.isDisplayed();
	}

	public void addOperation(){
		log.info("Click Expand icon");
		logExtentReport("Click Expand icon");
		WebElement element = driver.findElement(By.xpath("//span[@class='delite-icon dlt-icon-chevron-down icon-chevron-down']"));
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(operationButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("Operation button is visible");
		logExtentReport("Operation button is visible");
		operationButtonElement.click();


	}

	public void DeleteSoapconnector(String soapConnectorName) throws Exception
	{
		WebElement element = findElement("//a[contains(text(),'"+soapConnectorName+"')]/parent::div/span[2]/img[contains(@class,'SOAP-icon')]",driver);
		mousehover(element,driver,"mousehover on created REST connector " + soapConnectorName);

		waitForElementVisible(newAccountButtonElement,driver,"Verify NewAccountButton is present");
		//click(newAccountButtonElement,driver,"Clicked on NewAccount Button...");
		List<WebElement> element1 = findElements("//*[@class='delite-icon dlt-icon-more-menu']",driver);
   		click(element1.get(0),driver,"click on first element");
   		WebElement element2 = driver.findElement(By.xpath("//span[@class='dlt-icon-delete icon-mr icon-pad icons-delete-certificate']"));
   		click(element2, driver, "Clicked on remove  button....");
   		waitForElementNotVisible(loader, driver, "wait for page load");
   		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(DeletesoapconnectorTest, ObjectReader.reader.getExplicitWait());
         WebElement element4 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
        click(element4, driver, "Clicked on Delete....");
        waitForElementVisible(EmptyConnectormessage,driver,"Verify the connector is deleted or not");

	}











}
