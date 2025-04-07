package com.webMethodsUI.flow.pageObjects.Marketplace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class MarketPlacePage extends CommonActions {
	private WebDriver driver;
	WaitHelper waitHelper;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public MarketPlacePage(WebDriver driver) {
		super();
		this.driver = driver;
		logExtentReport("Marketplace page created");
	}
	public void navigateToAllInstallPage(String submenu) throws Exception {
		WebElement element = findElement("//a[contains(@class, 'connector-store-title')]/span[contains(text(), '"+submenu+"')]", driver);
		click(element, driver, "click on sub menu " +submenu);
	}
	public void clickonViews(String title) throws Exception {
		WebElement element = findElement("//li[@title='"+title+"']", driver);
		click(element, driver, "clicking on view " +title);
	}
	public void validateMarketPlaceDesc() throws Exception {
		WebElement element = findElement("//p[contains(text(), 'Platform for hosting and accessing open-source connectors supported by Software AG and its partners.')]", driver);
		waitForElementVisible(element, driver, "Description is visisble");
	}
	public void validateConnector(String connectorname) throws Exception {
		WebElement element = findElement("//h5[contains(text(),'"+connectorname+"')]", driver);
		waitForElementVisible(element, driver, "connector is visisble with name " +connectorname);
	}
	public void validateConnectorListview(String connectorname) throws Exception {
		WebElement element = findElement("//a[contains(text(),'"+connectorname+"')]", driver);
		waitForElementVisible(element, driver, "connector is visisble with name " +connectorname);
	}
	public void validateConnetorversion() throws Exception {
		WebElement element = findElement("//div[contains(@class,'connector-version-type-info')]/span[contains(text(),'1.0.0')]", driver);
		waitForElementVisible(element, driver, "connector version is visisble");
	}
	public void validateConnetorInstalled() throws Exception {
		WebElement element = findElement("//a[contains(@class,'connector-store-title')]/span[contains(text(),'Installed')]", driver);
		//WebElement element = findElement("//div[contains(@class,'connector-action-wrapper')]/span[contains(text(),'Installed')]", driver);
		waitForElementVisible(element, driver, "connector installed is visible");
	}
	public void validateConnetorVendor() throws Exception {
		WebElement element = findElement("//div[contains(@class,'vendor-info')]/span[contains(text(),'Software AG')]", driver);
		waitForElementVisible(element, driver, "connector vendor SoftwareAg is visible");
	}
	public void validateConnetorDesc(String desc) throws Exception {
		WebElement element = findElement("//*[contains(text(),'"+desc+"')]", driver);
		waitForElementVisible(element, driver, "connector with desc" +desc);
	}
	public void validateConnectordetails(String connetorlevel) throws Exception {
		WebElement element = findElement("//span[contains(text(), '"+connetorlevel+"')]", driver);
		waitForElementVisible(element, driver, "level is visible say "+connetorlevel);
	}
	public void setValueForSearch(String inputValue) throws Exception 
	{	
		WebElement element = findElement("//input[@placeholder='Search']",driver);
		enterValue(element,inputValue,driver,"setting value with...... " +inputValue);
	}
	public void clickSearch() throws Exception {
		WebElement element = findElement("//span[contains(@class,'searchbox-search-icon')]", driver);
		click(element, driver,"clicking on search icon");
	}
	public void ListviewData(String columndata) throws Exception {
		WebElement element = findElement("//div[contains(text(),'"+columndata+"')]", driver);
		waitForElementVisible(element,driver, "table data is visible " +columndata);
	}
	public void clickOnConnector(String connectorname) throws Exception {
		WebElement element = findElement("//h5[contains(text(),'"+connectorname+"')]", driver);
		click(element, driver, "clicking on the connector to go on details sections");
	}
	public void connectordetails(String levels) throws Exception {
		WebElement element = findElement("//*[contains(text(),'"+levels+"')]", driver);
		waitForElementVisible(element,driver, "connector deatils is with level " +levels);
	}
	public void goBackToMarketplace(String goback) throws Exception {
		WebElement element = findElement("//span[@aid='"+goback+"']", driver);
		click(element, driver, "going back to marketplace page");
	}
	public void clickOnLevel(String level) throws Exception 
	{
		WebElement element = findElement("//*[contains(text(),'"+level+"')]", driver);
		click(element, driver, "clicking on level" +level);
	}
}
