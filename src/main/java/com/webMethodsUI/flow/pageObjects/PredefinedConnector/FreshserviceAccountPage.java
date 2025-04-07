package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.webMethodsUI.flow.testbase.CommonActions;

import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;

public class FreshserviceAccountPage extends CommonActions {
    WebDriver driver;
//    private Logger log = LogManager.getLogger(FreshserviceAccountPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//input[@aid='Account Name']")
    @CacheLookup
    WebElement AccountNamefield;
    
    String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

    public FreshserviceAccountPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        //  waitHelper.waitForElement(AccountPageTitle, ObjectReader.reader.getExplicitWait());
    }
    public FreshserviceAccountPage ClickingAddbutton() throws Exception{

        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Add");
        return new FreshserviceAccountPage(driver);
    }
/*    public void PassAccountNameForFreshservice(String AccountName){
      //  WebElement element = driver.findElement(By.xpath("//input[@aid='Account Name']"));
       // element.click();
      //  element.clear();
      //  element.sendKeys(Accountname);
        clearAndEnterText(AccountNamefield, AccountName, driver, "Entering passWord.." + AccountName);
        waitForElementNotVisible(loader, driver, "wait for page load");
    }  */

    public void PassUsernameForFreshservice(String Username){
        WebElement element = driver.findElement(By.xpath("//input[@name='Username']"));
        element.click();
        element.sendKeys(Username);
    }

    public void PassPasswordForFreshservice(String Password){
        WebElement element = driver.findElement(By.xpath("//input[@name='Password']"));
        element.click();
        element.sendKeys(Password);
    }

    public void PassServerurlForFreshservice(String Serverurl){
        WebElement element = driver.findElement(By.xpath("//input[@aid='Server URL']"));
        element.click();
        element.clear();
        element.sendKeys(Serverurl);
    }
    
}