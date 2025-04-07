package com.webMethodsUI.flow.pageObjects.SoftwareAGManageEnv;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;

import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnviromentPage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(EnviromentPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h1[contains(text(),'Environment')]")
    @CacheLookup
    WebElement Enviromentheading;

    public EnviromentPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(Enviromentheading, ObjectReader.reader.getExplicitWait());
        log.info("Test operation input page   is visible now....");
        logExtentReport(
                " Test operation input page   is visible now........ and element text is  " + Enviromentheading.getText());


    }

    public boolean verifyelements(){
        log.info("Verify elements");
        logExtentReport(
                " Verify elements");
        WebElement element = driver.findElement(By.xpath("//ul[@class='sci-nav-tabs-bar']"));
        return element.isDisplayed();

    }







}
