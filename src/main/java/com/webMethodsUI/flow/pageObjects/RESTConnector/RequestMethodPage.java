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
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class RequestMethodPage extends CommonActions{
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Request')]")
	@CacheLookup
	WebElement requestTab;
	
	@FindBy(xpath = "//h1[@class='resources-title left']")
	@CacheLookup
	WebElement RequestMethodTitleElement;
	
    @FindBy(xpath = "//li[@class='Post http-list-view']//label[@class='new-checkbox-label']")
	@CacheLookup
	WebElement postButtonElement;
	
	@FindBy(xpath = "//span[@class='material-icons']")
	@CacheLookup
	WebElement addDocumentPlusIcon;
	
	@FindBy(xpath = "//*[text()='Document Type']/../div/div/div/div[text()='No Document Type Selected']")
	@CacheLookup
	WebElement DocumentTypeDropDown;
	
    @FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;
	
	public RequestMethodPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("RequestMethod PageObjects created");
		waitForElementVisible(requestTab,driver,"Verify requestTab is visible");
	}
	
	public AddDocumentPage clickAddDocumentPlusIcon() throws Exception 
	{	
		click(addDocumentPlusIcon,driver,"Click on addDocument PlusIcon");
		return new AddDocumentPage(driver);
	}
	
	
	public String getRequestMethodTitle() throws Exception 
	{
//		elementContainsText(RequestMethodTitleElement,"Post Method",driver,"Verify Get Method title is visible");
		return RequestMethodTitleElement.getText();
	}
	
	public String getPostButton() {
		return postButtonElement.getText();
	}
	
	
	public ParametersPage clickOnAddParametersButton(String buttonName) throws Exception
	{
		WebElement element = findElement("//a[contains(text(),'" + buttonName + "')]",driver);
		click(element,driver,"Clicking on button... " + buttonName);
		return new ParametersPage(driver);
	}
	
	
	public HeadersPage clickOnAddHeadersButton(String buttonName) throws Exception
	{
		WebElement element = findElement("//a[contains(text(),'" + buttonName + "')]",driver);
		click(element,driver,"Clicking on button... " + buttonName);
		return new HeadersPage(driver);
		
	}
	
	public boolean isNextenabled() {
			return nextButtonElement.isEnabled();
		}
	
	public void doubleClickDocumentTypeDropDown(String documentTypeName) throws Exception 
	{					
		click(DocumentTypeDropDown,driver,"clicking on DocumentTypeDropDown");
		WebElement element = findElement("//*[(text()='"+documentTypeName+"')]",driver);
		click(element,driver,"clicking created document from dropdown.. "+element);

	}
}
