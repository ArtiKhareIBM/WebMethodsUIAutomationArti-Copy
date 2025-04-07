package com.webMethodsUI.flow.pageObjects.onpremIS;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webMethodsUI.flow.testbase.CommonActions;

public class WebMethodsCloud extends CommonActions
{
	public WebMethodsCloud(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("WebMethodsCloud page object created");
	}
	
	
	@FindBy(xpath = "//a[text()='Create Tenant Connection']")
	WebElement createTenantConnection;
	
	@FindBy(xpath = "//a[text()='Create On-Premise Account']")
	WebElement createOnpremiseAccount;
	
	@FindBy(xpath = "//a[text()='Define webMethods Cloud Application']")
	WebElement defineCloudApplication;
	
	@FindBy(xpath = "//span[text()='webMethods Cloud']")
	WebElement webmethodsCloud;
	
	@FindBy(xpath = "//span[text()='Accounts']")
	WebElement accounts;
	
	@FindBy(xpath = "//span[text()='Applications']")
	WebElement applications;
	
	@FindBy(xpath = "//span[text()='Docker services']")
	WebElement DockerService;
	
	@FindBy(xpath = "//i[contains(@class,'side-panel-collapse-icon')]")
	WebElement sidepanelCollapse;
	
	public void createTenantConnection(String alias, String username,String password,String TenantUrl,String keystoreName) throws Exception
	{
		driver.navigate().refresh();
		click(webmethodsCloud, driver, "Click on webMethods Cloud link");
		driver.switchTo().frame("sagDSPFrame");
		click(createTenantConnection,driver,"Click on create tenant connection link");
		WebElement aliasName = findElementByID("alias", driver);
		enterValue(aliasName,alias,driver,"Entering alias name : " +alias);
	    WebElement uname = findElementByID("username", driver);
	    enterValue(uname,username,driver,"Entering username "+username);
	    WebElement pwd = findElementByID("password", driver);
	    enterValue(pwd,password,driver,"Entering pasword  ");
	    WebElement url = findElementByID("iliveURL", driver);
	    enterValue(url,TenantUrl,driver,"Entering TenantUrl  "+TenantUrl);
	    WebElement disable = findElementByID("isEnabled2", driver);
	    click(disable,driver,"selecting enable as no");
	    WebElement UpdateSettings = findElement("//input[@name='submit']", driver);
	    doubleClick(UpdateSettings,driver,"Clicking on Update Settings button");
	 	WebElement message = findElement("//p[@class='message']", driver);
	    elementContainsText(message,"Tenant connection(s) saved successfully.",driver,"verify tenant connection saved message is visible");
	    WebElement enable = findElement("//a[contains(@href,'theAction=enable')][contains(@href,'alias=UIautomationTenant')]", driver);
	    click(enable,driver,"enable tenant connection");
	    message = findElement("//p[@class='message']", driver);
	    elementContainsText(message,"Tenant connection is enabled.",driver,"verify tenant connection enabled message is visible");

	}
	
	public void updateTenantConnectionWithKeystore(String tenantNAME,String TenantUrl,String keystoreName) throws Exception
	{
		driver.navigate().refresh();
		WebElement tenant = findElement("//span[text()='Tenant connections']", driver);
		click(tenant, driver, "Click on tenant connections link");
		driver.switchTo().frame("sagDSPFrame");
		WebElement tenantAlias = findElement("//a[contains(@onclick,'editTenant') and contains(@onclick,'"+tenantNAME+"')]", driver);
		click(tenantAlias,driver,"Clicking on "+tenantNAME+" LINK");
		 WebElement url = findElementByID("iliveURL", driver);
		clearAndEnterText(url,TenantUrl+":8443",driver,"Entering TenantUrl  "+TenantUrl);
	    WebElement dropdown = findElementByID("keyStoreAlias", driver);
	    selectValueFromDropDown(dropdown,keystoreName,driver,"Select keystore from dropdown");
	    WebElement keyalias = findElement("//select[@id='keyAlias']/option", driver);
	    TenantUrl = TenantUrl.substring(8);
	    elementContainsText(keyalias,TenantUrl,driver,"verify KeyAlias URL is selected");
	    WebElement disable = findElementByID("isEnabled2", driver);
	    click(disable,driver,"selecting enable as no");
	    WebElement UpdateSettings = findElement("//input[@name='submit']", driver);
	    doubleClick(UpdateSettings,driver,"Clicking on Update Settings button");
	 	WebElement message = findElement("//p[@class='message']", driver);
	    elementContainsText(message,"Tenant connection(s) saved successfully.",driver,"verify tenant connection saved message is visible");
	    WebElement enable = findElement("//a[contains(@href,'theAction=enable')][contains(@href,'alias=UIautomationTenant')]", driver);
	    click(enable,driver,"enable tenant connection");
	    message = findElement("//p[@class='message']", driver);
	    elementContainsText(message,"Tenant connection is enabled.",driver,"verify tenant connection enabled message is visible");

	}
	
	public void createAccount(String alias,String tenantAlias,String user) throws Exception
	{
		driver.navigate().refresh();
		WebElement accounts = findElement("//span[text()='Accounts']", driver);
		click(accounts, driver, "Click on accounts link");
		driver.switchTo().frame("sagDSPFrame");
		click(createOnpremiseAccount,driver,"Click on create onpremise-account link");
		WebElement aliasName = findElementByID("aliasName", driver);
		enterValue(aliasName,alias,driver,"Entering alias name : " +alias);
		WebElement dropdown = findElementByID("tenantAlias", driver);
		selectValueFromDropDown(dropdown,tenantAlias,driver,"Select tenantAlias from dropdown");
	    WebElement runAsUser = findElementByID("runAsUser", driver);
	    enterValue(runAsUser,user,driver,"Entering Run As User "+user);    
	    WebElement TestAccountSettings = findElement("//input[@value='Test Account Settings']", driver);
	    click(TestAccountSettings,driver,"Clicking on Test Account Settings button");
	 	WebElement message = findElement("//*[@class='message']", driver);
	    elementContainsText(message,"The account "+alias+" is valid.",driver,"verify account valid message is visible");
	    WebElement saveChanges = findElement("//input[@value='Save Changes']", driver);
	    click(saveChanges,driver,"Clicking on save Changes button");
	    message = findElement("//*[@class='message']", driver);
	    elementContainsText(message,"Created account "+alias+" successfully.",driver,"verify account created message is visible");

	}
	
	public void TestOnpremeAccountWithKeystore(String alias,String tenantAlias) throws Exception
	{
		driver.navigate().refresh();
		WebElement accounts = findElement("//span[text()='Accounts']", driver);
		click(accounts, driver, "Click on accounts link");
		driver.switchTo().frame("sagDSPFrame");
		WebElement disableAccount = findElement("//a[contains(@href,'action=disable&tenantAlias="+tenantAlias+"&aliasName="+alias+"')]", driver);		
		click(disableAccount,driver,"Click on disableAccount link");
		WebElement message = findElement("//*[@class='message']", driver);
		elementContainsText(message,"Disabled account "+alias+".",driver,"verify account disabled message is visible");
		WebElement enableAccount = findElement("//a[contains(@href,'action=enable&tenantAlias="+tenantAlias+"&aliasName="+alias+"')]", driver);		
		click(enableAccount,driver,"Click on enableAccount link");
		message = findElement("//*[@class='message']", driver);
		elementContainsText(message,"Enabled account "+alias+".",driver,"verify account disabled message is visible");

	}
	
	public void clickOnApplications() throws Exception
	{
		driver.navigate().refresh();
		Thread.sleep(5000);
		scrollPageToElement(driver,DockerService);
		scrollPageDown2(driver,80);
		new WebMethodsCloud(driver);
		
		if(!isElementDisplayed(sidepanelCollapse,driver,"Verify collapse icon is displayed or not"))
		{
			WebElement ele = findElement("//i[contains(@class,'side-panel-expand-icon')]", driver);
			click(ele, driver, "Click side panel expand icon");
		}
		else
		   click(applications, driver, "Click on applications link");
	}
	
	public void createCloudApplication(String appname,String description,String pkgName, String serviceName) throws Exception
	{
		clickOnApplications();
		driver.switchTo().frame("sagDSPFrame");
		click(defineCloudApplication,driver,"Click on defineCloudApplication link");
		WebElement appName = findElementByID("applicationName", driver);
		enterValue(appName,appname,driver,"Entering application name : " +appname);
		WebElement des = findElementByID("description", driver);
		enterValue(des,description,driver,"Entering description  " +description);
		WebElement pkg = findElementByID("img"+pkgName, driver);
		click(pkg,driver,"Expand Package " +pkgName);
		Thread.sleep(2000);
		WebElement service = findElement("(//input[@value='"+serviceName+"'])[1]", driver);
		click(service,driver,"Select Service " +serviceName);
	    WebElement saveChanges = findElement("//input[@value='Save Changes']", driver);
	    click(saveChanges,driver,"Clicking on save Changes button");
	    WebElement message = findElement("//*[@class='message']", driver);
	    elementContainsText(message,"Application "+appname+" saved successfully.",driver,"verify application saved message is visible");

	}
	
//	public void uploadAccount(String tenantAlias,String accountAlias) throws Exception
//	{
//		WebElement uploadButton = findElement("//a[contains(@onclick,'confirmUpload') and contains(@onclick,'"+accountAlias+"')]", driver);
//		click(uploadButton,driver,"Clicking on "+accountAlias+" uploadbutton");
//	    Alert alt = driver.switchTo().alert();
//		alt.accept();
//	    WebElement message = findElement("//*[@class='message']", driver);
//	    Thread.sleep(10000);
//	    elementContainsText(message,"Account information for "+accountAlias+" uploaded successfully on stage Development.",driver,"verify account uploaded message is visible");
//	}
	
	public void uploadApp(String appname,String tenantAlias,String accountAlias) throws Exception
	{
		WebElement uploadButton = findElement("//a[contains(@onclick,'uploadApplication') and contains(@onclick,'"+appname+"')]", driver);
		click(uploadButton,driver,"Clicking on "+appname+" uploadbutton");
		selectAccAndTenant(tenantAlias,accountAlias);
		logExtentReport("Clicking on Upload button");
	    WebElement UploadButton = findElement("//input[@value='Upload']", driver);
	    UploadButton.click();
	    Alert alt = driver.switchTo().alert();
		alt.accept();
		getNavigationScreen(driver);
	    WebElement message = findElement("//*[@class='message']", driver);
	    Thread.sleep(10000);
	    elementContainsText(message,"Application "+appname+" was uploaded successfully to all selected tenants.",driver,"verify application uploaded message is visible");

	}
	
	public void selectAccAndTenant(String tenantAlias,String accountAlias) throws Exception
	{
		WebElement account = findElement("//input[contains(@value,'"+tenantAlias+"/"+accountAlias+"')]", driver);
		click(account,driver,"Select account checkbox " +accountAlias);
	}
	
	public void ReuploadSameApp(String appname,String tenantAlias,String accountAlias) throws Exception
	{
		WebElement uploadButton = findElement("//a[contains(@onclick,'uploadApplication') and contains(@onclick,'"+appname+"')]", driver);
		click(uploadButton,driver,"Clicking on "+appname+" uploadbutton");
		logExtentReport("Clicking on Upload button");
	    WebElement UploadButton = findElement("//input[@value='Upload']", driver);
	    UploadButton.click();
	    Alert alt = driver.switchTo().alert();
		alt.accept();
		getNavigationScreen(driver);
	    WebElement message = findElement("//*[@class='message']", driver);
	    elementContainsText(message,"Application "+appname+" was uploaded successfully to all selected tenants.",driver,"verify application uploaded message is visible");

	}
	
	public void deleteApp(String appname) throws Exception
	{
		logExtentReport("Clicking on WebMethods Cloud Link");
		WebElement webmethoudsCloud = findElement("//span[text()='webMethods Cloud']", driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webmethoudsCloud);
		click(applications, driver, "Click on applications link");
		driver.switchTo().frame("sagDSPFrame");
		logExtentReport("Clicking on delete application button");
		WebElement deleteButton = findElement("//a[contains(@onclick,'removeApplication') and contains(@onclick,'"+appname+"')]", driver);
		deleteButton.click();
		 Alert alt = driver.switchTo().alert();
	     alt.accept();
		 getNavigationScreen(driver);
	}
	
	public void deleteAccount(String accName) throws Exception
	{
		driver.navigate().refresh();
		WebElement accounts = findElement("//span[text()='Accounts']", driver);
		click(accounts, driver, "Click on accounts link");
		driver.switchTo().frame("sagDSPFrame");
		logExtentReport("Clicking on delete account button");
		WebElement deleteButton = findElement("//img[contains(@alt,'Delete alias "+accName+"')]", driver);
		deleteButton.click();
		Alert alt = driver.switchTo().alert();
	    alt.accept();
		getNavigationScreen(driver);
	}
	
	public void deleteTenant(String tenantName) throws Exception
	{
		driver.navigate().refresh();
		WebElement tenant = findElement("//span[text()='Tenant connections']", driver);
		click(tenant, driver, "Click on tenant connections link");
		driver.switchTo().frame("sagDSPFrame");
		logExtentReport("Clicking on delete tenant connection button");
		WebElement deleteButton = findElement("//img[contains(@alt,'Delete alias "+tenantName+"')]", driver);
		deleteButton.click();
		Alert alt = driver.switchTo().alert();
	    alt.accept();
		getNavigationScreen(driver);
	}
	
	public void logout() throws Exception
	{
		driver.navigate().refresh();
		WebElement PROFILE = findElementByID("profile-link", driver);
		click(PROFILE, driver, "Click on PROFILE link");
		WebElement logout = findElementByID("logout", driver);
		click(logout, driver, "Click on logout link");
		
	}
	 
}
