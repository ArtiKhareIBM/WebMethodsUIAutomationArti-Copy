package com.webMethodsUI.flow.pageObjects.soapapi;

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

public class SoapApiBasicInfoPage extends CommonActions{
	
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(SoapApiBasicInfoPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//span[@class='inner-detail-title']")
	@CacheLookup
	WebElement soapApiBasicinfoTitleElement;
	
	@FindBy(xpath = "//input[@aid='Name']")
	@CacheLookup
	WebElement nameElement;
	
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Version']")
	@CacheLookup
	WebElement versionDropDownElement;

	@FindBy(xpath = "//input[@name='userName']")
	@CacheLookup
	WebElement Usernameplaceholder;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement passsWordplaceholder;

	@FindBy(xpath = "//input[@type='url']")
	@CacheLookup
	WebElement urlplaceholder;
	
        @FindBy(xpath = "//span[contains(text(),'Operations')]")
	@CacheLookup
	WebElement soapApiOperationsPageTitle;   
	
	@FindBy(xpath = "//textarea[@aid='Description']")
	@CacheLookup
	WebElement descriptionElement;
	
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Flow service']")
	@CacheLookup
	WebElement selectFlowServiceDropDownElement;
	
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Operation']")
	@CacheLookup
	WebElement userAndStyleOperationsDropDownElement;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButtonElement;

@FindBy(xpath = "//strong[contains(text(),'Documentation')]")
	@CacheLookup
	WebElement documentationTextElement;
	

	

	public SoapApiBasicInfoPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(soapApiBasicinfoTitleElement, ObjectReader.reader.getExplicitWait());
		
		log.info("element is visible now...." +soapApiBasicinfoTitleElement);
		
	}

public boolean getDocumentationText(){
		log.info("Getting DocumentationText Message...");
		logExtentReport("Getting DocumentationText Message...");
		return documentationTextElement.isDisplayed();
	}
    
	public String getOperationsText() {
		
		log.info("operations text...... .");
		logExtentReport("operations text ......");
		return soapApiOperationsPageTitle.getText();
		
	}
public void clearDescription(){
		log.info("clearing the description........");
		logExtentReport("clearing the description....");
		descriptionElement.clear();
	}
	
	
	public String getSopNewApiTitle() {
		
		return soapApiBasicinfoTitleElement.getText();
	}
	
	
	public void enterName(String soapApiName) throws Exception 
	{
	
		enterValue(nameElement, soapApiName, driver, "Entering the soap api name....."+soapApiName);

		
	}
	
	
	public void selectVersion(String versionValue) throws Exception 
	{
		click(versionDropDownElement, driver, "Clicking on version dropdown");
		WebElement element = findElement("//*[contains(text(),'"+versionValue+"')]",driver);
		click(element, driver, "selecting version value.."+versionValue);
		
		
	}
	
	public void enterDescription(String soapApidescription) throws Exception {
		
		enterValue(descriptionElement, soapApidescription, driver, "entering the description...."+soapApidescription);
		
	}


	public void enterWSDLurl(String soapApidescription) throws Exception {
		enterValue(urlplaceholder, soapApidescription, driver, "Enter URL.."+soapApidescription);
		
	}
	
	public void enterUserName(String soapApidescription) throws Exception {

		enterValue(Usernameplaceholder, soapApidescription, driver, "Enter username.."+soapApidescription);
	}


	public void enterPassword(String soapApidescription) throws Exception 
	{
		enterValue(passsWordplaceholder, soapApidescription, driver, "Enter password.."+soapApidescription);
	}
	
	
	public void selectFlowService(String flowServiceName) throws Exception {
		
		click(selectFlowServiceDropDownElement, driver, "Clicking on select flow service dropdown");
		WebElement element = findElement("//*[contains(text(),'"+flowServiceName+"')]",driver);
		click(element, driver, "Selecting flow servcie from dropdown.."+flowServiceName)	;
	}
	
	
	public void selectUseAndStyleOperations(String styleName) throws Exception {

		click(userAndStyleOperationsDropDownElement, driver, "Clicking on Use and style operations dropdown.");
		WebElement element = findElement("//*[contains(text(),'"+styleName+"')]",driver);
		click(element, driver, "selecting style name.."+styleName);
	}
	
	
	public SoapApiOperationsPage clickOnSaveButton() throws Exception 
	{
		click(saveButtonElement, driver, "Clicking on Save Button....");	
		return new SoapApiOperationsPage(driver);
		
	}
	
	public void clickSaveButton() throws Exception {
		
	click(saveButtonElement, driver, "Clicking on Save Button....");	
		
	}
	
	
	
	
	
	
	
	
}
