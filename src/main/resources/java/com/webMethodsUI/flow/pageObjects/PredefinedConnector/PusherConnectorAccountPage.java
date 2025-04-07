package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PusherConnectorAccountPage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(PubnubAccountpage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//input[@aid='App ID']")
    @CacheLookup
    WebElement AppIDField;


    @FindBy(xpath = "//input[@aid='App Key']")
    @CacheLookup
    WebElement AppKeyField;

    @FindBy(xpath = "//input[@aid='App Secret']")
    @CacheLookup
    WebElement AppSecreateField;

    @FindBy(xpath = "//input[@aid='App Cluster']")
    @CacheLookup
    WebElement AppClusterField;

    @FindBy(xpath = "//h1[contains(text(),'Add Account')]")
    @CacheLookup
    WebElement AccountPageTitle;


    @FindBy(xpath = "//button[contains(text(),'Add')]")
    @CacheLookup
    WebElement Addbutton;

    public PusherConnectorAccountPage(WebDriver driver){

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(AccountPageTitle,15);
        log.info("element is visible now...." + AccountPageTitle);
        logExtentReport("element is visible now.... and element text is  " + AccountPageTitle.getText());

    }


    public void EnteringAppIDField(String publishkey){
        log.info("Entering AppIDField.." + publishkey);
        logExtentReport("Entering AppIDField ... " + publishkey);
        AppIDField.click();
        AppIDField.sendKeys(publishkey);

    }


    public void EnteringAppKeyField(String Subscribe){
        log.info("Entering AppKeyField." + Subscribe);
        logExtentReport("Entering AppKeyField ... " +Subscribe);
        AppKeyField.click();
        AppKeyField.sendKeys(Subscribe);

    }


    public void EnteringAppSecreteField(String Subscribe){
        log.info("Entering AppSecreteField." + Subscribe);
        logExtentReport("Entering AppSecreteField ... " +Subscribe);
        AppSecreateField.click();
        AppSecreateField.sendKeys(Subscribe);

    }


    public void EnteringAppClusterField(String Subscribe){
        log.info("Entering AppClusterField." + Subscribe);
        logExtentReport("Entering AppClusterField ... " +Subscribe);
        AppClusterField.click();
        AppClusterField.sendKeys(Subscribe);

    }

    public void clickAddbutton(){
        log.info("Clicking Add button");
        logExtentReport("Clicking Add button");
        Addbutton.click();
    }



}
