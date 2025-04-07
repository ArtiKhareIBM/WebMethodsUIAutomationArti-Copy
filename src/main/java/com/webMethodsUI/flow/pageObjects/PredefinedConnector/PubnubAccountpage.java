package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Scanner;

public class PubnubAccountpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(PubnubAccountpage.class);


    @FindBy(xpath = "//input[@aid='Publish Key']")
    @CacheLookup
    WebElement Publishkey;


    @FindBy(xpath = "//input[@aid='Subscribe Key']")
    @CacheLookup
    WebElement SubscribeKey;

    @FindBy(xpath = "//h1[contains(text(),'Add Account')]")
    @CacheLookup
    WebElement AccountPageTitle;


    @FindBy(xpath = "//button[contains(text(),'Add')]")
    @CacheLookup
    WebElement Addbutton;

    public PubnubAccountpage(WebDriver driver){

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        log.info("PubNUB Page object is created");
        logExtentReport("PubNUB Page object is created");

    }


    public void EnteringPublishkey(String publishkey) throws Exception{

        enterValue(Publishkey, publishkey, driver, "Entering publishkey ... " + publishkey);
    }


    public void EnteringSubscribe(String Subscribe) throws Exception
    {
        
        enterValue(SubscribeKey, Subscribe, driver, "Entering Subscribe.." + Subscribe);

    }
    
    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;
    
    
    public String loader = "//div[contains(@class,'circle-clipper left')]/div[@class='circle']";

    public void clickAddbutton() throws Exception
    {
        click(Addbutton, driver, "Clicking Add button");
        elementContainsText(SuccessMessage,"Account saved successfully.", driver, "Wait for Account created successfully mesage to visible");
        waitForElementNotVisible(loader, driver, "wait for page load");
    }

}
