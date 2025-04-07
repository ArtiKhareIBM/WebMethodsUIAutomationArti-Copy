package com.webMethodsUI.flow.pageObjects.ReferenceData;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class DefineReferenceDataPage {
	private WebDriver driver;
	private Logger log = LogManager.getLogger(NewRefereceDataPage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h4[contains(text(),'Define reference data')]")
	@CacheLookup
	WebElement defineReferenceDataTitleElement;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;
	
	public DefineReferenceDataPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(defineReferenceDataTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("  New Reference data  page...." + defineReferenceDataTitleElement);
		logExtentReport(" New Reference data  page...." + defineReferenceDataTitleElement);
	}

	public void clickOnNextButtonElement() {
		log.info("  Clicking on next  button. on define reference data page ..");
		logExtentReport("  Clicking on next  button. define reference data page .. ...");
		waitHelper.waitForElement(nextButtonElement, ObjectReader.reader.getExplicitWait());
		nextButtonElement.click();

	}

}
