package com.webMethodsUI.flow.pageObjects.common;

import com.webMethodsUI.flow.pageObjects.RecipesPage.recipesWorkflowAndFlowServicepage;
import com.webMethodsUI.flow.pageObjects.monitor.Dashboardpage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class NavigationMenu extends CommonActions{
	private WebDriver driver;

	WaitHelper waitHelper;


	@FindBy(xpath = "//a[@title='webMethods.io Integration']")
	@CacheLookup
	WebElement homeLogo;
	
	@FindBy(xpath = "//i[@class = 'delite-icon dlt-icon-app-switcher']")
	@CacheLookup
	WebElement appSwitcher;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public NavigationMenu(WebDriver driver) {
		super();
		this.driver = driver;

		logExtentReport("Navigation Menu Object created");
	}

	public void clickOnMainMenu(String menuName) throws Exception 
	{
		WebElement element = findElement("//a[contains(text(),'" + menuName + "')]",driver);
		click(element,driver,"Clicking on Menu..." + menuName);
	}

	public void clickOnSubMenu(String subMenu) throws Exception 
	{
		WebElement element = findElement("//div[@class='tab-details']/ul/li/a/span[contains(text(),'"+subMenu+"')]",driver);
		click(element,driver,"Clicking on subMenu..." + subMenu);
	}
	
	public void clickOnSubMenu1(String subMenu) throws Exception {
			WebElement element = findElement("//div[@class='dashboard-left-side']/ul/li/a[contains(text(),'"+subMenu+"')]",driver);
			click(element,driver,"Clicking on Sub  Menu....... " + subMenu);
	}
	
	public void clickOnSubMenu2(String subMenu2) throws Exception 
	{
		WebElement element = findElement("//div[@class='tab-details']/ul/li/a/span[contains(text(),'" + subMenu2 + "')]",driver);
		click(element,driver,"Click ON SUbMEnu.. "+subMenu2);
	}

	public void clickOnTreeMainMenu(String treeMainMenu) throws Exception 
	{
		WebElement element = findElement("//span[contains(text(),'" + treeMainMenu + "')]",driver);
		click(element,driver,"Clicking on Tree Main Menu " + treeMainMenu);
	}
	
     public void clickOnTreeMainTab(String treeMainMenu) throws Exception {
		WebElement element = findElement("//a[contains(text(),'" + treeMainMenu + "')]",driver);
		click(element,driver,"Clicking on Tree Main Menu " + treeMainMenu);
	}

	public void clickOnTreeSubMenu(String subMenu) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + subMenu + "')]"));
		click(element,driver,"Clicking on subMenu..." + subMenu);
	}

	public void clickOnLeftPanalMainMenu(String mainMenu) throws Exception 
	{
		WebElement element = findElement("//a[contains(text(),'" + mainMenu + "')]",driver);
		click(element,driver,"Clicking on Left Panal MainMenu...." + mainMenu);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public void clickNext() throws Exception 
	{
		WebElement element = findElement("//button[contains(text(),'Next')]",driver);
		click(element,driver,"Clicking on Button.. " +element);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}

	public HomePage clickOnHomePage() throws Exception 
	{
		WebElement ele = findElement("//a[@title='webMethods.io Integration']", driver);
			doubleClick(ele,driver,"Clicking on homeLogo.. ");
			waitForElementNotVisible(loader, driver, "wait for page load");
			WebElement ele1 = findElement("//a[contains(text(),'Projects')]", driver);
			waitForElementVisible(ele1,driver,"Verify project menu is visible");
		return new HomePage(driver);
	}

	public Dashboardpage clickOnMonitorePage() throws Exception 
	{
			WebElement element = findElement("//a[contains(text(),'Monitor')]",driver);
			doubleClick(element, driver, "Clicking on Monitor Tab");
			WebElement element1 = findElement("//a[contains(text(),'Projects')]",driver);
			waitForElementVisible(element1,driver,"Verify project menu is visible");
			waitForElementNotVisible(loader, driver, "wait for page load");
		return new Dashboardpage(driver);
	}

	public void clickonSubmenutillclickable(String subMenu) throws Exception{
		
			WebElement element = findElement("//div[@class='tab-details']/ul/li/a/span[contains(text(),'" + subMenu + "')]",driver);
			click(element,driver,"Clicking on Sub  Menu....... " + subMenu);
	}

	public void clickOnAppSwitcherMenu() throws Exception
	{
		WebElement element = findElement("//i[@class = 'delite-icon dlt-icon-app-switcher']",driver);
		click(element,driver,"Clicking on AppSwitcherMenu");
	}
	
	public void clickOnMyCloudIcon() throws Exception 
	{
		WebElement element = findElement("//span[contains(text(),'Mycloud')]",driver);
		click(element,driver,"Clicking on AppSwitcherMenu");
	}

	public recipesWorkflowAndFlowServicepage clickOnRecipePage() throws Exception
	{
			WebElement element = findElement("//a[contains(text(),'Recipes')]",driver);
			doubleClick(element, driver, "Clicking on Recipes Tab");
			WebElement ele = findElement("//a[contains(text(),'Projects')]", driver);
			waitForElementVisible(ele,driver,"Verify project menu is visible");
			return new recipesWorkflowAndFlowServicepage(driver);
	}
}
