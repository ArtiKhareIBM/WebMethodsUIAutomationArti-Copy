package com.webMethodsUI.flow.pageObjects.Connectors;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class FtpAddAccountPage extends CommonActions {
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(SftpAddAccountPage.class);
	WaitHelper waitHelper;
	WebElement element;
	
	@FindBy(xpath = "//input[@name='cn_user']")
	@CacheLookup
	WebElement ftpusername;
	
	@FindBy(xpath = "//input[@name='cn_password']")
	@CacheLookup
	WebElement ftppassword;
	
	@FindBy(xpath = "//input[@name='cn_host']")
	@CacheLookup
	WebElement ftphost;
	
	@FindBy(xpath = "//input[@name='cn_port']")
	@CacheLookup
	WebElement ftpport;
	
	@FindBy(xpath = "//input[@name='name']")
	@CacheLookup
	WebElement ftpaccountname;
	
	@FindBy(xpath = "//textarea[@name='description']")
	@CacheLookup
	WebElement accountdescriptin;
	
	@FindBy(xpath = "//button[.='Add']")
	@CacheLookup
	WebElement acct_addbutton;
	
	@FindBy(xpath = "//input[@id='step-dropdown-input']")
	@CacheLookup
	List<WebElement> selectOperationDropDownElemnt;
	
	@FindBy(xpath = "//input[@name='cn_userName']")
	@CacheLookup
	WebElement smtpusername;
	
	@FindBy(xpath = "//input[@name='cn_password']")
	@CacheLookup
	WebElement smtppassword;
	
	@FindBy(xpath = "//input[@name='cn_host']")
	@CacheLookup
	WebElement smtphost;
	
	@FindBy(xpath = "//input[@name='cx_from']")
	@CacheLookup
	WebElement smtpFromfield;
	
	@FindBy(xpath = "//input[@name='cx_to']")
	@CacheLookup
	WebElement smtpTofield;
	
	public FtpAddAccountPage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("AddAccount Page  Object created");
	}
	
	public void account_UserName(String userNametext)throws Exception
	{
		enterValue(ftpusername,userNametext,driver,"Entering user Name: " +userNametext);	
	}
	
	public void account_Password(String pwdtext)throws Exception
	{
		enterValue(ftppassword,pwdtext,driver,"Entering pwd : " +pwdtext);	
	}
	
	public void account_Host(String hosttxt)throws Exception
	{
		enterValue(ftphost,hosttxt,driver,"Entering host Name: " +hosttxt);	
	}
	
	public void account_Port(String portNumber)throws Exception
	{
		clearAndEnterText(ftpport,portNumber,driver,"Entering portnumber: " +portNumber);
	}
	
	public void account_Name(String acctName)throws Exception
	{
		clearAndEnterText(ftpaccountname,acctName,driver,"Entering Account Name.. "+ acctName);
	}
	
	public void account_Description(String AcctDescription)throws Exception
	{
		enterValue(accountdescriptin,AcctDescription,driver,"Entering the description:  "+AcctDescription);
	}

	public void addButton()throws Exception
	{
		click(acct_addbutton,driver,"clicked on add button");
	}
	
	public String verifyErrorMsgonWrongCredential()throws Exception
	{
		String error_msg = findElement("(//div[@class='ut-step-error-details']//span[@class='message'])[1]",driver).getText();
		System.out.println(error_msg);
		Assert.assertEquals(error_msg,"Error: Account creation error" );
		return error_msg;
	}
	
	public void getAllOperationList()throws Exception
	{
//		WebElement element = findElement("//i[@title='Show Dropdown']",driver);
//    	element.click();
    	
    	click(selectOperationDropDownElemnt.get(0),driver,"Clicking on select operation dropdown...");
    	Thread.sleep(3000);
//    	WebElement element1 = findElement("//i[@title='Show Dropdown']",driver);
//    	element1.click();
    	
    	String operatn_list = findElement("//div[@class='dropdown-result-list ng-star-inserted']",driver).getText();
    	System.out.println(operatn_list);
	}
	
	public void account_SMTPUserName(String userNametext)throws Exception
	{
		enterValue(smtpusername,userNametext,driver,"Entering user Name: " +userNametext);	
	}
	
	public void account_SMTPPassword(String pwdtext)throws Exception
	{
		enterValue(smtppassword,pwdtext,driver,"Entering pwd : " +pwdtext);	
	}
	
	public void account_SMTPHost(String hosttxt)throws Exception
	{
		enterValue(smtphost,hosttxt,driver,"Entering host Name: " +hosttxt);	
	}
	
	public void account_SMTPFromText(String fromEmail)throws Exception
	{
		clearAndEnterText(smtpFromfield,fromEmail,driver,"Entering the from emailid: " +fromEmail);
	}
	public void account_SMTPToText(String toEmail)throws Exception
	{
		clearAndEnterText(smtpTofield,toEmail,driver,"Entering the To emailid: " +toEmail);
	}
}
