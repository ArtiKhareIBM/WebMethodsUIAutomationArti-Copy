package com.webMethodsUI.flow.mycloud.PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.webMethodsUI.flow.pageObjects.RecipesPage.choosingProjectpage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class MycloudPage extends CommonActions
{
	 WebDriver driver;
	    private Logger log = LogManager.getLogger(choosingProjectpage.class);

	    @FindBy(xpath = "//img[@class = 'img-responsive'][@alt='Software AG Cloud']")
	    @CacheLookup
	    WebElement sagcloudImage;
	    
		public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	    public MycloudPage(WebDriver driver)
	    {
	        super();
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	        log.info("Mycloud page object created");
	        logExtentReport("Mycloud page object created");
	    }
	    
	    public void verifySagcloudImage() throws Exception
	    {
	    	waitForElementVisible(sagcloudImage, driver, "Verify sagcloud image is visible");
	    }
	    
	    public void verifySubscribedProducts(String appName) throws Exception
	    {
	    	WebElement ele = findElement("//h3[text() = '"+appName+"']", driver);
	    	waitForElementVisible(ele, driver, "Verify subscribed product is visible.."+appName);
	    }

}
