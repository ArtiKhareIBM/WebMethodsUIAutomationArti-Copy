package com.webMethodsUI.flow.pageObjects.onprem;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.common.OperationsPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class OnPremConnectorPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(OnPremConnectorPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//span[contains(text(),'On-Premises Connectors')]")
	@CacheLookup
	WebElement onPremConnetorPageTitle;
	
	@FindBy(xpath = "//span[contains(text(),'myPackage')]")
	@CacheLookup
	WebElement myPackageOnpremeTitle;
	
	@FindBy(xpath = "//span[contains(text(),'wmioonpremAPP')]")
	@CacheLookup
	WebElement wmioOnpremeTitle;


	@FindBy(xpath = "//span[@class='inner-view-title']")
	@CacheLookup
	WebElement onPremConnectorNameElement;

	@FindBy(xpath = "//button[contains(text(),'Operations')]")
	@CacheLookup
	WebElement operationButton;
	
	@FindBy(xpath = "//i[contains(@class,'icon-more-menu')]")
	@CacheLookup
	WebElement menu;
	
	@FindBy(xpath = "//li[@data-eventmap='actions-remove-button']/a")
	@CacheLookup
	WebElement remove;
	
	@FindBy(xpath = "//button[text()='Delete']")
	@CacheLookup
	WebElement delete;
	
	
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement notificationMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	public String notificationMessage_1 = "//div[@class='notification-message']";

	public OnPremConnectorPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		log.info("element is visible now....");
		logExtentReport(
				"element is visible now.... and element text is  " + onPremConnetorPageTitle.getText());

	}

	public String getOnPremConnectorPageTitle() {
		return onPremConnetorPageTitle.getText();
	}

	public OperationsPage clickOnOperation(String connectorName) throws Exception
	{

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + connectorName + "')]"));
		mousehover(element, driver, "MouseHover on connector name " +connectorName);
		click(operationButton, driver, "Click on operation button");
        return new OperationsPage(driver);
	}
 
	public void verifyConnectorIsVisible(String appname) throws Exception 
	{
		  WebElement appName = findElement("//span[contains(text(),'"+appname+"')]", driver);
		  waitForElementVisible(appName, driver, "Verify app is visible " +appname);
	}
	
	public void deleteOnpremeApp(String connectorName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + connectorName + "')]"));
		mousehover(element, driver, "MouseHover on connector name " +connectorName);
		click(menu, driver, "Click on menu icon");
		click(remove, driver, "Click on remove button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(delete, driver, "Click on delete button");
		elementContainsText(notificationMessage,"Successfully deleted the connector!",driver,"Verify Connector deleted successfully. message is visible");

	}
	
}