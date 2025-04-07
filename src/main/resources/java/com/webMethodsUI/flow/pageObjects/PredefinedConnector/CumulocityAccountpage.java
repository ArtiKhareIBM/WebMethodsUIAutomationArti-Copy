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

public class CumulocityAccountpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(CumulocityAccountpage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h1[contains(text(),'Add Account')]")
    @CacheLookup
    WebElement HomePageGrconnectorPageTitle;


    @FindBy(xpath = "//input[@aid='Account Name']")
    @CacheLookup
    WebElement AccountNamefield;


    @FindBy(xpath = "//input[@aid='Server URL']")
    @CacheLookup
    WebElement ServerURLField;

    @FindBy(xpath = "//input[@aid='Password']")
    @CacheLookup
    WebElement Passwordfield;

    @FindBy(xpath = "//input[@aid='Username']")
    @CacheLookup
    WebElement UserNamefield;


    @FindBy(xpath = "//button[contains(text(),'Add')]")
    @CacheLookup
    WebElement Addbutton;

    public CumulocityAccountpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(HomePageGrconnectorPageTitle,15);
        log.info("element is visible now...." + HomePageGrconnectorPageTitle);
        logExtentReport("element is visible now.... and element text is  " + HomePageGrconnectorPageTitle.getText());

    }
    public void EnteringAccountName(String AccountName){
        log.info("entering AccountName" + AccountName );
        logExtentReport("entering AccountName" + AccountName);
        AccountNamefield.click();
        AccountNamefield.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        AccountNamefield.sendKeys(AccountName);
    }
    public void EnteringUsername(String UserName){
        log.info("entering UserName" + UserName );
        logExtentReport("entering UserName" + UserName);
        UserNamefield.click();
        UserNamefield.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        UserNamefield.sendKeys(UserName);
    }

    public void EnteringPassword(String password){
        log.info("entering password" + password );
        logExtentReport("entering password" + password);
        Passwordfield.click();
        Passwordfield.clear();
        Passwordfield.sendKeys(password);
    }

    public void EnteringURL(){
        log.info("entering ServerURL");
        logExtentReport("entering ServerURL" );
        ServerURLField.click();
        ServerURLField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        ServerURLField.sendKeys("https://www.cumulocity.com");
    }

    public void EnteringURLwithuffix(){
        log.info("entering ServerURL");
        logExtentReport("entering ServerURL" );
        ServerURLField.click();
        ServerURLField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        ServerURLField.sendKeys("https://duerr_kmat.cumulocity.com");
    }


    public void clickAddbutton(){
        log.info("Clicking Add button");
        logExtentReport("Clicking Add button");
        Addbutton.click();
    }

}
