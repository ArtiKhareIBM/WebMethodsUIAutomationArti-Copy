package com.webMethodsUI.flow.pageObjects.Import;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.flowService.CustomActionAccountPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ImportTest extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(CustomActionAccountPage.class);
	TestBase test;
	WaitHelper waitHelper;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButtonElement;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
	@CacheLookup
	WebElement SubmitButtonElement;

    @FindBy(xpath = "//h3[contains(text(),'Custom operation')]")
	@CacheLookup
	WebElement customoperationtext;

    @FindBy(xpath = "//p[contains(text(),'The following FlowServices list will be imported')]")
	@CacheLookup
	WebElement flowtext;


    public ImportTest(WebDriver driver) {

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }










public void  clickNextButton() throws InterruptedException {
		log.info("Clicking on Next button.....");
		logExtentReport("clicking on Next button.....");
		Thread.sleep(5000);

		Actions action = new Actions(driver);
		//workaround to click next button as its not enabling by default after adding account info
		//action.click(customOperationNameElemnt).build().perform();
		//clicking on next button
		 waitHelper.waitForElement(flowtext, ObjectReader.reader.getExplicitWait());
		action.click(nextButtonElement).build().perform();
		//nextButtonElement.click();
		//return new Dynamicoperationconfiguration(driver);

	}

public void  clickSubmitButtonElement() throws InterruptedException {
	log.info("Clicking on Next button.....");
	logExtentReport("clicking on Next button.....");
	Thread.sleep(5000);

	Actions action = new Actions(driver);
	//workaround to click next button as its not enabling by default after adding account info
	//action.click(customOperationNameElemnt).build().perform();
	//clicking on next button
	 waitHelper.waitForElement(customoperationtext, ObjectReader.reader.getExplicitWait());
	action.click(SubmitButtonElement).build().perform();
	//nextButtonElement.click();
	//return new Dynamicoperationconfiguration(driver);

}



}



