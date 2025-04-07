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
import com.webMethodsUI.flow.testbase.TestBase;

import java.util.List;

public class OperationsPage {
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
	
	
	public String getOperationPageTitle() {
		return operationPageTitleElemnt.getText();
	}


	public String getSingleOperationName() {
		return singleOperationNameElemnt.getText();
		
		
		
	}


	public String getOperationName(int i){
		List<WebElement> ele = driver.findElements(By.xpath("//span[@class='single-operation-value']"));
		WebElement ele1 = ele.get(i);
		return ele1.getText();
	}
	
	
	public void clickOnClose() {
		
		log.info("clicking on close icon...");
		logExtentReport("Clicking on close element.....");
		closeLinkElemnt.click();
	}

}
