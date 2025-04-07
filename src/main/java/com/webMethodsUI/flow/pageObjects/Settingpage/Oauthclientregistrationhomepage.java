package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
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
import org.testng.Assert;

public class Oauthclientregistrationhomepage extends CommonActions{
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

    public Oauthclientregistrationhomepage(WebDriver driver) throws Exception
    {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForElementVisible(pageheadingelement, driver, "Wait for client page to be visible");
    }

    public AddNewClientpage Editclient(String ClientName) throws Exception
    {

        WebElement element = findElement("//span[contains(text(),'"+ClientName+"')]/ancestor::div[@class='single-rest-api-row row']/div[5]//a[@title='Update OAuth Client']",driver);
        click(element, driver, "edit the client "+ClientName);
        return new AddNewClientpage(driver);
    }

    public void DeleteClient(String ClientName) throws Exception
    {
        WebElement element = findElement("//span[contains(text(),'"+ClientName+"')]/ancestor::div[@class='single-rest-api-row row']/div[5]//a[@title='Delete OAuth Client']",driver);
        click(element, driver, "Delete the client"+ClientName);
        WebElement element1 = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-sm delete-btn-prmy primary-btn']"));
        click(element1, driver, "Click on delete button");
    }

    public void Associatetheclientwithscope(String ClientName) throws Exception
    {
        WebElement element = findElement("//span[contains(text(),'"+ClientName+"')]/ancestor::div[@class='single-rest-api-row row']/div[5]//a[@title='Associate OAuth Scope']",driver);
       click(element, driver, "Associate the client"+ClientName);
    }

    public boolean ScopeManagementIsVisible() 
    {
        log.info("verify Scope Management is visible");
        logExtentReport("verify Scope Management is visible");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Scope Management')]"));
        return element.isDisplayed();
    }

    public boolean ClientRegistrationIsVisible() throws Exception {
 
        WebElement element = findElement("//span[contains(text(),'Client Registration')]",driver);
        return isElementDisplayed(element, driver, "verify Client Registration is visible");
    }

    public boolean TokenManagementIsVisible() throws Exception
    {
        WebElement element = findElement("//span[contains(text(),'Token Management')]",driver);
        return isElementDisplayed(element, driver, "verify Token Management is visible");
    }

    public AddNewClientpage addnewclient() throws Exception
    {

        click(AddnewClient, driver, "click add new client button");
        return new AddNewClientpage(driver);
    }

    public void getSuccesMessageofImportfile(String text) throws Exception
    {

        String msg = getText(SuccessMessage, driver, "Getting successMessage...");
        Assert.assertEquals(msg,text);
        Thread.sleep(3000);
     }


    public void waittillitappears() throws Exception
    {
        String SuccessMessage = "//div[@class='notification-message']";
        waitForElementNotVisible(SuccessMessage, driver, "Wait for element not visible",10);
    }


    public void Searchrequiredclient(String client)
    {
        log.info("click search icon...");
        logExtentReport("click search icon...");
        searchfield.click();
        searchfield.clear();
        searchfield.sendKeys(client);

    }

    public boolean emptyclientmessage() throws Exception
    {
        WebElement element = findElement("//span[contains(text(),'No clients found!')]",driver);
        return element.isDisplayed();
    }
}
