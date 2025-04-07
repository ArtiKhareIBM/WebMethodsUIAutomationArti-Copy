package com.webMethodsUI.flow.pageObjects.flowService;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class InputValuePage extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(EditMappingPage.class);
	TestBase test;

	WaitHelper waitHelper;

	@FindBy(xpath = "//h4[contains(text(),'Input values')]")
	@CacheLookup
	WebElement inputValueTitleElement;

	@FindBy(xpath = "//button[contains(text(),'Run')]")
	@CacheLookup
	WebElement RunButtonElement;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	public String FlowRunLoader = "//div[contains(@class,'ut-test-loader')]//div[@aria-label='Loading']";


	public InputValuePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(inputValueTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + inputValueTitleElement);
		logExtentReport("input Value Object created");
	}

	public void clickRunButton() throws Exception {

		click(RunButtonElement, driver, "Click on run button");
		Thread.sleep(1000);
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementNotVisible(FlowRunLoader, driver, "wait for page load");
	}

	public void enterInputValue(int index, String value) 
	{

		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("..Total window ........" + count);
		for (String child : allWindows) {

			
			if (parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				log.info(" Entering input value ...");

				List<WebElement> elemntArray = driver
						.findElements(By.xpath("//input[@placeholder='Enter value here']"));
				log.info("All input parameters are....." + elemntArray);
				WebElement element = elemntArray.get(index);
				log.info(" Clicking on element at index..." + index + "......" + element);
				logExtentReport("Clicking on element at index..." + index + "......" + element);
				element.click();
				element.sendKeys(value);

			}
		}

	}
	
	public void enterInputValues(int index, String value) throws Exception 
	{
		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//input[@placeholder='Enter value here']"));
		click(elemntArray.get(0), driver, "Click on input field");
		enterValue(elemntArray.get(0), value, driver, "Enter input value : "+value+"");

	}

	public void Addfieldicon(int index){
		log.info(" clicking field icon...");

		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//span[@title='Add value']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		element.click();
	}


	public void runagain(){
		log.info(" Clicking on again run button ...");
		logExtentReport("Clicking on again run button ...");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",RunButtonElement);
	}


}
