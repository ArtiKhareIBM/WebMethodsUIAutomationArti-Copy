package com.webMethodsUI.flow.helper.generic;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GenericHelper extends CommonActions
{

	private WebDriver driver;
	TestBase test;
	WebElement element;

	@FindBy(xpath = "//a[@class='ut-icon-action-bar_run']")
	@CacheLookup
	WebElement runButtonElement;

	@FindBy(xpath = "//a[@title='Add FlowService']")
	@CacheLookup
	WebElement addFreshFlowService_PlusIconElement;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public GenericHelper(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickButton(String buttonText) throws Exception 
	{		
		element = findElement("//button[contains(text(),'" + buttonText + "')]",driver);
		click(element,driver,"Clicking on Button.. " + buttonText);
		waitForElementNotVisible(loader, driver, "wait for page load",60);
	}

	public void clickButtonLink(String buttonText) throws Exception 
	{
		element = findElement("//a[contains(text(),'" + buttonText + "')]",driver);
		click(element,driver,"Clicking on Button Link.. " + buttonText);
	}

	public void clickOnDropDown(WebElement element,int i) throws Exception 
	{
		click(element,driver,"Clicking on Drop Down.." + element +" at index");
	}
	
	public void clearInput(WebElement element) throws Exception 
	{
		clearTextBox(element,driver,"Clear InputField");
	}

	public void selectDropDownLink(String linkText) throws Exception {
			element = findElement("//div[contains(text(),'" + linkText + "')]",driver);
			click(element,driver,"selecting value from drop down link  " + linkText);
	}

	public void selectDropDownLink(String linkText, int dropDownIndex) throws Exception {
		element = findElement("(//div[contains(text(),'" + linkText + "')])[" + dropDownIndex + "]",driver);
		click(element,driver,"selecting drop down link  " + linkText + " at dropDownIndex  " + dropDownIndex);
	}

	public void selectDropDownLinkFromField(String linkText, int dropDownIndex) throws Exception {

		List<WebElement> elemntArray = findElements("//div[contains(text(),'" + linkText + "')]",driver);
		WebElement element = elemntArray.get(dropDownIndex);
		click(element,driver,"selecting drop down link  " + linkText + " dropDownIndex  " + dropDownIndex);
	}

	public void clickOnResourceCheckBox(String methodName) throws Exception {

		WebElement element = findElement("//span[contains(text(),'" + methodName + "')]",driver);
		click(element,driver,"clicking on checkbox  " + methodName);
	}

	public void selectoperationinFlowServicepage(String operationName) throws Exception
	{
		
			WebElement ele = findElement("//i[@title='Show Dropdown']",driver);
			click(ele,driver,"clicking on dropdown link.. " + ele);
			WebElement element = findElement("//div[@title='"+operationName+"']",driver);
			click(element,driver,"selecting operation.. " + operationName);
	}
//
//
//	public void EscapeFromFlowservice() {
//		try {
//			if (runButtonElement.isDisplayed()==true){
//				   driver.navigate().back();
//					Assert.assertTrue(addFreshFlowService_PlusIconElement.isDisplayed());}
//            else{
//					NavigationMenu navigationMenu = new NavigationMenu(driver);
//					navigationMenu.clickOnHomePage();}
//
//			}
//			 catch (Exception e) {
//			e.printStackTrace();
//
//
//		}
//
//	}
//
//
//	public String todaysdate(){
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd");
//		SimpleDateFormat sdf1 = new SimpleDateFormat("MMM");
//		String Todadate = sdf.format(date);
//        String currentMonth = sdf1.format(date);
//		return Todadate.concat(currentMonth);
//
//	}

}
