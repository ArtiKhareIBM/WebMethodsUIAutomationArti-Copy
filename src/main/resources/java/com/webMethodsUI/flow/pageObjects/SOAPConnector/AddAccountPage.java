package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;

import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddAccountPage {

	WebDriver driver;
	private Logger log = LogManager.getLogger(AddAccountPage.class);
	WaitHelper waitHelper;
	WebElement element;

	@FindBy(xpath = "//h1[@class='modal-title']")
	@CacheLookup
	WebElement AddAccountModelTitle;

	@FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down ']")

	@CacheLookup
	WebElement portFieldElement;

	@FindBy(xpath = "//input[@name='User']")
	@CacheLookup
	WebElement userNameElement;

	@FindBy(xpath = "//input[@name='Password']")
	@CacheLookup
	WebElement passwordElement;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	@CacheLookup
	WebElement addButtonElement;

	@FindBy(xpath = "//a[contains(text(),'Projects')]")
	@CacheLookup
	WebElement ProjectsMenu;

	@FindBy(xpath = "//input[@name='URL']")
	@CacheLookup
	WebElement accountUrlElement;

	public AddAccountPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(AddAccountModelTitle, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport(
				"Soap Account page is visible now.... and element text is  " + AddAccountModelTitle.getText());

	}

	public String getModelTitle() {
		return AddAccountModelTitle.getText();
	}

	public void selectPortType(String portType) {

		try {
			portFieldElement.click();
			element = driver.findElement(By.xpath("//div[contains(text(),'" + portType + "')]"));
			waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
			element.click();
			log.info("Clicked on auth type....");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterUserName(String userNametxt) {
		log.info("Entering user Name:  " + userNametxt);
		logExtentReport("Entering user Name: " + userNametxt);
		this.userNameElement.sendKeys(userNametxt);

	}

	public void enterPassword(String password) {
		log.info("Entering password " + password);
		logExtentReport("Entering password " + password);
		this.passwordElement.sendKeys(password);
	}

	public void clickOnAddButton() {
		waitHelper.waitForElement(addButtonElement, ObjectReader.reader.getExplicitWait());
		WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait() );
		wait.until(ExpectedConditions.elementToBeClickable(addButtonElement));
		log.info("clicked on add button");
		logExtentReport("clicked on add button");
		addButtonElement.click();

//		WaitHelper waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElement(ProjectsMenu, ObjectReader.reader.getExplicitWait());

	}



	
	
}
