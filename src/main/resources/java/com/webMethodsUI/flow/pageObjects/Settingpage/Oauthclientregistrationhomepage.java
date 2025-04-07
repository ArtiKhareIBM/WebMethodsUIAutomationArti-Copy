package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Oauthclientregistrationhomepage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(Oauthclientregistrationhomepage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;

    @FindBy(xpath = "//button[contains(text(),'Add New Client')]")
    @CacheLookup
    WebElement AddnewClient;

    @FindBy(xpath = "//h1[contains(text(),'Client Registration')]")
    @CacheLookup
    WebElement pageheadingelement;


    @FindBy(xpath = "//input[@type='search']")
    @CacheLookup
    WebElement searchfield;


//span[contains(text(),'AuthClient_expire(1)')]/ancestor::div[@class='single-rest-api-row row']/div[5]/a[@title='Update OAuth Client']
//span[contains(text(),'AuthClient_expire(1)')]/ancestor::div[@class='single-rest-api-row row']/div[5]/a[@title='Associate OAuth Scope']
//span[contains(text(),'AuthClient_expire(1)')]/ancestor::div[@class='single-rest-api-row row']/div[5]/a[@title='Delete OAuth Client']

    public Oauthclientregistrationhomepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(pageheadingelement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("element is visible now.... and element text is  " +pageheadingelement.getText());


    }

    public AddNewClientpage Editclient(String ClientName){
        log.info("edit the client"+ClientName);
        logExtentReport("edit the client " +ClientName);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+ClientName+"')]/ancestor::div[@class='single-rest-api-row row']/div[5]/a[@title='Update OAuth Client']"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
        return new AddNewClientpage(driver);
    }

    public void DeleteClient(String ClientName){
        log.info("Delete the client"+ClientName);
        logExtentReport("Delete the client " +ClientName);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+ClientName+"')]/ancestor::div[@class='single-rest-api-row row']/div[5]/a[@title='Delete OAuth Client']"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-sm delete-btn-prmy primary-btn']"));
        waitHelper.waitForElement(element1, ObjectReader.reader.getExplicitWait());
        element1.click();
    }

    public void Associatetheclientwithscope(String ClientName){
        log.info("Associate the client"+ClientName);
        logExtentReport("Associate the client " +ClientName);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+ClientName+"')]/ancestor::div[@class='single-rest-api-row row']/div[5]/a[@title='Associate OAuth Scope']"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();

    }

    public boolean ScopeManagementIsVisible() {
        log.info("verify Scope Management is visible");
        logExtentReport("verify Scope Management is visible");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Scope Management')]"));
        return element.isDisplayed();
    }

    public boolean ClientRegistrationIsVisible() {
        log.info("verify Client Registration is visible");
        logExtentReport("verify Client Registration is visible");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Client Registration')]"));
        return element.isDisplayed();
    }

    public boolean TokenManagementIsVisible() {
        log.info("verify Token Management is visible");
        logExtentReport("verify Token Management is visible");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Token Management')]"));
        return element.isDisplayed();
    }

    public AddNewClientpage addnewclient(){
        log.info("click add new client button");
        logExtentReport("click add new client button");
        waitHelper.waitForElement(AddnewClient, ObjectReader.reader.getExplicitWait());
        AddnewClient.click();
        return new AddNewClientpage(driver);
    }

    public String getSuccesMessageofImportfile(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();}


    public void waittillitappears(){
        WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait());
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(SuccessMessage,SuccessMessage.getText())));
    }


    public void Searchrequiredclient(String client){
        log.info("click search icon...");
        logExtentReport("click search icon...");
        searchfield.click();
        searchfield.clear();
        searchfield.sendKeys(client);

    }

    public boolean emptyclientmessage(){
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'No clients found!')]"));
        return element.isDisplayed();
    }
}
