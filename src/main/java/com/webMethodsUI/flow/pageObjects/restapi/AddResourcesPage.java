package com.webMethodsUI.flow.pageObjects.restapi;

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

public class AddResourcesPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(AddResourcesPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//h1[contains(text(),'Add')]")
	@CacheLookup
	WebElement resourcePageTitle;

	@FindBy(xpath = "//input[@placeholder='Name your Resource']")
	@CacheLookup
	WebElement ResourceName;

	@FindBy(xpath = "//textarea[@placeholder='Describe your Connector']")
	@CacheLookup
	WebElement ResourceDescription;

	@FindBy(xpath = "//input[@placeholder='Type Resource Path']")
	@CacheLookup
	WebElement ResourcePath;
	
	@FindBy(xpath = "//span[contains(text(),'Resources and Methods')]")
	@CacheLookup
	WebElement resourceAndMethodsPageTitleElement;
	
	@FindBy(xpath = "//h1[contains(text(),'Resources and Methods')]")
	@CacheLookup
	WebElement resourcesHeadingElement;
	
	@FindBy(xpath = "//button[contains(text(),'Add Resource')]")
	@CacheLookup
	WebElement addResourceButtonElement;
	
	

	public AddResourcesPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(resourcePageTitle, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now.... and element text is  " + resourcePageTitle.getText());
		logExtentReport(
				"Resource Title element is visible now.... and text is  " + resourcePageTitle.getText());

	}

	public void enterResourceName(String resourceName) {
		log.info("Entering resource Name... " + resourceName);
		logExtentReport("Entering resource name ... " + resourceName);
		ResourceName.sendKeys(resourceName);

	}

	public void enterResourceDescription(String resourceDescription) {
		log.info("Entering resource Description... " + resourceDescription);
		logExtentReport("Entering resource description ... " + resourceDescription);
		ResourceDescription.sendKeys(resourceDescription);

	}

	public void enterResourcePath(String resourcePath) {
		log.info("Entering resource Path... " + resourcePath);
		logExtentReport("Entering resource Path ... " + resourcePath);
		ResourcePath.sendKeys(resourcePath);
	}

	public String getresourcePageTitle() {
		return resourcePageTitle.getText();
	}
	
	public String getResourceAndMethodsPageTitle() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +resourceAndMethodsPageTitleElement.getText());
		return resourceAndMethodsPageTitleElement.getText();
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
	
	
	 

}
