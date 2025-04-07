package com.webMethodsUI.flow.pageObjects.flatfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class FlatfileConnectorsHomePage extends CommonActions
{
	WebDriver driver;
	private Logger log = LogManager.getLogger(FlatfileConnectorsHomePage.class);
	WaitHelper waitHelper;


	@FindBy(xpath = "//span[contains(text(),'Flat File Connectors')]")
	@CacheLookup
	WebElement flatFileConnectorPageTitleElement;

	@FindBy(xpath = "//button[contains(text(),'Add Connector')]")
	@CacheLookup
	WebElement addConnectorButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Operations')]")
	@CacheLookup
	WebElement operationsButtonElement;

	@FindBy(xpath = "//div[contains(text(),'No connectors created yet!')]")
	@CacheLookup
	WebElement noConnectorTitleElementElement;

	@FindBy(xpath = "//div[contains(text(),'Available Predefined Operations')]")
	@CacheLookup
	WebElement predefinedConnectorElement;

	@FindBy(xpath = "//span[contains(text(),'Successfully created the  connector.')]")
	@CacheLookup
	WebElement flatFileConnectorSuccesspageelement;

	@FindBy(xpath = "//*[contains(@class,'icon-more-menu')]")
	@CacheLookup
	WebElement iconMoreMenu;
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public WebElement notificationMessage;

	@FindBy(xpath = "//div[contains(text(),'Please select a file of size less than 5Mb.')]")
	@CacheLookup
	public WebElement FileErrorMessage;



	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public FlatfileConnectorsHomePage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(flatFileConnectorPageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +flatFileConnectorPageTitleElement.getText());

	}


	public String getFlatFileConnectorPageTitle() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +flatFileConnectorPageTitleElement.getText());
        return flatFileConnectorPageTitleElement.getText();
	}

	public String getFlatFileSucessMessage() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +flatFileConnectorSuccesspageelement.getText());
        return flatFileConnectorSuccesspageelement.getText();
	}



	public void clickOnFlatfileOperationButton(String flatfileConnectorName) {

		log.info("Clicking on flatfile connector name " + flatfileConnectorName);
		logExtentReport("Clicking on flatfile connector name " + flatfileConnectorName);
		
		WebElement element1 = driver.findElement(By.xpath("//div[@class='col s4 connector-list-item-actions']"));
		element1.click();
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Operations')]"));
		element.click();

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(predefinedConnectorElement, ObjectReader.reader.getExplicitWait());
		log.info("Operation button is visible");
		logExtentReport("Operation button is visible");
		predefinedConnectorElement.click();

	}

	public String getFlatfileConnectorEmptyMessage() {
		log.info("Checking if  flatfile connector  are empty");
		logExtentReport("Checking if  flatfile connector are empty...");
		return noConnectorTitleElementElement.getText();

	}

	public void clickOnDropdownIcon() {
		log.info("Clicking on Dropddown icon");
		logExtentReport("Clicking on drop down icon");
		WebElement element = driver.findElement(By.xpath("//span[@class='delite-icon dlt-icon-chevron-down icon-chevron-down']"));
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

	}

	public void clickOnEditDropdown() throws Exception {
		log.info("Clicking on Dropddown icon");
		logExtentReport("Clicking on drop down icon");
		WebElement element = findElement("//i[@class='delite-icon dlt-icon-more-menu']",driver);
		//waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

	}

	public DefineConnectorPage clickOnEditButton() throws Exception {
		log.info("Clicking on Dropddown icon");
		logExtentReport("Clicking on drop down icon");
		WebElement element = findElement("//span[@class='edit-pencil-icon dlt-icon-edit']",driver);
		//span[contains(text(),'Edit')]
		//span[@class='edit-pencil-icon dlt-icon-edit']
		//waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		return new DefineConnectorPage(driver);

	}

	 public void EditFlatfile(String connectorName) throws Exception
	    {
	    	WebElement element = findElement("//a[contains(text(),'"+connectorName+"')]/parent::div/span[2]/img",driver);
			mousehover(element,driver,"mousehover on REST connector Image.. " + connectorName);
			click(iconMoreMenu,driver,"Clicking on more menu icon");
			waitForElementNotVisible(loader, driver, "wait for page load");
			 WebElement EditButton = findElement("//*[text()='Edit']",driver);
	    	 click(EditButton,driver,"Click edit Button");
	    	 //waitForElementNotVisible(loader, driver, "wait for page load");
	    	 //WebElement deletePopup = findElement("//*[text()='Delete REST Connector']",driver);
	    	 //waitForElementVisible(deletePopup,driver,"Verify delete REST Connector popup is visible");
	    	 //WebElement deleteButton = findElement("//*[text()='Delete']",driver);
	    	 //click(deleteButton,driver,"Click delete Button");
	    }


	 public void deleteFlatfileConnector(String connectorName) throws Exception
	    {
	    	WebElement element = findElement("//a[contains(text(),'"+connectorName+"')]/parent::div/span[2]/img",driver);
			mousehover(element,driver,"mousehover on REST connector Image.. " + connectorName);
			click(iconMoreMenu,driver,"Clicking on more menu icon");
			waitForElementNotVisible(loader, driver, "wait for page load");
			 WebElement removeButton = findElement("//*[text()='Remove']",driver);
	    	 click(removeButton,driver,"Click remove Button");
	    	 waitForElementNotVisible(loader, driver, "wait for page load");
	    	 WebElement deletePopup = findElement("//*[text()='Delete Flat File Connector']",driver);
	    	 waitForElementVisible(deletePopup,driver,"Verify delete Flat File Connector popup is visible");
	    	 WebElement deleteButton = findElement("//*[text()='Delete']",driver);
	    	 click(deleteButton,driver,"Click delete Button");
//	    	 waitForElementNotVisible(loader, driver, "wait for page load");
	    	 waitForElementVisible(notificationMessage, driver, "Successfully deleted the connector!");
//	    	 elementContainsText(notificationMessage,"FlowService Exported successfully",driver,"Verify FlowService Exported successfully. message is visible");
	 		waitForElementNotVisible(loader, driver, "wait for page load");

	    }


	public void clickOnRemoveButton() {
		log.info("Clicking on remove button");
		logExtentReport("Clicking on remove button");
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Remove')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();


	}

	public FlatfileOperationsPage clickOperationsButton() throws Exception
	{
		log.info("Clicking on the Operations Button... ");
		logExtentReport("Clicking on the Operations Button... ");
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Operations");
		return new FlatfileOperationsPage(driver);
	}

	public FlatfileConnectorsHomePage clickDeleteButton() throws Exception
	{
		log.info("Clicking on the delete Button... ");
		logExtentReport("Clicking on the delete Button... ");
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Delete");
		return new FlatfileConnectorsHomePage(driver);
	}
	public void clickOnExpandOperation() {
		log.info("Clicking on expand button");
		logExtentReport("Clicking on expand button");
		WebElement element = driver.findElement(By.xpath("//span[@class = 'delite-icon dlt-icon-chevron-down icon-chevron-down']"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();


	}

	public boolean VerifyFlatfilenameOnhomepage(String Flatfilename){
		log.info("Verifythe Name" + Flatfilename +"On homepage");
		logExtentReport("Verifythe Name"+ Flatfilename +"On homepage");
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+Flatfilename+"')]/ancestor::div[@class='row inner-row connector-list-item-row']"));
		return element.isDisplayed();
	}

	public String  VerifyFlatfileName(String connectorName) throws Exception
	{
		log.info("verifying the flatfile name");
		WebElement element = findElement("//a[contains(text(),'"+connectorName+"')]",driver);
		waitForElementVisible(element, driver, "Getting flatfile name...");
		return element.getText();
	}

	public String getFlatFileSizeError(String Flatfilemessage) throws Exception 
	{
		log.info("element is visible now....");
		WebElement element = findElement("//div[contains(text(),'"+Flatfilemessage+"')]",driver);
		logExtentReport("element is visible now.... and element text is  " +element.getText());
        return element.getText();
	}

}
