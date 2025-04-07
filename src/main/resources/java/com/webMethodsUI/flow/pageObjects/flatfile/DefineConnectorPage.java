package com.webMethodsUI.flow.pageObjects.flatfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class DefineConnectorPage extends CommonActions
{
		WebDriver driver;

		@FindBy(xpath = "//span[contains(text(),'Define')]")
		@CacheLookup
		WebElement defineStepElement;
		
		@FindBy(xpath = "//input[@placeholder='Provide a suitable name for this Connector']")
		@CacheLookup
		WebElement flatfileConnnectorNameElement;
		
		@FindBy(xpath = "//textarea[@placeholder='Provide a short description for this Connector']")
		@CacheLookup
		WebElement connnectorDescriptionElement;
		
		@FindBy(xpath = "//span[contains(text(),'Browse Files')]")
		@CacheLookup
		WebElement browseButtonElement;
		
		@FindBy(xpath = "//button[contains(text(),'Previous')]")
		@CacheLookup
		WebElement previousButtonElement;
		
		@FindBy(xpath = "//button[contains(text(),'Next')]")
		@CacheLookup
		WebElement nextButtonElement;
		
		@FindBy(xpath = "//button[contains(text(),'Cancel')]")
		@CacheLookup
		WebElement cancelButtonElement;
		
		
		public DefineConnectorPage(WebDriver driver) throws Exception {
			super();
			this.driver = driver;
			PageFactory.initElements(driver, this);
			logExtentReport("AddConnectorPage Object created");
			waitForElementVisible(defineStepElement,driver,"Verify element is visible.. "+defineStepElement);
		}
		
		public String getDefineTab() throws Exception 
		{
			waitForElementVisible(defineStepElement,driver,"Verify element is visible.. "+defineStepElement);
			return defineStepElement.getText();
		}
		
		public void enterFlatfileConnectorName(String connectorName) throws Exception
		{
			enterValue(flatfileConnnectorNameElement,connectorName,driver,"Creating flatfile connector with name... " + connectorName);
		}
		
		public void enterFlatfileConnectorDescription(String connectorDescription) throws Exception
		{
			enterValue(connnectorDescriptionElement,connectorDescription,driver,"Creating flatfile connector description... " + connectorDescription);
		}
		
		public void clickOnDescriptionTextareaAndTypeNewDescription(String editedDescription) throws Exception
		{
			WebElement element = findElement("//textarea[@placeholder='Provide a short description for this Connector']",driver);
			clearAndEnterText(element, editedDescription, driver, "Entering new description.. "+editedDescription);	
		}
		
		public void ClickBrowseConnectorIconButton() throws Exception
		{
			click(browseButtonElement,driver,"clicking Browse connector Button...");
		}
		
		public String getPreviousButton() throws Exception 
		{
			waitForElementVisible(previousButtonElement,driver,"Get previous ButtonText.. "+previousButtonElement);
			return previousButtonElement.getText();
		}
		
		public String getNextButton() throws Exception 
		{
			waitForElementVisible(nextButtonElement,driver,"Get Next ButtonText.. "+nextButtonElement);
			return nextButtonElement.getText();
		}
		
		public String getCancelButton() throws Exception 
		{
			waitForElementVisible(cancelButtonElement,driver,"Get Cancel ButtonText.. "+cancelButtonElement);
			return cancelButtonElement.getText();
		}
		
		public FlatfileDefinitionPage clickNextButton() throws Exception
		{
			GenericHelper genericObj = new GenericHelper(driver);
			genericObj.clickButton("Next");
			return new FlatfileDefinitionPage(driver);
		}
		
		public void uploadFlatfileIcon() throws Exception 
		{
			WebElement BrowseFileElement = findElement("//input[@class='file-upload hide']",driver);
	        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\Flatfile.png");
	        FileUpload fileupload = new FileUpload(driver);
	        fileupload.fileUploadUsingInputType(BrowseFileElement,filePath);
	        Thread.sleep(2000);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
