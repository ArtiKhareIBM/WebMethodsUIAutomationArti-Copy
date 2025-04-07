package com.webMethodsUI.flow.pageObjects.ReferenceData;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class NewRefereceDataPage extends CommonActions{
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(NewRefereceDataPage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h5[contains(text(),'New Reference Data')]")
	@CacheLookup
	WebElement newReferenceDataPageTitleElement;
	
	
	//input[@id='save-as']
	
	
	@FindBy(xpath = "//input[@id='save-as']")
	@CacheLookup
	WebElement saveAsElement;
	
	@FindBy(xpath = "//textarea[@id='description']")
	@CacheLookup
	WebElement descriptionFieldElement;
	
	
	//label[contains(text(),'Browse file')]
	
	@FindBy(xpath = "//label[contains(text(),'Browse file')]")
	@CacheLookup
	WebElement browseElement;
	
	
	@FindBy(xpath = "//label[contains(text(),'Edit')]")
	@CacheLookup
	WebElement editElement;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;
	
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement doneButtonElement;
	
	
	public NewRefereceDataPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(newReferenceDataPageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("  New Reference data  page...." + newReferenceDataPageTitleElement);
		logExtentReport(" New Reference data  page...." + newReferenceDataPageTitleElement);
	}

	public void clickOnNextButtonElement() {
		log.info("  Clicking on next  button...");
		logExtentReport("  Clicking on next  button.. ...");
		waitHelper.waitForElement(nextButtonElement, ObjectReader.reader.getExplicitWait());
		nextButtonElement.click();

	}

	public void clickOnNextButtonElementoafterscroll() {
		log.info("  Clicking on next  button  on define page ...");
		logExtentReport("  Clicking on next  button on define page.. ...");
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].scrollIntoView(true);",nextButtonElement);

		nextButtonElement.click();

	}
	
	public void clickOnDoneButtonElement() {
		log.info("  Clicking on next  button...");
		logExtentReport("  Clicking on next  button.. ...");
		waitHelper.waitForElement(doneButtonElement, ObjectReader.reader.getExplicitWait());
		doneButtonElement.click();

	}
	
	public void entername(String referencedataName) {
		log.info("  Clicking on next  button...");
		logExtentReport("  Clicking on next  button.. ...");
		waitHelper.waitForElement(saveAsElement, ObjectReader.reader.getExplicitWait());
		saveAsElement.click();
		saveAsElement.sendKeys(referencedataName);

	}
	
	
	public void enterDescription(String referencedatades) {
		log.info("  Clicking on next  button...");
		logExtentReport("  Clicking on next  button.. ...");

		descriptionFieldElement.click();
		descriptionFieldElement.sendKeys(referencedatades);

	}
	
	public void scrollingThePageToUploadFile() {
		log.info("  Clicking on next  button...");
		logExtentReport("  Clicking on next  button.. ...");
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].scrollIntoView(true);",browseElement);
		
	}

}
