package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceCanvasPage;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.flow.testbase.CommonActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class FreshserviceCustomOperationPage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(FreshserviceCustomOperationPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//input[@aid='Name']")
    @CacheLookup
    WebElement OperationNameField;
    
    @FindBy(xpath = "//button[contains(text(),'Attachments')]")
	@CacheLookup
	WebElement AddButtonElement;

    public FreshserviceCustomOperationPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        //  waitHelper.waitForElement(AccountPageTitle, ObjectReader.reader.getExplicitWait());
    }

    public void selectingAccount(String AccountName) {

        try {
            // List<WebElement> elemntArray = driver
            //          .findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
            WebElement element1 = driver.findElement(By.xpath("//div[contains(text(),'Please Select')]"));
            log.info("All input parameters are....." + element1);

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element1, 0);
            genericHelper.selectDropDownLink(AccountName);
            log.info("Clicked on AccountName....");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void EnteringOperationName(String OperationName1){
        log.info("entering OperationName" + OperationName1 );
        logExtentReport("entering OperationName"+ OperationName1  );
        OperationNameField.click();
        OperationNameField.sendKeys(OperationName1);

    }

    public void ClickingNextbutton() {
        try {
            WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ObjectReader.reader.getExplicitWait()) );
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

    public void clickingOperationType(String Operationtype1){
        log.info("clicking Operationtype"+ Operationtype1 );
        logExtentReport("clicking Operationtype"+ Operationtype1);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+Operationtype1+"')]"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();

    }

    public void clickingAttachement() throws Exception {
        //TestBase.logExtentReport("clicking Attachement button");
        WebElement element = findElement("//button[contains(text(),'Attachments')]",driver);
        click(element, driver, "clicking Attachement button");
        
    }
   

	public void clickAddbutton() {
        logExtentReport("clicking Add button");
        WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm save-btn btn-add-icon right']"));
        element.click();
    }

    public void PassTheValue(int i, String Namevalue) throws InterruptedException {
        //log.info("passing the name value" +Namevalue);
        // TestBase.logExtentReport("passing the name value");
        List<WebElement> ele = driver.findElements(By.xpath("//div[@class='col s2 pos-relative']/span/input[@class='input-select']"));
        WebElement ele1 = ele.get(i);
        Actions action = new Actions(driver);
        action.moveToElement(ele1).perform();
        List<WebElement> ele2 = driver.findElements(By.xpath("//i[@class='dd-icons dd-edit-icon icon-mr mrm']"));
        WebElement pencilicon= ele2.get(i);
        pencilicon.click();
        ele1.click();
        ele1.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        log.info("passing the name value" +Namevalue);
        logExtentReport("passing the name value" +Namevalue);
        ele1.sendKeys(Namevalue);
        log.info("passed the name value" +Namevalue);
        logExtentReport("passed the name value" +Namevalue);
        Thread.sleep(3000);
    }
    public void selectingType(String Typevalue) {

        try {
            WebElement elem1 = driver.findElement(By.xpath("//div[contains(text(),'Select Type')]"));
            log.info("All input parameters are....." + elem1);

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(elem1, 0);
            genericHelper.selectDropDownLink(Typevalue);
            log.info("Clicked on Type value....");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public FlowServiceCanvasPage ClickingDonebutton() throws Exception{
        try {
            WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Done')]"));
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ObjectReader.reader.getExplicitWait()) );
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
}
