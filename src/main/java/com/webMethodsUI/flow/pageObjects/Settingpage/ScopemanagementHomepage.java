package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScopemanagementHomepage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(ScopemanagementHomepage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//button[contains(text(),'Add New Scope')]")
    @CacheLookup
    WebElement AddScopebutton;


    @FindBy(xpath = "//h1[contains(text(),'Scope Management')]")
    @CacheLookup
    WebElement Scopemanagementheading;


    @FindBy(xpath = " //button[@class='btn btn-danger btn-sm delete-btn-prmy primary-btn']")
    @CacheLookup
    WebElement Deletebutton;
    
    String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";




    //span[contains(text(),'TestScope')]/ancestor::div[@class='single-rest-api-row row']/div[4]//a[@title='Delete OAuth Scope']


    //span[contains(text(),'TestScope')]/ancestor::div[@class='single-rest-api-row row']/div[4]//a[@title='Update OAuth Scope']


    public ScopemanagementHomepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(Scopemanagementheading, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("element is visible now.... and element text is  " + Scopemanagementheading.getText());

    }

    public AddNewScopepage addnewscopebutton(){
        AddScopebutton.click();
        return new AddNewScopepage(driver);
    }

    public void DeleteScope(String ScopeName) throws Exception{
        WebElement deleteicon =findElement("//span[contains(text(),'"+ScopeName+"')]/ancestor::div[@class='single-rest-api-row row']/div[4]//a[@title='Delete OAuth Scope']",driver);
        waitHelper.waitForElement(deleteicon, ObjectReader.reader.getExplicitWait());
        deleteicon.click();
        waitHelper.waitForElement(Deletebutton, ObjectReader.reader.getExplicitWait());
        Deletebutton.click();
        log.info("Delete Scope"+ScopeName);
        logExtentReport("Delete Scope...." +ScopeName);
    }
    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;
    public String getSuccesMessageofImportfile(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();}


    public void waittillitappears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ObjectReader.reader.getExplicitWait()));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(SuccessMessage, SuccessMessage.getText())));
    }



    public boolean DeleteButtonVisible(String ScopeName) throws Exception{
        WebElement deleteicon = driver.findElement(By.xpath(" //span[contains(text(),'"+ScopeName+"')]/ancestor::div[@class='single-rest-api-row row']/div[4]//a[@title='Delete OAuth Scope']"));
//        deleteicon.click();
//        log.info(" Is Delete button visible");
//        logExtentReport("Is Delete button visible");
        click(deleteicon, driver, "click on delete icon");
        waitForElementNotVisible(loader, driver, "wait for page load");
        try {
            return Deletebutton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

//        return Deletebutton.isDisplayed();



}
