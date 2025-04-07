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

public class OutputSignaturePage extends CommonActions{
	
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(OutputSignaturePage.class);
	WaitHelper waitHelper;
	WebElement element;

	@FindBy(xpath = "//div[contains(text(),'OUTPUT')]")
	@CacheLookup
	WebElement outputTitleElement;

	@FindBy(xpath = "//i[@class='tree-icon dlt-icon-plus']")
	@CacheLookup
	WebElement plusIconElement;
	
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	@CacheLookup
	WebElement closeButtonElement;
	
	public OutputSignaturePage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(outputTitleElement, ObjectReader.reader.getExplicitWait());
		log.info(" Output element is visible in i/o signature page....");
		logExtentReport("output element is visible in i/o signature page.... and element text is  "
				+ outputTitleElement.getText());

	}
	
	
	
	public void clickOnPlusIcon() {
		log.info(" Clicking on plus icon on input signature  page.........");
		logExtentReport("Clicking on plus icon on input signature  page.........");
		waitHelper.waitForElement(plusIconElement, ObjectReader.reader.getExplicitWait());
		plusIconElement.click();

	}
	
	public boolean verifyOutputField(String fieldName) {

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + fieldName + "')]"));
		log.info(" Verifying " + element.getText() + "  element is display on input signatur field.........");
		logExtentReport(
				" Verifying \"+element.getText()+\"  element is display on input signatur field.........");

		return element.isDisplayed();
	}
	
    public void clickOnCloseButton() {
	log.info(" Clicking on close button on output signature  page.........");
	logExtentReport("Clicking on close button on output signature  page.........");
	waitHelper.waitForElement(closeButtonElement, ObjectReader.reader.getExplicitWait());
	closeButtonElement.click();
	
	
}


}
