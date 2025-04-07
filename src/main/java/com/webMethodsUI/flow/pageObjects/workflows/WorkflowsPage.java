package com.webMethodsUI.flow.pageObjects.workflows;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.assertion.VerificationHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkflowsPage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(LoginPage.class);
    WaitHelper waitHelper;
    
    @FindBy(xpath = "//div[@id='material-select-id']")
	@CacheLookup
	WebElement ProjectDropDown;
    
    
    @FindBy(xpath = "//h1[@class='no-workflow-created']")
	@CacheLookup
	WebElement noWorkFlowMessageElement;


	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-plus']")
	@CacheLookup
	WebElement Addworkflowicon;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	WebElement WorkFlowDeleteButtonElement;

	@FindBy(xpath = "//input[@id='myRecipiesfileInput']")
	@CacheLookup
	WebElement importfield;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public static WebElement notificationMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public WorkflowsPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("WorkflowsPage  Object created");
		waitForElementVisible(ProjectDropDown,driver,"Verify ProjectDropDown is visible");
	}
	
	public String getWorkFlowMessage() throws Exception 
	{
		waitForElementVisible(noWorkFlowMessageElement,driver,"Verify no WorkFlow Created Message is visible");
		return noWorkFlowMessageElement.getText();
	}

	public StartBuildingyourWorkflowpage Addeorkflowicon(){
		log.info("Click on Addnewworkflow icon" );
		logExtentReport("Click on Addnewworkflow icon" );
		Addworkflowicon.click();
		return new StartBuildingyourWorkflowpage(driver);

	}

	public void deleteworkFlowService(String WorkFlowName) throws Exception 
	{
			WebElement WorkFlowMenu = findElement("//div[@title='" + WorkFlowName + "']/div[@class='bottom-section']/div/a",driver);
			click(WorkFlowMenu,driver,"Clicking on WorkFlowMenu Icon");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			//action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
			waitForElementNotVisible(loader, driver, "wait for page load");
			WebElement ele = findElement("//button[contains(text(),'Delete')]", driver);
			click(ele,driver,"Click on WorkFlow DeleteButton");
			waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public String getProjectDeleteMessage() throws Exception 
	{
		WebElement ele = findElement("//div[@class='notification-message']", driver);
		waitForElementVisible(ele, driver, "Verify workflw deleted successfully message is present");
		return notificationMessage.getText();
	}

	public importExportpageforWorkflow clickExporttab(String flowServiceName){
		try {

			WebElement FlowServicesEllipsisElement = driver.findElement(
					By.xpath("//div[@title='" + flowServiceName + "']/div[@class='bottom-section']/div/a"));
			FlowServicesEllipsisElement.click();
			log.info("Clicked on elemnt.." + FlowServicesEllipsisElement);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
			return new importExportpageforWorkflow(driver);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new importExportpageforWorkflow(driver);
		}

	}

	public void importworkflow() throws Exception{
		log.info("uploading zipfile...");
		logExtentReport("uploading zip file");
//		WebElement BrowseFileElement = driver.findElement(By.xpath("//input[@class='file-upload hide']"));
		String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\export-fla6ba2bb36bd467bc2efa72-1625217451915.zip");
		FileUpload fileupload = new FileUpload(driver);
		fileupload.fileUploadUsingInputType(importfield,filePath);
	}

	public void importworkflow2() throws Exception{
		log.info("uploading zipfile...");
		logExtentReport("uploading zip file");
//		WebElement BrowseFileElement = driver.findElement(By.xpath("//input[@class='file-upload hide']"));
		String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\export-flfa5e786aa49df38b63ebee-1625569479180.zip");
		FileUpload fileupload = new FileUpload(driver);
		fileupload.fileUploadUsingInputType(importfield,filePath);
	}


}
