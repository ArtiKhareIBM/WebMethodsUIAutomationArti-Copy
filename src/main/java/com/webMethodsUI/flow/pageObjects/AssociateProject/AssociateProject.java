package com.webMethodsUI.flow.pageObjects.AssociateProject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.Certificates.CertificatesHomepage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class AssociateProject  extends CommonActions
{

    
	public AssociateProject(WebDriver driver) throws Exception {
		super(); 
		this.driver = driver;
		
		// All webelements defined in this page are initialized with below line at runtime
		PageFactory.initElements(driver, this);
		logExtentReport("Associate project page  Object created");

	}
    
	  private WebDriver driver;
	  
	    private Logger log = LogManager.getLogger(CertificatesHomepage.class);
	    TestBase test;
	    WaitHelper waitHelper;
	    
	    @FindBy(xpath = "//h1[text()='Associate']")
		@CacheLookup
		public WebElement AssociateModal;
	    
	    @FindBy(xpath = "//span[contains(text(),'Associate selected project(s) with the project ')]")
		@CacheLookup
		public WebElement InfoText;
	    
	    public String loader()
	    {    
	    	String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	    	return loader;   	
	    }
	    
	    @FindBy(xpath = "//div[contains(@class,'value-container')]")
		@CacheLookup
		public WebElement dropdown;
	    
	    @FindBy(xpath = "//input[@type='text'][@aria-autocomplete='list']")
	  		@CacheLookup
	  		public WebElement dropdownInput;
	    
	    @FindBy(xpath = "//button[text()='Save']")
	  		@CacheLookup
	  	public WebElement saveButton;
	    
	    		
		@FindBy(xpath = "//div[@class='notification-message']")
		@CacheLookup
		public WebElement notificationMessage;
		
		@FindBy(xpath = "//h1[text()='Warning']")
		@CacheLookup
		public WebElement warning;
			    
		
		@FindBy(xpath = "//button[text()='Cancel']")
		@CacheLookup
		public List<WebElement> Cancel;
		
	    public void selectProjectName() throws Exception
	    {
	    	Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			logExtentReport("Selected project ");	
	    }
	    
	    
	    public WebElement projectLinkIcon(String projectName) throws Exception
	    {
	    	WebElement ele = findElement("//span[text()='"+projectName+"']/ancestor::h2/span[contains(@class,'project-link-icon')]", driver);
	    	return ele;
	    }
	    
	    public WebElement deassociateIcon(String projectName) throws Exception
	    {
	    	WebElement ele = findElement("//div[text()='"+projectName+"']/ancestor::div/div[contains(@class,'multi-value__remove')]", driver);
	    	return ele;
	    }
	    
	    public WebElement referencedFlowName(String currentFlow, String referecedFlow) throws Exception
	    {
	    	WebElement ele = findElement("//span[text()='"+currentFlow+"']/ancestor::div/following-sibling::div/span[text()='"+referecedFlow+"']", driver);
	    	return ele;
	    }
	    
}
