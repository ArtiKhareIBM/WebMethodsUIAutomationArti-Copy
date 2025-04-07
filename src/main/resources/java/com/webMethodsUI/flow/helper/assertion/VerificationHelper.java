package com.webMethodsUI.flow.helper.assertion;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.webMethodsUI.flow.testbase.TestBase;

public class VerificationHelper {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(VerificationHelper.class);
	boolean status;

	public VerificationHelper(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isDisplayed(WebElement element) {

		try {
			element.isDisplayed();
			
			log.info("element is Displayed.... " + element.getText());
			logExtentReport("elemnt displayed is:  " +element.getText());
			return true;
		} catch (Exception e) {
			log.error("elelemt is not Displayed ", e.getCause());
			logExtentReport(" elelemt is not Displayed  " +e.getCause());
			return false;
		}

	}

	public boolean isNotDisplayed(WebElement element) {

		try {
			element.isDisplayed();
			log.info("element is present.... " + element.getText());
			logExtentReport("element is present.... \" + element.getText()");
			return true;
		} catch (Exception e) {
			log.error("elelemt is not present ", e.getCause());
			logExtentReport("elelemt is not present \", e.getCause()");
			return true;
		}

	}
	
	public String getText(WebElement element) {
		if(null == element)
		{
			log.info("WebElelemnt is null");
			logExtentReport("WebElelemnt is null");
			return null;
		}
		logExtentReport("Inside getText now....");
	   status= isDisplayed(element);
	   if(status)
	   {
		   log.info("element text is....." +element.getText());
		   logExtentReport("element text is....." +element.getText());
		   return element.getText();
	   }
	   else {
		   
		   return null;
	   }
		   
		
		
	}

}
