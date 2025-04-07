package com.webMethodsUI.flow.pageObjects.flowService;

import java.util.List;
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

public class DefineOutputFieldsPage {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(DefineOutputFieldsPage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h4[contains(text(),'Define input and output fields')]")
	@CacheLookup
	WebElement defineInputOutputPageTitleElement;

	@FindBy(xpath = "//span[contains(text(),'Output Fields')]")
	@CacheLookup
	WebElement outputFieldElement;

	@FindBy(xpath = "//input[@value='Done']")
	@CacheLookup
	WebElement doneButtonElement;

	public DefineOutputFieldsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(defineInputOutputPageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("  Define input and output fields element is visible now...." + defineInputOutputPageTitleElement);
		logExtentReport(" Define input and output fields page...");
	}

	public void selectOuputFieldPage() {
		log.info("  Clicking on output field  label...");
		logExtentReport("  Clicking on output field  label...");
		waitHelper.waitForElement(outputFieldElement, ObjectReader.reader.getExplicitWait());
		outputFieldElement.click();

	}

	public void clickplusIcon(int index) {

		log.info("  Clicking on plus icon ..." + index);
		logExtentReport(" Clicking on plus icon ..." + index);

		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//a[@class='io-tree-action-icon io-add-icon dlt-icon-plus ng-star-inserted']"));

		WebElement element = elemntArray.get(index);
		element.click();

	}

	public void createOutputDataField(int index, String dataFieldName) {
		log.info("  Creating dataField  on  output field  page ...");

		List<WebElement> elemntArray = driver.findElements(By.xpath("//input[@placeholder='Field name']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		log.info("element at index..." + index + "......" + element);
		logExtentReport("element at index..." + index + "......" + element);
		element.click();
		element.clear();
		element.sendKeys(dataFieldName);

	}

	public void clickDoneButton() {
		log.info("  Clicking on  done button ...");
		logExtentReport("  Clicking on done button successfully...");
		waitHelper.waitForElement(doneButtonElement, ObjectReader.reader.getExplicitWait());
		doneButtonElement.click();

	}

}
