package com.webMethodsUI.flow.pageObjects.onpremIS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class KeystorePage extends CommonActions
{
	private WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Security']")
	@CacheLookup
	WebElement SecurityLink;
	
	@FindBy(xpath = "//span[text()='Keystore']")
	WebElement KeystoreLink;
	
	public KeystorePage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("Keystore page object created");
	}
	  
	public void expandSecurityMenu() throws Exception 
	{
//		Thread.sleep(5000);
//		scrollPageDown2(driver,15);
//		WebElement expand = findElement("//span[text()='Security']", driver);
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", expand);
		click(SecurityLink,driver,"Expand security Link");
	}
	 
	public void selectKeystore(String passwordValue) throws Exception
	{
//		WebElement ele = findElement("//span[text()='Keystore']", driver);
//		scrollPageDown2(driver,15); 
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", ele);
		click(KeystoreLink,driver,"Click on keystore Link");
	}
	
	@FindBy(xpath = "//a[text()='Create Keystore Alias']")
	WebElement createKeyStoreAlias;
	
	public void createKeystoreAlias(String KSName, String path) throws Exception
	{
		logExtentReport("Click on Security link");
		WebElement expand = findElement("//span[text()='Security']", driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", expand);
		scrollPageDown2(driver,20);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", KeystoreLink);
		driver.switchTo().frame("sagDSPFrame");
		click(createKeyStoreAlias,driver,"Click on create keystore link");
//		driver.get("http://localhost:5555/WmRoot/security-keystoremgt-keystore.dsp?type=key&mode=add&webMethods-wM-AdminUI=true");
		WebElement ksname = findElementByID("ksname", driver);
		enterValue(ksname,KSName,driver,"Entering alias name : " +KSName);
	    String filePath = ResourceHelper.getResourcePath(path);
	    WebElement Location = findElementByID("loc", driver);
	    enterValue(Location,filePath,driver,"Entering Keystore Location "+filePath);
	    WebElement password = findElement("//input[@name='keyStorePassword']", driver);
	    enterValue(password,"changeit",driver,"Entering pasword  ");
	    WebElement retypepassword = findElement("//input[@name='retype_keyStorePassword']", driver);
	    enterValue(retypepassword,"changeit",driver,"ReEntering Password ");
	    WebElement submit = findElement("//input[@value='Submit']", driver);
	    click(submit,driver,"Clicking on submit button");
	    WebElement pwd = findElement("//input[@name='pkPasswords']", driver);
	    enterValue(pwd,"changeit",driver,"Entering Password");
	    WebElement rpwd = findElementByID("rpwd", driver);
	    enterValue(rpwd,"changeit",driver,"Re Entering Password ");
	    WebElement saveChanges = findElement("//input[@value='Save Changes']", driver);
	    click(saveChanges,driver,"Clicking on save Changes button");
	    WebElement message = findElement("//*[@class='message']", driver);
	    elementContainsText(message,"Keystore alias 'UIautomationKeystore' saved successfully.",driver,"verify keystore created message is visible");

	}
	
	public void deleteKeystore(String keystoreName) throws Exception
	{
		driver.navigate().refresh();
		logExtentReport("Click on Security link");
		WebElement expand = findElement("//span[text()='Security']", driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", expand);
		scrollPageDown2(driver,20);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", KeystoreLink);
		driver.switchTo().frame("sagDSPFrame");
		logExtentReport("Clicking on delete keystore button");
		WebElement deleteButton = findElement("//a[contains(@onclick,'deleteKeyStore') and contains(@onclick,'"+keystoreName+"')]", driver);
		deleteButton.click();
		 Alert alt = driver.switchTo().alert();
	     alt.accept();
		 getNavigationScreen(driver);

	}
	

}
