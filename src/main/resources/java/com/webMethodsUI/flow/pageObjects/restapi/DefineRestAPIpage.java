package com.webMethodsUI.flow.pageObjects.restapi;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.RESTConnector.DefineRESTConnectorPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.ResourcesPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServicePage;
import com.webMethodsUI.flow.testbase.TestBase;

public class DefineRestAPIpage {
	WebDriver driver;
	private Logger log = LogManager.getLogger(DefineRestAPIpage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//span[contains(text(),'Basic Info')]")
	@CacheLookup
	WebElement basicInfoTitleElement;
	
	@FindBy(xpath = "//input[@placeholder='Provide a suitable name for this API']")
	@CacheLookup
	WebElement restAPINameElement;
	
	@FindBy(xpath = "//input[@placeholder='Provide a version number for this API']")
	@CacheLookup
	WebElement restAPIVersionElement;
	
	@FindBy(xpath = "//textarea[contains(@placeholder,'Provide a short description for this API')]")
	@CacheLookup
	WebElement restAPIDescriptionElement;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveRestAPIElement;
	
	
	public DefineRestAPIpage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(basicInfoTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +basicInfoTitleElement.getText());

	}
	public String getbasicInfoTitle() {
		log.info("getting the Basic Info title... ");
		logExtentReport("getting the basic info title... ");
		return basicInfoTitleElement.getText();
	}
	
	public void enterRestAPIName(String APIName)
	{
		log.info("Creating REST API with name... " + APIName);
		logExtentReport("Creating REST API with name... " + APIName);
		restAPINameElement.sendKeys(APIName);
		
	} 
	public void enterRestAPIVersion(String APIVersion)
	{
		log.info("Entering REST API Version... " + APIVersion);
		logExtentReport("Entering REST API Version... " + APIVersion);
		restAPIVersionElement.sendKeys(APIVersion);
		
	}
	public void enterRestAPIDescription(String APIDescription)
	{
		log.info("Entering REST API Description... " + APIDescription);
		logExtentReport("Entering REST API Description... " + APIDescription);
		restAPIDescriptionElement.sendKeys(APIDescription);
		
	}
	public String getSaveRestAPI() {
		log.info("getting save Rest Api button... ");
		logExtentReport("getting save Rest Api button... ");
		return saveRestAPIElement.getText();
	}
	
	public FlowServicePage clickSaveButton() throws Exception
	{
		log.info("Clicking save Rest Api button... ");
	    logExtentReport("Clicking save Rest Api button... ");
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Save");
		return new FlowServicePage(driver);
	}
	
	
	

}
