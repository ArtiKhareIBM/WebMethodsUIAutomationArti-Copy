package com.webMethodsUI.flow.pageObjects.flowService;

import com.webMethodsUI.flow.helper.generic.GenericHelper;
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
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddAccountPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class CustomActionAccountPage extends CommonActions{

	private WebDriver driver;
	
	@FindBy(xpath = "//h1[contains(text(),'Add Custom Action')]")
	@CacheLookup
	WebElement AddCustomActionLabelElemnt;

	@FindBy(xpath = "//span[contains(text(),'Connect to account')]")
	@CacheLookup
	WebElement connectToAccountLableElement;

	@FindBy(xpath = "//input[@value='Please select']")
	@CacheLookup
	WebElement selectConnectorDropDownElemnt;

	@FindBy(xpath = "//input[@name='Name']")
	@CacheLookup
	WebElement customOperationNameElemnt;

	@FindBy(xpath = "//textarea[@name='Description']")
	@CacheLookup
	WebElement customOoperationDescriptionElemnt;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;
	
	@FindBy(xpath = "//span[contains(text(), 'add')]")
	@CacheLookup
	WebElement addPlusIconElement;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public CustomActionAccountPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("add custom Operation Object created");
		waitForElementVisible(AddCustomActionLabelElemnt,driver,"Verify Add Custom Action label is visible");
		waitForElementVisible(connectToAccountLableElement,driver,"Verify Connect To Account Label is visible");
	}

	public void selectConnectorAccountFromList(String connectorName) 
	{
//		String connectorTxt = connectorName + "_1";
//		log.info("Selecting the connector..." + connectorTxt);
//		logExtentReport("Selecting the connector..." + connectorTxt);
//
//		log.info("Clicking in elemnt..." + selectConnectorDropDownElemnt);
//		logExtentReport("Clicking in elemnt..." + selectConnectorDropDownElemnt);
//		selectConnectorDropDownElemnt.clear();
//		
//		Actions action = new Actions(driver);
//		action.doubleClick(selectConnectorDropDownElemnt).build().perform();
//		log.info("Double clicking on drop down....");
//		
//		log.info("Clicked on elemnt...." +selectConnectorDropDownElemnt);
//		WebElement elemnt = driver.findElement(By.xpath("//input[@value='" + connectorTxt + "']"));
//		elemnt.click();
	}

	public void enterCustomOperationName(String customOperationName) throws Exception 
	{
		enterValue(customOperationNameElemnt,customOperationName,driver,"Entering custom operation name..." + customOperationName);
	}

	public void enterCustomOperationDescription(String operationDescription) throws Exception 
	{	
		enterValue(customOoperationDescriptionElemnt,operationDescription,driver,"Entering custom operationDescription..." + operationDescription);
	}
	
	public CustomActionOperationPage clickNextButton() throws Exception 
	{
		click(nextButtonElement,driver,"Click on NextButton");
		return new CustomActionOperationPage(driver);
	}
	
	
	public AddAccountPage clickOnAddAccountPlusButton() throws Exception 
	{
		click(addPlusIconElement,driver,"Clicking in Add plus button.....");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new AddAccountPage(driver);
	}
	
	public void selectAccount(String connectorName) throws Exception
	{
		String accountName = connectorName + "_1";

		WebElement element = findElement("//*[text()='Connect to "+connectorName+"']/../div/div/div/div[text()='Please Select']",driver);
		click(element,driver,"Clicking on Account selection dropdown....");
		
		WebElement element1 = driver.findElement(By.xpath("//div[contains(text(),'" + accountName + "')]"));
		click(element1,driver,"Clicking on created account...."+accountName);
	}
	
	public void selectedAccount(String connectorName) throws Exception
	{
		String accountName = connectorName + "_1";
		WebElement element = driver.findElement(By.xpath("//div[contains(@class,'single-value')][contains(text(),'"+accountName+"')]"));
		waitForElementVisible(element, driver, "Verify created account is selected in dropdown.."+accountName);
	}

}
