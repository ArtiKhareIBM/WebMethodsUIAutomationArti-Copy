package com.webMethodsUI.flow.pageObjects.flatfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.assertion.VerificationHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class FlatfileDefinitionPage extends CommonActions{
	WebDriver driver;
	private Logger log = LogManager.getLogger(FlatfileDefinitionPage.class);
	WaitHelper waitHelper;


	@FindBy(xpath = "//span[contains(text(),'File type')]")
	@CacheLookup
	WebElement definitionStepElement;

	@FindBy(xpath = "//h1[contains(text(),'Flat File Definition')]")
	@CacheLookup
	WebElement flatfileDefinitionTitleElement;

	@FindBy(xpath = "//span[contains(text(),'Delimiter')]")
	@CacheLookup
	WebElement delimiterRecordParserElement;

	@FindBy(xpath = "//span[contains(text(),'Fixed Length')]")
	@CacheLookup
	WebElement fixedLengthRecordParserElement;

	@FindBy(xpath = "//span[contains(text(),'Variable Length')]")
	@CacheLookup
	WebElement variableLengthRecordParserElement;

	@FindBy(xpath = "//input[@id='charRecord']")
	@CacheLookup
	WebElement characterOfRecordElement;

	@FindBy(xpath = "//input[@id='charPosRecord']")
	@CacheLookup
	WebElement characterPositionOfRecordElement;

	@FindBy(xpath = "//div[@id='recordDelimiter']/parent::div/div/div/div")
	@CacheLookup
	WebElement typeAValueofRecordFieldElement;


	@FindBy(xpath = "//input[@id='charField or Composite']")
	@CacheLookup
	WebElement characterOfFieldorCompositeElement;

	@FindBy(xpath = "//input[@id='charPosField or Composite']")
	@CacheLookup
	WebElement characterPositionOfFieldorCompositeElement;

	@FindBy(xpath = "//input[@name='fieldDelimiter']")
	@CacheLookup
	WebElement typeAValueofFieldorCompositeElement;


	@FindBy(xpath = "//input[@id='charSubfield']")
	@CacheLookup
	WebElement characterOfSubfieldElement;

	@FindBy(xpath = "//input[@id='charPosSubfield']")
	@CacheLookup
	WebElement characterPositionOfSubfieldElement;

	@FindBy(xpath = "//input[@name='subFieldDelimiter']")
	@CacheLookup
	WebElement typeAValueofSubfieldElement;

	@FindBy(xpath = "//input[@name='charQuoted Release Character']")
	@CacheLookup
	WebElement characterOfQuotedReleaseCharacterElement;

	@FindBy(xpath = "//input[@name='charPosQuoted Release Character']")
	@CacheLookup
	WebElement characterPositionOfQuotedReleaseCharacterElement;

	@FindBy(xpath = "//input[@name='quoteReleaseDelimiter']")
	@CacheLookup
	WebElement typeAValueOfQuotedReleaseCharacterElement;


	@FindBy(xpath = "//input[@name='charRelease Character']")
	@CacheLookup
	WebElement characterOfReleaseCharacterElement;

	@FindBy(xpath = "//input[@name='charPosRelease Character']")
	@CacheLookup
	WebElement characterPositionOfReleaseCharacterElement;

	@FindBy(xpath = "//input[@name='releaseDelimiter']")
	@CacheLookup
	WebElement typeAValueOfReleaseCharacterElement;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement cancelButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	@CacheLookup
	WebElement previousButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;

	@FindBy(xpath = "//span[@class='switch-handle default']")
	@CacheLookup
	WebElement recordIdentifierButtonElement;

	@FindBy(xpath = "//span[contains(text(),'Start at position')]")
	@CacheLookup
	WebElement startAtPositionOptionElement;

	@FindBy(xpath = "//span[contains(text(),'Nth field')]")
	@CacheLookup
	WebElement nthFieldOptionElement;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	@CacheLookup
	WebElement yesRecordIdentifierElement;

	@FindBy(xpath = "//span[contains(text(),'No')]")
	@CacheLookup
	WebElement noRecordIdentifierElement;


	@FindBy(xpath = "//span[@class='switch-label default']")
	@CacheLookup
	WebElement Recordidentifier;


	@FindBy(xpath = "//input[@placeholder='Provide a value']")
	@CacheLookup
	WebElement recordIdentifierPositionTextFieldElement;

	@FindBy(xpath = "//input[@name='recordLength']")
	@CacheLookup
	WebElement recordLengthTextFieldElement;

	@FindBy(xpath = "//input[@name='fieldSeparators']")
	@CacheLookup
	WebElement fieldSeparatorsTextFieldElement;

	@FindBy(xpath = "//input[@name='quoteReleaseDelimiter']")
	@CacheLookup
	WebElement quotedReleaseCharacterTextFieldElement;


	public FlatfileDefinitionPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElement(definitionStepElement, ObjectReader.reader.getExplicitWait());
//		log.info("element is visible now...." + definitionStepElement);
		logExtentReport("FlatfileDefinitionPage Object created");
	}

	public String getDefinitionStep() 
	{
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +definitionStepElement.getText());
		return definitionStepElement.getText();

	}

	public boolean isDelimiterOptionVisible() {
		return new VerificationHelper(driver).isDisplayed(delimiterRecordParserElement);
	}

	public boolean isFixedLegthOptionVisible() {
		return new VerificationHelper(driver).isDisplayed(fixedLengthRecordParserElement);

	}

	public boolean isVariableLengthOptionVisible() {
		return new VerificationHelper(driver).isDisplayed(variableLengthRecordParserElement);

	}

	public void clickOnFixedLengthOption() throws Exception {
		
        WebElement element = findElement("//span[contains(text(),'Fixed Length')]",driver);
        click(element, driver, "Clicking on fixed length option");
        
 }

	public void clickOnRecordIdentifierPosition(String selectoption) throws Exception {
        
        WebElement element = findElement("//span[contains(text(),'" + selectoption + "')]",driver);
        click(element, driver, "Clicking on record identfier  option");
 }

	public void clickOnVariableLengthOption() throws Exception 
	{
		WebElement element = findElement("//span[contains(text(),'Variable Length')]",driver);
        click(element, driver, "Clicking on variable length option");
 }

	public void typeRecordLength(String recordLength) throws Exception
	{
		log.info("Typing record length... " + recordLength);
		logExtentReport("typing record length... " + recordLength);
		recordLengthTextFieldElement.clear();
		recordLengthTextFieldElement.sendKeys(recordLength);
		Thread.sleep(2000);

	}

	public void typefieldSeparators(String fieldSeparators) throws Exception
	{
		WebElement element1 = findElement("//input[@name='fieldSeparators']",driver);
		enterValue(element1, fieldSeparators, driver, "Typing field separators... " + fieldSeparators);
		Thread.sleep(2000);
		WebElement element = findElement("//span[contains(text(),'Field1')]",driver);
        waitForElementVisible(element, driver, "Verify field 1 is visible");
	}


	public String GetFiledName(String fieldname) throws Exception
	{
		WebElement element = findElement("//span[contains(text(),'" + fieldname + "')]",driver);
		return getText(element, driver, "fetchine field name");
	}






	public String getFixedLengthRecordParser() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +fixedLengthRecordParserElement.getText());
		return fixedLengthRecordParserElement.getText();
	}

	public String getVariableLengthRecordParser() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +variableLengthRecordParserElement.getText());
		return variableLengthRecordParserElement.getText();
	}

	public String getCharacterOfRecord() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +characterOfRecordElement.getText());
		return characterOfRecordElement.getText();

	}

	public String getCharacterOfFieldorComposite() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +characterOfFieldorCompositeElement.getText());
		return characterOfFieldorCompositeElement.getText();

	}

	public String getCharacterOfSubfield() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +characterOfSubfieldElement.getText());
		return characterOfSubfieldElement.getText();

	}

	public String getCharacterOfQuotedReleaseCharacter() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +characterOfQuotedReleaseCharacterElement.getText());
		return characterOfQuotedReleaseCharacterElement.getText();

	}

	public void typeAValueForRecordCharacter(String serviceName, String characterValue) throws Exception
	{

		WebElement element = findElement("//div[@id='" + serviceName + "']/parent::div/div/div//div[text()='Select...']",driver);
		click(element, driver, "adding record ... " + characterValue);
		//Actions builder = new Actions(driver);
        //logExtentReport("entering the reocrd .." +characterValue );
        //element.sendKeys(characterValue);
		WebElement element1 = findElement("//div[@id='" + serviceName + "']/parent::div/div/div//div/input",driver);
        //enterValue(element1, characterValue, driver, "entering the reocrd .." +characterValue);
		Actions builder = new Actions(driver);
        //logExtentReport("Selecting tenant.." +NameofTenanturl );
        element1.sendKeys(characterValue);
        builder.sendKeys(Keys.ENTER).perform();

	}
	
	public void selectDelimeter(String serviceName, String characterValue) throws Exception
	{

		WebElement element = findElement("//div[@id='" + serviceName + "']/parent::div/div/div//div[text()='Select...']",driver);
		click(element, driver, "clicking on dropdown");
		WebElement element1 = findElement("//div[@id='" + serviceName + "']/parent::div/div/div//div/input",driver);
    	Actions builder = new Actions(driver);
    	element1.clear();
        element1.sendKeys(characterValue);
        builder.sendKeys(Keys.ENTER).perform();
	}

	public String verifytypeAValueForRecordCharacter(String serviceName, String characterValue) throws Exception
	{

		WebElement element = findElement("//div[@id='" + serviceName + "']/parent::div/div/div//div[text()='Select...']",driver);
		click(element, driver, "adding record ... " + characterValue);
		//Actions builder = new Actions(driver);
        //logExtentReport("entering the reocrd .." +characterValue );
        //element.sendKeys(characterValue);
		WebElement element1 = findElement("//div[contains(text(),'" + characterValue + "')]",driver);
		return element1.getText();
	}

	public void typeAValueForFieldOrCompositeCharacter(String fieldOrCompositeCharacterValue)
	{
		log.info("Creating flatfile connector with name... " + fieldOrCompositeCharacterValue);
		logExtentReport("Creating flatfile connector with name... " + fieldOrCompositeCharacterValue);
		typeAValueofFieldorCompositeElement.sendKeys(fieldOrCompositeCharacterValue);
	}

	public void typeAValueForSubfieldCharacter(String subfieldCharacterValue)
	{
		log.info("Creating flatfile connector with name... " + subfieldCharacterValue);
		logExtentReport("Creating flatfile connector with name... " + subfieldCharacterValue);
		typeAValueofSubfieldElement.sendKeys(subfieldCharacterValue);
	}

	public void typeAValueForQuotedReleaseCharacter(String string)
	{
		log.info("Creating flatfile connector with name... " + string);
		logExtentReport("Creating flatfile connector with name... " + string);
		quotedReleaseCharacterTextFieldElement.sendKeys(string);
	}

	public boolean isYESRecordIdentiferIsVisible() {
		return new VerificationHelper(driver).isDisplayed(yesRecordIdentifierElement);
	}

	public StructurePage clickNextButton() throws Exception
	{
		log.info("Clicking on the Next Button... ");
		logExtentReport("Clicking on the Next Button... ");
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Next");
		return new StructurePage(driver);
	}

	public void clickRecordIdentifierYesOrNoButton() throws Exception 
	{
        WebElement element = findElement("//span[@class='switch-label default']",driver);
		click(element, driver, "Clicking on record identifier yes or no button");
    }

	public void clickswitchRecordidentifier()
	{
		log.info("Clicking on record identifier yes or no button");
		logExtentReport("Clicking on record identifier yes or no button");
		Recordidentifier.click();
	}

	public void QuotedReleaseCharacter(String CharacterValue)
	{
		log.info("Creating flatfile connector with name... " + CharacterValue);
		logExtentReport("Creating flatfile connector with name... " + CharacterValue);
		typeAValueOfQuotedReleaseCharacterElement.sendKeys(CharacterValue);
	}
	
	public String getFlatFiled(String Fieldname)
	{
		log.info("element is visible now....");
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+Fieldname+"')]"));
		logExtentReport("element is visible now.... and element text is  " +element.getText());
        return element.getText();
	}

	public void ClickFileType(String text) throws Exception
	{
	    log.info("Operations text with name " +text);
	    logExtentReport("clicking on the clear button...."+text);
	    WebElement element = driver.findElement(By.xpath("//p[contains(text(),'" + text + "')]"));
	    element.click();
	 }
	
	public void clickOnPreviousButton() throws Exception
	{
		click(previousButtonElement, driver, "Click on Pevious Button");
		Thread.sleep(2000);
	}
}
