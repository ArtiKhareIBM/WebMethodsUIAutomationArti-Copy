package com.webMethodsUI.flow.pageObjects.flowService;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class FlowServicePage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(FlowServicePage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//a[contains(text(),'FlowServices')]")
	@CacheLookup
	WebElement flowServiceTab;

	@FindBy(xpath = "//a[@title='Add FlowService']")
	@CacheLookup
	WebElement addFlowServicePlusIconElement;

	@FindBy(xpath = "//a[contains(@href,'/flow-editor') and contains(@class,'icon-plus')]")
	@CacheLookup
	WebElement addFreshFlowService_PlusIconElement;

	@FindBy(xpath = "//h1[@class='no-workflow-created']")
	@CacheLookup
	WebElement noFlowServiceElement;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu active')]//i[contains(@class,'delete-blue')]/following-sibling::*[@class='menu-title'][text()='Delete']")
	@CacheLookup
	public WebElement FlowServiceDeleteOption;

	@FindBy(xpath = "//button[text()='Delete']")
	@CacheLookup
	public WebElement deleteButton;
	
	@FindBy(xpath = "//h1[text()='Confirm Delete ?']")
	@CacheLookup
	public WebElement FlowServiceconfirmDeletePopUP;
	
//	@FindBy(xpath = "//div[@title='" + flowServiceName + "']//*[contains(text(),'Delete')]")
//	@CacheLookup
//	WebElement flowServiceDeleteButtonElement1;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement deleteFlowserviceNotificationMessageElement;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public WebElement notificationMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public FlowServicePage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("flowServiceTab Object created");
		waitForElementVisible(addFreshFlowService_PlusIconElement,driver,"Verify add flowservice plus icon is visible");
	}

//	public String getflowServiceTab() {
//		return flowServiceTab.getText();
//	}

	public FlowServiceCanvasPage clickFlowServiceName(String FlowServicename) throws Exception 
	{
		WebElement element = findElement("//span[contains(text(),'"+FlowServicename+"')]",driver);
		click(element,driver,"Clicking the Flowservices");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new FlowServiceCanvasPage(driver);
	}

	public FlowServiceCanvasPage clickOnAddFreshFlowServiceButton() throws Exception 
	{	
			click(addFreshFlowService_PlusIconElement,driver,"Click on flowservice create plus Button");
			waitForElementNotVisible(loader, driver, "wait for page load");
			return new FlowServiceCanvasPage(driver);
	}

	public FlowServiceCanvasPage clickOnAddFlowServiceButton() throws Exception {

	click(addFreshFlowService_PlusIconElement,driver,"Click on flowservice create plus Button");
		return new FlowServiceCanvasPage(driver);
	}

	public String getFlowServicesEmptyMessage() {
		log.info("Checking if flow services are empty");
		logExtentReport("Checking if flowservices are empty...");
		return noFlowServiceElement.getText();

	}

	public void deleteFlowService(String flowServiceName) throws Exception 
	{
		WebElement FlowServicesMoreMenu = findElement("//*[contains(@class,'title-flow-name')][text()='"+flowServiceName+"']/ancestor::div[@class='top-section']/following-sibling::div[@class='bottom-section']//i[contains(@class,'more-menu')]",driver);
		click(FlowServicesMoreMenu,driver,"Click FlowServices MoreMenu");
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(FlowServiceDeleteOption,driver,"Click on FlowService delete button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementVisible(FlowServiceconfirmDeletePopUP,driver,"Verify flow service delete confirm popup is visible");
		click(deleteButton,driver,"Click on delete button");
		elementContainsText(notificationMessage,"FlowService deleted successfully.",driver,"Verify FlowService deleted successfully. message is visible");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public boolean isFlowserviceDeleteMassageDisplay() {

		log.info("Verifing flow services delete massage.......... ");
		logExtentReport("Verifing flow services delete massage.......... ....");
		return deleteFlowserviceNotificationMessageElement.isDisplayed();

	}

	public FlowServiceOverViewDatepage gointoOverviewPage(String flowServiceName){
		WebElement FlowServicesEllipsisElement = driver.findElement(
		By.xpath("//div[@title='" + flowServiceName + "']/div[@class='bottom-section']/div/a"));
			FlowServicesEllipsisElement.click();
			log.info("Clicked on elemnt.." + FlowServicesEllipsisElement);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
       return new FlowServiceOverViewDatepage(driver);
	}


	public String NotificationMessage() {
		log.info("Verifying project delete success massage" + notificationMessage.getText());
		logExtentReport("Entering project Name " + notificationMessage.getText());

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(notificationMessage, ObjectReader.reader.getExplicitWait());
		return notificationMessage.getText();
	}

	public String getflowservicetittle(String flowtitile) {

		log.info("Getting the flowname name...");
		logExtentReport("Getting the flow name......");
		WebElement element = driver.findElement(
	    By.xpath("//span[contains(text(),'" + flowtitile + "')]"));
		return element.getText();

	}




}
