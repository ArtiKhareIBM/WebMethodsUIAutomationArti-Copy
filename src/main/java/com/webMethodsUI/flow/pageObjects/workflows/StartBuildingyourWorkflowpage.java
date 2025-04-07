package com.webMethodsUI.flow.pageObjects.workflows;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartBuildingyourWorkflowpage extends CommonActions {
    private WebDriver driver;
    private Logger log = LogManager.getLogger(StartBuildingyourWorkflowpage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h2[contains(text(),'Start Building your Workflow')]")
    @CacheLookup
    WebElement buildingpageelement;


    @FindBy(xpath = "//a[contains(text(),'Create New Workflow')]")
    @CacheLookup
    WebElement createnewWorkflowlink;



    public StartBuildingyourWorkflowpage(WebDriver driver){
        super();
        this.driver = driver;

        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(buildingpageelement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("Build your workflow  Object created");


    }

    public WorkflowCanvaspage clickonCreateNewworkflow(){
        log.info("Click on create new work flow link" );
        logExtentReport("Click on create new work flow link" );
        createnewWorkflowlink.click();
        return new WorkflowCanvaspage(driver);
    }


    //p[contains(text(),'Drag connectors on the canvas from the right panel')]


}
