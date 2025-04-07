package com.webMethodsUI.flow.VersionControlPageObject;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.Settingpage.Oauthclientregistrationhomepage;
import com.webMethodsUI.flow.testbase.CommonActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VersionControl extends CommonActions {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(Oauthclientregistrationhomepage.class);
	WaitHelper waitHelper;
	public static WebElement notificationMessage;

	public VersionControl(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("version control page created");
	}

	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-profile']")
	@CacheLookup
	WebElement UserProfile;
	
	/*
	 * @FindBy(xpath =
	 * "//span[@data-eventmap='metadata-AccountDetailsDropdown-{\"settings\"}']")
	 * 
	 * @CacheLookup WebElement Settings;
	 */

	@FindBy(xpath = "//a[@title='Settings']")
	@CacheLookup
	WebElement Settings;
	
	@FindBy(xpath = "//span[normalize-space()='Version control']")
	@CacheLookup
	WebElement Version_control;

	@FindBy(xpath = "//button[normalize-space()='+Add']")
	@CacheLookup
	WebElement AddButton;

	@FindBy(xpath = "//input[@id='display-name']")
	@CacheLookup
	WebElement SourceControl;

	@FindBy(xpath = "//input[@id='user-name']")
	@CacheLookup
	WebElement Username;

	@FindBy(xpath = "//div[@class='select2-common__value-container select2-common__value-container--has-value css-1hwfws3']")
	@CacheLookup
	WebElement Dropdown;

	@FindBy(xpath = "//input[@id='host_name']")
	@CacheLookup
	WebElement HostName;

	@FindBy(xpath = "//input[@id='new-token']")
	@CacheLookup
	WebElement PersonalAccessToken;

	@FindBy(xpath = "//button[normalize-space()='Validate']")
	@CacheLookup
	WebElement ValidateToken;

	@FindBy(xpath = "//button[normalize-space()='Update']")
	@CacheLookup
	WebElement UpdateToken;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	@CacheLookup
	WebElement AddVersionControl;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement NotificationMessage;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	@CacheLookup
	WebElement ConfirmDeleteButton;

	@FindBy(xpath = "//div[@class='alert-container']")
	@CacheLookup
	WebElement ConfirmDeleteAlert;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement AlertforIncorrectDetails;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	@CacheLookup
	WebElement Cancel;

	@FindBy(xpath = "//a[normalize-space(text())='Projects']")
	@CacheLookup
	WebElement Projects;

	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-plus']")
	@CacheLookup
	WebElement AddProject;

	@FindBy(xpath = "//input[@id='new-project']")
	@CacheLookup
	WebElement AddProjectName;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	@CacheLookup
	WebElement CreateProjectButton;

	@FindBy(xpath = "//button[normalize-space()='+Add']")
	@CacheLookup
	WebElement AddBUttonOnCreateProjectPopUp;

	public void clickUserProfile() throws Exception {

		logExtentReport("Click User Profile");
		log.info("Click User Profile");
		waitForElementVisible(UserProfile, driver, "wait for button to load:");
		click(UserProfile, driver, "click on User profile..");

	}

	public void clickSettings() throws Exception {

		logExtentReport("Click Settings");
		log.info("Click Settings");
		waitForElementVisible(Settings, driver, "wait for button to load:");
		click(Settings, driver, "click on settings..");

	}

	public void clickVersionControlTab() throws Exception {

		logExtentReport("Click VersionControl Tab");
		log.info("Click VersionControl Tab");
		waitForElementVisible(Version_control, driver, "wait for button to load:");
		click(Version_control, driver, "click on Version Control tab..");

	}

	public void clickAddButtonOnVersionControlPage() throws Exception {

		logExtentReport("click Add Button on in VersionControl Page");
		log.info("click Add Button on in VersionControl Page");
		waitForElementVisible(AddButton, driver, "wait for button to load:");
		click(AddButton, driver, "click on Add Button..");

	}

	public void enterSourceControl(String srcGithubCtrl) throws Exception {

		logExtentReport("Entering Github source control");
		log.info("Entering Github source control");
		enterValue(SourceControl, srcGithubCtrl, driver, "Enter the source control " + srcGithubCtrl);

	}

	public void enterUsername(String username) throws Exception {

		logExtentReport("Entering Username");
		log.info("Entering Username");
		enterValue(Username, username, driver, "Enter the User name " + username);

	}

	public void enterHostName(String hostname) throws Exception {

		logExtentReport("Entering HostName");
		log.info("Entering HostName");
		clearAndEnterText(HostName, hostname, driver, "Entering HostName");

	}

	public void enterPAT(String pat) throws Exception {

		logExtentReport("Entering Personal Access Token");
		log.info("Entering Personal Access Token");
		clearAndEnterText(PersonalAccessToken, pat, driver, "Entering Personal Access Token");

	}

	public void clickValidate() throws Exception {

		logExtentReport("click Validate ...");
		log.info("click Validate ...");
		isElementEnabled(ValidateToken, driver, "click Validate ...");
		click(ValidateToken, driver, "click on Validate Button..");

	}

	public void clickAdd() throws Exception {

		logExtentReport("click Add...");
		log.info("click Add...");
		click(AddVersionControl, driver, "click on Add Version Control Button..");
		waitForElementVisible(NotificationMessage, driver, "click on Add Version Control Button..");

	}
	
	public void clickUpdate() throws Exception {

		logExtentReport("click Update ...");
		log.info("click Update ...");
		isElementEnabled(UpdateToken, driver, "click Update ...");
		click(UpdateToken, driver, "click on Update Button..");
		waitForElementVisible(NotificationMessage, driver, "click on Add Version Control Button..");


	}

	public void verifyAlertMsgforIncorrectDetails() throws Exception {

		logExtentReport("verify Alert Msg for Incorrect Details...");
		log.info("verify Alert Msg for Incorrect Details..");
		waitForElementVisible(AlertforIncorrectDetails, driver, "verify Alert Msg for Incorrect Details");

	}

	public void clickCancel() throws Exception {

		logExtentReport("click Cancel...");
		log.info("click Cancel...");
		isElementEnabled(Cancel, driver, "click Cancel ...");
		click(Cancel, driver, "click Cancel..");

	}

	public void deleteSourceControlFromVersionControl(String srcCtrl) throws Exception {

		logExtentReport("Delete Source Control...");
		log.info("Deleting Source Control...");
		WebElement element = findElement("//span[normalize-space()='" + srcCtrl
				+ "']/ancestor::div[@class='git-account-row row']//a[contains(@title, 'Delete')]", driver);
		click(element, driver, "Removing the added source control :");
		click(ConfirmDeleteButton, driver, "clicking confirm delete button..");
		waitForElementVisible(ConfirmDeleteAlert, driver, "Confirming Source Control delete.. ");
		log.info(" Source Control Deleted...");

	}

	public void editSourceControlFromVersionControl(String srcCtrl) throws Exception {

		logExtentReport("Update Source Control with valid token...");
		log.info("Update Source Control with valid token...");
		WebElement element = findElement("//span[normalize-space()='" + srcCtrl
				+ "']/ancestor::div[@class='git-account-row row']//a[contains(@title, 'Edit')]", driver);
		click(element, driver, "Click Edit Source Control button  :");

		log.info(" Edit Source Control button Clicked..");

	}

	public void clickProjects() throws Exception {

		logExtentReport("click Projects....");
		log.info("click Projects.......");
		waitForElementVisible(Projects, driver, "wait for Projects tab tobe visible");
		click(Projects, driver, "click Projects..");

	}

	public void clickAddProject() throws Exception {

		logExtentReport("Create Add Project ...");
		log.info("Create Add Project ......");
		waitForElementVisible(AddProject, driver, "wait for Add Project to be visible");
		click(AddProject, driver, "click Add Project..");
	}

	public void enterProjectName(String projectname) throws Exception {

		logExtentReport("Entering projectname");
		log.info("Entering projectname");
		enterValue(AddProjectName, projectname, driver, "Enter the User name " + projectname);
	}

	public void clickAddBUttonOnCreateProjectPopUp() throws Exception {

		logExtentReport("click Add BUtton On Create Project PopUp");
		log.info("click Add BUtton On Create Project PopUp.");
		waitForElementVisible(AddBUttonOnCreateProjectPopUp, driver,
				"wait for Add Button on create Project pop up to be visible");
		click(AddBUttonOnCreateProjectPopUp, driver, "click AddBUttonOnCreateProjectPopUp..");
	}

	public void clickCreateProjectButton() throws Exception {

		logExtentReport("click create project button");
		log.info("click create project button");
		click(CreateProjectButton, driver, "Click create project button ");
		elementContainsText(notificationMessage, "Project created successfully.", driver,
				"Verify project created successfully message is visible");

	}

}
