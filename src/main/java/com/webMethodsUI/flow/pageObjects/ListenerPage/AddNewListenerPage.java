package com.webMethodsUI.flow.pageObjects.ListenerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import java.util.List;

import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class AddNewListenerPage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(AddNewListenerPage.class);
	TestBase test;

	WaitHelper waitHelper;
	
	@FindBy(xpath = "//span[@class='listener-icon']")
    @CacheLookup
    WebElement listenerPageTitle;

	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select type of listener']")
    @CacheLookup
    WebElement TypeofListenerfield;
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select version']")
    @CacheLookup
    WebElement versionfield;
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select replay option']")
    @CacheLookup
    WebElement Replayoptfield;
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Account']")
    @CacheLookup
    WebElement Accuntfield;
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Flow service name']")
    @CacheLookup
    WebElement Flowfield;

	
	@FindBy(xpath = "//span[text()='add']/ancestor::a[@class='add-icon']")
	@CacheLookup
	WebElement addIcon;
	
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select a user to run Flow service']")
    @CacheLookup
    WebElement SelectUserfield;
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select subscription']")
    @CacheLookup
    WebElement Subscriptionfield;
	
	@FindBy(xpath = "//input[@aid='Name']")
	@CacheLookup
	WebElement nameElement;
	
	@FindBy(xpath = "//input[@aid='Streaming API endpoint URL']")
	@CacheLookup
	WebElement StreamingURLElement;
	
	@FindBy(xpath = "//input[@aid='Default value']")
	@CacheLookup
	WebElement DefaultElement;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButtonElement;
	
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement DoneButtonElement;
	
	public AddNewListenerPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForElementVisible(listenerPageTitle, driver, "Wait for listener page tite is visible" );
	}

	public void selectTypeOfListener(String lisType) throws Exception {

        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickOnDropDown(TypeofListenerfield,0);
        genericHelper.selectDropDownLink(lisType);
        
        genericHelper.clickOnDropDown(versionfield,0);
        genericHelper.selectDropDownLink("Salesforce® CRM SOAP_v53");
        
}
	
	public void entername(String listenername) throws Exception 
	{
		enterValue(nameElement, listenername, driver, " Enter listener name...");

	}
	
	public void streamingEndpoint(String streamingURL) throws Exception 
	{	
		enterValue(StreamingURLElement, streamingURL, driver, "Enter streaming endpoint...");
	}
	
	public void selectAcct(String AccountName) throws Exception {

        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickOnDropDown(Accuntfield,0);
        genericHelper.selectDropDownLink(AccountName);
        
        genericHelper.clickOnDropDown(Subscriptionfield,0);
        genericHelper.selectDropDownLink("Salesforce Change Data Capture Event");
        
	}

	public void selectReplayOption(String ReplayOpt) throws Exception {

        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickOnDropDown(Replayoptfield,0);
        genericHelper.selectDropDownLink(ReplayOpt);
        
}
	
	 public void ClickingNextbutton() throws Exception{
         WebElement element = findElement("//button[contains(text(),'Next')]",driver);
         click(element, driver, "Click on Next Button");
 }
	 
	 public void enterDefaultValue(String defaultValue) throws Exception 
	 {		
			enterValue(DefaultElement, defaultValue, driver, "Enter default value...");			
	}
	 
	 public void selectFlowToInvoke(String flowName) throws Exception {

	        GenericHelper genericHelper = new GenericHelper(driver);
	        genericHelper.clickOnDropDown(Flowfield,0);
	        genericHelper.selectDropDownLink(flowName);
	}
	 
	 public void selectErrorCallBackFlowToInvoke(String flowName) throws Exception 
	 {

	        GenericHelper genericHelper = new GenericHelper(driver);
	        genericHelper.clickOnDropDown(ErrorCallbackdropdown,0);
	        genericHelper.selectDropDownLink(flowName);
	}
	 
	 public void selectUserToInvokeFlow() throws Exception 
	 {

	        GenericHelper genericHelper = new GenericHelper(driver);
	        genericHelper.clickOnDropDown(SelectUserfield,0);
	        genericHelper.selectDropDownLink(ObjectReader.reader.getUserName());
	        
	}
	 
	    @FindBy(xpath = "//div[@class='notification-message']")
	    @CacheLookup
	    WebElement notificationMessage;
	    
	    @FindBy(xpath = "//*[text()='Select ErrorCallBackFlowService name']")
	    @CacheLookup
	    WebElement ErrorCallbackLabel;
	    
	    @FindBy(xpath = "//*[text()='info']/following-sibling::span")
	    @CacheLookup
	    WebElement ErrorCallbackInfo;
	    
	    @FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select ErrorCallBackFlowService name']")
	    @CacheLookup
	    WebElement ErrorCallbackdropdown;
	    
	    public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	    
	    public String notificationMessage_1 = "//div[@class='notification-message']";
	    
	 
	 public void createErrorCallBackFlowToInvoke(String flowName) throws Exception 
	 {
		 waitForElementVisible(ErrorCallbackLabel, driver, "Verify Select ErrorCallback header is visible");
		elementContainsText(ErrorCallbackInfo, ":The Flow service that is invoked when a non recoverable error occurs.In the Summary tab,click on the name of the Flow service to access it.", driver, "Verify ErrorCallBack service info is visible");
		 waitForElementVisible(ErrorCallbackdropdown, driver, "Verify Select ErrorCallback placeholder  is visible in dropdown");
		 click(addIcon, driver, "Click on plus icon to create callback flow service");
		WebElement callbackserviceModal = findElement("//h1[text()='Create ErrorCallBackFlowservice']", driver);
	      waitForElementVisible(callbackserviceModal, driver, "Verify Create ErrorCallBackFlowservice header is visible");
	      WebElement callbackserviceNameLabel = findElement("//span[@class='required-input'][text()='*']/preceding-sibling::span[text()='ErrorCallBackFlowservice name']", driver);
	      waitForElementVisible(callbackserviceNameLabel, driver, "Verify Create callbackserviceName * Label is visible");
	 	 WebElement inputField = findElement("//input[@name='CallBackErrorFlowservice name']", driver);
	     enterValue(inputField, "CallbackFromListenerPage", driver, "Enter callback flow service name");
	 	 List<WebElement> save = findElements("//button[contains(text(),'Save')]", driver);
	     click(save.get(1), driver, "Click on save button");
	     waitForElementNotVisible(loader, driver, "wait for page load");
	     elementContainsText(notificationMessage,"ErrorCallBackService is created successfully.", driver, "Verify callback service created messageLabel is visible");
	     waitForElementNotVisible(notificationMessage_1, driver, "wait for notification to be invisible");
	     WebElement element1 = findElement("//div[text()='CallbackFromListenerPage']", driver);
	     waitForElementVisible(element1, driver, "Verify Created callback fs is selected in dropdown");
	     click(element1, driver, "Click on callback fs dropdown");
	     element1 = findElement("//div[contains(text(),'" + flowName + "')]",driver);
	     waitForElementVisible(element1, driver, "Verify Imported callback fs is listed in dropdown");
	     click(element1, driver, "select imported flow service");
	}
	 
	 public void clickOnSaveButton() throws Exception 
	 {
			click(saveButtonElement, driver, "Click on save button");
//			 waitForElementNotVisible(loader, driver, "wait for page load");
	 }
	 
	 public void validateNotificationMessage(String message) throws Exception 
	 {
		 WebElement notification = findElement("//div[@class='notification-message']", driver);
		 elementContainsText(notification,message, driver, "Verify Listener created message is visible");
	}
	 
	 public void validateSummaryPage(String flowName) throws Exception 
	 {
		 WebElement summary = findElement("//span[text()='ErrorCallBackFlowService']/../following-sibling::div/span[text()='"+flowName+"']", driver);
	      waitForElementVisible(summary, driver, "Verify CallBackErrorFlowservice link is visible in summary page");
	 }
	 
	 public void clickOnCallBackServiceLink(String flowName) throws Exception 
	 {
		 WebElement summary = findElement("//span[text()='ErrorCallBackFlowService']/../following-sibling::div/span[text()='"+flowName+"']", driver);
	      click(summary, driver, "Click on CallBackErrorFlowservice link");

	}
	 
	 public void clickOnDoneButton() throws Exception 
	 {
			click(DoneButtonElement, driver, "  Clicking on done button ...");
			waitForElementNotVisible(loader, driver, "wait for page load",45);
	  }
}
