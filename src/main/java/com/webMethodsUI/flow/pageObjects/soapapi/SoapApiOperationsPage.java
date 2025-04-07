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

public class SoapApiOperationsPage extends CommonActions{
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(SoapApiOperationsPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//h1[contains(text(),'Operations')]")
	@CacheLookup
	WebElement soapApiOperationsPageTitleElement;
	
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(xpath = "//span[@class='inner-detail-value']/a")
	@CacheLookup
	WebElement flowServiceNameElement;

        @FindBy(xpath = "//span[contains(text(),'Operations')]")
	@CacheLookup
	WebElement soapApiOperationsPageTitle;
	
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Add Operation')]")
	@CacheLookup
	WebElement addOperationButton;
	
	
	
	@FindBy(xpath = "//input[@placeholder='Operation Name']")
	@CacheLookup
	WebElement  addOperationName;
	
	
	@FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Flow service']")
	@CacheLookup
	WebElement  selectDropDown;
	
	

	public SoapApiOperationsPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(soapApiOperationsPageTitleElement, ObjectReader.reader.getExplicitWait());
		
		log.info("element is visible now...." +soapApiOperationsPageTitleElement);
		
	}
	
	public void clickOnOperationName(String operationName) {
		log.info("clicking on Operations name...." +operationName);
		logExtentReport("clicking on Operations name...." +operationName);
		
		WebElement element = driver.findElement(By.xpath("//span[@class='single-resources-title'][contains(text(),'"+operationName+"')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		
	}
	
	
	public String getFlowServiceName() {
		
		log.info("Getting the flowServiceName..........");
		logExtentReport("Getting the flow service........");
		return flowServiceNameElement.getText();
		
	}
	
       public void clickOnAddOperationButton() {
		
		log.info("adding operation on operation page...... .");
		logExtentReport("adding operation ......");
		   waitHelper.waitForElement(addOperationButton, ObjectReader.reader.getExplicitWait());
		 addOperationButton.click();
		
	}

       public void operationsText() {
        log.info("operations text...... .");
        logExtentReport("operations text ......");
        soapApiOperationsPageTitle.getText();	
}
	
   public String  enterOperationName(String operationName) {
	
	log.info("entering  operation name  on operation page...... .");
	logExtentReport("entering  operation name  on operation page...... ..");
	addOperationName.sendKeys(operationName);
	return operationName;
}
   

public void selectFlowservice(String flowserviceName) throws Exception 
{
	click(selectDropDown, driver, "Clicking on select flow service dropdown");
	WebElement element = findElement("//div[contains(text(),'"+flowserviceName+"')]",driver);
	click(element, driver, "selecting the flowservice ..... .");
}


public void clickOnSaveButton() throws Exception {

	click(saveButton, driver, "clicking on save button...... ..");
}


public String  getSoapOperationName(String soapOperationName) throws Exception 
{
	
	WebElement element = findElement("//span[contains(text(),'"+soapOperationName+"')]",driver);
	waitForElementVisible(element, driver, "verifing soap operation name  ..... . ..");
	return element.getText();

}


}
