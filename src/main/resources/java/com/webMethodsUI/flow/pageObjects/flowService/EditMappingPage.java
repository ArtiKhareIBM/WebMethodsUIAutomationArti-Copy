package com.webMethodsUI.flow.pageObjects.flowService;


import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class EditMappingPage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(EditMappingPage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//label[contains(text(),'Show only mapped')]")
	@CacheLookup
	WebElement editMappingTitleElement;
	
	@FindBy(xpath = "//a[@class='ut-icon-data-mapper_map ut-pipeline-icon']")
	@CacheLookup
	WebElement mapLinkElement;
	
	@FindBy(xpath = "//*[contains(@class,'modal-title')][contains(text(),'Enable Mapping Recommendations')]")
	@CacheLookup
	WebElement enableMappingDialog;
	
	@FindBy(xpath = "//button[contains(text(),'No')]")
	@CacheLookup
	WebElement enableMapNoButton;
	
	@FindBy(xpath = "//div[@class='btn-groups flow-modal-footer']/button[3]")
	@CacheLookup
	WebElement saveButton;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public EditMappingPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("EditMappingPage Object created");
		closeEnableMappingDialogIfExists();
		waitForElementVisible(editMappingTitleElement,driver,"Verify editMapping title element is visible");
	}

//	public boolean isEditMappingTitleVisible() {
//		return editMappingTitleElement.isDisplayed();
//	}

	public void clickOnParentNode(int index) throws Exception 
	{
		
		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//i[@class='tree-icon dlt-icon-plus ng-star-inserted']"));

		WebElement element = elemntArray.get(index);
		click(element,driver,"element at index..." + index + "......" + element);

	}
	
	public void clickOnChildNode(int subindex) throws Exception 
	{
		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//div[@class='tree-node ng-star-inserted tree-branch index-border node-visible']//i[@class='tree-icon dlt-icon-plus ng-star-inserted']"));
		
		WebElement element = elemntArray.get(subindex);
		click(element,driver,"element at index..." + subindex + "......" + element);

	}

	// this method will work when there are unique child elemnts exists
	public void doubleClickOnChildParamName(String paramName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + paramName + "')]"));
		doubleClick(element,driver,"double clicking on child parameter.. " + paramName);
	}

	public boolean verifyValueSetForParameters(String paramName) throws Exception 
	{
		WebElement element = findElement("//a[@class='ut-icon-data-mapper_set-variable ng-star-inserted']/parent::span/span[@class='child-node'][contains(text(),'"+paramName+"')]",driver);
		waitForElementVisible(element,driver,"Verify ValueSet symbol is visible for the paratemer.. "+paramName);
		return true;
	}
	
	public void clickInputField( int index ,String FieldName) throws Exception {
		
		List<WebElement> elemntArray = findElements("//span[@class='child-node field-required']",driver);

		WebElement element = elemntArray.get(index);
		click(element,driver," Clicking on element at index..." + index + "......" + element);
	}
	
	public void clickOutputField( int index ,String FieldName) throws Exception 
	{
		List<WebElement> elemntArray = findElements("//span[@class='child-node'][contains(text(),'c')]",driver);
		WebElement element = elemntArray.get(index);
		click(element,driver," Clicking on element at index..." + index + "......" + element);
	}
	public void clickMapLink() throws Exception 
	{
		click(mapLinkElement,driver,"Clicking on mapLink...");
		
	}
	
	public boolean verifyMapLink() 
	{
		log.info("  Verifying mapLink is enabled ...");
		logExtentReport("Verifying mapLink is enabled ....");
		 return mapLinkElement.isEnabled();
	}
	public void expandParentNodeWithName(String parameter) throws Exception 
	{
		WebElement element = findElement("//span[contains(text(),'"+parameter+"')]//ancestor::div[@class='tree-context']/preceding-sibling::div[@class='tree-icon-container']/span/i",driver);
		click(element,driver,"Expand the field... "+parameter);
	}

	public void doubleclickonparameter(String paramName) throws Exception
	{
		WebElement element = driver
				.findElement(By.xpath("//span[@data-flow-title='"+ paramName +"']"));

		doubleClick(element, driver, "double clicking on child parameter...." + paramName);

	}

	public void clickonpubnubnubchannel() throws Exception{
		WebElement element = driver.findElement(By.xpath("//span[@data-flow-title='Channel']"));

		doubleClick(element, driver, "double clicking on pubnub channel....");
	}

	public void clickonpubnubnubmessage() throws Exception
	{
		WebElement element = driver.findElement(By.xpath("//span[@data-flow-title='Message']"));

		doubleClick(element, driver, "double clicking on pubnub message....");

	}
	
	public void setInputValue(String paramName, String value) throws Exception 
	{
			WebElement element = findElement("//div[@id='"+paramName+"']//input",driver);
			enterValue(element,value,driver,"Entering Input Value " +value);
	}
	
	public void verifyInputValue(String paramName, String value) throws Exception 
	{
			WebElement element = driver.findElement(By.xpath("//div[@id='"+paramName+"']//input[@placeholder='"+value+"']"));		
			waitForElementVisible(element,driver,"Verify value is present in inputField.. "+value);		
	}
	
	public void clickOnCancel() throws Exception 
	{
		WebElement element = findElement("//button[contains(@class,' dlt-button-secondary sm-button')][contains(text(),'Cancel')]",driver);
		click(element,driver,"Click cancel Button");
	}
	
	public void clickOnSave() throws Exception 
	{
		click(saveButton,driver,"Click Save Button");
	}
	
	public void closeEnableMappingDialogIfExists() throws Exception 
	{
		try
		{
			if (enableMappingDialog.isDisplayed()) 
			{
				click(enableMapNoButton,driver,"Closing the enable mapping dialog");
				waitForElementNotVisible(loader, driver, "wait for page load");
			}
		}
		catch(Exception e)
		{

		}
	}

}