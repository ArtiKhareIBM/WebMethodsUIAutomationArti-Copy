package com.webMethodsUI.flow.pageObjects.flowService;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.JavascriptExecutor;

public class FlowServicePage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(FlowServicePage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//a[contains(text(),'Flow services')]")
	@CacheLookup
	WebElement flowServiceTab;

	@FindBy(xpath = "//a[@title='Add Flow service']")
	@CacheLookup
	WebElement addFlowServicePlusIconElement;

	@FindBy(xpath = "//*[contains(@class,'icon-plus')]")
	@CacheLookup
	WebElement addFreshFlowService_PlusIconElement;

	@FindBy(xpath = "//h1[@class='no-workflow-created']")
	@CacheLookup
	WebElement noFlowServiceElement;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu active')]//i[contains(@class,'delete-blue')]/following-sibling::*[@class='menu-title'][text()='Delete']")
	@CacheLookup
	public WebElement FlowServiceDeleteOption;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu active')]//i[contains(@class,'export')]/following-sibling::*[@class='menu-title'][text()='Export']")
	@CacheLookup
	public WebElement FlowServiceExportOption;
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu active')]//i[contains(@class,'clone')]/following-sibling::*[@class='menu-title'][text()='Clone']")
	@CacheLookup
	public WebElement FlowServiceCloneOption;

	@FindBy(xpath = "//button[text()='Delete']")
	@CacheLookup
	public WebElement deleteButton;
	
	@FindBy(xpath = "//h1[@class='modal-title'][text()='Delete']")
	@CacheLookup
	public WebElement deleteModal;
	
	@FindBy(xpath = "//h1[text()='Confirm Delete ?']")
	@CacheLookup
	public WebElement FlowServiceconfirmDeletePopUP;
	
//	@FindBy(xpath = "//div[@title='" + flowServiceName + "']//*[contains(text(),'Delete')]")
//	@CacheLookup
//	WebElement flowServiceDeleteButtonElement1;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement deleteFlowserviceNotificationMessageElement;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public WebElement notificationMessage;
	
	@FindBy(xpath = "//span[@class='delite icon dlt-icon-cloud-download']")
	@CacheLookup
	WebElement importfield;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	public String notificationMessage_1 = "//div[@class='notification-message']";
	
	@FindBy(xpath = "//h1[text()='Select Flow service type']")
	@CacheLookup
	WebElement flowServiceTypeHeaderElement;
	
	@FindBy(xpath = "//div[@class='select-flow-type']//div[contains(@class,'flow-type-wmio')]")
	@CacheLookup
	WebElement flowServiceElement;
	
	@FindBy(xpath = "//button[text()='Create']")
	@CacheLookup
	WebElement createButton;
	
	@FindBy(xpath = "//button[@type='button'][text()='Cancel']")
	@CacheLookup
	WebElement cancelButton;


	public FlowServicePage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("flowServiceTab Object created");
		waitForElementVisible(addFreshFlowService_PlusIconElement,driver,"Verify add flowservice plus icon is visible");
	}

//	public String getflowServiceTab() {
//		return flowServiceTab.getText();
//	}

	public FlowServiceCanvasPage clickFlowServiceName(String FlowServicename) throws Exception 
	{
		WebElement element = findElement("//span[contains(text(),'"+FlowServicename+"')]",driver);
		click(element,driver,"Clicking the Flowservices");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new FlowServiceCanvasPage(driver);
	}

	public FlowServiceCanvasPage clickOnAddFreshFlowServiceButton() throws Exception 
	{	
			click(addFreshFlowService_PlusIconElement,driver,"Click on flowservice create plus Button");
			closeFlowServiceTypeModalIfExists();
			waitForElementNotVisible(loader, driver, "wait for page load");
			return new FlowServiceCanvasPage(driver);
	}
	
	//h1[text()='Select Flow service type']
	
	public void closeFlowServiceTypeModalIfExists() throws Exception
	{
		try
		{
			if (flowServiceTypeHeaderElement.isDisplayed())
				click(flowServiceElement,driver,"selecting Flow service type");
			    click(createButton,driver,"Clicking on create Buton");
		}
		catch(Exception e)
		{

		}
	}

	public FlowServiceCanvasPage clickOnAddFlowServiceButton() throws Exception {

	click(addFreshFlowService_PlusIconElement,driver,"Click on flowservice create plus Button");
	closeFlowServiceTypeModalIfExists();
	waitForElementNotVisible(loader, driver, "wait for page load");
		return new FlowServiceCanvasPage(driver);
	}

	public void VerifynoFlowServiceCreatedMessage() throws Exception 
	{		
		elementContainsText(noFlowServiceElement, "No Flow services created yet!", driver, "No Flow services created yet! message is visible");
		Assert.assertEquals(noFlowServiceElement.getText(), "No Flow services created yet!");

	}
	
	public void deleteFlowService(String flowServiceName) throws Exception 
	{
		WebElement FlowServicesMoreMenu = findElement("//*[contains(@class,'title-flow-name')][text()='"+flowServiceName+"']/ancestor::div[@class='top-section']/following-sibling::div[@class='bottom-section']//i[contains(@class,'more-menu')]",driver);
		click(FlowServicesMoreMenu,driver,"Click FlowServices MoreMenu");
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(FlowServiceDeleteOption,driver,"Click on FlowService delete button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementVisible(FlowServiceconfirmDeletePopUP,driver,"Verify flow service delete confirm popup is visible");
		click(deleteButton,driver,"Click on delete button");
		elementContainsText(notificationMessage,"Flow service deleted successfully.",driver,"Verify FlowService deleted successfully. message is visible");
		waitForElementNotVisible(loader, driver, "wait for page load",45);
	}

//	public void deleteFlowService(String flowServiceName) throws Exception 
//	{
//		WebElement FlowServicesMoreMenu = findElement("//*[contains(@class,'title-flow-name')][text()='"+flowServiceName+"']/ancestor::div[@class='top-section']/following-sibling::div[@class='bottom-section']//i[contains(@class,'more-menu')]",driver);
//		click(FlowServicesMoreMenu,driver,"Click FlowServices MoreMenu");
//		waitForElementNotVisible(loader, driver, "wait for page load");
//		//click(FlowServiceDeleteOption,driver,"Click on FlowService delete button");
//		try
//		{
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", FlowServiceDeleteOption);
//		}
//		catch(StaleElementReferenceException e) 
//		{
//            // retrieving the name input field again
//			FlowServiceDeleteOption =  findElement("//ul[contains(@class,'dropdown-menu active')]//i[contains(@class,'delete-blue')]/following-sibling::*[@class='menu-title'][text()='Delete']",driver);
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", FlowServiceDeleteOption);
//            // now nameHtmlElement is no longer stale
//        }
//		//JavascriptExecutor executor = (JavascriptExecutor)driver;
//		//executor.executeScript("arguments[0].click();", FlowServiceDeleteOption);
//		waitForElementNotVisible(loader, driver, "wait for page load");
//		//waitForElementVisible(FlowServiceconfirmDeletePopUP,driver,"Verify flow service delete confirm popup is visible");
//		//click(deleteButton,driver,"Click on delete button");
//		try
//		{
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", deleteButton);
//			elementContainsText(notificationMessage,"Flow service deleted successfully.",driver,"Verify FlowService deleted successfully. message is visible");
//			waitForElementNotVisible(loader, driver, "wait for page load",45);
//		}
//		catch(StaleElementReferenceException e) 
//		{
//            // retrieving the name input field again
//			FlowServiceconfirmDeletePopUP =  findElement("//h1[text()='Confirm Delete ?']",driver);
//			waitForElementVisible(FlowServiceconfirmDeletePopUP,driver,"Verify flow service delete confirm popup is visible");
//			deleteButton =  findElement("//button[text()='Delete']",driver);
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", deleteButton);
//			notificationMessage = findElement("//div[@class='notification-message']",driver);
//			elementContainsText(notificationMessage,"Flow service deleted successfully.",driver,"Verify FlowService deleted successfully. message is visible");
//			waitForElementNotVisible(loader, driver, "wait for page load",45);
//            // now nameHtmlElement is no longer stale
//        }
////		elementContainsText(notificationMessage,"Flow service deleted successfully.",driver,"Verify FlowService deleted successfully. message is visible");
////		waitForElementNotVisible(loader, driver, "wait for page load",45);
//	}
//	
	
	public void deletionOfFlowToCheckDependency(String currentFlow,String dependentProject) throws Exception 
	{
		WebElement FlowServicesMoreMenu = findElement("//*[contains(@class,'title-flow-name')][text()='"+currentFlow+"']/ancestor::div[@class='top-section']/following-sibling::div[@class='bottom-section']//i[contains(@class,'more-menu')]",driver);
		click(FlowServicesMoreMenu,driver,"Click FlowServices MoreMenu");
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(FlowServiceDeleteOption,driver,"Click on FlowService delete button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementVisible(deleteModal,driver,"Verify delete depedency modal  is visible");
		WebElement dependency = findElement("//table[@class='ut-dependent-flows']//tr/td[text()='"+currentFlow+"']/following-sibling::td[text()='"+dependentProject+"']",driver);
		waitForElementVisible(dependency,driver,"Verify flow name and dependent flow name  is visible");
		click(cancelButton,driver,"Click on cancel button");
	}
	
	public void ExportFlowService(String flowServiceName) throws Exception 
	{
		WebElement FlowServicesMoreMenu = findElement("//*[contains(@class,'title-flow-name')][text()='"+flowServiceName+"']/ancestor::div[@class='top-section']/following-sibling::div[@class='bottom-section']//i[contains(@class,'more-menu')]",driver);
		click(FlowServicesMoreMenu,driver,"Click Flow Services MoreMenu");
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(FlowServiceExportOption,driver,"Click on FlowService Export button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement exportButton = findElement("//button[contains(text(),'Export')]",driver);
		click(exportButton,driver,"Click FlowServices export button");
		elementContainsText(notificationMessage,"Flow service exported successfully",driver,"Verify Flow service exported successfully. message is visible");
		waitForElementNotVisible(loader, driver, "wait for page load",45);
		Thread.sleep(5000);
	}
	
	@FindBy(xpath = "//input[@id='ut-flow-export']")
	@CacheLookup
	WebElement importFileInput;
	
	public FlowServicePage ImportFlowService(String flowServiceName,String path,String Operation) throws Exception 
	{
		 String filePath = ResourceHelper.getResourcePath(path);
		 FileUpload fileupload = new FileUpload(driver);
	     fileupload.fileUploadUsingInputType(importFileInput,filePath);
//	     WebElement ImportFlowServicePopUP = findElement("//h1[text()='Import FlowService: '][text()='"+flowServiceName+"']",driver);
//	     waitForElementVisible(ImportFlowServicePopUP, driver, "Verify import flow service popup is visible");
	     WebElement element = findElement("//input[@value='"+flowServiceName+"']/../../following-sibling::div/span[contains(@class,'dlt-icon-success')]",driver);
	     waitForElementVisible(element, driver, "Verify Status is green for the custom connector");
	     GenericHelper genericObj = new GenericHelper(driver);
	 	 genericObj.clickButton("Next");
//	 	 waitForElementNotVisible(loader, driver, "wait for page load");
	 	 Thread.sleep(2000);
	     WebElement info = findElement("//span[text()='"+Operation+"']/../../following-sibling::div/span[contains(@class,'dlt-icon-info')]",driver);
	     click(info, driver, "Clicking on info of custom operation to check usage");
	     waitForElementNotVisible(loader, driver, "wait for page load");
	     WebElement success = findElement("//span[text()='"+Operation+"']/../../following-sibling::div/span[contains(@class,'dlt-icon-success')]",driver);
	     waitForElementVisible(success, driver, "Verify usage status is success");
	     genericObj.clickButton("Submit");
	      
	     return new FlowServicePage(driver);
	}
	
	public FlowServicePage ImportFlowServiceWithoutOperation(String flowServiceName,String path) throws Exception 
	{
		 String filePath = ResourceHelper.getResourcePath(path);
		 FileUpload fileupload = new FileUpload(driver);
		 fileupload.fileUploadUsingInputType(importFileInput,filePath);
	 	 waitForElementNotVisible(loader, driver, "wait for page load",60);
		 waitForElementNotVisible(loader, driver, "wait for page load",60);
//		 elementContainsText(notificationMessage,"Import successful. Files imported: "+flowServiceName,driver,"Verify FlowService Imported successfully. message is visible");
	     return new FlowServicePage(driver);
	}
	
	public void ImportStreamingFlowService(String FSfileName) throws Exception 
	{	
			WebElement BrowseFileElement = driver.findElement(By.xpath("//input[@id='ut-flow-export']"));
	        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\"+FSfileName);
	        FileUpload fileupload = new FileUpload(driver);
	        fileupload.fileUploadUsingInputType(BrowseFileElement,filePath);
	}
	
	public void errorMessageOnImport() throws Exception 
	{
		 elementContainsText(notificationMessage,"FlowService Exported successfully.",driver,"Verify FlowService Exported successfully. message is visible");	
	}
	
	public void ImportSuccessMessage(String flowservice) throws Exception 
	{
		 waitForElementNotVisible(loader, driver, "wait for page load",45);
		 waitForElementNotVisible(loader, driver, "wait for page load",60);
		 //waitForElementVisible(notificationMessage, driver,"Verify FlowService Imported successfully. message is visible");
		 elementContainsText(notificationMessage,"Import successful. Files imported: "+flowservice,driver,"Verify FlowService Imported successfully. message is visible");
		 Assert.assertEquals(notificationMessage.getText(), "Import successful. Files imported: "+flowservice);
		 waitForElementNotVisible(notificationMessage_1, driver, "wait for notificationMessage to not visible");
	}
	
	public boolean isFlowserviceDeleteMassageDisplay() {

		log.info("Verifing flow services delete massage.......... ");
		logExtentReport("Verifing flow services delete massage.......... ....");
		return deleteFlowserviceNotificationMessageElement.isDisplayed();

	}

	public FlowServiceOverViewDatepage gointoOverviewPage(String flowServiceName) throws Exception{
		WebElement FlowServicesEllipsisElement = driver.findElement(
		By.xpath("//div[@title='" + flowServiceName + "']/div[@class='bottom-section']/div/a"));
			FlowServicesEllipsisElement.click();
			log.info("Clicked on elemnt.." + FlowServicesEllipsisElement);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
       return new FlowServiceOverViewDatepage(driver);
	}


	public String NotificationMessage() {
		log.info("Verifying project delete success massage" + notificationMessage.getText());
		logExtentReport("Entering project Name " + notificationMessage.getText());

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(notificationMessage, ObjectReader.reader.getExplicitWait());
		return notificationMessage.getText();
	}

	public String getflowservicetittle(String flowtitile) {

		log.info("Getting the flowname name...");
		logExtentReport("Getting the flow name......");
		WebElement element = driver.findElement(
	    By.xpath("//span[contains(text(),'" + flowtitile + "')]"));
		return element.getText();

	}
	
	public void CloneFlowService(String flowServiceName,String projectName1) throws Exception 
	{
		WebElement FlowServicesMoreMenu = findElement("//*[contains(@class,'title-flow-name')][text()='"+flowServiceName+"']/ancestor::div[@class='top-section']/following-sibling::div[@class='bottom-section']//i[contains(@class,'more-menu')]",driver);
		click(FlowServicesMoreMenu,driver,"Click FlowServices MoreMenu");
		waitForElementNotVisible(loader, driver, "wait for page load");
		click(FlowServiceCloneOption,driver,"Click on FlowService clone button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement element = findElement("//input[@value='Copy_"+flowServiceName+"']",driver);
		waitForElementVisible(element,driver,"Verify copy flow service name is visible.. Copy_"+flowServiceName);
		WebElement dropdown = findElement("//select[@id='ut-clone-toprojectname']",driver);
		selectValueFromDropDown(dropdown, projectName1, driver, "Select project name from dropdown");
		WebElement cloneButton = findElement("//button[text()='Clone']",driver);
		click(cloneButton,driver,"Click on clone button");
//	    String CloneSuccessMessage = "//*[contains(text(),'FlowService created')]";
//	    WebElement successMessage = findElement(CloneSuccessMessage,driver);
//		elementContainsText(successMessage,"Clone success",driver,"Verify clone success message is visible");
//		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	
	public void verifyFlowServiceIsVisible(String flowServiceName) throws Exception 
	{
		WebElement element = findElement("//span[contains(text(),'"+flowServiceName+"')]",driver);
		waitForElementVisible(element,driver,"verify flowservice " +flowServiceName+ "is visible");

	}
}
