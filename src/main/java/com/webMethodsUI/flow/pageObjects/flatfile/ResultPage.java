package com.webMethodsUI.flow.pageObjects.flatfile;

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

public class ResultPage extends CommonActions{
	WebDriver driver;
	private Logger log = LogManager.getLogger(ResultPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//div[contains(text(),'Available Predefined Operations')]")
	@CacheLookup
	WebElement predefinedOperationsTitleElement;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement cancelButtonElement;
	
	@FindBy(xpath = "//span[@class='delite-icon dlt-icon-success']")
	@CacheLookup
	WebElement successLabelElement;
	
	
	
	
	
	public ResultPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(cancelButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + cancelButtonElement);
		logExtentReport("AddConnectorPage Object created");
	}
	
	public String cancelButton() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +cancelButtonElement.getText());
        return cancelButtonElement.getText();
	}
	
	public String verifySuccessLabel() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +successLabelElement);
		return successLabelElement.getText();
	}
}
