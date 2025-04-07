package com.webMethodsUI.flow.pageObjects.DocumentType;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class DocumentTypeMainpage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(DocumentTypeMainpage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//button[contains(text(),'Add Document Type')]")
	@CacheLookup
	WebElement addDocumentTypeButtonElement;

	@FindBy(xpath = "//h5[contains(text(),'Document Types')]")
	@CacheLookup
	WebElement documentTypePageTitleElement;

	@FindBy(xpath = "//input[@id='fromScratch']")
	@CacheLookup
	WebElement fromScratchRadioButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	@CacheLookup
	WebElement okButtonElement;

	@FindBy(xpath = "//i[@class='dlt-icon-edit']")
	@CacheLookup
	WebElement editIconElement;

	@FindBy(xpath = "//i[@class='dlt-icon-more-menu']")
	@CacheLookup
	WebElement threeDotIconElement;

	@FindBy(xpath = "(//i[contains(@class,'dlt-icon-delete')])[1]")
	@CacheLookup
	WebElement deleteIconElement;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	WebElement deleteButtonElement;

	@FindBy(xpath = "//a[contains(text(),'Copy')]/i[contains(@class,'icon-copy')]")
	@CacheLookup
	WebElement copyIconElement;

	@FindBy(xpath = "//input[@placeholder='Name your Document Type']")
	@CacheLookup
	WebElement copyInputElement;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButtonElement;
	
	@FindBy(xpath = "//button[contains(text(),'Copy')]")
	@CacheLookup
	WebElement copyButtonElement;

	@FindBy(xpath = "//div[contains(text(),'saved successfully')]")
	@CacheLookup

	WebElement documentTypeCreateNotificationMessage;

	@FindBy(xpath = "//p[contains(text(),'No Document Types added yet!')]")
	@CacheLookup

	WebElement noDocumentAddedTextElement;

	@FindBy(xpath = "//label[contains(text(),'XML Schema')]")
	@CacheLookup

	WebElement buildFromXMLElement;

	@FindBy(xpath = "//input[@id='fromXmlSchema']")
	@CacheLookup

	WebElement buildFromXMLRadioButtonElement;
	
	@FindBy(xpath = "//p[contains(text(),'Copied successfully')]")
	@CacheLookup
	WebElement copiedMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public String notificationMessage_1 = "//div[@class='notification-message']";
	
	public String copiedMessage_1 = "//p[contains(text(),'Copied successfully')]";
	
	
	public String deletedMessage_1 = "//p[contains(text(),'deleted successfully')]";

	public DocumentTypeMainpage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(documentTypePageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info(" Document Type main page...." + documentTypePageTitleElement);
		logExtentReport("Document Type main page...." + documentTypePageTitleElement);
	}

	public String getAddDocumentTypeButtonElement() {
		log.info("  Verfing   Add document Button  Element is visible ...");
		logExtentReport("  Verfing   Add document Button  Element is visible ...");

		return addDocumentTypeButtonElement.getText();

	}

	public void clickOnAddDocumentTypeButton() {

		log.info("  Clicking on  Add Document  Button ...");
		logExtentReport(" Clicking on  Add Document  Button ...");
		waitHelper.waitForElement(addDocumentTypeButtonElement, ObjectReader.reader.getExplicitWait());
		addDocumentTypeButtonElement.click();

	}

	public boolean isSelectedBuildScratchRadioButton() {
		log.info("  Verifing  by default build  from scratch radio button is selected ...");
		logExtentReport(" Verifing  by default build from scratch radio button is selected ...");

		return fromScratchRadioButtonElement.isSelected();
	}

	public void clickOnOkButton() {

		log.info("  Clicking on ok button ...");
		logExtentReport(" Clicking on Ok button ...");
		waitHelper.waitForElement(okButtonElement, ObjectReader.reader.getExplicitWait());
		okButtonElement.click();

	}

	public void clickOnEditIcon() {

		log.info("  Clicking on Edit  icon  when single document present  ...");
		logExtentReport(" Clicking on Edit icon  when single document present  ...");
		waitHelper.waitForElement(editIconElement, ObjectReader.reader.getExplicitWait());
		editIconElement.click();

	}

	public void editMultipleDocumentType(int index) {

		log.info("  Clicking on three dot icon for editing  document type when multiple document type is present ...");
		logExtentReport(
				" Clicking on three dot icon for editing document type  when multiple document type is present... ...");
		List<WebElement> elemntArray = driver.findElements(By.xpath("//i[@class='dlt-icon-edit']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		log.info("element at index..." + index + "......" + element);
		element.click();

	}

	public void deleteDocType() {

		/*
		 * log.
		 * info("  Clicking on three dot icon for deleting document type ...");
		 * TestBase.
		 * logExtentReport(" Clicking on three dot icon for deleting document type ... ..."
		 * );
		 * 
		 * threeDotIconElement.click();
		 */
		log.info("  Clicking on delete icon for deleting document type ...");
		logExtentReport(" Clicking on delet icon for deleting document type ... ...");
		waitHelper.waitForElement(deleteIconElement, ObjectReader.reader.getExplicitWait());
		deleteIconElement.click();

		log.info("  Clicking on delete button for deleting document type ...");
		logExtentReport(" Clicking on delete button for deleting document type ... ...");
		waitHelper.waitForElement(deleteButtonElement, ObjectReader.reader.getExplicitWait());
		deleteButtonElement.click();

	}

	public void clickOnThreeDotIcon(int index) {

		log.info("  Clicking on three dot icon for deleting document type ...");
		logExtentReport(" Clicking on three dot icon for deleting document type ... ...");
		List<WebElement> elemntArray = driver.findElements(By.xpath("//i[@class='dlt-icon-more-menu']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		log.info("element at index..." + index + "......" + element);
		element.click();

	}

	public void DeleteMultipleDocumentType(String DocumentName) throws InterruptedException 
	{

		log.info("  Clicking on three dot icon for deleting document type ...");
		logExtentReport(" Clicking on three dot icon for deleting document type ... ...");
//		List<WebElement> elemntArray = driver.findElements(By.xpath("//i[@class='dlt-icon-more-menu']"));
//		log.info("All input parameters are....." + elemntArray);
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+DocumentName+"')]/parent::tr/td[6]/div[1]/button/i"));
		log.info("clicking at document ..." + DocumentName+ "......" + element);
		element.click();

		log.info("  Deleting documentType when multiple document present...");
		logExtentReport(" Deleting documentType when multiple document present...");
		WebElement element1 = driver.findElement(By.xpath("//td[contains(text(),'"+DocumentName+"')]/parent::tr/td[6]/div[1]/div/a[2]"));
		element1.click();
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.ENTER).perform();
//		// action.moveToElement(deleteIconElement).click().build().perform();
//
//		Thread.sleep(2000);
		log.info("  Clicking on delete button for deleting document type ...");
		logExtentReport(" Clicking on delete button for deleting document type ... ...");
		waitHelper.waitForElement(deleteButtonElement, ObjectReader.reader.getExplicitWait());
		deleteButtonElement.click();

	}
	
	public void DeleteDocumentType(int index,String DocumentName) throws Exception 
	{
		List<WebElement> elemntArray = findElements("//i[@class='dlt-icon-more-menu']",driver);
		WebElement element = elemntArray.get(index);
		click(element, driver, "  Clicking on Three dot icon ...");

		waitForElementVisible(deleteIconElement, driver, "Wait for delete Icon to be visible");
		click(deleteIconElement, driver, "Click on delete icon");
		Thread.sleep(5000);
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementVisible(deleteButtonElement, driver, "Wait for delete popup to be visible");
		click(deleteButtonElement, driver, "Click on delete button");
		waitForElementNotVisible(loader, driver, "wait for page load");
	    WebElement ele = findElement("//p[contains(text(),'Successfully deleted the generated document types.')]",driver);
	    waitForElementVisible(ele, driver, "Wait for deleted message to be visible");
	}
		


	public void copyMultipleDocumentType(int index) throws InterruptedException {
		waitHelper.waitForElement(threeDotIconElement, ObjectReader.reader.getExplicitWait());
		threeDotIconElement.click();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		waitHelper.waitForElement(copyIconElement, ObjectReader.reader.getExplicitWait());
		copyIconElement.click();
		System.out.println(">>>>>>>>>>>copyIconElement.click();>>>>>>>>>>>");

	}

	public void clickOnCopyIcon() {

		log.info("  Clicking on copy icon ...");
		logExtentReport(" Clicking on copy icon ...");
		waitHelper.waitForElement(threeDotIconElement, ObjectReader.reader.getExplicitWait());
		threeDotIconElement.click();
		waitHelper.waitForElement(copyIconElement, ObjectReader.reader.getExplicitWait());
		copyIconElement.click();

	}

	public String CopyDocType(int index, String copyDocTypeName) throws Exception 
	{
		List<WebElement> elemntArray = findElements("//i[@class='dlt-icon-more-menu']",driver);
		WebElement element = elemntArray.get(index);
		click(element, driver, "  Clicking on Three dot icon ...");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		log.info("  Clicking on copy icon ...");
		logExtentReport(" Clicking on copy icon ....");
		jse.executeScript("arguments[0].click()", copyIconElement);

		enterValue(copyInputElement, copyDocTypeName, driver, " Entering the name of copy document type  ...");
		click(copyButtonElement, driver, "  Clicking on Save button ...");
		
		waitForElementVisible(copiedMessage, driver, "wait for copied message to visible");
		waitForElementNotVisible(copiedMessage_1, driver, "wait for copied message to invisible");

		return copyDocTypeName;

	}

	public void clickOnSaveButton() {

		log.info("  Clicking on Save button ...");
		logExtentReport(" Clicking on Save button ...");
		waitHelper.waitForElement(saveButtonElement, ObjectReader.reader.getExplicitWait());
		saveButtonElement.click();

	}

	public boolean verifyDocumentTypeName(String docTypeName) {

		log.info("  Verifing" + docTypeName + " document name is visible.......... ");
		logExtentReport(" Verifing" + docTypeName + " document name is visible..........  ");

		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + docTypeName + "')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());

		return element.isDisplayed();

	}

	public boolean verifyDocumentTypeDescription(String docTypeDescription) {

		log.info("  Verifing" + docTypeDescription + " document description is visible.......... ");
		logExtentReport(" Verifing" + docTypeDescription + " document description is visible..........  ");

		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + docTypeDescription + "')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		//element.getText();
		return element.isDisplayed();

	}

	public String getNoDocumenttitleText() {

		log.info("  Veriging " + noDocumentAddedTextElement.getText() + " text .....");
		logExtentReport("  Veriging " + noDocumentAddedTextElement.getText() + " text ....");
		waitHelper.waitForElement(noDocumentAddedTextElement, ObjectReader.reader.getExplicitWait());
		return noDocumentAddedTextElement.getText();

	}

	public void selectBuildFromXMLRadioButton() {

		log.info("  Selecting build from XML radio button........");
		logExtentReport("  Selecting build from XML radio button....... ....");
		buildFromXMLElement.click();
	}

	public boolean verifyBuildFromRadioButtonSelected() {

		log.info("  Verifying build from XML radio button is selected ........");
		logExtentReport(" Verifying Selecting build from XML radio button is selected...... ....");
		return buildFromXMLRadioButtonElement.isSelected();
	}

}
