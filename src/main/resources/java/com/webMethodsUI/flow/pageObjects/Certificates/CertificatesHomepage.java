package com.webMethodsUI.flow.pageObjects.Certificates;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

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

import java.util.Random;

public class CertificatesHomepage {
    private WebDriver driver;
    private Logger log = LogManager.getLogger(CertificatesHomepage.class);
    TestBase test;
    WaitHelper waitHelper;


    @FindBy(xpath = "//span[contains(text(),'Certificates')]")
    @CacheLookup
    WebElement CertificateTitlepage;

    @FindBy(xpath = "//a[contains(text(),'New certificate')]")
    @CacheLookup
    WebElement AddCertificate;

    @FindBy(xpath = "//a[contains(text(),'Keystore')]")
    @CacheLookup
    WebElement AddNewkeyStore;

    @FindBy(xpath = "//a[contains(text(),'Truststore')]")
    @CacheLookup
    WebElement AddTruststore;

    @FindBy(xpath = "//button[@class=' btn btn-link delete-btn-prmy btn-sm']")
    @CacheLookup
    WebElement flowServiceDeleteButtonElement;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;


    public CertificatesHomepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(CertificateTitlepage, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now...." + CertificateTitlepage);
        logExtentReport("Element is visible");

    }

    public KeyStorepage Addkeystore(){
        log.info("Clicking Add button");
        logExtentReport("Clicking Add button" );
        waitHelper.waitForElement(AddCertificate, ObjectReader.reader.getExplicitWait());
        AddCertificate.click();
        waitHelper.waitForElement(AddNewkeyStore, ObjectReader.reader.getExplicitWait());
        AddNewkeyStore.click();
        return new KeyStorepage(driver);
    }

    public TrustStorepage AddTruststore(){
        log.info("Clicking Add button");
        logExtentReport("Clicking Add button" );
        waitHelper.waitForElement(AddCertificate, ObjectReader.reader.getExplicitWait());
        AddCertificate.click();
        waitHelper.waitForElement(AddTruststore, ObjectReader.reader.getExplicitWait());
        AddTruststore.click();
        return new TrustStorepage(driver);
    }



    public void DeletingKeyStore(String KeyStoreName){
//        Random objGenerator = new Random();
//        int randomNumber = objGenerator.nextInt(100);
//        String name = "KeystoreName"+randomNumber;
        log.info("Deleting keyStore");
        logExtentReport("Deleting keyStore" );
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+ KeyStoreName +"')]/ancestor::div[@class='certificates-inner-content']/div/div[3]/span[2]"));
        ele.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(flowServiceDeleteButtonElement, ObjectReader.reader.getExplicitWait());
        flowServiceDeleteButtonElement.click();
    }

    public String getSuccesMessage(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();
    }


    public String getkeystorename(){
        WebElement ele = driver.findElement(By.xpath("//div[@class='row certificate-wrapper-inner-detail']/div[1]//span[@class='certificate-inner-title']"));
        return ele.getText();
    }

    public void EditCertificate(String KeyStoreName){
        log.info("clicking 3dot ");
        logExtentReport("clicking 3dot " );
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+ KeyStoreName +"')]/ancestor::div[@class='certificates-inner-content']/div/div[3]/span[2]"));
        ele.click();
        log.info("clicking Edit Button ");
        logExtentReport("clicking Edit Button " );
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();



    }

}
