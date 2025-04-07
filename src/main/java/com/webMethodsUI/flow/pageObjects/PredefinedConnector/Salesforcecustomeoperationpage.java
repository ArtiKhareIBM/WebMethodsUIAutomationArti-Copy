package com.webMethodsUI.flow.pageObjects.PredefinedConnector;

import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceCanvasPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Salesforcecustomeoperationpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(Salesforcecustomeoperationpage.class);

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


//    @FindBy(xpath = "//input[@class='inputElement filled']")
//    @CacheLookup
//    WebElement Authorizationfield;
    
    @FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Authorization Type']")
    @CacheLookup
    WebElement Authorizationfield;
    
    @FindBy(xpath = "//div[contains(@class,'placeholder')][text()='Select Authentication type']")
    @CacheLookup
    WebElement AuthenticationField;



    public Salesforcecustomeoperationpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        log.info("Sales force custom operation page object created");
        logExtentReport("Sales force custom operation page object created");
    }


    public void EnteringOperationName(String OperationName) throws Exception
    {
        enterValue(OperationNameField, OperationName, driver, "entering OperationName"+ OperationName);
    }
    
    public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
    
    public void ClickingNextbutton() throws Exception{

            WebElement element =findElement("//button[contains(text(),'Next')]",driver);
            click(element, driver, "Click on Next button");
            waitForElementNotVisible(loader, driver, "wait for page load");
    }

    public void selectingAccount(String AccountName) throws Exception 
    {
            WebElement element = findElement("//div[text()='Please Select']",driver);
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element,0);
            genericHelper.selectDropDownLink(AccountName);
            log.info("Selected Account from dropdown....");
    }
    
    public void selectAuthrizationType(String authType) throws Exception 
    {
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickOnDropDown(Authorizationfield,0);
        genericHelper.selectDropDownLink(authType);
}
    
    public void selectAuthonticationType(String authType) throws Exception 
    {
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickOnDropDown(AuthenticationField,0);
        genericHelper.selectDropDownLink(authType);
}
    
    
  public void clickingOperationType(String Operationtype) throws Exception
  {
      WebElement element = findElement("//label[@for='"+Operationtype+"']",driver);
      click(element, driver, "clicking Operationtype"+ Operationtype);

  }

    public void selectingBusinessObject(String BusinessObject) throws Exception
    {
        WebElement element = findElement("//span[@class='radio-btn-label-text'][contains(text(),'"+ BusinessObject +"')]/parent::label",driver);     
        click(element, driver, "clicking BusinessObject"+ BusinessObject );
    }

    public FlowServiceCanvasPage ClickingDonebutton() throws Exception
    {
            WebElement element = findElement("//button[contains(text(),'Done')]",driver);
           click(element, driver, "Click on Done button");
           waitForElementNotVisible(loader, driver, "wait for page load");
           return new FlowServiceCanvasPage(driver);
    }

    public void Descriptionfield(String Description) throws Exception
    {       
        enterValue(Descriptionfield, Description, driver, "Entering Description"+Description);
    }

    public void checkthecheckbox() throws Exception
    {
        WebElement ele = findElement("//label[@class='new-checkbox-label']",driver);
        click(ele, driver, "check the check box");   
    }
    
    public void selectAllFields() throws Exception
    {
        WebElement ele = findElement("//label[@class='new-checkbox-label' and contains(@for,'selectall')]",driver);
        click(ele, driver, "selecting all data fields");   
    }

}
