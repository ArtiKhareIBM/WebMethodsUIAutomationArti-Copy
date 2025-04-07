package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.fileupload.FileUpload;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TenantCertificatepage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(TenantCertificatepage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//span[contains(text(),'Select Certificate')]")
    @CacheLookup
    WebElement Tenantpageelement;


    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down ']")
    @CacheLookup
    WebElement  Certificatedropdown;

    @FindBy(xpath = "//button[@class='btn secondary-btn btn-sm']")
    @CacheLookup
    WebElement DeleteButton;

    @FindBy(xpath = "//button[@class='btn primary-btn']")
    @CacheLookup
    WebElement DeleteButton2;

    @FindBy(xpath = "//button[@class='btn secondary-btn btn-sm btn-space']")
    @CacheLookup
    WebElement DownloadButton;

    @FindBy(xpath = "//input[@class='file-upload hide']")
    @CacheLookup
    WebElement uploadcertificate;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;



    public TenantCertificatepage(WebDriver driver){

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(Tenantpageelement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("element is visible now.... and element text is  " +Tenantpageelement.getText());


    }

    public void clickingSelectingCertificatedropdown(){
        log.info("clicking select certificate drop down");
        logExtentReport("clicking select certificate drop down");
        waitHelper.waitForElement(Certificatedropdown, ObjectReader.reader.getExplicitWait());
        Certificatedropdown.click();

    }

    public void SelectinguploadCertificate() throws Exception {
//        clickingSelectingCertificatedropdown();
        log.info("select upload certificate");
        logExtentReport("select upload certificate");
        WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Upload New Certificate')]"));
        waitHelper.waitForElement(ele, ObjectReader.reader.getExplicitWait());
        ele.click();
        log.info("Verify Browse button visible or not");
        logExtentReport("Verify Browse button visible or not");
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Browse File')]")).isDisplayed());
        WebElement browse = driver.findElement(By.xpath("//input[@class='file-upload hide']"));
        FileUpload fileUpload = new FileUpload(driver);
        String filepath = ResourceHelper.getResourcePath("\\src\\main\\java\\com\\webMethodsUI\\flow\\pageObjects\\Settingpage\\2103536290.crt");
        fileUpload.fileUploadUsingInputType(browse,filepath);
         Thread.sleep(5000);
        
        if(driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).isDisplayed())
        {
           log.info("clicking proceed button");
           logExtentReport("clicking proceed button");
           WebElement ele1 = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
           waitHelper.waitForElement(ele1, ObjectReader.reader.getExplicitWait());
           ele1.click();
           Thread.sleep(5000);
        }

    }

    public void SelectinggenerateCertificateinjksformat(){
        clickingSelectingCertificatedropdown();
        log.info("clicking select certificate drop down");
        logExtentReport("clicking select certificate drop down");
        WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Generate Private Key and Certificate')]"));
        waitHelper.waitForElement(ele, ObjectReader.reader.getExplicitWait());
        ele.click();
        log.info("clicking generate button");
        logExtentReport("clicking generate button");
        WebElement element = driver.findElement(By.xpath("//a[@class='dropdown-button primary-button']"));
        element.click();
        log.info("clicking jks button");
        logExtentReport("clicking jks button");
        WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'jks format')]"));
        waitHelper.waitForElement(element1, ObjectReader.reader.getExplicitWait());
        element1.click();
        log.info("clicking proceed button");
        logExtentReport("clicking proceed button");
        WebElement element2 = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
        waitHelper.waitForElement(element2, ObjectReader.reader.getExplicitWait());
        element2.click();
    }

    public void SelectinggenerateCertificateinpk12format(){
        clickingSelectingCertificatedropdown();
        log.info("clicking select certificate drop down");
        logExtentReport("clicking select certificate drop down");
        WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Generate Private Key and Certificate')]/parent::li"));
        ele.click();
        log.info("clicking generate button");
        logExtentReport("clicking generate button");
        WebElement element = driver.findElement(By.xpath("//a[@class='dropdown-button primary-button']"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
        log.info("clicking jks button");
        logExtentReport("clicking jks button");
        WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'pkcs12 format')]"));
        waitHelper.waitForElement(element1, ObjectReader.reader.getExplicitWait());
        element1.click();
        log.info("clicking proceed button");
        logExtentReport("clicking proceed button");
        WebElement element2 = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
        waitHelper.waitForElement(element2, ObjectReader.reader.getExplicitWait());
        element2.click();
    }





    public String getSuccesMessageofImportfile(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();
    }

    public void waittillitappears(){
        WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait());
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(SuccessMessage,SuccessMessage.getText())));
    }

    public void ClickDownloadbutton(){
        log.info("clicking download buton...");
        logExtentReport("clicking download buton....");
        Assert.assertTrue(DownloadButton.isDisplayed());
    }
    public void goingtoCertificatepage(){
        log.info("going to certificate page");
        logExtentReport("going to certificate page");
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Configuration')]"));
        element.click();
    }

    public boolean Verifydropdownlist(){
        log.info("verify the lists  visible in dropdowns");
        logExtentReport("verify the lists  visible in dropdowns");
        clickingSelectingCertificatedropdown();
        WebElement element1 = driver.findElement(By.xpath("//li[@class='search-list']"));
        return element1.isDisplayed();
    }

    public boolean VerifyUsageinUserlabel(){
        log.info("Verify at user label");
        logExtentReport("Delete generated certificate");
        WebElement element = driver.findElement(By.xpath("//div[@class='title-wrapper']"));
        return element.isDisplayed();
    }


    public void uploadinvalidCertificate() throws Exception {
        clickingSelectingCertificatedropdown();
        log.info("select upload certificate");
        logExtentReport("select upload certificate");
        WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Upload New Certificate')]/parent::li"));
        ele.click();
        log.info("Verify Browse button visible or not");
        logExtentReport("Verify Browse button visible or not");
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Browse File')]")).isDisplayed());
        WebElement browse = driver.findElement(By.xpath("//input[@class='file-upload hide']"));
        FileUpload fileUpload = new FileUpload(driver);
        String filepath = ResourceHelper.getResourcePath("\\src\\main\\java\\com\\webMethodsUI\\flow\\pageObjects\\Settingpage\\Ankeeta.crt");
        fileUpload.fileUploadUsingInputType(browse, filepath);

    }



    public void clickproceedbutton() {
        log.info("clicking proceed button");
        logExtentReport("clicking proceed button");
        WebElement element2 = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
        waitHelper.waitForElement(element2, ObjectReader.reader.getExplicitWait());
        element2.click();
    }

    public void DeleteGenerated(){
        log.info("Delete generated certificate");
        logExtentReport("Delete generated certificate");
        waitHelper.waitForElement(DeleteButton, ObjectReader.reader.getExplicitWait());
        DeleteButton.click();
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(DeleteButton2, ObjectReader.reader.getExplicitWait());
        DeleteButton2.click();
    }

}

















