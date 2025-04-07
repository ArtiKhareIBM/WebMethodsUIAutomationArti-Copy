package com.webMethodsUI.flow.pageObjects.projects;

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
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class HomePage extends CommonActions{

	WebDriver driver;

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

	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-plus']")
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
	
	String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";


	public HomePage(WebDriver driver) throws Exception 
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("HomePage  Object created");
		waitForElementVisible(HomePageGreetMessageDescription,driver,"Verify Home page greet message is visible");
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
	
	public void openProject(String ProjectName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + ProjectName + "')]"));
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
			click(projectEllipsisElement,driver,"Click on projectpanel more menu");
			
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();

			waitForElementVisible(projectDeleteButtonElement,driver,"Verify project delete button is present");
			click(projectDeleteButtonElement,driver,"Clicking on delete button");
			elementContainsText(notificationMessage,"Project deleted successfully.",driver,"Verify Project deleted successfully. message is present");
			waitForElementNotVisible(loader, driver, "wait for page load");
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
			projectEllipsisElement.click();
			click(projectEllipsisElement,driver,"clicking on projectEllipsis Element....");
			
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			//action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
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
		return new ClientCertificateConfigurationpage(driver);
	}

	public void Clickcurrentenvdropdwn() throws Exception
	{
		click(Currentelement,driver,"Clicking .. "+Currentelement);
		WebElement element = findElement("//a[contains(text(),'"+ObjectReader.reader.GetdeployURL()+"')]",driver);
		click(element,driver,"Clicking .. "+element);

	}

}
