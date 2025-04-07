package com.webMethodsUI.flow.pageObjects.restapi;

import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceCanvasPage;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HttpMethodPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(HttpMethodPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//textarea[@aid='Description']")
	@CacheLookup
	WebElement HttpMethodPageDescriptionElement;

	@FindBy(xpath = "//h1[@class='resources-title left']")
	@CacheLookup
	WebElement httpMethodNameElemnt;

	@FindBy(xpath = "//span[@class='operation-path']")
	@CacheLookup
	WebElement pathElement;

	@FindBy(xpath = "//input[@placeholder='Type Resource Path']")
	@CacheLookup
	WebElement ResourcePath;

	@FindBy(xpath = "//div[contains(text(),'Select Workflow/FlowService')]")
	@CacheLookup
	WebElement selectWorkFlowORFlowServiceDropDownElement;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement doneButtonElement;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public HttpMethodPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(httpMethodNameElemnt, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now.... and element text is  ");
		logExtentReport("Resource Title element is visible now.... and text is  ");

	}

	public void enterResourceDescription(String resourceDescription) {
		log.info("Entering resource Description... " + resourceDescription);
		logExtentReport("Entering resource description ... " + resourceDescription);
		HttpMethodPageDescriptionElement.sendKeys(resourceDescription);

	}

	public String getResourcePathName() {
		log.info("Getting resource path name.....");
		logExtentReport("Getting resource path name.....");
		return pathElement.getText();
	}

	public void selectFlowService(String flowServiceName) throws Exception 
	{
			Actions action = new Actions(driver);
			waitHelper.waitForElement(selectWorkFlowORFlowServiceDropDownElement, ObjectReader.reader.getExplicitWait());
			action.click(selectWorkFlowORFlowServiceDropDownElement).click().sendKeys(flowServiceName)
					.sendKeys(Keys.ENTER).build().perform();
			waitForElementNotVisible(loader, driver, "wait for page load");
			log.info("select the flow service from drop down....." + flowServiceName);
			logExtentReport("select the flow service from drop down....." + flowServiceName);
			getNavigationScreen(driver);
	}

	public ResourcesAndMethodsPage clickOnDoneButton() throws Exception {
		
		click(doneButtonElement,driver,"Clicking on done button");
		waitForElementNotVisible(loader, driver, "wait for page load");
    	return new ResourcesAndMethodsPage(driver);

	}
	
	public FlowServiceCanvasPage clickselectedFlowService(String FlowServiceName) throws Exception{
		log.info("click the allready selected flowservice" +FlowServiceName);
		logExtentReport("click the allready selected flowservice" +FlowServiceName);
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+ FlowServiceName +"')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		return new FlowServiceCanvasPage(driver);
	}

	public void VerifyAddresponseAndAddresponse() {
		log.info("verify Add response is visible");
		logExtentReport("verify Add response is visible");
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Add Response')]"));
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(element,ObjectReader.reader.getExplicitWait());
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}

	public void enteringhttpresponse(int index){
		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//input[@placeholder='Http Code']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
	}

	public String verifyparameterisdisplayed(){
		log.info("verify parametertab is visible");
		logExtentReport("verify parametertab is visible");
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Parameters')]"));
		return element.getText();
	}

	public boolean verifyparameterField(String fieldValue){
		log.info("verify field is visible "+fieldValue);
		logExtentReport("verify field is visible "+fieldValue);
		WebElement element = driver.findElement(By.xpath("//span[@class='single-row-title'][contains(text(),'"+fieldValue+"')]"));
		return element.isDisplayed();

	}


}
