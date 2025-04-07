package com.webMethodsUI.flow.pageObjects.RESTConnector;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ResourcesPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(AddResourcesPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//h1[contains(text(),'Resources')]")
	@CacheLookup
	WebElement resourcePageTitle;
	
	
	@FindBy(xpath = "//span[@class='single-resources-title']")
	@CacheLookup
	WebElement resourceNameElement;
	

	public ResourcesPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("Resource PageObject created");
		waitForElementVisible(resourcePageTitle,driver,"Verify resourcePageTitle is visible");
	}
	
	public String getResourceName() 
	{
		return resourceNameElement.getText();
	}
	
	public void clickAddResourceButton(String buttonText) throws Exception 
	{
		WebElement element = findElement("//button[contains(text(),'" + buttonText + "')]",driver);
		click(element,driver,"Clicking on Add Resource button");
	}
}
