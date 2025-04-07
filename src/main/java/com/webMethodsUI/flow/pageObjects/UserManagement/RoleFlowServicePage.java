package com.webMethodsUI.flow.pageObjects.UserManagement;

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

public class RoleFlowServicePage extends CommonActions {
	private WebDriver driver;
	private Logger log = LogManager.getLogger(RoleFlowServicePage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//span[contains(text(),'FlowServices')]")
	@CacheLookup
	WebElement flowServiceTab;

	@FindBy(xpath = "//a[@title = 'Add FlowService']")
	@CacheLookup
	WebElement addFlowServicePlusIconElement;

	@FindBy(xpath = "//a[@title = 'Add FlowService']")   
	@CacheLookup
	WebElement addFreshFlowService_PlusIconElement;

	@FindBy(xpath = "//h1[contains(text(),'No FlowServices created yet!')]")
	@CacheLookup
	WebElement noFlowServiceElement;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	WebElement flowServiceDeleteButtonElement;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement deleteFlowserviceNotificationMessageElement;

	
	
	public RoleFlowServicePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(addFreshFlowService_PlusIconElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + addFreshFlowService_PlusIconElement);
		logExtentReport("flowServiceTab Object created");
	}
	
	public String getflowServiceTab() {
		return flowServiceTab.getText();
	}
	
	public RoleFlowserviceCanvasPage clickFlowServiceName() {
		log.info("Clicking the Flowservices");
		logExtentReport("Clicking the Flowservices");
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'RestApplicationFlow')]"));
		element.click();
		log.info("Clicking the Flowservices");
		logExtentReport("Clicking the Flowservices");
		return new RoleFlowserviceCanvasPage(driver);
	}
	
	

	public RoleFlowserviceCanvasPage clickOnAddFreshFlowServiceButton() {
		try {
			log.info("Clicking on Flow service button:(when no flow service exists)  " + addFlowServicePlusIconElement);
			logExtentReport("Clicking on Flow service button:(when no flow service exists)  "
					+ addFreshFlowService_PlusIconElement);
			addFreshFlowService_PlusIconElement.click();
			return new RoleFlowserviceCanvasPage(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new RoleFlowserviceCanvasPage(driver);
		}

	}

	public RoleFlowserviceCanvasPage clickOnAddFlowServiceButton() {
		try {
			log.info("Clicking on Flow service button:(when already few flow service exists)  "
					+ addFlowServicePlusIconElement);
			logExtentReport("Clicking on Flow service button: (when already few flow service exists) "
					+ addFlowServicePlusIconElement);
			addFlowServicePlusIconElement.click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RoleFlowserviceCanvasPage(driver);

	}

	public String getFlowServicesEmptyMessage() {
		log.info("Checking if flow services are empty");
		logExtentReport("Checking if flowservices are empty...");
		return noFlowServiceElement.getText();

	}

	public void deleteFlowService(String flowServiceName) {
		try {

			WebElement FlowServicesEllipsisElement = driver.findElement(
					By.xpath("//div[@title='" + flowServiceName + "']/div[@class='bottom-section']/div/a"));
			FlowServicesEllipsisElement.click();
			log.info("Clicked on elemnt.." + FlowServicesEllipsisElement);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			//action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
			waitHelper = new WaitHelper(driver);
			waitHelper.waitForElement(flowServiceDeleteButtonElement, ObjectReader.reader.getExplicitWait());
			flowServiceDeleteButtonElement.click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isFlowserviceDeleteMassageDisplay() {

		log.info("Verifing flow services delete massage.......... ");
		logExtentReport("Verifing flow services delete massage.......... ....");
		return deleteFlowserviceNotificationMessageElement.isDisplayed();

	}
	

}
