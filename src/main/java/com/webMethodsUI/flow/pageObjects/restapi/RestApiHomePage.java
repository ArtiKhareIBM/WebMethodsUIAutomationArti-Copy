package com.webMethodsUI.flow.pageObjects.restapi;

import com.webMethodsUI.flow.helper.generic.GenericHelper;
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

public class RestApiHomePage extends CommonActions {

	WebDriver driver;
	private Logger log = LogManager.getLogger(RestApiHomePage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//h1[@class='rest-header-title']")
	@CacheLookup
	WebElement restApiHomePageTitleElement;

	@FindBy(xpath = "//button[contains(text(),'Create API')]")
	@CacheLookup
	WebElement createAPIButtonElement;

	@FindBy(xpath = "//button[contains(@class,'btn secondary-btn delete-btn-prmy btn-sm')]")
	@CacheLookup
	WebElement deleteButtonElement;

	@FindBy(xpath = "//span[contains(text(),'No APIs created yet!')]")
	@CacheLookup
	WebElement noRESTAPIElement;
	
	@FindBy(xpath = "//a[@class='active']//span[contains(text(),'APIs')]")
	@CacheLookup
	WebElement apisPageTitleElement;
	
	@FindBy(xpath = "//h1[@class='rest-header-title']")
	@CacheLookup
	WebElement restAPIpageTitleElement;
	
	@FindBy(xpath = "//span[contains(text(),'TestAPI')]")
	@CacheLookup
	WebElement clickTestApiElement;
	
	@FindBy(xpath = "//a[contains(@class,'delite-icon dlt-icon-delete icon-delete icon-mr mrm')]")
	@CacheLookup
	WebElement deleteRestApiIconElement;
	
	@FindBy(xpath = "//button[contains(@class,'btn secondary-btn delete-btn-prmy btn-sm')]")
	@CacheLookup
	WebElement deleteRestApiButtonElement;


	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement SuccessMessage;

	@FindBy(xpath = "//span[contains(text(),'Username')]")
	@CacheLookup
	WebElement BasicInfopage;

	@FindBy(xpath = "//div[text()='REST API deleted successfully.']")
	@CacheLookup
	WebElement deletemessage;

	@FindBy(xpath = "//span[text()='Convert to Defined Type']")
	@CacheLookup
	WebElement convertdefinemessag;

	@FindBy(xpath = "(//span[@class='delite-icon dlt-icon-caret-down'])[2]")
	@CacheLookup
	WebElement definedata;



	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public RestApiHomePage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		log.info("RestAPIHome Page Object created");
		logExtentReport("RestAPIHome Page Object created");

	}

	public String getRestApiTitle() {

		log.info("Getting the soap api page title..............");
		logExtentReport("Getting the soap api page title..............");
		return restApiHomePageTitleElement.getText();

	}

	public RestApiLetsGetStartedPage clickOnCreateApiButton() throws Exception 
	{
		WebElement element = findElement("//button[contains(text(),'Create API')]",driver);
		click(element, driver, "clicking on create api button...");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new RestApiLetsGetStartedPage(driver);

	}

	public void deleteRestAPI(String restApiName) throws Exception
	{
		WebElement element = findElement("//span[contains(text(),'" + restApiName+ "')]/parent::div/parent::div/div/a[@title='Delete REST API']",driver);
		click(element,driver,"Clicking on delete REST API.. " + element);
		click(deleteButtonElement,driver,"Clicking on delete REST API button.. " + element);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public void  deletecreatedrestapi(String restApiName) throws Exception
	{
		WebElement element = findElement("//span[contains(text(),'" + restApiName+ "')]/parent::div/parent::div/div/a[@title='Delete REST API']",driver);
		click(element,driver,"Clicking on delete REST API.. " + element);
		click(deleteButtonElement,driver,"Clicking on delete REST API button.. ");
		waitForElementNotVisible(loader,driver,"waiting for page load", 3000);
		//waitHelper.waitForElement(deletemessage, ObjectReader.reader.getExplicitWait());

	}

	public String getRestapiDeletemessage(String DeleteMessage) throws Exception
	{
		logExtentReport("Verify success message... ");
		WebElement element = findElement(DeleteMessage,driver);
		logExtentReport("element is visible now.... and element text is  " +element.getText());
		return element.getText();
	}


	public String isRestAPIExists() {

		log.info("Checking if rest apis exists.......");
		logExtentReport("Checking if rest apis exists.......");
		return noRESTAPIElement.getText();

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
		return createAPIButtonElement.getText();
		
	}
	
	public void clickCreateAPIbutton() {
		
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(createAPIButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("create API button is visible");
		logExtentReport("createAPIButton button is visible");
		createAPIButtonElement.click();
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
  
	
public void clickDeleteApiIcon() throws Exception {
		click(deleteRestApiIconElement, driver, "Click delete Rest API Icon");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

public void clickDeleteApiButton() throws Exception {
	click(deleteRestApiButtonElement, driver, "Click delete Rest API Button");
	waitForElementNotVisible(loader, driver, "wait for page load");
}

public CreatedAPIDetailsPage EditRestApi(String restApiName) throws Exception
{
    WebElement element = findElement("//span[contains(text(),'"+ restApiName
			+"')]/parent::div/following-sibling::div[@class='col single-rest-api-actions']/a[1]",driver);
	click(element, driver, "Clicking on created REST API.. "+restApiName);
	waitForElementNotVisible(loader, driver, "wait for page load");
    return new CreatedAPIDetailsPage(driver);
}


	public String getSuccesMessageofImportfile(){
		log.info("Getting successMessage...");
		logExtentReport("Getting successMessage...");
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
		return SuccessMessage.getText();
	}

	public void  EditBasicInfo() throws Exception
	{
		WebElement element = findElement("//span[contains(@class,'edit-pencil-icon delite-icon')]",driver);
		click(element, driver, "Clicking on created REST API.. ");
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementVisible(BasicInfopage,driver,"Verify element is visible.. "+BasicInfopage);

	}

	public void  EditBasicInfoforswagger() throws Exception
	{
		WebElement element = findElement("//span[contains(@class,'edit-pencil-icon delite-icon')]",driver);
		click(element, driver, "Clicking on created REST API.. ");
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementVisible(convertdefinemessag,driver,"Verify element is visible.. "+convertdefinemessag);

	}
	
	public void drillDownApi(String ApiName) throws Exception 
	{
		WebElement ApiEleName = findElement("//span[text()='"+ApiName+"']",driver);
		click(ApiEleName,driver,"Clicking on API");
	}

	public void importMultiApiUsingUrl(String ApiName) throws Exception 
	{
		WebElement copyjsonApiEndpoint =findElement("//span[text()=" + ApiName + "]/ancestor::div[1]/following-sibling::div[6]/a[3]",driver);
		click(copyjsonApiEndpoint,driver,"Clicking on Json public url link ");
		driver.navigate().refresh();
	}
	
	public void selectDefineType(String definetype) {

		try {

			GenericHelper genericHelper = new GenericHelper(driver);
			genericHelper.clickOnDropDown(definedata,0);
			genericHelper.selectDropDownLink(definetype);
			log.info("Clicked on convert to defined type....");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}




