package com.webMethodsUI.flow.pageObjects.PredefinedConnector;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkSpanAccountpage extends CommonActions
{
    WebDriver driver;
    private Logger log = LogManager.getLogger(WorkSpanAccountpage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//input[@aid='Client ID']")
    @CacheLookup
    WebElement ClientID;

    @FindBy(xpath = "//input[@aid='Client Secret']")
    @CacheLookup
    WebElement ClientSecret;

    @FindBy(xpath = "//input[@aid='Domain']")
    @CacheLookup
    WebElement Domain;

    @FindBy(xpath = "//h1[contains(text(),'Account')]")
    @CacheLookup
    WebElement AccountPageTitle;
   
    

     public WorkSpanAccountpage(WebDriver driver)
     {
         super();
         this.driver = driver;
         PageFactory.initElements(driver, this);
         log.info("WorkSpan account page object created");
         logExtentReport("WorkSpan account page object created");
     }

    public void EnteringClientID(String clientID) throws Exception{
        enterValue(ClientID, clientID, driver, "Entering ClientID ... " + clientID);
    }

    public void EnteringClientsecret(String clientsecret) throws Exception{
      enterValue(ClientSecret, clientsecret, driver, "Entering clientsecret... " + clientsecret);
    }

    public void EnteringDomain(String domain) throws Exception{
    	enterValue(Domain, domain, driver, "Entering Domain. " + domain);
    }
    
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    @CacheLookup
    WebElement Addbutton;
    
    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;
    
    public String loader = "//div[contains(@class,'circle-clipper left')]/div[@class='circle']";

    public void ClickingAddbutton() throws Exception
    {
    	 click(Addbutton, driver, "Clicking Add button");
         elementContainsText(SuccessMessage,"Account saved successfully.", driver, "Wait for Account created successfully mesage to visible");
         waitForElementNotVisible(loader, driver, "wait for page load");
    }
}
