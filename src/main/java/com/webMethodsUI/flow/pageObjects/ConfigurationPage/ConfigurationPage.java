package com.webMethodsUI.flow.pageObjects.ConfigurationPage;

import java.util.List;

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

public class ConfigurationPage extends CommonActions{
	private WebDriver driver;
	private Logger log = LogManager.getLogger(ConfigurationPage.class);
	TestBase test;

	WaitHelper waitHelper;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Document types')]")
	@CacheLookup
	WebElement documentTypeElement;
	
	@FindBy(xpath = "//span[contains(text(),' Listeners')]")
	@CacheLookup
	WebElement listenerElement;
	
	@FindBy(xpath = "//span[contains(text(),'Certificates')]")
	@CacheLookup
	WebElement certificatesElement;
	
	@FindBy(xpath = "//span[contains(text(),'Reference data')]")
	@CacheLookup
	WebElement referenceDataElement;



public ConfigurationPage(WebDriver driver) throws Exception {
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);

	waitForElementVisible(certificatesElement, driver, "Wait for Certificates title is visible" , 45);
}



public String getCertificatesElementTitle()
{
	log.info("  Verfing  certificate Element is visible ..." );
	logExtentReport(" Verfing new certificate Element is visible ..." );
	
	 return certificatesElement.getText();
	
}

public void ExpandFlowserviceArrowIcon(int index) throws Exception 
{

	List<WebElement> elemntArray = findElements("//span[@class='sub-title delite-icon dlt-icon-chevron-right']",driver);
	
	WebElement element = elemntArray.get(index);
	click(element, driver, "Clicking on arrow icon ..." +index);
	
}

public void ExpandTriggerArrowIcon(int index) throws Exception 
{
	
	List<WebElement> elemntArray = findElements("//span[@class='sub-title delite-icon dlt-icon-chevron-right']",driver);
	
	WebElement element = elemntArray.get(index);
	click(element, driver, "Clicking on arrow icon ..." +index);
	
}

public boolean isDisplayedDocumentType()
{

	return isElementDisplayed(documentTypeElement, driver, "verifing   document Type  is visible  ...");
	
}

public void clickOnDocumentType() throws Exception
{
	click(documentTypeElement, driver, "  Clicking on document Type  ...");
	
}

public void clickOnListener() throws Exception
{
	click(listenerElement, driver, "  Clicking on Listener  ..." );
	
}

public void clickOnReferenceData() throws Exception
{
	click(referenceDataElement, driver, "  Clicking on Reference data  ..." );
	
}

}

