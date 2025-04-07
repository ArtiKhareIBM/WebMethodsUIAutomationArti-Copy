package com.webMethodsUI.flow.pageObjects.RESTConnector;

import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.helper.window.WindowHelper;
import com.webMethodsUI.flow.pageObjects.flatfile.FlatfileConnectorsHomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;


public class AddAccountPage extends CommonActions{

	WebDriver driver;

	@FindBy(xpath = "//h1[@class='modal-title']")
	@CacheLookup
	WebElement AddAccountModelTitle;

	@FindBy(xpath = "//button[contains(text(),'New Account')]")
	@CacheLookup
	WebElement NewAccountButton;

	@FindBy(xpath = "//input[@name='Response Timeout']")
	@CacheLookup
	WebElement responseTimeout;

        @FindBy(xpath = "//div[@class='cloud-label-content']//div[1]//div[1]//div[1]//div[1]//span[1]//input[1]")
	@CacheLookup
	WebElement portFieldElement;
        
    @FindBy(xpath = "//span[text()='Port Binding']/../..//div[text()='Please Select']")
	@CacheLookup
	WebElement portBindingElement;

	@FindBy(xpath = "//*[text()='Authorization Type']/../div/div/div/div[contains(@class,'singleValue')]")
	@CacheLookup
	WebElement authorizationType;

	@FindBy(xpath = "//input[@name='Username']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@name='Password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//input[@aid='Account Name']")
	@CacheLookup
	WebElement accountNameElement;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	@CacheLookup
	WebElement addButton;

	@FindBy(xpath = "//input[@name='SNI Server Name']")
	@CacheLookup
	WebElement SNIServerNameElement;

	@FindBy(xpath = "//div[11]//div[1]//div[1]//div[1]//span[1]//input[1]")
	@CacheLookup
	WebElement enableSNIDropDownElement;
	
	@FindBy(xpath = "//a[contains(text(),'Projects')]")
	@CacheLookup
	WebElement ProjectsMenu;

    @FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='authConnectionAddNew']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/span[1]/input[1]")
	@CacheLookup  
	WebElement roleuserName;
	
	@FindBy(xpath = "//body/div[@id='activationmesage']/div[@id='authConnectionAddNew']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/span[1]/input[1]")
	@CacheLookup
	WebElement rolepassword;
	
	@FindBy(xpath = "//span[@class='select-label-text' and text()='Refresh URL Request']")
	@CacheLookup
	WebElement RefreshURLRequesttext;
	
	@FindBy(xpath = "//span[@class='material-icons']")
	@CacheLookup
	WebElement refreshtokencallbckservice;

	
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public static WebElement notificationMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	private Logger log = LogManager.getLogger(AddAccountPage.class);
	WaitHelper waitHelper;

	public AddAccountPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("AddAccount Page  Object created");
		waitForElementVisible(AddAccountModelTitle,driver,"Verify AddAccountModelTitle is visible");
	}

	public void clickOnAddAccount(String restConnectorName, String accountName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + restConnectorName + "')]"));	
		click(element,driver,"Clicking on REST connector name " + restConnectorName);
		
		waitForElementVisible(NewAccountButton,driver,"Verify NewAccountButton is visible");
		click(NewAccountButton,driver,"Clicking on REST connector name " + restConnectorName);
	}

	public void enterResponseTimeout(String timeout) throws Exception 
	{
		enterValue(responseTimeout,timeout,driver,"Entering response timeout " +timeout);
	}

	public void selectAuthrizationType(String authType) throws Exception 
	{
		click(authorizationType,driver,"Clicking on authorization Drop Down...." + authorizationType);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + authType + "')]"));
		click(element,driver,"Selecting Auth type...." +authType);
	}

	public void enterUserName(String userNametxt) throws Exception 
	{
		enterValue(userName,userNametxt,driver,"Entering user Name: " +userNametxt);	
	}
	
	public void enterPassword(String passwordValue) throws Exception
	{
		enterValue(password,passwordValue,driver,"Entering Password: " +password);
	}

	public void enterSNIServerName(String SNIserverName) throws Exception 
	{
		enterValue(SNIServerNameElement,SNIserverName,driver,"Entering SNIserverName... " +SNIserverName);
	}

	public void selectEnableSNI(String isSNIEnabled) throws Exception 
	{
		WebElement element = driver.findElement(
				By.xpath("//span[contains(text(),'Enable SNI')]/following-sibling::div/ul/li/ul/li/div[@title='"
						+ isSNIEnabled + "']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(enableSNIDropDownElement).perform();
		actions.moveToElement(enableSNIDropDownElement).click().perform();
		click(element,driver,"Clicking in IS SNI Enabled to ..." + isSNIEnabled);
	}

	public void clickOnAddButton() throws Exception 
	{	
		click(addButton,driver,"clicked on add button");
		waitForElementNotVisible(loader, driver, "wait for page load");
		elementContainsText(notificationMessage,"Account saved successfully.",driver,"Verify Account saved successfully message is visible");
//		waitForElementVisible(ProjectsMenu,driver,"Verify ProjectMenu is visible");
	}

	public String getModelTitle() 
	{
		return AddAccountModelTitle.getText();
	}
	
    public void enterRoleUserName(String userNametxt) throws Exception 
    {	
		enterValue(roleuserName,userNametxt,driver,"Entering user Name: " + userNametxt);
    }
	
	public void enterRolePassword(String password) throws Exception 
	{	
		enterValue(rolepassword,password,driver,"Entering Password: " + password);
	}

     public void selectPortType(String portType) throws Exception 
     {
//			portFieldElement.click();
//			WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + portType + "')]"));
//			click(element,driver,"clicke on portFieldElement button");
    	 
    	 click(portBindingElement, driver, "Click on port binding drop down");
    	 WebElement element = findElement("//div[contains(text(),'" + portType + "')]",driver);
    	 click(element,driver,"Select port binding.."+portType);
	}
     
     public void accountCreatedMessage() throws Exception
     {
    	elementContainsText(notificationMessage,"Account saved successfully.",driver,"Verify Account saved successfully message is visible");

     }
     
     public void enterAccountName(String accountName) throws Exception
 	{
 		clearAndEnterText(accountNameElement,accountName,driver,"Entering Account Name.. "+ accountName);
 	}
     
     public void EnterValue(String FieldName, String Value) throws Exception 
 	{
 		WebElement ele = findElement("//span[text()='"+FieldName+"']/following-sibling::span[text()='*']/../..//input[@aid='"+FieldName+"']", driver);
 		enterValue(ele,Value, driver, "Enter Value for "+FieldName+" : "+Value);	
 	} 
     
     public void VerifyHeaderCustomField() throws Exception 
  	{
  		WebElement ele = findElement("//span[text()='Header']/following-sibling::span[text()='*']/../..//input[@aid='Header']", driver);
  		waitForElementVisible(ele, driver, "Verify header custom field is visible and it is mandatory field");	
  		isElementDisabled(ele, driver, "Verify header input field is disabled");
  	} 
     
     public void VerifyClaimHeaderIsVisible() throws Exception 
   	{
   		WebElement ele = findElement("//span[text()='Claim']/following-sibling::span[text()='*']", driver);
   		waitForElementVisible(ele, driver, "Verify Claim custom field is visible and it is mandatory field");	
   	} 
     
     public void VerifyClaimHeaderDefaultValue() throws Exception 
    	{
    	    WebElement ele = findElement("//span[text()='Claim']/following-sibling::span[text()='*']/../..//div[text()='10']", driver);
    		waitForElementVisible(ele, driver, "Verify default value is delected in claim field");
    	} 
     
     public void VerifyScopeHeaderIsVisible() throws Exception 
    	{
    		WebElement ele = findElement("//span[text()='Scope']/following-sibling::span[text()='*']", driver);
    		waitForElementVisible(ele, driver, "Verify Scope custom field is visible and it is mandatory field");	
    	} 
     
     public void VerifyScopeHeaderDefaultValue() throws Exception 
 	{
 	    WebElement ele = findElement("//span[text()='Scope']/following-sibling::span[text()='*']/../..//div[text()='https://graph.microsoft.com/.default']", driver);
 		waitForElementVisible(ele, driver, "Verify scope value is delected in scope field");
 	} 


     public String VerifyRefreshURLRequesttext_isVisible()throws Exception{
    	 
    	 log.info("element is visible now....");
 		logExtentReport("element is visible now.... and element text is  " +RefreshURLRequesttext.getText());
         return RefreshURLRequesttext.getText();
    	 
     }
     
		public void verifyRefreshURLRequestdropdownelements() throws Exception {
			WebElement drpdown = findElement(
					"//body[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[21]/div[1]/div[1]/div[1]/div[1]/div[1]",
					driver);
			drpdown.click();
			
			List<WebElement> values = findElements("//div[@class='select2-common__menu css-26l3qy-menu']", driver);
//			System.out.println(values.size());
			for (int i = 0; i < values.size(); i++) {
				System.out.println(values.get(i).getText());
				if (values.get(i).getText() == "URL Query String") {
					System.out.println("URL Query String -  is present from the dropdown");
				} else if (values.get(i).getText() == "Body Query String") {
					System.out.println("Body Query String -  is present from the dropdown");
				} else if (values.get(i).getText() == "Refresh token callback service") {
					System.out.println("Refresh token callback service -  is present from the dropdown");
				}
			}
		}
		
		public void EnterConsumerID(String FieldName, String Value)throws Exception
		{
			WebElement consum_id = findElement("//input[@name='"+FieldName+"']", driver);
	 		enterValue(consum_id,Value, driver, "Enter Value for "+FieldName+" : "+Value);
		}
		
		public void enterAccessToken(String FieldName, String Value)throws Exception
		{
			WebElement access_tkn = findElement("//div[@data-react-toolbox='input']/span/descendant::input[@name='"+FieldName+"']", driver);
	 		enterValue(access_tkn,Value, driver, "Enter Value for "+FieldName+" : "+Value);
		}
		
		public void enterRefreshToken(String FieldName, String Value)throws Exception
		{
			WebElement refresh_tkn = findElement("//div[@data-react-toolbox='input']/span/descendant::input[@name='"+FieldName+"']", driver);
	 		enterValue(refresh_tkn,Value, driver, "Enter Value for "+FieldName+" : "+Value);
		}
		
		public void enterRefreshURL(String FieldName, String Value)throws Exception
		{
			WebElement refresh_url = findElement("//div[@data-react-toolbox='input']/span/descendant::input[@name='"+FieldName+"']", driver);
	 		enterValue(refresh_url,Value, driver, "Enter Value for "+FieldName+" : "+Value);
		}
		
		public void createRefreshtokencallbackservice()throws Exception
		{
			click(refreshtokencallbckservice,driver,"clicked on Refresh token callback service plus button");
			Thread.sleep(3000);
		}
		
	}
