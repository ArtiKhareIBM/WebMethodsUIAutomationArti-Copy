package com.webMethodsUI.flow.pageObjects.RESTConnector;

import java.util.List;

import com.webMethodsUI.flow.helper.DropDown.DropDownHelper;
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

public class AddDocumentPage extends CommonActions{
	
	WebDriver driver;

	@FindBy(xpath = "//h4[contains(text(),'Add new Document type')]")
	@CacheLookup
	WebElement AddNewDocumentTitle;

	@FindBy(xpath = "//input[@id='ut-doc-type-name']")
	@CacheLookup
	WebElement DocumentTypeName;
	
	@FindBy(xpath = "//textarea[@id='ut-doc-type-desc']")
	@CacheLookup
	WebElement DocumentTypeDescription;
	
	@FindBy(xpath = "//a[@class='io-tree-action-icon io-add-icon dlt-icon-plus ng-star-inserted']")
	@CacheLookup
	WebElement addNewFieldIcon;
	
	@FindBy(xpath = "//div[@class=\"dlt-form-group\"]/input[@name=\"fieldName\"]")
	@CacheLookup
	WebElement docNameElement1;
	
	@FindBy(xpath = "//div[@class=\"dlt-form-group\"]/input[@ng-reflect-name=\"fieldName\"]")
	@CacheLookup
	WebElement docNameElement2;

	@FindBy(xpath = "//label[contains(text(),'Content Type')]/parent::div/div[1]/select")
	@CacheLookup
	WebElement SelectConstraintElement;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public AddDocumentPage(WebDriver driver) throws Exception
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("AddNewDocument PageObject created");
		waitForElementVisible(AddNewDocumentTitle,driver,"Verify AddNewDocumentTitle is visible");
	}
	
	public void enterDocumentTypeName(String documentTypeName) throws Exception
	{	
		enterValue(this.DocumentTypeName,documentTypeName,driver,"Entering documentTypeName... " + documentTypeName);
	}
	
	public void enterDocumentTypeDescription(String documentDescription) throws Exception
	{
		enterValue(this.DocumentTypeDescription,documentDescription,driver,"Entering documentTypeName... " + documentDescription);
	}
	
	public void clickAddNewField() throws Exception 
	{	
		click(addNewFieldIcon,driver,"Clicking on Add New Field Plus icon ");
	}
	
	public void enterDocumentSubNames(String documentSubName) throws Exception
	{
		enterValue(this.docNameElement1,documentSubName,driver,"Entering documentSubName... " + documentSubName);
	}
	
	public void enterDocumentSubNames2(String documentSubName2) throws Exception
	{
		enterValue(this.docNameElement2,documentSubName2,driver,"Entering documentSubName2... " + documentSubName2);
	}

	public ResponseBodyPage clickOnSaveButton(String document) throws Exception 
	{
		WebElement element = findElement("//input[@type='submit'][@value='Save']",driver);
		click(element,driver,"Clicking on Save button");
		WebElement newElement = findElement("//div[@class='notification-message']", driver);
		elementContainsText(newElement,document+" created successfully.", driver, "wait for page load");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new ResponseBodyPage(driver);
	}
	
	public RequestMethodPage clickOnSaveButton2(String document) throws Exception 
	{
		WebElement element = findElement("//input[@type='submit'][@value='Save']",driver);
		click(element,driver,"Clicking on Save button");
		WebElement newElement = findElement("//div[contains(@class,'alert success')]//div[@class='notification-message']", driver);
		elementContainsText(newElement,document+" created successfully.", driver, "wait for page load");
		waitForElementNotVisible(loader, driver, "wait for page load");

		return new RequestMethodPage(driver);
	}
	
	public void createInputDataField(int index,String dataFieldName) throws Exception 
	{
		List<WebElement> elemntArray = driver.findElements(By.xpath("//input[@placeholder='Field name']"));
		WebElement element = elemntArray.get(index);
		clearAndEnterText(element, dataFieldName, driver, "Creating Data Field   at" + index+ "with name"+ dataFieldName);
	}

	public void clickingArraydocumenttype(int index,String field) throws Exception
	{
		List<WebElement> elemntArray = findElements("//span[contains(text(),'"+field+"')]//ancestor::span//label[contains(text(),'Array')]",driver);
		WebElement element = elemntArray.get(index);
		click(element,driver,"Creating Data Field at index.. " + index);
	}

	public void addingconstrains()
	{
		selectUsingVisibleText(SelectConstraintElement,driver,"anySimpleType","Select anySimpleType constraints");
	}

	public void EntermaxminlengthOfContrain(int index,String Maxlength,String Minlength) 
	{
//		//Entering Minimun length
//		log.info("Entering max and min length at" + index);
//		logExtentReport("Entering max and min length at" + index);
//		List<WebElement> elemntArray = driver
//				.findElements(By.xpath("//label[contains(text(),'Minimum Length')]/parent::div/div/input"));
//		log.info("All input parameters are....." + elemntArray);
//		WebElement element = elemntArray.get(index);
//		log.info("element at index..." + index + "......" + element);
//		element.click();
//		element.clear();
//		element.sendKeys(Minlength);
//
//		//Entering Maximum length
//		List<WebElement> elemntArray1 = driver
//				.findElements(By.xpath("//label[contains(text(),'Maximum Length')]/parent::div/div/input"));
//
//		log.info("All input parameters are....." + elemntArray);
//		WebElement element1 = elemntArray1.get(index);
//		log.info("element at index..." + index + "......" + element);
//		element1.click();
//		element1.clear();
//		element1.sendKeys(Maxlength);
	}







}
