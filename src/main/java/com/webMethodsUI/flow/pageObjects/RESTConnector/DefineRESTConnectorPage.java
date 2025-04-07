package com.webMethodsUI.flow.pageObjects.RESTConnector;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class DefineRESTConnectorPage extends CommonActions{
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Define Connector')]")
	@CacheLookup
	WebElement defineConnetorPageTitle;
	
	
	@FindBy(xpath = "//input[@placeholder='Name your Connector']")
	@CacheLookup
	WebElement RESTConnnectorName;
	
	
	@FindBy(xpath = "//textarea[@placeholder='Describe your Connector']")
	@CacheLookup
	WebElement RESTConnnectorDescription;
	
	@FindBy(xpath = "//input[@placeholder='Type the Endpoint URL']")
	@CacheLookup
	WebElement  DefaultEndPointURL;
	
	
	@FindBy(xpath = "//div[text()='Select Authentication Type']")
	@CacheLookup
	WebElement  AuthenticationType;

        @FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement  saveButtonElement;
	
	@FindBy(xpath = "//a/span[contains(text(),'Connectors')]")
	@CacheLookup
	WebElement  connectorButtonElement;
	
	
	public DefineRESTConnectorPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		logExtentReport("DefineConnetor Page obejct created");
		waitForElementVisible(defineConnetorPageTitle,driver,"Verify defineConnetorPageTitle is visible");
	}
	
	public void enterRestConnectorName(String connectorName) throws Exception
	{
		enterValue(RESTConnnectorName,connectorName,driver,"Entering connector Name.. " +connectorName);
	}
	
	public void enterRestConnectorDescription(String connectorDescription) throws Exception
	{
		enterValue(RESTConnnectorDescription,connectorDescription,driver,"Entering connectorDescription.. " +connectorDescription);
	}
	
    public void clearDescription() throws Exception
    {
		clearTextBox(RESTConnnectorDescription,driver,"Clear Description InputField");
	}
	
	public void clickSaveButton() throws Exception{
		click(saveButtonElement,driver,"Click on Save Button");
	}
	
	public boolean getConnectorText() throws Exception
	{
		waitForElementVisible(connectorButtonElement,driver,"Verify ConnectorText Message is visible");
		return connectorButtonElement.isDisplayed();
	}
	
	public void enterRestConnectorEndPointURL(String connectorURL) throws Exception
	{
		enterValue(DefaultEndPointURL,connectorURL,driver,"Entering REST connector URL... " + connectorURL);
	}
	
	public void enterCopiedApiRestConnectorEndPoint() throws Exception
	{
		enterValue(DefaultEndPointURL,Keys.CONTROL+"v",driver,"Entering swaggerURL... " );
	}
	
	public void selectAuthenticationType(String linkText) throws Exception 
	{
		click(AuthenticationType,driver,"Clicking on Authentication Type drop down");
		GenericHelper genericHelper = new GenericHelper(driver);
		genericHelper.selectDropDownLink(linkText);
	}
	
	public ResourcesPage clickNextButton() throws Exception
	{
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Next");
		return new ResourcesPage(driver);
	}
	
	public String getDefineConnectorTitle() throws Exception 
	{
		waitForElementVisible(defineConnetorPageTitle,driver,"Verify defineConnetorPageTitle is visible.. "+defineConnetorPageTitle);
		return defineConnetorPageTitle.getText();
	}
	
	
	@FindBy(xpath = "//button[text()='Add']")
	@CacheLookup
	WebElement  AddButton;
	
	@FindBy(xpath = "//div[text()='Header']")
	@CacheLookup
	WebElement  HeaderField;
	
	@FindBy(xpath = "//span[contains(@class,'custom-table-title')][text()='Fields']")
	@CacheLookup
	WebElement  FieldsLabel;
	
	public void clickaddFiledButton() throws Exception 
	{
		WebElement ele = findElement("//*[text()='Add Field']", driver);
		click(ele, driver, "Click on add field button");
	}
	
	public void ValidateAddFieldModel() throws Exception 
	{
		WebElement ele = findElement("//h1[text()='Add Field']", driver);
		waitForElementVisible(ele, driver, "Verify add field header is visible");
		ele = findElement("//span[@class='dlt-icon-close']", driver);
		waitForElementVisible(ele, driver, "Verify cancel icon is visible");
		ele = findElement("//button[text()='Add']", driver);
		isElementDisabled(ele, driver, "Verify AddButton is disabled");
		ele = findElement("(//button[text()='Cancel'])[2]", driver);
		isElementEnabled(ele, driver, "Verify Cancel button is enabled");
	}
	
	public void ClickAddFieldCancelIcon() throws Exception 
	{
		WebElement ele = findElement("//span[@class='dlt-icon-close']", driver);
		click(ele, driver, "Click on cancel icon and verify cancel icon is working");
		waitForElementNotVisible("//h1[text()='Add Field']", driver, "Verify add fiel model is not visible");		
	}
	
	public void ClickAddFieldCancelButton() throws Exception 
	{
		WebElement ele = findElement("(//button[text()='Cancel'])[2]", driver);
		click(ele, driver, "Click cancel button and verify cancel button is working");	
		waitForElementNotVisible("//h1[text()='Add Field']", driver, "Verify add fiel model is not visible");	
	}
	
	public void verifyHeaderIsSelectedByDefault() throws Exception 
	{
		waitForElementVisible(HeaderField, driver, "Verify Header field is selected by default");
	}
	
	
	public void verifyAddButtonIsDiabled() throws Exception 
	{
		isElementDisabled(AddButton, driver, "Verify AddButton is disabled");
	}
	
	public void verifyAddButtonIsEnabled() throws Exception 
	{
		isElementEnabled(AddButton, driver, "Verify AddButton is Enabled");
	}
	
	public void SelectFieldCategory(String category) throws Exception 
	{
		WebElement ele = findElement("//span[text()='Select Field Category']/../..//div[contains(@class,'value-container')]", driver);
		click(ele, driver, "Click on slect category dropdown");
		ele = findElement("//div[contains(text(),'" + category + "')]", driver);
		click(ele, driver, "Select field category "+category);		
	}
	
	public void EnterName(String name,String headerName) throws Exception 
	{
		WebElement ele = findElement("//div[contains(@class,'-name-input')]//span[text()='Name']/following-sibling::span[text()='*']", driver);
		waitForElementVisible(ele, driver, "Verify Name * is visible");
		ele = findElement("//span[contains(@class,'header-name')][text()='"+headerName+"']", driver);
		waitForElementVisible(ele, driver, "Verify default header name "+headerName+" is visible");
		ele = findElement("//input[@aid='Name'][@placeholder=' Enter name']", driver);
		enterValue(ele,name, driver, "Enter Name");
	}
	
	public void EnterDisplayName(String DisplayName) throws Exception 
	{
		WebElement ele = findElement("//div[contains(@class,'custom-input')]//span[text()='Display Name']/following-sibling::span[text()='*']", driver);
		waitForElementVisible(ele, driver, "Verify DisaplayName * is visible");
		ele = findElement("//input[@aid='Display Name'][@placeholder='Enter display name']", driver);
		enterValue(ele,DisplayName, driver, "Enter Display Name");
		
	}
	
	public void EnterDescription(String Description) throws Exception 
	{
		WebElement ele = findElement("//span[contains(text(),'Description')]/../../input[@placeholder='Enter description']", driver);
		enterValue(ele,Description, driver, "Enter Description");	
	}
	
	public void SelectDataType(String type) throws Exception 
	{
		WebElement ele = findElement("//div[contains(@class,'custom-select')]//span[text()='Select Data Type']/following-sibling::span[text()='*']", driver);
		waitForElementVisible(ele, driver, "Verify Select Data Type * is visible");
		ele = findElement("//div[contains(text(),'Select Data Type')]", driver);
		click(ele, driver, "Click on select data type dropdown");
		ele = findElement("//div[contains(text(),'" + type + "')]", driver);
		click(ele, driver, "SelectDataType "+type);
	}
	
	public void EnterDefaultValue(String DefaultValue) throws Exception 
	{
		WebElement ele = findElement("//span[contains(text(),'Default Value')]/../../input[@placeholder='Enter default value']", driver);
		enterValue(ele,DefaultValue, driver, "Enter Default Value");	
	}
	
	@FindBy(xpath = "//span[contains(text(),'Allowed Values')]/following-sibling::div//input")
	@CacheLookup
	WebElement  AllowedValueEle;
	
	public void EnterAllowedValues(String AllowedValue) throws Exception 
	{
//		WebElement ele = findElement("//span[contains(text(),'Allowed Values')]/following-sibling::div//div[text()='Enter allowed values']", driver);
		WebElement ele = findElement("//span[contains(text(),'Allowed Values')]/following-sibling::div", driver);
		scrollPageToElement(driver,ele);
		click(ele, driver, "Clicking on Enter Allowed Valuefield" );
		enterValue(AllowedValueEle,AllowedValue, driver, "Enter Allowed Value "+AllowedValue);
		  Actions action = new Actions(driver);
	      action.sendKeys(Keys.TAB).perform();
	}
	
	public void ClearAllAllowedValues() throws Exception 
	{
		WebElement ele = findElement("//div[contains(@class,'clear-indicator')]", driver);
		click(ele, driver, "Clear all allowed values list");
	    ele = findElement("//span[contains(text(),'Allowed Values')]/following-sibling::div//div[text()='Enter allowed values']", driver);
		waitForElementVisible(ele, driver, "Verify allowed values are cleared and place holder is visible");
	}
	
	public void ClearIndividualValue(String value) throws Exception 
	{
		WebElement ele = findElement("//div[text()='"+value+"']/following-sibling::div", driver);
		click(ele, driver, "Clear Individual value "+value);
	 	waitForElementNotVisible("//div[text()='"+value+"']/following-sibling::div", driver, "Verify value is cleared "+value);
	}
	
	public void EnableFieldProperty(String label,String value) throws Exception 
	{
		WebElement ele = findElement("//span[text()='"+label+"']/ancestor::div//span[@data-key='"+value+"']", driver);
		click(ele, driver, "Clear Individual value "+value);
		ele = findElement("//span[text()='"+label+"']/ancestor::div//div[@aid='on']", driver);
	 	waitForElementVisible(ele, driver, "Verify Toggle button is active");
	}
	
	public void clickAddButton() throws Exception 
	{
		click(AddButton, driver, "Click on add button");
		
	}
	
	public void VerifyFieldsLableIsVisible() throws Exception 
	{
		waitForElementVisible(FieldsLabel, driver, "Verify Fields Label is visible");
		
	}
	
	public void VerifyDefaultColumns() throws Exception 
	{
		WebElement ele = findElement("//div[contains(@class,'data-table-heading')]//span[text()='Name']/../..//span[text()='Data Type']/../..//span[text()='Default Value']/../..//span[text()='Display Name']/../..//span[text()='Actions']", driver);
		waitForElementVisible(ele, driver, "Verify default columns are visible");
		
	}
	
	public void VerifyAddedHeaderField(String fieldName) throws Exception 
	{
		WebElement ele = findElement("//span[@data-testid='jwt.header.x5t']//span[text()='jwt.header.x5t']/../..//span[text()='string']/../..//span[text()='Header default value']/../..//span[text()='Header']", driver);
		waitForElementVisible(ele, driver, "Verify Added field is visible "+fieldName);
		
	}
	
	public void VerifyAddedClaimField(String fieldName) throws Exception 
	{
		WebElement ele = findElement("//span[@data-testid='jwt.claim.exp']//span[text()='jwt.claim.exp']/../..//span[text()='string']/../..//span[text()='10']/../..//span[text()='Claim']", driver);
		waitForElementVisible(ele, driver, "Verify Added field is visible "+fieldName);
		
	}
	
	public void VerifyAddedScopeAssertion(String fieldName) throws Exception 
	{
		WebElement ele = findElement("//span[@data-testid='jwt.client.assertion.scope']//span[text()='jwt.client.assertion.scope']/../..//span[text()='string']/../..//span[text()='https://graph.microsoft.com/.default']/../..//span[text()='Scope']", driver);
		waitForElementVisible(ele, driver, "Verify Added field is visible "+fieldName);
		
	}
	
	public void VerifyAddedClientIDAssertion(String fieldName) throws Exception 
	{
		WebElement ele = findElement("//span[@data-testid='jwt.client.assertion.clientid']//span[text()='jwt.client.assertion.clientid']/../..//span[text()='string']/../..//span[text()='cdacd4de-a654-4b5d-8dcb-a3830fd38f0e']/../..//span[text()='Clientid']", driver);
		waitForElementVisible(ele, driver, "Verify Added field is visible "+fieldName);
		
	}
	
	public void VerifyAddedDeleteField(String fieldName) throws Exception 
	{
		WebElement ele = findElement("//span[@data-testid='jwt.header.f1']//span[text()='jwt.header.f1']/../..//span[text()='string']/../..//span[text()='delete']", driver);
		waitForElementVisible(ele, driver, "Verify Added field is visible "+fieldName);
	}
	
	public void VerifyUpdatedDeleteField(String fieldName) throws Exception 
	{
		WebElement ele = findElement("//span[@data-testid='jwt.header.f1']//span[text()='jwt.header.f1']/../..//span[text()='string']/../..//span[text()='delete default value']/../..//span[text()='delete']", driver);
		waitForElementVisible(ele, driver, "Verify Updated field is visible "+fieldName);
	}
	
	public void clickEditIconOfField(String displayName) throws Exception 
	{
		WebElement ele = findElement("//span[@data-testid='jwt.header.f1']//span[text()='jwt.header.f1']/../..//span[text()='string']/../..//span[text()='"+displayName+"']/../..//span[contains(@class,'action-icons')]/i[contains(@class,'icon-edit')]", driver);
		click(ele, driver, "Click on edit of field "+displayName);
		 ele = findElement("//h1[text()='Add Field']", driver);
		waitForElementVisible(ele, driver, "Verify add field header is visible");
	}
	
	public void clickDeleteIconOfField(String displayName) throws Exception 
	{
		WebElement ele = findElement("//span[@data-testid='jwt.header.f1']//span[text()='jwt.header.f1']/../..//span[text()='string']/../..//span[text()='delete default value']/../..//span[text()='"+displayName+"']/../..//span[contains(@class,'action-icons')]/i[contains(@class,'icon-delete')]", driver);
		click(ele, driver, "Click on delete of field "+displayName);
		waitForElementNotVisible("//span[@data-testid='jwt.header.f1']//span[text()='jwt.header.f1']/../..//span[text()='string']/../..//span[text()='delete default value']/../..//span[text()='"+displayName+"']/../..//span[contains(@class,'action-icons')]/i[contains(@class,'icon-delete')]", driver, "Verify deleted field is not visible");
	}
	
	public void ClickOnsettingsIcon(String value) throws Exception 
	{
		WebElement ele = findElement("//span[contains(@class,'icon-settings')]", driver);
		click(ele, driver, "Click on settings icon");
	 	waitForElementNotVisible("//div[text()='"+value+"']/following-sibling::div", driver, "Verify value is cleared "+value);
	}
	
	public void selectFieldsToDisplay(String field) throws Exception 
	{
		WebElement ele = findElement("//span[@class='new-checkbox-label-text'][text()='"+field+"']", driver);
		click(ele, driver, "Select "+field);
	}
	
	public void VerifySelectedColumns() throws Exception 
	{
		WebElement ele = findElement("//div[contains(@class,'data-table-heading')]//span[text()='Name']/../..//span[text()='Data Type']/../..//span[text()='Default Value']/../..//span[text()='Description']/../..//span[text()='Allowed Values']/../..//span[text()='Array']/../..//span[text()='Encrypted']/../..//span[text()='Hidden']/../..//span[text()='Required']/../..//span[text()='Display Name']/../..//span[text()='Actions']", driver);
		waitForElementVisible(ele, driver, "Verify all the selected columns are visible");
		
	}
	
	public void VerifyErrorMessage(String text) throws Exception 
	{
		WebElement ele = findElement("//span[@class='error-validaion-text']/span[text()='error']/following-sibling::span[text()=': Custom field with name "+text+" already exists.']", driver);
		waitForElementVisible(ele, driver, "Verify duplicate name is not allowed error message is visible");
		
	}
}
