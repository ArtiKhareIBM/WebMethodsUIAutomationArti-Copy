package com.webMethodsUI.flow.pageObjects.monitor;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FlowServiceExecutionpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(FlowServiceExecutionpage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//span[@class='filter-toggle-arrows delite-icon dlt-icon-chevron-down']")
    @CacheLookup
    WebElement Filterdropdown;

    @FindBy(xpath = "//input[@name='contextID']")
    @CacheLookup
    WebElement ContntIDinputField;



    @FindBy(xpath = "//div[@class='monitor-workflow-title monitor-title'][contains(text(),'Executions')]")
    @CacheLookup
    WebElement FlowServiceExecutionpageElement;

    public FlowServiceExecutionpage(WebDriver driver) {

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(FlowServiceExecutionpageElement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        //logExtentReport("element is visible now.... and element text is  " +resourcePageTitleElement.getText());

    }

    public Metricoverviewpage clickonFlowService(int index,String FlowserviceName) {

        List<WebElement> elemntArray = driver
                .findElements(By.xpath("//a[contains(text(),'"+FlowserviceName+"')]"));
        log.info("All input parameters are....." + elemntArray);
        WebElement element = elemntArray.get(index);
        log.info("element at index..." + index + "......" + element);
        element.click();
        return new Metricoverviewpage(driver);

    }

    public String getUsername(int index,String FlowserviceName){
        List<WebElement> elemntArray = driver
                .findElements(By.xpath("//a[contains(text(),'"+FlowserviceName+"')]/ancestor::div[@class='row monitor-workflow-main-content']/span/div[3]/span"));
        WebElement element = elemntArray.get(index);
        log.info("element at index..." + index + "......" + element.getText());
        return element.getText();
    }


    public void clickfliterdropdown(){
        log.info("Click filter drop down");
        logExtentReport("Click filter drop down");
        Filterdropdown.click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).isDisplayed());
    }

    public void EnteringContexID(String ContextID){
        log.info("Entering contextId" +ContextID);
        logExtentReport("Entering contextId" +ContextID);
        ContntIDinputField.click();
        ContntIDinputField.sendKeys(ContextID);
    }

    public void ClickApply() throws Exception{
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Apply");

    }

}
