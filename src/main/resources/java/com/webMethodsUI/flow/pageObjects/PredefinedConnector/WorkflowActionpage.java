package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
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

import java.util.List;

public class WorkflowActionpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(WorkflowActionpage.class);
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

    @FindBy(xpath = "//h1[contains(text(),'Salesforce CRM')]")
    @CacheLookup
    WebElement salesactionpageheading;







    //h1[contains(text(),'Test this action')]

    //h1[contains(text(),'Message posted successfully')]

    //button[contains(text(),'Test')]


    public WorkflowActionpage(WebDriver driver){
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
        boolean verify = driver.findElement(By.xpath("//span[contains(text(),'Incoming Data')]")).isDisplayed();
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
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Next");
        log.info("Clicked Next button" );
        logExtentReport("Clicked Next button");
    }

    public void ClickDonebutton() throws Exception{
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Done");
        log.info("Clicked Done button" );
        logExtentReport("Clicked Done button");
    }

    public void SelectAction(String Action){
        Selectactdropdown.click();
        SelectActiontab.sendKeys(Action);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
//        WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+Action+"')]"));
//        ele.click();
        log.info("Entered Action"+ Action);
        logExtentReport("Entered Action"+ Action);
    }

    public void selectingAccount(int index,String AccountName) {

        try {
            List<WebElement> elemntArray = driver
                    .findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down']"));
            log.info("All input parameters are....." + elemntArray);
            WebElement element = elemntArray.get(index);

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element,0);
            genericHelper.selectDropDownLink(AccountName);
            log.info("Clicked on AccountName....");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




}
