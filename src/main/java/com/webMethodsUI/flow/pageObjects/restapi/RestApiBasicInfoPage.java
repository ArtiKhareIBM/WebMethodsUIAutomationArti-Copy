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
import org.testng.Assert;

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

	@FindBy(xpath = "//h1[contains(text(),'Resources and Methods')]")
	@CacheLookup
	WebElement resourcesAndmethodsTitleElement;
	
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

	public void clickOnSaveButton() throws Exception 
	{		
		click(saveButtonElement,driver,"Clicking on SaveButton ");
		waitForElementVisible(SuccessMessage,driver, "Wait for notification message to be visible");
	}

	public void getSuccesMessageofImportfile(String message) throws Exception
	{
		elementContainsText(SuccessMessage, message, driver, "Validate notification text");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public CreatedAPIDetailsPage clickOnSaveButtonForimportFile() throws Exception 
	{
		click(saveButtonElement,driver,"Clicking on SaveButton ");
		return new CreatedAPIDetailsPage(driver);
	}
	
	public String getbasicInfoTitle() 
	{

		return basicInfoTitleElement.getText();
	}

	public void getErrorMessage() throws Exception
	{

		WebElement Ele = driver.findElement(By.xpath("//div[contains(text(),'The REST API could not be created because the uploaded Swagger file or the URL provided are not valid')]"));
		waitForElementVisible(Ele,driver,"Verify error message for invalid file message is visible");
		//return Ele.getText();
		waitForElementNotVisible("//div[contains(text(),'The REST API could not be created because the uploaded Swagger file or the URL provided are not valid')]",driver,"Verify error message for invalid file message is visible");
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
		SwaggerURLfieldElement.clear();
		SwaggerURLfieldElement.clear();
		enterValue(SwaggerURLfieldElement,Keys.CONTROL+"v",driver,"Entering swaggerURL... " );
	}
	
	public void enterswaggerURLwithoutcredentials(String url) throws Exception
	{
		SwaggerURLfieldElement.clear();
		enterValue(SwaggerURLfieldElement,"https://petstore.swagger.io/v2/swagger.json",driver,"Entering swaggerURL... " );
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

	public String gettingnotificationforenteringiligalcharacter() throws Exception
	{
		WebElement element = findElement("//span[@class='error-validaion-text']",driver);
		elementContainsText(element, "Error: You have entered an invalid REST API name: Illegal character *", driver, "Verify error validation message is visible");
		return element.getText();
	}

	public String getRestapiSuccessmessage(String Restapimessage) throws Exception
	{
		logExtentReport("Verify success message... ");
		WebElement element = findElement(Restapimessage,driver);
		logExtentReport("element is visible now.... and element text is  " +element.getText());
		return element.getText();
	}
	
	public void validateNameField() throws Exception
	{
		logExtentReport("Check for different validations of Name field in New API page... ");
		WebElement element = findElement("//span[text()='Name']/ancestor::label/span[2]",driver);
		logExtentReport("element is visible now.... Name field is mandatory  " +element.getText());
		enterswaggerURL();
		boolean savebuttonStatus = saveButtonElement.isEnabled();
		Assert.assertFalse(savebuttonStatus, "Save button is disabled when name field is blank");
		enterName("dqodkooqwfkowvfowfvjeowfjowejfowefojweofowefow");
		WebElement counter = findElement("//span[@class='counter']",driver);
		logExtentReport("element is visible now.... Max Characters entered in name field  " +counter.getText());
		boolean savebuttonStatus1 = saveButtonElement.isEnabled();
		Assert.assertTrue(savebuttonStatus1, "Save button is enabled when name field is not blank");
		nameElement.clear();
	}
	
	public void validatePasswordField() throws Exception
	{
		logExtentReport("Check for different validations of Password field in New API page... ");
		enterName("APIName");
		enterswaggerURL();
		String url = SwaggerURLfieldElement.getAttribute("value");
		logExtentReport("url is "+url); 
		enteringUsername(ObjectReader.reader.getUserName());
		logExtentReport("Validate the error message on clicking save button when password field is blank");
		click(saveButtonElement,driver,"Clicking on Save Button....");
		waitForElementVisible(SuccessMessage,driver,"Wait for error message for blank password");
		logExtentReport(SuccessMessage.getText()); 
		Assert.assertEquals(SuccessMessage.getText(),
				"unable to read location `"+url+"`");
		waitForElementNotVisible("//div[@class='notification-message']", driver,"wait for notification to be invisible");
		logExtentReport("Validate the error message on clicking save button when password is incorrect");
		enteringpassword("Incorrect");
		WebElement saveButtonElement = findElement("//button[contains(text(),'Save')]",driver);
		click(saveButtonElement,driver,"Clicking on Save Button....");
		WebElement SuccessMessage = findElement("//div[@class='notification-message']",driver);
		waitForElementVisible(SuccessMessage,driver,"Wait for error message for blank password");
		logExtentReport(SuccessMessage.getText()); 
		Assert.assertEquals(SuccessMessage.getText(),"unable to read location `"+url+"`");
		waitForElementNotVisible("//div[@class='notification-message']", driver,"wait for notification to be invisible");
		WebElement name = findElement("//input[@aid='Name']",driver);
		name.clear();
		driver.navigate().refresh();
	}
	
	public void validateURLField() throws Exception
	{
		logExtentReport("Check for different validations of Swagger URL field in New API page... ");
		WebElement element = findElement("//span[text()='Swagger URL']/ancestor::label/span[2]",driver);
		logExtentReport("element is visible now.... Swagger URL field is mandatory  " +element.getText());
		enterName("APIName");
		boolean savebuttonStatus = saveButtonElement.isEnabled();
		Assert.assertFalse(savebuttonStatus, "Save button is disabled when Swagger URL field is blank");
		enterswaggerURL();
		boolean savebuttonStatus1 = saveButtonElement.isEnabled();
		Assert.assertTrue(savebuttonStatus1, "Save button is enabled when Swagger URL field is not blank");
		nameElement.clear();
		driver.navigate().refresh();
	}
	
	public void validateUsernameField() throws Exception
	{
		logExtentReport("Check for different validations of Username field in New API page... ");
		enterName("APIName");
		enterswaggerURL();
		String url = SwaggerURLfieldElement.getAttribute("value");
		logExtentReport("url is "+url); 
		logExtentReport("Validate the error message on clicking save button when username field is blank");
		enteringpassword(ObjectReader.reader.getPassword());
		click(saveButtonElement,driver,"Clicking on Save Button....");
		waitForElementVisible(SuccessMessage,driver,"Wait for error message for blank password");
		logExtentReport(SuccessMessage.getText()); 
		Assert.assertEquals(SuccessMessage.getText(),
				"unable to read location `"+url+"`");
		waitForElementNotVisible("//div[@class='notification-message']", driver,"wait for notification to be invisible");
		logExtentReport("Validate the error message on clicking save button when username is incorrect");
		enteringUsername("abcdef");
		WebElement saveButtonElement = findElement("//button[contains(text(),'Save')]",driver);
		click(saveButtonElement,driver,"Clicking on Save Button....");
		WebElement SuccessMessage = findElement("//div[@class='notification-message']",driver);
		waitForElementVisible(SuccessMessage,driver,"Wait for error message for blank password");
		logExtentReport(SuccessMessage.getText()); 
		Assert.assertEquals(SuccessMessage.getText(),"unable to read location `"+url+"`");
		waitForElementNotVisible("//div[@class='notification-message']", driver,"wait for notification to be invisible");
		WebElement name = findElement("//input[@aid='Name']",driver);
		name.clear();
		driver.navigate().refresh();
	}

	public void validateMandatoryOptionalFields() throws Exception
	{
		logExtentReport("Check for different validations of Name field in New API page... ");
		WebElement element = findElement("//span[text()='Name']/ancestor::label/span[2]",driver);
		logExtentReport("Name is visible now.... Name field is mandatory  " +element.getText());
		logExtentReport("Check for different validations of Swagger URL field in New API page... ");
		WebElement element1 = findElement("//span[text()='Swagger URL']/ancestor::label/span[2]",driver);
		logExtentReport("Swagger URL is visible now.... Swagger URL field is mandatory  " +element1.getText());
		logExtentReport("Check for different validations of Swagger URL field in New API page... ");
		WebElement element2 = findElement("//span[text()='Convert to Defined Type']/ancestor::div/span[2]",driver);
		logExtentReport("Convert to Defined Type is visible now.... Convert to Defined Type field is mandatory  " +element2.getText());
		driver.navigate().refresh();
	}
	
	public String getUrlFromUrlfield() throws Exception
	{
		String url = SwaggerURLfieldElement.getAttribute("value");
		logExtentReport("url is "+url);
		return url;
	}
	
	public void validateNotification(String message) throws Exception
	{
		WebElement SuccessMessage = findElement("//div[@class='notification-message']",driver);
		waitForElementVisible(SuccessMessage,driver,"Wait for error message for blank password");
		logExtentReport(SuccessMessage.getText());
		Assert.assertEquals(SuccessMessage.getText(),message);
		waitForElementNotVisible("//div[@class='notification-message']", driver,"wait for notification to be invisible");
		driver.navigate().refresh();
	}
}
