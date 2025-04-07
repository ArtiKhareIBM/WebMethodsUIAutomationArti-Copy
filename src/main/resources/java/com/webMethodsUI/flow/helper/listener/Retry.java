package com.webMethodsUI.flow.helper.listener;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.webMethodsUI.flow.helper.javaScript.JavaScriptHelper;


public class Retry implements IRetryAnalyzer{
	
	private WebDriver driver;
	private int retryCount = 0;
	private int maxRetryCount = 2;
	
	private Logger log = LogManager.getLogger(Retry.class);

	
	
	@Override
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("arg0 is " +arg0.getStatus());
		if(retryCount<maxRetryCount) {
			log.info("Retrying test case " + "\"" +arg0.getName() + "\""  +" with status  " +getResultStatusName(arg0.getStatus()) +" For the " +(retryCount+1) +" times");
			retryCount++;
			return true;
		}
		return false;
	}
	
	
	public String getResultStatusName(int status) {
		String resultName = null;
		if(status == 1)
		{
			resultName = "SUCCESS";
		}
		if(status == 2) {
			resultName = "FAILURE";
		}
		if(status == 3)
		{
			resultName = "SKIP";
		}
		return resultName;
		
	}
	
	
	

}
