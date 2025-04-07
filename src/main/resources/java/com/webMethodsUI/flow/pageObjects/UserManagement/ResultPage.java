package com.webMethodsUI.flow.pageObjects.UserManagement;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class ResultPage {
	WebDriver driver;
    private Logger log = LogManager.getLogger(ResultPage.class);
    WaitHelper waitHelper;
    
    @FindBy(xpath = "//div[contains(text(),'responseBody')]//ancestor::div[@class='tree-context']/preceding-sibling::div[@class='tree-icon-container']/span/i")
    @CacheLookup
    WebElement responseBodyExpansionElement;
    
    @FindBy(xpath = "//div[contains(text(),'Details')]")
    @CacheLookup
    WebElement detailsTextElement;
    
    @FindBy(xpath = "//div[contains(text(),'output')]//ancestor::div[@class='tree-context']/preceding-sibling::div[@class='tree-icon-container']/span/i")
    @CacheLookup
    WebElement outputExpansionElement;
    
    @FindBy(xpath = "//div[contains(text(),'integration')]//ancestor::div[@class='tree-context']/preceding-sibling::div[@class='tree-icon-container']/span/i")
    @CacheLookup
    WebElement integrationExpansionElement;
    
    @FindBy(xpath = "//div[contains(text(),'message')]//ancestor::div[@class='tree-context']/preceding-sibling::div[@class='tree-icon-container']/span/i")
    @CacheLookup
    WebElement messageExpansionElement;
    
    @FindBy(xpath = "//div[contains(text(),'Access is denied')]")
    @CacheLookup
    WebElement accessDeniedTextElement;
    
    
    
    
    
    
    
    
    public ResultPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(detailsTextElement,15);
        log.info("element is visible now...." + detailsTextElement);
        logExtentReport("element is visible now.... and element text is  " + detailsTextElement.getText());

    }
    public void clickExpandResponseBody()
	{
		log.info("Clicking on plus icon... ");
		logExtentReport("Clicking on Plus Icon... ");
		responseBodyExpansionElement.click();
	    
	}
    
    public void clickOutputExpand()
	{
		log.info("Clicking on plus icon... ");
		logExtentReport("Clicking on Plus Icon... ");
		outputExpansionElement.click();
	    
	}
    public void clickIntegrationExpand()
	{
		log.info("Clicking on plus icon... ");
		logExtentReport("Clicking on Plus Icon... ");
		integrationExpansionElement.click();
	    
	}
    
    public void clickMessageExpand()
	{
		log.info("Clicking on plus icon... ");
		logExtentReport("Clicking on Plus Icon... ");
		messageExpansionElement.click();
	    
	}
    
    public boolean getAccessDeniedMessage(){
		log.info("Getting access denied Message...");
		logExtentReport("Getting access denied Message...");
		return accessDeniedTextElement.isDisplayed();
	}
    
    


}
