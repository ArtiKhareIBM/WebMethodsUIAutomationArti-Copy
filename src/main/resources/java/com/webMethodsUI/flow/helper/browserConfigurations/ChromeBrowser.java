package com.webMethodsUI.flow.helper.browserConfigurations;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;

public class ChromeBrowser 
{
	//File seprator variable 
	public static String fileSeperator = System.getProperty("file.separator");

	// when we create chrome driver we need to provide some options to chrome
	// This method only gives chrome options capability
	public ChromeOptions getChromeOptions() {
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory",absoluteFilePath(fileSeperator+"DownloadedFiles").getAbsolutePath());

		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", prefs);
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
//		option.addArguments("--incognito");
		option.addArguments("--disable-infobars");	
		option.addArguments("--disable-gpu");

		// get Chrome capabilities
		DesiredCapabilities chrome = DesiredCapabilities.chrome();

		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, chrome);

		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}

		return option;
	}

	// call this method with chrome options
	// set the location of chrome driver
	public WebDriver getChromeDriver(ChromeOptions cap) {

		if (System.getProperty("os.name").contains("Mac")) {
			// need to add chrome jar path for Mac
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath(""));
			return new ChromeDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(cap);
		} // while using add linux path
		else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(cap);
		}

		return null;
	}
	
	//Method to return absolute file path based on environment
	public static File absoluteFilePath(String relativeFilePath)
	{
		File file = null; 
	
		if(getCurrentPlatform().contains("Windows"))
		{
			file = new File(System.getProperty("user.dir")+relativeFilePath);
		}
		else if(getCurrentPlatform().contains("nix")||getCurrentPlatform().contains("nux")||getCurrentPlatform().contains("aix"))
		{
			file = new File(System.getProperty("user.dir")+relativeFilePath);
		}
		else if(getCurrentPlatform().contains("mac"))
		{
			file = new File(System.getProperty("user.home")+relativeFilePath);
		}
	
		return file;
	}
	
	//Method to fetch current platform
	public static String getCurrentPlatform()
	{
		return System.getProperty("os.name");
	}
}
