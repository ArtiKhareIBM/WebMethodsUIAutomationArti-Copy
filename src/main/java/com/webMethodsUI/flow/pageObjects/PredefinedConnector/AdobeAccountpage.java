package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdobeAccountpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(AdobeAccountpage.class);
  
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

    log.info("Adobe Account page object created");
    logExtentReport("Adobe Account page object created");
}

    public void SelectingKeystore() throws Exception {

        click(JWTKeystoredropdown, driver, "Click on JWTKeystoredropdown");
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        log.info("Selected JWTKeystore from dropdown.." );
        logExtentReport("Selected JWTKeystore from drop down" );
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
    public void EnteringClientID(String clientID) throws Exception{
        enterValue(ClientIDfield, clientID, driver, "Entering ClientID ... " + clientID);
    }

    public void EnteringClientsecret(String clientsecret) throws Exception{
        enterValue(ClientSecretefield, clientsecret, driver, "Entering clientsecret.." + clientsecret);
    }

    public void EnteringOrganizationID(String orgID) throws Exception {
    	enterValue(OrganizationIDfield, orgID, driver, "Entering orgID... " + orgID);
    }

    public void EnteringtechnicalID(String orgID) throws Exception{
        enterValue(TechnicalAccountID, orgID, driver, "Entering technicalID.. " + orgID);   
    }

   public void EnteringAudience(String orgID) throws Exception
   {
       enterValue(Adidencefield, orgID, driver, "Entering Audience.." + orgID);   
   }

    public void EnteringSandbox() throws Exception
    {
        click(Sandboxnamefield, driver, "Entering Sand box..");
        WebElement element = findElement("//li[contains(text(),'SoftwareAG AE Sandbox ')]",driver);
        click(element, driver, fileSeperator);
    }
    
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    @CacheLookup
    WebElement Addbutton;
    
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
