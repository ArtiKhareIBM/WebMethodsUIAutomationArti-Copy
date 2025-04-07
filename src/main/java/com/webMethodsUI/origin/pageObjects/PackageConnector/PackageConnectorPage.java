package com.webMethodsUI.origin.pageObjects.PackageConnector;

import com.webMethodsUI.flow.pageObjects.restapi.RestApiHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class PackageConnectorPage extends CommonActions{
	private WebDriver driver;
	private Logger log = LogManager.getLogger(PackageConnectorPage.class);
	WaitHelper waitHelper;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public PackageConnectorPage(WebDriver driver) {
		super();
		this.driver = driver;
		logExtentReport("PackageConnector page created");
	}
	public void clickOnButton(String buttonname) throws Exception {
		WebElement element = findElement("//button[contains(text(),'" +buttonname+ "')]", driver);
		waitForElementVisible(element,driver,"wait for button to load:");
		click(element,driver,"Click on button" +buttonname);
	}
	public void AddGitAccount() throws Exception {
		WebElement element = findElement("//h2[contains(text(),'GIT')]", driver);
		waitForElementVisible(element,driver,"wait for page to load:");
		click(element,driver,"clicking on add git account");
	}
	
	public void selectSourceControl(String name) throws Exception {

		try {
			WebElement eledata = findElement("//button[normalize-space(text())='Next']", driver);
			if (!eledata.isEnabled()) {

				logExtentReport("By default account did'nt get selected");
				log.info("By default account did'nt get selected");
				WebElement ele = findElement("//div[contains(text(),'Select an existing git account')]", driver);
				click(ele, driver, "Click on source control dropdown");
				WebElement ele3 = findElement("//input[@id='react-select-3-input']", driver);
				enterValue(ele3, name, driver, "Enter the account " + name);
				WebElement ele34 = findElement(" //div[@class='select2-common__menu-list css-11unzgr']/div[contains(text(),'" + name + "')]", driver);
				click(ele34, driver, name);
			}
			else {
				logExtentReport("already account  seletced");
				log.info("already account  seletced");
			}
		}

		catch(NoSuchElementException e){
				// TODO Auto-generated catch block
				//e.printStackTrace();
			  selectaccount();

			}

		catch(TimeoutException e){
			// TODO Auto-generated catch block
			//e.printStackTrace();
			selectaccount();

		}

	}

	public void selectaccount() throws Exception{

		logExtentReport("By default account get selected");
		log.info("By default account  get selected");

	}


	public void enterGitUrl(String giturl) throws Exception 
	{
		WebElement element = findElement("//input[@placeholder='Enter git URL']",driver);
		waitForElementVisible(element,driver,"wait for page to load:");
		enterValue2(element,giturl,driver,"Entering GIT URl: " +giturl);	
	}

	public void VerifyLebelIsVisible(String lebelname) throws Exception {
		WebElement element = findElement("//div[contains(text(),'" +lebelname+ "')]",driver);
		waitForElementVisible(element,driver,"Verify vissible level is: " +lebelname);
	}
	public void clickOnDownIcon() throws Exception {
		WebElement element = findElement("//span[@class='delite-icon dlt-icon-chevron-down icon-chevron-down']", driver);
		click(element,driver,"Click on connector details button");
	}
	public void VerifyLebels(String labelname) throws Exception {
		WebElement element = findElement("//div[contains(text(),'"+labelname+"')]",driver);
		waitForElementVisible(element,driver,"Verify vissible level is: " +labelname);
	}
	public void clickOnFilterIcon() throws Exception {
		WebElement element = findElement("//button[normalize-space()='Filters']", driver);
		click(element,driver,"Click on connector details button");
	}
	public void VerifyDisabledButton(String buttonname) throws Exception {
		WebElement element = findElement("//button[contains(text(),'"+buttonname+"')]", driver);
		isElementDisabled(element,driver,"disbaled button is :"+buttonname);
	}
	
	public void closeaccountConfigPage() throws Exception {
		WebElement  ele = findElement("//button[@class='btn dlt-button-secondary btn-secondary']", driver);
		click(ele, driver, "Click on close button");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visble");
	}
	public void ClickOnDropdown(String lebelname) throws Exception {
		WebElement element = findElement("//div[contains(text(),'" +lebelname+ "')]",driver);
		click(element,driver,"click on filter :" +lebelname);
	}
	public void SelectLabelFromDropDown(String lebelname) throws Exception {
		WebElement element = findElement("//div[@id='"+lebelname+"']",driver);
		click(element,driver,"select from dropdown filter :" +lebelname);
	}
	public void RemovePackages(String packageName) throws Exception {
		WebElement element = findElement("//span[normalize-space()='"+packageName+"']/ancestor::tr[@class='packages-table-row ']//span[@title='Remove package']",driver);
		click(element,driver,"Removing the added packages :");
	}
	public void validateElementNotVisible() throws Exception{
		String element = "//span[contains(text(),'AbhiPackages')]";
		waitForElementNotVisible(element, driver, "wait for page load, packages should not be visible");
		
	}
	public void VerifyLebel(String lebelname) throws Exception {
		WebElement element = findElement("//div[contains(text(),'" +lebelname+ "')]",driver);
		click(element,driver,"click on filter :" +lebelname);
	}
	
	public void verifylabels1(String name) throws Exception {
		WebElement ele = findElement("//span[@title='"+name+"']", driver);
		waitForElementVisible(ele,driver,"Verify vissible level is: " +name);
	}
	public void clickManageRuntime() throws Exception {
		WebElement element = findElement("//a[contains(text(),'Manage runtimes')]",driver);
		click(element,driver,"Clicking on Manage Runtime");
	}
	public void VerifyElementVisible(String labelname) throws Exception {
		WebElement element = findElement("//span[contains(text(),'"+labelname+"')]",driver);
		waitForElementVisible(element,driver,"Verify vissible level is: " +labelname);
	}
	public void SelectRuntime(String Runtime) throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement element = findElement("//span[contains(text(),'"+Runtime+"')]",driver);
		click(element,driver,"Selecting Cloud Runtime");
	}
	public void ClickOnIcon(String Runtime) throws Exception {
		WebElement element = findElement("//span[normalize-space()='"+Runtime+"']/ancestor::div[@class='runtimes-item row']//i[@title='Edit configurations']",driver);
		click(element,driver,"click on icon: " +Runtime);
	}
	
	public void ClickOnIcon1(String Runtime) throws Exception {
		WebElement element = findElement("//span[normalize-space()='"+Runtime+"']/ancestor::div[@class='runtimes-item row']//i[@title='Remove connection']",driver);
		click(element,driver,"click on icon: " +Runtime);
	}
	public void enterUserName(String username) throws Exception 
	{
		WebElement element = findElement("//input[@id='cloudstreamsconnection.AbhiPackages.Abhi_conn:Abhi_conn.connectionconfiguration.cr..username']",driver);
		waitForElementVisible(element,driver,"wait for page to load:");
		enterValue(element,username,driver,"Entering GIT URl: " +username);	
	}
	public void enterPassword(String password) throws Exception 
	{
		WebElement element = findElement("//input[@id='cloudstreamsconnection.AbhiPackages.Abhi_conn:Abhi_conn.connectionconfiguration.cr..password']",driver);
		waitForElementVisible(element,driver,"wait for page to load:");
		enterValue(element,password,driver,"Entering GIT URl: " +password);	
	}

}
