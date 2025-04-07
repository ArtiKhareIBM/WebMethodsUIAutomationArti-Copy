package com.webMethodsUI.flow.pageObjects.restapi;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class NewAPIPage {
	WebDriver driver;
	private Logger log = LogManager.getLogger(NewAPIPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//span[@class='title-start']")
	@CacheLookup
	WebElement getStartedTitleElement;
	
	@FindBy(xpath = "//div[@class='create-api-inner-content']//div[1]//p[1]//div[1]//label[1]")
	@CacheLookup
	WebElement createFromscratchButtonElement;
	
	@FindBy(xpath = "//div[@class='create-new-manage-api']//div[2]//p[1]//div[1]//label[1]")
	@CacheLookup
	WebElement importAPIButtonElement;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;
	
	public NewAPIPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(getStartedTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +getStartedTitleElement.getText());

	}
	
	public String getStartedTitle() {
		log.info("Getting the get started title..............");
		logExtentReport("Getting the get started title..............");
		return getStartedTitleElement.getText();
	}
	
	public String createFromscratchButton() {
		log.info("Getting the createFromscratchButton..............");
		logExtentReport("Getting the createFromscratchButton..............");
		return createFromscratchButtonElement.getText();
	}
	
	public String importAPIButton() {
		log.info("Getting the importAPIButton..............");
		logExtentReport("Getting the importAPIButton..............");
		return importAPIButtonElement.getText();
	}
	public String nextButton() {
		log.info("Getting the nextButton..............");
		logExtentReport("Getting the nextButton..............");
		return nextButtonElement.getText();
	}
	
	
	
	
	

}
