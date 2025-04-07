package com.webMethodsUI.flow.pageObjects.workflows;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditworkflowName extends CommonActions{
    private WebDriver driver;
    private Logger log = LogManager.getLogger(WorkflowCanvaspage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h1[contains(text(),'Edit Workflow Name')]")
    @CacheLookup
    WebElement Editworkflowelement;


    @FindBy(xpath = "//input[@name='Flow Name']")
    @CacheLookup
    WebElement Namefield;



    public EditworkflowName(WebDriver driver){
        super();
        this.driver = driver;

        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(Editworkflowelement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now....");
        logExtentReport("Build your workflow  Object created");

    }

    public void EnteringWorkFlowName(String FlowServiceName) throws Exception
    {
        clearAndEnterText(Namefield,FlowServiceName,driver,"Entering WorkFlow Name.." +FlowServiceName);

    }
    public void ClickDonebutton() throws Exception
    {
        WebElement ele = findElement("//button[@class='btn btn-primary btn-sm']",driver);
        click(ele, driver,"Click on Done button");
    }




}
