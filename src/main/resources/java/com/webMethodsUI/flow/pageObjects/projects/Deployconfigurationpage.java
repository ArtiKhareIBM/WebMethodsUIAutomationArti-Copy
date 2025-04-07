package com.webMethodsUI.flow.pageObjects.projects;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.assertion.VerificationHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class Deployconfigurationpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(Deployconfigurationpage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//h3[contains(text(),'Configure Accounts')]")
    @CacheLookup
    public static WebElement ConfigureAccountstitle;

    @FindBy(xpath = "//h3[contains(text(),'Configure Triggers')]")
    @CacheLookup
    public static WebElement Configuretriggertab;

    @FindBy(xpath = "//h3[contains(text(),'Configure Parameters')]")
    @CacheLookup
    public static WebElement Configureparameterstab;


    @FindBy(xpath = "//button[contains(text(),'Deploy')]")
    @CacheLookup
    public static WebElement Deploybutton;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;




    public Deployconfigurationpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(ConfigureAccountstitle, ObjectReader.reader.getExplicitWait());

        log.info("element is visible now....");



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

    public void clickingDeploybutton(){
        try {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Deploy");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public boolean verifyConfiguretriggertabTitle() {
        return new VerificationHelper(driver).isDisplayed(Configuretriggertab);
    }

    public boolean verifyConfigureparameterstabTitle() {
        return new VerificationHelper(driver).isDisplayed(Configureparameterstab);
    }

    public String getSuccesMessage(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();
    }



}
