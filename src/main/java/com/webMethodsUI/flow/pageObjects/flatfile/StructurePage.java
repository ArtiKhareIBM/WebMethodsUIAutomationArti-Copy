package com.webMethodsUI.flow.pageObjects.flatfile;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class StructurePage extends CommonActions{
	WebDriver driver;
	private Logger log = LogManager.getLogger(StructurePage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//h1[contains(text(),'Flat File Structure')]")
	@CacheLookup
	WebElement flatfileStructureHeadingElement;



	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement cancelButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	@CacheLookup
	WebElement previousButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButtonElement;

	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-plus icon-mr action-icon']")
	@CacheLookup
	WebElement MainRecordPlusButtonElement;

	@FindBy(xpath = "//input[@name='Name']")
	@CacheLookup
	WebElement recordTextfieldElement;

	@FindBy(xpath = "//span[@data-eventmap='select-dropdown']")
	@CacheLookup
	WebElement maxRepeatDropdownElement;

	@FindBy(xpath = "//div[@title='Unlimited']")
	@CacheLookup
	WebElement unlimitedTitleElement;

	@FindBy(xpath = "//span[@class='switch-handle default']")
	@CacheLookup
	WebElement switcherButtonElement;

	@FindBy(xpath = "//input[@name='Alternate name']")
	@CacheLookup
	WebElement alternateNameTextfieldElement;

	@FindBy(xpath = "//input[@name='Description']")
	@CacheLookup
	WebElement descriptionTextfieldElement;

	@FindBy(xpath = "//div[@title='Field definition']")
	@CacheLookup
	WebElement fieldDefinitionTypeElement;

	@FindBy(xpath = "//input[@name='Extractor']")
	@CacheLookup
	WebElement extractorValueElement;

	@FindBy(xpath = "//div[@title='Composite definition']")
	@CacheLookup
	WebElement compositeDefinitionTypeElement;


	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-edit icon-mr action-icon ']")
	@CacheLookup
	WebElement Editicon;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";


	public StructurePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("element is visible now...." + cancelButtonElement);
		logExtentReport("Structure page Object created");
	}


	public String getFlatfileStructureHeading() throws Exception
	{
		elementContainsText(flatfileStructureHeadingElement, "Flat File Structure", driver, "Verify flat file structure header is visible");
		return flatfileStructureHeadingElement.getText();
	}

	public String verfiyingFieldStructire(String FieldName) throws Exception {
		log.info("element is visible now....");
		WebElement element = findElement("//div[contains(text(),'" + FieldName + "')]",driver);
		logExtentReport("element is visible now.... and element text is  " +element.getText());
		return element.getText();
	}
	public String getCancelButton() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +cancelButtonElement.getText());
		return cancelButtonElement.getText();
	}

	public String getPreviousButton() 
	{
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +previousButtonElement.getText());
		return previousButtonElement.getText();
	}

	public String getSaveButton() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +saveButtonElement.getText());
		return saveButtonElement.getText();
	}

	public void clickPlusIcon(int index) {



	    log.info("  Clicking on plus icon ..." +index);
	    logExtentReport(" Clicking on plus icon ..." +index);

	    List<WebElement> elemntArray = driver
	            .findElements(By.xpath("//i[@class='delite-icon dlt-icon-plus icon-mr action-icon']"));

	    WebElement element = elemntArray.get(index);
	    element.click();
	}


	public void enterRecordName(int index, String value) {

		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("..Total window ........" + count);
		for (String child : allWindows) {

			if (parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				log.info(" Entering Record Name ...");

				List<WebElement> elemntArray = driver.findElements(By.xpath("//input[@name='Name']"));
				log.info("All input parameters are....." + elemntArray);
				WebElement element = elemntArray.get(index);
				log.info(" Clicking on element at index..." + index + "......" + element);
				logExtentReport("Clicking on element at index..." + index + "......" + element);
				element.click();
				element.clear();
				element.sendKeys(value);
			}
		}

	}


	public void entersubfiednameName(int index, String value) throws Exception {

		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("..Total window ........" + count);
		for (String child : allWindows) {

			if (parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				log.info(" Entering Record Name ...");

				List<WebElement> elemntArray = driver.findElements(By.xpath("//input[@name='Name']"));
				log.info("All input parameters are....." + elemntArray);
				WebElement element = elemntArray.get(index);
				log.info(" Clicking on element at index..." + index + "......" + element);
				logExtentReport("Clicking on element at index..." + index + "......" + element);
				element.click();
				element.clear();
				Thread.sleep(1000);
				element.sendKeys(value);

			}
		}

	}
//	public void typeSubField1Name(int index ,String value1) {
//
//		String parent = driver.getWindowHandle();
//		Set<String> allWindows = driver.getWindowHandles();
//		int count = allWindows.size();
//		System.out.println("..Total window ........" + count);
//		for (String child : allWindows) {
//
//			if (parent.equalsIgnoreCase(child)) {
//				driver.switchTo().window(child);
//
//				log.info(" Entering Record Name ...");
//
//				List<WebElement> elemntArray = driver
//						.findElements(By.xpath("//input[@name='Name']"));
//				log.info("All input parameters are....." + elemntArray);
//				WebElement element = elemntArray.get(index1);
//				log.info(" Clicking on element at index..." + index1 + "......" + element);
//				logExtentReport("Clicking on element at index..." + index1 + "......" + element);
//				element.click();
//				element.clear();
//				element.sendKeys(value1);
//
//			}
//		}
//
//	}






	public void typeSubField1Name() throws InterruptedException {
        log.info("Clicking and typing the SubField1 value");
        logExtentReport("Clicking and typing the SubField1 value");
        WebElement element = driver.findElement(By.xpath("(//input[@class='inputElement  filled required-field'])[3]"));
        element.click();
        element.clear();
        Thread.sleep(3000);
        element.sendKeys("SubField1");

 }

	public void typeSubField2Name() throws InterruptedException {
        log.info("Clicking and typing the SubField2 value");
        logExtentReport("Clicking and typing the SubField2 value");
        WebElement element = driver.findElement(By.xpath("(//input[@class='inputElement  filled required-field'])[5]"));
        element.click();
        element.clear();
        Thread.sleep(3000);
        element.sendKeys("SubField2");
 }

	public void maxRepeatDropdown(String MaxRepeat) throws Exception {

		log.info("  Clicking on plus icon ..." +MaxRepeat);
	    logExtentReport(" Clicking on plus icon ..." +MaxRepeat);

	    //List<WebElement> elemntArray = driver.findElements(By.xpath("//span[contains(text(),'Max repeat')]/parent::div/div/div/div"));
	    //WebElement element = elemntArray.get(index);
	    WebElement element = findElement("//i[@class='delite-icon dlt-icon-chevron-down']",driver);
	    element.click();
	    WebElement element1 = findElement("//span[contains(text(),'Max repeat')]/parent::div/div/div/div/div[text()=1]",driver);
	    GenericHelper genericHelper = new GenericHelper(driver);
	    genericHelper.clickOnDropDown(element1,0);
		genericHelper.selectDropDownLink(MaxRepeat);
	    WebElement element2 = findElement("//i[@class='delite-icon dlt-icon-chevron-up']",driver);
	    element2.click();
	    //WebElement element3 = findElement("//i[@class='delite-icon dlt-icon-cross icon-mr action-icon ']",driver);
	    //element3.click();


	}

	public void selectElementTypeDropdown(String FieldTypeName,String fieldType, int index, int index1) throws Exception {



	    log.info("  Clicking on plus icon ..." +fieldType);
	    logExtentReport(" Clicking on plus icon ..." +fieldType);

	    //WebElement element = findElement("//i[@class='delite-icon dlt-icon-chevron-down']",driver);
	    //element.click();
	    List<WebElement> elemntArray = driver.findElements(By.xpath("//i[@class='delite-icon dlt-icon-chevron-down']"));
		WebElement element = elemntArray.get(index);
		element.click();
       //List<WebElement> elemntArray = driver.findElements(By.xpath("//span[contains(text(),'Element type')]/parent::*/parent::*/parent::*/following-sibling::span"));
       //WebElement element = elemntArray.get(index);
	    WebElement element1 = findElement("//div[contains(text(),'" + FieldTypeName + "')]",driver);
	    GenericHelper genericHelper = new GenericHelper(driver);
	    genericHelper.clickOnDropDown(element1,0);
		genericHelper.selectDropDownLink(fieldType);
		//WebElement element2 = findElement("//i[@class='delite-icon dlt-icon-chevron-up']",driver);
		//element2.click();
		List<WebElement> elemntArray1 = driver.findElements(By.xpath("//i[@class='delite-icon dlt-icon-chevron-up']"));
		WebElement element2 = elemntArray1.get(index1);
		element2.click();
	    //element1.click();
	}

	public void selectElementTypeDropdowNEW(String FieldTypeName, String fieldType) throws Exception {

		WebElement element1 = findElement("//div[contains(text(),'" + FieldTypeName + "')]",driver);
	    GenericHelper genericHelper = new GenericHelper(driver);
	    genericHelper.clickOnDropDown(element1,0);
		genericHelper.selectDropDownLink(fieldType);

	}

	public void clickUnlimitedOptionButton(){
		log.info("clicking Unlimited  Button..............");
		logExtentReport("clicking Unlimited Button..............");
		waitHelper.waitForElement(unlimitedTitleElement, ObjectReader.reader.getExplicitWait());
		unlimitedTitleElement.click();
	}

	public void clickFieldDefinitionTypeButton(){
		log.info("clicking Field Definition  Button..............");
		logExtentReport("clicking Field Definition Button..............");
		waitHelper.waitForElement(fieldDefinitionTypeElement, ObjectReader.reader.getExplicitWait());
		fieldDefinitionTypeElement.click();
	}



	public void clickCompositeDefinitionLink(int index) {



	    log.info("  Clicking on plus icon ..." +index);
	    logExtentReport(" Clicking on plus icon ..." +index);

	    List<WebElement> elemntArray = driver
	            .findElements(By.xpath("//div[@title='Composite definition']"));

	    WebElement element = elemntArray.get(index);
	    element.click();
	}



	public void switchButton(int index) {



	    log.info("  Clicking on plus icon ..." +index);
	    logExtentReport(" Clicking on plus icon ..." +index);

	    List<WebElement> elemntArray = driver
	            .findElements(By.xpath("//span[@class='switch-handle default']"));

	    WebElement element = elemntArray.get(index);
	    element.click();
	}

	public void alternateNameText(int index) {



	    log.info("  Clicking on plus icon ..." +index);
	    logExtentReport(" Clicking on plus icon ..." +index);

	    List<WebElement> elemntArray = driver
	            .findElements(By.xpath("//input[@name='Alternate name']"));

	    WebElement element = elemntArray.get(index);
	    element.click();
	}

	public void descriptionText(int index) {



	    log.info("  Clicking on plus icon ..." +index);
	    logExtentReport(" Clicking on plus icon ..." +index);

	    List<WebElement> elemntArray = driver
	            .findElements(By.xpath("//input[@name='Description']"));

	    WebElement element = elemntArray.get(index);
	    element.click();
	}

	public void clickSchemaRecordPlusButton(){
		log.info("clicking SchemaRecordPlusButton..............");
		logExtentReport("clicking  SchemaRecordPlusButton..............");
		waitHelper.waitForElement(MainRecordPlusButtonElement, ObjectReader.reader.getExplicitWait());
		MainRecordPlusButtonElement.click();
	}

	public void typeExtractorValue(int index, String value, int index1) {

		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("..Total window ........" + count);
		for (String child : allWindows) {

			if (parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				log.info(" Entering Record Name ...");

				List<WebElement> elemntArray = driver
						.findElements(By.xpath("//input[@name='Extractor']"));
				log.info("All input parameters are....." + elemntArray);
				WebElement element = elemntArray.get(index);
				log.info(" Clicking on element at index..." + index + "......" + element);
				logExtentReport("Clicking on element at index..." + index + "......" + element);
				element.click();
				element.clear();
				element.sendKeys(value);
				WebElement elemntArray1 = driver.findElement(By.xpath("//i[@class='delite-icon dlt-icon-cross icon-mr action-icon ']"));
				elemntArray1.click();

			}
		}

	}



	public void clickAddRecordPlusIcon() throws Exception
	{
		WebElement element = findElement("//i[@class='delite-icon dlt-icon-plus icon-mr action-icon ']",driver);
		click(element, driver, "Clicking the add record plus icon..............");
	}

	public void clickAddRecordPlusIconForCRLFRecord(int index) throws InterruptedException
	{
		log.info("Clicking the add record plus icon..............");
		logExtentReport("Clicking the add record plus icon..............");
		JavascriptExecutor Field1 = (JavascriptExecutor) driver;
		List<WebElement> elemntArray =  driver.findElements(By.xpath("//i[@class='delite-icon dlt-icon-plus icon-mr action-icon ']"));
		WebElement element = elemntArray.get(index);
		//WebElement element = driver.findElement(By.xpath("//i[@class='delite-icon dlt-icon-plus icon-mr action-icon ']"));
		//WebElement element2 = driver.findElement(By.xpath("//i[@class='delite-icon dlt-icon-plus icon-mr action-icon ']"));
		Field1.executeScript("arguments[0].click();",element);
		Thread.sleep(2000);

		}

	public void clickAddRecordPlusIconForCRLFRecord1(int index) throws Exception
	{
		log.info("Clicking the add record plus icon..............");
		logExtentReport("Clicking the add record plus icon..............");
		//JavascriptExecutor Field1 = (JavascriptExecutor) driver;
		List<WebElement> elemntArray =  driver.findElements(By.xpath("//i[@class='delite-icon dlt-icon-plus icon-mr action-icon ']"));
		WebElement element = elemntArray.get(index);
		//WebElement element2 = driver.findElement(By.xpath("//i[@class='delite-icon dlt-icon-plus icon-mr action-icon ']"));
		//Field1.executeScript("arguments[0].click();",element);
		element.click();
		Thread.sleep(2000);

		}

	public void clickAddRecordPlusIconForField2CompositeRecord() throws Exception
	{
		log.info("Clicking the add record plus icon..............");
		logExtentReport("Clicking the add record plus icon..............");
        JavascriptExecutor SubField1 = (JavascriptExecutor) driver;
		WebElement element4 = driver.findElement(By.xpath("//div[contains(text(),'Field2')]/parent::div/following-sibling::div/child::div/i[3]"));
		SubField1.executeScript("arguments[0].click();",element4);
		Thread.sleep(2000);

		}




	public FlatfileConnectorsHomePage clickSaveButton() throws Exception
	{
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		click(element, driver, "clicking Save Button..............");
		waitForElementNotVisible(loader, driver, "wait for page load",45);
		return new FlatfileConnectorsHomePage(driver);
	}


	public void EditrequiredField(int index ,String FieldName) throws Exception 
	{
		log.info("clicking RequiredField..............");
		logExtentReport("clicking RequiredField..............");
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+FieldName+"')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element.click();
		List<WebElement> elemntArray = driver.findElements(By.xpath("//i[@class='delite-icon dlt-icon-edit icon-mr action-icon ']"));
		//Editicon.click();
		WebElement element1 = elemntArray.get(index);
		js.executeScript("arguments[0].click();",element1);
		Thread.sleep(1000);
	}

	public void verifyeditModeButtonIsOff() throws Exception
	{
		WebElement element = findElement("//span[text()='Edit Mode: ']/ancestor::div//div[@title='Inactive']",driver);
		waitForElementVisible(element, driver, "Verify edit mode is off");
	}

	public void verifyeditModeButtonIsOn() throws Exception
	{
		WebElement element = findElement("//span[text()='Edit Mode: ']/ancestor::div//div[@title='Active']",driver);
		waitForElementVisible(element, driver, "Verify edit mode is on");
	}
	
	public void clickOnEditModeToggle() throws Exception
	{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement element = findElement("//span[text()='Edit Mode: ']/ancestor::div//input[@id='edit_field_switch']",driver);
		WebElement element = findElement("//div[@class='pill_switch ']/div/label", driver);
		js.executeScript("arguments[0].click();",element);
		//click(element, driver, "Click on edit mode Toggle");
	}
	
	public void clickOnField(String type, String name) throws Exception
	{
		WebElement element = findElement("//div[text()='"+type+"']/ancestor::div//div[@class='node-label'][text()='"+name+"']",driver);
		click(element, driver, "Click on the fiel " +name);
	}
	
	public void verifyFieldIsNotVisible(String type, String name) throws Exception
	{
		String element = "//div[text()='"+type+"']/ancestor::div//div[@class='node-label'][text()='"+name+"']";
		waitForElementNotVisible(element, driver, "Verify field is not visible");
	}
	
	public void verifyFieldIsVisible(String type, String name,int index) throws Exception
	{
		List<WebElement> element = findElements("//div[text()='"+type+"']/ancestor::div//div[@class='node-label'][text()='"+name+"']",driver);
		waitForElementVisible(element.get(index), driver, "Verify field is visible");
	}
	
	public void verifyNodeActionsAreNotvisible(String type, String name) throws Exception
	{
		String ele = "//div[text()='"+type+"']/ancestor::div//div[@class='node-label'][text()='"+name+"']/ancestor::div//span[@class='node-actions']";
		waitForElementNotVisible(ele, driver, "Verify edit, add or delete actons are not visible when edit mode is off");
	}
	
	public void verifyNodeActionsArevisible(String type, String name) throws Exception
	{
		WebElement element = findElement("//div[text()='"+type+"']/ancestor::div//div[@class='node-label'][text()='"+name+"']/ancestor::div//span[@class='node-actions']",driver);
		waitForElementVisible(element, driver, "Verify node actions edit, add or delete are visible when edit mode is on");
	}

	public void verifyPlusNodeActionsIsVisible(String type, String name) throws Exception
	{
		WebElement element = findElement("//div[text()='"+type+"']/ancestor::div//div[@class='node-label'][text()='"+name+"']/ancestor::div//span[@class='node-actions']/i[contains(@class,'icon-plus')]",driver);
		waitForElementVisible(element, driver, "Verify node action plus button is visible");
	} 
	
	public void verifyPlusNodeActionsIsNotVisible(String type, String name) throws Exception
	{
		String element = "//div[text()='"+type+"']/ancestor::div//div[@class='node-label'][text()='"+name+"']/ancestor::div//span[@class='node-actions']/i[contains(@class,'icon-plus')]";
		waitForElementNotVisible(element, driver, "Verify node action plus button is not visible");
	} 

	public void positionTheFields(int index,String message) throws Exception
	{
		List<WebElement> element = findElements("//div[@class='data-operators']/div/span",driver);
		click(element.get(index), driver, message);
	}
	
	public void verifyWarningForWrongPosition(String type,String name) throws Exception
	{
		WebElement element = findElement("//div[text()='"+type+"']/ancestor::div//div[@class='node-label'][text()='"+name+"']/ancestor::div//i[@title='Wrong Position']",driver);
		waitForElementVisible(element, driver, "Verify wrong position warning is visible");
	}
	
	public void clickOnPreviousButton() throws Exception
	{
		click(previousButtonElement, driver, "Click on Pevious Button");
		Thread.sleep(2000);
	}
	
}
