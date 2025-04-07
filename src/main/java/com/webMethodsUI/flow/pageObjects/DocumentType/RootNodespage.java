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

public class RootNodespage extends CommonActions{

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
	
	String RootNodeHeader = "//h3[text()='Root Nodes']";

	@FindBy(xpath = "//input[@id='checkbox-0']")
	@CacheLookup
	WebElement rootNodesCheckBoxElement;
	
	
	
	@FindBy(xpath = "//label[@for='checkbox-0']")
	@CacheLookup
	WebElement rootNodesCheckBoxlabelElement;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	

	public RootNodespage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForElementVisible(selectRootNodesTextElement, driver, "  verifing  select root nodes   text is visible  ....",45);
	}

	public void clickOnDoneButton() throws Exception 
	{
		click(doneButtonElement, driver, "  Clicking on next button...");
		waitForElementNotVisible(RootNodeHeader, driver, "wait for RootNodeHeader label to invisible",45);
	}

	public void selectRootNodes() throws Exception 
	{

		click(rootNodesCheckBoxlabelElement, driver, "  Clicking on root nodes label...");

	}

	public boolean verifyRootNodesCheckBoxSelected() {
		log.info(" Verifing root nodes check boxes are selected...");
		logExtentReport("  Verifing root nodes check boxes are selected...");
		return rootNodesCheckBoxElement.isSelected();

	}
}
