package com.webMethodsUI.flow.pageObjects.projects;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

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

public class ManageEnviromentPage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(ManageEnviromentPage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//h1[contains(text(),'Manage Environments')]")
    @CacheLookup
    public static WebElement ManageenviromentTitlepage;

    @FindBy(xpath = "//button[contains(text(),'Register Environment')]")
    @CacheLookup
    public static WebElement RegisterEnviromentbutton;


    @FindBy(xpath = "//input[@aid='Name']")
    @CacheLookup
    public static WebElement Namefield;

    @FindBy(xpath = "//input[@aid='Tenant URL']")
    @CacheLookup
    public static WebElement TenantURLfield;

    @FindBy(xpath = "//input[@aid='Username']")
    @CacheLookup
    public static WebElement UserNameField;


    @FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
    @CacheLookup
    public static WebElement Savebutton;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;





    public ManageEnviromentPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(ManageenviromentTitlepage, ObjectReader.reader.getExplicitWait());

        log.info("element is visible now....");


    }

    public void ClickRegisterbutton(){
        log.info("Clicking Register button");
        logExtentReport("Clicking Register button");
        RegisterEnviromentbutton.click();
    }
    public void EnteringName(String NameofURL){
        log.info("Entering UrlName" + NameofURL );
        logExtentReport("Entering UrlName" + NameofURL);
        Namefield.click();
        Namefield.sendKeys(NameofURL);

    }

    public void EnteringTenanturl(String deployingTenanturl){
        log.info("Entering Tenanturl" + deployingTenanturl );
        logExtentReport("Entering Tenanturl" + deployingTenanturl);
        TenantURLfield.click();
        TenantURLfield.sendKeys(deployingTenanturl);

    }

    public void EnteringUsername(String deployingTenantUsername){
        log.info("Entering deployingTenantUsername" + deployingTenantUsername );
        logExtentReport("Entering deployingTenantUsername" + deployingTenantUsername);
        UserNameField.click();
        UserNameField.sendKeys(deployingTenantUsername);

    }

    public void ClickSavebutton(){
        log.info("Clicking Save button");
        logExtentReport("Clicking Save button");
        Savebutton.click();
    }

    public String getSuccesMessage(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();
    }

    public void DeleteAddedEnviroment(String NameofURL){
        log.info("Deleting Added Enviroment" +NameofURL);
        logExtentReport("Deleting Added Enviroment" +NameofURL);
        WebElement ele = driver.findElement(By.xpath(" //div[@class='col s3'][contains(text(),'"+NameofURL+"')]/parent::div/div[4]/a[@class='environment-check-delete']"));
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
        ele1.click();

    }


}
