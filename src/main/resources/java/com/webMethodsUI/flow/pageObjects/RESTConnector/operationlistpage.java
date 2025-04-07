package com.webMethodsUI.flow.pageObjects.RESTConnector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class operationlistpage extends CommonActions{
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'New Operation')]")
    @CacheLookup
    WebElement Addoperationbutton;

    @FindBy(xpath = "//div[contains(text(),'Custom Operations')]")
    @CacheLookup
    WebElement operationpageheading;

    @FindBy(xpath = "//span[@title='oper']/ancestor::div[@class='single-operation-row row margin-0 words-no-break']/div[@class='col s1 action-menu-container']/div[@class='actions-menu-dropdown']")
    @CacheLookup
    WebElement Actionicon;

    @FindBy(xpath = "//span[@class='dlt-icon-close close-icon']")
    @CacheLookup
    WebElement closeicon;

    @FindBy(xpath = "//span[@title='Show i/o signature']")
    @CacheLookup
    WebElement iosignatureicon;

    @FindBy(xpath = " //span[@title='Test operation']")
    @CacheLookup
    WebElement Testoperationicon;

    @FindBy(xpath = "//input[@name='Name']")
   	@CacheLookup
   	WebElement customOperationNameElemnt;

    @FindBy(xpath = "//textarea[@name='Description']")
	@CacheLookup
	WebElement customOoperationDescriptionElemnt;

    @FindBy(xpath = "//span[@class='switch-label default']")
    @CacheLookup
    WebElement EnableDynamicConnection;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;

    @FindBy(xpath = "//span[@class='custom-operation-step-title'][contains(text(),'Select the Operation')]")
	@CacheLookup
	WebElement selectoperationpage;
	
	@FindBy(xpath = "//div[@class='notification-message']")	
    @CacheLookup	
    WebElement SuccessMessage;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	@CacheLookup
	public WebElement CancelButton;
	
	@FindBy(xpath = "//span[contains(@class,'close-icon')]")
	@CacheLookup
	public WebElement CloseIcon;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
    //span[@title='Test operation']




    //div[contains(text(),'Custom Operations')]

    //span[@title='oper']/ancestor::div[@class='single-operation-row row margin-0 words-no-break']/div[@class='col s1 action-menu-container']/div[@class='actions-menu-dropdown']

    public operationlistpage(WebDriver driver) throws Exception {

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logExtentReport("OperationList PageObject created");
        waitForElementVisible(operationpageheading,driver,"Verify operationpageheading is visible");
    }

    public void Addopertion() throws Exception
    {
        click(Addoperationbutton,driver,"Click Add operation button Button");
    }

    public void EditCreatedoperation(String operation) throws Exception
    {
        WebElement element = findElement("//i[@class='icons8-option-icon']",driver);
        click(element,driver,"click on edit operation");
        WebElement Ele = findElement("//span[@data-eventmap='actions-edit-button']",driver);
        click(Ele,driver,"click element.. "+ Ele);
    }

   public RESTConnectorPage backtorestappPage() throws Exception
   {
       click(closeicon,driver,"back to rest app home page");
       return new RESTConnectorPage(driver);
   }

  public String verifyCreatedoperationName(String operation) throws Exception
  {
      WebElement ele = findElement("//span[@title='"+operation+"']",driver);
      waitForElementVisible(ele,driver,"Verify created Operation is present");

      return ele.getText();
  }


 public IOsignaturepage clickioIcon() throws Exception
 {
     click(iosignatureicon,driver,"click on i/o operation icon");
     waitForElementNotVisible(loader, driver, "wait for page load");
     return new IOsignaturepage(driver);
 }


    public void TestTheOperation() throws Exception
    {
        click(Testoperationicon,driver,"Click on Test icon");
        waitForElementNotVisible(loader, driver, "wait for page load");
    }

//    public boolean Verifytestopertionpagecame() throws Exception
//    {
//        WebElement element = findElement("//span[contains(text(),'Input')]",driver);
//        waitForElementVisible(element,driver,"Verify testOperationPage name is visible.. "+element);
//        return element.isDisplayed();
//    }

    public void SelectAccount(String AccountName) throws Exception
    {
 
        WebElement dropdownelement = findElement("//*[text()='Account']/..//div[text()='Select Account']",driver);
        click(dropdownelement,driver,"Click on dropdown element");
        WebElement accountNameElement = findElement("//div[contains(text(),'" + AccountName + "')]",driver);
        click(accountNameElement,driver,"Select account.. "+accountNameElement);
    }


     public void ClickonRunButton() throws Exception
     {
      WebElement element = findElement("//button[contains(text(),'Run')]",driver);
      click(element,driver,"Click on Run button");
      waitForElementNotVisible(loader, driver, "wait for page load");
   }

    public boolean VerifySuccestestoperation() throws Exception
    {
        WebElement element = findElement("//span[@class='delite-icon dlt-icon-success']",driver);
    	waitForElementVisible(element,driver,"Verify runsuccessfull message is visible");
        return element.isDisplayed();
    }
    
    public void navigateOperationListPage() throws Exception
    {
    	 click(CancelButton,driver,"Click on CancelButton button");
    	 click(CloseIcon,driver,"Click on CloseIcon button");
    }
    
    public void enterCustomOperationName(String customAccountName) throws Exception 
    {
		enterValue(customOperationNameElemnt,customAccountName,driver,"Entering custom operation Name " +customAccountName);
	}

    public void enterCustomOperationDescription(String operationDescription) throws Exception 
    {
		enterValue(customOoperationDescriptionElemnt,operationDescription,driver,"Entering custom description... " +operationDescription);
	}

    public void EnableDynamicConnection() throws Exception
    {
    	click(EnableDynamicConnection,driver,"Enable EnableDynamicConnection");
    }

    public void  clickNextButton() throws Exception 
    {
		click(nextButtonElement,driver,"Click createProject Button");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

    public String getoperationselectionText() throws Exception 
    {
    	waitForElementVisible(selectoperationpage,driver,"Verify selectoperationpage is present");
		return selectoperationpage.getText();
	}

    public String getSuccesMessage() throws Exception
    {
    	waitForElementVisible(SuccessMessage,driver,"Verify SuccessMessage is visible");
        return SuccessMessage.getText();
    }

}
