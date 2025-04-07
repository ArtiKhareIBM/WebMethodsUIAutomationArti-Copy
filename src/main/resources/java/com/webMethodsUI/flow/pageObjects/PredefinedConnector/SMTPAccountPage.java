package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SMTPAccountPage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(SMTPAccountPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h4[contains(text(),'Account')]")
    @CacheLookup
    WebElement AccountPageTitle;

    @FindBy(xpath = "//input[@name='name']")
    @CacheLookup
    WebElement AccountNameField;

    @FindBy(xpath = "//input[@name='cn_host']")
    @CacheLookup
    WebElement HostNameField;

    @FindBy(xpath = "//input[@name='cn_userName']")
    @CacheLookup
    WebElement Usernamefield;


    @FindBy(xpath = "//input[@name='cn_password']")
    @CacheLookup
    WebElement passwordfield;


    @FindBy(xpath = "//input[@name='cn_port']")
    @CacheLookup
    WebElement portField;

    @FindBy(xpath = "//input[@name='cx_from']")
    @CacheLookup
    WebElement fromfield;

    @FindBy(xpath = "//input[@name='cx_to']")
    @CacheLookup
    WebElement Tofield;




    public SMTPAccountPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(AccountPageTitle,15);
        log.info("element is visible now...." + AccountPageTitle);
        logExtentReport("element is visible now.... and element text is  " + AccountPageTitle.getText());
    }

    public void EnteringAccountName(String AccountName){
        log.info("entering AccountName" + AccountName );
        logExtentReport("entering AccountName" + AccountName);
        AccountNameField.click();
        AccountNameField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        AccountNameField.sendKeys(AccountName);
    }
    public void EnteringHostValue(String HostValue){
        log.info("entering HostValue" + HostValue );
        logExtentReport("entering HostValue" + HostValue);
        HostNameField.click();
        HostNameField.sendKeys(HostValue);

    }

    public void EnteringUsername(String UserName){
        log.info("entering UserName" + UserName );
        logExtentReport("entering UserName" + UserName);
        Usernamefield.click();
        Usernamefield.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        Usernamefield.sendKeys(UserName);
    }

    public void EnteringPassword(String password){
        log.info("entering password" + password );
        logExtentReport("entering password" + password);
        passwordfield.click();
        passwordfield.clear();
        passwordfield.sendKeys(password);
    }

    public void Enteringportvalue(String portValue){
        log.info("entering password" + portValue );
        logExtentReport("entering password" + portValue);
        portField.click();
        portField.clear();
        portField.sendKeys(portValue);

    }

    public void EnteringFromfield(String Fromfield){
        log.info("entering Fromfield" + Fromfield );
        logExtentReport("entering Fromfield" + Fromfield);
        fromfield.click();
        fromfield.sendKeys(Fromfield);
    }

    public void Enteringtofield(String tofield){
        log.info("entering Tofield" + tofield );
        logExtentReport("entering Tofield" + tofield);
        Tofield.click();
        Tofield.clear();
        Tofield.sendKeys(tofield);

    }
}
