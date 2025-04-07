package com.webMethodsUI.flow.pageObjects.DocumentType;

import com.webMethodsUI.flow.helper.DropDown.DropDownHelper;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import java.util.List;

public class AddNewDocumentTypePage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(DocumentTypeMainpage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h4[contains(text(),'Add new Document type')]")
	@CacheLookup
	WebElement addNewDocumentTypePageTitleElement;

	@FindBy(xpath = "//input[@id='ut-doc-type-name']")
	@CacheLookup
	WebElement documentTypeNameElement;

	@FindBy(xpath = "//textarea[@id='ut-doc-type-desc']")
	@CacheLookup
	WebElement documentTypeDescriptionElement;

	@FindBy(xpath = "//a[@class='io-tree-action-icon io-add-icon dlt-icon-plus ng-star-inserted']")
	@CacheLookup
	WebElement plusIconElement;

	@FindBy(xpath = "//input[@placeholder='Field name']")
	@CacheLookup
	WebElement dataFieldNameElement;

	@FindBy(xpath = "//input[@value='Save']")
	@CacheLookup
	WebElement saveButtonElement;

	@FindBy(xpath = "//i[@class='tree-icon dlt-icon-plus ng-star-inserted']")
	@CacheLookup
	WebElement plusIconDataFieldElement;

	@FindBy(xpath = "//span[contains(text(),' firstname ')]")
	@CacheLookup
	WebElement firstnameElement;

	@FindBy(xpath = "//span[contains(text(),' lastname ')]")
	@CacheLookup
	WebElement lastnameElement;


	@FindBy(xpath = "//label[contains(text(),'Content Type')]/parent::div/div[1]/select")
	@CacheLookup
	WebElement SelectConstraintElement;

	@FindBy(xpath = "//p[contains(text(),'saved successfully')]")
	@CacheLookup
	WebElement createdMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public String notificationMessage_1 = "//div[@class='notification-message']";
	
	public String createdMessage_1 = "//p[contains(text(),'saved successfully')]";
	
	public AddNewDocumentTypePage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForElementVisible(addNewDocumentTypePageTitleElement, driver, "Wait for add new document type title to visible");
	}

	public void enterDocumentTypeName(String docTypeName) throws Exception 
	{
		enterValue(documentTypeNameElement, docTypeName, driver, "  Entering document type name ...");
	}

	public void enterDocumentTypeDescription(String docTypeDescription) throws Exception
	{
		enterValue(documentTypeDescriptionElement, docTypeDescription, driver, " Entering document type discription ......");

	}

	public void createDataField() throws Exception 
	{
		click(plusIconElement, driver, "  clicking on plus icon to create data field ...");
	}

	public void enterDataFieldName(String dataFieldName) throws Exception 
	{
		clearAndEnterText(dataFieldNameElement, dataFieldName, driver, "  Entering data field name  ...");
	}

	public boolean isSaveButtonEnable() 
	{
		log.info("  verifing  save button  is enable  ...");
		logExtentReport("   verifing  save button  is enable .....");

		return saveButtonElement.isEnabled();

	}

	public void clickOnSaveButton() throws Exception 
	{
		click(saveButtonElement, driver, "  Clicking on save button ...");
		waitForElementVisible(createdMessage,driver,"Verify Document saved successfully message is visible");
		waitForElementNotVisible(createdMessage_1,driver,"Verify Document saved successfully message to invisible");
		waitForElementNotVisible(loader, driver, "wait for page load");

	}

	public boolean verifyDataField() throws Exception 
	{
		waitForElementVisible(plusIconDataFieldElement, driver, "  Verifing data fields ........ ...");
		plusIconDataFieldElement.click();
		plusIconDataFieldElement.click();
		firstnameElement.isDisplayed();
		 return lastnameElement.isDisplayed();

	}


	public void createmultipleDataField(int index,String dataFieldName) 
	{
		log.info("  Creating Data Field   at" + index+ "with name"+ dataFieldName);
		logExtentReport(" Creating Data Field   at" + index+ "with name"+ dataFieldName);

		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//input[@placeholder='Field name']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		log.info("element at index..." + index + "......" + element);
		element.click();
		element.clear();
		element.sendKeys(dataFieldName);


	}

	public void addingconstrains(){
		DropDownHelper dropdown = new DropDownHelper(driver);
		dropdown.selectUsingVisibleText(SelectConstraintElement,"anySimpleType");
	}

	public void EntermaxminlengthOfContrain(int index,String Maxlength,String Minlength) {
		//Entering Minimun length
		log.info("Entering max and min length at" + index);
		logExtentReport("Entering max and min length at" + index);
		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//label[contains(text(),'Minimum Length')]/parent::div/div/input"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		log.info("element at index..." + index + "......" + element);
		element.click();
		element.clear();
		element.sendKeys(Minlength);

		//Entering Maximum length
		List<WebElement> elemntArray1 = driver
				.findElements(By.xpath("//label[contains(text(),'Maximum Length')]/parent::div/div/input"));

		log.info("All input parameters are....." + elemntArray);
		WebElement element1 = elemntArray1.get(index);
		log.info("element at index..." + index + "......" + element);
		element1.click();
		element1.clear();
		element1.sendKeys(Maxlength);
	}


}
