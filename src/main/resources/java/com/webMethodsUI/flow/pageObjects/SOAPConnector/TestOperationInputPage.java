package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import java.util.List;

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

public class TestOperationInputPage {

	WebDriver driver;
	private Logger log = LogManager.getLogger(AvailablePredefinedOperationPage.class);
	WaitHelper waitHelper;
	WebElement element;

	@FindBy(xpath = "//span[contains(text(),'Input')]")
	@CacheLookup
	WebElement inputElement;


	@FindBy(xpath = "//input[@value='Select Account']")
	@CacheLookup
	WebElement selectAccountElement;

	@FindBy(xpath = "//button[contains(text(),'Run')]")
	@CacheLookup
	WebElement runButtonElement;

        @FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='global-modal']/div[@id='test-operation-modal']/div[2]/section[1]/div[3]/div[1]/div[1]/div[1]/span[1]/i[1]")
	@CacheLookup
	WebElement plusButtonElement;

    @FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='global-modal']/div[@id='test-operation-modal']/div[2]/section[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]/i[1]")
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


	public  void selectAccount( String AccountName) {
		waitHelper.waitForElement(selectAccountElement, ObjectReader.reader.getExplicitWait());
		selectAccountElement.click();
		log.info(" Clicking on select account ....");

		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" +AccountName+ "')]"));

		log.info(" Soap connector Account   is visible now....");
		logExtentReport(
				"  Soap connector Account   is visible now........ and element text is  " + element.getText());
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();


	}

	public void enterInputValue(String inputValue ,String inputFieldName) {
		WebElement element = driver.findElement(By.xpath("//input[@name='" +inputFieldName+ "']"));
		log.info("Entering the input value. on.. ...."+inputFieldName);
		logExtentReport(
				"Entering the input value. on. ..... "+inputFieldName);
		//element.click();
		 element.sendKeys(inputValue);
		 System.out.println("Clickied on enter input valaye checking run button");

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

	public  void  clickOnRunButton() {

		log.info("Clicking on run button .. ..");
		logExtentReport(
				"Clicking on run button .. ......  "+runButtonElement.getText());
		waitHelper.waitForElement(runButtonElement, ObjectReader.reader.getExplicitWait());
		runButtonElement.click();

	}


	public boolean VerifySuccestestoperation(){
		WebElement element = driver.findElement(By.xpath("//span[@class='delite-icon dlt-icon-success']"));
		log.info("Click the Drop Down"+element);
		logExtentReport("Click the Drop Down"+element);
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		return element.isDisplayed();
	}

       public  void  clickOnPlusButton() {

		log.info("Clicking on plus button .. ..");
		logExtentReport(
				"Clicking on plus button .. ......  ");
		   waitHelper.waitForElement(plusButtonElement, ObjectReader.reader.getExplicitWait());
		plusButtonElement.click();

	}

       public  void  clickOnarrayPlusButton() {

   		log.info("Clicking on plus button .. ..");
   		logExtentReport(
   		"Clicking on plus button .. ......  ");
   		waitHelper.waitForElement(plusButtonElement, ObjectReader.reader.getExplicitWait());
   		plusButtonElement.click();
   		plusButtonElement1.click();
   		plusButtonElement2.click();
   		plusButtonElement3.click();
   		plusButtonElement4.click();
   		plusButtonElement5.click();

   	}

    public void closeoperationpage(){
     waitHelper.waitForElement(Cancelbutton, ObjectReader.reader.getExplicitWait());
     Cancelbutton.click();
     log.info("close the operation test page" );
      logExtentReport("close the page" );
       }


      public  void  clickOnInputField() {

	log.info("Clicking on plus button .. ..");
	logExtentReport(
			"Clicking on plus button .. ......  ");
	inputTextElementField.click();
	inputTextElementField.sendKeys("100");

}

}
