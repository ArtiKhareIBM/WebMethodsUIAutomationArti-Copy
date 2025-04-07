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

public class SFTPAccountpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(SFTPAccountpage.class);

    @FindBy(xpath = "//h4[contains(text(),'Account')]")
    @CacheLookup
    WebElement AccountPageTitle;

    @FindBy(xpath = "//input[@name='name']")
    @CacheLookup
    WebElement AccountNameField;

    @FindBy(xpath = "//input[@name='hostName']")
    @CacheLookup
    WebElement HostNameField;

    @FindBy(xpath = "//input[@name='userName']")
    @CacheLookup
    WebElement Usernamefield;
    
    @FindBy(xpath = "//input[@name='port']")
    @CacheLookup
    WebElement Port;


    @FindBy(xpath = "//input[@name='password']")
    @CacheLookup
    WebElement passwordfield;


	public String AddAccountloader = "//*[text()='Add Account']/ancestor::div/following-sibling::div//*[@class='spinner']";


    public SFTPAccountpage(WebDriver driver) throws Exception{
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        log.info("SFTP Page object created");
        logExtentReport("SFTP Page object created");
        waitForElementVisible(AccountPageTitle, driver, "Wait for sgtp account page to be visible");
        
    }
    
    public void EnteringAccountName(String AccountName) throws Exception
    {
    	clearAndEnterText(AccountNameField, AccountName, driver, "entering AccountName" + AccountName );
    }
    
    public void EnteringPort(String PORT) throws Exception
    {
        clearAndEnterText(Port, PORT, driver, "entering PORT" + PORT );
    }
    
    public void EnteringHostValue(String HostValue) throws Exception
    {
        enterValue(HostNameField, HostValue, driver, "entering Host name" + HostValue);
    }

    public void EnteringUsername(String UserName) throws Exception
    {        
        enterValue(Usernamefield, UserName, driver, "entering UserName" + UserName);
    }

    public void EnteringPassword(String password) throws Exception
    {
        clearAndEnterText(passwordfield, password, driver, "entering password" + password);
    }
    
    public void clickAddButton() throws Exception
    {
    	WebElement element = findElement("//button[contains(text(),'Add')]",driver);
		click(element,driver,"Clicking on Add Button.. ");
		waitForElementNotVisible(AddAccountloader, driver, "wait for page load",45);
		Thread.sleep(5000);

    }
    

}
