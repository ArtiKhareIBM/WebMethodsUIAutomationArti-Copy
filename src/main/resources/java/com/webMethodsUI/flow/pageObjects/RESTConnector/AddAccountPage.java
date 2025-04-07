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
import com.webMethodsUI.flow.helper.window.WindowHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class AddAccountPage extends CommonActions{

	WebDriver driver;

	@FindBy(xpath = "//h1[@class='modal-title']")
	@CacheLookup
	WebElement AddAccountModelTitle;

	@FindBy(xpath = "//button[contains(text(),'New Account')]")
	@CacheLookup
	WebElement NewAccountButton;

	@FindBy(xpath = "//input[@name='Response Timeout']")
	@CacheLookup
	WebElement responseTimeout;

        @FindBy(xpath = "//div[@class='cloud-label-content']//div[1]//div[1]//div[1]//div[1]//span[1]//input[1]")
	@CacheLookup
	WebElement portFieldElement;

	@FindBy(xpath = "//*[text()='Authorization Type']/../div/div/div/div[contains(@class,'singleValue')]")
	@CacheLookup
	WebElement authorizationType;

	@FindBy(xpath = "//input[@name='Username']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@name='Password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	@CacheLookup
	WebElement addButton;

	@FindBy(xpath = "//input[@name='SNI Server Name']")
	@CacheLookup
	WebElement SNIServerNameElement;

	@FindBy(xpath = "//div[11]//div[1]//div[1]//div[1]//span[1]//input[1]")
	@CacheLookup
	WebElement enableSNIDropDownElement;
	
	@FindBy(xpath = "//a[contains(text(),'Projects')]")
	@CacheLookup
	WebElement ProjectsMenu;

    @FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='authConnectionAddNew']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/span[1]/input[1]")
	@CacheLookup  
	WebElement roleuserName;
	
	@FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='authConnectionAddNew']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/span[1]/input[1]")
	@CacheLookup
	WebElement rolepassword;
	
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public static WebElement notificationMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";


	public AddAccountPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("AddAccount Page  Object created");
		waitForElementVisible(AddAccountModelTitle,driver,"Verify AddAccountModelTitle is visible");
	}

	public void clickOnAddAccount(String restConnectorName, String accountName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + restConnectorName + "')]"));	
		click(element,driver,"Clicking on REST connector name " + restConnectorName);
		
		waitForElementVisible(NewAccountButton,driver,"Verify NewAccountButton is visible");
		click(NewAccountButton,driver,"Clicking on REST connector name " + restConnectorName);
	}

	public void enterResponseTimeout(String timeout) throws Exception 
	{
		enterValue(responseTimeout,timeout,driver,"Entering response timeout " +timeout);
	}

	public void selectAuthrizationType(String authType) throws Exception 
	{
		click(authorizationType,driver,"Clicking on authorization Drop Down...." + authorizationType);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + authType + "')]"));
		click(element,driver,"Selecting Auth type...." +authType);
	}

	public void enterUserName(String userNametxt) throws Exception 
	{
		enterValue(userName,userNametxt,driver,"Entering user Name: " +userNametxt);	
	}
	
	public void enterPassword(String passwordValue) throws Exception
	{
		enterValue(password,passwordValue,driver,"Entering Password: " +password);
	}

	public void enterSNIServerName(String SNIserverName) throws Exception 
	{
		enterValue(SNIServerNameElement,SNIserverName,driver,"Entering SNIserverName... " +SNIserverName);
	}

	public void selectEnableSNI(String isSNIEnabled) throws Exception 
	{
		WebElement element = driver.findElement(
				By.xpath("//span[contains(text(),'Enable SNI')]/following-sibling::div/ul/li/ul/li/div[@title='"
						+ isSNIEnabled + "']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(enableSNIDropDownElement).perform();
		actions.moveToElement(enableSNIDropDownElement).click().perform();
		click(element,driver,"Clicking in IS SNI Enabled to ..." + isSNIEnabled);
	}

	public void clickOnAddButton() throws Exception 
	{	
		click(addButton,driver,"clicked on add button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		elementContainsText(notificationMessage,"Account saved successfully.",driver,"Verify Account saved successfully message is visible");
//		waitForElementVisible(ProjectsMenu,driver,"Verify ProjectMenu is visible");
	}

	public String getModelTitle() 
	{
		return AddAccountModelTitle.getText();
	}
	
    public void enterRoleUserName(String userNametxt) throws Exception 
    {	
		enterValue(roleuserName,userNametxt,driver,"Entering user Name: " + userNametxt);
    }
	
	public void enterRolePassword(String password) throws Exception 
	{	
		enterValue(rolepassword,password,driver,"Entering Password: " + password);
	}

     public void selectPortType(String portType) throws Exception 
     {
			portFieldElement.click();
			WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + portType + "')]"));
			click(element,driver,"clicke on portFieldElement button");
	}
     
     public void accountCreatedMessage() throws Exception
     {
    	elementContainsText(notificationMessage,"Account saved successfully.",driver,"Verify Account saved successfully message is visible");

     }

}
