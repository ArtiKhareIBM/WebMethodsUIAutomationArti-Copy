package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountPage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(AccountPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h1[contains(text(),'Account')]")
    @CacheLookup
    WebElement AccountPageTitle;
    
    @FindBy(xpath = "//h4[contains(text(),'Account')]")
    @CacheLookup
    WebElement SFTPAccountPageTitle;

    @FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Authorization Type']")
    @CacheLookup
    WebElement Authorizationfield;

    @FindBy(xpath = "//input[@aid='Account Name']")
    @CacheLookup
    WebElement AccountNamefield;

    @FindBy(xpath = "//input[@name='Username']")
    @CacheLookup
    WebElement UserNamefield;
    
    @FindBy(xpath = "//input[@name='User Name']")
    @CacheLookup
    WebElement CCUserNamefield;

    @FindBy(xpath = "//input[@name='Password']")
    @CacheLookup
    WebElement PassWordfield;

    @FindBy(xpath = "//input[@aid='Server URL']")
    @CacheLookup
    WebElement Serverurlfield;

    @FindBy(xpath = "//input[@aid='Issuer']")
    @CacheLookup
    WebElement issuerfield;

    @FindBy(xpath = "//input[@aid='Subject']")
    @CacheLookup
    WebElement SubjectFieldfield;

    @FindBy(xpath = "//div[@data-eventmap='metadata-OpenLookUpDropdown-JWT Keystore']/span")
    @CacheLookup
    WebElement JWTKeystoredropdown;

    @FindBy(xpath = "//div[@data-eventmap='metadata-OpenLookUpDropdown-JWT Key Alias']/span")
    @CacheLookup
    WebElement JWTKeyAlliasedropdown;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]")
    @CacheLookup
    WebElement OAuthdropdown;

    @FindBy(xpath = "//input[@aid='Client ID']")
    @CacheLookup
    WebElement ClientID;

    @FindBy(xpath = "//input[@aid='Client Secret']")
    @CacheLookup
    WebElement ClientSecret;

    @FindBy(xpath = "//input[@aid='Access Token']")
    @CacheLookup
    WebElement AccessToken;

    @FindBy(xpath = "//input[@aid='Refresh Token']")
    @CacheLookup
    WebElement RefreshToken;

    @FindBy(xpath = "//input[@aid='Refresh Url']")
    @CacheLookup
    WebElement RefreshURL;

    @FindBy(xpath = "//input[@aid='Grant Type']")
    @CacheLookup
    WebElement GrantType;

    @FindBy(xpath = "//input[@aid='Server Url']")
    @CacheLookup
    WebElement ServerURL;

    @FindBy(xpath = "//input[@aid='Instance Url']")
    @CacheLookup
    WebElement InstanceURL;
    
    @FindBy(xpath = "//div[contains(@class,'singleValue')][text()='basic']")
    @CacheLookup
    WebElement basicAuthSelected;

    @FindBy(xpath = "//div[@class='modal-header']")
    @CacheLookup
    WebElement AccountHeading;
    
    String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

    //span[@title='JWT Keystore']/ancestor::div[@id='lookup-container']/span[2]/span
    //div[@data-eventmap='metadata-OpenLookUpDropdown-JWT Keystore']/span


    public AccountPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(AccountPageTitle, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now...." + AccountPageTitle);
        logExtentReport("element is visible now.... and element text is  " + AccountPageTitle.getText());

    }

    public void selectAuthrizationType(String authType) throws Exception {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(Authorizationfield,0);
            genericHelper.selectDropDownLink(authType);

    }
    
    public void SelectingDropdown(int index,String AccountName) throws Exception{
        log.info("Clicking Add account icon");
        logExtentReport("Clicking Add account icon");
        //List<WebElement> list = driver.findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
//        List<WebElement> list = driver.findElements(By.xpath("//div[@class='material-custom-select clearfix']/div/div/div[2]/div/span"));
//        WebElement element = list.get(index);
        WebElement element = driver.findElement(By.xpath("//div[@class='material-custom-select clearfix']/div/div/div[2]/div/span"));
        element.click();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink(AccountName);

    }


    public void SelectingAuthtype(String authType) throws Exception {
        log.info("Clicking Auth type");
        logExtentReport("Clicking Auth type");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//input[@class='inputElement  filled required-field']"));
        js.executeScript("arguments[0].click();", element);
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink(authType);


    }

    public void ClickingNextbutton() throws Exception{
            WebElement element = findElement("//button[contains(text(),'Next')]",driver);
            click(element, driver, "Click on Next Button");
    }

    public ConnectorsHomepage ClickingAddbutton() throws Exception
    {
    	WebElement element = findElement("//button[contains(text(),'Add')]",driver);
        click(element, driver, "Click on add button");
        return new ConnectorsHomepage(driver);
    }

    public ConnectorsHomepage ClickingSavebutton() throws Exception
    {
    	WebElement element = findElement("//button[contains(text(),'Save')]",driver);
        click(element, driver, "Click on add button");
        return new ConnectorsHomepage(driver);
    }


    public void enteringAccountName(String AccountName) throws Exception
    {
//        log.info("Entering passWord.." + AccountName);
//        logExtentReport("Entering passWord ... " + AccountName);
//        AccountNamefield.click();
//        AccountNamefield.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        AccountNamefield.sendKeys(AccountName);
        
        clearAndEnterText(AccountNamefield, AccountName, driver, "Entering passWord.." + AccountName);
        Thread.sleep(2000);
        waitForElementNotVisible(loader, driver, "wait for page load");
    }

    public void enteringAccountNameACFlow(String AccountName) throws Exception{
//        log.info("Entering passWord.." + AccountName);
//        logExtentReport("Entering passWord ... " + AccountName);
        WebElement accountfield = findElement("//input[@aid='Account Name']",driver);
        accountfield.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//        accountfield.sendKeys(AccountName);
      
        clearAndEnterText(accountfield, AccountName, driver, "Entering account Name.."+AccountName);
    }

    public void EnteringUserName(String Username) throws Exception{

        clearAndEnterText(UserNamefield, Username, driver, "Entering User Name.."+Username);
    }
    
    public void EnteringCCUserName(String Username) throws Exception
    {
        clearAndEnterText(CCUserNamefield, Username, driver, "Entering CC User Name.."+Username);
    }

    public void enteringPassword(String password) throws Exception{
        enterValue(PassWordfield, password, driver, "Entering passWord ... " + password);
    }

    public void enteringServerURL(String ServerUrl) throws Exception{
        
        clearAndEnterText(Serverurlfield, ServerUrl, driver, "Entering ServerURL ... " + ServerUrl);

    }
    
    public void EnteringIssuerfield(String Issuer) throws Exception
    {
        enterValue(issuerfield, Issuer, driver, "Entering ServerURL ... " + Issuer);
    }

    public void EnteringSubjectfield(String Subject) throws Exception
    {
        enterValue(SubjectFieldfield, Subject, driver, "Entering ServerURL ... " +  Subject);

    }
    
    public void SelectingKeystore(String keystoreName) throws Exception
    {
        click(JWTKeystoredropdown, driver, "Clicking on JWTKeystore dropdown..");
         findElement("//span[contains(text(),'"+keystoreName+"')]",driver);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        log.info("Selected JWTKeystore dropdown.." );
        logExtentReport("Selected JWTKeystoredrop down" );
        }

    public void SelectingJWTalliasedropdown(String Aliase) throws Exception 
    {
        log.info("Selecting JWTKeyAlliase dropdown.." );
        logExtentReport("Selecting JWTKeyAlliase  down" );
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        JWTKeyAlliasedropdown.click();
        findElement("//span[contains(text(),'"+Aliase+"')]",driver);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        System.out.println("One step down");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
      }

    public void SelectingOathType(int index,String Oathtype) throws Exception{

            log.info(" clicking oathtype dropdown...");
            WebElement element = findElement("//div[contains(@class,'placeholder')][text()='Select OAuth Type']",driver);
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element,0);
            genericHelper.selectDropDownLink(Oathtype);
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

    public void EnteringAccessToken(String Accesstoken){
        log.info("Entering Accesstoken.." + Accesstoken);
        logExtentReport("Entering Accesstoken... " + Accesstoken);
        AccessToken.click();
        AccessToken.sendKeys(Accesstoken);

    }

    public void EnteringRefreshToken(String refreshtoken){
        log.info("Entering refreshtoken.." + refreshtoken);
        logExtentReport("Entering refreshtoken... " + refreshtoken);
        RefreshToken.click();
        RefreshToken.sendKeys(refreshtoken);

    }

    public void EnteringRefreshURL(String refreshurl){
        log.info("Entering refreshurl.." + refreshurl);
        logExtentReport("Entering refreshurl... " + refreshurl);
        RefreshURL.click();
        RefreshURL.sendKeys(refreshurl);

    }

    public void EnteringGrantType(String grantType){
        log.info("Entering grantType.." + grantType);
        logExtentReport("Entering grantType... " + grantType);
        GrantType.click();
        GrantType.sendKeys(grantType);

    }

    public void EnteringserverURL(String serverURL) throws InterruptedException {
        ServerURL.click();
        ServerURL.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        Thread.sleep(3000);
        ServerURL.clear();
        log.info("cleared serverURL..");
        logExtentReport("cleared... " );
        ServerURL.sendKeys(serverURL);
        log.info("Entered serverURL.." + serverURL);
        logExtentReport("Entered serverURL... " + serverURL);

    }


    public void EnteringinstanceURL(String instanceURL ){
        log.info("Entering instanceURL.." + instanceURL);
        logExtentReport("Entering instanceURL... " + instanceURL);
        InstanceURL.click();
        InstanceURL.clear();
        InstanceURL.sendKeys(instanceURL);

    }


















}
