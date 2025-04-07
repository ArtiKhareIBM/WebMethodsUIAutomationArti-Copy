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
import com.webMethodsUI.flow.testbase.TestBase;

public class CreatedAPIDetailsPage {
	WebDriver driver;
	private Logger log = LogManager.getLogger(CreatedAPIDetailsPage.class);
	WaitHelper waitHelper;
	
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

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(apiDetailsTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +apiDetailsTitleElement.getText());

	}
	
	public String getapiDetailsTitle() {
		log.info("getting Api Details title....");
		logExtentReport("element is visible now.... and element text is  " +apiDetailsTitleElement.getText());
		return apiDetailsTitleElement.getText();
	}
	
	public String getnameTitle() {
		log.info("getting Api Name title....");
		logExtentReport("element is visible now.... and element text is  " +nameTitleElement.getText());
		return nameTitleElement.getText();
	}
	
	public String getdocumentationTitle() {
		log.info("getting Api Documentation Details title....");
		logExtentReport("element is visible now.... and element text is  " +documentationTitleElement.getText());
		return documentationTitleElement.getText();
	}
	
	public String getbasicInfoTitle() {
		log.info("getting basic info Details title....");
		logExtentReport("element is visible now.... and element text is  " +basicInfoTitleElement.getText());
		return basicInfoTitleElement.getText();
	}
	
public void clickEditApiButton() {
		
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(RestApieditIconElement, ObjectReader.reader.getExplicitWait());
		log.info("edit API button is visible");
		logExtentReport("EditAPIButton button is visible");
		waitHelper.waitForElement(RestApieditIconElement, ObjectReader.reader.getExplicitWait());
		RestApieditIconElement.click();
		log.info("Clicked on edit api button...");
		logExtentReport("EditAPIButton button is clicked");

	}

	public void EditApiiconclick() {

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(editRestApiIconElement, ObjectReader.reader.getExplicitWait());
		log.info("edit API button is visible");
		logExtentReport("EditAPIButton button is visible");
		waitHelper.waitForElement(editRestApiIconElement, ObjectReader.reader.getExplicitWait());
		editRestApiIconElement.click();
		log.info("Clicked on edit api button...");
		logExtentReport("EditAPIButton button is clicked");

	}



	public  AddResourcePage clickResourcesAndMethods() throws Exception
{
	log.info("clicking on resources and methods button....");
	logExtentReport("clicking on resources and methods button.......");
	GenericHelper genericObj = new GenericHelper(driver);
	genericObj.clickButton("Resources and Methods");
	return new AddResourcePage (driver);
}

public String getEndPointUrl() {
	 log.info("getting endpointUrl ...."+endPointURLElement.getText() );
	 logExtentReport("copying Endpoint URL");
	 copyEndPointURLIconElement.click();
	
	return endPointURLElement.getText(); 
}
public void clickSaveButton(){
	log.info("Clicking Save button" );
	logExtentReport("Clicking Save button..");
	waitHelper.waitForElement(Savebutton, ObjectReader.reader.getExplicitWait());
	Savebutton.click();

}
  public RestApiHomePage clickOnRestApiLink() {
		log.info("clicking in REST API link............");
		logExtentReport("clicking in REST API link............");
	    waitHelper.waitForElement(restApiLinkElemnt, ObjectReader.reader.getExplicitWait());
		restApiLinkElemnt.click();
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

	public String getSuccesMessage(){
		log.info("Getting successMessage...");
		logExtentReport("Getting successMessage...");
		return SuccessMessage.getText();
	}

    public String VerifyName(){
		log.info("VerifyApiName....");
		logExtentReport("VerifyApiName....");
        return VerifyApiName.getText();
	}

	public void Copyingthepath(){
		log.info("Coping the url");
		logExtentReport("Coping the url");
		WebElement element = driver.findElement(By.xpath("//span[@class='copyurl pad-top delite-icon dlt-icon-copy ']"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		log.info("Coped the url");
		logExtentReport("Coped the url..."+Keys.CONTROL+"v");
	}

	public String getthepath(){
		log.info("Coping the url");
		logExtentReport("Coping the url");
		WebElement element = driver.findElement(By.xpath("//span[@class='swagger-download-url']"));
		return element.getText();
	}

	public AddResourcePage resourcepage(){
		log.info("clicking on resources and methods page....");
		logExtentReport("clicking on resources and methods page......");
		WebElement ele = driver.findElement(By.xpath("//span[@class='rest-api-title'][contains(text(),'Resources and Methods')]"));
		waitHelper.waitForElement(ele, ObjectReader.reader.getExplicitWait());
		ele.click();
		return new AddResourcePage(driver);
	}

	public void CopyingSwaggerURL(){
		log.info("Coping the Swaggerurl");
		logExtentReport("Coping the Swaggerurl");
		waitHelper.waitForElement(SwaggerURLcopingicon, ObjectReader.reader.getExplicitWait());
		SwaggerURLcopingicon.click();
	}






}
