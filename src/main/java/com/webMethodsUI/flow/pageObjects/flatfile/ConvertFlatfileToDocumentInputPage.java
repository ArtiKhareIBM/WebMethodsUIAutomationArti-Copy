package com.webMethodsUI.flow.pageObjects.flatfile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ConvertFlatfileToDocumentInputPage extends CommonActions{
	WebDriver driver;
	private Logger log = LogManager.getLogger(ConvertFlatfileToDocumentInputPage.class);
	WaitHelper waitHelper;
	
	
	@FindBy(xpath = "//input[@name='ffDataString']")
	@CacheLookup
	WebElement inputFieldElement;
	
	@FindBy(xpath = "//h1[contains(text(),'convertFlatFileToDocument')]")
	@CacheLookup
	WebElement convertFlatfileToDocumentTitleElement;
	

	public ConvertFlatfileToDocumentInputPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(inputFieldElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now...." + inputFieldElement);
		logExtentReport("input Filed element Object created");
	}

	public String getPredefinedOperationsTitle() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +convertFlatfileToDocumentTitleElement.getText());
        return convertFlatfileToDocumentTitleElement.getText();
	}
	
	public void enterInput() throws InterruptedException
	{
		log.info("Entering REST connector Description... ");
		logExtentReport("Entering REST connector Description... ");
		inputFieldElement.click();
		inputFieldElement.clear();
		//inputFieldElement.sendKeys("CRLF:Fairfax:Virginia:22030@1234:(703)123-4568!CRLF:Centreville:VA:20120@4321:(703)229-1688!");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='CRLF:Fairfax:Virginia:22030@1234:(703)123-4568!CRLF:Centreville:VA:20120@4321:(703)229-1688!'",inputFieldElement);
		Thread.sleep(5000);
	}
	
	
	 
	public ResultPage clickRunButton() throws Exception
	{
		log.info("Clicking on the Run Button... ");
		logExtentReport("Clicking on the Run Button... ");
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Run");
		return new ResultPage(driver);
	}

	
	
}
