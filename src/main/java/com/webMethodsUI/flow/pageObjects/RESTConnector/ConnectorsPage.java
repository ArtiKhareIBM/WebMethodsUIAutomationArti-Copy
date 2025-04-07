package com.webMethodsUI.flow.pageObjects.RESTConnector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.flatfile.FlatfileConnectorsHomePage;
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
	
	@FindBy(xpath = "//span[@class='predeifined-title']")
	@CacheLookup
	WebElement PredefinedConnectorPageTitleElement;
	
	private Logger log = LogManager.getLogger(FlatfileConnectorsHomePage.class);
	WaitHelper waitHelper;

	
	public ConnectorsPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("Connectors PageObject created");
//		waitForElementVisible(PredefinedConnectorTitle,driver,"Verify PredefinedConnectorTitle is visible");
	}
	
	public String getConnectorName()throws Exception
	{
		log.info("element is visible now....");
		logExtentReport(
				"element is visible now.... and element text is  " + ConnectorNameElement.getText());
		return ConnectorNameElement.getText();
	}
	
	public String getConnectorsTitle()throws Exception{
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +PredefinedConnectorPageTitleElement.getText());
        return PredefinedConnectorPageTitleElement.getText();
		
		
	}
	
	public void searchPredefinedconnectors(String ConnectorName)
	{
		WebElement search_connectr = driver.findElement(By.xpath("//input[@class='search-box-input']"));
		search_connectr.click();
		search_connectr.sendKeys(ConnectorName);
		
		String display_txt = driver.findElement(By.xpath("//span[@class='no-predefined-table']")).getText();
		Assert.assertEquals(display_txt, "No Account(s) found.", ConnectorName +"connector is not present" );
		log.info(ConnectorName+ "connector is not present");
	
	}
	
	
	

}
