package com.webMethodsUI.flow.pageObjects.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.aventstack.extentreports.Status;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.TestBase;

public class LoginPage extends CommonActions {

	private WebDriver driver;

	@FindBy(xpath = "//*[@id='username']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//*[@id='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//*[@id='kc-login']")
	@CacheLookup
	WebElement loginButton;

	@FindBy(xpath = "//*[@id='kc-forgot-password']")
	@CacheLookup
	WebElement forgotPassword;
	
	@FindBy(xpath = "//div[contains(@class,'log-account log-in-to-your-account')]")
	@CacheLookup
	WebElement loginToYouAccountElement;
	
	String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public LoginPage(WebDriver driver) throws Exception {
		super(); 
		this.driver = driver;
		
		// All webelements defined in this page are initialized with below line at runtime
		PageFactory.initElements(driver, this);
		logExtentReport("Loginpage  Object created");
		// ensure login page loaded or not based on any UI element . here it is 'userName'	
		waitForElementVisible(userName,this.driver,"Verify username text field is visible");
	}

	public void enterUserName(String userNametxt) throws Exception 
	{
		enterValue(userName,userNametxt,driver,"Entering user Name: " +userNametxt);
		
	}
	
	public void enterPassword(String passwordValue) throws Exception
	{
		enterValue(password,passwordValue,driver,"Entering Password: " +passwordValue);
	}
	
	public void clickOnLoginButton() throws Exception
	{
		Thread.sleep(2000);
		click(loginButton,driver,"Click on Login Button");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	
	
	public HomePage loginToApplication(String userName, String password) throws Exception
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
		return new HomePage(driver);
		
	}
	
	public String getLoginPageText() {		
		logExtentReport("Get Login page Text and text is `	....." +loginToYouAccountElement.getText());
		return loginToYouAccountElement.getText();	
	}
	
	public HomePage Enterthrow2nduserurl() throws Exception{
		try {
			WebElement element = driver.findElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/span[1]"));
			click(element, driver, "Clicking on login with environment link..");
			return new HomePage(driver);
		}
		catch (Exception e){
			enterUserName(ObjectReader.reader.getUserName());
			enterPassword(ObjectReader.reader.getPassword());
			loginButton.click();
			return new HomePage(driver);
		}
	}
	
	
	/*
	 * public void logExtentReport(String logInfo) {
	 * TestBase.test.log(Status.INFO,logInfo); }
	 */ 
	

}
