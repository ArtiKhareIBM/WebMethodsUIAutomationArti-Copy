package com.webMethodsUI.flow.pageObjects.DocumentType;

import java.util.Set;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class DocumentTypePage {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(DocumentTypePage.class);
	TestBase test;

	WaitHelper waitHelper;
	@FindBy(xpath = " //h4[contains(text(),'Document type')]")
	@CacheLookup
	WebElement documentTypePageTitleElement;

	@FindBy(xpath = "//textarea[@id='ut-doc-type-desc']")
	@CacheLookup
	WebElement documentTypeDescriptionElement;

	@FindBy(xpath = "//input[@value='Save']")
	@CacheLookup
	WebElement saveButtonElement;
	
	@FindBy(xpath = "//i[@class='tree-icon dlt-icon-plus ng-star-inserted']")
	@CacheLookup
	WebElement plusIconDataFieldElement;
	
	
	
	
	
	@FindBy(xpath = "//a[@title='Add a new field (ALT+A)']")
	@CacheLookup
	WebElement addNewFieldPlusIconElement;
	
	

	public DocumentTypePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(documentTypePageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info(" document page ....................." + documentTypePageTitleElement);
		
		
		
		logExtentReport(" document page ...........");
	}

	public void enterDocumentTypeDescription(String docTypeDescription) {
		log.info("  Updating description field ...");
		logExtentReport(" Updating description field .........");
		
	

		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("..Total window ........" + count);
		for (String child : allWindows) {

			if (parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				log.info(" Entering description  value ...");
				documentTypeDescriptionElement.click();
				

				documentTypeDescriptionElement.sendKeys(docTypeDescription);
				
				//saveButtonElement.click();
				
			}
		}

	}

	public void clickOnSaveButton() {
		log.info("  Clicking on save button ...");
		logExtentReport("Clicking on save button ...");
		waitHelper.waitForElement(saveButtonElement, ObjectReader.reader.getExplicitWait());
		saveButtonElement.click();

	}
	public void clickOnDataFieldPlusIcon(){
		log.info("  Clicking on plus icon to verify data field ...");
		logExtentReport("Clicking on plus icon to verify data field...");
		waitHelper.waitForElement(plusIconDataFieldElement, ObjectReader.reader.getExplicitWait());
		plusIconDataFieldElement.click();
		
	}
	
	public boolean verifyAddFieldPlusIconIsDisable(){
		log.info("  verifing add field plus icon is disable ...");
		logExtentReport("verifing add field plus icon is disable ....");
		return addNewFieldPlusIconElement.isEnabled();
		
	}
	public boolean verifyCreatedDocumentName(String documentName){
		log.info("  verifing Created documnet type name  ...");
		logExtentReport("verifing Created documnet type name  ....");
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+ documentName+ "')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		WebElement element1 = driver.findElement(By.xpath("//td[contains(text(),'docTypeRef_StudentType')]"));
		return element.isDisplayed();
		
	}
	

}
