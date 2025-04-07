package com.webMethodsUI.flow.pageObjects.SagCloudPage;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.common.SagCloudLoginPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class SagCloudHomePage {
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(SagCloudHomePage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//h3[contains(text(),'webMethods.io Integration')]")
	@CacheLookup
	WebElement webMethodsTitleElement;
	
	@FindBy(xpath = "//i[@class='dlt-icon-profile']")
	@CacheLookup
	public static WebElement sagCloudProfileIconElement;
	
	@FindBy(xpath = "//a[@id='sci-app-logout']")
	@CacheLookup
	public static WebElement sagcloudLogOutLink;

	
	
	
	

	
	
	public SagCloudHomePage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(webMethodsTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport(
				"element is visible now.... and element text is  " + webMethodsTitleElement.getText());

	}
	
	
	public SagCloudLoginPage logOutFromSagcloudApplication() {
		log.info("Logging out from Sagcloud application....");
		logExtentReport("Logging out from Sagcloud application.... ");
		
		log.info("clicking on profine icon....");
		logExtentReport("clicking on profine icon....");
		
		sagCloudProfileIconElement.click();
		
		log.info("clicking on logout link....");
		logExtentReport("clicking on logout link....");
		
		
		sagcloudLogOutLink.click();
		//LoginPage loginPage = new LoginPage(driver);
		SagCloudLoginPage sagCloudLoginPage = new SagCloudLoginPage(driver);
		return sagCloudLoginPage;
		//return loginPage;
		
		
	}
	
    public String getWebMethodsTitle() {
		
		return webMethodsTitleElement.getText();
	}
	
	
	
}
