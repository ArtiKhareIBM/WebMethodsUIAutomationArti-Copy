package com.webMethodsUI.flow.pageObjects.flatfile;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class FlatfileConnectorsHomePage
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
	
	
	public void clickOnFlatfileOperationButton(String flatfileConnectorName) {

		log.info("Clicking on flatfile connector name " + flatfileConnectorName);
		logExtentReport("Clicking on flatfile connector name " + flatfileConnectorName);
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + soapConnectorName + "')]"));
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
	
	public void clickOnEditDropdown() {
		log.info("Clicking on Dropddown icon");
		logExtentReport("Clicking on drop down icon");
		WebElement element = driver.findElement(By.xpath("//i[@class='delite-icon dlt-icon-more-menu']"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

	}
	
	public DefineConnectorPage clickOnEditButton() throws Exception {
		log.info("Clicking on Dropddown icon");
		logExtentReport("Clicking on drop down icon");
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Edit')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		return new DefineConnectorPage(driver);

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
	
	
	
	
}
