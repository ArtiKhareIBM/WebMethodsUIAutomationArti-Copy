package com.webMethodsFlowUI.testsuites.VersionControlTestCases;

import com.webMethodsUI.flow.VersionControlPageObject.VersionControl;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;

import githubAPIs.GithubAPI;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class VersionControlTestCase extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	VersionControl versionControl;
	WebElement element;
	CommonActions commonActions;
	PackageConnectorPage packageConnectorPage;
	String src_github_Ctrl = "srcGithubCtrl_Arti";
	String github_username = "ArtiKhareIBM";
	String githubsrc_github_Ctrl = "GitHub";
	String github_hostname = "github.com";
	String github_pat = "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";
	String invalid_github_pat = "34298ud9r4j3ygBIcktiqjpa2kUayz";
	String projectName = "GithubAutomation";
	String dynamicRepoName = projectName + "Project";
	String description = "Github Automation Project";
	String homepage = "https://github.com";
	boolean isPrivate = true;
	String isDynamic = "true";
	// Gitlab parameters
	String src_GitLab_Ctrl = "srcCtrl_gitlab_Arti";
	String gitlab_username = "ArtiKhareGitlab";
	String gitlabsrcCtrl = "GitLab";
	String gitlab_hostname = "gitlab.com";
	String gitlab_pat = "glpat-xA3EQv459wTbQLYFxySF";
	String invalid_gitlab_pat = "1234g4b490jd945gvj";

	// Bitbucket Parameters
	String src_Bitbucket_Ctrl = "srcCtrl_bitbucket_Arti";
	String bitbucket_username = "artikhare";
	String bitbucketsrcCtrl = "Bitbucket";
	String bitbucket_hostname = "bitbucket.org";
	String bitbucket_pat = "ATBBbGDhRrPXkFT7G2UVDCpT3Rpy32594F58";
	String invalid_bitbucket_pat = "125f5g6rv7G2UVDCpT3Rpy3";
	
	
	@Test(priority = 1, groups = " github source control", description = "ensure login worked fine", testName = "login test case")
	public void loginTest() throws Exception {
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}

	@Test(priority = 2, groups = " github source control", description = "create Github SourceControl Account", testName = "create Github SourceControl Account")

	public void createGithubSourceControlAccount() throws Exception {

		versionControl = new VersionControl(driver);
		// versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(src_github_Ctrl);
		versionControl.enterUsername(github_username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitHub");
		versionControl.enterHostName(github_hostname);
		versionControl.enterPAT(github_pat);
		versionControl.clickValidate();
		versionControl.clickAdd();
		packageConnectorPage.VerifyElementVisible(src_github_Ctrl);
		Thread.sleep(2000);
	}

	@Test(priority = 3, groups = " github source control", description = "update Github SourceControl Account with valid token", testName = "update Github SourceControl Account with valid token")
	public void update_GithubSourceControl_Account_with_ValidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
		// versionControl.clickUserProfile(); 
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		packageConnectorPage.VerifyElementVisible(src_github_Ctrl);
		versionControl.editSourceControlFromVersionControl(src_github_Ctrl);
		versionControl.enterPAT(github_pat);
		versionControl.clickValidate();
		versionControl.clickUpdate();
		Thread.sleep(2000);

	}

	@Test(priority = 4, groups = " github source control", description = "update github SourceControl Account with invalid token", testName = "update github SourceControl Account with invalid token")
	public void update_GitHubSourceControl_Account_with_InValidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
		//versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		packageConnectorPage.VerifyElementVisible(src_github_Ctrl);
		versionControl.editSourceControlFromVersionControl(src_github_Ctrl);
		versionControl.enterPAT(invalid_github_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		versionControl.clickCancel();
		Thread.sleep(2000);

	}

	@Test(priority = 5, groups = " github source control", description = "delete github SourceControl", testName = "delete github SourceControl")
	public void delete_GitHubSourceControl_Account() throws Exception {
		versionControl.deleteSourceControlFromVersionControl(src_github_Ctrl);
		Thread.sleep(2000);
	}

	@Test(priority = 6, groups = " github source control", description = "create Github SourceControl Account with incorrect type", testName = "create Github SourceControl Account with incorrect type")
	public void create_GithubSourceControl_Account_with_IncorrectType() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(src_github_Ctrl);
		versionControl.enterUsername(github_username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitLab");
		versionControl.enterHostName(github_hostname);
		versionControl.enterPAT(invalid_github_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		Thread.sleep(2000);
		versionControl.clickCancel();
		Thread.sleep(2000);

	}

	@Test(priority = 7, groups = " github source control", description = "create Github SourceControl Account with invalid token", testName = "create Github SourceControl Account with invalid token")
	public void create_GithubSourceControl_Account_with_InvalidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000); 
	//	versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(src_github_Ctrl);
		versionControl.enterUsername(github_username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitHub");
		versionControl.enterHostName(github_hostname);
		versionControl.enterPAT(invalid_github_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		versionControl.clickCancel();
		Thread.sleep(2000);

	}

	
	  public void createGitRepo() throws Exception {
	  System.out.println("~~~~~~~createGitRepo~~~~~~~~~"); 
	  String dynamicRepoName = repoName + "Project"; 
	  GithubAPI.gitRepoName.put(repoName, dynamicRepoName);
	  GithubAPI githubAPI = new GithubAPI();
	  githubAPI.createGitRepo(dynamicRepoName, description, homepage, isPrivate);
	  //githubAPI.deleteGitRepo(dynamicRepoName); }
	 

	
	  @Test(priority = 6, groups = " github source control", description =
	  "create Project with Github Repo", testName =
	  "create Project with Github Repo")
	  
	  public void createProjectWithSourceControl() throws Exception {
	  
	  versionControl = new VersionControl(driver); versionControl.clickProjects();
	  versionControl.clickAddProject();
	  versionControl.enterProjectName(projectName);
	  versionControl.clickAddBUttonOnCreateProjectPopUp();
	  versionControl.enterSourceControl(src_github_Ctrl);
	  versionControl.enterUsername(github_username); 
	  packageConnectorPage = new PackageConnectorPage(driver); 
	  packageConnectorPage.ClickOnDropdown("GitHub");
	  packageConnectorPage.ClickOnDropdown("GitHub");
	  versionControl.enterHostName(github_hostname);
	  versionControl.enterPAT(github_pat); versionControl.clickValidate();
	  versionControl.clickAdd(); 
	  GithubAPI.gitRepoName.put(projectName,dynamicRepoName); 
	  GithubAPI githubAPI = new GithubAPI();
	  githubAPI.createGitRepo(dynamicRepoName, description, homepage, isPrivate);
	  versionControl.clickCreateProjectButton(); 
	  //versionControl.deleteSourceControlFromVersionControl(src_github_Ctrl);
	  Thread.sleep(3000); }
	 

	/*
	 * @Test(priority = 8, groups = " gitlab source control", description =
	 * "creating gitlab source control account", testName =
	 * "creating gitlab source control account") public void
	 * createGitLabSourceControl() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); Thread.sleep(3000);
	 * //versionControl.clickUserProfile(); versionControl.clickSettings();
	 * versionControl.clickVersionControlTab();
	 * versionControl.clickAddButtonOnVersionControlPage();
	 * versionControl.enterSourceControl(src_GitLab_Ctrl);
	 * versionControl.enterUsername(gitlab_username); packageConnectorPage = new
	 * PackageConnectorPage(driver); packageConnectorPage.ClickOnDropdown("GitHub");
	 * packageConnectorPage.ClickOnDropdown("GitLab");
	 * versionControl.enterHostName(gitlab_hostname);
	 * versionControl.enterPAT(gitlab_pat); versionControl.clickValidate();
	 * versionControl.clickAdd();
	 * packageConnectorPage.VerifyElementVisible(src_GitLab_Ctrl);
	 * Thread.sleep(2000); }
	 * 
	 * 
	 * @Test(priority = 9, groups = " gitlab source control", description =
	 * "update gitlab SourceControl Account with valid token", testName =
	 * "update gitlab SourceControl Account with valid token") public void
	 * update_GitLabSourceControl_Account_with_ValidToken() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); Thread.sleep(3000);
	 * //versionControl.clickUserProfile(); versionControl.clickSettings();
	 * versionControl.clickVersionControlTab();
	 * packageConnectorPage.VerifyElementVisible(src_GitLab_Ctrl);
	 * versionControl.editSourceControlFromVersionControl(src_GitLab_Ctrl);
	 * versionControl.enterPAT(gitlab_pat); versionControl.clickValidate();
	 * versionControl.clickUpdate(); Thread.sleep(2000);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority = 10, groups = " gitlab source control", description =
	 * "update gitlab SourceControl Account with invalid token", testName =
	 * "update gitlab SourceControl Account with invalid token") public void
	 * update_GitLabSourceControl_Account_with_InValidToken() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); Thread.sleep(3000); //
	 * versionControl.clickUserProfile(); versionControl.clickSettings();
	 * versionControl.clickVersionControlTab();
	 * packageConnectorPage.VerifyElementVisible(src_GitLab_Ctrl);
	 * versionControl.editSourceControlFromVersionControl(src_GitLab_Ctrl);
	 * versionControl.enterPAT(invalid_gitlab_pat); versionControl.clickValidate();
	 * versionControl.verifyAlertMsgforIncorrectDetails();
	 * versionControl.clickCancel(); Thread.sleep(2000);
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 11, groups = " gitlab source control", description =
	 * "delete Gitlab SourceControl", testName = "delete Gitlab SourceControl")
	 * public void delete_GitlabSourceControl_Account() throws Exception {
	 * versionControl.deleteSourceControlFromVersionControl(src_GitLab_Ctrl);
	 * Thread.sleep(2000); }
	 * 
	 * @Test(priority = 12, groups = " gitlab source control", description =
	 * "create Gitlab SourceControl Account with incorrect token", testName =
	 * "create Gitlab SourceControl Account with invalid token") public void
	 * create_GitlabSourceControl_Account_with_InvalidToken() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); Thread.sleep(3000); //
	 * versionControl.clickUserProfile(); versionControl.clickSettings();
	 * versionControl.clickVersionControlTab();
	 * versionControl.clickAddButtonOnVersionControlPage();
	 * versionControl.enterSourceControl(src_GitLab_Ctrl);
	 * versionControl.enterUsername(gitlab_username); packageConnectorPage = new
	 * PackageConnectorPage(driver); packageConnectorPage.ClickOnDropdown("GitHub");
	 * packageConnectorPage.ClickOnDropdown("GitLab");
	 * versionControl.enterHostName(gitlab_hostname);
	 * versionControl.enterPAT(invalid_gitlab_pat); versionControl.clickValidate();
	 * versionControl.verifyAlertMsgforIncorrectDetails();
	 * versionControl.clickCancel(); Thread.sleep(3000);
	 * 
	 * }
	 * 
	 * @Test(priority = 13, groups = " bitbucket source control", description =
	 * "creating bitbucket source control account", testName =
	 * "creating bitbucket source control account") public void
	 * createBitbucketSourceControl() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); Thread.sleep(3000);
	 * //versionControl.clickUserProfile(); versionControl.clickSettings();
	 * versionControl.clickVersionControlTab();
	 * versionControl.clickAddButtonOnVersionControlPage();
	 * versionControl.enterSourceControl(src_Bitbucket_Ctrl);
	 * versionControl.enterUsername(bitbucket_username); packageConnectorPage = new
	 * PackageConnectorPage(driver); packageConnectorPage.ClickOnDropdown("GitHub");
	 * packageConnectorPage.ClickOnDropdown("Bitbucket");
	 * versionControl.enterHostName(bitbucket_hostname);
	 * versionControl.enterPAT(bitbucket_pat); versionControl.clickValidate();
	 * versionControl.clickAdd();
	 * packageConnectorPage.VerifyElementVisible(src_Bitbucket_Ctrl);
	 * Thread.sleep(2000); }
	 * 
	 * @Test(priority = 14, groups = " Bitbucket source control", description =
	 * "update Bitbucket SourceControl Account with valid token", testName =
	 * "update Bitbucket SourceControl Account with valid token") public void
	 * update_BitbucketSourceControl_Account_with_ValidToken() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); Thread.sleep(1000); //
	 * versionControl.clickUserProfile(); versionControl.clickSettings();
	 * versionControl.clickVersionControlTab();
	 * packageConnectorPage.VerifyElementVisible(src_Bitbucket_Ctrl);
	 * versionControl.editSourceControlFromVersionControl(src_Bitbucket_Ctrl);
	 * versionControl.enterPAT(bitbucket_pat); versionControl.clickValidate();
	 * versionControl.clickUpdate(); Thread.sleep(2000);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test(priority = 15, groups = " Bitbucket source control", description =
	 * "update Bitbucket SourceControl Account with invalid token", testName =
	 * "update Bitbucket SourceControl Account with invalid token") public void
	 * update_BitbucketSourceControl_Account_with_InValidToken() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); Thread.sleep(3000); //
	 * versionControl.clickUserProfile(); versionControl.clickSettings();
	 * versionControl.clickVersionControlTab();
	 * versionControl.editSourceControlFromVersionControl(src_Bitbucket_Ctrl);
	 * versionControl.enterPAT(invalid_bitbucket_pat);
	 * versionControl.clickValidate();
	 * versionControl.verifyAlertMsgforIncorrectDetails();
	 * versionControl.clickCancel(); Thread.sleep(2000);
	 * 
	 * }
	 * 
	 * @Test(priority = 16, groups = " Bitbucket source control", description =
	 * "delete Bitbucket SourceControl", testName =
	 * "delete Bitbucket SourceControl") public void
	 * delete_BitbucketSourceControl_Account() throws Exception {
	 * versionControl.deleteSourceControlFromVersionControl(src_Bitbucket_Ctrl);
	 * Thread.sleep(2000); }
	 * 
	 * @Test(priority = 17, groups = " Bitbucket source control", description =
	 * "create Bitbucket SourceControl Account with invalid token", testName =
	 * "create Bitbucket SourceControl Account with invalid token") public void
	 * create_BitBucket_SourceControl_Account_with_InvalidToken() throws Exception {
	 * 
	 * versionControl = new VersionControl(driver); Thread.sleep(3000); //
	 * versionControl.clickUserProfile(); versionControl.clickSettings();
	 * versionControl.clickVersionControlTab();
	 * versionControl.clickAddButtonOnVersionControlPage();
	 * versionControl.enterSourceControl(src_Bitbucket_Ctrl);
	 * versionControl.enterUsername(bitbucket_username); packageConnectorPage = new
	 * PackageConnectorPage(driver); packageConnectorPage.ClickOnDropdown("GitHub");
	 * packageConnectorPage.ClickOnDropdown("Bitbucket");
	 * versionControl.enterHostName(bitbucket_hostname);
	 * versionControl.enterPAT(invalid_bitbucket_pat);
	 * versionControl.clickValidate();
	 * versionControl.verifyAlertMsgforIncorrectDetails();
	 * versionControl.clickCancel();
	 * 
	 * }
	 */

}
