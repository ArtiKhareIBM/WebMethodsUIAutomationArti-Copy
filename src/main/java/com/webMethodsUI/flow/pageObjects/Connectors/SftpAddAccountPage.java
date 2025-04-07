package com.webMethodsUI.flow.pageObjects.Connectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class SftpAddAccountPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(SftpAddAccountPage.class);
	WaitHelper waitHelper;
	WebElement element;

	@FindBy(xpath = "//h4[@class='modal-title float-left']")
	@CacheLookup
	WebElement AddAccountTitle;
	
	@FindBy(xpath = "//textarea[@name='description']")
	@CacheLookup
	WebElement accountdescriptin;
	
	@FindBy(xpath = "//input[@name='name']")
	@CacheLookup
	WebElement sftpv2accountname;
	
	@FindBy(xpath = "//input[@name='userName']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//input[@name='hostName']")
	@CacheLookup
	WebElement HostName;
	
	@FindBy(xpath = "//input[@name='port']")
	@CacheLookup
	WebElement PortNumber;
	
	@FindBy(xpath = "//input[@name='passPhrase']")
	@CacheLookup
	WebElement Passphrasetxt;
	
	@FindBy(xpath = "//input[@name='privateKeyBytes']")
	@CacheLookup
	WebElement pvkeyfilebutton;
	
	@FindBy(xpath = "//input[@name='hostKeyBytes']")
	@CacheLookup
	WebElement pbkeyfilebutton;
	
	@FindBy(xpath = "//button[@class='dlt-button dlt-button-primary sm-button ut-button ng-star-inserted']")
	@CacheLookup
	WebElement addButton;
	
	@FindBy(xpath = "//li[@class,'action-item action-save ng-star-inserted']")
	@CacheLookup
	WebElement SaveButton;
	
	@FindBy(xpath = "//a[contains(@class,'ut-icon-action-bar_save')]")
	@CacheLookup
	WebElement SaveButton1;
	
	public String FlowSaveLoader = "//div[contains(@class,'ut-page-loader')]//div[@aria-label='Loading']";
	
	public static WebElement notificationMessage;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public SftpAddAccountPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("AddAccount Page  Object created");
		waitForElementVisible(AddAccountTitle,driver,"Verify Add Account is visible");
	}
	 
    public void enterAccountName1(String accountName1) throws Exception
 	{
 		clearAndEnterText(sftpv2accountname,accountName1,driver,"Entering Account Name.. "+ accountName1);
 	}
    
    public void AddAccountDescription(String description) throws Exception
    {
   	 enterValue(accountdescriptin,description,driver,"Entering the Text:  "+description);
    } 
    
    public void enterUserName(String userNametxt) throws Exception 
	{
		enterValue(userName,userNametxt,driver,"Entering user Name: " +userNametxt);	
	}
	
	public void enterPassword(String passwordValue) throws Exception
	{
		enterValue(password,passwordValue,driver,"Entering Password: " +password);
	}
	
	public void enterHostName(String hostname) throws Exception
	{
		enterValue(HostName,hostname,driver,"Entering Password: " +hostname);
	}
	
	public void enterPortNumber(String txtPort) throws Exception
	{
		clearAndEnterText(PortNumber,txtPort,driver,"Entering Password: " +txtPort);
	}
	
	public void clickOnAddButton() throws Exception 
	{	
		click(addButton,driver,"clicked on add button");
		waitForElementNotVisible(loader, driver, "wait for page load");
//		elementContainsText(notificationMessage,"Account saved successfully.",driver,"Verify Account saved successfully message is visible");
//		waitForElementVisible(ProjectsMenu,driver,"Verify ProjectMenu is visible");
	}
	
	public void selectAuthenticationType() throws Exception
	{
//		Select dropdown = new Select(driver.findElement(By.id("designation")));
		Select dropdown = new Select(driver.findElement(By.name("authenticationType")));
		dropdown.selectByVisibleText("publicKey");
	}
	
	public void enterPassphraseText(String Passphrasetext)throws Exception
	{
		enterValue(Passphrasetxt,Passphrasetext,driver,"Entering Password: " +Passphrasetext);
	}
	
	public void selectprivatekeyfile(String path)throws Exception
	{
		click(pvkeyfilebutton,driver,"clicked on Choose File");
		String filePath = ResourceHelper.getResourcePath(path);
		FileUpload fileupload = new FileUpload(driver);
		fileupload.fileUploadUsingInputType(pvkeyfilebutton, filePath);
	} 
	
	
	public void selectHostPublicKey() throws Exception
	{
		Select dropdown = new Select(driver.findElement(By.name("hostPublicKey")));
		dropdown.selectByVisibleText("custom");
	}
	public void selectPublickeyfile(String path)throws Exception
	{
		click(pbkeyfilebutton,driver,"clicked on Choose File");
		String filePath = ResourceHelper.getResourcePath(path);
		FileUpload fileupload = new FileUpload(driver);
		fileupload.fileUploadUsingInputType(pbkeyfilebutton, filePath);
	}
	
	public String verifySuccessfullmsg()throws Exception
	{
		String returnmsg1 = findElement("(//div[@class='field-value ng-star-inserted'])[3]",driver).getText();
		System.out.println(returnmsg1);
		return returnmsg1;
		
	}
	
	public void SaveFlowService() throws Exception
	{
		click(SaveButton,driver,"Clicking on Save Flow Service button");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}	
}