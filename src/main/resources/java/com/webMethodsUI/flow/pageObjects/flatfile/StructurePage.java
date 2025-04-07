package com.webMethodsUI.flow.pageObjects.flatfile;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.RESTConnector.ConnectorsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class StructurePage {
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
	
	
	public StructurePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(cancelButtonElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + cancelButtonElement);
		logExtentReport("AddConnectorPage Object created");
	}
	
	
	public String getFlatfileStructureHeading() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +flatfileStructureHeadingElement.getText());
		return flatfileStructureHeadingElement.getText();
	}
	public String getCancelButton() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +cancelButtonElement.getText());
		return cancelButtonElement.getText();
	}
	
	public String getPreviousButton() {
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
	
	public void maxRepeatDropdown(int index) {

		log.info("  Clicking on plus icon ..." +index);
	    logExtentReport(" Clicking on plus icon ..." +index);
	    
	    List<WebElement> elemntArray = driver
	            .findElements(By.xpath("//span[contains(text(),'Max repeat')]/ancestor::div[@class='dropdown-box']/div/span"));
	    
	    WebElement element = elemntArray.get(index);
	    element.click();
	}
	
	public void selectElementTypeDropdown(int index) {

		 

	    log.info("  Clicking on plus icon ..." +index);
	    logExtentReport(" Clicking on plus icon ..." +index);
	    
	    List<WebElement> elemntArray = driver
	            .findElements(By.xpath("//span[contains(text(),'Element type')]/parent::*/parent::*/parent::*/following-sibling::span"));
	    
	    WebElement element = elemntArray.get(index);
	    element.click();
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
	
	public void typeExtractorValue(int index, String value) {

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

			}
		}

	}
	
	
	
	public void clickAddRecordPlusIcon() throws InterruptedException
	{
		log.info("Clicking the add record plus icon..............");
		logExtentReport("Clicking the add record plus icon..............");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//i[@class='delite-icon dlt-icon-plus icon-mr action-icon ']"));
		js.executeScript("arguments[0].click();",element);
		Thread.sleep(3000);
		}
	
	public void clickAddRecordPlusIconForCRLFRecord() throws InterruptedException
	{
		log.info("Clicking the add record plus icon..............");
		logExtentReport("Clicking the add record plus icon..............");
		JavascriptExecutor Field1 = (JavascriptExecutor) driver;
		WebElement element2 = driver.findElement(By.xpath("//div[contains(text(),'CRLF')]/parent::div/following-sibling::div/child::div/i[3]"));
		Field1.executeScript("arguments[0].click();",element2);
		Thread.sleep(2000);
		
		}
	
	public void clickAddRecordPlusIconForField2CompositeRecord() throws InterruptedException
	{
		log.info("Clicking the add record plus icon..............");
		logExtentReport("Clicking the add record plus icon..............");
        JavascriptExecutor SubField1 = (JavascriptExecutor) driver;
		WebElement element4 = driver.findElement(By.xpath("//div[contains(text(),'Field2')]/parent::div/following-sibling::div/child::div/i[3]"));
		SubField1.executeScript("arguments[0].click();",element4);
		Thread.sleep(2000);
		
		}
	
	
	
	
	public FlatfileConnectorsHomePage clickSaveButton(){
		log.info("clicking Save  Button..............");
		logExtentReport("clicking Save Button..............");
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		return new FlatfileConnectorsHomePage(driver);
	}
	
	
	public void EditrequiredField(int index ,String FieldName) throws InterruptedException {
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
	
	


}
