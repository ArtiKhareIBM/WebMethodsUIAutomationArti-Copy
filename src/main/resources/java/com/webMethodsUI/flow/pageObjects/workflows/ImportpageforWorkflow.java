package com.webMethodsUI.flow.pageObjects.workflows;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ImportpageforWorkflow {

    private WebDriver driver;
    private Logger log = LogManager.getLogger(ImportpageforWorkflow.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//span[contains(text(),'Template Description')]")
    @CacheLookup
    WebElement thatpageelement;


//    @FindBy(xpath = "//div[@class='ql-editor ql-blank']/p")
//    @CacheLookup
//    WebElement Tampletefield;


//    @FindBy(xpath = "//button[contains(text(),'Export')]")
//    @CacheLookup
//    WebElement Exportfield;

    @FindBy(xpath = "//button[contains(text(),'Import')]")
    @CacheLookup
    WebElement Importfield;


    public ImportpageforWorkflow(WebDriver driver){
        super();
        this.driver = driver;

        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(Importfield, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("import workflow  Object created");

    }

//    public void EnteringField(String Tamplete){
//        log.info("element is visible now....");
//        logExtentReport("import workflow  Object created");
//        Tampletefield.click();
//        Tampletefield.sendKeys("description");
//
//
//
//    }
//
//    public void Exporttheworkflow(){
//        Assert.assertTrue(Exportfield.isEnabled());
//        log.info("click export button");
//        logExtentReport("click export button");
//        Exportfield.click();
//    }
    public void Importtheworkflow(){
        log.info("click impport button");
        logExtentReport("click impport button");
        Assert.assertTrue(Importfield.isEnabled());
        Importfield.click();
    }

}
