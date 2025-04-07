package com.webMethodsUI.flow.pageObjects.RESTConnector;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ConnectorsPage extends CommonActions{

	WebDriver driver;
	
	@FindBy(xpath = "//*[contains(text(),'Predefined Connectors')]")
	@CacheLookup
	public static WebElement PredefinedConnectorTitle;
	
	@FindBy(xpath = "//span[@class='inner-view-title']")
	@CacheLookup
	WebElement ConnectorNameElement;
	
	public ConnectorsPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("Connectors PageObject created");
		waitForElementVisible(PredefinedConnectorTitle,driver,"Verify PredefinedConnectorTitle is visible");
	}
	
//	public String getConnectorName() 
//	{
//		log.info("element is visible now....");
//		logExtentReport(
//				"element is visible now.... and element text is  " + ConnectorNameElement.getText());
//		return ConnectorNameElement.getText();
//	}

}
