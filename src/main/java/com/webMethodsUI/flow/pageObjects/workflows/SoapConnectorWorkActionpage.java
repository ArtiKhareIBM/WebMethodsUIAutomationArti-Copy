package com.webMethodsUI.flow.pageObjects.workflows;

import java.util.List;

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

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.AddAccountPage;
import com.webMethodsUI.flow.testbase.CommonActions;

public class SoapConnectorWorkActionpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(SoapConnectorWorkActionpage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//div[@class='select2-common__input']/input")
    @CacheLookup
    WebElement SelectActiontab;

    @FindBy(xpath = "//span[@class='delite-icon dlt-icon-caret-down']/parent::div")
    @CacheLookup
    WebElement Selectactdropdown;

    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down']")
    @CacheLookup
    WebElement accountfielstab;

    @FindBy(xpath = "//h1[@class='inline-block truncate']")
    @CacheLookup
    WebElement salesactionpageheading;

    @FindBy(xpath = "//span[@class='material-icons']")
    @CacheLookup
    WebElement AccountCreation;

    @FindBy(xpath = "//div[contains(text(),'Please Select')]")

	@CacheLookup
	WebElement portFieldElement;

    @FindBy(xpath = "//span[contains(text(),'Connect to PartnerCertficateConnector')]")

   	@CacheLookup
   	WebElement ElementTobeVisible;


    public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";







    //h1[contains(text(),'Test this action')]

    //h1[contains(text(),'Message posted successfully')]

    //button[contains(text(),'Test')]


    public SoapConnectorWorkActionpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(salesactionpageheading, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");

    }

    public boolean VerifyActionconfigurepage(){
        log.info("Verifying ActionPage.." );
        logExtentReport("Verifying ActionPage..");
        boolean verify = driver.findElement(By.xpath("//span[contains(text(),'Incoming Data')]")).isDisplayed();
        return verify;
    }

    public boolean VerifyTestpage(){
        log.info("Verifying Test page" );
        logExtentReport("Verifying Test page");
        boolean verify = driver.findElement(By.xpath("//h1[contains(text(),'Test this action')]")).isDisplayed();
        return verify;
    }

    public boolean VerifyAfterTest(){
        log.info("Verifying After Test " );
        logExtentReport("Verifying After Test");
        boolean verify = driver.findElement(By.xpath("//h1[contains(text(),'Message posted successfully')]")).isDisplayed();
        return verify;
    }

    public void ClickTestButton() throws Exception{
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Test");
        waitForElementLoaderNotVisible(loader, driver, "wait for page load");
        log.info("Clicked Test button" );
        logExtentReport("Clicked Test button");
        
    }

    public void ClickNextbutton() throws Exception{
        GenericHelper genericHelper = new GenericHelper(driver);
        waitForElementNotVisible(loader, driver, "wait for page load");
        genericHelper.clickButton("Next");
        log.info("Clicked Next button" );
        logExtentReport("Clicked Next button");
    }

    public void ClickDonebutton() throws Exception{
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Done");
        log.info("Clicked Done button" );
        logExtentReport("Clicked Done button");
    }

    public void SelectAction(String Action){
        Selectactdropdown.click();
        SelectActiontab.sendKeys(Action);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
//        WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+Action+"')]"));
//        ele.click();
        log.info("Entered Action"+ Action);
        logExtentReport("Entered Action"+ Action);
    }

    public void selectingAccount(int index,String AccountName) {

        try {
            List<WebElement> elemntArray = driver.findElements(By.xpath("//span[@class='delite-icon dlt-icon-caret-down']"));
            log.info("All input parameters are....." + elemntArray);
            Thread.sleep(2000);
            WebElement element = elemntArray.get(index);
           
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickOnDropDown(element,1);
            genericHelper.selectDropDownLink(AccountName);
            log.info("Clicked on AccountName....");

        } 
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void enteringValuesinparameters(String fieldname,String value){
        WebElement element = driver.findElement(By.xpath("//div[@aid='"+fieldname+"']/div/input"));
        element.click();
        element.sendKeys(value);
        log.info("Entered Value in "+fieldname+ value);
        logExtentReport("Entered Value in"+fieldname+ value);
    }


//span[contains(text(),'tns:addIntsFlowService')]/ancestor::span[@style='margin-right: 10px;']/following-sibling::span/i



    public void clickdropdown(){
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'tns:addIntsFlowService')]/ancestor::span[@style='margin-right: 10px;']/following-sibling::span/i"));
        element.click();
        enteringValuesinparameters("input1","12");
        enteringValuesinparameters("input2","2");
    }


    public AddAccountPage ClickConnectButton() throws Exception{
    	waitForElementVisible(ElementTobeVisible,driver,"Verify ElementTobeVisible is present");
    	//WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'add')]"));
    	WebElement ele = driver.findElement(By.xpath("//a[@class='add-icon']/span"));
        click(ele, driver, "Click on Create account  link");
        //WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'circle-clipper')]/div[@class='circle']"));
        //waitForElementVisible(element1, driver, "wait for page load");
        //waitForElementNotVisible(loader, driver, "wait for page load");
        waitForElementNotVisible(loader, driver, "wait for page load");
        return new AddAccountPage(driver);
    }


    public void  selectAccount(String accountname) throws Exception {
    	//WebElement element = driver.findElement(By.xpath("//span[@class='delite-icon dlt-icon-caret-down']/parent::div']"));
   		click(Selectactdropdown,driver,"click on first element");
   		//scrollPageDown2(driver, 30);
   		WebElement element1 = driver.findElement(By.xpath("//div[contains(text(),'" + accountname + "')]"));
		click(element1, driver, "Clicked on port  type...."+accountname);

	    //return new AddAccountPage(driver);

	}
    public void clickOnCancelButton() throws Exception {
		//waitForElementVisible(PartnerCerifcate,driver,"Verify cancel button is present");
		WebElement element1 = driver.findElement(By.xpath("//button[text()='Next']/preceding-sibling::button[text()='Cancel']"));
		click(element1, driver, "clicked on cancel button");
		waitForElementNotVisible(loader, driver, "wait for page load");

	}


}
