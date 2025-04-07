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
import com.webMethodsUI.flow.testbase.TestBase;

public class ConfigurationPage {
	private WebDriver driver;
	private Logger log = LogManager.getLogger(ConfigurationPage.class);
	TestBase test;

	WaitHelper waitHelper;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Document types')]")
	@CacheLookup
	WebElement documentTypeElement;

	
	
	@FindBy(xpath = "//span[contains(text(),'Certificates')]")
	@CacheLookup
	WebElement certificatesElement;
	
	@FindBy(xpath = "//span[contains(text(),'Reference data')]")
	@CacheLookup
	WebElement referenceDataElement;



public ConfigurationPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);
	waitHelper = new WaitHelper(driver);
	waitHelper.waitForElement(certificatesElement, ObjectReader.reader.getExplicitWait());
	log.info(" New certificate page...." + certificatesElement);
	logExtentReport(" New certificate page.......");
}



public String getCertificatesElementTitle(){
	log.info("  Verfing  certificate Element is visible ..." );
	logExtentReport(" Verfing new certificate Element is visible ..." );
	
	 return certificatesElement.getText();
	
}

public void ExpandFlowserviceArrowIcon(int index) {

	log.info("  Clicking on arrow icon ..." +index);
	logExtentReport(" Clicking on arrow icon ..." +index);
	
	List<WebElement> elemntArray = driver
			.findElements(By.xpath("//span[@class='sub-title delite-icon dlt-icon-chevron-right']"));
	
	WebElement element = elemntArray.get(index);
	element.click();

	
}

public boolean isDisplayedDocumentType(){
	log.info("  verifing   document Type  is visible  ..." );
	logExtentReport(" visible   document Type is visible ..." );
	
	
	return documentTypeElement.isDisplayed();
	
}

public void clickOnDocumentType(){
	log.info("  Clicking on document Type  ..." );
	logExtentReport(" Clicking on document Type..." );
	waitHelper.waitForElement(documentTypeElement, ObjectReader.reader.getExplicitWait());
	documentTypeElement.click();
	
}

public void clickOnReferenceData(){
	log.info("  Clicking on Reference data  ..." );
	logExtentReport(" Clicking on reference data.." );
	waitHelper.waitForElement(referenceDataElement, ObjectReader.reader.getExplicitWait());
	referenceDataElement.click();
	
}

}

