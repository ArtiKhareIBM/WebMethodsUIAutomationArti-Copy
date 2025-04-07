package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.fileupload.FileUpload;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import java.io.File;
import java.time.Duration;

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

public class TenantCertificatepage extends CommonActions {
    WebDriver driver;
    private Logger log = LogManager.getLogger(TenantCertificatepage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//span[contains(text(),'Select Certificate')]")
    @CacheLookup
    WebElement Tenantpageelement;

    @FindBy(xpath = "//div[text()='Select Certificate']")
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
 

    String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

    public TenantCertificatepage(WebDriver driver){

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        log.info("Tenant Certificate Page object created");
        logExtentReport("Tenant Certificate Page object created");


    }

    public void clickingSelectingCertificatedropdown() throws Exception{     
        click(Certificatedropdown, driver, "clicking select certificate drop down");
    }

    public void downloadAndUploadCertificate(String tenantID) throws Exception 
    {
    	 WebElement downloadButton = findElement("//I[contains(@class,'icon-download')]/ancestor::*[@type='button']",driver);
    	 click(downloadButton, driver, "Click on download button");
    	 waitForElementNotVisible(loader, driver, "wait for page load");
    	 TenantCertificatepage.verifyDownloadedFile(tenantID+".crt");
	     WebElement ele = findElement("//div[contains(text(),'Generate Private Key and Certificate')]",driver);
	     click(ele, driver, "Click on select certificate dropdown");
        WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'Upload New Certificate')]"));
        click(ele1,driver,"Select upload new certificate from dropdown");
        WebElement element = findElement("//span[contains(text(),'Browse File')]",driver);
        waitForElementVisible(element, driver, "Verify browser file button is visible");
//        WebElement browse = findElement("//input[@class='file-upload hide']",driver);
        FileUpload fileUpload = new FileUpload(driver); 
        String filepath = ResourceHelper.getResourcePath("\\DownloadedFiles\\"+tenantID+".crt");
        fileUpload.fileUploadUsingInputType(uploadcertificate,filepath);
//        Thread.sleep(5000);
        
        if(driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).isDisplayed())
        {
           WebElement ele2 = findElement("//button[contains(text(),'Proceed')]",driver);
           click(ele2, driver, "clicking proceed button");
//           waitForElementNotVisible(loader, driver, "wait for page load");
        }

    }

    public void SelectinggenerateCertificateinjksformat(String text) throws Exception
    {
    	click(Certificatedropdown, driver, "clicking select certificate drop down");
        WebElement ele = findElement("//div[contains(text(),'Generate Private Key and Certificate')]",driver);
        click(ele, driver, "Selecting Generate Private Key and Certificate from dropdown");
        WebElement element = findElement("//a[@class='dropdown-button primary-button']",driver);
        click(element, driver, "clicking generate button");
        Thread.sleep(1000);
        WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'"+text+"')]"));
        click(element1, driver, "clicking jks format");
        WebElement element2 = findElement("//button[contains(text(),'Proceed')]",driver);
        click(element2, driver, "clicking proceed button");
//        waitForElementNotVisible(loader, driver, "wait for page load");
    }
    
    public void SelectinggenerateCertificateinpfxformat(String text) throws Exception
    {
//    	click(Certificatedropdown, driver, "clicking select certificate drop down");
//        WebElement ele = findElement("//div[contains(text(),'Generate Private Key and Certificate')]",driver);
//        click(ele, driver, "Selecting Generate Private Key and Certificate from dropdown");
        WebElement element = findElement("//a[@class='dropdown-button primary-button']",driver);
        click(element, driver, "clicking generate button");
        WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'"+text+"')]"));
        click(element1, driver, "clicking pfs format");
        WebElement element2 = findElement("//button[contains(text(),'Proceed')]",driver);
        click(element2, driver, "clicking proceed button");
//        waitForElementNotVisible(loader, driver, "wait for page load");
    }

    public void SelectinggenerateCertificateinpk12format() throws Exception{
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

   

    public String getSuccesMessageofImportfile() throws Exception
    {
        waitForElementVisible(SuccessMessage, driver, "Wait for notification message to visible");
        return SuccessMessage.getText();
    }

    public void waittillitappears(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ObjectReader.reader.getExplicitWait()));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(SuccessMessage,SuccessMessage.getText())));
    }

    public void ClickDownloadbutton(){
        log.info("clicking download buton...");
        logExtentReport("clicking download buton....");
        Assert.assertTrue(DownloadButton.isDisplayed());
    }
    public void goingToCertificatePage() throws Exception{
 
        WebElement element = driver.findElement(By.xpath("//a[text()='User certificate']"));
        click(element, driver, "Click on user certificate Page");
        waitForElementNotVisible(loader, driver, "wait for page load");
    }

    public void Verifydropdownlist() throws Exception{
        log.info("verify the lists  visible in dropdowns");
        logExtentReport("verify the lists  visible in dropdowns");
        clickingSelectingCertificatedropdown();
//        WebElement element1 = driver.findElement(By.xpath("//li[@class='search-list']"));
//        return element1.isDisplayed();
    }

    public boolean VerifyUsageinUserlabel()
    {
        log.info("Verify at user label");
        logExtentReport("Delete generated certificate");
        WebElement element = driver.findElement(By.xpath("//div[@class='title-wrapper']"));
        return element.isDisplayed();
    }


    public void uploadinvalidCertificate() throws Exception
    {
    	click(Certificatedropdown, driver, "clicking select certificate drop down");
        WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'Upload New Certificate')]"));
        click(ele1,driver,"Select upload new certificate from dropdown");
        WebElement element = findElement("//span[contains(text(),'Browse File')]",driver);
        waitForElementVisible(element, driver, "Verify browser file button is visible");
//        WebElement browse = findElement("//input[@class='file-upload hide']",driver);
        FileUpload fileUpload = new FileUpload(driver); 
        String filepath = ResourceHelper.getResourcePath("\\\\src\\\\main\\\\java\\\\com\\\\webMethodsUI\\\\flow\\\\pageObjects\\\\Settingpage\\\\Ankeeta.crt");
        fileUpload.fileUploadUsingInputType(uploadcertificate,filepath);
//        Thread.sleep(5000);
        
        if(driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).isDisplayed())
        {
           WebElement ele2 = findElement("//button[contains(text(),'Proceed')]",driver);
           click(ele2, driver, "clicking proceed button");
//           waitForElementNotVisible(loader, driver, "wait for page load");
        }

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

















