package com.webMethodsUI.flow.pageObjects.monitor;



import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class MonitorPage {
	private WebDriver driver;
	private Logger log = LogManager.getLogger(MonitorPage.class);
	WebElement element;

	WaitHelper waitHelper;

	

	@FindBy(xpath = "//h1[contains(text(),'Monitor')]")
	@CacheLookup
	public static WebElement monitorPageTitleElement;

	
	
	@FindBy(xpath = "//span[contains(text(),'General')]")
	@CacheLookup
	public static WebElement generalTextElement;
	
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Audit logs')]")
	@CacheLookup
	public static WebElement auditLogsTextElement;
	
	
	@FindBy(xpath = "//*[contains(text(),'Usage')]")
	@CacheLookup
	public static WebElement usagesTextElement;
	
	public MonitorPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(monitorPageTitleElement, ObjectReader.reader.getExplicitWait());

		log.info("element is visible now....");
		// new TestBase().getNavigationScreen(driver);

	}
	
	
	public void expandGeneralArrowIcon() {
		log.info("Clicking on General Text on Monitor Page.......  ");
		logExtentReport("Clicking on General Text on Monitor Page... ");
		waitHelper.waitForElement(generalTextElement, ObjectReader.reader.getExplicitWait());
		generalTextElement.click();
		

	}
	
	public void clickOnAuditLogLabel() {
		log.info("Clicking on Audit log  label on Monitor Page.......  ");
		logExtentReport("Clicking on Audit log label on Monitor Page... ");
		waitHelper.waitForElement(auditLogsTextElement, ObjectReader.reader.getExplicitWait());
		auditLogsTextElement.click();
		

	}
	
	public void clickOnUsagesLabel() {
		log.info("Clicking on Audit log  label on Monitor Page.......  ");
		logExtentReport("Clicking on Audit log label on Monitor Page... ");
		waitHelper.waitForElement(usagesTextElement, ObjectReader.reader.getExplicitWait());
		usagesTextElement.click();
		

	}
	
	
	

}
