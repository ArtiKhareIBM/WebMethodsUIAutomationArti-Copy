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

public class ProcessingOptionsPage extends CommonActions{

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
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public ProcessingOptionsPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForElementVisible(ProcessingOptionsTextElement, driver, "  verifing  Processing  Options  text is visible  ....",45);
		
	}
	
	public void clickOnNextButton() throws Exception
	{
		click(nextButtonElement, driver, "  Clicking on next button...");
		waitForElementNotVisible(loader, driver, "wait for page load");

	}
	
	
	public boolean verifyPreviousButtonEnabled() 
	{
		log.info("  Verifing previous button is enabled.. ...");
		logExtentReport(" Verifing previous button is enabled.....");
		 return previousButtonElement.isEnabled();

	}
	
	
	
}
