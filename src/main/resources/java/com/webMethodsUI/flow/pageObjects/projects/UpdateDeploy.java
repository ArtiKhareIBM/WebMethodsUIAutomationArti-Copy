package com.webMethodsUI.flow.pageObjects.projects;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;


public class UpdateDeploy {

	WebDriver driver;
    private Logger log = LogManager.getLogger(Deploypage.class);
    WaitHelper waitHelper;


	 @FindBy(xpath = "//a[contains(text(),'Deploy')]")
	    @CacheLookup
	    public static WebElement UpdateDeployButton;

	 @FindBy(xpath = "//h3[contains(text(),'Deployments')]")
	    @CacheLookup
	    public static WebElement Deploytittle;


	 @FindBy(xpath = "//span[contains(@class,'cross-icon dlt-icon-close')]")
	    @CacheLookup
	    public static WebElement closethepopup;


	    @FindBy(xpath = "//h3[contains(text(),'Configure Accounts')]")
	    @CacheLookup
	    public static WebElement configuraccount;


	    @FindBy(xpath = "//button[contains(text(),'Deploy')]")
	    @CacheLookup
	    public static WebElement Deploybutton;

	    @FindBy(xpath = "//div[@class='notification-message']")
	    @CacheLookup
	    WebElement SuccessMessage;

	    @FindBy(xpath = "//h3[contains(text(),'Configure Triggers')]")
	    @CacheLookup
	    public static WebElement configuretrigger;




	 public UpdateDeploy(WebDriver driver){
	        super();
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	        waitHelper = new WaitHelper(driver);
	        waitHelper.waitForElement(Deploytittle, ObjectReader.reader.getExplicitWait());

	        log.info("element is visible now....");


	    }

	 public void clickingdeployButton() {

		waitHelper.waitForElement(UpdateDeployButton, ObjectReader.reader.getExplicitWait());
		UpdateDeployButton.click();
	     log.info("clicking the deploybutton" );
	      logExtentReport("clicking the deploybutton" );


 }

	  public void closedeploypopup(){
	      // waitHelper.waitForElement(closebutton, ObjectReader.reader.getExplicitWait());
	       closethepopup.click();
	       log.info("close the page" );
	       logExtentReport("close the page" );
	   }

	  public void ClickingNextbutton(){
	        try {
	        	waitHelper.waitForElement(configuraccount, ObjectReader.reader.getExplicitWait());
	            GenericHelper genericHelper = new GenericHelper(driver);
	            genericHelper.clickButton("Next");
	        }
	        catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }


	  public void ClickingsecondNextbutton(){
	        try {
	        	waitHelper.waitForElement(configuretrigger, ObjectReader.reader.getExplicitWait());
	            GenericHelper genericHelper = new GenericHelper(driver);
	            genericHelper.clickButton("Next");
	        }
	        catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }

	  public void clickingDeploybutton(){
	        try {

	            GenericHelper genericHelper = new GenericHelper(driver);
	            genericHelper.clickButton("Deploy");
	        }
	        catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }
	  public String getSuccesMessage(){
	        log.info("Getting successMessage...");
	        logExtentReport("Getting successMessage...");
	        waitHelper = new WaitHelper(driver);
	        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
	        return SuccessMessage.getText();
	    }
	//span[(text()='page')]


}
