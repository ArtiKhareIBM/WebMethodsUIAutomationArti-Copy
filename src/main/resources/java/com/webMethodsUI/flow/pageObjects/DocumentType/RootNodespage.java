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

public class RootNodespage {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(RootNodespage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h5[contains(text(),'Select Root Nodes')]")
	@CacheLookup
	WebElement selectRootNodesTextElement;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement doneButtonElement;

	@FindBy(xpath = "//input[@id='checkbox-0']")
	@CacheLookup
	WebElement rootNodesCheckBoxElement;
	
	
	
	@FindBy(xpath = "//label[@for='checkbox-0']")
	@CacheLookup
	WebElement rootNodesCheckBoxlabelElement;
	

	public RootNodespage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(selectRootNodesTextElement, ObjectReader.reader.getExplicitWait());
		log.info("  verifing  select root nodes   text is visible  ...." + selectRootNodesTextElement);
		logExtentReport("  verifing  select root nodes  text is visible  ....");
	}

	public void clickOnDoneButton() {
		log.info("  Clicking on next button...");
		logExtentReport(" Clicking on next button....");
		waitHelper.waitForElement(doneButtonElement, ObjectReader.reader.getExplicitWait());
		doneButtonElement.click();

	}

	public void selectRootNodes() {
		log.info("  Clicking on root nodes label...");
		logExtentReport(" Clicking on root nodes label....");
		waitHelper.waitForElement(rootNodesCheckBoxlabelElement, ObjectReader.reader.getExplicitWait());
		rootNodesCheckBoxlabelElement.click();

	}

	public boolean verifyRootNodesCheckBoxSelected() {
		log.info(" Verifing root nodes check boxes are selected...");
		logExtentReport("  Verifing root nodes check boxes are selected...");
		return rootNodesCheckBoxElement.isSelected();

	}
}
