package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class AvailablePredefinedOperationPage extends CommonActions {

	WebDriver driver;
	private Logger log = LogManager.getLogger(AvailablePredefinedOperationPage.class);
	WaitHelper waitHelper;
	WebElement element;

	@FindBy(xpath = "//div[contains(text(),'Available Predefined Operations')]")
	@CacheLookup
	WebElement availablePredefinedOperationsElement;

	@FindBy(xpath = "//span[@title='Show i/o signature']")
	@CacheLookup
	WebElement showSignatureElement;

	@FindBy(xpath = "//span[@title='Test operation']")
	@CacheLookup
	WebElement testOperationButtonElement;
	
	//span[@class='dlt-icon-close close-icon']
	
	@FindBy(xpath = "//span[@class='dlt-icon-close operation-close-icon']")
	@CacheLookup
	WebElement closeIconElement;
	
	@FindBy(xpath = "//button[@class='btn btn-link btn-sm cancel-btn']")
	@CacheLookup
	WebElement closebutton;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public AvailablePredefinedOperationPage(WebDriver driver) throws Exception 
	{

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waitForElementVisible(availablePredefinedOperationsElement, driver, "Wait for operations page to visible");

	}
	public InputSignaturePage clickOnShowSignature() throws Exception
	
	{
		click(showSignatureElement, driver, "Click on showSignatureElement");
		
		return  new InputSignaturePage(driver);
		
	}
	
	public  TestOperationInputPage clickOnTestOperationButton() throws Exception 
	{

		click(testOperationButtonElement, driver, "Click on Test operation button");
		return  new TestOperationInputPage(driver);
	}
	
	public  TestOperationInputPage clickOnTestOperationButton1(int i) throws Exception 
	{
		WebElement element = findElement("(//span[@title='Test operation'])["+i+"]",driver);	
		click(element,driver,"Click on Test operation"+element);
		waitForElementNotVisible(loader, driver, "wait for page load");
		return  new TestOperationInputPage(driver);
	}
	
	
	public boolean verifyShowSignatureElement() throws Exception
	{
		waitForElementVisible(showSignatureElement, driver, "Wait for showSignatureElement visible");
		 return showSignatureElement.isDisplayed();
	}
	
	public SOAPConnectorHomePage clickOnCloseIcon() throws Exception 
	{
		log.info("Clicking on close icon on predefined operation page   .....");
		logExtentReport(" Clicking on close icon on predefined operation page   .....");
//		waitHelper.waitForElement(closeIconElement, ObjectReader.reader.getExplicitWait());
		Thread.sleep(7000);
		closeIconElement.click();
		return  new SOAPConnectorHomePage(driver);
	}
	
	public void closeShowIOSignature() throws Exception
	{
		log.info("Clicking on close button on Input and Output Signature page   .....");
		logExtentReport(" Clicking on close button on Input and Output Signature page   .....");
		Thread.sleep(3000);
		closebutton.click();	
	}
	
}

