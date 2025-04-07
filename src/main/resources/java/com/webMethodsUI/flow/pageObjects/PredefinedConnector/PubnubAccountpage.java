package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Scanner;

public class PubnubAccountpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(PubnubAccountpage.class);
    WaitHelper waitHelper;


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

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(AccountPageTitle,15);
        log.info("element is visible now...." + AccountPageTitle);
        logExtentReport("element is visible now.... and element text is  " + AccountPageTitle.getText());

    }


    public void EnteringPublishkey(String publishkey){
        log.info("Entering publishkey.." + publishkey);
        logExtentReport("Entering publishkey ... " + publishkey);
        Publishkey.click();
        Publishkey.sendKeys(publishkey);

    }


    public void EnteringSubscribe(String Subscribe){
        log.info("Entering Subscribe.." + Subscribe);
        logExtentReport("Entering Subscribe ... " +Subscribe);
        SubscribeKey.click();
        SubscribeKey.sendKeys(Subscribe);

    }

    public void clickAddbutton(){
        log.info("Clicking Add button");
        logExtentReport("Clicking Add button");
        Addbutton.click();
    }



}
