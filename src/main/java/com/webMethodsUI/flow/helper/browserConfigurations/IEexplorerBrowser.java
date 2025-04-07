package com.webMethodsUI.flow.helper.browserConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;

public class IEexplorerBrowser {

	/*
	 * public InternetExplorerOptions getIExplorerCapabilities() {
	 * 
	 * DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	 * 
	 * cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,
	 * ElementScrollBehavior.BOTTOM);
	 * cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	 * cap.setCapability(InternetExplorerDriver.
	 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	 * cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	 * //cap.setJavascriptEnabled(true);
	 * 
	 * InternetExplorerOptions internetExplorerOptions = new
	 * InternetExplorerOptions(cap); return internetExplorerOptions;
	 * 
	 * }
	 */

	public WebDriver getIExplorerDriver(InternetExplorerOptions cap) {
		// <<<<<<<<<<<<<<<<<<<<TO DO need to download IE driver and keep it>>>>>>>>>>>>
		System.setProperty("webdriver.ie.driver", ResourceHelper.getResourcePath(""));
		return new InternetExplorerDriver(cap);
	}

}
