package com.webMethodsUI.flow.appSwitcher.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.pageObjects.RecipesPage.choosingProjectpage;
import com.webMethodsUI.flow.testbase.CommonActions;

public class apps extends CommonActions
{
	 WebDriver driver;
//	    private Logger log = LogManager.getLogger(choosingProjectpage.class);
	    private static final Logger log = LogManager.getLogger(choosingProjectpage.class);

	    @FindBy(xpath = "//span[@class = 'app-name']")
	    @CacheLookup
	    List<WebElement> appNames;
	    
		public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	    public apps(WebDriver driver)
	    {
	        super();
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        log.info("AppSwitcher page object created");
	        logExtentReport("AppSwitcher page object created");
	    }
	    
	    public void verifyApps(String appName,int index) throws Exception
	    {
	    	WebElement element = findElement("//span[@class = 'app-name'][text()='"+appName+"']",driver);
	    	waitForElementVisible(element, driver, "Verify app name is visible.."+appName);
	    }

	    public void goToMycloud(String appName,int index) throws Exception
	    {
	     	WebElement element = findElement("//span[@class = 'app-name'][text()='"+appName+"']",driver);
	    	click(element, driver, "Click on app name.."+appName);
	    	waitForElementNotVisible(loader, driver, "wait for page load");
	    }

}
