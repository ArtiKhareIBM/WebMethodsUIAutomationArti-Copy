package com.webMethodsUI.flow.pageObjects.flatfile;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.assertion.VerificationHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class FlatfileDefinitionPage {
	WebDriver driver;
	private Logger log = LogManager.getLogger(FlatfileDefinitionPage.class);
	WaitHelper waitHelper;
	
	
	@FindBy(xpath = "//span[contains(text(),'Definition')]")
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
	
	@FindBy(xpath = "//input[@name='recordDelimiter']")
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
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(definitionStepElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + definitionStepElement);
		logExtentReport("AddConnectorPage Object created");
	}
	
	public String getDefinitionStep() {
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
	
	public void clickOnFixedLengthOption() {
        log.info("Clicking on fixed length option");
        logExtentReport("Clicking on fixed length option");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Fixed Length')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
 }
	
	public void clickOnVariableLengthOption() {
        log.info("Clicking on variable length option");
        logExtentReport("Clicking on variable length option");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Variable Length')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
 }
	
	public void typeRecordLength(String recordLength)
	{
		log.info("Typing record length... " + recordLength);
		logExtentReport("typing record length... " + recordLength);
		recordLengthTextFieldElement.clear();
		recordLengthTextFieldElement.sendKeys(recordLength);
		
	}
	
	public void typefieldSeparators(String fieldSeparators)
	{
		log.info("Typing field separators... " + fieldSeparators);
		logExtentReport("typing field separators... " + fieldSeparators);
		fieldSeparatorsTextFieldElement.clear();
		fieldSeparatorsTextFieldElement.sendKeys(fieldSeparators);
		
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
	
	public void typeAValueForRecordCharacter(String characterValue)
	{
		log.info("Creating flatfile connector with name... " + characterValue);
		logExtentReport("Creating flatfile connector with name... " + characterValue);
		typeAValueofRecordFieldElement.sendKeys(characterValue);
		
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
	
	
	public void clickRecordIdentifierYesOrNoButton() {
        log.info("Clicking on record identifier yes or no button");
        logExtentReport("Clicking on record identifier yes or no button");
        WebElement element = driver.findElement(By.xpath("//span[@class='switch-label default']"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        element.click();
 }
	
	public void clickswitchRecordidentifier(){
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
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
