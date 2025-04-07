package com.webMethodsUI.flow.helper.browserConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;

public class FireFoxBrowser {

	// when we create firefox driver we need to provide some options to firefox
	// This method only gives firefox options capability
	public FirefoxOptions getFireFoxOptions() {

		//DesiredCapabilities firefox = DesiredCapabilities.;
		FirefoxProfile profile = new FirefoxProfile();

		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);

		//firefox.setCapability(FirefoxDriver.PROFILE, profile);
		//firefox.setCapability("marionette", true);

		FirefoxOptions firefoxOptions = new FirefoxOptions();
		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			firefoxOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return firefoxOptions;
	}

	// call this method with firefox options
	// set the location of Firefox driver
	public WebDriver getFireDriver(FirefoxOptions cap) {

		if (System.getProperty("os.name").contains("Mac")) {
			// need to add firefox jar path for Mac
			System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath(""));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/GeckoDriver.exe"));
			return new FirefoxDriver(cap);
		} // while using add linux path
		else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/GeckoDriver.exe"));
			return new FirefoxDriver(cap);
		}

		return null;
	}
}
