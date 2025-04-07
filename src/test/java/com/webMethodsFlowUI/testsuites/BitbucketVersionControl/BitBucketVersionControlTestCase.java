package com.webMethodsFlowUI.testsuites.BitbucketVersionControl;

import com.webMethodsUI.flow.VersionControlPageObject.VersionControl;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class BitBucketVersionControlTestCase extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	VersionControl versionControl;
	WebElement element;
	CommonActions commonActions;
	PackageConnectorPage packageConnectorPage;
	String src_Bitbucket_Ctrl = "srcCtrl_bitbucket_Arti";
	String bitbucket_username = "artikhare";
	String bitbucketsrcCtrl = "Bitbucket";
	String bitbucket_hostname = "bitbucket.org";
	String bitbucket_pat = "ATBBbGDhRrPXkFT7G2UVDCpT3Rpy32594F58";
	String invalid_bitbucket_pat = "125f5g6rv7G2UVDCpT3Rpy3";

	@Test(priority = 1, groups = " bitbucket source control", description = "ensure login worked fine", testName = "login test case")
	public void loginTest() throws Exception {
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}

	
	
	@Test(priority = 2, groups = " bitbucket source control", description = "creating bitbucket source control account", testName = "creating bitbucket source control account")
	public void createBitbucketSourceControl() throws Exception {

		versionControl = new VersionControl(driver);
		//versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(src_Bitbucket_Ctrl);
		versionControl.enterUsername(bitbucket_username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("Bitbucket");
		versionControl.enterHostName(bitbucket_hostname);
		versionControl.enterPAT(bitbucket_pat);
		versionControl.clickValidate();
		versionControl.clickAdd();
		packageConnectorPage.VerifyElementVisible(src_Bitbucket_Ctrl);
		Thread.sleep(2000);
	}
	 
	@Test(priority = 3, groups = " Bitbucket source control", description = "update Bitbucket SourceControl Account with valid token", testName = "update Bitbucket SourceControl Account with valid token")
	public void update_BitbucketSourceControl_Account_with_ValidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
	//	versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		packageConnectorPage.VerifyElementVisible(src_Bitbucket_Ctrl);
		versionControl.editSourceControlFromVersionControl(src_Bitbucket_Ctrl);
		versionControl.enterPAT(bitbucket_pat);
		versionControl.clickValidate();
		versionControl.clickUpdate();
		Thread.sleep(2000);

	}

		 
	
	@Test(priority = 4, groups = " Bitbucket source control", description = "update Bitbucket SourceControl Account with invalid token", testName = "update Bitbucket SourceControl Account with invalid token")
	public void update_BitbucketSourceControl_Account_with_InValidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
	//	versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.editSourceControlFromVersionControl(src_Bitbucket_Ctrl);
		versionControl.enterPAT(invalid_bitbucket_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		versionControl.clickCancel();
		Thread.sleep(2000);

	}
	
	@Test(priority = 5, groups = " Bitbucket source control", description = "delete Bitbucket SourceControl", testName = "delete Bitbucket SourceControl")
	public void delete_BitbucketSourceControl_Account() throws Exception {
		versionControl.deleteSourceControlFromVersionControl(src_Bitbucket_Ctrl);
		Thread.sleep(2000);
	}
	
	@Test(priority = 6, groups = " Bitbucket source control", description = "create Bitbucket SourceControl Account with invalid token", testName = "create Bitbucket SourceControl Account with invalid token")
	public void create_GitlabSourceControl_Account_with_InvalidToken() throws Exception {

		versionControl = new VersionControl(driver);
		Thread.sleep(3000);
	//	versionControl.clickUserProfile();
		versionControl.clickSettings();
		versionControl.clickVersionControlTab();
		versionControl.clickAddButtonOnVersionControlPage();
		versionControl.enterSourceControl(src_Bitbucket_Ctrl);
		versionControl.enterUsername(bitbucket_username);
		packageConnectorPage = new PackageConnectorPage(driver);
		packageConnectorPage.ClickOnDropdown("GitHub");
		packageConnectorPage.ClickOnDropdown("Bitbucket");
		versionControl.enterHostName(bitbucket_hostname);
		versionControl.enterPAT(invalid_bitbucket_pat);
		versionControl.clickValidate();
		versionControl.verifyAlertMsgforIncorrectDetails();
		versionControl.clickCancel();		

	}

}
