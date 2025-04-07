package com.webMethodsUI.flow.pageObjects.DocumentType;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class FileDescriptionPage {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(FileDescriptionPage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h3[contains(text(),'File Description')]")
	@CacheLookup
	WebElement fileDescriptionElement;

	@FindBy(xpath = "//input[@id='text-name']")
	@CacheLookup
	WebElement documentTypeNameElement;

	@FindBy(xpath = "//textarea[@id='text-area-1']")
	@CacheLookup
	WebElement documentTypeDescriptionElement;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;

	public FileDescriptionPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(fileDescriptionElement, ObjectReader.reader.getExplicitWait());
		log.info("  verifing  file description  text is visible  ...." + fileDescriptionElement);
		logExtentReport(" verifing  file description  text is visible  ....");
	}

	public void enterDocumentTypeName(String docTypeName) {
		log.info("  Entering document type name ...");
		logExtentReport(" Entering document type name ... ...");

		documentTypeNameElement.sendKeys(docTypeName);

	}

	public void enterDocumentTypeDescription(String docTypeDescription) {
		log.info("  Entering document type description ...");
		logExtentReport(" Entering document type description ... ...");
		documentTypeDescriptionElement.sendKeys(docTypeDescription);

	}

	public void clickOnNextButton() {
		log.info("  Clicking on next button...");
		logExtentReport(" Clicking on next button....");
		waitHelper.waitForElement(nextButtonElement, ObjectReader.reader.getExplicitWait());
		nextButtonElement.click();

	}
	
	
	public boolean verifyFileUploaded(String fileName)
	{
		
		log.info("  Verifing file is uploaded or not.. ...");
		logExtentReport("  Verifing file is uploaded or not.... ...");
	WebElement element = driver.findElement(By.xpath("//li[contains(text(),'"+fileName+"')]"));
		 return element.isDisplayed();
	
	
	}

	public void uploadfileBic7155() throws Exception{
		WebElement BrowseFileElement1 = driver.findElement(By.xpath("//input[@id='file-importer-primary']"));
		String filePath1 = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\5mbs.xsd");
		FileUpload fileupload = new FileUpload(driver);
		fileupload.fileUploadUsingInputType(BrowseFileElement1, filePath1);
	}

}
