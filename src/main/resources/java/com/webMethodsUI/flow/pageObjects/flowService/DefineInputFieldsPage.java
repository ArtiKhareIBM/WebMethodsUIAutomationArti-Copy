package com.webMethodsUI.flow.pageObjects.flowService;

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
		waitForElementVisible(defineInputOutputPageTitleElement,driver,"verify defineInputOutputPageTitleElement is visible");
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

	public void clickingArraydocumenttype(int index) throws Exception
	{
		List<WebElement> elemntArray = findElements("//label[contains(text(),'Array')]",driver);
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

}
