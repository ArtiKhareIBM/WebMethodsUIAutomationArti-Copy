package com.webMethodsUI.flow.pageObjects.SOAPConnector;

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

public class OperationList extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(OperationList.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//div[contains(text(),'Operations')]")
	@CacheLookup
	WebElement operationsElement;

	@FindBy(xpath = "//span[contains(text(),'Operation Names')]")
	@CacheLookup
	WebElement operationNameElement;

	@FindBy(xpath = "//span[contains(text(),'SOAP Connectors')]")
	@CacheLookup
	WebElement soapConnectorLinkElement;

        @FindBy(xpath = "//span[@class = 'operation-action-icons wmio-test-operation-icon disabled-click']")
	@CacheLookup
	WebElement runOperationButton;
	
	@FindBy(xpath = "//span[@class = 'dlt-icon-close close-icon']")
	@CacheLookup
	WebElement closeOperationButtonElement;
	
	@FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='container']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[3]/div[2]/div[3]/span[2]")
	@CacheLookup
	WebElement runRoleOperationButtonElement;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public OperationList(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(operationsElement, ObjectReader.reader.getExplicitWait());
		log.info(" Operation list element is visible now....");
		logExtentReport(
				" Operation list element is visible now.... and element text is  " + operationsElement.getText());

	}

	public String getOperationsElement() {
		log.info("Operations text with name " + operationsElement.getText());
		logExtentReport(" Operations  text  with name... " + operationsElement.getText());
		return operationsElement.getText();

	}

	public void clickSoapConnectorLink() throws Exception 
	{

		click(soapConnectorLinkElement, driver, "Clicking on Soap Connectors Link");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

     public boolean isRunOperationButtonVisible() {
		log.info("Run Operations text with name " + runOperationButton.getText());
		logExtentReport("Run Operations  text  with name... " + runOperationButton.getText());
		return runOperationButton.isDisplayed();
	}

	public Boolean verifyOperationName(String operationName) {
		log.info("Verifying the operation name  element is visible.... " + operationName);
		logExtentReport(" Verifying the operation name  element is visible.... " + operationName);

		WebElement element = driver.findElement(By.xpath("//span[@class='single-operation-value'][contains(text(),'" + operationName + "')]"));
		return element.isDisplayed();

	}
	
	public String  getOperationNameText() {
		log.info("Verifying the operation Name   text on Operation list page  is visible.... " );
		logExtentReport(" Verifying the operation name  text on operation list page  is visible.... " );
	return operationNameElement.getText();
	
	}
        public void clickRunSoapOperationButton() {
		log.info("Clicking on  Run Button.... ");
		logExtentReport(" Clicking on Run Operation Button ..... ");
		waitHelper.waitForElement(runRoleOperationButtonElement, ObjectReader.reader.getExplicitWait());
		runRoleOperationButtonElement.click();
	}
	
	public void clickCloseSoapConnectorOperation() {
		log.info("Clicking on  Link.... " + closeOperationButtonElement.getText());
		logExtentReport(" Clicking on Link with name ..... " + closeOperationButtonElement.getText());
		waitHelper.waitForElement(closeOperationButtonElement, ObjectReader.reader.getExplicitWait());
		closeOperationButtonElement.click();
	}
}
