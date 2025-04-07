package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddAccountPage;
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

public class ClientCertificateConfigurationpage {


    WebDriver driver;
    private Logger log = LogManager.getLogger(ClientCertificateConfigurationpage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//span[contains(text(),'Two-way SSL Security Mode')]")
    @CacheLookup
    WebElement configurationheading;

    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down ']")
    @CacheLookup
    WebElement securitymodedropdown;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    @CacheLookup
    WebElement Applybutton;

    @FindBy(xpath = "//span[@class='delite-icon dlt-icon-chevron-right tab ']")
    @CacheLookup
    WebElement certificateexpandicon;


    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
    @CacheLookup
    WebElement Proceedbutton;


    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    @CacheLookup
    WebElement Cancelbutton;


    public ClientCertificateConfigurationpage(WebDriver driver) {

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(configurationheading, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("element is visible now.... and element text is  " + configurationheading.getText());


    }

    public void SelectSecuritymode(String Link) {
        log.info("Clicking drop down");
        logExtentReport("Clicking drop down");
        securitymodedropdown.click();
        log.info("Clicking link" + Link);
        logExtentReport("Clicking link" + Link);
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + Link + "')]"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();


    }

    public TenantCertificatepage goingtotenentCertificatepage() {
        log.info("click expnandicon");
        logExtentReport("click expnandicon");
        certificateexpandicon.click();
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Tenant certificate')]"));
        element.click();
        return new TenantCertificatepage(driver);
    }

    public UserCertificatepage goingtoUserCertificatepage() {
        log.info("click expnandicon");
        logExtentReport("click expnandicon");
        certificateexpandicon.click();
        WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'User certificate')]"));
        element1.click();
        return new UserCertificatepage(driver);
    }

    public void ApplyProceedbutton() {
        log.info("click Apply button");
        logExtentReport("click Apply button");
        waitHelper.waitForElement(Applybutton, ObjectReader.reader.getExplicitWait());
        Applybutton.click();
        log.info("click Proceed button");
        logExtentReport("click Proceed button");
        waitHelper.waitForElement(Proceedbutton, ObjectReader.reader.getExplicitWait());
        Proceedbutton.click();
    }


    public boolean ApplybuttonVisible() {
        log.info("verify Apply button is visible");
        logExtentReport("verify Apply button is visible");
        return Applybutton.isDisplayed();
    }

    public boolean CancelbuttonVisible() {
        log.info("verify Cancel button is visible");
        logExtentReport("verify Cancel button is visible");
        return Cancelbutton.isDisplayed();
    }


    public String getSuccesMessageofImportfile() {
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();
    }

    public boolean ClientCertificateIsVisible() {
        log.info("verify Client Certificate is visible");
        logExtentReport("verify Client Certificate button is visible");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Client certificate')]"));
        return element.isDisplayed();
    }

    public boolean UsageMessgae() {
        log.info("verify usage information visible");
        logExtentReport("verify usage information is visible");
        WebElement element = driver.findElement(By.xpath("//div[@class='inline-message']"));
        return element.isDisplayed();
    }

    public boolean Verfifylistsof2sslmodes() {
        log.info("verify the lists  visible in dropdowns");
        logExtentReport("verify the lists  visible in dropdowns");
        securitymodedropdown.click();
        WebElement element1 = driver.findElement(By.xpath("//li[@class='search-list']"));
        return element1.isDisplayed();
    }

    public boolean VerifyTenantlevelUserlevel() {
        log.info("verify the tenant level and userlevel is  visible ");
        logExtentReport("verify the tenant level and userlevel is  visible");
        certificateexpandicon.click();
        WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'User certificate')]/parent::li"));
        return element1.isDisplayed();

    }

    public void waittillitappears() {
        WebDriverWait wait = new WebDriverWait(driver, ObjectReader.reader.getExplicitWait());
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(SuccessMessage, SuccessMessage.getText())));
    }

    public void expandicon() {
        certificateexpandicon.click();
    }


    public boolean OauthIsVisible() {
        log.info("verify OAuth 2.0 is visible");
        logExtentReport("verify OAuth 2.0 button is visible");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'OAuth 2.0')]"));
        return element.isDisplayed();
    }
}