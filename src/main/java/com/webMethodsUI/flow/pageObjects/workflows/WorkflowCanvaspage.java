package com.webMethodsUI.flow.pageObjects.workflows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class WorkflowCanvaspage extends CommonActions{

    private WebDriver driver;
    private Logger log = LogManager.getLogger(WorkflowCanvaspage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//span[@class='switch-label default']")
    @CacheLookup
    WebElement workflowcanvaspageelement;

    @FindBy(xpath = "//input[@id='focusOn']")
    @CacheLookup
    WebElement SearchField;

    @FindBy(xpath = "//button[@class='btn btn-primary save_flow_btn right primary-btn']")
    @CacheLookup
    WebElement Savebutton;

    @FindBy(xpath = "//i[@class='run-play-icon']")
    @CacheLookup
    WebElement Runbutton;

    @FindBy(xpath = " //i[@class='flow-icons add-title-pencil mrs delite-icon dlt-icon-edit icons8 ']")
    @CacheLookup
    WebElement EditworkflowNamepencilicon;

    @FindBy(xpath = "//i[@class='flow-icons material-icons delite-icon dlt-icon-chevron-left icons8']")
    @CacheLookup
    WebElement Backarrowbutton;

    //button[@class='btn btn-primary save_flow_btn right primary-btn']
    @FindBy(xpath = "//span[@class='activity-tick icons8-test-check']")
    @CacheLookup
    WebElement VerifyActiontickmark;

    @FindBy(xpath = "//span[contains(text(),'UrSopConnector')]")
    @CacheLookup
    WebElement soapconnectorimage;

    @FindBy(xpath = "//span[contains(text(),'RESTApiConnector')]")
    @CacheLookup
    WebElement restconnectorimage;

    @FindBy(xpath = "//span[contains(text(),'Swagger - Open API')]")
    @CacheLookup
    WebElement apiimage;

    @FindBy(xpath = "//span[contains(text(),'OnPremFlowService')]")
    @CacheLookup
    WebElement onpremimage;

    @FindBy(xpath = "//span[@class='material-icons']")
    @CacheLookup
    WebElement AccountCreation;

    public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

    public String WorkFlowCreatedMessage = "//*[contains(text(),'Workflow saved.')]";


    public WorkflowCanvaspage(WebDriver driver){
        super();
        this.driver = driver;

        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(workflowcanvaspageelement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("Build your workflow  Object created");
    }

    public void DragAPISeviceanddrop(String ServiceName) throws InterruptedException{
        log.info("Search the Service" +ServiceName);
        logExtentReport("Search the Service" +ServiceName);
        SearchField.click();
        SearchField.sendKeys(ServiceName);
        Thread.sleep(3000);
        waitHelper.waitForElement(apiimage, ObjectReader.reader.getExplicitWait());
        log.info("Draging the Service" +ServiceName);
        logExtentReport("Draging the Service" +ServiceName);
        WebElement Source = driver.findElement(By.xpath("//span[@title='"+ServiceName+"']"));
        WebElement Target = driver.findElement(By.xpath("//p[contains(text(),'Drag connectors on the canvas from the right panel')]"));
        waitHelper.waitForElement(Source, ObjectReader.reader.getExplicitWait());
        Actions action = new Actions(driver);
        action.clickAndHold(Source).moveToElement(Target).release().build().perform();
        log.info("Dropped Success fully");
        logExtentReport("Dropped Success fully" );
    }


    public void DragOnPremSeviceanddrop(String ServiceName) throws InterruptedException{
        log.info("Search the Service" +ServiceName);
        logExtentReport("Search the Service" +ServiceName);
        SearchField.click();
        SearchField.sendKeys(ServiceName);
        Thread.sleep(3000);
        waitHelper.waitForElement(onpremimage, ObjectReader.reader.getExplicitWait());
        log.info("Draging the Service" +ServiceName);
        logExtentReport("Draging the Service" +ServiceName);
        WebElement Source = driver.findElement(By.xpath("//span[@title='"+ServiceName+"']"));
        WebElement Target = driver.findElement(By.xpath("//p[contains(text(),'Drag connectors on the canvas from the right panel')]"));
        waitHelper.waitForElement(Source, ObjectReader.reader.getExplicitWait());
        Actions action = new Actions(driver);
        action.clickAndHold(Source).moveToElement(Target).release().build().perform();
        log.info("Dropped Success fully");
        logExtentReport("Dropped Success fully" );
    }

    public void DragRestSeviceanddrop(String ServiceName) throws InterruptedException{
        log.info("Search the Service" +ServiceName);
        logExtentReport("Search the Service" +ServiceName);
        SearchField.click();
        SearchField.sendKeys(ServiceName);
        Thread.sleep(3000);
        waitHelper.waitForElement(restconnectorimage, ObjectReader.reader.getExplicitWait());
        log.info("Draging the Service" +ServiceName);
        logExtentReport("Draging the Service" +ServiceName);
        WebElement Source = driver.findElement(By.xpath("//span[@title='"+ServiceName+"']"));
        WebElement Target = driver.findElement(By.xpath("//p[contains(text(),'Drag connectors on the canvas from the right panel')]"));
        waitHelper.waitForElement(Source, ObjectReader.reader.getExplicitWait());
        Actions action = new Actions(driver);
        action.clickAndHold(Source).moveToElement(Target).release().build().perform();
        log.info("Dropped Success fully");
        logExtentReport("Dropped Success fully" );
    }


    public void DragSoapSeviceanddrop(String ServiceName) throws Exception{

        enterValue(SearchField,ServiceName,driver,"Search the Service" +ServiceName);
        waitForElementVisible(soapconnectorimage,driver,"Wait for soap connector image visible.. "+soapconnectorimage);
        log.info("Draging the Service" +ServiceName);
        logExtentReport("Draging the Service" +ServiceName);
        WebElement Source = driver.findElement(By.xpath("//span[@title='"+ServiceName+"']"));
        WebElement Target = driver.findElement(By.xpath("//p[contains(text(),'Drag connectors on the canvas from the right panel')]"));
        waitForElementVisible(soapconnectorimage,driver,"Wait for element visible.. "+Source);
        Actions action = new Actions(driver);
        action.clickAndHold(Source).moveToElement(Target).release().build().perform();
        log.info("Dropped Success fully");
        logExtentReport("Dropped Success fully" );
    }


    public void DragSoapCommonSeviceanddrop(String ServiceName, String ConnectorName) throws Exception{

        enterValue(SearchField,ServiceName,driver,"Search the Service" +ServiceName);
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+ConnectorName+"')]"));
        waitForElementVisible(ele,driver,"Wait for soap connector image visible.. "+ConnectorName);
        log.info("Draging the Service" +ServiceName);
        logExtentReport("Draging the Service" +ServiceName);
        WebElement Source = driver.findElement(By.xpath("//span[@title='"+ServiceName+"']"));
        WebElement Target = driver.findElement(By.xpath("//p[contains(text(),'Drag connectors on the canvas from the right panel')]"));
        waitForElementVisible(ele,driver,"Wait for element visible.. "+Source);
        Actions action = new Actions(driver);
        action.clickAndHold(Source).moveToElement(Target).release().build().perform();
        log.info("Dropped Success fully");
        logExtentReport("Dropped Success fully" );
    }


    public void mappingthecontainer(String ServiceName) throws Exception{
        WebElement ele = driver.findElement(By.xpath("//div[@data-eventmap='metadata-clickedActivity- ("+ServiceName+")']"));
        WebElement Source = driver.findElement(By.xpath("//div[@data-eventmap='metadata-clickedActivity- ("+ServiceName+")']//parent::div/div[4]/span//*[name()='svg']//*[name()='circle']"));
        WebElement Target = driver.findElement(By.xpath("//div[@data-eventmap='stop-activity']"));
        click(ele, driver, "Click on element.. "+ele);
        waitForElementVisible(Source,driver,"Wait for element is visible.. "+Source);
        Actions action = new Actions(driver);
        action.clickAndHold(Source).moveToElement(Target).release().build().perform();
        log.info("Mapped Success fully");
        logExtentReport("Mapped Success fully" );
    }

    public void gotoServiceActionpage(String ServiceName) throws Exception
    {
        WebElement ele = findElement("//div[@data-eventmap='metadata-clickedActivity- ("+ServiceName+")']",driver);
        doubleClick(ele, driver, "Click on Action page");
        waitForElementNotVisible(loader, driver, "wait for page load");
        waitForElementNotVisible(loader, driver, "wait for page load");
    }

    public EditworkflowName editworkflowname() throws Exception
    {
        click(EditworkflowNamepencilicon, driver, "Click on edit pencil icon");
        return new EditworkflowName(driver);
    }

     public void Savebutton() throws Exception{
         click(Savebutton, driver, "Click on WorkFlow Save button");
//         WebElement element = findElement(WorkFlowCreatedMessage,driver);
// 		 elementContainsText(element,"Workflow saved.",driver,"Verify WorkFlow saved message is visible");
 		 waitForElementNotVisible(loader, driver, "wait for page load");
     }

     public void runbutton() throws Exception{
         click(Runbutton, driver, "Click on Run button");
         waitForElementNotVisible(loader, driver, "wait for page load");
     }

     public WorkflowsPage bacckArrowicon() throws Exception
     {
         click(Backarrowbutton, driver, "Click on back button");
         waitForElementNotVisible(loader, driver, "wait for page load");
        return new WorkflowsPage(driver);
     }

     public boolean verifyServiceaction(){
         log.info("Verify Activity tab...");
         logExtentReport("Verify Activity tab...");
         boolean result = VerifyActiontickmark.isDisplayed();
         return result;
     }


}
