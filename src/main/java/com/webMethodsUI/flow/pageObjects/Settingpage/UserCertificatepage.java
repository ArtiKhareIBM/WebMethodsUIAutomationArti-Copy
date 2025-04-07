package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.fileupload.FileUpload;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class UserCertificatepage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(UserCertificatepage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//span[contains(text(),'Select User')]")
    @CacheLookup
    WebElement UserCertificatepageelement;



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

    public  UserCertificatepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(UserCertificatepageelement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("element is visible now.... and element text is  " +UserCertificatepageelement.getText());

    }

    public void Selectingdropdown(int index) throws Exception{
        log.info("clicking select certificate drop down");
        logExtentReport("clicking select certificate drop down");
        WebElement elemntArray =findElement("//*[contains(@class,'placeholder')][text()='Select User']",driver);
        
    }

   public void downloadAndUploadCertificate() throws Exception 
   {
   	 WebElement downloadButton = findElement("//I[contains(@class,'icon-download')]/ancestor::*[@type='button']",driver);
   	 click(downloadButton, driver, "Click on download button");
   	 waitForElementNotVisible(loader, driver, "wait for page load");
   	 verifyDownloadedFile(ObjectReader.reader.getUserName()+".crt");
	     WebElement ele = findElement("//div[contains(text(),'Generate Private Key and Certificate')]",driver);
	     click(ele, driver, "Click on select certificate dropdown");
       WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'Upload New Certificate')]"));
       click(ele1,driver,"Select upload new certificate from dropdown");
       WebElement element = findElement("//span[contains(text(),'Browse File')]",driver);
       waitForElementVisible(element, driver, "Verify browser file button is visible");
//       WebElement browse = findElement("//input[@class='file-upload hide']",driver);
       FileUpload fileUpload = new FileUpload(driver); 
       String filepath = ResourceHelper.getResourcePath("\\DownloadedFiles\\"+ObjectReader.reader.getUserName()+".crt");
       fileUpload.fileUploadUsingInputType(uploadcertificate,filepath);
//       Thread.sleep(5000);
       
       if(driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).isDisplayed())
       {
          WebElement ele2 = findElement("//button[contains(text(),'Proceed')]",driver);
          click(ele2, driver, "clicking proceed button");
//          waitForElementNotVisible(loader, driver, "wait for page load");
       }

   }


    public void SelectinggenerateCertificate() throws Exception 
    { 
    	 WebElement elemnt =findElement("//*[contains(@class,'placeholder')][text()='Select Certificate']",driver);
    	 click(elemnt, driver, "Click on select certificate dropdown");
        WebElement ele = findElement("//div[contains(text(),'Generate Private Key and Certificate')]",driver);
       click(ele, driver, "Selecting Generate Private Key and Certificate");
        WebElement element = findElement("//a[@class='dropdown-button primary-button'][text()='Generate']",driver);
        click(element, driver, "Clicking on generate button");
        WebElement element1 = findElement("//a[contains(text(),'jks format')]",driver);
        click(element1, driver, "Select jks format");
        waitForElementNotVisible(loader, driver, "wait for page load");
        WebElement element2 = findElement("//button[contains(text(),'Proceed')]",driver);
       click(element2, driver, "clicking proceed button");
       waitForElementNotVisible(loader, driver, "wait for page load");
    }
    
    public void SelectinggenerateCertificatepkcs12format() throws Exception
    {
    	  WebElement element = findElement("//a[@class='dropdown-button primary-button'][text()='Generate']",driver);
          click(element, driver, "Clicking on generate button");
          WebElement element1 = findElement("//a[contains(text(),'pkcs12 format')]",driver);
          click(element1, driver, "Select pkcs12 format");
          waitForElementNotVisible(loader, driver, "wait for page load");
          WebElement element2 = findElement("//button[contains(text(),'Proceed')]",driver);
         click(element2, driver, "clicking proceed button");
         waitForElementNotVisible(loader, driver, "wait for page load");
    }
    public void selectingusername(String UserName) throws Exception
    {
    	 WebElement elemnt =findElement("//*[contains(@class,'placeholder')][text()='Select User']",driver);
    	 click(elemnt, driver, "Click on select user dropdown");
        WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+UserName+"')]"));
        click(ele, driver, "selecting username");
        waitForElementNotVisible(loader, driver, "wait for page load");

    }

    public String getSuccesMessageofImportfile(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();
    }

    public void waittillitappears(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ObjectReader.reader.getExplicitWait()));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(SuccessMessage,SuccessMessage.getText())));
    }

    public void ClickDownloadbutton() throws Exception
    {
    	 WebElement downloadButton = findElement("//I[contains(@class,'icon-download')]/ancestor::*[@type='button']",driver);
    	 click(downloadButton, driver, "Click on download button");
    	 waitForElementNotVisible(loader, driver, "wait for page load");
    }
        
    public void goingtoConfigurationpage() throws Exception{

        WebElement element = findElement("//a[contains(text(),'Configuration')]",driver);
        scrollPageToElement(driver,element);
        click(element, driver, "going to certificate page");
        waitForElementNotVisible(loader, driver, "wait for page load");
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

    public boolean VerifyUsageinUserlabel(){
        log.info("Verify at user label");
        logExtentReport("Delete generated certificate");
        WebElement element = driver.findElement(By.xpath("//div[@class='title-wrapper']"));
        return element.isDisplayed();
    }

    public void clickproceedbutton() {
        log.info("clicking proceed button");
        logExtentReport("clicking proceed button");
        WebElement element2 = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
        waitHelper.waitForElement(element2, ObjectReader.reader.getExplicitWait());
        element2.click();
    }
    
   

}
