package com.webMethodsUI.flow.pageObjects.flowService;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlowServiceOverViewDatepage {

    private WebDriver driver;
    private Logger log = LogManager.getLogger(FlowServiceOverViewDatepage.class);
    TestBase test;
    WaitHelper waitHelper;

    @FindBy(xpath = "//h6[contains(text(),'Configuration')]")
    @CacheLookup
    WebElement overviewpageElement;

    @FindBy(xpath = "//span[contains(text(),'Enable FlowService to be invoked over HTTP')]/parent::label/parent::div")
    @CacheLookup
    WebElement checkboxhttpinterface;


    @FindBy(xpath = "//span[contains(text(),'Synchronous URL')]")
    @CacheLookup
    WebElement Synchronousurl;

    @FindBy(xpath = "//i[contains(text(),'close')]")
    @CacheLookup
    WebElement closethescreen;




    public FlowServiceOverViewDatepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(overviewpageElement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now...." + overviewpageElement);

    }

    public void clickcheckbox() throws InterruptedException {
        log.info("click check box http interface");
        logExtentReport("click check box http interface");
        waitHelper.waitForElement( checkboxhttpinterface, ObjectReader.reader.getExplicitWait());
        checkboxhttpinterface.click();
        waitHelper.waitForElement(Synchronousurl, ObjectReader.reader.getExplicitWait());
        Thread.sleep(2000);
    }


    public void closethescreen(){
        waitHelper.waitForElement( closethescreen, ObjectReader.reader.getExplicitWait());
        closethescreen.click();
        log.info("Screen closed");
        logExtentReport("Screen closed");
    }




}
