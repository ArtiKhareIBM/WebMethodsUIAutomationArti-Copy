package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

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

import java.time.Duration;
import java.util.List;

public class AddNewScopepage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(AddNewScopepage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//input[@name='name']")
    @CacheLookup
    WebElement NameFieldelement;

    @FindBy(xpath = "//label[contains(text(),'Choose services to add as Service URLs')]")
    @CacheLookup
    WebElement AddnewScopeelement;




    public AddNewScopepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(AddnewScopeelement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("element is visible now.... and element text is  " +AddnewScopeelement.getText());


    }

    public void EnterNameForNewClient(String Name){
        log.info("Entering Name Scopename..."+Name);
        logExtentReport("Entering Name Scopename..."+Name);
        NameFieldelement.click();
        NameFieldelement.sendKeys(Name);

    }

    public void selectingScopeFromproject(String ProjectName) throws Exception{
        log.info("Selecting project for Scope"+ProjectName);
        logExtentReport("Entering Name Scopename..."+ProjectName);
        //Thread.sleep(2000);
        WebElement element = findElement("//div[contains(text(),'"+ProjectName+"')]/ancestor::div[@class='tree-node tree-branch']/div/span",driver);
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
    }

    public void selectingScopeFromServices(String Services,int index) throws Exception{
        log.info("Selecting Services for Scope"+Services);
        logExtentReport("Selecting Services for Scope"+Services);
      
        List<WebElement> element1 =findElements("//div[contains(text(),'"+Services+"')]/ancestor::div[@class='tree-node tree-branch']/div/span", driver);
//        Thread.sleep(2000);
        WebElement element = element1.get(index);
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
    }


    public void clickingcheckboxofrequiredService(String Services,int index) throws InterruptedException{
        log.info("click the check box"+Services);
        logExtentReport("click the check box"+Services);
        Thread.sleep(2000);
        List<WebElement> element1 = driver.findElements(By.xpath("//span[contains(text(),'"+Services+"')]/ancestor::div[@class='tree-context showBorder']/div/div/div[@class='custom-chbox fixed-radio-btn']/label"));
        //Thread.sleep(2000);
        WebElement element = element1.get(index);
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
    }

    public boolean VerifyAssociatebuttonenabled(){
        log.info("Verify Associate button enabled");
        logExtentReport("Verify Associate button enabled");
        WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-sm delete-btn-prmy primary-btn']"));
        return element.isEnabled();
    }


    public void ClickAssociatebutton(){
        log.info("Click Associate button");
        logExtentReport("Click Associate button");
        WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-sm delete-btn-prmy primary-btn']"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
    }

  public boolean ServicesAreIsVisible(String Services){
      log.info("Selecting Services for Scope"+Services);
      logExtentReport("Selecting Services for Scope"+Services);
      List<WebElement> element1 = driver.findElements(By.xpath("//div[contains(text(),'"+Services+"')]/ancestor::div[@class='tree-node tree-branch']/div/span"));;
      WebElement element = element1.get(1);
      return element.isDisplayed();
  }

  public void ClickAddButton(){
      log.info("click Add Button");
      logExtentReport("click Add Button");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-danger btn-sm delete-btn-prmy primary-btn']")));
      waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
      element.click();
  }
 public boolean Errormsgforinvalidletter() throws Exception{
     log.info("Validate the error message ");
     logExtentReport("Validate the error message ");
     WebElement Element =findElement("//*[contains(@class,'error-validation-icon')]/following-sibling::*/*[text()='error']/following-sibling::*[text()=': You have entered an invalid OAuth Scope name: Illegal character @']",driver);
     return Element.isDisplayed();
 }




    //div[contains(text(),'Default')]/ancestor::div[@class='tree-node tree-branch']/div/span/i

    //div[contains(text(),'Flow Services')]/ancestor::div[@class='tree-node tree-branch']/div/span/i


    //span[contains(text(),'AddInt')]/ancestor::div[@class='tree-context showBorder']/div/div/div[@class='custom-chbox fixed-radio-btn']
}
