package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class TestOperationResultPage extends CommonActions {
	WebDriver driver;
	private Logger log = LogManager.getLogger(TestOperationResultPage.class);
	WaitHelper waitHelper;
	WebElement element;
	
	@FindBy(xpath = "//span[contains(text(),'Result')]")
	@CacheLookup
	WebElement resultElement;
	
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement cancelButtonElement;
	
	
	@FindBy(xpath = "//section[@class='result-container']//div[3]//div[1]//span[1]//i[1]")
	@CacheLookup
	WebElement plusIconElement;
	
	
	
	
	public TestOperationResultPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(resultElement, ObjectReader.reader.getExplicitWait());
		log.info("Test operation Result page   is visible now....");
		logExtentReport(
				" Test operation Result page   is visible now........ and element text is  " + resultElement.getText());

	}
	
	
	public void clickOnPlusIcon( ) {
		
		log.info(" Clicking on  plus icon element at index   on Test operation result page ..."  );
		logExtentReport("Clicking on  plus icon element at index.. on test operation result page........." );
		waitHelper.waitForElement(plusIconElement, ObjectReader.reader.getExplicitWait());
		plusIconElement.click();
		
	
	}
	
	public boolean isFieldNameDisplayed(  String fieldName) {
		
		WebElement element =driver.findElement(By.xpath("//div[contains(text(),'" + fieldName + "')]"));
				
		log.info(" verifing  output field name on result page..");
		logExtentReport("verifing  output field name on result page.." );
		 return element.isDisplayed();	
	}
	public void clickOnCancelButton() {
		log.info(" Clickin on  cancel button");
		logExtentReport("Clickin on  cancel button");
		waitHelper.waitForElement(cancelButtonElement, ObjectReader.reader.getExplicitWait());
		cancelButtonElement.click();
	}
	
	public void verifyOutputonResultspage() throws Exception
	{
		log.info(" Clickin on  cancel button");
		logExtentReport("Clickin on  cancel button");
		waitHelper.waitForElement(cancelButtonElement, ObjectReader.reader.getExplicitWait());
		WebElement element = findElement("//div[@class='node-label' and text()=' Result']", driver);
		System.out.println(element.getText());
		elementContainsText(element, "Result     20", driver, "Verify test operation is working fine");		
	}
}
