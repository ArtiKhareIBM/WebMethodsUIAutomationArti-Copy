package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdobeAccountpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(AdobeAccountpage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//h1[contains(text(),'Add Account')]")
    @CacheLookup
    WebElement AccountPageTitle;

    @FindBy(xpath = "//input[@aid='Organization ID']")
    @CacheLookup
    WebElement OrganizationIDfield;


    @FindBy(xpath = "//input[@aid='Audience']")
    @CacheLookup
     WebElement Adidencefield;


    @FindBy(xpath = "//input[@aid='Technical Account ID']")
    @CacheLookup
    WebElement TechnicalAccountID;

    @FindBy(xpath = "//input[@aid='Client Secret']")
    @CacheLookup
     WebElement ClientSecretefield;

    @FindBy(xpath = "//input[@aid='Client ID']")
    @CacheLookup
    WebElement ClientIDfield;

    @FindBy(xpath = "//span[contains(text(),'Sandbox Name')]/parent::div/div/div")
    @CacheLookup
    WebElement Sandboxnamefield;

    @FindBy(xpath = "//div[@data-eventmap='metadata-OpenLookUpDropdown-JWT Keystore']/span")
    @CacheLookup
    WebElement JWTKeystoredropdown;

    @FindBy(xpath = "//div[@data-eventmap='metadata-OpenLookUpDropdown-JWT Key Alias']/span")
    @CacheLookup
    WebElement JWTKeyAlliasedropdown;




    //  Organization ID , Technical Account ID , Audience ,Client ID,Client Secret




public AdobeAccountpage(WebDriver driver){

    super();
    this.driver = driver;
    PageFactory.initElements(driver, this);

    waitHelper = new WaitHelper(driver);
    waitHelper.waitForElement(AccountPageTitle,15);
    log.info("element is visible now...." + AccountPageTitle);
    logExtentReport("element is visible now.... and element text is  " + AccountPageTitle.getText());
}

    public void SelectingKeystore() throws InterruptedException {
        log.info("Selecting JWTKeystore dropdown.." );
        logExtentReport("Selecting JWTKeystoredrop down" );
        JWTKeystoredropdown.click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        log.info("Selected JWTKeystore dropdown.." );
        logExtentReport("Selected JWTKeystoredrop down" );
        //action.keyDown(Keys.ARROW_DOWN).build().perform();
    }

    public void SelectingJWTalliasedropdown(String Aliase) throws InterruptedException {
        log.info("Selecting JWTKeyAlliase dropdown.." );
        logExtentReport("Selecting JWTKeyAlliase  down" );
        JavascriptExecutor exe = (JavascriptExecutor) driver;

//        log.info("Scrolling down JWTKeyAlliase dropdown......");
//        logExtentReport("Scrolling down JWTKeyAlliase dropdown.........");
//        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Session Timeout (min)')]"));
//        exe.executeScript("arguments[0].scrollIntoView(true);", element);
        JWTKeyAlliasedropdown.click();
        Thread.sleep(5000);
        Actions action = new Actions(driver);
       // action.sendKeys(Keys.ARROW_DOWN).perform();
        System.out.println("One step down");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

    }
    public void EnteringClientID(String clientID){
        log.info("Entering ClientID.." + clientID);
        logExtentReport("Entering ClientID ... " + clientID);
        ClientIDfield.click();
        ClientIDfield.sendKeys(clientID);

    }

    public void EnteringClientsecret(String clientsecret){
        log.info("Entering clientsecret.." + clientsecret);
        logExtentReport("Entering clientsecret... " + clientsecret);
        ClientSecretefield.click();
        ClientSecretefield.sendKeys(clientsecret);

    }


    public void EnteringOrganizationID(String orgID){
        log.info("Entering orgID.." + orgID);
        logExtentReport("Entering orgID... " + orgID);
        OrganizationIDfield.click();
        OrganizationIDfield.sendKeys(orgID);
    }

    public void EnteringtechnicalID(String orgID){
        log.info("Entering technicalID.." + orgID);
        logExtentReport("Entering technicalID.. " + orgID);
        TechnicalAccountID.click();
        TechnicalAccountID.sendKeys(orgID);
    }

   public void EnteringAudience(String orgID){
       log.info("Entering Audience.." + orgID);
       logExtentReport("Entering Audience.. " + orgID);
       Adidencefield.click();
       Adidencefield.sendKeys(orgID);
   }


    public void EnteringSandbox(){
        log.info("Entering Sand box..");
        logExtentReport("Entering Sand box... ");
        Sandboxnamefield.click();
        WebElement element = driver.findElement(By.xpath("//li[contains(text(),'SoftwareAG AE Sandbox ')]"));
        element.click();
    }
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    @CacheLookup
    WebElement Addbutton;

    public void clickAddbutton(){
        log.info("Clicking Add button");
        logExtentReport("Clicking Add button");
        Addbutton.click();
    }


}
