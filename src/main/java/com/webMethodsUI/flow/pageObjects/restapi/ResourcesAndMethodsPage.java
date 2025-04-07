package com.webMethodsUI.flow.pageObjects.restapi;

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
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ResourcesAndMethodsPage extends CommonActions{
	WebDriver driver;
	private Logger log = LogManager.getLogger(ResourcesAndMethodsPage.class);

	@FindBy(xpath = "//h1[contains(text(),'Resources and Methods')]")
	@CacheLookup
	WebElement resourcesAndmethodsTitleElement;

	@FindBy(xpath = "//input[@placeholder='Path']")
	@CacheLookup
	WebElement pathTextField;

	@FindBy(xpath = "//span[contains(text(),'HTTP Method')]")
	@CacheLookup
	WebElement httpMethodTitle;


	@FindBy(xpath = "//button[contains(text(),'Add resource')]")
	@CacheLookup
	WebElement addResourcesButtonElement;

	@FindBy(xpath = "//li[@class='Get http-list-view']//label[@class='new-checkbox-label']")
	@CacheLookup
	WebElement getMethod;

	@FindBy(xpath = "//li[@class='Post http-list-view']//label[@class='new-checkbox-label']")
	@CacheLookup
	WebElement postMethod;

	@FindBy(xpath = "//li[@class='Put http-list-view']//label[@class='new-checkbox-label']")
	@CacheLookup
	WebElement putMethod;

	@FindBy(xpath = "//li[@class='Delete http-list-view']//label[@class='new-checkbox-label']")
	@CacheLookup
	WebElement deleteMethod;

	@FindBy(xpath = "//li[@class='Patch http-list-view']//label[@class='new-checkbox-label']")
	@CacheLookup
	WebElement patchMethod;

	@FindBy(xpath = "//input[@aid='Path']")
	@CacheLookup
	WebElement pathElement;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButtonElement;

	@FindBy(xpath = "//span[contains(text(),'REST APIs')]")
	@CacheLookup
	WebElement restApiLinkElemnt;
	
	@FindBy(xpath = "//span[contains(text(),'REST APIs')]/i")
	@CacheLookup
	WebElement restApipagearrow;

	@FindBy(xpath = "//span[contains(@class,'edit-icon-pencil icons8-pencil-icon')]")
	@CacheLookup
	WebElement restapiediticon;

	@FindBy(xpath = "//div[@class='rest-api-table']/div[2]/div/div[1]/span")
	@CacheLookup
	WebElement openApiLink;
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement doneButtonElement;
	
	@FindBy(xpath = "//div[@id='json-endpoint']/div/div[1]/div[2]")
	@CacheLookup
	WebElement copyjsonEndpoint;
	
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement SuccessMessage;

        @FindBy(xpath = "//span[contains(text(),'Resources and Methods')]")
	@CacheLookup
	WebElement resourcesAndmethodsTitle;
        
        public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

    	@FindBy(xpath = "//div[@class='notification-message']")
    	@CacheLookup
    	public WebElement notificationMessage;

	public ResourcesAndMethodsPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForElementVisible(resourcesAndmethodsTitle,driver,"resourcesAndmethodsTitle text is.. " +resourcesAndmethodsTitle.getText());
	}
	
	public String getresourcesAndMethodsTitle() {
		return resourcesAndmethodsTitleElement.getText();
	}
	public void clickOnAddResourceButton() throws Exception {

		click(addResourcesButtonElement,driver,"Clicking on addResources button");
//		elementContainsText(notificationMessage,"Basic info saved successfully.",driver,"Verify Basic info saved successfully. is visible");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	
	public void enterPathValue(String pathValue) throws Exception {
		enterValue(pathElement,pathValue,driver,"Entering Path Value.. " +pathValue);
	}
	
	public HttpMethodPage clickOnHTTPMethod(String httpMethod) throws Exception {
		WebElement elemnt = findElement("//span[@class='new-checkbox-label-text'][contains(text(),'" + httpMethod + "')]",driver);

		click(elemnt,driver,"Clicking on HTTP Method.. "+httpMethod);
		return new HttpMethodPage(driver);

	}

	public void enterPath(String path) throws Exception
	{
		enterValue(pathTextField,path,driver,"Entering Path.. " +path);

	}
	public PostMethodPage clickOnCheckBox(String checkBoxName) throws Exception {
		GenericHelper genericHelper = new GenericHelper(driver);
		genericHelper.clickOnResourceCheckBox(checkBoxName);
		return new PostMethodPage(driver);
	}
	public String getResourceNameBeforeSavingResource(String resourcePathName) throws Exception 
	{

		log.info("Get the resource name  " + resourcePathName);
		logExtentReport("Get the resource name  " + resourcePathName);
		WebElement element = findElement("//a/span[contains(text(),'" + resourcePathName + "')]",driver);
		return element.getText();

	}
	public String getCreatedResourceName(String resourcePathName) throws Exception 
	{
		WebElement element =findElement
				("//span[@class='single-resources-title'][contains(text(),'" + resourcePathName + "')]",driver);
		elementContainsText(element, resourcePathName, driver, "Verify created Resource Name is present.."+resourcePathName);
		return element.getText();

	}
	public void clickOnSaveButton() throws Exception {

		click(saveButtonElement,driver,"Clicking on SaveButton ");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}


	public void clickOnResourceEditButton() throws Exception {
		WebElement element1 = findElement("//span[contains(text(),'Resources and Methods')]", driver);
		waitForElementVisible(element1,driver,"wait for page to load:");
		click(element1,driver,"clicking on Resource and method");
		click(restapiediticon,driver,"Clicking on edit button in resource page ");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement element = findElement("//a[contains(@class,'single-resource-view clearfix')]//span[1]", driver);
		waitForElementVisible(element,driver,"wait for page to load:");
		click(element,driver,"clicking on post method");
	}

	public void selectinganotherservice(String Servicename,String Servicename1) throws Exception {
		WebElement element1 = findElement("//div[contains(text(),'" + Servicename + "')]", driver);
		Actions action = new Actions(driver);
		waitForElementVisible(element1, driver, "Verify select workflow flow service drop down is visible");
		action.click(element1).click().sendKeys(Servicename1)
				.sendKeys(Keys.ENTER).build().perform();
		waitForElementNotVisible(loader, driver, "wait for page load",60);
		log.info("select the flow service from drop down....." + Servicename1);
		logExtentReport("select the flow service from drop down....." + Servicename1);
		getNavigationScreen(driver);
	}
	
	public RestApiHomePage clickOnRestApiLink() throws Exception 
	{
		click(restApiLinkElemnt,driver,"Clicking on RestAPI Link ");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new RestApiHomePage(driver);
	}
	
	public RestApiHomePage openRestApi() throws Exception 
	{
		click(openApiLink,driver,"Clicking on RestAPI Link ");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new RestApiHomePage(driver);
	}
	
	public RestApiHomePage openRestSpecificrestApi(String apiname) throws Exception 
	{
		WebElement jsonApiEndpoint =findElement("//div[@class='rest-api-table']/div[2]/div/div[1]/span[text()='"+apiname+"']",driver);
		click(jsonApiEndpoint,driver,"Clicking on RestAPI Link "+apiname);
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new RestApiHomePage(driver);
	}
	
	public RestApiHomePage copyApiIcon() throws Exception 
	{
		WebElement copyApi = findElement("//div[@id='api-endpoint']/div/div[1]/div[2]",driver);
		click(copyApi,driver,"Copying API link.");
		return new RestApiHomePage(driver);
	}
	
	
	public RestApiHomePage importApiUsingUrl() throws Exception 
	{
		click(copyjsonEndpoint,driver,"Clicking on Json public url link ");
		click(restApipagearrow,driver,"Navigate to rest API page ");
		return new RestApiHomePage(driver);
	}
	
	
	public RestApiHomePage importMultiApiUsingUrl() throws Exception 
	{
		WebElement copyjsonApiEndpoint =findElement("//div[@id='json-endpoint']/div/div[1]/div[2]",driver);
		click(copyjsonApiEndpoint,driver,"Clicking on Json public url link ");
		click(restApipagearrow,driver,"Navigate to rest API page ");
		return new RestApiHomePage(driver);
	}
	public ResourcesAndMethodsPage clickOnDoneButton() throws Exception {

		click(doneButtonElement,driver,"Clicking on done button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new ResourcesAndMethodsPage(driver);

	}
	
	public RestApiHomePage importMultiApiyamlUsingUrl() throws Exception 
	{
		WebElement copyjsonApiEndpoint =findElement("//div[@id='yaml-endpoint']/div/div[1]/div[2]",driver);
		click(copyjsonApiEndpoint,driver,"Clicking on Json public url link ");
		driver.navigate().refresh();
		//click(restApipagearrow,driver,"Navigate to rest API page ");
		return new RestApiHomePage(driver);
	}
	
	public RestApiHomePage clickEdit() throws Exception 
	{
		WebElement editButton =findElement("//div[@class='info-header']/h3/span",driver);
		click(editButton,driver,"Clicking on edit button ");
		return new RestApiHomePage(driver);
	}
	
	public RestApiHomePage drillDownApi(String ApiName) throws Exception 
	{
		WebElement ApiEleName = findElement("copyjsonEndpoint",driver);
		click(ApiEleName,driver,"Clicking on API");
		return new RestApiHomePage(driver);
	}
	public String getSuccesMessageofImportfile() throws Exception
	{
		waitForElementVisible(SuccessMessage, driver, "wait for notification message to visible");
		return SuccessMessage.getText();
	}


	public boolean checkResourceButton(){
		log.info("check Add Resources button....");
		logExtentReport("check on Add Resources button....");
		boolean verify = addResourcesButtonElement.isDisplayed();
		return verify;
	}

	public void clickOnResourcebutton() throws Exception {

		click(resourcesAndmethodsTitle, driver, "Clicking on resource and method button....");
}

	public void Copyingthepath() throws Exception{

		WebElement element = findElement("//span[@class='copyurl pad-top delite-icon dlt-icon-copy ']",driver);
		click(element, driver, "Coping the url");
	}
}
