package com.webMethodsUI.flow.pageObjects.ACERuntime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ace extends CommonActions {
    private WebDriver driver;
    private Logger log = LogManager.getLogger(com.webMethodsUI.flow.pageObjects.Certificates.KeyStorepage.class);
    TestBase test;
    WaitHelper waitHelper;

    @FindBy(xpath = "//a[normalize-space(text())='Integration Runtimes']")
    @CacheLookup
    WebElement Runtime;

    @FindBy(xpath = "//h2[normalize-space(text())='App Connect Runtime']")
    @CacheLookup
    WebElement runtimemessage;

    @FindBy(xpath = "//h2[normalize-space(text())='Deployment locations']")
    @CacheLookup
    WebElement deploymentlable;
    @FindBy(xpath = "//span[normalize-space(text())='ir-test-10']")
    @CacheLookup
    WebElement runtimelist;

    @FindBy(xpath = "//button[normalize-space(text())='Add Runtime']")
    @CacheLookup
    WebElement Addruntime;

    @FindBy(xpath = "//span[normalize-space(text())='sales-ir']")
    @CacheLookup
    WebElement RuntimeName;

    @FindBy(xpath = "//a[normalize-space(text())='Projects']")
    @CacheLookup
    WebElement Projects;

    @FindBy(xpath = "//h1[normalize-space(text())='Add Integrations']")
    @CacheLookup
    WebElement Integrationlabel;

    @FindBy(xpath = "(//div[@class='select2-common__placeholder css-1wa3eu0-placeholder'])[3]")
    @CacheLookup
    WebElement seletcLocation;


    @FindBy(xpath = "(//div[@class='select2-common__placeholder css-1wa3eu0-placeholder'])[1]")
    @CacheLookup
    WebElement seletcLocationfromworkflow;

    @FindBy(xpath = "(//span[text()='Runtime']/following-sibling::div)[2]")
    @CacheLookup
    WebElement selectruntime;

    @FindBy(xpath = "//div[@class='select2-common__placeholder css-1wa3eu0-placeholder']")
    @CacheLookup
    WebElement selectruntimeFromWorkflow;

    @FindBy(xpath = "//span[contains(@class,'select-label-text')][text()='Location']")
    @CacheLookup
    WebElement location;

    @FindBy(xpath = "(//button[text()='Reset']/following-sibling::button)[2]")
    @CacheLookup
    WebElement Apply;
    @FindBy(xpath = "//span[normalize-space(text())='Deployment location']")
    @CacheLookup
    WebElement deploylabel;

    @FindBy(xpath = "//span[normalize-space(text())='Rest_Call_Flow_1']")
    @CacheLookup
    WebElement connectorname;
    @FindBy(xpath = "//span[@title='sales-ir']")
    @CacheLookup
    WebElement NotavailableRuntime;

    @FindBy(xpath = "//span[normalize-space(text())='Rest_Call_Flow_1']")
    @CacheLookup
    WebElement ConnectorRadioButton;

    @FindBy(xpath = "//span[@title='App Connect']")
    @CacheLookup
    WebElement Appconnect;

    @FindBy(xpath = "//h1[normalize-space(text())='App Connect Integrations']")
    @CacheLookup
    WebElement aceconnectorpage;

    @FindBy(xpath = "//button[normalize-space(text())='Add']")
    @CacheLookup
    WebElement AddConnector;

    @FindBy(xpath = "//div[normalize-space(text())='Select location']")
    @CacheLookup
    WebElement SelectLocationDropDown;

    @FindBy(xpath = "//div[normalize-space(text())='Select runtime']")
    @CacheLookup
    WebElement SelectRuntimeDropDown;

    @FindBy(xpath = "//a[normalize-space(text())='Create New Workflow']")
    @CacheLookup
    WebElement workflowHeading;

    @FindBy(xpath = "//span[normalize-space(text())='Untitled Workflow']")
    @CacheLookup
    WebElement WorkflowDefaultName;

    @FindBy(xpath = "//i[@class='delite-icon dlt-icon-plus']")
	@CacheLookup
	WebElement createProjectPlusButton;

    @FindBy(xpath = "//input[@id='new-project']")
	@CacheLookup
	WebElement ProjectName;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	@CacheLookup
	WebElement createButton;

    @FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public static WebElement notificationMessage;

    String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

    @FindBy(xpath = "//*[@class='project-greet']")
	@CacheLookup
	WebElement HomePageGreetMessageDescription;



    public ace(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("Runtime Page Object created");
        logExtentReport("Runtime Page Object created");
    }

    public void addaceruntime() throws Exception {
        log.info("clicking Integrationruntime button...");
        logExtentReport("clicking Integration runtime ...");
        Runtime.click();
        WebElement ele = findElement("//a[@title='Register runtime']", driver);
        ele.click();
        waitForElementVisible(runtimemessage, driver, "verifying app connect option");
        WebElement ele1 = findElement("//img[@alt='App Connect Runtime']", driver);
        ele1.click();
        waitForElementVisible(deploymentlable, driver, "verifying deployment location page");
        WebElement ele2 = findElement("//label[@class='radio-btn-label with-label']", driver);
        ele2.click();
        log.info("Clicking on next button...");
        logExtentReport("Clicking on next button...");
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Next");
        waitForElementVisible(runtimelist, driver, "verifying runtime  from list");
        //WebElement ele3 = findElement("//tr[contains(.,'sales-ir')]/td/div/input", driver);
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//tr[contains(.,'sales-ir')]/td/div/input[@type='checkbox']"));
        action.moveToElement(we).click().build().perform();
        WebElement we1 = driver.findElement(By.xpath("//tr[contains(.,'ir-test-01')]/td/div/input[@type='checkbox']"));
        action.moveToElement(we1).click().build().perform();
        Addruntime.click();
        waitForElementVisible(RuntimeName, driver, "verifying runtime is created or not");
        log.info("clicking project button...");
        logExtentReport("clicking project runtime ...");
        Projects.click();


    }

    public void AddIntegration() throws Exception {
        log.info("clicking Add integration button...");
        logExtentReport("clicking Add integration button ...");
        waitForElementVisible(aceconnectorpage, driver, "verifying the connector page is loaded or not");
        WebElement ele = findElement("//button[normalize-space(text())='Add Integrations']", driver);
        click(ele, driver, "clicking Add integration button");
        //waitForElementVisible(Integrationlabel, driver, "verifying Addintegration UI is loaded or not");
        Thread.sleep(2000);

    }

    public void filtering(String deployname, String runtimename) throws Exception {
        log.info("clicking filter  button...");
        logExtentReport("clicking filter button ...");
        WebElement ele = findElement("(//button[@class='dlt-button dlt-filter__button'])[2]", driver);
        click(ele, driver, "clicking the filter button");
        //waitForElementVisible(location, driver, "verifying after clicking on the filter icon the location lable is visible or not");
        log.info("clicking on the location drop down");
        logExtentReport("clicking on the location dropdown...");
        GenericHelper genericHelper = new GenericHelper(driver);
        click(seletcLocation, driver, "Clicking on select location Type drop down");
        genericHelper.selectDropDownLink(deployname);
        waitForElementVisible(deploylabel, driver, "verifying lable before selecting runtime drop down");
        log.info("clicking on the runtime drop down");
        logExtentReport("clicking on the runtime dropdown...");
        click(selectruntime, driver, "Clicking on select runtime Type drop down");
        //GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink(runtimename);
        Apply.click();
        waitForElementVisible(connectorname, driver, "verifying applied filter giving proper search");

    }
    public void closingIntegrationUi() throws Exception{

        WebElement ele3 = findElement("//button[normalize-space(text())='Close']", driver);
        click(ele3, driver, "clicking the close button");
        waitForElementVisible(aceconnectorpage, driver, "verifying ace connector page loaded or not after creating the connector");
    }


    public boolean istheRuntimeNameDisabled(String name) throws Exception {
        //boolean status = false;
        try {
            WebElement element = findElementBasedOnTime("(//span[@title='" + name + "'])", driver, 10);
            //WebElement element = findElement("(//span[@title='" + name + "'])", driver);
            if (element.isDisplayed()) {
                logExtentReport("element is dispalyed");
                log.info("element is present");
                //status = false;
                return false;
            }
        } catch(Exception e) {
            {
                logExtentReport("sales-ir runtime is not dispalyed");
                log.info("element is not present");
                return true;

            }
        }

        return false;
    }

    public void createConnector(String apiname, String operationname) throws Exception{
        logExtentReport("creating connector using the api");
        log.info("creating connector using the api");
        log.info("clicking on the api");
        logExtentReport("clicking on the api");
        //waitForElementVisible(Integrationlabel, driver, "verifying the integration UI label");
        Thread.sleep(1000);
        WebElement ele = findElement("//span[normalize-space(text())='" + apiname + "']", driver);
        click(ele, driver, "clicking the api");
        //ConnectorRadioButton.click();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Next");
        //ConnectorOperation.click();
        WebElement ele2 = findElement("//span[normalize-space(text())='" + operationname + "']", driver);
        click(ele2, driver, "clicking the api");
        WebElement ele3 = findElement("//button[normalize-space(text())='Add']", driver);
        click(ele3, driver, "clicking the add button");
        waitForElementVisible(aceconnectorpage, driver, "verifying ace connector page loaded or not after creating the connector");


    }

    public void searchconnector(String connectorName) throws Exception{
        Thread.sleep(1000);
        WebElement filterbutton = findElement("//button[@class='dlt-button dlt-filter__button']", driver);
        click(filterbutton, driver, "clicking the filter button");
        WebElement ConnectorName = findElement("//input[@data-testid='materialInputElement']", driver);
        enterValue(ConnectorName, connectorName, driver, "Entering connectorName ... " + connectorName);
        WebElement ApplyButton = findElement("//button[normalize-space(text())='Apply']", driver);
        click(ApplyButton, driver, "clicking the apply button");


    }

    public void SearchConnectorUsingLocation(String locationName) throws Exception{
        WebElement ResetButton = findElement("//button[normalize-space(text())='Reset']", driver);
        click(ResetButton, driver, "clicking the reset button");
        GenericHelper genericHelper = new GenericHelper(driver);
        click(SelectLocationDropDown, driver, "Clicking on select location Type drop down");
        genericHelper.selectDropDownLink(locationName);
        WebElement ApplyButton = findElement("//button[normalize-space(text())='Apply']", driver);
        click(ApplyButton, driver, "clicking the apply button");
    }

    public void SearchConnectorUsingRuntime(String RuntimeName) throws Exception{
        WebElement ResetButton = findElement("//button[normalize-space(text())='Reset']", driver);
        click(ResetButton, driver, "clicking the reset button");
        GenericHelper genericHelper = new GenericHelper(driver);
        click(SelectRuntimeDropDown, driver, "Clicking on select runtime Type drop down");
        genericHelper.selectDropDownLink(RuntimeName);
        WebElement ApplyButton = findElement("//button[normalize-space(text())='Apply']", driver);
        click(ApplyButton, driver, "clicking the apply button");
    }

    public void CreateaceConnectorFromWorkflowPage(String deployname, String runtimename ) throws Exception{
        WebElement AddWorkflowButton = findElement("//a[@title='Add Workflow']//i[1]", driver);
        click(AddWorkflowButton, driver, "Clicking on Add workflow");
        waitForElementVisible(workflowHeading, driver, "verifying after workflow page");
        WebElement CreateWorkflowButton = findElement("//a[normalize-space(text())='Create New Workflow']", driver);
        click(CreateWorkflowButton, driver, "clicking the creating workflow button");
        waitForElementVisible(WorkflowDefaultName, driver, "verifying the workflow default name");
        WebElement clickcanvas = findElement("(//a[@data-eventmap='canvas-list-services']//span)[2]", driver);
        click(clickcanvas, driver, "clicking the reset button");
        waitForElementVisible(Appconnect, driver, "verifying the app connect label from workflow canvas");
        WebElement addbutton = findElement("//a[@title='Add New App Connect']//span[1]", driver);
        click(addbutton, driver, "clicking the app connect add button from the worklfow page");
        Thread.sleep(1000);
        WebElement filterbutton = findElement("//button[@class='dlt-button dlt-filter__button']", driver);
        click(filterbutton, driver, "clicking the filter button");
        log.info("clicking on the location drop down");
        logExtentReport("clicking on the location dropdown...");
        GenericHelper genericHelper = new GenericHelper(driver);
        click(seletcLocationfromworkflow, driver, "Clicking on select location Type drop down");
        genericHelper.selectDropDownLink(deployname);
        waitForElementVisible(deploylabel, driver, "verifying lable before selecting runtime drop down");
        log.info("clicking on the runtime drop down");
        logExtentReport("clicking on the runtime dropdown...");
        click(selectruntimeFromWorkflow, driver, "Clicking on select runtime Type drop down");
        //GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink(runtimename);
        WebElement Clickapplybutton = findElement("//button[normalize-space(text())='Apply']", driver);
        click(Clickapplybutton, driver, "Clicking the apply button");




    }

    public void createConnectorFromWorkflow(String apiname, String operationname) throws Exception {
        logExtentReport("creating connector using the api");
        log.info("creating connector using the api");
        log.info("clicking on the api");
        logExtentReport("clicking on the api");
        //waitForElementVisible(Integrationlabel, driver, "verifying the integration UI label");
        Thread.sleep(1000);
        WebElement ele = findElement("//span[normalize-space(text())='" + apiname + "']", driver);
        click(ele, driver, "clicking the api");
        //ConnectorRadioButton.click();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Next");
        //ConnectorOperation.click();
        WebElement ele2 = findElement("//span[normalize-space(text())='" + operationname + "']", driver);
        click(ele2, driver, "clicking the api");
        WebElement ele3 = findElement("//button[normalize-space(text())='Add']", driver);
        click(ele3, driver, "clicking the add button");
    }

public void creatProject(String projectName) throws Exception 
    {
		click(createProjectPlusButton,driver,"Click on Add Project Button");
		enterValue(this.ProjectName,projectName,driver,"Entering Project Name " +projectName);
		click(createButton,driver,"Click createProject Button");
		elementContainsText(notificationMessage,"Project created successfully.",driver,"Verify project created successfully message is visible");
//		waitForElementNotVisible(loader, driver, "wait for page load");
	}

    public void openProject(String ProjectName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(@class,'project-name')][contains(text(),'" + ProjectName + "')]"));
		click(element,driver,"Clicking on Project " + element);
		waitForElementNotVisible(loader, driver, "wait for page load");
		//waitForElementVisible(HomePageGreetMessageDescription,driver,"Verify Home page greet message is visible");
		//waitForElementVisible(createProjectPlusButton,driver,"Verify create project plus button is visible");
	}

}
