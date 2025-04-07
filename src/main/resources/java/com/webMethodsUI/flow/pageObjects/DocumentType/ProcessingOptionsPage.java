package com.webMethodsUI.flow.pageObjects.DocumentType;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class ProcessingOptionsPage {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(FileDescriptionPage.class);
	TestBase test;
	
	WaitHelper waitHelper;

	@FindBy(xpath = "//h5[contains(text(),'Processing Options')]")
	@CacheLookup
	WebElement ProcessingOptionsTextElement;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;
	
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	@CacheLookup
	WebElement previousButtonElement;
	
	public ProcessingOptionsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(ProcessingOptionsTextElement, ObjectReader.reader.getExplicitWait());
		log.info("  verifing  Processing  Options  text is visible  ...." + ProcessingOptionsTextElement);
		logExtentReport(" verifing  Processing  Options  text is visible  ....");
	}
	
	public void clickOnNextButton() {
		log.info("  Clicking on next button...");
		logExtentReport(" Clicking on next button....");
		waitHelper.waitForElement(nextButtonElement, ObjectReader.reader.getExplicitWait());
		nextButtonElement.click();

	}
	
	
	public boolean verifyPreviousButtonEnabled() {
		log.info("  Verifing previous button is enabled.. ...");
		logExtentReport(" Verifing previous button is enabled.....");
		 return previousButtonElement.isEnabled();

	}
	
	
	
}
