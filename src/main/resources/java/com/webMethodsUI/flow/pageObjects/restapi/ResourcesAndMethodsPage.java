package com.webMethodsUI.flow.pageObjects.restapi;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	WaitHelper waitHelper;

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
		log.info("ResourceAndMethods PageObject created");
		logExtentReport("ResourceAndMethods PageObject created");
		waitForElementVisible(resourcesAndmethodsTitle,driver,"Element text is.. " +resourcesAndmethodsTitle.getText());
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
	
	public RestApiHomePage clickOnRestApiLink() throws Exception {
		click(restApiLinkElemnt,driver,"Clicking on RestAPI Link ");
		return new RestApiHomePage(driver);
	}

	public String getSuccesMessageofImportfile(){
		log.info("Getting successMessage...");
		logExtentReport("Getting successMessage...");
		waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
		return SuccessMessage.getText();
	}


	public boolean checkResourceButton(){
		log.info("check Add Resources button....");
		logExtentReport("check on Add Resources button....");
		boolean verify = addResourcesButtonElement.isDisplayed();
		return verify;
	}

	public void clickOnResourcebutton() {
		log.info("Clicking on resource and method button....");
		logExtentReport("Clicking on resource and method button....");
		waitHelper.waitForElement(resourcesAndmethodsTitle, ObjectReader.reader.getExplicitWait());
		resourcesAndmethodsTitle.click();
}

	public void Copyingthepath(){
		log.info("Coping the url");
		logExtentReport("Coping the url");
		WebElement element = driver.findElement(By.xpath("//span[@class='copyurl pad-top delite-icon dlt-icon-copy ']"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		log.info("Coped the url");
		logExtentReport("Coped the url");
	}
}
