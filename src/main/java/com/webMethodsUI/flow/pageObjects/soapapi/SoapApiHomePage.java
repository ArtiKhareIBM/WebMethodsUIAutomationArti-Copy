package com.webMethodsUI.flow.pageObjects.soapapi;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class SoapApiHomePage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(SoapApiHomePage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//h1[@class='rest-header-title']")
	@CacheLookup
	WebElement soapApiHomePageTitleElement;
	
	@FindBy(xpath = "//button[contains(text(),'Create API')]")
	@CacheLookup
	WebElement createAPIButtonElement;
	
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	WebElement deleteButtonElement;
	
	
	
	@FindBy(xpath = "//span[text()='No APIs created yet!']")
	@CacheLookup
	WebElement noApiCreatedElement;
	
	

	
	@FindBy(xpath = "//a[@title='Copy SOAP API']")
	@CacheLookup
	WebElement copySoapApiIcon;
	
	
	
	@FindBy(xpath = "//input[@value='Select Project']")
	@CacheLookup
	WebElement selectProject;
	
	
	@FindBy(xpath = "/input[@placeholder='Provide a suitable name for this API']")
	@CacheLookup
	WebElement copySoapApiName;
	

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButtonElement;

       @FindBy(xpath = "//a[@title='Edit SOAP API']")
	@CacheLookup
	WebElement editSoapApiElement;    
       
       String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
     //SoapApiBasicInfoPage
       
	public SoapApiHomePage(WebDriver driver) 
	{

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		log.info("SoapAPI Home Page objects created");
		logExtentReport("SoapAPI Home Page objects created");
	}
	
	
	public String getSoapApiTitle() {
		
		log.info("Getting the soap api page title..............");
		logExtentReport("Getting the soap api page title..............");
		return soapApiHomePageTitleElement.getText();
		
	}
	
	
	public SoapApiLetsGetStartedPage clickOnCreateApiButton() throws Exception
	{
		click(createAPIButtonElement, driver, "clicking on create api button...");
		return new SoapApiLetsGetStartedPage(driver);	
	}


	public void deleteSoapAPI(String soapApiName) throws Exception {
		
		WebElement element = findElement("//span[contains(text(),'"+soapApiName+"')]/parent::div/parent::div//a[@title='Delete SOAP API']",driver);
		click(element, driver, "Clicking on delete soap api icon");
		click(deleteButtonElement, driver, "Clicking on deleteButtonElement");
		
	}

   public SoapApiBasicInfoPage editSoapApi() throws Exception {
		
		click(editSoapApiElement, driver, "Editing the soap api..............");
		return new SoapApiBasicInfoPage(driver);
		
	}
	
   	public void copySoapAPI(String copysoapApiName, String projectName) {
		
	log.info("clicking on copy icon on soap api page   ...");
		logExtentReport("clicking on copy icon on soap api page   ...");

		copySoapApiIcon.click();
		log.info("selecting the project   ...");
		logExtentReport("clicking on copy icon on soap api page   ...");
		selectProject.click();
		//exe.executeScript("arguments[0].scrollIntoView(true);", element1);
		WebElement element = driver.findElement(By.xpath("//input[@value='"+projectName+"')]"));
		//input[@value='IC_Test']
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		jse.executeScript("argument[0].click()",element);
		copySoapApiName.sendKeys(copysoapApiName);
		saveButtonElement.click();
		
	}
      
      public boolean verifySoapApiName(String soapApiName) {
    	  WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+soapApiName+"')]"));
    	  log.info("verifing  on soap Api name  ...");
  		logExtentReport("verifing on soap Api name ....");
  		return  element.isDisplayed(); 
    	  
      }
	
      public void clickOnSoapApiNameLink(String soapApiName) throws Exception 
      {
 		 
 	  		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+soapApiName+"')]"));
 	  		click(element, driver, "clicking   on soap Api name  link..."+soapApiName );
 	  		waitForElementNotVisible(loader, driver, "wait for page load");
 	  		
 	 }
      
      public String getApiEmptyMessageDisplay() throws Exception 
      {
    	  Thread.sleep(2000);
    	  log.info(" verifying massage No APIs created yet.." );
	  		logExtentReport("verifying massage No APIs created yet...." );
    	  
    	  return noApiCreatedElement.getText();
      }
	

     
      
	
}
