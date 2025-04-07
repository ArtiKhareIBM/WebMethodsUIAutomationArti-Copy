package com.webMethodsUI.flow.pageObjects.flatfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.OperationList;
import com.webMethodsUI.flow.testbase.CommonActions;


public class AddConnectorPage  extends CommonActions
{
	WebDriver driver;
	private Logger log = LogManager.getLogger(OperationList.class);
	FileUpload fileUpload;



	@FindBy(xpath = "//span[contains(text(),'Create/Import')]")
	@CacheLookup
	WebElement selectStepElement;

	@FindBy(xpath = "//span[contains(text(),'Create manually')]")
	@CacheLookup
	WebElement createManuallyElement;

	@FindBy(xpath = "//span[contains(text(),'Import from file')]")
	@CacheLookup
	WebElement importFromFileElement;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement cancelButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;

	@FindBy(xpath = "//span[contains(text(),'Create a connector by importing from a sample file')]")
	@CacheLookup
	WebElement BrowseText;
	@FindBy(xpath = "//input[@class='hide']")
    @CacheLookup
    WebElement BrowseFileElement;


	public AddConnectorPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("AddConnectorPage Object created");
	}

	public String getSelectTabTitle() throws Exception
	{
		waitForElementVisible(selectStepElement,driver,"Verify element is visible.. "+selectStepElement);
		return selectStepElement.getText();
	}

	public String cancelButton() throws Exception
	{
		waitForElementVisible(cancelButtonElement,driver,"Verify element is visible.. "+cancelButtonElement);
		return cancelButtonElement.getText();
	}

	public String nextButton() throws Exception
	{
		waitForElementVisible(nextButtonElement,driver,"Verify element is visible.. "+nextButtonElement);
		return nextButtonElement.getText();
	}

	public DefineConnectorPage clickNextButton() throws Exception
	{
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Next");
		return new DefineConnectorPage(driver);
	}


	public void clickImportFromFileButton() throws Exception
	{
        WebElement element = findElement("//span[contains(text(),'Import from file')]",driver);
		click(element,driver,"Click on importFile Button");
 }

	public void uploadFlatfileFiles(String filePath1) throws Exception
	{
		logExtentReport("uploading the flatfile ...........");
		 String filePath = ResourceHelper.getResourcePath(filePath1);
         FileUpload fileUpload = new FileUpload(driver);
         fileUpload.fileUploadUsingInputType(BrowseFileElement, filePath);
        Thread.sleep(2000);
	}

  public String ButtonDisableORenable(String Button, String Message) {
	log.info("Operations text with name " +Button);
	logExtentReport(" Verifying the next button is disable or enable name  element is visible...."+Button);
    WebElement element = driver.findElement(By.xpath("//button[contains(text(),'" + Button + "')]"));
    if(element.isEnabled())
    {
    	return Message;
    }
    else
    {
    	return Message;
    }
  }

  public String TextDisabledorenabled(String text, String Message) {
		log.info("verify text with name " +text);
		logExtentReport(" Verifying the text  element is visible...."+text);
	    WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + text + "')]"));
	    if(element.isEnabled())
	    {
	    	return Message;
	    }
	    else
	    {
	    	return Message;
	    }
	  }

  public boolean isTextisdisabled(String text, String message)
  {
  	boolean status = false;
  	if(driver.getPageSource().contains(text))
  	{
  	    logExtentReport(message);
          status = true;
  	}
  	else
  		{
  		    logExtentReport(message);

  		}
  	return status;
  	}


    public void ClickTextButton(String text) throws Exception{
    log.info("Operations text with name " +text);
    logExtentReport("clicking on the clear button...."+text);
    WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + text + "')]"));
    element.click();

    }






	public void uploadSampleFlatfile() throws Exception
	{
		WebElement BrowseFileElement =findElement("//input[@class='file-upload hide']",driver);
        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\test_cr (1).txt");
        FileUpload fileupload = new FileUpload(driver);
        fileupload.fileUploadUsingInputType(BrowseFileElement,filePath);
        Thread.sleep(2000);

	}

	public void uploadFixedFlatfileWithNoRecordIdentifier() throws Exception
	{
		logExtentReport("uploading fixed flatfile with no record identifer..........");
		WebElement BrowseFileElement = findElement("//input[@class='file-upload hide']",driver);
        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\fixedlengthwithnorecord.txt");
        FileUpload fileupload = new FileUpload(driver);
        fileupload.fileUploadUsingInputType(BrowseFileElement,filePath);
        Thread.sleep(2000);

	}

	public void uploadSampleFileFlatfileWithNoRecordIdentifier() throws Exception
	{
		logExtentReport("uploading sample file flatfile with no record identifer..........");
		WebElement BrowseFileElement = findElement("//div[@class='col s12 new-file-btn clearfix no-padding']/input",driver);
        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\test_cr5 (2).txt");
        FileUpload fileupload = new FileUpload(driver);
        fileupload.fileUploadUsingInputType(BrowseFileElement,filePath);
        Thread.sleep(4000);

	}

	public void uploadVariableLengthFlatfile() throws Exception {
		logExtentReport("uploading variable length file flatfile with no record identifer..........");
		WebElement BrowseFileElement = findElement("//div[@class='col s12 new-file-btn clearfix no-padding']/input",driver);
        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\variable_length2.txt");
		fileUpload = new FileUpload(driver);
		fileUpload.fileUploadUsingInputType(BrowseFileElement,filePath);
        Thread.sleep(4000);

	}

	public void uploadSampleFileFlatfileWithNoRecordIdentifierCustomerIssue() throws Exception {
		logExtentReport("uploading sample file flatfile with no record identifer..........");
		WebElement BrowseFileElement = driver.findElement(By.xpath("//div[@class='col s12 new-file-btn clearfix no-padding']/input"));
		String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\FlatNoRec.txt");
		FileUpload fileupload = new FileUpload(driver);
		fileupload.fileUploadUsingInputType(BrowseFileElement,filePath);
		Thread.sleep(2000);

	}

	public void clickCreateMannualButton() throws Exception
	{
        WebElement element = findElement("//span[contains(text(),'Create manually')]",driver);
		click(element,driver,"Click on importFile Button");
 }

}
