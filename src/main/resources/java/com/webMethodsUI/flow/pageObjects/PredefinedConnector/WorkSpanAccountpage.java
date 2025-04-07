package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkSpanAccountpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(WorkSpanAccountpage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//input[@aid='Client ID']")
    @CacheLookup
    WebElement ClientID;


    @FindBy(xpath = "//input[@aid='Client Secret']")
    @CacheLookup
    WebElement ClientSecret;

    @FindBy(xpath = "//input[@aid='Domain']")
    @CacheLookup
    WebElement Domain;


    @FindBy(xpath = "//h1[contains(text(),'Account')]")
    @CacheLookup
    WebElement AccountPageTitle;

     public WorkSpanAccountpage(WebDriver driver){
         super();
         this.driver = driver;
         PageFactory.initElements(driver, this);

         waitHelper = new WaitHelper(driver);
         waitHelper.waitForElement(AccountPageTitle,15);
         log.info("element is visible now...." + AccountPageTitle);
         logExtentReport("element is visible now.... and element text is  " + AccountPageTitle.getText());

     }


    public void EnteringClientID(String clientID){
        log.info("Entering ClientID.." + clientID);
        logExtentReport("Entering ClientID ... " + clientID);
        ClientID.click();
        ClientID.sendKeys(clientID);

    }

    public void EnteringClientsecret(String clientsecret){
        log.info("Entering clientsecret.." + clientsecret);
        logExtentReport("Entering clientsecret... " + clientsecret);
        ClientSecret.click();
        ClientSecret.sendKeys(clientsecret);

    }


    public void EnteringDomain(String domain){
        log.info("Entering Domain.." + domain);
        logExtentReport("Entering Domain. " + domain);
        Domain.click();
        Domain.sendKeys(domain);

    }

    public ConnectorsHomepage ClickingAddbutton() throws Exception{


        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Add");
        return new ConnectorsHomepage(driver);

    }


}
