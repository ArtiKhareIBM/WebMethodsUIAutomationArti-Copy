package com.webMethodsUI.flow.helper.window;

import java.util.Set;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import com.webMethodsUI.flow.helper.wait.WaitHelper;

public class WindowHelper {
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(WindowHelper.class);
	
	
	public WindowHelper(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public void switchToParentWindow() {
		log.info("Switching into parent window");
		driver.switchTo().defaultContent();
		log.info("Switched into parent window");
	}
	
	
	public void switchToWindow(int index)
	{
		Set<String> windows = driver.getWindowHandles();
		int i=1;
		for (String nameOrHandle : windows) {
			if(i==index) {
				log.info("Switched to : " +index +"window");
				driver.switchTo().window(nameOrHandle);
			}
			else
			{
				i++;
			}
			
		}
	}
	
	
	public void closeAllTabsAndSwitchToMainWindow() {		
		
		Set<String> allWindows = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();//gives parent window
		for(String windowName : allWindows)
		{
			if(!windowName.equalsIgnoreCase(parentWindow))
			{
				driver.close();
			}
		}
		log.info("switch to main window ");
		driver.switchTo().window(parentWindow);
		
	}
	
		public void navigateBack() {
			log.info("switching back ");
		driver.navigate().back();
		
	    }
		
		public void navigateForward() {
			log.info("navigating forward");
			driver.navigate().forward();
		}
	
	
	
	
	
	

}
