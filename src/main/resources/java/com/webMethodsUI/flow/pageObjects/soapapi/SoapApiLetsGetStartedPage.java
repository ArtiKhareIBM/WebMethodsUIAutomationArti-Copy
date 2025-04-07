package com.webMethodsUI.flow.pageObjects.soapapi;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class SoapApiLetsGetStartedPage {
	
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(SoapApiLetsGetStartedPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//span[contains(text(),'get started')]")
	@CacheLookup
	WebElement getStartedTitleElement;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;


	@FindBy(xpath = "//div[@class='create-new-manage-api']//div[2]//p[1]//div[1]//label[1]")
	@CacheLookup
	WebElement importAPIButtonElement;


	@FindBy(xpath = "//div[@class='create-new-manage-api']//div[3]//p[1]//div[1]//label[1]/span")
	@CacheLookup
	WebElement importAPIfromURLElement;


	public SoapApiLetsGetStartedPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(getStartedTitleElement, ObjectReader.reader.getExplicitWait());
		
		log.info("element is visible now...." +getStartedTitleElement);
		
	}
	
	
	
	public SoapApiBasicInfoPage clickOnNext() {
		
		try {
			log.info("clicking on Next button...");
			logExtentReport("clicking on Next button...");
			waitHelper.waitForElement(nextButtonElement, ObjectReader.reader.getExplicitWait());
			nextButtonElement.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SoapApiBasicInfoPage(driver);
		
		
		
	}


	public void ClickImportAPIbutton(){
		log.info("clicking importAPIButton..............");
		logExtentReport("clicking  importAPIButton..............");
		waitHelper.waitForElement(importAPIButtonElement, ObjectReader.reader.getExplicitWait());
		importAPIButtonElement.click();
	}

	public void clickingImportfromurlbutton(){
		log.info("clicking importAPIfromURLButton..............");
		logExtentReport("clicking  importAPIfromURLButton..............");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",importAPIfromURLElement);

	}

}
