package com.webMethodsUI.flow.pageObjects.SOAPConnector;

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

public class InputSignaturePage {

	WebDriver driver;
	private Logger log = LogManager.getLogger(InputSignaturePage.class);
	WaitHelper waitHelper;
	WebElement element;

	@FindBy(xpath = "//div[contains(text(),'INPUT')]")
	@CacheLookup
	WebElement inputTitleElement;

	@FindBy(xpath = "//i[@class='tree-icon dlt-icon-plus']")
	@CacheLookup
	WebElement plusIconElement;
	
	@FindBy(xpath = "//div[contains(text(),'OUTPUT')]")
	@CacheLookup
	WebElement outputTitleElement;

	//span[contains(text(),' status')]


	
	

	public InputSignaturePage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(inputTitleElement, ObjectReader.reader.getExplicitWait());
		log.info(" Input element is visible in i/o signature page....");
		logExtentReport("Input element is visible in i/o signature page.... and element text is  "
				+ inputTitleElement.getText());

	}

	public void clickOnPlusIcon() {
		log.info(" Clicking on plus icon on input signature  page.........");
		logExtentReport("Clicking on plus icon on input signature  page.........");
		waitHelper.waitForElement(plusIconElement, ObjectReader.reader.getExplicitWait());
		plusIconElement.click();

	}

	public boolean verifyInputField(String fieldName) {

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + fieldName + "')]"));
		log.info(" Verifying " + element.getText() + "  element is display on input signatur field.........");
		logExtentReport(
				" Verifying "+element.getText()+"  element is display on input signatur field.........");

		return element.isDisplayed();
	}
	
	  public  void clickOnOutput() {
		  waitHelper.waitForElement(outputTitleElement, ObjectReader.reader.getExplicitWait());
		  outputTitleElement.click();
		  log.info(" output element is visible in i/o signature page....");
			logExtentReport("output element is visible in i/o signature page.... and element text is  "
					+ outputTitleElement.getText());
			
	  }

	  public boolean VerifyField(String Field){
		  log.info(" Verifying   element is display on output signatur field........." + Field  );
		  logExtentReport(" Verifying   element is display on output signatur field........." + Field);
          WebElement Element = driver.findElement(By.xpath("//span[contains(text(),'"+Field+"')]"));
          return Element.isDisplayed();
	  }


	  }


