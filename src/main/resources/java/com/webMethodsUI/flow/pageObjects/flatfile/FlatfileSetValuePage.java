package com.webMethodsUI.flow.pageObjects.flatfile;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.flowService.SetValuePage;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlatfileSetValuePage {
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(FlatfileSetValuePage.class);
	TestBase test;

	WaitHelper waitHelper;
	
	@FindBy(xpath = "//h4[@class='modal-title pull-left']")
	@CacheLookup
	WebElement setValuePageTitleElement;
	
	@FindBy(xpath = "//label[contains(text(),' @record-id ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement recordIdTexfieldElement;
	
	@FindBy(xpath = "//label[contains(text(),' @segment-id ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement segmentIdTexfieldElement;
	
	@FindBy(xpath = "//label[contains(text(),' Field1 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement field1TextfieldElement;
	
	@FindBy(xpath = "//label[contains(text(),' Field2 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement field2TextfieldElement;
	
	@FindBy(xpath = "//label[contains(text(),' Field3 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement field3TextfieldElement;
	
	@FindBy(xpath = "//label[contains(text(),' Field4 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement field4TextfieldElement;
	
	@FindBy(xpath = "//label[contains(text(),' Field5 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement field5TextfieldElement;
	
	
	@FindBy(xpath = "//label[contains(text(),' @composite ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement compositeTextfieldElement;
	
	@FindBy(xpath = "//label[contains(text(),' SuFil1 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement subField1TextfieldElement;
	
	@FindBy(xpath = "//label[contains(text(),' SuFil2 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement subField2TextfieldElement;
	
	
	@FindBy(xpath = "//label[contains(text(),' subfield1 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement subField1TextfieldsElement;
	
	@FindBy(xpath = "//label[contains(text(),' subfield2 ')]/parent::div/flow-input-control/div/input")
	@CacheLookup
	WebElement subField2TextfieldsElement;

	
	
	

	@FindBy(xpath = "//button[@class='dlt-button dlt-button-primary m-20 sm-button modal-button']")
	@CacheLookup
	WebElement saveButtonElement;
	
	
	
	
	
	
	
	
	
	
	public FlatfileSetValuePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(setValuePageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + setValuePageTitleElement.getText());
		logExtentReport("SetValuePage Object created");
	}
	public void clickOnAddValueForManualFlatfile() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),' Manual_Flatfile_Connector_dt ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	
	public void clickOnAddValueManualNoRecIdentifierFlatfile() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),' Manual_No_Rec_Identifier_FF_dt ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	
	public void clickOnAddValueIcon() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//span[@class='run-input-addicon dlt-icon-plus']"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	
	public void clickOnAddValueForFlatfileIcon() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),' CRLF:Fairfax:Virginia:22030@1234:(703)123-4568 ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}

	public void clickOnAddValuesForFlatfile() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),' ABCD ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	
	public void clickOnAddValuesForFixedLengthConnectorButton() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//label[@class='dlt-form-label test-input-label']/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	
	
	public void clickOnAddRecordValues() {
        log.info("Clicking on adding record values");
        logExtentReport("Clicking on adding record values");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),' Record ')]/parent::div/parent::div/parent::div/preceding-sibling::div/child::span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	
	public void clickOnAddValueIconForSampleFlatfile() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//div[@id='Sample_Flatfile_Connector_dt']/div/span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	

	public void clickOnAddValueIconForSampleFlatfileWithNoRec() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//div[@id='Sample_FF_No_Rec_Identifier_dt']/div/span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	
	
	
	public void enterRecordId(String recordId)
	{
		log.info("Creating flatfile connector with description... " + recordId);
		logExtentReport("Creating flatfile connector with description... " + recordId);
		recordIdTexfieldElement.sendKeys(recordId);
		
	}
	
	public void entersegmentId(String segmentId)
	{
		log.info("Creating flatfile connector with description... " + segmentId);
		logExtentReport("Creating flatfile connector with description... " + segmentId);
		segmentIdTexfieldElement.sendKeys(segmentId);
		
	}
	
	public void enterField1(String Field1)
	{
		log.info("entering the field1 value... " + Field1);
		logExtentReport("entering field1 value... " + Field1);
		field1TextfieldElement.sendKeys(Field1);
		
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
	
	public void clickField2PlusIcon() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),' Field2 ')]/parent::*/parent::*/parent::div/parent::div/child::div/span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	public void clickField6PlusIcon() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),' Field6 ')]/parent::*/parent::*/parent::div/parent::div/child::div/span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	public void clickField4PlusIcon() {
        log.info("Clicking on add value icon");
        logExtentReport("Clicking on add value icon");
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),' Field4 ')]/parent::*/parent::*/parent::div/parent::div/child::div/span/i"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
}
	
	
	public void enterComposite(String composite)
	{
		log.info("Creating flatfile connector with description... " + composite);
		logExtentReport("Creating flatfile connector with description... " + composite);
		compositeTextfieldElement.sendKeys(composite);
		
	}
	
	public void enterSubField1(String subField1)
	{
		log.info("Creating flatfile connector with description... " + subField1);
		logExtentReport("Creating flatfile connector with description... " + subField1);
		subField1TextfieldElement.sendKeys(subField1);
		
	}
	
	public void enterSubField2(String subField2)
	{
		log.info("Creating flatfile connector with description... " + subField2);
		logExtentReport("Creating flatfile connector with description... " + subField2);
		subField2TextfieldElement.sendKeys(subField2);
		
	}
	
	
	public void enterSubField1Text(String subField1)
	{
		log.info("Creating flatfile connector with description... " + subField1);
		logExtentReport("Creating flatfile connector with description... " + subField1);
		subField1TextfieldsElement.sendKeys(subField1);
		
	}
	
	public void enterSubField2Text(String subField2)
	{
		log.info("Creating flatfile connector with description... " + subField2);
		logExtentReport("Creating flatfile connector with description... " + subField2);
		subField2TextfieldsElement.sendKeys(subField2);
		
	}
	

	public void clickOnSave() {
		log.info("Clicking on Save...");
		logExtentReport("Clicking on Save...");
		WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait() );
		wait.until(ExpectedConditions.elementToBeClickable(saveButtonElement));
		saveButtonElement.click();
	}


}
