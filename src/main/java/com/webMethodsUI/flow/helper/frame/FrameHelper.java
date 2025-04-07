package com.webMethodsUI.flow.helper.frame;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.webMethodsUI.flow.helper.wait.WaitHelper;

public class FrameHelper {
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(FrameHelper.class);
	
	
	public FrameHelper(WebDriver driver) {
		super();
		this.driver = driver;
	}

	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		log.info("switched to:" +index +" frame");
	}
	
	public void switchToFrame(String name)
	{
		driver.switchTo().frame(name);
		log.info("switched to:" +name +" name");

	}
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("switched to:" +element +" element");

	}
	
	


}
