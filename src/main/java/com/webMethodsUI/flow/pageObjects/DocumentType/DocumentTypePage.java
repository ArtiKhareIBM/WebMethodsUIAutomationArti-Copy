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
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class DocumentTypePage extends CommonActions{

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
	
	@FindBy(xpath = "//p[contains(text(),'updated successfully')]")
	@CacheLookup
	WebElement updatedMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public String notificationMessage_1 = "//div[@class='notification-message']";
	
	public String updatedMessage_1 = "//p[contains(text(),'updated successfully')]";
	

	public DocumentTypePage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForElementVisible(documentTypePageTitleElement, driver, "Wait for document typage page is visible",60);
	}

	public void enterDocumentTypeDescription(String docTypeDescription) 
	{
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

	public void clickOnSaveButton() throws Exception 
	{
		click(saveButtonElement, driver, "Clicking on save button ...");
		waitForElementVisible(updatedMessage,driver,"Verify Document updated successfully message is visible");
		waitForElementNotVisible(updatedMessage_1, driver, "wait for notification to be invisible");
		waitForElementNotVisible(loader, driver, "wait for page load");
		
	}
	
	public void clickOnDataFieldPlusIcon() throws Exception
	{
		click(plusIconDataFieldElement, driver, "  Clicking on plus icon to verify data field ...");
		
	}
	
	public boolean verifyAddFieldPlusIconIsDisable()
	{
		log.info("  verifing add field plus icon is disable ...");
		logExtentReport("verifing add field plus icon is disable ....");
		return addNewFieldPlusIconElement.isEnabled();
		
	}
	public void verifyCreatedDocumentName(String documentName) throws Exception
	{
		WebElement element = findElement("//td[contains(text(),'"+ documentName+ "')]",driver);
		waitForElementVisible(element, driver, "  verifing Created documnet type name is visible ...");
		WebElement element1 = findElement("//td[contains(text(),'docTypeRef_StudentType')]",driver);
//		return element.isDisplayed();
		waitForElementVisible(element1, driver, "  verifing Created documnet type reference docTypeRef_StudentType is visible ...");
		
	}
	

}
