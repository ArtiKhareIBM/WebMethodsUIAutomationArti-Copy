package com.webMethodsUI.flow.pageObjects.restapi;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class RestApiMainPage extends CommonActions

{
	WebDriver driver;
	private Logger log = LogManager.getLogger(RestApiMainPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//a[@class='active']//span[contains(text(),'APIs')]")
	@CacheLookup
	WebElement apisPageTitleElement;
	
	@FindBy(xpath = "//h1[@class='rest-header-title']")
	@CacheLookup
	WebElement restAPIpageTitleElement;
	
	@FindBy(xpath = "//button[contains(text(),'Create API')]")
	@CacheLookup
	WebElement createApiButtonElement;
	
	@FindBy(xpath = "//span[contains(text(),'TestAPI')]")
	@CacheLookup
	WebElement clickTestApiElement;
	
	@FindBy(xpath = "//a[contains(@class,'delite-icon dlt-icon-delete icon-delete icon-mr mrm')]")
	@CacheLookup
	WebElement deleteRestApiIconElement;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-danger btn-sm delete-btn-prmy primary-btn')]")
	@CacheLookup
	WebElement deleteRestApiButtonElement;
	
	
	
	
	

	
	
	
	
	
	public RestApiMainPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(apisPageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +apisPageTitleElement.getText());

	}
	
	public String getAPIsPageTitle() {
		log.info("Getting the  api page title.........");
		logExtentReport("Getting the  api page title..............");
		return apisPageTitleElement.getText();
		}
	
	public String getRESTAPIPageTitle() {
		log.info("Getting the rest api page title..............");
		logExtentReport("Getting the rest api page title..............");
		return restAPIpageTitleElement.getText();
		
	}
	
	public String getCreateApiButton() {
		log.info("Getting the create api button..............");
		logExtentReport("Getting the create api button..............");
		return createApiButtonElement.getText();
		
	}
	
	public void clickCreateAPIbutton() {
		
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(createApiButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("create API button is visible");
		logExtentReport("createAPIButton button is visible");
		createApiButtonElement.click();
		log.info("Clicked on Add Account...");

	}
	
	public CreatedAPIDetailsPage clickCreatedAPI(String restAPIName) {
		log.info("Clicking on REST API name " + restAPIName);
		logExtentReport("Clicking on REST API name " + restAPIName);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + restAPIName + "')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		return new CreatedAPIDetailsPage(driver);
		
	}
  
	
public void clickDeleteApiIcon() {
		
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(deleteRestApiIconElement, ObjectReader.reader.getExplicitWait());
		log.info("Delete API button is visible");
		logExtentReport("deleteAPIButton button is visible");
		deleteRestApiIconElement.click();
		log.info("Clicked on delete icon...");

	}

public void clickDeleteApiButton() {
	
	waitHelper = new WaitHelper(driver);
	waitHelper.waitForElement(deleteRestApiButtonElement, ObjectReader.reader.getExplicitWait());
	log.info("Delete API button is visible");
	logExtentReport("deleteAPIButton button is visible");
	deleteRestApiButtonElement.click();
	log.info("Clicked on delete icon...");

}

	
}
	
