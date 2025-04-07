package com.webMethodsUI.flow.pageObjects.restapi;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.webMethodsUI.flow.testbase.CommonActions;

public class RestApiLetsGetStartedPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(RestApiLetsGetStartedPage.class);

	@FindBy(xpath = "//span[contains(text(),'get started')]")
	@CacheLookup
	WebElement getStartedTitleElement;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;

	@FindBy(xpath = "//span[contains(text(),'Create from scratch / Design new API')]")
	@CacheLookup
	WebElement createFromScratchElement;

	@FindBy(xpath = "//span[contains(text(),'Import API Using URL')]")
	@CacheLookup
	WebElement createImportApiUsingUrl;
	
	
	@FindBy(xpath = "//span[contains(text(),'Import API Using URL')]/ancestor::div[1]/input")
	@CacheLookup
	WebElement importApiUsingUrlradiobutton;
	
	
	//label[@class='radio-btn-label' and @for='importRestAPI']
	
	//@FindBy(xpath = "//span[@class='title-start']")
	//@CacheLookup
	//WebElement getStartedTitleElement;
	
	@FindBy(xpath = "//div[@class='create-api-inner-content']//div[1]//p[1]//div[1]//label[1]")
	@CacheLookup
	WebElement createFromscratchButtonElement;

	@FindBy(xpath = "//span[contains(text(),'Import API / I have an existing API')]")
	@CacheLookup
	WebElement importAPIElement;

	@FindBy(xpath = "//span[contains(text(),'Import API Using URL')]")
	@CacheLookup
	WebElement importAPIURLElement;
	@FindBy(xpath = "//span[text()='Import API / I have an existing API']")
	@CacheLookup
	WebElement importAPIButton;



	@FindBy(xpath = "//div[@class='create-new-manage-api']//div[2]//p[1]//div[1]//label[1]")
	@CacheLookup
	WebElement importAPIButtonElement;


	@FindBy(xpath = "//div[@class='create-new-manage-api']//div[3]//p[1]//div[1]//label[1]/span")
	@CacheLookup
	WebElement importAPIfromURLElement;

	@FindBy(xpath = "//input[@id='myRecipiesfileInput']")
	@CacheLookup
	WebElement BrowseFileElement;

	@FindBy(xpath = "//span[text()='Create API by importing API from a specified file.']")
	@CacheLookup
	WebElement getapielemet;


	

	public RestApiLetsGetStartedPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		log.info("Rest API lets get started page object created");
		logExtentReport("Rest API lets get started page object created");

	}

	public RestApiBasicInfoPage clickOnNext() throws Exception {

			click(nextButtonElement, driver, "clicking on Next button...");
			return new RestApiBasicInfoPage(driver);

	}

	public String getCreateFromScratchLabel() {

		log.info("getting the api from scratch label text....");
		logExtentReport("getting the api from scratch label text....");
		return createFromScratchElement.getText();
	}
	
	public String getCreateImportApiUsingUrl() {

		log.info("getting the api from scratch label text....");
		logExtentReport("getting the api from scratch label text....");
		return createImportApiUsingUrl.getText();
	}
	
	public String getImportAPILabel() throws Exception {

		log.info("getting the api ImportAPI text....");
		logExtentReport("getting the api ImportAPI text....");
		waitForElementVisible(importAPIElement, driver, "Verify import API desciption is visible.."+importAPIElement);
		return importAPIElement.getText();
	}

	public String getImportAPIUrlLabel() throws Exception {

		log.info("getting the api ImportAPI text....");
		logExtentReport("getting the api ImportAPI text....");
		waitForElementVisible(importAPIURLElement, driver, "Verify import API desciption is visible.."+importAPIURLElement);
		return importAPIURLElement.getText();
	}
	
	
	public String getStartedTitle() {
		log.info("Getting the get started title..............");
		logExtentReport("Getting the get started title..............");
		return getStartedTitleElement.getText();
	}
	
	public String createFromscratchButton() {
		log.info("Getting the createFromscratchButton..............");
		logExtentReport("Getting the createFromscratchButton..............");
		return createFromscratchButtonElement.getText();
	}
	
	public String importAPIButton() {
		log.info("Getting the importAPIButton..............");
		logExtentReport("Getting the importAPIButton..............");
		return importAPIButtonElement.getText();
	}
	public String nextButton() {
		log.info("Getting the nextButton..............");
		logExtentReport("Getting the nextButton..............");
		return nextButtonElement.getText();
	}
	
	public String ClickImportAPIbutton() {
		log.info("clicking ClickImportAPIbutton..............");
		logExtentReport("clicking  ClickImportAPIbutton..............");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",importAPIButton);
		return getapielemet.getText();
	}

	public void uploadswaggerFile(String filePath1) throws Exception
	{
		logExtentReport("uploading the swaggerfile ...........");
		String filePath = ResourceHelper.getResourcePath(filePath1);
		FileUpload fileUpload = new FileUpload(driver);
		fileUpload.fileUploadUsingInputType(BrowseFileElement, filePath);
		Thread.sleep(2000);
	}

	public void clickingImportfromurlbutton(){
		log.info("clicking importAPIfromURLButton..............");
		logExtentReport("clicking  importAPIfromURLButton..............");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",importAPIfromURLElement);

	}
	
	 

}
