package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectorsHomepage extends CommonActions{
    WebDriver driver;
    
    private Logger log = LogManager.getLogger(ConnectorsHomepage.class);

    @FindBy(xpath = "//span[contains(text(),'Predefined Connectors')]")
    @CacheLookup
    WebElement HomePageGrconnectorPageTitle;

    @FindBy(xpath = "//input[@class='search-box-input' and @xpath='1']")
    @CacheLookup
    WebElement Createdapplicationsearchfield;

    @FindBy(xpath = "//div[@class='search-box ']/input[@class='search-box-input' ]")
    @CacheLookup
    WebElement applicationsearchfield;

    @FindBy(xpath = "//span[@class='predefined-search-icon delite-icon dlt-icon-search']")
    @CacheLookup
    WebElement Searchicon;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;

    @FindBy(xpath = "//span[@class='predefined-inner-accounts-title truncate']")
    @CacheLookup
    WebElement VerifyAccountName;


    public ConnectorsHomepage(WebDriver driver) throws Exception {

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

         log.info("Connectors HomePage object created");
        logExtentReport("Connectors HomePage object created");
        waitForElementVisible(HomePageGrconnectorPageTitle, driver, "Verify predefined connectors Header is visible");
    }

    public AccountPage Addaccount(String ApplicationName) throws Exception 
    {
        ClickSearchicon();
        click(applicationsearchfield, driver, "Click on search field");
        enterValue(applicationsearchfield,ApplicationName,driver,"Entering Application Name...." + ApplicationName);	
        WebElement element = findElement("//div[contains(@class,'connector-list')]//span[contains(text(),'"+ ApplicationName +"')]",driver);
        click(element, driver, "clicking Application Name...." + ApplicationName);
       
        return new AccountPage(driver);
    }

    public void ClickSearchicon() throws Exception
    {
        log.info("clicking on Search icon");
        logExtentReport("clicking on Search icon");
           click(Searchicon, driver, "Clicked on search icon");
           
//        catch (Exception e) {
//            WebElement ele = driver.findElement(By.xpath("//span[@class='icon-chevron dlt-icon-chevron-double-left']"));
//            ele.click();
//            Searchicon.click();
//            log.info("clicked on Searchicon");
//            logExtentReport("clicked on Searchicon");
//        }
    }
    
    public String loader = "//div[contains(@class,'circle-clipper left')]/div[@class='circle']";
    
    public void DeleteAccount(String AccountName) throws Exception
    {
    	WebElement accountNameElement = findElement("//div/span[contains(text(),'"+AccountName+"')]",driver);
		mousehover(accountNameElement, driver, "Mouse hover on Account Name");
        //WebElement element = findElement("//span[contains(text(),'"+AccountName+"')]/parent::div/following-sibling::div[contains(@class,'predefined-options')]/span[3][@title='Delete']",driver);
        WebElement element = findElement("//span[@title='Delete']",driver);
        click(element, driver, "Click on delete icon");  
        element = findElement("//button[contains(text(),'Delete')]",driver);
        click(element, driver, "Click on delete button");
        elementContainsText(SuccessMessage, "Account deleted successfully.", driver, "Wait for Account deleted successfully mesage to visible");
        waitForElementNotVisible(loader, driver, "wait for page load");
    }

    public String getSuccesMessage() throws Exception
    {
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        //elementContainsText(SuccessMessage,"Account saved successfully.", driver, "Wait for Account saved successfully message to visible");
//        waitForElementNotVisible(loader, driver, "wait for page load");
        waitForElementVisible(SuccessMessage,driver,"Wait for Account saved successfully message to visible");
        elementContainsText(SuccessMessage,"Account saved successfully.", driver, "Wait for Account saved successfully message to visible");
        System.out.println(SuccessMessage.getText());
        return SuccessMessage.getText();
    }

    public String getCreatedAccountName() throws Exception
    {
        log.info("VerifyAccountName....");
        logExtentReport("VerifyAccountName....");
        waitForElementVisible(VerifyAccountName, driver, "Wait for Account Name to visible");
        return VerifyAccountName.getText();
    }

    public void clickOnapplicontiondetailicon(String ApplicationName) throws Exception
    {
        WebElement element = findElement("//span[@title='"+ApplicationName+"']/parent::div/span[@class='delite-icon dlt-icon-chevron-down icon-chevron-down']",driver);
        click(element, driver, "click on detailicon....");
    }

    public AccountPage EditAccount(String AccountName) throws Exception
    {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = findElement("//span[contains(text(),'"+AccountName +"')]/parent::div/div[1]/span[@class='edit-pencil-icon delite-icon dlt-icon-edit']",driver);
        click(element, driver, "click on editicon");
        return new AccountPage(driver);

    }

    public String getConnectorsTitle() {
        log.info("element is visible now....");
        logExtentReport(
                "element is visible now.... and element text is  " + HomePageGrconnectorPageTitle.getText());

        return HomePageGrconnectorPageTitle.getText();

    }

    public boolean VerifyAccountpresent(String ApplicationName) throws Exception{
        log.info("Verifying Status");
        logExtentReport("Verifying Status");
        WebElement element = findElement("//span[@title='"+ApplicationName+"']/ancestor::div[@class='col s3']/following-sibling::div[1]/span[contains(text(),'1 Account configured')]",driver);
        boolean status = element.isDisplayed();
        return status;
    }

    public String VerifyemptyAccountmessgae(String ApplicationName) throws Exception{
        log.info("Verifying Status");
        logExtentReport("Verifying Status");
        WebElement element = findElement("//input[@class='search-box-input']",driver);
        enterValue(element, ApplicationName, driver, "Entering Application");
        WebElement element1 = findElement("//span[contains(text(),'No Accounts Yet!')]",driver);
      
        return element1.getText();

    }

    public void AddaccountforConnectors(String ApplicationName) throws Exception 
    {
        ClickSearchicon();

        click(applicationsearchfield, driver, "clicking on Searchfield");

        enterValue(applicationsearchfield, ApplicationName, driver, "Entering Application..." + ApplicationName);
        
        WebElement element = findElement("//span[@class='connector-label truncate']",driver);
        click(element, driver, "clicking Application..." + ApplicationName);
    }


}
