package com.webMethodsUI.flow.pageObjects.workflows;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RestConnectorworkflowActionpage extends CommonActions
{
    WebDriver driver;
    private Logger log = LogManager.getLogger(RestConnectorworkflowActionpage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//div[@class='select2-common__input']/input")
    @CacheLookup
    WebElement SelectActiontab;

    @FindBy(xpath = "//span[@class='delite-icon dlt-icon-caret-down']/parent::div")
    @CacheLookup
    WebElement Selectactdropdown;

    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down']")
    @CacheLookup
    WebElement accountfielstab;

    @FindBy(xpath = "//h1[@class='inline-block truncate']")
    @CacheLookup
    WebElement salesactionpageheading;
    
    public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";


    //h1[contains(text(),'Test this action')]

    //h1[contains(text(),'Message posted successfully')]

    //button[contains(text(),'Test')]


    public RestConnectorworkflowActionpage(WebDriver driver) throws Exception{
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
        log.info("RestConnector WorkFlow Action Page Object created..");
        logExtentReport("RestConnector WorkFlow Action Page Object created..");
        waitForElementVisible(salesactionpageheading, driver, "Wait for element visible.. "+salesactionpageheading);
        WebElement ele = findElement("//*[text()='Connect to RESTApiConnector']", driver);
        waitForElementVisible(ele, driver, "Wait for element visible.. "+ele);
    }

    public boolean VerifyActionconfigurepage()
    {
        log.info("Verifying ActionPage.." );
        logExtentReport("Verifying ActionPage..");
        boolean verify = driver.findElement(By.xpath("//span[contains(text(),'Incoming data')]")).isDisplayed();
        return verify;
    }

    public boolean VerifyTestpage(){
        log.info("Verifying Test page" );
        logExtentReport("Verifying Test page");
        boolean verify = driver.findElement(By.xpath("//h1[contains(text(),'Test this action')]")).isDisplayed();
        return verify;
    }

    public boolean VerifyAfterTest() throws Exception
    {
        log.info("Verifying After Test " );
        logExtentReport("Verifying After Test");

    	waitForElementNotVisible(loader, driver, "wait for page load",30);
        WebElement message = findElement("//h1[contains(text(),'Message posted successfully')]", driver);
        waitForElementVisible(message, driver, "Wait for Message posted successfully message to visible");      
        return message.isDisplayed();
//       catch(Exception e)
//       {
//    	   logFailedExtentReport("Test operation failed..");
//         	return false;
//       }
    }

    public void ClickTestButton() throws Exception
    {
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Test");
    }

    public void ClickNextbutton() throws Exception{
        WebElement element = findElement("//button[contains(text(),'Next')]",driver);
        Assert.assertTrue(element.isEnabled());
        click(element, driver, "Clicked Next button");
        waitForElementNotVisible(loader, driver, "wait for page load");
    }

    public void ClickDonebutton() throws Exception
    {
    	 WebElement element = findElement("//button[contains(text(),'Done')]",driver);
         click(element, driver, "Clicked Done button");
         waitForElementNotVisible(loader, driver, "wait for page load");
    }

    public void SelectAction(String Action) throws Exception
    {
        enterValue(SelectActiontab, Action, driver, "Select Action.."+Action);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        waitForElementNotVisible(loader, driver, "wait for page load");
        WebElement ele = findElement("//*[text()='Connect to RESTApiConnector']", driver);
        waitForElementVisible(ele, driver, "Wait for element visible.. "+ele);
    }

    public void selectingAccount(int index,String AccountName) throws Exception {
    	List<WebElement> elemntArray = findElements("//div[contains(@class,'placeholder')][text()='Please Select']",driver);
            WebElement element = elemntArray.get(index);
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element,index);
            genericHelper.selectDropDownLink(AccountName);
    }

    public void enteringValuesinparameters(String fieldname,String value) throws Exception{
        WebElement element = findElement("//div[@aid='"+fieldname+"']/div/input",driver);
        enterValue(element, value, driver, "Entered Value in "+fieldname+ value);
    }
}


