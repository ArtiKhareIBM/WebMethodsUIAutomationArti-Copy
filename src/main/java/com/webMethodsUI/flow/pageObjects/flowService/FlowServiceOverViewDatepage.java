package com.webMethodsUI.flow.pageObjects.flowService;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlowServiceOverViewDatepage extends CommonActions {

    private WebDriver driver;
    private Logger log = LogManager.getLogger(FlowServiceOverViewDatepage.class);
    TestBase test;
    WaitHelper waitHelper;

    @FindBy(xpath = "//h6[contains(text(),'Configuration')]")
    @CacheLookup
    WebElement overviewpageElement;

    @FindBy(xpath = "//span[contains(text(),'Enable Flow service invocation over HTTP')]")
    @CacheLookup
    WebElement checkboxhttpinterface;
    
    @FindBy(xpath = "//span[contains(text(),'Enable Flow service to be restarted')]")
    @CacheLookup
    WebElement restartCheckBox;
    
    @FindBy(xpath = "//span[contains(text(),'Enable Flow service to be resumed')]")
    @CacheLookup
    WebElement resumeCheckBox;

    @FindBy(xpath = "//i[contains(text(),'close')]")
    @CacheLookup
    WebElement closethescreen;
    
    @FindBy(xpath = "(//i[contains(@class,'copy-icon')])[1]")
    @CacheLookup
    WebElement Synchronousurl;
    
    public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";


    public FlowServiceOverViewDatepage(WebDriver driver) throws Exception{
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);   
        waitForElementVisible(overviewpageElement, driver, "Verify configuration label in overbiew page is visible");
    }

    public void clickcheckbox() throws Exception {

        click(checkboxhttpinterface, driver, "Select enable flow service to be invoked over HTTP checkbox");        
        Thread.sleep(5000);
    }
    
    public void copySyncURL() throws Exception 
    {
        click(Synchronousurl, driver, "Click on copy button of Synchronous URL");        
    }


    public void closethescreen() throws Exception{
        click(closethescreen, driver, "Close overview page");
    }
    
    public void enableRestart() throws Exception
    {
      click(restartCheckBox, driver, "Select enable restart checkbox");  
      waitForElementNotVisible(loader, driver, "wait for page load");

      Thread.sleep(2000);
    }
    
    public void enableResume() throws Exception
    {
      click(resumeCheckBox, driver, "Select enable resume checkbox");  
      waitForElementNotVisible(loader, driver, "wait for page load");
      Thread.sleep(2000);
    }




}
