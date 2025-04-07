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

	@FindBy(xpath = "//div[contains(text(),'Select services')]")
	@CacheLookup
	WebElement selectWorkFlowORFlowServiceDropDownElement;

	@FindBy(xpath = "//div[contains(text(),'Select runtime')]")
	@CacheLookup
	WebElement selectRuntime;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement doneButtonElement;

	@FindBy(xpath = "//button[@title='Sync']")
	@CacheLookup
	WebElement syncbutton;
	
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
			waitForElementVisible(selectWorkFlowORFlowServiceDropDownElement, driver, "Verify select workflow flow service drop down is visible");
			action.click(selectWorkFlowORFlowServiceDropDownElement).click().sendKeys(flowServiceName)
					.sendKeys(Keys.ENTER).build().perform();
			waitForElementNotVisible(loader, driver, "wait for page load",60);
			log.info("select the flow service from drop down....." + flowServiceName);
			logExtentReport("select the flow service from drop down....." + flowServiceName);
			getNavigationScreen(driver);
	}

	public void isprivateVariable(String servicename) throws Exception
	{
		click(selectWorkFlowORFlowServiceDropDownElement, driver, "click on the dropdown");
		String data = "//*[contains(text(),'" +servicename + "')]";
		waitForElementNotVisible(data, driver, "verfiying the private serivce listing" +data, 5);

	}


	public void selectctRuntime(String Servicename) throws Exception
	{
		Actions action = new Actions(driver);
		waitForElementVisible(selectRuntime, driver, "Verify select  service drop down is visible");
		action.click(selectRuntime).click().sendKeys(Servicename)
				.sendKeys(Keys.ENTER).build().perform();
		waitForElementNotVisible(loader, driver, "wait for page load",60);
		log.info("select the  service from drop down....." + Servicename);
		logExtentReport("select the flow service from drop down....." + Servicename);
		getNavigationScreen(driver);
	}

	public String getMessagefromrrsourcepage(String Message) throws Exception
	{

		log.info("Get the some message from rest api page before clicking done button " + Message);
		logExtentReport("Get the some message from rest api page before clicking done button   " + Message);
		WebElement element = findElement("//p[contains('" + Message + "')]",driver);
		return element.getText();

	}

	public ResourcesAndMethodsPage clickOnDoneButton() throws Exception {
		
		click(doneButtonElement,driver,"Clicking on done button");
		waitForElementNotVisible(loader, driver, "wait for page load");
    	return new ResourcesAndMethodsPage(driver);

	}
	
	public FlowServiceCanvasPage clickselectedFlowService(String FlowServiceName) throws Exception
	{
		
		WebElement element = findElement("//a[contains(text(),'"+ FlowServiceName +"')]",driver);
		click(element, driver, "click the allready selected flowservice" +FlowServiceName);
		Thread.sleep(35000);
		return new FlowServiceCanvasPage(driver);
	}

	public void VerifyAddresponseAndAddresponse() throws Exception 
	{
		log.info("verify Add response is visible");
		logExtentReport("verify Add response is visible");
		WebElement element = findElement("//a[contains(text(),'Add Response')]",driver);
		click(element, driver, "Click on Add Response Button");
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
