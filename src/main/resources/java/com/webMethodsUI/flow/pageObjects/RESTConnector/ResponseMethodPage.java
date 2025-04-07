package com.webMethodsUI.flow.pageObjects.RESTConnector;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class ResponseMethodPage {

	WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Response')]")
	@CacheLookup
	WebElement responseTab;
	
	@FindBy(xpath = "//span[contains(text(),'No Headers to be displayed.')]")
	@CacheLookup
	WebElement emptyHeaderMessageElemnt;

	public ResponseMethodPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("ResponseMethodPage PageObject created");
	}
	
	public HeadersPage clickOnAddHeadersButton(String buttonName) throws Exception 
	{
		GenericHelper genericHelper = new GenericHelper(driver);
		genericHelper.clickButtonLink(buttonName);
		return new HeadersPage(driver);
	}
	
	public ResponseBodyPage clickOnAddBodyButton(String buttonName) throws Exception
	{
		GenericHelper genericHelper = new GenericHelper(driver);
		genericHelper.clickButtonLink(buttonName);

		return new ResponseBodyPage(driver);
	}
	
	public String getemptyHeaderMessage() {
		
		return emptyHeaderMessageElemnt.getText();
		
	}
}
