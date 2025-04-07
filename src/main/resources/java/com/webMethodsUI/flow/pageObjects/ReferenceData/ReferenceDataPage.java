package com.webMethodsUI.flow.pageObjects.ReferenceData;

import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;

import com.webMethodsUI.flow.testbase.TestBase;

public class ReferenceDataPage {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(ReferenceDataPage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//button[contains(text(),'Add Reference Data')]")
	@CacheLookup
	WebElement addReferenceDataButtonElement;

	@FindBy(xpath = "//h5[contains(text(),'Reference Data')]")
	@CacheLookup
	WebElement referenceDataTitleElement;

	@FindBy(xpath = "//p[contains(text(),'No Reference Data added yet!')]")
	@CacheLookup
	WebElement noRecordToDisplayTextElement;

	@FindBy(xpath = "//i[@class='dlt-icon-more-menu dlt-icon']")
	@CacheLookup
	WebElement threeDotIconElement;

	@FindBy(xpath = "//i[@class='dlt-icon-delete menu-icons']")
	@CacheLookup
	WebElement deleteIconElement;

	@FindBy(xpath = "//button[@class='dlt-button dlt-button-secondary sm-button']")
	@CacheLookup
	WebElement deleteButtonElement;

	public ReferenceDataPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(referenceDataTitleElement, ObjectReader.reader.getExplicitWait());
		log.info(" Reference data main page...." + referenceDataTitleElement);
		logExtentReport("Reference data main page...." + referenceDataTitleElement);
	}

	public void clickOnAddReferenceDataButtonElement() {
		log.info("  Clicking on add  reference data  button...");
		logExtentReport("  Clicking on add  reference data  button.. ...");
		waitHelper.waitForElement(addReferenceDataButtonElement, ObjectReader.reader.getExplicitWait());
		addReferenceDataButtonElement.click();

	}

	public String getAddReferenceDataButtonElement() {
		log.info("  Verifing  add  reference data  button is visible ...");
		logExtentReport("  Verifing  add  reference data  button is visible. ...");

		return addReferenceDataButtonElement.getText();

	}

	public void deleteReferenceData(String ReferencedataName) throws InterruptedException {
		log.info("  Clicking on three dot icon to delete reference data  ...");
		logExtentReport(" Clicking on three dot icon to delete reference data  ....");
       WebElement action1 = driver.findElement(By.xpath("//td[contains(text(),'"+ReferencedataName+"')]/ancestor::tr/td[7]/div[1]/div[1]/button"));
		action1.click();
		//threeDotIconElement.click();
		log.info("  Clicking on delete icon for deleting reference data  ...");
		logExtentReport(" Clicking on delete icon for deleting reference data ... ...");
        WebElement element = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/div[1]/div[1]/div[2]/button[1]"));
		element.click();

		waitHelper.waitForElement(deleteButtonElement, ObjectReader.reader.getExplicitWait());
		log.info(" waiting for delete button...." +deleteButtonElement);
		logExtentReport("waiting for delete button..." + deleteButtonElement);
		Thread.sleep(2000);
		log.info("  Clicking on delete button for deleting reference data  ...");
		logExtentReport(" Clicking on delete button for deleting reference data ... ...");
		deleteButtonElement.click();


//		waitHelper.waitForElement(noRecordToDisplayTextElement, ObjectReader.reader.getExplicitWait());
//		log.info(" waiting for no record text ...." +noRecordToDisplayTextElement);
//		logExtentReport("waiting for delete button..." + noRecordToDisplayTextElement);
		

	}

	public void clickOn(WebElement ele, WebDriver driver, int timeout) {
		final WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ele)));
		ele.click();

	}

	public String verifyNoReferenceDataPresent() {
		log.info(" Verifing no reference data text is present    ...");
		logExtentReport("Verifing no reference data text is present    .......");

		return noRecordToDisplayTextElement.getText();

	}

	public boolean verifyCreatedReferenceData(String referenceDataName) {

		log.info("  Verifing" + referenceDataName + " document name is visible.......... ");
		logExtentReport(" Verifing" + referenceDataName + " document name is visible..........  ");

		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + referenceDataName + "')]"));
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting for created reference data is visible...." +element);
		logExtentReport("waiting for created reference data is visible..." + element);

		return element.isDisplayed();

	}

}
