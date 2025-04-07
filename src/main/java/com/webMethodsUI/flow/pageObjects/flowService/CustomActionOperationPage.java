package com.webMethodsUI.flow.pageObjects.flowService;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import java.util.List;

public class CustomActionOperationPage extends CommonActions{
	
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Select the Operation')]")
	@CacheLookup
	WebElement customOperationStepTitle;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Headers')]")
	@CacheLookup
	WebElement clickHeaderbutton;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	@CacheLookup
	WebElement AddHeaderbutton;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public CustomActionOperationPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("add custom Operation Object created");
		elementContainsText(customOperationStepTitle,"Select the Operation",driver,"Verify customOperationStepTitle is visible");
	}
	
	public void relodPageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOperationName(String operationName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+operationName+"')]"));
		click(element,driver,"Select operation..."+operationName);
	}
	
	public void clickOnHeadersPageNextButton() throws Exception 
	{
		click(nextButtonElement,driver,"Clicking on Next..."+nextButtonElement);
	}
	
	public CustomActionConfirmationPage clickNextButton() throws Exception 
	{
		WebElement element = findElement("//button[contains(text(),'Next')]",driver);
		click(element,driver,"Clicking on Next Button...");
		return new CustomActionConfirmationPage(driver);
	}
	
//	public String getcustomOperationStepTitle() {
//		waitHelper.waitForElement(customOperationStepTitle, ObjectReader.reader.getExplicitWait());
//		return customOperationStepTitle.getText();
//	}
//

	public void validateHeaders(String headerKey, String headerValue,String operationName) throws Exception
	{
		
		WebElement element = findElement("//button[contains(@class,'custom-header')][contains(text(),'Headers')]",driver);
		click(element,driver,"Clicking on Header button...");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement actionBackLink = driver.findElement(By.xpath("//span[@class='select-action-back'][text()='"+operationName+"']"));
		WebElement HeaderKey = driver.findElement(By.xpath("//input[@data-testid='headerkey'][@value='"+headerKey+"']"));
		WebElement HeaderValue = driver.findElement(By.xpath("//input[@data-testid='headerValue'][@value='"+headerValue+"']"));
		waitForElementVisible(actionBackLink, driver, "Verify action back link is visible... " +actionBackLink);
		waitForElementVisible(HeaderKey, driver, "Verify headerkey os visible.. "+headerKey);
		waitForElementVisible(HeaderValue, driver, "Verify HeaderValue os visible.. "+HeaderValue);
	}
	
	public void clickOnHeaders() throws Exception
	{
		
		WebElement element = findElement("//button[contains(@class,'custom-header')][contains(text(),'Headers')]",driver);
		click(element,driver,"Clicking on Header button...");
		waitForElementNotVisible(loader, driver, "wait for page load");
//		WebElement actionBackLink = driver.findElement(By.xpath("//span[@class='select-action-back'][text()='"+operationName+"']"));
//		WebElement HeaderKey = driver.findElement(By.xpath("//input[@data-testid='headerkey'][@value='"+headerKey+"']"));
//		WebElement HeaderValue = driver.findElement(By.xpath("//input[@data-testid='headerValue'][@value='"+headerValue+"']"));
//		waitForElementVisible(actionBackLink, driver, "Verify action back link is visible... " +actionBackLink);
//		waitForElementVisible(HeaderKey, driver, "Verify headerkey os visible.. "+headerKey);
//		waitForElementVisible(HeaderValue, driver, "Verify HeaderValue os visible.. "+HeaderValue);
	}

	public void Addheaderbutton() throws Exception
	{
		click(AddHeaderbutton,driver,"Clicking on Add Header button..");
	}

	public void enteringnewHeadernamein(int index,String Headername) throws InterruptedException 
	{
		List<WebElement> elemntArray = driver.findElements(By.xpath("//i[@class='dd-icons dd-edit-icon icon-mr mrm']"));
		WebElement element = elemntArray.get(index);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		List<WebElement> elemntArray1 = driver.findElements(By.xpath("//i[@class='dd-icons dd-edit-icon icon-mr mrm']/parent::div/input"));
		WebElement element1 = elemntArray1.get(index);
		element1.click();
		element1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(3000);
		//ServerURL.clear();
		element1.sendKeys(Headername);
	}
	
	public void selectBussinessObject() throws Exception
	{
//		WebElement element = findElement("//span[contains(text(),'promote (Solution)')]/preceding-sibling::i[contains(@class,'dlt-icon-caret-right right-arrow')]",driver);
		WebElement element = findElement("(//i[@class='dlt-icon-caret-right right-arrow'])[3]",driver);
		click(element,driver,"Expand the solution..");
		waitForElementNotVisible(loader, driver, "wait for page load");
//		WebElement ISelement = findElement("//span[contains(text(),'IS1')]/preceding-sibling::i[contains(@class,'right-arrow')]",driver);
		WebElement ISelement = findElement("(//i[@class='dlt-icon-caret-right right-arrow'])[3]",driver);
		click(ISelement,driver,"Expand the IS node..");
		waitForElementNotVisible(loader, driver, "wait for page load");
//		WebElement Package = findElement("//span[contains(text(),'WMIOAssets')]/preceding-sibling::i[contains(@class,'right-arrow')]",driver);
		WebElement WMIOAssets_Package = findElement("(//i[@class='dlt-icon-caret-right right-arrow'])[62]",driver);
		click(WMIOAssets_Package,driver,"Expand the Package..");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement folder = findElement("//span[contains(text(),'addInts')]/preceding-sibling::i[contains(@class,'right-arrow')]",driver);
		click(folder,driver,"Expand the folder..");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement flowserviceName = findElement("//span[contains(text(),'addNumbersUsingDoctypes')]",driver);
		click(flowserviceName,driver,"Select flow service..");
		waitForElementNotVisible(loader, driver, "wait for page load");

	}
	
	public void selectDataFields() throws Exception
	{
		List<WebElement> element = findElements("//span[contains(@class,'icon-info')][@title='This field is not loaded. Expand the field to view the child fields.']",driver);
		waitForElementVisible(element.get(0), driver, "Verify This field is not loaded. Expand the field to view the child fields. info is visible");
		List<WebElement> element1 = findElements("//span[contains(@class,'icon-info')][@title='This field is not loaded. Expand the field to view the child fields.']/following-sibling::span/i[contains(text(),'keyboard_arrow_down')]",driver);
		click(element1.get(0),driver,"Expand the Myinput field..");
		waitForElementNotVisible(loader, driver, "wait for page load");
		
		List<WebElement> chidlField = findElements("//span[@class='filed-name']",driver);
		elementContainsText(chidlField.get(0),"a",driver,"Verify chidl field is visible.."+chidlField.get(0));
		elementContainsText(chidlField.get(1),"b",driver,"Verify chidl field is visible.."+chidlField.get(1));

		waitForElementVisible(element.get(1), driver, "Verify DocOutput : This field is not loaded. Expand the field to view the child fields. info is visible");
		click(element1.get(1),driver,"Expand the DocOutput field..");
		waitForElementNotVisible(loader, driver, "wait for page load");
		
		chidlField = findElements("//span[@class='filed-name']",driver);
		elementContainsText(chidlField.get(3),"c",driver,"Verify chidl field is visible.."+chidlField.get(3));

	}

}
