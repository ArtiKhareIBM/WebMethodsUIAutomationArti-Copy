package com.webMethodsUI.flow.pageObjects.DocumentType;

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

public class AddNewDocumentTypeFromXSDPage extends CommonActions{
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(DocumentTypeMainpage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h3[contains(text(),'File Description')]")
	@CacheLookup
	WebElement fileDescriptionElement;
	
	
	
	
	@FindBy(xpath = "//input[@id='text-name']")
	@CacheLookup
	WebElement documentTypeNameElement;
	
	
	
	
	
	@FindBy(xpath = "//textarea[@id='text-area-1']")
	@CacheLookup
	WebElement documentTypeDescriptionElement;
	
	
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;
	
	
	public AddNewDocumentTypeFromXSDPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(fileDescriptionElement, ObjectReader.reader.getExplicitWait());
		log.info("  verifing  file description  text is visible  ...." + fileDescriptionElement);
		logExtentReport(" verifing  file description  text is visible  ....");
	}

	public void enterDocumentTypeName(String docTypeName) {
		log.info("  Entering document type name ...");
		logExtentReport(" Entering document type name ... ...");

		documentTypeNameElement.sendKeys(docTypeName);

	}
	
	
	public void enterDocumentTypeDescription(String docTypeDescription) {
		log.info("  Entering document type description ...");
		logExtentReport(" Entering document type description ... ...");
		documentTypeDescriptionElement.sendKeys(docTypeDescription);
		

	}

	public void clickOnNextButton() {
		log.info("  Clicking on next button...");
		logExtentReport(" Clicking on next button....");
		waitHelper.waitForElement(nextButtonElement, ObjectReader.reader.getExplicitWait());
		nextButtonElement.click();
		

	}
	
	
	

}
