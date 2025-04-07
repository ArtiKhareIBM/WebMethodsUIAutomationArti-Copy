package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.testbase.CommonActions;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PusherConnectorAccountPage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(PubnubAccountpage.class);


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
    
    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;

    public PusherConnectorAccountPage(WebDriver driver){

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("Pusher Connector Page Object created");
        logExtentReport("Pusher Connector Page Object created");

    }


    public void EnteringAppIDField(String publishkey) throws Exception{

        enterValue(AppIDField, publishkey, driver, "Entering AppIDField ... " + publishkey);
    }


    public void EnteringAppKeyField(String Subscribe) throws Exception{
        enterValue(AppKeyField, Subscribe, driver, "Entering AppKeyField ... " +Subscribe);
    }


    public void EnteringAppSecreteField(String Subscribe) throws Exception{
        enterValue(AppSecreateField, Subscribe, driver, "Entering AppSecreteField ... " +Subscribe);
    }

    public void EnteringAppClusterField(String Subscribe) throws Exception{
        enterValue(AppClusterField, Subscribe, driver, "Entering AppClusterField ... " +Subscribe);
    }

    public String loader = "//div[contains(@class,'circle-clipper left')]/div[@class='circle']";
    
    public void clickAddbutton() throws Exception
    {
        click(Addbutton, driver, "Clicking Add button");
        elementContainsText(SuccessMessage,"Account saved successfully.", driver, "Wait for Account created successfully mesage to visible");
        waitForElementNotVisible(loader, driver, "wait for page load");
    }

}
