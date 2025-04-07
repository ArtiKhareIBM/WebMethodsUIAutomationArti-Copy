package com.webMethodsUI.flow.pageObjects.onpremIS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.testbase.CommonActions;

public class OnpremeISLoginPage extends CommonActions
{
	private WebDriver driver;
	
	String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public OnpremeISLoginPage(WebDriver driver) throws Exception {
		super(); 
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebElement ele = findElement("//div/img[@alt='webMethods Integration Server']", driver);
		waitForElementVisible(ele, driver, "Verify webmethids Integration server is visible");
	}

	public void enterUserName(String userNametxt) throws Exception 
	{
		WebElement userName = findElementByID("isac_usernameElementRef", driver);
		enterValue(userName,userNametxt,driver,"Entering user Name: " +userNametxt);
	} 
	
	public void enterPassword(String passwordValue) throws Exception
	{
		WebElement passWord = findElementByID("isac_passwordFieldRef", driver);
		enterValue(passWord,passwordValue,driver,"Entering Password : " +passwordValue);
	}
 
	public void clickOnLoginButton() throws Exception
	{
		WebElement loginButton = findElement("//button[text()='Log in']", driver);
		click(loginButton,driver,"Click on Login Button");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	
	
	public void loginToApplication(String userName, String password) throws Exception
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
//		return new Dashboard(driver);
		
	}
	


}
