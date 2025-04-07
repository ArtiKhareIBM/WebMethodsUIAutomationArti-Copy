package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddAccountPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class SOAPConnectorPage extends CommonActions{
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(SOAPConnectorPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//div[contains(text(),'No connectors created yet!')]")
	@CacheLookup
	WebElement soapConnectorContentElement;

	
	public SOAPConnectorPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(soapConnectorContentElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + soapConnectorContentElement);
		logExtentReport("element is visible now.... and element text is  " + soapConnectorContentElement.getText());

	}
	

}
