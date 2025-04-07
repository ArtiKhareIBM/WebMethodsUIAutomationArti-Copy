package com.webMethodsUI.flow.pageObjects.monitor;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class UsagesPage {
	
	
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(MonitorPage.class);
	WebElement element;

	WaitHelper waitHelper;
	

	@FindBy(xpath = "//*[contains(text(),'Usage')]")
	@CacheLookup
	public static WebElement usagesTextElement;
	
	
	
	@FindBy(xpath = "//h1[contains(text(),'Transaction Usage')]")
	@CacheLookup
	public static WebElement transactionUsagesTextElement;
	

	
	public  UsagesPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(transactionUsagesTextElement, ObjectReader.reader.getExplicitWait());

		log.info("element is visible now....");
		// new TestBase().getNavigationScreen(driver);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickOnUsageLabel() {
		log.info("Clicking on usages  label on Monitor Page.......  ");
		logExtentReport("Clicking onUsages label on Monitor Page... ");
		usagesTextElement.click();
		

	}

}
