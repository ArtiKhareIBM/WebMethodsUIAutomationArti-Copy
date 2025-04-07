package com.webMethodsUI.flow.pageObjects.soapapi;

import java.time.Duration;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class APIDetailsPage extends CommonActions{
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(APIDetailsPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//strong[contains(text(),'Documentation')]")
	@CacheLookup
	WebElement documentationTitleElement;
	
	
	
	@FindBy(xpath = "//span[@class='copyurl dlt-icon-copy ']")
	@CacheLookup
	WebElement copyWsdlUrlIconElement;
	
	@FindBy(xpath = "//div[@class='content-basic-info']//div[@class='col s6']//span[@class='swagger-download-url'][contains(text(),'https:')]")
	@CacheLookup
	WebElement wsdlUrlElement;



	@FindBy(xpath = "//span[@class='soap-api-edit-pencil-icon delite-icon dlt-icon-edit']")
	@CacheLookup
	WebElement EditpencilElenent;

	public APIDetailsPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitForElementVisible(documentationTitleElement, driver, "Wait for API details page title to be visible");
		
	}
	
	
	public String getsoapAPIName() {
		
		WebElement element = driver.findElement(By.xpath("//span[@class='edit-name'][contains(text(),'Name')]/parent::div//following-sibling::div/span"));
		return element.getText();
		
	}
	
	 public void clickOnLinkMenu(String linkText) throws Exception 
	 {
			
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+linkText+"')]"));		
			click(element, driver, "Click on menu link");
		
		}
	 
	 
	 public String  getWsdlUrl() throws Exception 
	 {
		 
		 click(copyWsdlUrlIconElement, driver, "clicking on copyUrlIcon.... and  fetching element text is  " + wsdlUrlElement.getText());
		 return wsdlUrlElement.getText();
		 
	 }
	 
	 public boolean verifyCopyWsdlUrlIcon() 
	 {
		 
		 log.info("Verifing CopyUrlIcon is visible ... ..."+ copyWsdlUrlIconElement );
		 logExtentReport("Verifing  wsdl url copy icon is disolay....... ");
		 				
		return copyWsdlUrlIconElement.isDisplayed();
		 
	 }


	public String copytheURL() throws InterruptedException 
	{

		log.info("Clicking on ..."+ copyWsdlUrlIconElement);
		logExtentReport(
				"clicking on copyUrlIcon.... and  fetching element text is  " + wsdlUrlElement.getText());
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='col s6']/span[@class='swagger-download-url']"));
		copyWsdlUrlIconElement.click();
		copyWsdlUrlIconElement.click();
		return element.getText();

	}

	public void editelement(){
		log.info("click edit element." );
		logExtentReport("click edit element.");
		EditpencilElenent.click();

	}

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement SuccessMessage;


	public String getSuccesMessageofImportfile() 
	{
		log.info("Getting successMessage...");
		logExtentReport("Getting successMessage...");
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
		return SuccessMessage.getText();
	}

	public void waittillitappears() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ObjectReader.reader.getExplicitWait()));
		wait.until(ExpectedConditions.not(
				ExpectedConditions.textToBePresentInElement(SuccessMessage, SuccessMessage.getText())));
	}

}
