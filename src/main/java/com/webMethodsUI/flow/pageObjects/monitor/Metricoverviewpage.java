package com.webMethodsUI.flow.pageObjects.monitor;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Metricoverviewpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(Metricoverviewpage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//h3[contains(text(),'Operations')]")
    @CacheLookup
    WebElement MetricpageElement;

    @FindBy(xpath = "//div[@class='activity-log-title'][contains(text(),'Execution Source')]/following-sibling::div")
    @CacheLookup
    WebElement invocationchanneldetail;

    @FindBy(xpath = "//span[@class='activity-log-title'][contains(text(),'Context Id')]/following-sibling::div")
    @CacheLookup
    WebElement ContexIdDetail;


    @FindBy(xpath = "//div[@class='activity-log-title'][contains(text(),'Status')]/following-sibling::div")
    @CacheLookup
    WebElement Statusdetail;

    @FindBy(xpath = "//div[@class='activity-logs-header-section']/div[1]/div[1]/div[2]")
    @CacheLookup
    WebElement StatusFlowService;
  



    public Metricoverviewpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(MetricpageElement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
    }

    public String Verifyinvocationchannel(){
        log.info("check details of invocation channel");
        logExtentReport("check details of invocation channel");
        return invocationchanneldetail.getText();
    }

    public String VerifyStatusdetail() throws Exception{
        elementContainsText(Statusdetail, "Success", driver, "Verify Status : Success is visible");
        return Statusdetail.getText();
    }
    
    public String VerifyStatusFlowService() throws Exception{
        elementContainsText(Statusdetail, "Success", driver, "Verify Status : Success is visible");
        return StatusFlowService.getText();
    }

    public String VerifyContextdetail(){
        log.info("check details of ContextID");
        logExtentReport("check details of ContextID");
        return ContexIdDetail.getText();
    }

}
