package com.webMethodsUI.flow.pageObjects.flowService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class CustomActionConfirmationPage extends CommonActions{
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Confirm Action')]")
	@CacheLookup
	WebElement confirmActionTitleElement;
	
	@FindBy(xpath = "//*[text()='Name :']/../../div/following-sibling::div")
	@CacheLookup
	public WebElement customOperationName;
	
	@FindBy(xpath = "//*[text()='Operation :']/../../div/following-sibling::div")
	@CacheLookup
	public WebElement operationName;
	
	@FindBy(xpath = "//*[text()='Valid with Account :']/../../div/following-sibling::div")
	@CacheLookup
	public WebElement validWithAccountName;
	
	@FindBy(xpath = "//*[text()='Service :']/../../div/following-sibling::div")
	@CacheLookup
	public WebElement serviceName;
	
	@FindBy(xpath = "//*[text()='Description :']/../../div/following-sibling::div")
	@CacheLookup
	public WebElement description;
	
	@FindBy(xpath = "//button[text()='Done']")
	@CacheLookup
	public WebElement doneButton;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	
	public CustomActionConfirmationPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("add custom Operation Object created");
//		elementContainsText(confirmActionTitleElement,"Confirm Action",driver,"Verify confirmActionTitleElement is visible");
	}
	
//	
//	public FlowServiceCanvasPage clickOnDone() throws InterruptedException {
//		log.info("Clicking on Done button...");
//		logExtentReport("Clicking on Done button...");
//		GenericHelper genericHelper = new GenericHelper(driver);
//		genericHelper.clickButton("Done");
//		Thread.sleep(4000);
//		
//		return new FlowServiceCanvasPage(driver);
//		
//	}
	
	public void verifycustomOperationName(String Value) throws Exception 
	{
		elementContainsText(customOperationName,Value,driver,"Verify customOperation Name is visible... "+Value);
	}
	
	public void verifycustomOperationDescription(String Value) throws Exception 
	{
		elementContainsText(description,Value,driver,"Verify customOperation description is visible... "+Value);
	}
	
	public void verifycustomOperationAccount(String Value) throws Exception 
	{
		elementContainsText(validWithAccountName,Value,driver,"Verify customOperation account is visible... "+Value);
	}
	
	public void verifycustomOperationService(String Value) throws Exception 
	{
		elementContainsText(serviceName,Value,driver,"Verify customOperation serviceName is visible... "+Value);
	}
	
	public void verifyOperationName(String Value) throws Exception 
	{
		elementContainsText(operationName,Value,driver,"Verify operationName is visible... "+Value);
	}
	
	public void clickOnDoneButton() throws Exception 
	{
		click(doneButton,driver,"Clicking on done button ");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
}
