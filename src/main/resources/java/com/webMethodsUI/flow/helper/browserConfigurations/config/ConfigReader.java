package com.webMethodsUI.flow.helper.browserConfigurations.config;

import com.webMethodsUI.flow.helper.browserConfigurations.BrowserType;

public interface ConfigReader {

	public int getImplicitWait();

	public int getExplicitWait();

	public int getPageLoadTime();

	public BrowserType getBrowserType();

	public String getURL();

	public String getUserName();

	public String getPassword();

	public String GetdeployURL();

	public String GetdeployUserName();

	public String GetdeployPassword();


}
