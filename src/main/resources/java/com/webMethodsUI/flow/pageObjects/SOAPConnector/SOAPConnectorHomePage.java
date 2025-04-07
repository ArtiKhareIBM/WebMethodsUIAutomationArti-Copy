package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SOAPConnectorHomePage {

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


	@FindBy(xpath = "//span[@data-eventmap='actions-edit-button']")
	@CacheLookup
	WebElement EditButtonElement;

	@FindBy(xpath = "//span[@data-eventmap='actions-remove-button']")
	@CacheLookup
	WebElement removeButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	WebElement deleteButtonElement;

	@FindBy(xpath = "//div[@class='no-table-data']")
	@CacheLookup
	WebElement noConnectorTitleElement;

	public SOAPConnectorHomePage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(soapConnectorTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + soapConnectorTitleElement);
		logExtentReport(
				"element is visible now.... and element text is  " + soapConnectorTitleElement.getText());

	}

	public boolean verifyAddConnectorButton() {
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

	public void clickOnOperationButton(String soapConnectorName) {

		log.info("Clicking on Soap connector name " + soapConnectorName);
		logExtentReport("Clicking on Soap connector name " + soapConnectorName);
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + soapConnectorName + "')]"));
		WebElement element = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(operationButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("Operation button is visible");
		logExtentReport("Operation button is visible");
//		operationButtonElement.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", operationButtonElement);

	}

	public void removeConnector(String soapConnectorName) throws InterruptedException

	{

		log.info("Clicking on Soap connector name " + soapConnectorName);
		logExtentReport("Clicking on Soap connector name " + soapConnectorName);
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + soapConnectorName + "')]"));
		WebElement element = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));
		element.click();

		waitHelper.waitForElement(editDropdownElement, ObjectReader.reader.getExplicitWait());

		log.info("Three dot actions element is visible.....");
		logExtentReport("Three dot actions element is visible.....");
		editDropdownElement.click();
		log.info("Clicking on remove button........");
		logExtentReport("Clicking on remove button........");
		removeButtonElement.click();
		waitHelper.waitForElement(deleteButtonElement, ObjectReader.reader.getExplicitWait());
		//Thread.sleep(2000);
		log.info("Clicking on delete button........");
		logExtentReport("Clicking on delete  button........");
		deleteButtonElement.click();
       Thread.sleep(3000);
		//waitHelper.waitForElement(noConnectorTitleElement,40);

	}

	public void EditConnector(String soapConnectorName) throws InterruptedException

	{

		log.info("Clicking on Soap connector name " + soapConnectorName);
		logExtentReport("Clicking on Soap connector name " + soapConnectorName);
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + soapConnectorName + "')]"));
		WebElement element = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));
		element.click();

		waitHelper.waitForElement(editDropdownElement, ObjectReader.reader.getExplicitWait());

		log.info("Three dot actions element is visible.....");
		logExtentReport("Three dot actions element is visible.....");
		editDropdownElement.click();
		log.info("Clicking on remove button........");
		logExtentReport("Clicking on remove button........");
		EditButtonElement.click();
//		waitHelper.waitForElement(deleteButtonElement, ObjectReader.reader.getExplicitWait());
//		//Thread.sleep(2000);
//		log.info("Clicking on delete button........");
//		logExtentReport("Clicking on delete  button........");
//		deleteButtonElement.click();
//		Thread.sleep(3000);
		//waitHelper.waitForElement(noConnectorTitleElement,40);

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
		WebDriverWait wait = new WebDriverWait(driver, ObjectReader.reader.getExplicitWait());
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

	public void WaitTillElementappears(String soapConnectorName){
		WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait() );
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+soapConnectorName+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Expected Element is visible");
		logExtentReport("Expected Element is visible");
		WebElement element1 = driver.findElement(By.xpath("//img[@class='app-icon SOAP-icon']"));
		waitHelper.waitForElement(element1, ObjectReader.reader.getExplicitWait());
		element1.click();
		log.info("NewAccountButton button is visible");
		logExtentReport("NewAccountButton button is visible");

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", newAccountButtonElement);
	}

	public boolean EnsureAccountCreated(String CreatedAccountNo){
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+CreatedAccountNo+" Accounts configured')]"));
		log.info("EnsureAccountCreated with " +element);
		logExtentReport("EnsureAccountCreated with " +element);
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
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











}
