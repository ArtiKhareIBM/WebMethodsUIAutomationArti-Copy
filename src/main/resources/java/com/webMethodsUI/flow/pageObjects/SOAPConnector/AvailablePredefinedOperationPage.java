package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class AvailablePredefinedOperationPage {

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

	public AvailablePredefinedOperationPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(availablePredefinedOperationsElement, ObjectReader.reader.getExplicitWait());
		log.info("Available Predefined Operations page element is visible now....");
		logExtentReport(" Available Predefined Operations  page is visible now.... and element text is  "
				+ availablePredefinedOperationsElement.getText());

	}
	public InputSignaturePage clickOnShowSignature()
	
	{
		waitHelper.waitForElement(showSignatureElement, ObjectReader.reader.getExplicitWait());
		showSignatureElement.click();
		log.info("Clicking on show signature icon  .....");
		logExtentReport(" Clicking on show signature icon  ..... and element text is  "
				+ showSignatureElement.getText());
		
		return  new InputSignaturePage(driver);
		
	}
	
	public  TestOperationInputPage clickOnTestOperationButton() {
		waitHelper.waitForElement(testOperationButtonElement, ObjectReader.reader.getExplicitWait());
		testOperationButtonElement.click();
		
		log.info("Clicking on Test operation button   .....");
		logExtentReport(" Clicking on Test operation button ...  .... and element text is  "
				+ testOperationButtonElement.getText());
		
		return  new TestOperationInputPage(driver);
	}
	
	
	public boolean verifyShowSignatureElement() {
		log.info("Verify show signature. element is visible .. ..  .....");
		logExtentReport("Verify show signature. element is visible ....... and element text is  "
				+ showSignatureElement.getText());
		
		 return showSignatureElement.isDisplayed();
	}
	
	public SOAPConnectorHomePage clickOnCloseIcon() {
		log.info("Clicking on close icon on predefined operation page   .....");
		logExtentReport(" Clicking on close icon on predefined operation page   .....");
		waitHelper.waitForElement(closeIconElement, ObjectReader.reader.getExplicitWait());
		closeIconElement.click();
		return  new SOAPConnectorHomePage(driver);
	}
	
}

