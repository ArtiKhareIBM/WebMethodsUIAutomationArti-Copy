package com.webMethodsUI.flow.pageObjects.RESTConnector;
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
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class Dynamicoperationconfiguration extends CommonActions{
WebDriver driver;
private Logger log = LogManager.getLogger(Dynamicoperationconfiguration.class);
WaitHelper waitHelper;


@FindBy(xpath = "//span[@class='custom-operation-step-title inline-title '][contains(text(),'Connection')]")
@CacheLookup
WebElement ConnectionStepTitle;




@FindBy(xpath="//span[contains(text(), 'Username')]")
@CacheLookup
WebElement CheckUsername;

@FindBy(xpath = "//span[@class='custom-operation-step-title'][contains(text(),'Select the Operation')]")
@CacheLookup
WebElement customOperationStepTitle;



  public Dynamicoperationconfiguration(WebDriver driver) {

    super();
    this.driver = driver;
    PageFactory.initElements(driver, this);

    waitHelper = new WaitHelper(driver);
    waitHelper.waitForElement(ConnectionStepTitle, ObjectReader.reader.getExplicitWait());
    log.info("element is visible now.... and element text is  " + ConnectionStepTitle.getText());
    logExtentReport("connection element is visible now.... and text is  " + ConnectionStepTitle.getText());

}
  public void checkUsername(String fieldname)
  {
  	WebElement element = driver.findElement(By.xpath("//span[contains(text(), '"+fieldname+"')]"));
  	log.info("enabling the checkboxes in the dynamic connection");
  	element.click();
  	 logExtentReport("enabling the "+fieldname );

  }
  public String getcustomOperationStepTitle() {
		waitHelper.waitForElement(ConnectionStepTitle, ObjectReader.reader.getExplicitWait());
		return ConnectionStepTitle.getText();
	}

public void clickOnResourceName(String resourceName, String httpMethod) {
		log.info("Clicking on resource..." +resourceName +" And http method is " +httpMethod);
		logExtentReport("Clicking on resource..." +resourceName +" And http method is " +httpMethod);

		String fullResourceName = (httpMethod.toLowerCase())+resourceName;
		log.info("resource to be cliked is ...." +fullResourceName);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+fullResourceName+"')]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();

	}
public void clickdonebutton() throws Exception {
	log.info("Clicking on Done button...");
	logExtentReport("Clicking on Done button...");
	GenericHelper genericHelper = new GenericHelper(driver);
	genericHelper.clickButton("Done");
	Thread.sleep(4000);
}
public String getcustomOperationselectionStepTitle() {
	waitHelper.waitForElement(customOperationStepTitle, ObjectReader.reader.getExplicitWait());
	return customOperationStepTitle.getText();
}


}
