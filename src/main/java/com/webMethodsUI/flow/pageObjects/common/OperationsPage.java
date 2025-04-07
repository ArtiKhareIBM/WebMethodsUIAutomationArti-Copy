package com.webMethodsUI.flow.pageObjects.common;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.TestOperationInputPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import java.util.List;

public class OperationsPage extends CommonActions{
	private WebDriver driver;
	private Logger log = LogManager.getLogger(OperationsPage.class);
	WebElement element;

	WaitHelper waitHelper;

	@FindBy(xpath = "//span[@class='operation-title']")
	@CacheLookup
	WebElement operationPageTitleElemnt;
	
	@FindBy(xpath = "//span[@class='single-operation-value']")
	@CacheLookup
	WebElement singleOperationNameElemnt;
	
	@FindBy(xpath = "//span[@class='dlt-icon-close close-icon']")
	@CacheLookup
	WebElement closeLinkElemnt;

	public OperationsPage(WebDriver driver) {
		super();
		this.driver = driver;

		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);

		waitHelper.waitForElement(operationPageTitleElemnt, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." +operationPageTitleElemnt);
		logExtentReport("Operation page object is created...");

	}
	
	
	public void getOperationPageTitle() throws Exception {
		WebElement element = findElement("//span[@class='operation-title']", driver);
		elementContainsText(element, "testautomation_app Operations", driver, "Verify Operation page title is visible");
	}

	public String getSingleOperationName() {
		return singleOperationNameElemnt.getText();

	}

	public String getOperationName(int i) {
		List<WebElement> ele = driver.findElements(By.xpath("//span[@class='single-operation-value']"));
		WebElement ele1 = ele.get(i);
		return ele1.getText();
	}

	public void clickOnClose() throws Exception {

		WebElement element = findElement("//span[contains(@class,'operation-close-icon')]", driver);
		click(element, driver, "Click on close icon");
	}

	public void verifyOperation(String operationName) throws Exception {

		WebElement element = findElement("//span[contains(text(),'" + operationName + "')]", driver);
		waitForElementVisible(element, driver, "Verify Operation name is visible");
	}
	
	public void clickOnShowIoOperationOnPrem()throws Exception
	{
		WebElement element = findElement("//span[contains(@class,'operation-action-icons wmio-io-signature-icon')]", driver);
		click(element, driver, "Click on show I/o Operation icon");
		
	}
	
	public void closeShowIoOperationOnPrem()throws Exception
	{
		WebElement element = findElement("//button[@class='btn btn-link btn-sm cancel-btn']", driver);
		click(element, driver, "Click on close button");
		
	}
	
	public void getShowIoOperationPageTitle() throws Exception {
		WebElement element = findElement("//h1[@class='modal-title']", driver);
		elementContainsText(element, "AddInts Input and Output Signature", driver, "Verify Operation page title is visible");
	}
	
	public void clickOnTestOperation() throws Exception
	{
		WebElement element1 = findElement("//span[contains(@class,'operation-action-icons wmio-test-operation-icon ')]", driver);
		click(element1, driver, "Click on Test operation button");

	}

}
