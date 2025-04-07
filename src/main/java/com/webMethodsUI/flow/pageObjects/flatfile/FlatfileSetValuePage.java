package com.webMethodsUI.flow.pageObjects.flatfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class FlatfileSetValuePage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(FlatfileSetValuePage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h4[@class='modal-title pull-left']")
	@CacheLookup
	WebElement setValuePageTitleElement;

	@FindBy(xpath = "//label[contains(text(),'@record-id ')]/parent::div/flow-input-control/div//textarea")
	@CacheLookup
	WebElement recordIdTexfieldElement;

	@FindBy(xpath = "//label[contains(text(),'@segment-id ')]/parent::div/flow-input-control/div//textarea")
	@CacheLookup
	WebElement segmentIdTexfieldElement;

	@FindBy(xpath = "//label[contains(text(),'Field1')]/parent::div/flow-input-control/div//textarea")
	@CacheLookup
	WebElement field1TextfieldElement;

	@FindBy(xpath = "//label[contains(text(),'Field2')]/parent::div/flow-input-control/div//textarea")
	@CacheLookup
	WebElement field2TextfieldElement;

	@FindBy(xpath = "//label[contains(text(),'Field3')]/parent::div/flow-input-control/div//textarea")
	@CacheLookup
	WebElement field3TextfieldElement;

	@FindBy(xpath = "//label[contains(text(),' Field4 ')]/parent::div/flow-input-control/div//textarea")
	@CacheLookup
	WebElement field4TextfieldElement;

	@FindBy(xpath = "//label[contains(text(),' Field5 ')]/parent::div/flow-input-control/div//textarea")
	@CacheLookup
	WebElement field5TextfieldElement;


	@FindBy(xpath = "//label[contains(text(),' @composite')]/parent::div/flow-input-control//div/textarea")
	@CacheLookup
	WebElement compositeTextfieldElement;

	@FindBy(xpath = "//label[contains(text(),' SuFil1 ')]/parent::div/flow-input-control//div/textarea")
	@CacheLookup
	WebElement subField1TextfieldElement;

	@FindBy(xpath = "//label[contains(text(),' SuFil2 ')]/parent::div/flow-input-control//div/textarea")
	@CacheLookup
	WebElement subField2TextfieldElement;

	@FindBy(xpath = "//label[contains(text(),' subfield1 ')]/parent::div/flow-input-control//div/textarea")
	@CacheLookup
	WebElement subField1TextfieldsElement;

	@FindBy(xpath = "//label[contains(text(),' subfield2 ')]/parent::div/flow-input-control//div/textarea")
	@CacheLookup
	WebElement subField2TextfieldsElement;


	@FindBy(xpath = "//button[@class='dlt-button dlt-button-primary m-20 sm-button modal-button']")
	@CacheLookup
	WebElement saveButtonElement;

	public FlatfileSetValuePage(WebDriver driver) 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("SetValuePage Objects refreshed");
	}
	
	public void clickOnAddValueForManualFlatfile() throws Exception 
	{
        WebElement element = findElement("//label[contains(text(),' Manual_Flatfile_Connector_dt ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i",driver);
        click(element, driver, "Clicking on add value icon");
	}

	public void clickOnAddValueManualNoRecIdentifierFlatfile() throws Exception 
	{

        WebElement element = findElement("//label[contains(text(),' Manual_No_Rec_Identifier_FF_dt ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i",driver);
        click(element, driver, "Clicking on add value icon");
	}

	public void clickOnAddValueIcon() throws Exception 
	{
        WebElement element = findElement("//span[@class='run-input-addicon dlt-icon-plus']",driver);
        click(element, driver, "Clicking on add value icon");
	}

	public void clickOnAddValueForFlatfileIcon() throws Exception 
	{
        WebElement element = findElement("//label[contains(text(),' CRLF')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i",driver);
        click(element, driver, "Clicking on add value icon");
     }

	public void clickOnAddValuesForFlatfile() throws Exception
	{
        WebElement element = findElement("//label[contains(text(),' ABCD ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i",driver);
  		click(element,driver,"expaning the child document...."+element);
  		Thread.sleep(5000);
    }

	public void clickOnAddValuesForFixedLengthConnectorButton() throws Exception
	{
        WebElement element = findElement("//label[@class='dlt-form-label test-input-label']/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i",driver);
		click(element, driver, "Clicking on add value icon");
	}


	public void clickOnAddRecordValues() throws Exception 
	{
        WebElement element = findElement("//label[contains(text(),' Record ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i",driver);
		click(element, driver, "Clicking on adding record values");
		Thread.sleep(5000);
	}

	public void clickOnAddValueIconForSampleFlatfile() throws Exception
	{  
        WebElement element = findElement("//div[@id='Sample_Flatfile_Connector_dt']/div/span/i",driver);
		click(element, driver, "Clicking on add value icon");
	}

	public void clickOnAddValueIconForSampleFlatfileWithNoRec() throws Exception 
	{
        WebElement element =findElement("//div[@id='Sample_FF_No_Rec_Identifier_dt']/div/span/i",driver);
		click(element, driver, "Clicking on add value icon");
	}

	public void enterRecordId(String recordId) throws Exception
	{
		click(recordIdTexfieldElement, driver, "Clicking on inout field");
		enterValue(recordIdTexfieldElement, recordId, driver, "entering the data in the field... " + recordId);
	}

	public void entersegmentId(String segmentId) throws Exception
	{
		enterValue(segmentIdTexfieldElement, segmentId, driver, "Creating flatfile connector with description... " + segmentId);
	}

	public void enterField1(String Field1) throws Exception
	{
		enterValue(field1TextfieldElement, Field1, driver, "entering the field1 value... " + Field1);
	}

	public void enterField2(String Field2)
	{
		log.info("entering field2 value... " + Field2);
		logExtentReport("entering field 2 value... " + Field2);
		field2TextfieldElement.sendKeys(Field2);
	}

	public void enterField3(String Field3)
	{
		log.info("entering field3 value... " + Field3);
		logExtentReport("entering field 3 value... " + Field3);
		field3TextfieldElement.sendKeys(Field3);
	}

	public void enterField4(String Field4)
	{
		log.info("entering field4 value... " + Field4);
		logExtentReport("entering field4 value... " + Field4);
		field4TextfieldElement.sendKeys(Field4);
	}
	
	public void enterField5(String Field5)
	{
		log.info("entering field4 value... " + Field5);
		logExtentReport("entering field4 value... " + Field5);
		field5TextfieldElement.sendKeys(Field5);
	}

	public void clickField2PlusIcon(String fieldname) throws Exception 
	{
        WebElement element = findElement("//label[contains(text(),'" + fieldname + "')]/parent::*/parent::*/parent::div/parent::div/child::div/span/i",driver);
		click(element, driver, "Clicking on add value icon");
		Thread.sleep(3000);
		new FlatfileSetValuePage(driver);
	}
	
	public void clickField6PlusIcon() throws Exception 
	{
        WebElement element = findElement("//label[contains(text(),' Field6 ')]/parent::*/parent::*/parent::div/parent::div/child::div/span/i",driver);
        click(element, driver, "Clicking on add value icon");
	}
	
	public void clickField4PlusIcon() throws Exception 
	{
        WebElement element = findElement("//label[contains(text(),' Field4 ')]/parent::*/parent::*/parent::div/parent::div/child::div/span/i",driver);
        click(element, driver, "Clicking on add value icon");
	}

	public void enterComposite(String composite) throws Exception
	{
		scrollPageToElement(driver, compositeTextfieldElement);
		enterValue(compositeTextfieldElement, composite, driver, "Creating flatfile connector with description... " + composite);
	}

	public void enterSubField1(String subField1) throws Exception
	{
		enterValue(subField1TextfieldElement, subField1, driver, "Creating flatfile connector with description... " + subField1);
	}

	public void enterSubField2(String subField2) throws Exception
	{
		enterValue(subField2TextfieldElement, subField2, driver, "Creating flatfile connector with description... " + subField2);
	}


	public void enterSubField1Text(String subField1) throws Exception
	{
		enterValue(subField1TextfieldsElement, subField1, driver, "Creating flatfile connector with description... " + subField1);
	}

	public void enterSubField2Text(String subField2) throws Exception
	{
		enterValue(subField2TextfieldsElement, subField2, driver, "Creating flatfile connector with description... " + subField2);
	}

	public void clickOnSave() throws Exception 
	{
		click(saveButtonElement, driver, "Clicking on Save...");
	}


}
