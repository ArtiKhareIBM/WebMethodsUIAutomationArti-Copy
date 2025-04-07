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
import com.webMethodsUI.flow.testbase.TestBase;

public class SoapApiBasicInfoPage {
	
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(SoapApiBasicInfoPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//span[@class='inner-detail-title']")
	@CacheLookup
	WebElement soapApiBasicinfoTitleElement;
	
	@FindBy(xpath = "//input[@aid='Name']")
	@CacheLookup
	WebElement nameElement;
	
	
	@FindBy(xpath = "//input[@aid='Version']")
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
	
	
	@FindBy(xpath = "//input[@aid='Select FlowService']")
	@CacheLookup
	WebElement selectFlowServiceDropDownElement;
	
	
	@FindBy(xpath = "//input[@aid='Use and style for operations']/ancestor::div[@class='material-custom-select clearfix dropdown tex-transform-i']/span")
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
	
	
	public void enterName(String soapApiName) {
		
		log.info("Entering the soap api name.........");
		logExtentReport("Entering the soap api name.........");
		nameElement.sendKeys(soapApiName);
		
	}
	
	
	public void selectVersion(String versionValue) {
		
		log.info("Clicking on version dropdown and selecting value ...." +versionValue);
		logExtentReport("Clicking on version dropdown and selecting value ...." +versionValue);
		versionDropDownElement.click();
		WebElement element = driver.findElement(By.xpath("//li/div[contains(text(),'"+versionValue+"')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		
	}
	
	public void enterDescription(String soapApidescription) {
		
		
		log.info("entering the description........");
		logExtentReport("entering the description....");
		descriptionElement.sendKeys(soapApidescription);
	}


	public void enterWSDLurl(String soapApidescription) {


		log.info("entering the WSDL url.......");
		logExtentReport("entering the WSDL url....");
		urlplaceholder.sendKeys(soapApidescription);
	}
	public void enterUserName(String soapApidescription) {


		log.info("entering the Username........");
		logExtentReport("entering the Username.....");
		Usernameplaceholder.sendKeys(soapApidescription);
	}


	public void enterPassword(String soapApidescription) {


		log.info("entering the password........");
		logExtentReport("entering the password....");
		passsWordplaceholder.sendKeys(soapApidescription);
	}
	
	
	public void selectFlowService(String flowServiceName) {
		
		log.info("selecting the flow service...." +flowServiceName);
		logExtentReport("selecting the flow service...." +flowServiceName);
		selectFlowServiceDropDownElement.click();
		WebElement element = driver.findElement(By.xpath("//li/div[contains(text(),'"+flowServiceName+"')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		
				
	}
	
	
	public void selectUseAndStyleOperations(String styleName) {
		log.info("selecting the User and style operations...........");
		logExtentReport("selecting the User and style operations...........");
		userAndStyleOperationsDropDownElement.click();
		WebElement element = driver.findElement(By.xpath("//li/div[contains(text(),'"+styleName+"')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
	}
	
	
	public SoapApiOperationsPage clickOnSaveButton() {
		
		log.info("Clicking on Save Button....");
		logExtentReport("Clicking on Save Button....");
		waitHelper.waitForElement(saveButtonElement, ObjectReader.reader.getExplicitWait());
		saveButtonElement.click();
		return new SoapApiOperationsPage(driver);
		
	}
public void clickSaveButton() {
		
		log.info("Clicking on Save Button....");
		logExtentReport("Clicking on Save Button....");
		waitHelper.waitForElement(saveButtonElement, ObjectReader.reader.getExplicitWait());
		saveButtonElement.click();
		
		
	}
	
	
	
	
	
	
	
	
}
