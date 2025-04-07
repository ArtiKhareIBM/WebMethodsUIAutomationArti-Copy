package com.webMethodsFlowUI.testsuites.GitLabVersionControl;

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

public class GitLabVersionControl_CreateProject extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	VersionControl versionControl;
	WebElement element;
	CommonActions commonActions;
	PackageConnectorPage packageConnectorPage;
	String srcCtrl = "srcCtrl_gitlab_Arti";
	String username = "ArtiKhareGitlab";
	String gitlabsrcCtrl = "GitLab";
	String gitlab_hostname = "gitlab.com";
	String gitlab_pat = "glpat-xA3EQv459wTbQLYFxySF";
	String invalid_gitlab_pat = "1234g4b490jd945gvj";
	String projectName = "TestGitlabAutomation";

	@Test(priority = 1, groups = " Project with Gitlab Account", description = "ensure login worked fine", testName = "login test case")
	public void loginTest() throws Exception {
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}

	@Test(priority = 2, groups = " Project with Gitlab Account", description = "creating gitlab source control account", testName = "creating gitlab source control account")
	public void createGitLabSourceControl() throws Exception {

		versionControl = new VersionControl(driver);
		versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(srcCtrl);
		versionControl.enterUsername(username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("GitLab");
		versionControl.enterHostName(gitlab_hostname);
		versionControl.enterPAT(gitlab_pat);
		versionControl.clickValidate();
		versionControl.clickAdd();
		packageConnectorPage.VerifyElementVisible(srcCtrl);
		Thread.sleep(3000);
	}

	/*
	 * @Test(priority = 3, groups = "Project with Gitlab Account", description =
	 * "create Project Gitlab  Account ", testName =
	 * "create Project Gitlab  Account") public void createGitRepo(String repoName,
	 * String description, String homepage, boolean isPrivate, String isDynamic) {
	 * String dynamicRepoName = repoName+"Project";
	 * GithubAPI.gitRepoName.put(repoName,dynamicRepoName); GithubAPI githubAPI =
	 * new GithubAPI();
	 * githubAPI.createGitRepo(dynamicRepoName,description,homepage,isPrivate); }
	 */

}
