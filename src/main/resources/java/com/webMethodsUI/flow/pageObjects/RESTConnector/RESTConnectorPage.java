package com.webMethodsUI.flow.pageObjects.RESTConnector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class RESTConnectorPage extends CommonActions{
	
	WebDriver driver;
	WebElement element;

	@FindBy(xpath = "//span[contains(text(),'REST Connectors')]")
	@CacheLookup
	WebElement RESTConnectorPageTitle;
	
	@FindBy(xpath = "//span[contains(text(),'REST Connectors')]")
	@CacheLookup
	WebElement addConnectorButton;
	
	@FindBy(xpath = "//button[contains(text(),'New Account')]")
	@CacheLookup
	WebElement NewAccountButton;
	
	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-more-menu']")
	@CacheLookup
	WebElement deleteOrEditIconElement;
	
	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	@CacheLookup
	WebElement removeConnectorButtonElement;
	
	@FindBy(xpath = "//button[@class='btn btn-danger btn-sm delete-btn-prmy']")
	@CacheLookup
	WebElement deleteRestConnectorButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Operations')]")
	@CacheLookup
	WebElement AddoperationButton;
	
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public WebElement notificationMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public RESTConnectorPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("REST Conenctor PageObject created");
		waitForElementVisible(RESTConnectorPageTitle,driver,"Verify RESTConnectorPageTitle is visible");
	}
	
//	
//	public String getRESTConnectorPageTitle() {
//		log.info("element is visible now....");
//		logExtentReport("element is visible now.... and element text is  " +RESTConnectorPageTitle.getText());
//        return RESTConnectorPageTitle.getText();
//	}
	
	public void clickOnAddAccount(String restConnectorName) throws Exception 
	{
		WebElement element = findElement("//a[contains(text(),'"+restConnectorName+"')]/parent::div/span[2]/img",driver);
		click(element,driver,"Clicking on REST connector image " + restConnectorName);
		
		waitForElementVisible(NewAccountButton,driver,"Verify NewAccountButton is present");
		click(NewAccountButton,driver,"Clicked on NewAccount Button...");

	}

	public void clickOnEditorDeleteConnectorIcon(String restConnectorName) throws Exception 
	{
		WebElement element = findElement("//a[contains(text(),'"+restConnectorName+"')]/parent::div/span[2]/img",driver);
		click(element,driver,"Clicking on REST connector image " + restConnectorName);
		waitForElementVisible(deleteOrEditIconElement,driver,"Verify deleteOrEditIconElement is present");
		click(deleteOrEditIconElement,driver,"Clicked on edit or delete account icon...");
	}
	
	public void getRemoveButton(String Remove) throws Exception 
	{
		WebElement element = findElement("//span[contains(text(),'" + Remove + "')]",driver);
		click(element,driver,"Clicking on remove Button.." + element);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

   public void getEditButton(String Edit) throws Exception {
		WebElement element = findElement("//span[contains(text(),'" + Edit + "')]",driver);
		click(element,driver,"Clicking on edit button..." + element);
	}
	
	public void deleteConnectorButton(String delete) throws Exception {
		WebElement element = findElement("//button[@class='btn btn-secondary btn-sm']",driver);
		click(element,driver,"Clicking on delete..." + delete);
		waitForElementNotVisible(loader, driver, "wait for page load");

	}

	public void clickOnAddAccount1(String restConnectorName) throws Exception 
	{
		WebElement element = findElement("//a[contains(text(),'"+restConnectorName+"')]/parent::div/span[2]/img",driver);
		mousehover(element,driver,"mousehover on created REST connector " + restConnectorName);

		waitForElementVisible(NewAccountButton,driver,"Verify NewAccountButton is present");
		click(NewAccountButton,driver,"Clicked on NewAccount Button...");

	}

	public String VerifyempyRestappmessage() throws Exception
	{
		WebElement element = findElement("//div[@class='no-table-data']",driver);
		waitForElementVisible(element, driver, "Verify No Rest Conenctor created message is visible");
		return element.getText();
	}

	public operationlistpage clickOnAddoperation(String restConnectorName) throws Exception 
	{
		WebElement element = findElement("//a[contains(text(),'"+restConnectorName+"')]/parent::div/span[2]/img",driver);
		mousehover(element,driver,"mousehover on REST connector Image.. " + restConnectorName);
		click(AddoperationButton,driver,"Clicking on Addoperation Button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new operationlistpage(driver);
	}

//	public String getProjectDeleteMessage() 
//	{
//		log.info("Verifying project delete success massage" + notificationMessage.getText());
//		logExtentReport("Entering project Name " + notificationMessage.getText());
//
//		waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElement(notificationMessage, ObjectReader.reader.getExplicitWait());
//		return notificationMessage.getText();
//	}

//	public void waittillitappears() {
//		WebDriverWait wait = new WebDriverWait(driver, ObjectReader.reader.getExplicitWait());
//		wait.until(ExpectedConditions.not(
//				ExpectedConditions.textToBePresentInElement(notificationMessage, notificationMessage.getText())));
//	}


	public boolean EnsureAccountCreated(String CreatedAccountNo) throws Exception
	{
		WebElement element = findElement("//div[contains(text(),'"+CreatedAccountNo+" Accounts configured')]",driver);
		waitForElementVisible(element,driver,"Verify CreatedAccount is visible");
		return element.isDisplayed();
	}


    public void ClickRestapp(String RestApp) throws Exception
    {
		WebElement element = findElement("//a[contains(text(),'"+RestApp+"')]",driver);
		click(element,driver,"Clicking on Created REST connector name " + RestApp);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	
}
