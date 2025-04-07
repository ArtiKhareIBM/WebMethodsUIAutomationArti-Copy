package com.webMethodsUI.flow.pageObjects.projects;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.assertion.VerificationHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class publishprojectpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(publishprojectpage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//div[@class='published-details-wrapper']/span[contains(text(),'Select assets')]")
    @CacheLookup
    public static WebElement publishprojectSelectAssettab;

    @FindBy(xpath = "//div[@class='published-details-wrapper']/span[contains(text(),'Publish settings')]")
    @CacheLookup
    public static WebElement publicSettingtab;

    @FindBy(xpath = "//div[@class='published-details-wrapper']/span[contains(text(),'Confirm dependencies')]")
    @CacheLookup
    public static WebElement Confirmdependenciestab;

    @FindBy(xpath = "//span[@class='new-checkbox-label-text'][contains(text(),'Rest APIs')]")
    @CacheLookup
    public static WebElement RESTapicheckbox;


    @FindBy(xpath = "//input[@aid='Name']")
    @CacheLookup
    public static WebElement Namefield;

    @FindBy(xpath = "//span[@class='delite-icon dlt-icon-caret-down']")
    @CacheLookup
    public static WebElement selectenvironmentdropdown;


    @FindBy(xpath = "//input[@aid='Password']")
    @CacheLookup
    public static WebElement passwordfield;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;

    public publishprojectpage(WebDriver driver) throws Exception{
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logExtentReport("Publish Project Page object created");
    	waitForElementVisible(publishprojectSelectAssettab,driver,"Verify publishprojectSelectAssettab is present");
    }

    public void ClickingNextbutton(){
        try {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Next");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String verifyRestApi(String RestapiName){
        log.info("VerifyRestApi Name" );
        logExtentReport("VerifyRestApi Name" );
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+RestapiName+"')]"));
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(ele, ObjectReader.reader.getExplicitWait());
        return ele.getText();
    }


    public boolean verifypublicSettingTitle() {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(publicSettingtab, ObjectReader.reader.getExplicitWait());
        return new VerificationHelper(driver).isDisplayed(publicSettingtab);
    }

    public boolean verifyConfirmdepencies() {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(Confirmdependenciestab, ObjectReader.reader.getExplicitWait());
        return new VerificationHelper(driver).isDisplayed(Confirmdependenciestab);
    }

    public void EnteringName(String NamedeployedProject){
        log.info("Entering NamedeployedProject" + NamedeployedProject );
        logExtentReport("Entering UrlName" + NamedeployedProject);
        Namefield.click();
        Namefield.sendKeys(NamedeployedProject);

    }

    public void clickingcheckboxforRestApis(){
        log.info("Clicking RestApi checkbox" );
        logExtentReport("Clicking RestApi checkbox" );
        RESTapicheckbox.click();
    }

    public void selectingEnviroment(String NameofTenanturl) throws InterruptedException{
        log.info("Selecting enviroment" +NameofTenanturl );
        logExtentReport("Selecting enviroment" +NameofTenanturl );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        selectenvironmentdropdown.click();
        WebElement element = driver.findElement(By.xpath("//div[@class='css-1g6gooi']/div/input"));
        //js.executeScript("arguments[0].click();",element);
        //element.click();
        Actions builder = new Actions(driver);

        //builder.moveToElement(element).click(element).sendKeys(NameofTenanturl).build().perform();
        element.sendKeys(NameofTenanturl);
//        Actions action = new Actions(driver);
          //Thread.sleep(10000);
        builder.sendKeys(Keys.ENTER).perform();
//        action.sendKeys(Keys.TAB).perform();
        // WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+ NameofTenanturl +"')]"));
        //js.executeScript("arguments[0].click();",element);

    }

    public void ClickingPublishtbutton(){
        try {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Publish");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void enteringpassword(String newpassword){
        log.info("Entering" +newpassword );
        logExtentReport("Entering" +newpassword );
        passwordfield.click();
        passwordfield.sendKeys(newpassword);
        passwordfield.click();
        passwordfield.clear();
        passwordfield.sendKeys(newpassword);
    }

    public String getSuccesMessage(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, 10);
        return SuccessMessage.getText();
    }


    //span[@class='new-checkbox-label-text'][contains(text(),'Workflows')]

    public void AssetTobeselect(String NameOfAsset){
        log.info("Clicking  checkbox" +NameOfAsset );
        logExtentReport("Clicking  checkbox" +NameOfAsset );
        WebElement ele = driver.findElement(By.xpath(" //span[@class='new-checkbox-label-text'][contains(text(),'"+NameOfAsset+"')]"));
        ele.click();

    }

    public void SelectTenant(String NameofTenanturl) throws Exception{
    	log.info("Selecting enviroment" +NameofTenanturl );
        logExtentReport("Selecting enviroment" +NameofTenanturl );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        selectenvironmentdropdown.click();
        WebElement element = driver.findElement(By.xpath("//div[@class='css-1g6gooi']/div/input"));
        //js.executeScript("arguments[0].click();",element);
        //element.click();
        Actions builder = new Actions(driver);

        //builder.moveToElement(element).click(element).sendKeys(NameofTenanturl).build().perform();
        element.sendKeys(NameofTenanturl);
        element.click();
    	GenericHelper genericHelper = new GenericHelper(driver);
        //WebElement element = driver.findElement(By.xpath("//span[@class='delite-icon dlt-icon-caret-down']"));
        //waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        //element.click();
        log.info("Click the Drop Down"+element);
        logExtentReport("Click the Drop Down"+element);
        //GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink(NameofTenanturl);

    }



}
