package com.webMethodsUI.flow.pageObjects.flatfile;

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

public class FlatfileOperationsPage {
	WebDriver driver;
	private Logger log = LogManager.getLogger(FlatfileOperationsPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//div[contains(text(),'Available Predefined Operations')]")
	@CacheLookup
	WebElement predefinedOperationsTitleElement;
	
	@FindBy(xpath = "//span[@class = 'operation-action-icons wmio-test-operation-icon disabled-click']") //operation-action-icons wmio-test-operation-icon disabled-click
	@CacheLookup
	WebElement runOperationButton;
	
	
	@FindBy(xpath = "//span[@class = 'dlt-icon-close close-icon']")
	@CacheLookup
	WebElement closeOperationButtonElement;
	

	
	
	
	public FlatfileOperationsPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(predefinedOperationsTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +predefinedOperationsTitleElement.getText());

	}
	
	
	public void clickCloseflatfileConnectorOperation() {

		log.info("Clicking on  Link.... " + closeOperationButtonElement.getText());
		logExtentReport(" Clicking on Link with name ..... " + closeOperationButtonElement.getText());
		waitHelper.waitForElement(closeOperationButtonElement, ObjectReader.reader.getExplicitWait());
		closeOperationButtonElement.click();

	}
	public boolean isRunOperationButtonVisible() {
		log.info("Run Operations button is visible " + runOperationButton);
		logExtentReport("Run Operations button is visible... " + runOperationButton);
		return runOperationButton.isDisplayed();
	}
	
	public String getPredefinedOperationsTitle() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +predefinedOperationsTitleElement.getText());
        return predefinedOperationsTitleElement.getText();
	}
	
	public ConvertFlatfileToDocumentInputPage clickTestConvertFlatfileToDocumentButton() {
		log.info("Clicking on Test Operation button");
		logExtentReport("Clicking on Test Operation button");
		WebElement element = driver.findElement(By.xpath("//span[@title='convertFlatFileToDocument']/parent::*/following-sibling::div[2]/child::span[2]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
        return new ConvertFlatfileToDocumentInputPage(driver);
	}
	
	public void clickTestConvertDocumentToFlatfileButton() {
		log.info("Clicking on Test Operation button");
		logExtentReport("Clicking on Test Operation button");
		WebElement element = driver.findElement(By.xpath("//span[@title='convertDocumentToFlatFile']/parent::*/following-sibling::div[2]/child::span[2]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

	}
	
	public void clickShowIOSignatureOfConvertDocumentToFlatfileButton() {
		log.info("Clicking on show i/o signature button");
		logExtentReport("Clicking on show i/o signature button");
		WebElement element = driver.findElement(By.xpath("//span[@title='convertDocumentToFlatFile']/parent::*/following-sibling::div[2]/child::span[2]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

	}
	
	
	public void clickShowIOSignatureOfConvertFlatfileToDocumentButton() {
		log.info("Clicking on show i/o signature button");
		logExtentReport("Clicking on show i/o signature button");
		WebElement element = driver.findElement(By.xpath("//span[@title='convertFlatFileToDocument']/parent::*/following-sibling::div[2]/child::span[1]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

	}
	
	
	
}
