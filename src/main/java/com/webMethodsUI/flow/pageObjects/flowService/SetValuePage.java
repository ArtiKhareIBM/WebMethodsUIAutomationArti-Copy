package com.webMethodsUI.flow.pageObjects.flowService;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class SetValuePage extends CommonActions{

	private WebDriver driver;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h4[contains(text(),'Set Value')]")
	@CacheLookup
	WebElement setValuePageTitleElement;
	
	@FindBy(xpath = "//div[@class='btn-groups flow-modal-footer']/button[3]")
	@CacheLookup
	WebElement saveButtonElement;
	
	//@FindBy(xpath = "//input[@placeholder='Enter value here']")
	@FindBy(xpath = "//input[@placeholder='Enter value here']")
	@CacheLookup
	List <WebElement> setValueInputElement;
	
	@FindBy(xpath = "//input[@placeholder='Enter value here']")
	@CacheLookup
	WebElement setArrayElementValue;
	
	@FindBy(xpath = "//div[@id='a']//textarea[@placeholder='Enter value here']")
	@CacheLookup
	WebElement setAValueInputElement;
	
	@FindBy(xpath = "//div[@id='b']//textarea[@placeholder='Enter value here']")
	@CacheLookup
	WebElement setBValueInputElement;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter value here']")
	@CacheLookup
	WebElement setIdValueElement;
	

	public SetValuePage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("SetValuePage Object created");
		waitForElementVisible(setValuePageTitleElement,driver,"Verify setValuePageTitleElement is present");
	}

	public void setValue(String paramName, String value) throws Exception 
	{
		WebElement element = findElement("//label[contains(text(),'"+paramName+"')]/ancestor::div/flow-input-control//div/textarea",driver);
		enterValue(element,value,driver,"Entering Input Value " +value);
	}
	
	public void setValueInput( String inputValue, int index) throws Exception 
	{	
		  List<WebElement> ele = findElements("//input[@placeholder='Enter value here']", driver);
			click(ele.get(index), driver, "Click setInput value field");
			Thread.sleep(2000);
			enterValue(ele.get(index), inputValue, driver, "setting value with...... " + inputValue);
	}
	
	public void setArrayElementValue( String inputValue ) throws Exception 
	{	
		click(setArrayElementValue,driver,"Click setValueInput Element");
		enterValue(setArrayElementValue,inputValue,driver,"setting value with...... " +inputValue);
	}
	
	
	public void enterAValue( String inputValue ) throws Exception 
	{
		click(setAValueInputElement,driver,"Click setValueInput Element");
		enterValue(setAValueInputElement,inputValue,driver,"setting value with...... " +inputValue);
	}
	
	public void enterBValue( String inputValue ) throws Exception 
	{
		click(setBValueInputElement,driver,"Click setValueInput Element");
		enterValue(setBValueInputElement,inputValue,driver,"setting value with...... " +inputValue);
	}
	
	public void enterValue( String inputValue ) throws Exception 
	{
		click(setIdValueElement,driver,"Click setValueInput Element");
		enterValue(setIdValueElement,inputValue,driver,"setting value with...... " +inputValue);
	}
	
	public void clickOnSave() throws Exception 
	{	
		click(saveButtonElement,driver,"Clicking on Save...");
	}
	
	public void Addfieldicon(int index) throws Exception
	{
		List<WebElement> elemntArray = findElements("//span[@title='Add value']",driver);
		WebElement element = elemntArray.get(index);
		click(element,driver," clicking field icon...");
	}

	public void clickOnParentNodeWithName(String parameter) throws Exception 
	{
		WebElement element = findElement("//label[contains(text(),'"+parameter+"')]//ancestor::div[@class='tree-context']/preceding-sibling::div[@class='tree-icon-container']/span/i",driver);
		click(element,driver," clicking field icon...");
	}
}
