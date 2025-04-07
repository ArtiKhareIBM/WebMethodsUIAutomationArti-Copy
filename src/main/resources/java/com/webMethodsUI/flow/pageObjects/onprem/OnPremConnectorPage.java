package com.webMethodsUI.flow.pageObjects.onprem;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.common.OperationsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class OnPremConnectorPage {

	WebDriver driver;
	private Logger log = LogManager.getLogger(OnPremConnectorPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//span[contains(text(),'On-Premises Connectors')]")
	@CacheLookup
	WebElement onPremConnetorPageTitle;
	
	@FindBy(xpath = "//span[contains(text(),'myPackage')]")
	@CacheLookup
	WebElement myPackageOnpremeTitle;
	
	@FindBy(xpath = "//span[contains(text(),'wmioonpremAPP')]")
	@CacheLookup
	WebElement wmioOnpremeTitle;


	@FindBy(xpath = "//span[@class='inner-view-title']")
	@CacheLookup
	WebElement onPremConnectorNameElement;

	@FindBy(xpath = "//button[contains(text(),'Operations')]")
	@CacheLookup
	WebElement operationButton;

	public OnPremConnectorPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(onPremConnetorPageTitle, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport(
				"element is visible now.... and element text is  " + onPremConnetorPageTitle.getText());

	}

	public String getOnPremConnectorPageTitle() {
		return onPremConnetorPageTitle.getText();
	}

	public OperationsPage clickOnOperation(String connectorName) {

		log.info("Clicking on OnPrem  connector Operation name " + connectorName);
		logExtentReport("Clicking on OnPrem  connector Operation name" + connectorName);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + connectorName + "')]"));
		element.click();

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(operationButton, ObjectReader.reader.getExplicitWait());
		log.info("operationButton button is visible");
		logExtentReport("operationButton button is visible");
		operationButton.click();
		log.info("Clicked on operationButton..." + operationButton);
        return new OperationsPage(driver);

	}

	public String getConnectorName() {

		return wmioOnpremeTitle.getText();
	}

}