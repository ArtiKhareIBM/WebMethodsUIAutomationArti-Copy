package com.webMethodsUI.flow.pageObjects.common;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.SagCloudPage.SagCloudHomePage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class SagCloudLoginPage extends CommonActions{
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(SagCloudLoginPage.class);

	WaitHelper waitHelper;
	
	@FindBy(xpath = "//button[@id = 'sci-app-login']")
	@CacheLookup
	WebElement firstLoginButton;
	
	
	@FindBy(xpath = "//a[@title = 'Resources']")
	@CacheLookup
	WebElement resourcesTitle;
	
	

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
	
	
	@FindBy(xpath = "//div[@class='log-account log-in-to-your-account']")
	@CacheLookup
	WebElement loginToYouAccountElement;

	public SagCloudLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		// All webelements defined in this page are initialized with below line at
		// runtime
		PageFactory.initElements(driver, this);
		// Whenever any test calls loginPage ensure login page is loaded
		waitHelper = new WaitHelper(driver);
		// ensure login page loaded or not based on any UI element . here it is
		// 'userName'
		// Systax waitHelper.waitForElement(element, timeOutInSeconds,
		// pollingEveryMiliSec)
		waitHelper.waitForElement(resourcesTitle, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("resourceTitle Object created");
		// new TestBase().getNavigationScreen(driver);
	}

	
	 public String getLoginTitle() {
			
			return firstLoginButton.getText();
		}
	 
	 
	 public void clickingOnSagcloudLoginButton() {

			waitHelper = new WaitHelper(driver);
			waitHelper.waitForElement(firstLoginButton, ObjectReader.reader.getExplicitWait());
			log.info("Login button is visible");
			logExtentReport("Login button is visible");
			firstLoginButton.click();
			log.info("Clicked on Login button...");
			logExtentReport("Login button is clicked");

		}
		
	public void enterUserName(String userNametxt) {
		userName.click();
		userName.clear();
		log.info("Entering user Name:  " +userName);
		//logExtentReport("enter userName");
		logExtentReport("Entering user Name: " +userNametxt);
		this.userName.sendKeys(userNametxt);
		

	}
	
	
	public void enterPassword(String password)
	{
		log.info("Entering password " +password);
		logExtentReport("Entering password " +password);
		
		this.password.sendKeys(password);
	}
	
	
	public SagCloudHomePage loginToTheApplication(String userName, String password)
	{
		
		
		enterUserName(userName);
		enterPassword(password);
		
		
		clickOnLoginButton();
		return new SagCloudHomePage(driver);
		
	}
	
	
	public HomePage clickOnFirstLoginButton() throws Exception
	{
		log.info("Clicking on Login button....");
		//logExtentReport("Clicked on Login Button");
		logExtentReport("Clicked on Login Button");
		firstLoginButton.click();
		return new HomePage(driver);
		
	}
	
	
	public SagCloudHomePage clickOnLoginButton()
	{
		log.info("Clicking on Login button....");
		//logExtentReport("Clicked on Login Button");
		logExtentReport("Clicked on Login Button");
		loginButton.click();
		return new SagCloudHomePage(driver);
		
	}
	
	
	public String getLoginPageText() {
		
		log.info("Get Login page Text and text is `	....." +loginToYouAccountElement.getText());
		
		logExtentReport("Get Login page Text and text is `	....." +loginToYouAccountElement.getText());
		return loginToYouAccountElement.getText();
		
	}
	
	
	
	
	/*
	 * public void logExtentReport(String logInfo) {
	 * TestBase.test.log(Status.INFO,logInfo); }
	 */ 
	

}


