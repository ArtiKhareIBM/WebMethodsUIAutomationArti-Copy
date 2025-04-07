package com.webMethodsUI.flow.pageObjects.ReferenceData;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class ConfirmPage {
	
	

	
		private WebDriver driver;
		private Logger log = LogManager.getLogger(ConfirmPage.class);
		TestBase test;

		WaitHelper waitHelper;

		@FindBy(xpath = "//h4[contains(text(),'Confirm')]")
		@CacheLookup
		WebElement confirmTitleElement;
		
		@FindBy(xpath = "//button[contains(text(),'Done')]")
		@CacheLookup
		WebElement doneButtonElement;
		
		
		public ConfirmPage(WebDriver driver) {
			super();
			this.driver = driver;
			PageFactory.initElements(driver, this);
			waitHelper = new WaitHelper(driver);
			waitHelper.waitForElement(confirmTitleElement, ObjectReader.reader.getExplicitWait());
			log.info("  New Reference data  page...." + confirmTitleElement);
			logExtentReport(" New Reference data  page...." + confirmTitleElement);
		}

		public void clickOnDoneButtonElement() {
			log.info("  Clicking on done  button. on confirm  reference data page ..");
			logExtentReport("  Clicking on next  button. confirm reference data page .. ...");
			waitHelper.waitForElement(doneButtonElement, ObjectReader.reader.getExplicitWait());
			doneButtonElement.click();

		}
	}




