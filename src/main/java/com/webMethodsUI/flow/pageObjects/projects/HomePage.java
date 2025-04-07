package com.webMethodsUI.flow.pageObjects.projects;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.pageObjects.Settingpage.ClientCertificateConfigurationpage;
import com.webMethodsUI.flow.pageObjects.Settingpage.ScopemanagementHomepage;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class HomePage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(ScopemanagementHomepage.class);

	@FindBy(xpath = "//*[@class='project-greet']")
	@CacheLookup
	WebElement HomePageGreetMessageDescription;

	@FindBy(xpath = "//span[contains(text(),'Great to have you here')]")
	@CacheLookup
	WebElement ProjectGreetMessageDescriptionElement;

	@FindBy(xpath = "//*[@class='welcome-header-title']")
	@CacheLookup
	WebElement HomePageTitle;

	@FindBy(xpath = "//a[contains(text(),'Projects')]")
	@CacheLookup
	WebElement ProjectsMenu;

	@FindBy(xpath = "//i[@class='wm-int-icon-add']")
	@CacheLookup
	WebElement createProjectPlusButton;

	@FindBy(xpath = "//input[@id='new-project']")
	@CacheLookup
	WebElement ProjectName;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	@CacheLookup
	WebElement createButton;

	@FindBy(xpath = "//div[@class='notification-alert success']")
	@CacheLookup
	WebElement createProjectSuccessMessage;


	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	public static WebElement projectDeleteButtonElement;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public static WebElement notificationMessage;


	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-profile']")
	@CacheLookup
	public static WebElement profileIconElement;


	@FindBy(xpath = "//span[contains(text(),'Log out')]/parent::a[@class='truncate logout']")
	@CacheLookup
	public static WebElement logOutLink;


	@FindBy(xpath = "//span[@class='dlt-icon-chevron-down']")
	@CacheLookup
	public static WebElement Currentelement;


	@FindBy(xpath = "//span[@class='environment-divide']")
	@CacheLookup
	public static WebElement Manageenviromentelement;

	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	@CacheLookup
	public static WebElement settinglink;
	
	@FindBy(xpath = "//span[@class=' delite-icon dlt-icon-search searchbox-search-icon']")
	@CacheLookup
	public static WebElement searchicon;
	
	String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";


	public HomePage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("HomePage  Object created");
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementVisible(HomePageGreetMessageDescription,driver,"Verify Home page greet message is visible");
		waitForElementVisible(createProjectPlusButton,driver,"Verify create project plus button is visible");
	}

//	public String getHomePageGreetMessageDescription() {
//
//		return new VerificationHelper(driver).getText(HomePageGreetMessageDescription);
//	}
//
//	public boolean verifyGreetMessage() {
//		return new VerificationHelper(driver).isDisplayed(HomePageGreetMessageDescription);
//	}
//
//	public boolean verifyHomePageTitle() {
//		return new VerificationHelper(driver).isDisplayed(HomePageTitle);
//	}

	
//	public boolean verifyProjectCreateSuccessMessage() {
//		return new VerificationHelper(driver).isDisplayed(createProjectSuccessMessage);
//	}
//
//	public boolean IsProjectGreetMessageDescriptionDisplayed() {
//		return new VerificationHelper(driver).isDisplayed(ProjectGreetMessageDescriptionElement);
//	}
	
	public void searchProject(String ProjectName) throws Exception
	{
		WebElement searcheElement = driver.findElement(By.xpath("//input[@type='search']"));
		click(searcheElement, driver, "Cicking on search project field");
		enterValue(searcheElement, ProjectName, driver, "Entering project name in search box: "+ProjectName);
		click(searchicon, driver, "Clicking on searchicon to search project");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement element = driver.findElement(By.xpath("//span[contains(@class,'project-name')][contains(text(),'" + ProjectName + "')]"));
		click(element,driver,"Clicking on Project " + element);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	
	public void openProject(String ProjectName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(@class,'project-name')][contains(text(),'" + ProjectName + "')]"));
		click(element,driver,"Clicking on Project " + element);
		waitForElementNotVisible(loader, driver, "wait for page load");
		
	}

	public WorkflowsPage createProject(String projectName) throws Exception 
	{
		click(createProjectPlusButton,driver,"Click on Add Project Button");
		enterValue(this.ProjectName,projectName,driver,"Entering Project Name " +projectName);
		click(createButton,driver,"Click createProject Button");
		elementContainsText(notificationMessage,"Project created successfully.",driver,"Verify project created successfully message is visible");
//		waitForElementNotVisible(loader, driver, "wait for page load");
		return new WorkflowsPage(driver);
	}

	public void deleteProject(String projectNametxt) throws Exception 
	{
			WebElement projectEllipsisElement = driver.findElement(By.xpath("//span[contains(text(),'" + projectNametxt
					+ "')]/parent::h2/../../../following-sibling::div/a[@aid='projectCardMenuBtn']"));
			scrollPageToElement(driver,projectEllipsisElement);
			click(projectEllipsisElement,driver,"Click on projectpanel more menu");
			Thread.sleep(1000);
//			Actions action = new Actions(driver);
//			action.sendKeys(Keys.TAB).perform();
//			action.sendKeys(Keys.TAB).perform();
//			action.sendKeys(Keys.TAB).perform();
//			action.sendKeys(Keys.TAB).perform();
//			action.sendKeys(Keys.ENTER).perform();
			WebElement deleteprojectbtn = driver.findElement(By.xpath("//a[@name='"+projectNametxt+"-delete']"));
//			waitForElementVisible(projectDeleteButtonElement,driver,"Verify project delete button is present");
//			click(projectDeleteButtonElement,driver,"Clicking on delete button");
			Thread.sleep(1000);
			click(deleteprojectbtn,driver,"Clicking on delete button");
			waitForElementVisible(projectDeleteButtonElement,driver,"Verify project delete button is present");
			doubleClick(projectDeleteButtonElement,driver,"Clicking on homeLogo.. ");
			//click(projectDeleteButtonElement,driver,"Clicking on delete button");
			//Thread.sleep(6000);
			waitForElementVisible(notificationMessage,driver,"Verify Project deleted successfully. message is present");
			elementContainsText(notificationMessage,"Project deleted successfully.",driver,"Verify Project deleted successfully. message is present");
			waitForElementNotVisible(loader, driver, "wait for page load",45);
	}
	
	public void associateProject(String projectNametxt) throws Exception 
	{
			WebElement projectEllipsisElement = driver.findElement(By.xpath("//span[text()='" + projectNametxt
					+ "']/parent::h2/../../../following-sibling::div/a[@aid='projectCardMenuBtn']"));
			scrollPageToElement(driver,projectEllipsisElement);
			click(projectEllipsisElement,driver,"Click on projectpanel more menu");
			
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
	}

//	public String getProjectDeleteMessage() throws Exception 
//	{
//
//		elementContainsText(notificationMessage,"Project deleted successfully.",driver,"Verify project deleted successfully message is visible");
//		return notificationMessage.getText();
//	}

//	public void waittillitappears() {
//		WebDriverWait wait = new WebDriverWait(driver, ObjectReader.reader.getExplicitWait());
//		wait.until(ExpectedConditions.not(
//				ExpectedConditions.textToBePresentInElement(notificationMessage, notificationMessage.getText())));
//	}

//	public void clickOnProjectsMenu() {
//		waitHelper.waitForElement(ProjectName, ObjectReader.reader.getExplicitWait());
//		ProjectName.click();
//		waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElement(HomePageGreetMessageDescription, ObjectReader.reader.getExplicitWait());
//		log.info("element is visible now...." + HomePageGreetMessageDescription);
//
//	}
//
//
	public LoginPage logOutApplication() throws Exception 
	{
		click(profileIconElement,driver,"clicking on profine icon....");
		click(logOutLink,driver,"clicking on logout link....");
		return new LoginPage(driver);
	}
//
	public publishprojectpage clickingpublishprojectOption(String projectNametxt) throws Exception
	{
		WebElement projectEllipsisElement = findElement("//span[contains(text(),'" + projectNametxt
					+ "')]/parent::h2/../../../following-sibling::div/a[@aid='projectCardMenuBtn']",driver);
//			projectEllipsisElement.click();
			click(projectEllipsisElement,driver,"clicking on projectEllipsis Element....");
			
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			//action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
			waitForElementNotVisible(loader, driver, "wait for page load");
		return new publishprojectpage(driver);
	}
	
	

	public void ClickDefault() throws Exception
	{
		click(Currentelement,driver,"Clicking on Default link... "+Currentelement);
		click(Manageenviromentelement,driver,"Clicking on Manageenviromentelement link... "+Manageenviromentelement);
		Manageenviromentelement.click();
//		return new ManageEnviromentPage(driver);
	}

	public ClientCertificateConfigurationpage clickSettinglink() throws Exception
	{
		click(profileIconElement,driver,"Clicking profileIconElement");
		click(settinglink,driver,"Clicking settinglink");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new ClientCertificateConfigurationpage(driver);
	}

	public void Clickcurrentenvdropdwn() throws Exception
	{
		click(Currentelement,driver,"Clicking on current environment  "+Currentelement);
		WebElement element = findElement("//a[contains(text(),'"+ObjectReader.reader.GetdeployURL()+"')]",driver);
		click(element,driver,"Clicking on environment .. "+element);
	}


}
