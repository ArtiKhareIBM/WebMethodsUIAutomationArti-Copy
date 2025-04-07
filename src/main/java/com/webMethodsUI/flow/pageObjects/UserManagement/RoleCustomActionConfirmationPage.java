package com.webMethodsUI.flow.pageObjects.UserManagement;
import javax.lang.model.element.Element;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class RoleCustomActionConfirmationPage extends CommonActions{
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(RoleCustomActionConfirmationPage.class);
	TestBase test;
	WaitHelper waitHelper;
	
	
	@FindBy(xpath = "//span[contains(text(),'Confirm Action')]")
	@CacheLookup
	WebElement confirmActionTitleElement;
	
	
	
	
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement confirmActionDoneElement;
	

	
	
	
	public RoleCustomActionConfirmationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(confirmActionTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + confirmActionTitleElement);
		logExtentReport("add custom Operation Object created");
	}
	
	
	public RoleFlowserviceCanvasPage clickOnDone() throws Exception {
		log.info("Clicking on Done button...");
		logExtentReport("Clicking on Done button...");
		GenericHelper genericHelper = new GenericHelper(driver);
		genericHelper.clickButton("Done");
		Thread.sleep(4000);
		
		return new RoleFlowserviceCanvasPage(driver);
		
	}
	
	
	public void clickdonebutton() throws Exception {
		log.info("Clicking on Done button...");
		logExtentReport("Clicking on Done button...");
		GenericHelper genericHelper = new GenericHelper(driver);
		genericHelper.clickButton("Done");
		Thread.sleep(4000);
	}
	
	
	public String getconfirmActionTitle() {
		
		return confirmActionTitleElement.getText();
		
	}
	
	
	public String getConfirmActionsDetailsByValue(String Value) {
		
	try {
		log.info("getting value for " +Value);
		logExtentReport("getting vaue for..." +Value);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+Value+"')]"));
		return element.getText();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "no elemnt found with value " +Value;
	}
	
	
	/*
	 * public void clickOnDone() { log.info("Clicking on Done button....");
	 * logExtentReport("Clicking on Done button...."); Actions action = new
	 * Actions(driver); action.click(confirmActionDoneElement).build().perform();
	 * 
	 * }
	 */


}
