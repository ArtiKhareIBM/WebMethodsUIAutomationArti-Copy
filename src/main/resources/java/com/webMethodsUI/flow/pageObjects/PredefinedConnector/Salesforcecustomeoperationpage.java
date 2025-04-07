package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceCanvasPage;
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

public class Salesforcecustomeoperationpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(Salesforcecustomeoperationpage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//h1[@class='inline-block']")
    @CacheLookup
    WebElement OperationTitlepage;

    @FindBy(xpath = "//input[@aid='Name']")
    @CacheLookup
    WebElement OperationNameField;

    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down ']")
    @CacheLookup
    WebElement Accountfield;

    @FindBy(xpath = " //textarea[@aid='Description']")
    @CacheLookup
    WebElement Descriptionfield;


    @FindBy(xpath = "//input[@class='inputElement filled']")
    @CacheLookup
    WebElement Authorizationfield;







    //button[contains(text(),'Done')]


    public Salesforcecustomeoperationpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(OperationTitlepage, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");

    }


    public void EnteringOperationName(String OperationName){
        log.info("entering OperationName" + OperationName );
        logExtentReport("entering OperationName"+ OperationName  );
        OperationNameField.click();
        OperationNameField.sendKeys(OperationName);

    }
    public void selectAuthrizationType(String authType) {

        try {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(Authorizationfield,0);
            genericHelper.selectDropDownLink(authType);
            log.info("Clicked on auth type....");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void ClickingNextbutton(){
        try {
            WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
            WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait() );
            wait.until(ExpectedConditions.elementToBeClickable(element));
            //element.click();
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Next");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void selectingAccount(int index,String AccountName) {

        try {
            List<WebElement> elemntArray = driver
                    .findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
            log.info("All input parameters are....." + elemntArray);
            WebElement element = elemntArray.get(index);

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element,0);
            genericHelper.selectDropDownLink(AccountName);
            log.info("Clicked on AccountName....");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
  public void clickingOperationType(String Operationtype){
      log.info("clicking Operationtype"+ Operationtype );
      logExtentReport("clicking Operationtype"+ Operationtype);
      WebElement element = driver.findElement(By.xpath("//label[@for='"+Operationtype+"']"));
      waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
      element.click();

  }

    public void selectingBusinessObject(String BusinessObject){
        log.info("clicking BusinessObject"+ BusinessObject );
        logExtentReport("clicking BusinessObject"+ BusinessObject);
        WebElement element = driver.findElement(By.xpath("//span[@class='radio-btn-label-text'][contains(text(),'"+ BusinessObject +"')]/parent::label"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();

    }

    public FlowServiceCanvasPage ClickingDonebutton() throws Exception{
        try {
            WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Done')]"));
            WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait() );
            wait.until(ExpectedConditions.elementToBeClickable(element));
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Done");
            return new FlowServiceCanvasPage(driver);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new FlowServiceCanvasPage(driver);
        }

    }

    public void Descriptionfield(String Description){
        log.info("Entering Description"+Description );
        logExtentReport("Entering Description"+Description);
        Descriptionfield.click();
        Descriptionfield.sendKeys(Description);
    }

    public void checkthecheckbox(){
        log.info("check the check box");
        logExtentReport("check the check box");
        WebElement ele = driver.findElement(By.xpath("//label[@class='new-checkbox-label']"));
        waitHelper.waitForElement(ele, ObjectReader.reader.getExplicitWait());
        ele.click();
    }


}
