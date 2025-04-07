package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
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

public class AccountPage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(AccountPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h1[contains(text(),'Account')]")
    @CacheLookup
    WebElement AccountPageTitle;

    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down ']")
    @CacheLookup
    WebElement Authorizationfield;

    @FindBy(xpath = "//input[@aid='Account Name']")
    @CacheLookup
    WebElement AccountNamefield;

    @FindBy(xpath = "//input[@name='Username']")
    @CacheLookup
    WebElement UserNamefield;

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



    @FindBy(xpath = "//div[@class='modal-header']")
    @CacheLookup
    WebElement AccountHeading;

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

    public void selectAuthrizationType(String authType) {

        try {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(Authorizationfield,0);
            genericHelper.selectDropDownLink(authType);
            log.info("Clicked on auth type....");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void SelectingDropdown(int index,String AccountName) throws Exception{
        log.info("Clicking Add account icon");
        logExtentReport("Clicking Add account icon");
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
        WebElement element = list.get(index);
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

    public void ClickingNextbutton(){
        try {
            WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
            WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait() );
            wait.until(ExpectedConditions.elementToBeClickable(element));
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Next");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ConnectorsHomepage ClickingAddbutton() throws Exception{


            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Add");
            return new ConnectorsHomepage(driver);

    }

    public ConnectorsHomepage ClickingSavebutton() throws Exception{


        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Save");
        return new ConnectorsHomepage(driver);

    }


    public void enteringAccountName(String AccountName){
        log.info("Entering passWord.." + AccountName);
        logExtentReport("Entering passWord ... " + AccountName);
        AccountNamefield.click();
        AccountNamefield.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        AccountNamefield.sendKeys(AccountName);
    }

    public void enteringAccountNameACFlow(String AccountName){
        log.info("Entering passWord.." + AccountName);
        logExtentReport("Entering passWord ... " + AccountName);
        WebElement accountfield = driver.findElement(By.xpath("//input[@aid='Account Name']"));
        accountfield.click();
        accountfield.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        accountfield.sendKeys(AccountName);
    }

    public void EnteringUserName(String Username){
        log.info("Entering UserName.." + Username);
        logExtentReport("Entering Username ... " + Username);
        UserNamefield.click();
        UserNamefield.clear();
        UserNamefield.sendKeys(Username);
    }

    public void enteringPassword(String password){
        log.info("Entering passWord.." + password);
        logExtentReport("Entering passWord ... " + password);
        PassWordfield.click();
        PassWordfield.sendKeys(password);
    }

    public void enteringServerURL(String ServerUrl){
        log.info("Entering ServerURL.." + ServerUrl);
        logExtentReport("Entering ServerURL ... " + ServerUrl);
        Serverurlfield.click();
        Serverurlfield.clear();
        Serverurlfield.sendKeys(ServerUrl);

    }
    public void EnteringIssuerfield(String Issuer){
        log.info("Entering ServerURL.." + Issuer);
        logExtentReport("Entering ServerURL ... " + Issuer);
        issuerfield.click();
        issuerfield.sendKeys(Issuer);

    }



    public void EnteringSubjectfield(String Subject){
        log.info("Entering ServerURL.." +  Subject);
        logExtentReport("Entering ServerURL ... " +  Subject);
        SubjectFieldfield.click();
        SubjectFieldfield.sendKeys(Subject);

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
        action.sendKeys(Keys.ARROW_DOWN).perform();
        System.out.println("One step down");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

    }

    public void SelectingOathType(int index,String Oathtype){
        try {
            log.info(" clicking oathtype...");

//            List<WebElement> elemntArray = driver
//                    .findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
//            log.info("All input parameters are....." + elemntArray);
            WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]"));
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element,0);
            genericHelper.selectDropDownLink(Oathtype);
            log.info("Clicked on OAuthtype type....");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
