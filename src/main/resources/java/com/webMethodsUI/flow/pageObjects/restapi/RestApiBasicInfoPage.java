package com.webMethodsUI.flow.pageObjects.restapi;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServicePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestApiBasicInfoPage extends CommonActions{

	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='inner-detail-title']")
	@CacheLookup
	WebElement restApiBasicinfoTitleElement;

	@FindBy(xpath = "//input[@aid='Name']")
	@CacheLookup
	WebElement nameElement;

	@FindBy(xpath = "//input[@aid='Version']")
	@CacheLookup
	WebElement versionElement;

	@FindBy(xpath = "//textarea[@aid='Description']")
	@CacheLookup
	WebElement descriptionElement;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButtonElement;
	
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


	@FindBy(xpath = "//span[contains(text(),'REST APIs')]")
	@CacheLookup
	WebElement restApiLinkElemnt;

	@FindBy(xpath = "//span[@class='error-validaion-text']")
	@CacheLookup
	WebElement ErrormsgElement;

	@FindBy(xpath = "//input[@aid='Swagger URL']")
	@CacheLookup
	WebElement SwaggerURLfieldElement;


	@FindBy(xpath = "//input[@aid='Username']")
	@CacheLookup
	WebElement Usernamefield;

	@FindBy(xpath = "//input[@aid='Password']")
	@CacheLookup
	WebElement passwordfield;


	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement SuccessMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public RestApiBasicInfoPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		logExtentReport("restApiBasicinfoTitle PageObject created");
		waitForElementVisible(restApiBasicinfoTitleElement,driver,"Verify restApiBasicinfoTitleElement is present");

	}

	public String getRestApiTitle() {

		return restApiBasicinfoTitleElement.getText();
	}

	public void enterName(String soapApiName) throws Exception {

		enterValue(nameElement,soapApiName,driver,"Entering soapApi Name.. " +soapApiName);
	}

	public void enterVersion(String versionValue) throws Exception {

		enterValue(versionElement,versionValue,driver,"Entering version Value.. " +versionValue);
	}

	public void enterDescription(String restApidescription) throws Exception 
	{		
		enterValue(descriptionElement,restApidescription,driver,"Entering description.. " +restApidescription);
	}

	/*
	 * public void selectFlowService(String flowServiceName) {
	 * 
	 * log.info("selecting the flow service...." +flowServiceName);
	 * logExtentReport("selecting the flow service...." +flowServiceName);
	 * selectFlowServiceDropDownElement.click(); WebElement element =
	 * driver.findElement(By.xpath("//li/div[contains(text(),'"+flowServiceName+
	 * "')]")); element.click();
	 * 
	 * 
	 * }
	 * 
	 * 
	 * public void selectUseAndStyleOperations(String styleName) {
	 * log.info("selecting the User and style operations...........");
	 * logExtentReport("selecting the User and style operations..........."
	 * ); userAndStyleOperationsDropDownElement.click(); WebElement element =
	 * driver.findElement(By.xpath("//li/div[contains(text(),'"+styleName+"')]"));
	 * element.click(); }
	 */

	public ResourcesAndMethodsPage clickOnSaveButton() throws Exception 
	{		
		click(saveButtonElement,driver,"Clicking on SaveButton ");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new ResourcesAndMethodsPage(driver);

	}

	public CreatedAPIDetailsPage clickOnSaveButtonForimportFile() throws Exception {
		
		click(saveButtonElement,driver,"Clicking on SaveButton ");
		return new CreatedAPIDetailsPage(driver);

	}
	
	public String getbasicInfoTitle() 
	{

		return basicInfoTitleElement.getText();
	}

	public String getErrorMessage() throws Exception
	{

		WebElement Ele = driver.findElement(By.xpath("//div[contains(text(),'The REST API could not be created because the uploaded Swagger file or the URL provided are not valid')]"));
		waitForElementVisible(Ele,driver,"Verify error message for invalid file message is visible");
		return Ele.getText();
	}
	
	public void enterRestAPIName(String APIName) throws Exception
	{
		enterValue(restAPINameElement,APIName,driver,"Creating REST API with name... " +APIName);
	} 
	
	public void enterRestAPIVersion(String APIVersion) throws Exception
	{
		enterValue(restAPIVersionElement,APIVersion,driver,"Entering REST API Version... " +APIVersion);
		
	}
	
	public void enterRestAPIDescription(String APIDescription) throws Exception
	{

		enterValue(restAPIDescriptionElement,APIDescription,driver,"Entering REST API Description... " +APIDescription);
	}
	
	public String getSaveRestAPI() 
	{
		return saveRestAPIElement.getText();
	}
	
	public FlowServicePage clickSaveButton() throws Exception
	{
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Save");
		return new FlowServicePage(driver);
	}
	
	public RestApiHomePage clickOnRestApiLink() throws Exception 
	{
		click(restApiLinkElemnt,driver,"Click restApi Link");
		return new RestApiHomePage(driver);
	}

	public String ErrorMessage() 
	{
		logExtentReport("Verify error message... ");
		return ErrormsgElement.getText();
	}

	public void enterswaggerURL() throws Exception
	{
		enterValue(SwaggerURLfieldElement,Keys.CONTROL+"v",driver,"Entering swaggerURL... " );
	}

	public void enteringurl(String SwaggerURL) throws Exception
	{
		enterValue(SwaggerURLfieldElement,SwaggerURL,driver,"Entering swaggerURL... " );
	}

	public void enteringUsername(String Username) throws Exception
	{
		enterValue(Usernamefield,Username,driver,"Entering userName... " +Username);
	}

     public void clickOnEditedRestApiSaveButton() throws Exception 
     {
		click(saveButtonElement,driver,"Clicking on Save Button....");
	 }

      public String getRestAPITitle() 
      {
		return restApiLinkElemnt.getText();
	  }

      public void enterEditedRestAPIDescription(String APIEditedDescription) throws Exception
      {
		clearAndEnterText(restAPIDescriptionElement,APIEditedDescription,driver,"Entering REST API Description... " + APIEditedDescription);	
      }

      public void enteringpassword(String Password) throws Exception
      {		
		enterValue(passwordfield,Password,driver,"Entering Password... " +Password);
      }

	public String Geturl()
	{
		String geturl = SwaggerURLfieldElement.getAttribute("value");
		return geturl;
	}

	public void SaveButton() throws Exception
	{
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Save");
	}

	public String getSuccesMessageofImportfile()
	{
		return SuccessMessage.getText();
	}

	public String gettingnotificationforenteringiligalcharacter()
	{
		WebElement element = driver.findElement(By.xpath("//span[@class='error-validaion-text']"));
		return element.getText();
	}

}
