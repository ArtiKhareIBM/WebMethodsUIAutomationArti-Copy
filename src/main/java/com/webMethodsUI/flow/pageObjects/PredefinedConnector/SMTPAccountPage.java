package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SMTPAccountPage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(SMTPAccountPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h4[contains(text(),'Account')]")
    @CacheLookup
    WebElement AccountPageTitle;

    @FindBy(xpath = "//input[@name='name']")
    @CacheLookup
    WebElement AccountNameField;

    @FindBy(xpath = "//input[@name='cn_host']")
    @CacheLookup
    WebElement HostNameField;

    @FindBy(xpath = "//input[@name='cn_userName']")
    @CacheLookup
    WebElement Usernamefield;


    @FindBy(xpath = "//input[@name='cn_password']")
    @CacheLookup
    WebElement passwordfield;


    @FindBy(xpath = "//input[@name='cn_port']")
    @CacheLookup
    WebElement portField;

    @FindBy(xpath = "//input[@name='cx_from']")
    @CacheLookup
    WebElement fromfield;

    @FindBy(xpath = "//input[@name='cx_to']")
    @CacheLookup
    WebElement Tofield;

    public String AddAccountloader = "//*[text()='Add Account']/ancestor::div/following-sibling::div//*[@class='spinner']";



    public SMTPAccountPage(WebDriver driver) throws Exception{
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        log.info("SMTP account page obejct created");
        logExtentReport("SMTP account page obejct created");
        waitForElementVisible(AccountPageTitle, driver, "Wait for account paget title is visible");
    }

    public void EnteringAccountName(String AccountName) throws Exception
    {
        clearAndEnterText(AccountNameField, AccountName, driver, "entering AccountName" + AccountName);
    }
    
    public void EnteringHostValue(String HostValue) throws Exception
    {
        clearAndEnterText(HostNameField, HostValue, driver, "entering HostValue" + HostValue);
    }

    public void EnteringUsername(String UserName) throws Exception
    {

        clearAndEnterText(Usernamefield, UserName, driver, "entering UserName" + UserName);
    }

    public void EnteringPassword(String password) throws Exception
    {

        clearAndEnterText(passwordfield, password, driver, "entering password" + password);
    }

    public void Enteringportvalue(String portValue) throws Exception
    {
        clearAndEnterText(portField, portValue, driver, "entering password" + portValue);
    }

    public void EnteringFromfield(String Fromfield) throws Exception
    {
        clearAndEnterText(fromfield, Fromfield, driver, "entering Fromfield" + Fromfield);
    }

    public void Enteringtofield(String tofield) throws Exception
    {
        clearAndEnterText(Tofield, tofield, driver, "entering Tofield" + tofield);
    }
    
    public void clickAddButton() throws Exception
    {
    	WebElement element = findElement("//button[contains(text(),'Add')]",driver);
		click(element,driver,"Clicking on Add Button.. ");
		waitForElementNotVisible(AddAccountloader, driver, "wait for page load",45);
		Thread.sleep(5000);

    }
}
