package com.webMethodsUI.flow.pageObjects.flowService;

import java.util.List;

import com.webMethodsUI.flow.helper.DropDown.DropDownHelper;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class DefineInputFieldsPage extends CommonActions {
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(DefineInputFieldsPage.class);
	TestBase test;

	WaitHelper waitHelper;
	
	@FindBy(xpath = "//h4[contains(text(),'Define input and output fields')]")
	@CacheLookup
	WebElement defineInputOutputPageTitleElement;
	
	
	@FindBy(xpath = "//span[contains(text(),'Input Fields')]")
	@CacheLookup
	WebElement intputFieldElement;

	public DefineInputFieldsPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("Define InputFields PageObject created");
		logExtentReport("Define InputFields PageObject created");
//		waitForElementVisible(defineInputOutputPageTitleElement,driver,"verify defineInputOutputPageTitleElement is visible");
	}
	
	public void clickplusIcon(int index) throws Exception 
	{
		List<WebElement> elemntArray = driver.findElements(By.xpath("//a[@class='io-tree-action-icon io-add-icon dlt-icon-plus ng-star-inserted']"));
		WebElement element = elemntArray.get(index);
		click(element,driver,"Click on plus icon.. "+element);
	}
	

	public void createInputDataField(int index,String dataFieldName) throws Exception 
	{
		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//input[@placeholder='Field name']"));

		WebElement element = elemntArray.get(index);
		enterValue(element,dataFieldName,driver,"Creating Data Field   at" + index+ "with name"+ dataFieldName);
	}
	
	public boolean verifyCreatedDataFields(String dataFieldName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[@class='ut-field-name field-required'][contains(text(),'"+dataFieldName+"')]"));
		waitForElementVisible(element,driver,"Verify the created data field is with name .........."+ dataFieldName);
		return element.isDisplayed();
	}

	public void clickingArraydocumenttype(int index,String field) throws Exception
	{
		List<WebElement> elemntArray = findElements("//span[contains(text(),'"+field+"')]//ancestor::span//label[contains(text(),'Array')]",driver);
		WebElement element = elemntArray.get(index);
		click(element,driver,"Creating Data Field   at" + index);
	}

	public void AddingDocumentReferenceinInputField(int index,String DocumentName) throws Exception 
	{
		List<WebElement> elemntArray =findElements("//div[@class='input-selection pull-left ng-star-inserted']/div[2]/label[contains(text(),'Document reference')]",driver);

		WebElement element = elemntArray.get(index);
		click(element,driver,"element at index..." + index + "......" + element);
		
		List<WebElement> elemntArray1 = driver
				.findElements(By.xpath("//select[@id='doc-ref-selection']"));
		WebElement element1 = elemntArray1.get(index);

		selectUsingVisibleText(element1,driver,DocumentName,"Selecting documentName"+ DocumentName);
	}
	
	public void verifythespecificationDropDownIsDisabled() throws Exception
	{
		WebElement dropdown = findElement("//select[@id='spec-selection']",driver);
		isElementDisabled(dropdown,driver,"Verify dropdown is disabled or not");
	}
	
	public void verifythespecification() throws Exception
	{
		WebElement errorDetails = findElement("//span[text()=' errorDetails ']",driver);
		waitForElementVisible(errorDetails, driver, "Verify errorDetails field is visible");
		WebElement result = findElement("//span[text()=' result ']",driver);
		waitForElementVisible(result, driver, "Verify result field is visible");
		WebElement plusIcon = findElement("(//i[contains(@class,'icon-plus')])[1]",driver);
		click(plusIcon, driver, "Expand of error details");
		WebElement inputField = findElement("//span[text()=' listenerAlias ']",driver);
		waitForElementVisible(inputField, driver, "Verify listenerAlias  is visible");
		inputField = findElement("//span[text()=' code ']",driver);
		waitForElementVisible(inputField, driver, "Verify code  is visible");
		inputField = findElement("//span[text()=' error ']",driver);
		waitForElementVisible(inputField, driver, "Verify error  is visible");
		inputField = findElement("//span[text()=' cause ']",driver);
		waitForElementVisible(inputField, driver, "Verify cause  is visible");
		inputField = findElement("//span[text()=' timestamp ']",driver);
		waitForElementVisible(inputField, driver, "Verify timestamp  is visible");
		inputField = findElement("//span[text()=' timestamp ']",driver);
		waitForElementVisible(inputField, driver, "Verify timestamp  is visible");
	    plusIcon = findElement("(//i[contains(@class,'icon-plus')])[6]",driver);
		click(plusIcon, driver, "Expand of result");
		inputField = findElement("//span[text()=' status ']",driver);
		waitForElementVisible(inputField, driver, "Verify status  is visible");
		inputField = findElement("//span[text()=' statusMessage ']",driver);
		waitForElementVisible(inputField, driver, "Verify statusMessage  is visible");
		inputField = findElement("//span[text()=' startTime ']",driver);
		waitForElementVisible(inputField, driver, "Verify startTime  is visible");
		inputField = findElement("//span[text()=' endTime ']",driver);
		waitForElementVisible(inputField, driver, "Verify endTime  is visible");
		WebElement doneButton = findElement("//input[@type='submit']",driver);
		click(doneButton, driver, "Click on done button");
	}
	
	public void clickonDefineIOicon()throws Exception
	{
		WebElement element = driver.findElement(By.xpath("//a[@class='ut-icon-action-bar_io ng-star-inserted']"));
		element.click();
	}

	public void validateAllInputFields()throws Exception
	{
		
		String input_label = driver.findElement(By.xpath("//span[text()='Input Fields']")).getText();
		System.out.println(input_label);
		Assert.assertEquals(input_label, "Input Fields", "Input Fields tab is visible.");
		
		String Inputfield_1 = driver.findElement(By.xpath("(//span[text()=' access_token '])[1]")).getText();
		Assert.assertEquals(Inputfield_1, "access_token", "access_token inputfield is present.");
		
		String Inputfield_2 = driver.findElement(By.xpath("//span[text()=' consumer_id ']")).getText();
		Assert.assertEquals(Inputfield_2, "consumer_id", "consumer_id inputfield is present.");
		
		String Inputfield_3 = driver.findElement(By.xpath("//span[text()=' consumer_secret ']")).getText();
		Assert.assertEquals(Inputfield_3, "consumer_secret", "consumer_secret inputfield is present.");
		
		String Inputfield_4 = driver.findElement(By.xpath("(//span[text()=' refresh_token '])[1]")).getText();
		Assert.assertEquals(Inputfield_4, "refresh_token", "refresh_token inputfield is present.");
		try {
			String Inputfield_5 = driver.findElement(By.xpath("//span[text()=' access_token_refresh_url ']")).getText();
			Assert.assertEquals(Inputfield_5, "access_token_refresh_url","access_token_refresh_url inputfield is present.");
		} catch(StaleElementReferenceException e) {

		}
		String Inputfield_6 = driver.findElement(By.xpath("//span[text()=' sslKeyStoreAlias ']")).getText();
		Assert.assertEquals(Inputfield_6, "sslKeyStoreAlias", "sslKeyStoreAlias inputfield is present.");
		
		String Inputfield_7 = driver.findElement(By.xpath("//span[text()=' sslKeyAlias ']")).getText();
		Assert.assertEquals(Inputfield_7, "sslKeyAlias", "sslKeyAlias inputfield is present.");
		
		String Inputfield_8 = driver.findElement(By.xpath("//span[text()=' sslTrustStoreAlias ']")).getText();
		Assert.assertEquals(Inputfield_8, "sslTrustStoreAlias", "sslTrustStoreAlias inputfield is present.");
		
		log.info("all the input signature assertions are passed from inputfield tab....");
		
	}
	
	
	public void navigateToOutputFieldsTab()throws Exception
	{
		WebElement output_tab = driver.findElement(By.xpath("//span[text()='Output Fields']"));
		output_tab.click();
	}
	
	public void validateAllOutputFields()throws Exception
	{
		String output_label = driver.findElement(By.xpath("//span[text()='Output Fields']")).getText();
		System.out.println(output_label);
		Assert.assertEquals(output_label, "Output Fields", "Output Fields tab is visible.");
		
		String outputfield_1 = driver.findElement(By.xpath("(//span[text()=' access_token '])[2]")).getText();
		Assert.assertEquals(outputfield_1, "access_token", "access_token outputfield is present.");
				
		String outputfield_2 = driver.findElement(By.xpath("//span[text()=' token_type ']")).getText();
		Assert.assertEquals(outputfield_2, "token_type", "token_type outputfield is present.");
		
		String outputfield_3 = driver.findElement(By.xpath("//span[text()=' expires_in ']")).getText();
		Assert.assertEquals(outputfield_3, "expires_in", "expires_in outputfield is present.");
		
		String outputfield_4 = driver.findElement(By.xpath("(//span[text()=' refresh_token '])[2]")).getText();
		Assert.assertEquals(outputfield_4, "refresh_token", "refresh_token  outputfield is present.");
		
		String outputfield_5 = driver.findElement(By.xpath("//span[text()=' scope ']")).getText();
		Assert.assertEquals(outputfield_5, "scope", "scope outputfield is present.");
		
		log.info("all the output signature assertions are passed from outputfield tab....");
		
	}
	
	public void closeDefineIOFieldwindow()throws Exception
	{
		WebElement output_tab = driver.findElement(By.xpath("//a[@class='dlt-icon-close flow-modal-close-icon']"));
		output_tab.click();
	}
}
