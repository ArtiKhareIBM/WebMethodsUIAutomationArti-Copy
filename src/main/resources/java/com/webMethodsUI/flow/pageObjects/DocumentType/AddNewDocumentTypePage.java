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
import com.webMethodsUI.flow.testbase.TestBase;

import java.util.List;

public class AddNewDocumentTypePage {

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

	public AddNewDocumentTypePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(addNewDocumentTypePageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("  verifing  add new document text is visible  ...." + addNewDocumentTypePageTitleElement);
		logExtentReport(" verifing  add new document text is visible  ....");
	}

	public void enterDocumentTypeName(String docTypeName) {
		log.info("  Entering document type name ...");
		logExtentReport(" Entering document type name ... ...");

		documentTypeNameElement.sendKeys(docTypeName);

	}

	public void enterDocumentTypeDescription(String docTypeDescription) {
		log.info("  Entering document type discription ......");
		logExtentReport(" Entering document type discription .......");

	}

	public void createDataField() {
		log.info("  clicking on plus icon to create data field ...");
		logExtentReport("  clicking on plus icon to create data field ..");
		waitHelper.waitForElement(plusIconElement, ObjectReader.reader.getExplicitWait());
		plusIconElement.click();

	}

	public void enterDataFieldName(String dataFieldName) {
		log.info("  Entering data field name  ...");
		logExtentReport("  Entering data field name ...");
		dataFieldNameElement.clear();
		dataFieldNameElement.sendKeys(dataFieldName);

	}

	public boolean isSaveButtonEnable() {
		log.info("  verifing  save button  is enable  ...");
		logExtentReport("   verifing  save button  is enable .....");

		return saveButtonElement.isEnabled();

	}

	public void clickOnSaveButton() {
		log.info("  Clicking on save button ...");
		logExtentReport(" Clicking on save button .....");
		waitHelper.waitForElement(saveButtonElement, ObjectReader.reader.getExplicitWait());
		saveButtonElement.click();

	}

	public boolean verifyDataField() {

		log.info("  Verifing data fields ........ ...");
		logExtentReport(" Verifing data fields  .. .....");
		waitHelper.waitForElement(plusIconDataFieldElement, ObjectReader.reader.getExplicitWait());
		plusIconDataFieldElement.click();
		plusIconDataFieldElement.click();
		firstnameElement.isDisplayed();
		 return lastnameElement.isDisplayed();

	}


	public void createmultipleDataField(int index,String dataFieldName) {
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
