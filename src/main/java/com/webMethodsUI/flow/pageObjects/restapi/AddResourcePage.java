package com.webMethodsUI.flow.pageObjects.restapi;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class AddResourcePage extends CommonActions{
	WebDriver driver;
	private Logger log = LogManager.getLogger(AddResourcePage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//span[contains(text(),'Resources and Methods')]")
	@CacheLookup
	WebElement resourcePageTitleElement;
	
	@FindBy(xpath = "//h1[contains(text(),'Resources and Methods')]")
	@CacheLookup
	WebElement resourcesHeadingElement;
	
	@FindBy(xpath = "//button[contains(text(),'Add Resource')]")
	@CacheLookup
	WebElement addResourceButtonElement;
	
	public AddResourcePage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(resourcePageTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +resourcePageTitleElement.getText());

	}
	
	public String getresourcePageTitle() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +resourcePageTitleElement.getText());
		return resourcePageTitleElement.getText();
	}
	
	public String getresourcesHeading() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +resourcesHeadingElement.getText());
		return resourcesHeadingElement.getText();
	}
	
	public String getaddResourceButton() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +addResourceButtonElement.getText());
        return addResourceButtonElement.getText();
	}

	public void clickexpandDetailicon(String pathName){
		log.info("clicking expandicon...");
		logExtentReport("clicking expandicon...");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+pathName +"')]/parent::div[@class='single-resources-inner-contnet']/span/i"));
		waitHelper.waitForElement(ele, ObjectReader.reader.getExplicitWait());
		ele.click();
	}

	public HttpMethodPage clickmethodlink(){
		log.info("click method link");
		logExtentReport("click method link");
		WebElement element = driver.findElement(By.xpath("//li[@class='operation-view clearfix Post']/span[2]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();
		return new HttpMethodPage(driver);
	}





}
