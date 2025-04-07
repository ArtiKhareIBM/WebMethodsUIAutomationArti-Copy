package com.webMethodsUI.flow.pageObjects.RESTConnector;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class HeadersPage extends CommonActions{

	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(),'Headers')]")
	@CacheLookup
	WebElement HeaderTitle;
	
	@FindBy(xpath = "//input[@placeholder='Type the Header Name']")
	@CacheLookup
	WebElement TypeTheHeaderNameElement;
	
	@FindBy(xpath = "//input[@placeholder='Type a Value']")
	@CacheLookup
	WebElement TypeaValueElement;
	
	@FindBy(xpath = "//*[text()='Mandatory']/..//div/input[contains(@id,'input')]")
	@CacheLookup
	List<WebElement> isHeaderMandatory;
	
	// (//input[@placeholder='Type the Header Name'])[1] to differentiate between
	// duplicates
	/*
	 * @FindBy(xpath = "//input[@placeholder='Type the Header Name']")
	 * 
	 * @CacheLookup WebElement headerName;
	 */

	// (//input[@placeholder='Type a Value'])[1]
	/*
	 * @FindBy(xpath = "//input[@placeholder='Type a Value']")
	 * 
	 * @CacheLookup WebElement headerValue;
	 */

	/*
	 * @FindBy(xpath = "//input[@aid='Mandatory']")
	 * 
	 * @CacheLookup WebElement isHeaderMandatory;
	 */

	GenericHelper genericHelper;

	public HeadersPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("HeadersPage PageObject created");
	}
	
	public void enterHeaderName1(int index,String headerName) throws Exception
	{
		List<WebElement> elemntArray = findElements("//input[@placeholder='Type the Header Name']",driver);
		WebElement element = elemntArray.get(index);
		click(element,driver,"element at index..." + index + "......" + element);
		enterValue(element,headerName,driver,"Entering Header Name " +headerName);
	}
	
	/*public void enterHeaderName(String headerName) {
		log.info("Entering headerName... " + headerName);
		logExtentReport("Entering headerName ... " + headerName);
		this.TypeTheHeaderNameElement.sendKeys(headerName);

	}*/

	public void enterHeaderValue1(int index,String headerValue) throws Exception 
	{
		List<WebElement> elemntArray = findElements("//input[@placeholder='Type a Value']",driver);
		WebElement element = elemntArray.get(index);
		click(element,driver,"element header value at index..." + index + "......" + element);
		enterValue(element,headerValue,driver,"Entering Header Name " +headerValue);
	}
	
	public void selectHeaderMandatoryValue(String headerMandatoryValue, int headerIndex) throws Exception 
	{
		GenericHelper genericHelper = new GenericHelper(driver);
		List<WebElement> element = findElements("//*[text()='Mandatory']/../div/div/div/div[contains(@class,'singleValue')]",driver);
		WebElement newEle = element.get(headerIndex);
		genericHelper.clickOnDropDown(newEle,headerIndex);
		List<WebElement> elements = findElements("//div[contains(text(),'" + headerMandatoryValue + "')]",driver);
		WebElement newEle1 = elements.get(headerIndex);
		click(newEle1,driver,"selecting value from drop down link  " + headerMandatoryValue);
	}		  
	
	//headerName index starts with 1
	public void enterHeaderName(String headerName, int headerSectionIndex) throws Exception {
			String fPart = "(//input[@placeholder='Type the Header Name'])[";
			String sPart = "]";
			WebElement element = findElement(fPart + headerSectionIndex + sPart,driver);
			enterValue(element,headerName,driver,"Entering headerName... " + headerName + "And header section index is " + headerSectionIndex);
	}
	
	//headerValue index starts with 2
	public void enterHeaderValue(String headerValue, int headerSectionIndex) throws Exception {

			String fPart = "(//input[@placeholder='Type a Value'])[";
			String sPart = "]";
			WebElement element = findElement(fPart + headerSectionIndex + sPart,driver);
			enterValue(element,headerValue,driver,"Entering header Value... " + headerValue + "And header section index is " + headerSectionIndex);
	}
	
	//headerMandatory index starts with 2
	public void selectIsHeaderMandatory(String mandatoryValue, int headerSectionIndex, int mandatoryValueIndex) throws Exception 
	{

//			String fPart = "(//input[@aid='Mandatory'])[";
//			String sPart = "]";
			GenericHelper genericHelper = new GenericHelper(driver);
			List<WebElement> element = findElements("//*[text()='Mandatory']/../div/div/div/div[contains(@class,'singleValue')]",driver);
			WebElement newEle = element.get(headerSectionIndex);
			genericHelper.clickOnDropDown(newEle,headerSectionIndex);
//			genericHelper.selectDropDownLink(mandatoryValue);
			WebElement mandatoryValueElement = findElement("(//div[contains(text(),'" + mandatoryValue + "')])["+mandatoryValueIndex+"]",driver);
			click(mandatoryValueElement,driver,"selecting value from drop down link  " + mandatoryValue);

	}
	
	public String getHeaderNameValue(String headerName) throws Exception 
	{
		WebElement element = findElement("//input[@value='"+headerName+"']",driver);
		return element.getText();
	}
}
