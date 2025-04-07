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

public class CreatedAPIDetailsPage extends CommonActions{
	WebDriver driver;
	private Logger log = LogManager.getLogger(CreatedAPIDetailsPage.class);
	
	@FindBy(xpath = "//span[contains(text(),'API Details')]")
	@CacheLookup
	WebElement apiDetailsTitleElement;
	
	@FindBy(xpath = "//span[contains(text(),'Name')]")
	@CacheLookup
	WebElement nameTitleElement;
	
	@FindBy(xpath = "//h1[contains(text(),'Documentation')]")
	@CacheLookup
	WebElement documentationTitleElement;
	
	@FindBy(xpath = "//h3[contains(text(),'Basic Info')]")
	@CacheLookup
	WebElement basicInfoTitleElement;
	
	@FindBy(xpath = "//span[@class='edit-pencil-icon icons8-pencil-icon']")
	@CacheLookup
	WebElement editRestApiIconElement;

	@FindBy(xpath = "//span[@class='edit-pencil-icon delite-icon dlt-icon-edit ']")
	@CacheLookup
	WebElement RestApieditIconElement;
	
	@FindBy(xpath = "//span[contains(text(),'Resources and Methods')]")
	@CacheLookup
	WebElement resourcesAndMethodsButtonElement;
	
	@FindBy(xpath = "//span[contains(text(),'Consumes')]")
	@CacheLookup
	WebElement consumesLabelElement;
	
	@FindBy(xpath = "//span[contains(text(),'Produces')]")
	@CacheLookup
	WebElement producesLabelElement;
	
	@FindBy(xpath = "//span[contains(@class,'copyurl pad-top delite-icon dlt-icon-copy')]")
	@CacheLookup
	WebElement copyEndPointURLIconElement;
	
	@FindBy(xpath = "//span[@class='apiEndpoint edit-value api-endpoint-url']")
	@CacheLookup
	WebElement endPointURLElement;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement Savebutton;

	@FindBy(xpath = "//span[contains(text(),'REST APIs')]")
	@CacheLookup
	WebElement restApiLinkElemnt;

	@FindBy(xpath = "//input[@aid='Version']")
	@CacheLookup
	WebElement versionElement;

	@FindBy(xpath = "//textarea[@aid='Description']")
	@CacheLookup
	WebElement descriptionElement;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement SuccessMessage;


	@FindBy(xpath = "//span[@class='edit-value edit-word-break']")
	@CacheLookup
	WebElement VerifyApiName;


	@FindBy(xpath = "//span[contains(text(),'JSON')]/parent::div/following-sibling::div[@class='col s2 swagger-col copy-download-icons json-swagger']/span[1]")
	@CacheLookup
	WebElement SwaggerURLcopingicon;
	
	public CreatedAPIDetailsPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		log.info("CreatedAPIDetails Page Object created");
		logExtentReport("CreatedAPIDetails Page Object created");
	}
	
	public String getapiDetailsTitle() 
	{
		log.info("getting Api Details title....");
		logExtentReport("element is visible now.... and element text is  " +apiDetailsTitleElement.getText());
		return apiDetailsTitleElement.getText();
	}
	
	public String getnameTitle() throws Exception {
//		log.info("getting Api Name title....");
//		logExtentReport("element is visible now.... and element text is  " +nameTitleElement.getText());
		waitForElementVisible(nameTitleElement, driver, "wait for elemrnt visible");
		return nameTitleElement.getText();
	}
	
	public String getdocumentationTitle() throws Exception {
		log.info("getting Api Documentation Details title....");
		logExtentReport("element is visible now.... and element text is  " +documentationTitleElement.getText());
		waitForElementVisible(documentationTitleElement, driver, "wait for elemrnt visible");
		return documentationTitleElement.getText();
	}
	
	public String getbasicInfoTitle() {
		log.info("getting basic info Details title....");
		logExtentReport("element is visible now.... and element text is  " +basicInfoTitleElement.getText());
		return basicInfoTitleElement.getText();
	}
	
public void clickEditApiButton() throws Exception {
		
		click(RestApieditIconElement, driver, "Clicked on edit api button...");

	}

	public void EditApiiconclick() throws Exception 
	{

		click(editRestApiIconElement, driver, "Clicked on edit api button...");

	}



	public  AddResourcePage clickResourcesAndMethods() throws Exception
	{
		log.info("clicking on resources and methods button....");
		logExtentReport("clicking on resources and methods button.......");
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Resources and Methods");
		 return new AddResourcePage (driver);
	}

public String getEndPointUrl() throws Exception {
	 
	 click(copyEndPointURLIconElement, driver, "copying endpointUrl ...."+endPointURLElement.getText());
	
	return endPointURLElement.getText(); 
}

public void clickSaveButton() throws Exception{
	
	click(Savebutton, driver, "Clicking Save button..");

}
  public RestApiHomePage clickOnRestApiLink() throws Exception {
		click(restApiLinkElemnt, driver, "clicking in REST API link...");
		
		return new RestApiHomePage(driver);

	}

	public void enterVersion(String versionValue) {

		log.info("entering verion value ...." + versionValue);
		logExtentReport("Entering version value ...." + versionValue);
		versionElement.clear();
		versionElement.sendKeys(versionValue);
		/*
		 * WebElement element =
		 * driver.findElement(By.xpath("//li/div[contains(text(),'"+versionValue+"')]"))
		 * ; element.click();
		 */

	}

	public void enterDescription(String restApidescription) {

		log.info("entering the description........");
		logExtentReport("entering the description....");
		descriptionElement.clear();
		descriptionElement.sendKeys(restApidescription);
	}

	public String getSuccesMessage() throws Exception{
//		log.info("Getting successMessage...");
//		logExtentReport("Getting successMessage...");
		WebElement element = findElement("//div[@class='notification-message']",driver);
		waitForElementVisible(element, driver, "wait for notification message to visible");
		return SuccessMessage.getText();
	}

    public String VerifyName(){
		log.info("VerifyApiName....");
		logExtentReport("VerifyApiName....");
        return VerifyApiName.getText();
	}

	public void Copyingthepath() throws Exception{

		WebElement element = findElement("//span[@class='copyurl pad-top delite-icon dlt-icon-copy ']",driver);
		click(element, driver, "Coped the url..."+Keys.CONTROL+"v");
	}
	
	public void CopyPrivateAPIEndpoint() throws Exception
	{
		WebElement element = findElement("//div[@id='api-endpoint']//*[text()='Private URL']/ancestor::div[@class='endpoint']/div[2][contains(@class,'copyurl')]",driver);
		click(element, driver, "Coped the url..."+Keys.CONTROL+"v");
	}
	
	public void CopyInternalAPIEndpoint() throws Exception
	{
		WebElement element = findElement("//div[@id='api-endpoint']//*[text()='//div[@id='api-endpoint']//*[text()='Internal URL']/ancestor::div[@class='endpoint']/div[2][contains(@class,'copyurl')]']/ancestor::div[@class='endpoint']/div[2][contains(@class,'copyurl')]",driver);
		click(element, driver, "Coped the url..."+Keys.CONTROL+"v");
	}
	
	public void CopyPublicAPIEndpoint() throws Exception
	{
		WebElement element = findElement("//div[@id='api-endpoint']//*[text()='//div[@id='api-endpoint']//*[text()='Public URL']/ancestor::div[@class='endpoint']/div[2][contains(@class,'copyurl')]']/ancestor::div[@class='endpoint']/div[2][contains(@class,'copyurl')]",driver);
		click(element, driver, "Coped the url..."+Keys.CONTROL+"v");
	}
	

	public String getthepath(){
		log.info("Coping the url");
		logExtentReport("Coping the url");
		WebElement element = driver.findElement(By.xpath("//span[@class='swagger-download-url']"));
		return element.getText();
	}

	public AddResourcePage resourcepage() throws Exception{
		WebElement ele = findElement("//span[@class='rest-api-title'][contains(text(),'Resources and Methods')]",driver);
		click(ele, driver, "clicking on resources and methods page......");
		return new AddResourcePage(driver);
	}

	public void CopyingSwaggerURL() throws Exception{
		
		click(SwaggerURLcopingicon, driver, "Coping the Swaggerurl");
	}

}
