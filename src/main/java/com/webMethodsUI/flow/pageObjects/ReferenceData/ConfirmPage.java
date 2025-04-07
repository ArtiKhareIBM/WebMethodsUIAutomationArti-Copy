package com.webMethodsUI.flow.pageObjects.ReferenceData;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ConfirmPage extends CommonActions{
	

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
		
		@FindBy(xpath = "//h3[text()='Confirm']")
		@CacheLookup
		WebElement confirmHeader;
		
		String confirmHeader_1 = "//h3[text()='Confirm']";
		
		
		public ConfirmPage(WebDriver driver) throws Exception {
			super();
			this.driver = driver;
			PageFactory.initElements(driver, this);
			waitForElementVisible(confirmTitleElement, driver, "wait for New Reference data  page....");
		}

		public void clickOnDoneButtonElement() throws Exception 
		{
			click(doneButtonElement, driver, "  Clicking on done  button. on confirm  reference data page ..");
			waitForElementNotVisible(confirmHeader_1, driver, "Wait for confirm header to invisible");
			WebElement ele = findElement("//p[contains(text(),'Added reference data successfully')]",driver);
			waitForElementVisible(ele, driver, "Wait for added reference data message to be visible",45);
		}
	}




