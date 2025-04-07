package com.webMethodsFlowUI.testsuites.GitLabVersionControl;

import com.webMethodsUI.flow.VersionControlPageObject.VersionControl;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class GitLabVersionControlTestCase extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	VersionControl versionControl;
	WebElement element;
	CommonActions commonActions;
	PackageConnectorPage packageConnectorPage;
	String src_GitLab_Ctrl = "srcCtrl_gitlab_Arti";
	String gitlab_username = "ArtiKhareGitlab";
	String gitlabsrcCtrl = "GitLab";
	String gitlab_hostname = "gitlab.com";
	String gitlab_pat = "glpat-xA3EQv459wTbQLYFxySF";
	String invalid_gitlab_pat = "1234g4b490jd945gvj";

	
	@Test(priority = 1, groups = " gitlab source control", description = "ensure login worked fine", testName = "login test case")
	public void loginTest() throws Exception {
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
	  
	
	
	@Test(priority = 2, groups = " gitlab source control", description = "creating gitlab source control account", testName = "creating gitlab source control account")
	public void createGitLabSourceControl() throws Exception {

		versionControl = new VersionControl(driver);
		//versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(src_GitLab_Ctrl);
		versionControl.enterUsername(gitlab_username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitLab");
		versionControl.enterHostName(gitlab_hostname);
		versionControl.enterPAT(gitlab_pat);
		versionControl.clickValidate();
		versionControl.clickAdd();
		packageConnectorPage.VerifyElementVisible(src_GitLab_Ctrl);
		Thread.sleep(2000);
	}
	 
	 
	@Test(priority = 3, groups = " gitlab source control", description = "update gitlab SourceControl Account with valid token", testName = "update gitlab SourceControl Account with valid token")
	public void update_GitLabSourceControl_Account_with_ValidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
		//versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		packageConnectorPage.VerifyElementVisible(src_GitLab_Ctrl);
		versionControl.editSourceControlFromVersionControl(src_GitLab_Ctrl);
		versionControl.enterPAT(gitlab_pat);
		versionControl.clickValidate();
		versionControl.clickUpdate();
		Thread.sleep(2000);

	}
	 
	 
	
	
	@Test(priority = 4, groups = " gitlab source control", description = "update gitlab SourceControl Account with invalid token", testName = "update gitlab SourceControl Account with invalid token")
	public void update_GitLabSourceControl_Account_with_InValidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
	//	versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		packageConnectorPage.VerifyElementVisible(src_GitLab_Ctrl);
		versionControl.editSourceControlFromVersionControl(src_GitLab_Ctrl);
		versionControl.enterPAT(invalid_gitlab_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		versionControl.clickCancel();
		Thread.sleep(2000);

	}


	@Test(priority = 5, groups = " gitlab source control", description = "delete Gitlab SourceControl", testName = "delete Gitlab SourceControl")
	public void delete_GitlabSourceControl_Account() throws Exception {
		versionControl.deleteSourceControlFromVersionControl(src_GitLab_Ctrl);
		Thread.sleep(2000);
	}
	
	@Test(priority = 6, groups = " gitlab source control", description = "create Gitlab SourceControl Account with incorrect token", testName = "create Gitlab SourceControl Account with invalid token")
	public void create_GitlabSourceControl_Account_with_InvalidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
	//	versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(src_GitLab_Ctrl);
		versionControl.enterUsername(gitlab_username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitLab");
		versionControl.enterHostName(gitlab_hostname);
		versionControl.enterPAT(invalid_gitlab_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		versionControl.clickCancel();
		Thread.sleep(3000);

	}
	 
	
	
		 

}
