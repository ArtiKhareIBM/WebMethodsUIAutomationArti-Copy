package com.webMethodsUI.flow.helper.logger;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;

//This class helps for logging for any class in the framework
public class LoggerHelper {
	
	private static boolean root=false;
	
	public static Logger getLogger(Class cls)
	{
		//if logger is created by some class or utility
		if(root)
		{
			return Logger.getLogger(cls);
		}
		//If no logger defined by any class then define the logger
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(cls);
		
	}
	
	/*
	 * public static void main(String[] args) { Logger log =
	 * LogManager.getLogger(LoggerHelper.class);
	 * log.info("logger is configured1"); log.info("logger is configured2");
	 * log.info("logger is configured3"); log.info("logger is configured4");
	 * System.out.println(ResourceHelper.getResourcePath(
	 * "src/main/resources/configfile/log4j.properties"));
	 * 
	 * }
	 */
}
