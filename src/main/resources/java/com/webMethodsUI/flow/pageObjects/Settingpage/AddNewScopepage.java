package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

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

import java.util.List;

public class AddNewScopepage {
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

    public void selectingScopeFromproject(String ProjectName){
        log.info("Selecting project for Scope"+ProjectName);
        logExtentReport("Entering Name Scopename..."+ProjectName);
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+ProjectName+"')]/ancestor::div[@class='tree-node tree-branch']/div/span"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
    }

    public void selectingScopeFromServices(String Services,int index){
        log.info("Selecting Services for Scope"+Services);
        logExtentReport("Selecting Services for Scope"+Services);
        List<WebElement> element1 = driver.findElements(By.xpath("//div[contains(text(),'"+Services+"')]/ancestor::div[@class='tree-node tree-branch']/div/span"));;
        WebElement element = element1.get(index);
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
    }


    public void clickingcheckboxofrequiredService(String Services,int index){
        log.info("click the check box"+Services);
        logExtentReport("click the check box"+Services);
        List<WebElement> element1 = driver.findElements(By.xpath("//span[contains(text(),'"+Services+"')]/ancestor::div[@class='tree-context showBorder']/div/div/div[@class='custom-chbox fixed-radio-btn']/label"));
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
      WebDriverWait wait = new WebDriverWait(driver, 10);
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-danger btn-sm delete-btn-prmy primary-btn']")));
      waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
      element.click();
  }
 public boolean Errormsgforinvalidletter(){
     log.info("Validate the error message ");
     logExtentReport("Validate the error message ");
     WebElement Element = driver.findElement(By.xpath("//span[@class='error-validaion-text']/span"));
     return Element.isDisplayed();
 }




    //div[contains(text(),'Default')]/ancestor::div[@class='tree-node tree-branch']/div/span/i

    //div[contains(text(),'Flow Services')]/ancestor::div[@class='tree-node tree-branch']/div/span/i


    //span[contains(text(),'AddInt')]/ancestor::div[@class='tree-context showBorder']/div/div/div[@class='custom-chbox fixed-radio-btn']
}
