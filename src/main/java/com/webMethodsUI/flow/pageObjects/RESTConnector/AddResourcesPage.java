package com.webMethodsUI.flow.pageObjects.RESTConnector;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import java.util.List;

public class AddResourcesPage extends CommonActions{
	
	WebDriver driver;
	
	@FindBy(xpath = "//h1[contains(text(),'Add')]")
	@CacheLookup
	WebElement resourcePageTitle;
	
	
	@FindBy(xpath = "//input[@placeholder='Name your Resource']")
	@CacheLookup
	WebElement ResourceName;
	
	@FindBy(xpath = "//textarea[@placeholder='Describe your Connector']")
	@CacheLookup
	WebElement ResourceDescription;
	
	@FindBy(xpath = "//input[@placeholder='Type Resource Path']")
	@CacheLookup
	WebElement ResourcePath;
	
	
	public AddResourcesPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("AddResource PageObject created");
		waitForElementVisible(resourcePageTitle,driver,"Verify resourcePageTitle is present");
	}
	
	public void enterResourceName(String resourceName) throws Exception
	{
		enterValue(ResourceName,resourceName,driver,"Entering Resource Name.. " +resourceName);
	}
	
	public void enterResourceDescription(String resourceDescription) throws Exception
	{
		enterValue(ResourceDescription,resourceDescription,driver,"Entering Resource resourceDescription.. " +resourceDescription);	
	}
	
	public void enterResourcePath(String resourcePath) throws Exception
	{
		enterValue(ResourcePath,resourcePath,driver,"Entering Resource resourcePath.. " +resourcePath);	
	}
	
	
	public RequestMethodPage clickOnCheckBox(String checkBoxName) throws Exception 
	{
		WebElement element = findElement("//span[@class='new-checkbox-label-text'][contains(text(),'" + checkBoxName + "')]",driver);
		click(element,driver,"clicking on checkbox.. " + checkBoxName);
		return new RequestMethodPage(driver);
	}
	
	public String getresourcePageTitle() 
	{
		return resourcePageTitle.getText();
	}

	public void pastingResourcePath(String resourcePath) throws Exception
	{
		enterValue(ResourcePath,Keys.CONTROL+"v",driver,"Pasting REST API URL in resourcePath.. "+ Keys.CONTROL+"v");
		enterValue(ResourcePath,resourcePath,driver,"Entering  in resourcePath.. "+ resourcePath);
		String pathvalue = ResourcePath.getAttribute("value");
		String pathvalue1 = pathvalue.replace(ObjectReader.reader.getURL(),"");
		ResourcePath.click();
		ResourcePath.clear();
		ResourcePath.sendKeys(pathvalue1);
	}
	
	public void pastingNewResourcePath(String resourcePath) throws Exception
	{
//		enterValue(ResourcePath,Keys.CONTROL+"v",driver,"Pasting REST API URL in resourcePath.. "+ Keys.CONTROL+"v");
//		enterValue(ResourcePath,resourcePath,driver,"Entering  in resourcePath.. "+ resourcePath);
//		String pathvalue = ResourcePath.getAttribute("value");
//		String pathvalue1 = pathvalue.replace(ObjectReader.reader.getURL(),"");
		ResourcePath.click();
		ResourcePath.clear();
		ResourcePath.sendKeys(resourcePath);
	}


	public void EnteringResourcePath(String resourcePath) throws Exception
	{
		enterValue(ResourcePath,resourcePath,driver,"Entering resource Path.. " +resourcePath);
	}

	public RequestMethodPage clickOnResourceCheckBox(String methodName) throws Exception 
	{
		WebElement element = findElement("//span[@class='new-checkbox-label-text'][contains(text(),'" + methodName + "')]",driver);
		click(element,driver,"clicking on checkbox.. " + methodName);
		return new RequestMethodPage(driver);
	}
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
    public void clickSaveButton(int i) throws Exception
    {
		List<WebElement> array = findElements("//button[contains(text(),'Save')]",driver);
		WebElement ele = array.get(i);
		click(ele,driver,"clicking on save button.. " + ele);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}


}
