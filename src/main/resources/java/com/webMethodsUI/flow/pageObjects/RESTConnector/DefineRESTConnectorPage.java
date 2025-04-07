package com.webMethodsUI.flow.pageObjects.RESTConnector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class DefineRESTConnectorPage extends CommonActions{
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Define Connector')]")
	@CacheLookup
	WebElement defineConnetorPageTitle;
	
	
	@FindBy(xpath = "//input[@placeholder='Name your Connector']")
	@CacheLookup
	WebElement RESTConnnectorName;
	
	
	@FindBy(xpath = "//textarea[@placeholder='Describe your Connector']")
	@CacheLookup
	WebElement RESTConnnectorDescription;
	
	@FindBy(xpath = "//input[@placeholder='Type the Endpoint URL']")
	@CacheLookup
	WebElement  DefaultEndPointURL;
	
	
	@FindBy(xpath = "//div[text()='Select Authentication Type']")
	@CacheLookup
	WebElement  AuthenticationType;

        @FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement  saveButtonElement;
	
	@FindBy(xpath = "//a/span[contains(text(),'Connectors')]")
	@CacheLookup
	WebElement  connectorButtonElement;
	
	
	public DefineRESTConnectorPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		logExtentReport("DefineConnetor Page obejct created");
		waitForElementVisible(defineConnetorPageTitle,driver,"Verify defineConnetorPageTitle is visible");
	}
	
	public void enterRestConnectorName(String connectorName) throws Exception
	{
		enterValue(RESTConnnectorName,connectorName,driver,"Entering connector Name.. " +connectorName);
	}
	
	public void enterRestConnectorDescription(String connectorDescription) throws Exception
	{
		enterValue(RESTConnnectorDescription,connectorDescription,driver,"Entering connectorDescription.. " +connectorDescription);
	}
	
    public void clearDescription() throws Exception
    {
		clearTextBox(RESTConnnectorDescription,driver,"Clear Description InputField");
	}
	
	public void clickSaveButton() throws Exception{
		click(saveButtonElement,driver,"Click on Save Button");
	}
	
	public boolean getConnectorText() throws Exception
	{
		waitForElementVisible(connectorButtonElement,driver,"Verify ConnectorText Message is visible");
		return connectorButtonElement.isDisplayed();
	}
	
	public void enterRestConnectorEndPointURL(String connectorURL) throws Exception
	{
		enterValue(DefaultEndPointURL,connectorURL,driver,"Entering REST connector URL... " + connectorURL);
	}
	
	public void selectAuthenticationType(String linkText) throws Exception 
	{
		click(AuthenticationType,driver,"Clicking on Authentication Type drop down");
		GenericHelper genericHelper = new GenericHelper(driver);
		genericHelper.selectDropDownLink(linkText);
	}
	
	public ResourcesPage clickNextButton() throws Exception
	{
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Next");
		return new ResourcesPage(driver);
	}
	
	public String getDefineConnectorTitle() throws Exception 
	{
		waitForElementVisible(defineConnetorPageTitle,driver,"Verify defineConnetorPageTitle is visible.. "+defineConnetorPageTitle);
		return defineConnetorPageTitle.getText();
	}
    
}
