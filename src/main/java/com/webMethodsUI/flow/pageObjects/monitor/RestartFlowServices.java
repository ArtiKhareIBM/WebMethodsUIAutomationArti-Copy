package com.webMethodsUI.flow.pageObjects.monitor;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestartFlowServices extends CommonActions {
    WebDriver driver;

    
    @FindBy(xpath = "//button[text()='Restart']")
	@CacheLookup
	WebElement restartButton;
    
    @FindBy(xpath = "//button[text()='//button[text()='Close']']")
	@CacheLookup
	WebElement closeButton;
    
    @FindBy(xpath = "//button[text()='OK']")
  	@CacheLookup
  	WebElement okButton;
    
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	@FindBy(xpath = "//div[@class='notification-message'][contains(text(),'Your request is submitted.')]")
	@CacheLookup
	WebElement notificationMessage1;
	
	@FindBy(xpath = "//div[@class='notification-message'][contains(text(),'Your request to resubmit bulk executions has been processed successfully. Kindly refresh to get the latest executions summary.')]")
	@CacheLookup
	WebElement notificationMessage2;
	
	public String notificationMessage_1 = "//div[@class='notification-message']";


    public RestartFlowServices(WebDriver driver) 
    {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logExtentReport("Dashboard PageObjectCreated");
    }
    
	public void verifyCheckBoxIsVisibleToRestart(String flowName) throws Exception 
	{
		WebElement element = findElement("//a[text()='"+flowName+"']/preceding-sibling::div/label",driver);
		waitForElementVisible(element,driver,"Verify check box is visible for flow service  "+flowName);
	}
	
	public void SelectBatchFlowServices(String flowName,int count,String name) throws Exception
    {
		WebElement element = findElement("//a[text()='"+flowName+"']/preceding-sibling::div/label",driver);
		click(element,driver,"Select checkbox for  "+flowName);
		element = findElement("//div[@class='resubmitcount'][text()='"+count+"'][text()=' "+name+"'][text()=' selected']",driver);
		waitForElementVisible(element,driver,"Verify resubmit count "+count+" "+name+" selected is visible");
    }
	
	public void submitBulkFlowservicesToRestart() throws Exception
    {
		click(restartButton,driver,"Click on restart button");
		
    }
	
	public void clickOK() throws Exception
    {
		click(okButton,driver,"Click on OK button");
		
    }
	
	public void verifyRestartSubmittedMessage(String message) throws Exception
    {
		elementContainsText(notificationMessage1,message,driver,"Verify "+message+" message is visible");		
		waitForElementNotVisible(loader, driver, "wait for page load");
//		waitForElementNotVisible(notificationMessage_1, driver, "wait for message to invisible");
    }
    
	public void verifyRestartProccessedMessage(String message) throws Exception
    {
		elementContainsText(notificationMessage2,message,driver,"Verify "+message+" message is visible");		
		waitForElementNotVisible(loader, driver, "wait for page load");
//		waitForElementNotVisible(notificationMessage_1, driver, "wait for message to invisible");
    }
    
}
