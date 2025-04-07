package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class TestOperationInputPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(AvailablePredefinedOperationPage.class);
	WaitHelper waitHelper;
	WebElement element;

	@FindBy(xpath = "//span[contains(text(),'Input')]")
	@CacheLookup
	WebElement inputElement;

	@FindBy(xpath = "//div[contains(text(),'Select Account')]")
	@CacheLookup
	WebElement selectAccountElement;

	@FindBy(xpath = "//button[contains(text(),'Run')]")
	@CacheLookup
	WebElement runButtonElement;

        @FindBy(xpath = "(//*[@class='tree-icon dlt-icon-plus'])[1]")
	@CacheLookup
	WebElement plusButtonElement;

    @FindBy(xpath = "//*[@class='array-header-icon dlt-icon-plus']")
   @CacheLookup
   WebElement plusButtonElement1;

    @FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='global-modal']/div[@id='test-operation-modal']/div[2]/section[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/span[1]/i[1]")
    @CacheLookup
    WebElement plusButtonElement2;

    @FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='global-modal']/div[@id='test-operation-modal']/div[2]/section[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/span[1]/i[1]")
    @CacheLookup
    WebElement plusButtonElement3;

    @FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='global-modal']/div[@id='test-operation-modal']/div[2]/section[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/span[1]")
    @CacheLookup
    WebElement plusButtonElement4;

    @FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='global-modal']/div[@id='test-operation-modal']/div[2]/section[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/span[1]/i[1]")
    @CacheLookup
    WebElement plusButtonElement5;



	@FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='global-modal']/div[@id='test-operation-modal']/div[2]/section[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/span[1]/input[1]")
	@CacheLookup
	WebElement inputTextElementField;

	@FindBy(xpath = "//input[contains(text(),'Zgeneracion')]")
	@CacheLookup
	WebElement TextFieldata;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
    @CacheLookup
    WebElement Cancelbutton;

	@FindBy(xpath = "//*[contains(@class,'dlt-icon-close operation-close-icon')]")
    @CacheLookup
    WebElement crossbutton;
	
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public static WebElement notificationMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";


	public TestOperationInputPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(inputElement, ObjectReader.reader.getExplicitWait());
		log.info("Test operation input page   is visible now....");
		logExtentReport(
				" Test operation input page   is visible now........ and element text is  " + inputElement.getText());

	}


	public  void selectAccount( String AccountName) throws Exception {
		waitHelper.waitForElement(selectAccountElement, ObjectReader.reader.getExplicitWait());
		selectAccountElement.click();
		log.info(" Clicking on select account ....");

		WebElement element = findElement("//div[contains(text(),'" +AccountName+ "')]",driver);

		//log.info(" Soap connector Account   is visible now....");
		//logExtentReport(
				//"  Soap connector Account   is visible now........ and element text is  " + element.getText());
		//waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		//element.click();
		click(element, driver, "selecting the account");


	}

	public void enterInputValue(String inputValue ,String inputFieldName) throws Exception {
		WebElement element = findElement("//input[@name='" +inputFieldName+ "']",driver);
		log.info("Entering the input value. on.. ...."+inputFieldName);
		logExtentReport(
				"Entering the input value. on. ..... "+inputFieldName);
		 element.click();
		 element.sendKeys(inputValue);
		 System.out.println("Clickied on enter input value checking run button");

	}
	////i[@class='tree-icon dlt-icon-plus']

	public void clickOnPlusIcon(int index) {

		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//i[@class='tree-icon dlt-icon-plus']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		log.info(" clicking on plusIcon element at index..." + index + "......" + element);
		element.click();


	}

	public boolean verifyInputField( String  inputFieldName) {
		WebElement element = driver.findElement(By.xpath("//input[@name='" +inputFieldName+ "']"));
		log.info("Verifing input fields  is display on test operation input page.. ....");
		logExtentReport(
				"Verifing input fields  is display on test operation input page.. ....");
		 return element.isDisplayed();



	}

	public  void  clickOnRunButton() throws Exception {
		
		click(runButtonElement, driver, "Clicking on run button .. .");

	}
	
	public  void  clickOnBackButton() throws Exception 
	{
		WebElement backButton = findElement("//button[text()='Back']",driver);
		click(backButton, driver, "Click on Back button .. .");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	
	public  void  clickOnCancelButton() throws Exception 
	{
		WebElement cancelButton = findElement("//button[text()='Cancel']",driver);
		click(cancelButton, driver, "Click on Cancel button .. .");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}


	public boolean VerifySuccestestoperation() throws Exception
	{
		waitForElementNotVisible(loader, driver, "wait for page load");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[@class='delite-icon dlt-icon-success']"));
		log.info("Click the Drop Down"+element);
		logExtentReport("Click the Drop Down"+element);
		return element.isDisplayed();
	}
	
	public void VerifyFailureTestoperation() throws Exception
	{
		WebElement notification = findElement("//div[@class='notification-message']",driver);
		elementContainsText(notification, "Received fatal alert: bad_certificate", driver, "Verify error notification is visible for first port");
		Assert.assertTrue(notification.isDisplayed());
		waitForElementNotVisible("//div[@class='notification-message']", driver, "Wait for notification message to be cleared", 60);
	}

       public  void  clickOnPlusButton() throws Exception {

		click(plusButtonElement, driver, "Clicking on plus button .. ..");

	}

       public  void  clickOnarrayPlusButton() throws Exception {

   		log.info("Clicking on plus button .. ..");
   		logExtentReport(
   		"Clicking on plus button .. ......  ");
   		//waitHelper.waitForElement(plusButtonElement, ObjectReader.reader.getExplicitWait());
   		//plusButtonElement.click();
   		//plusButtonElement.click();
   		//plusButtonElement.click();
   		//plusButtonElement1.click();
   		//plusButtonElement.click();
   		click(plusButtonElement, driver, "click the +button");
   		Thread.sleep(5000);
   		WebElement element = findElement("(//*[@class='tree-icon dlt-icon-plus'])[1]",driver);
   		click(element, driver, "click the +button");
   		Thread.sleep(5000);
   		WebElement element1 = findElement("(//*[@class='tree-icon dlt-icon-plus'])[1]",driver);
   		click(element1, driver, "click the +button");
   		Thread.sleep(5000);
   		click(plusButtonElement1, driver, "click the +button");
   		WebElement element2 = findElement("(//*[@class='tree-icon dlt-icon-plus'])[1]",driver);
   		click(element2, driver, "click the +button");


   	}




    public void closeoperationpage() throws Exception{
    // waitHelper.waitForElement(Cancelbutton, ObjectReader.reader.getExplicitWait());
     Cancelbutton.click();
     //log.info("close the operation test page" );
     Thread.sleep(7000);
     crossbutton.click();
     ///WebElement element = findElement("(//*[contains(@class,'icon-close')]",driver);
     //click(element, driver, "click cross icon");
     //logExtentReport("close the page" );
       }


      public  void  clickOnInputField() {

	log.info("Clicking on plus button .. ..");
	logExtentReport(
			"Clicking on plus button .. ......  ");
	inputTextElementField.click();
	inputTextElementField.sendKeys("100");

}

}
