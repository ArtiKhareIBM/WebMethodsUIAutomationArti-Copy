package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import java.time.Duration;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DefineSoapConnector extends CommonActions{
	
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(DefineSoapConnector.class);
	WaitHelper waitHelper;
	
	
	@FindBy(xpath = "//h1[contains(text(),'Define Connector')]")
	@CacheLookup
	WebElement defineConnetorPageTitleElement;
	
	
	@FindBy(xpath = "//input[@placeholder='Provide a suitable name for this Connector']")
	@CacheLookup
	WebElement soapConnectorNameElement;
	
	@FindBy(xpath = "//textarea[contains(@placeholder,'Provide a short description for this Connector')]")
	@CacheLookup
	WebElement soapConnectorDescriptionElement;
		
	@FindBy(xpath = "//input[@name='user']")
	@CacheLookup
	WebElement usernameTextfieldElement;
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement passwordTextFieldElement;
	
	@FindBy(xpath = "//span[@class='switch-label default']")
	@CacheLookup
	WebElement validateSchemaElement;
	
	@FindBy(xpath = "//input[@placeholder='Provide a url']")
	@CacheLookup
	WebElement importURLElement;

	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public DefineSoapConnector(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(defineConnetorPageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +defineConnetorPageTitleElement.getText());
		
	}
	
	public void enterSOAPConnectorName(String connectorName)
	{
		log.info("Creating SOAP connector with name... " + connectorName);
		logExtentReport("Creating SOAP connector with name... " + connectorName);
		soapConnectorNameElement.sendKeys(connectorName);
		
	}
	
	public void enterSOAPConnectorDescription(String connectorDescription)
	
	{
		
		log.info("Adding SOAP connector description... " + connectorDescription);
		logExtentReport("Adding  SOAP connector description  with name... " + connectorDescription);
		soapConnectorDescriptionElement.sendKeys(connectorDescription);
	}
	
	public void enterImportURL(String importURL) 
	{
		log.info("Entering soap connector url " + importURL);
		logExtentReport(" Entering soap connector url with url... " + importURL);
		importURLElement.clear();
		importURLElement.sendKeys(importURL);
	}

	
	public void SelectOverrideWSDL() throws Exception	
	{
		
		log.info("Select overrride WSDL radiobutton... ");
		logExtentReport("Selecting overrride WSDL radiobutton... ");
		WebElement element =  findElement("//span[text()='Yes, Override WSDL']",driver);
		click(element,driver,"Select Yes, Override WSDL");
	}
	
	
	public void enterUsername(String userName) {
		log.info("Entering user Name:  " + userName);
		logExtentReport("Entering user Name: " + userName);
		usernameTextfieldElement.sendKeys(userName);

	}

	public void enterPassword(String password) {
		log.info("Entering password " + password);
		logExtentReport("Entering password " + password);
		passwordTextFieldElement.sendKeys(password);
	}

	
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement SuccessMessage;
	
	public void clicksavebutton() throws Exception
	{
		WebElement element = findElement("//button[contains(text(),'Save')]",driver);
		click(element,driver,"Click save button");
		waitForElementNotVisible(loader, driver, "wait for page load",45);
		//elementContainsText(SuccessMessage, "Successfully created the connector.", driver, "Verfiy notification message is visible");
	}
	
	public void clickconfirmsavebutton() throws Exception
	{
		WebElement element = findElement("//button[@type='button'][text()='Save']",driver);
		click(element,driver,"Click save button in confirm pop up");
		waitForElementNotVisible(loader, driver, "wait for page load",45);
		//elementContainsText(SuccessMessage, "Successfully created the connector.", driver, "Verfiy notification message is visible");
	}


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




}


	
	
	
	


