package com.webMethodsUI.flow.helper.browserConfigurations.config;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import com.webMethodsUI.flow.helper.browserConfigurations.BrowserType;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {
	private static FileInputStream file;
	public static Properties OR;

	// property file will be loaded into memory whenever object of this file is
	// created
	public PropertyReader() {
		String filePath = ResourceHelper.getResourcePath("/src/main/resources/configfile/config.properties");
		try {
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getImplicitWait() {

		return Integer.parseInt(OR.getProperty("implicitWait"));
	}

	@Override
	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitWait"));

	}

	@Override
	public int getPageLoadTime() {

		return Integer.parseInt(OR.getProperty("pageLoadTime"));

	}

	// here string converted into enum
	@Override
	public BrowserType getBrowserType() {

		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

	@Override
	public String getURL() {
		if (System.getProperty("url") != null) {
			return System.getProperty("url");

		}
		// this return will execute only when the pom property is null
		return OR.getProperty("applicationUrl");
	}

	@Override
	public String getprojectName() {
		if (System.getProperty("projectName") != null) {
			return System.getProperty("projectName");

		}
		// this return will execute only when the pom property is null
		return OR.getProperty("projectName");
	}

	@Override
	public String getUserName() {
		if (System.getProperty("userName") != null) {
			return System.getProperty("userName");

		}

		return OR.getProperty("userName");
	}

	@Override
	public String getGitHubUserName() {
		if (System.getProperty("GIT_Username") != null) {
			return System.getProperty("GIT_Username");

		}

		return OR.getProperty("GIT_Username");
	}

	@Override
	public String getGitHubPAT() {
		if (System.getProperty("GIT_PAT") != null) {
			return System.getProperty("GIT_PAT");

		}

		return OR.getProperty("GIT_PAT");
	}

	@Override
	public String getGitHubUrl() {
		if (System.getProperty("GIT_URL") != null) {
			return System.getProperty("GIT_URL");

		}

		return OR.getProperty("GIT_URL");
	}

	@Override
	public String getExtentLogging() {
		if (System.getProperty("rest.extentLogging") != null) {
			return System.getProperty("rest.extentLogging");

		}

		return OR.getProperty("rest.extentLogging");
	}

	@Override
	public String getExtentReporting() {
		if (System.getProperty("rest.extentReport") != null) {
			return System.getProperty("rest.extentReport");

		}

		return OR.getProperty("rest.extentReport");
	}

	@Override
	public int getDefaultconnectionTimeOut() {

		return Integer.parseInt(OR.getProperty("DefaultconnectionTimeOut"));

	}

	@Override
	public int getDefaultReadConnectionTimeOut() {

		return Integer.parseInt(OR.getProperty("DefaultReadConnectionTimeOut"));

	}

	@Override
	public String getHTTPS_Relaxed_validation() {

		if (System.getProperty("relaxedHTTPSValidation") != null) {
			return System.getProperty("relaxedHTTPSValidation");

		}

		return OR.getProperty("relaxedHTTPSValidation");
	}

	@Override
	public String getPassword() {
		if (System.getProperty("password") != null) {
			return System.getProperty("password");

		}

		return OR.getProperty("password");
	}

	@Override
	public String getISURL() {
		if (System.getProperty("ISUrl") != null) {
			return System.getProperty("ISUrl");

		}
		// this return will execute only when the pom property is null
		return OR.getProperty("ISUrl");
	}

	@Override
	public String getISUserName() {
		if (System.getProperty("ISuserName") != null) {
			return System.getProperty("ISuserName");

		}

		return OR.getProperty("ISuserName");
	}

	@Override
	public String getISPassword() {
		if (System.getProperty("ISpassword") != null) {
			return System.getProperty("ISpassword");

		}

		return OR.getProperty("ISpassword");
	}

	@Override
	public String targetSubdomain() {
		if (System.getProperty("targetSubdomain") != null) {
			return System.getProperty("targetSubdomain");

		}
		// this return will execute only when the pom property is null
		return OR.getProperty("targetSubdomain");
	}

	@Override
	public String GetdeployURL() {
		if (System.getProperty("DeployedtenantURL") != null) {
			return System.getProperty("DeployedtenantURL");

		}
		// this return will execute only when the pom property is null
		return OR.getProperty("DeployedtenantURL");
	}

	@Override
	public String GetdeployUserName() {
		if (System.getProperty("DeployedtenantuserName") != null) {
			return System.getProperty("DeployedtenantuserName");

		}

		return OR.getProperty("DeployedtenantuserName");
	}

	@Override
	public String GetdeployPassword() {
		if (System.getProperty("Deployedpassword") != null) {
			return System.getProperty("Deployedpassword");

		}

		return OR.getProperty("Deployedpassword");
	}

	@Override
	public String getDevUserName() {
		if (System.getProperty("DevUserName") != null) {
			return System.getProperty("DevUserName");

		}

		return OR.getProperty("DevUserName");
	}

	@Override
	public String getDevPassword() {
		if (System.getProperty("DevPassword") != null) {
			return System.getProperty("DevPassword");

		}

		return OR.getProperty("DevPassword");
	}

	@Override
	public String getAdmin2UserName() {
		if (System.getProperty("Admin2userName") != null) {
			return System.getProperty("Admin2userName");

		}

		return OR.getProperty("Admin2userName");
	}

	@Override
	public String getAdmin2Password() {
		if (System.getProperty("Admin2Password") != null) {
			return System.getProperty("Admin2Password");

		}

		return OR.getProperty("Admin2Password");
	}

	@Override
	public BrowserType getBrowserTypeFireFox() {
		return BrowserType.valueOf(OR.getProperty("browserTypeFireFox"));
	}

	@Override
	public String getTargetUserName() {
		if (System.getProperty("targetTenantuserName") != null) {
			return System.getProperty("targetTenantuserName");

		}

		return OR.getProperty("targetTenantuserName");
	}

	@Override
	public String getTargetPassword() {
		if (System.getProperty("targetTenantPassword") != null) {
			return System.getProperty("targetTenantPassword");

		}

		return OR.getProperty("targetTenantPassword");
	}

}
