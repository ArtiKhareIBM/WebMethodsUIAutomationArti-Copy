package com.webMethodsUI.flow.pageObjects.RESTConnector;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webMethodsUI.flow.helper.DropDown.DropDownHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ResponseBodyPage extends CommonActions{

	WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Type HTTP Codes, E.g. 200, 201 or 200-299']")
	@CacheLookup
	WebElement HTTPCode;

	@FindBy(xpath = "//input[@aid='Mandatory']")
	@CacheLookup
	WebElement isHeaderMandatory;

	@FindBy(xpath = "//span[@class='material-icons']")
	@CacheLookup
	WebElement addDocumentPlusIcon;

	@FindBy(xpath = "//input[@placeholder='Select Content Type']")
	@CacheLookup
	WebElement ContentTypeDropDown;

	@FindBy(xpath = "//*[text()='Document Type']/../div/div/div/div[text()='Select Document Type']")
	@CacheLookup
	WebElement DocumentTypeDropDown;

	@FindBy(xpath = "//span[@class='delete-icon'][@xpath='1']")
	@CacheLookup
	WebElement deleteResponseBody;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;
	
	@FindBy(xpath = "//a[contains(text(),'Add Body')]")
	@CacheLookup
	WebElement AddBodyElement;

	GenericHelper genericHelper;
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public ResponseBodyPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("ResponseBody PageObject created");
		waitForElementVisible(HTTPCode, driver, "Verify HTTPCode is visible.. "+HTTPCode);
	}
	
	public String addBodyButton() {
		return AddBodyElement.getText();
	}

	public void enterHTTPCode(String HttpCode) throws Exception {

		enterValue(HTTPCode,HttpCode,driver,"Entering HTTP Code.. " +HttpCode);

	}

	public void selectContentType(String contentType) throws Exception {

		WebElement element = findElement("//*[text()='Content Type']/../div/div/div/div[contains(@class,'singleValue')]",driver);
			GenericHelper genericHelper = new GenericHelper(driver);
			genericHelper.clickOnDropDown(element,0);
			genericHelper.selectDropDownLink("application/json");
	}

	public AddDocumentPage clickAddDocumentPlusIcon() throws Exception {

		click(addDocumentPlusIcon,driver,"Clicking on Add Document Plus icon ");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new AddDocumentPage(driver);

	}

	public void deleteResponseBody(String index) throws Exception {
		
		click(deleteResponseBody,driver,"clicking on delete response body with index..." + index);
	}

	public void clearHTTPCode() {
		HTTPCode.clear();

	}

	public void doubleClickDocumentTypeDropDown(String documentTypeName) throws Exception {
		
		click(DocumentTypeDropDown,driver,"clicking DocumentTypeDropDown");
		WebElement element = findElement("//*[(text()='"+documentTypeName+"')]",driver);
		click(element,driver,"clicking created document from dropdown.. "+element);
	}
	
	
	public void doubleClickDocumentTypeDropDown2(String documentTypeName) throws Exception {
		
		click(DocumentTypeDropDown,driver,"clicking DocumentTypeDropDown");
		WebElement element = findElement("//*[(text()='"+documentTypeName+"')]",driver);
		click(element,driver,"clicking created document from dropdown.. "+element);
	}
	
	public void ClickingErrorResponse() throws Exception {
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Error response')]"));
		click(element,driver,"clicking Error response checkbox");
    }

}
