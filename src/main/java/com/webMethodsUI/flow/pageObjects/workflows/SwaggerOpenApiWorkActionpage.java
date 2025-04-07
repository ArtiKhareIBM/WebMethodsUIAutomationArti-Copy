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
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SwaggerOpenApiWorkActionpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(SwaggerOpenApiWorkActionpage.class);
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

    @FindBy(xpath = "//h1[@class='inline-block']")
    @CacheLookup
    WebElement salesactionpageheading;


    @FindBy(xpath = "//input[@aid='Swagger file URL']")
    @CacheLookup
    WebElement Swagerurlinputfield;

    @FindBy(xpath = "//input[@aid='Username']")
    @CacheLookup
    WebElement Usernamefield;


    @FindBy(xpath = "//input[@aid='Password']")
    @CacheLookup
    WebElement PasswordField;









    //h1[contains(text(),'Test this action')]

    //h1[contains(text(),'Message posted successfully')]

    //button[contains(text(),'Test')]


    public SwaggerOpenApiWorkActionpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(salesactionpageheading, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");

    }

    public boolean VerifyActionconfigurepage(){
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

    public boolean VerifyAfterTest(){
        log.info("Verifying After Test " );
        logExtentReport("Verifying After Test");
        waitHelper.waitForElement(driver.findElement(By.xpath("//h1[contains(text(),'Message posted successfully')]")), ObjectReader.reader.getExplicitWait());
        boolean verify = driver.findElement(By.xpath("//h1[contains(text(),'Message posted successfully')]")).isDisplayed();
        return verify;
    }

    public void ClickTestButton() throws Exception{
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Test");
        log.info("Clicked Test button" );
        logExtentReport("Clicked Test button");
    }

    public void ClickNextbutton() throws Exception{
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
        Assert.assertTrue(element.isEnabled());
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Next");
        log.info("Clicked Next button" );
        logExtentReport("Clicked Next button");
    }

    public void ClickDonebutton() throws Exception{
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Done')]")).isEnabled());
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Done");
        log.info("Clicked Done button" );
        logExtentReport("Clicked Done button");
    }

    public void ClickFetchbutton() throws Exception{
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Fetch')]")).isEnabled());
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Fetch");
        log.info("Clicked Fetch button" );
        logExtentReport("Clicked Fetch button");
    }

    public void EnterSwagerurlinputfield(String path){
        log.info("Entering SwaggerurlField");
        logExtentReport("Entering SwaggerurlField");
        Swagerurlinputfield.click();
        Swagerurlinputfield.sendKeys(path);
    }


    public void EnteringUserName(String Username){
        log.info("Entering Username"+Username);
        logExtentReport("Entering Username"+Username);
        Usernamefield.click();
        Usernamefield.sendKeys(Username);
    }

    public void EnteringPassword(String password){
        log.info("Entering password"+password);
        logExtentReport("Entering password"+password);
        PasswordField.click();
        PasswordField.sendKeys(password);
    }



    public void enteringValuesinparameters(String fieldname,String value){
        WebElement element = driver.findElement(By.xpath("//div[@aid='"+fieldname+"']/div/input"));
        element.click();
        element.sendKeys(value);
        log.info("Entered Value in "+fieldname+ value);
        logExtentReport("Entered Value in"+fieldname+ value);
    }


    public void selectingpath(int index,String path) {

        try {

            List<WebElement> elemntArray = driver
                    .findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
            log.info("All input parameters are....." + elemntArray);
            WebElement element = elemntArray.get(index);
            waitHelper.waitForElement(element,ObjectReader.reader.getExplicitWait());
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element,0);
            genericHelper.selectDropDownLink(path);
            log.info("Clicked on path...");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
