package com.webMethodsUI.flow.helper.alert;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/** 
 * This class to handle javascript and window alerts
 * @author ABAC
 *
 */
public class AlertHelper {
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public Alert getAlert() {
		log.info("alert test: " +driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert() {
		log.info("Accepting the alert is done ...");
		getAlert().accept();
	}
	
	public void dissmissAlert() {
		log.info("Cancelling the alert is done....");
		getAlert().dismiss();
		
	}
	
	public String getAlertTest()
	{
		log.info("Getting the alert text..........");
		String text = getAlert().getText();
		log.info("Alert text is " +getAlert().getText());
		return text;
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			log.info("Alert is present....");
			return true;
		}
		catch(NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
			
		}
	}
	
	public void acceptAlertIfPresent()
	{
		if(isAlertPresent()) {
			acceptAlert();
		}
		else {
			log.info("Alert is not present");
		}
	}
	
	public void dissmissAlertIfPresent()
	{
		if(isAlertPresent())
		{
			dissmissAlert();
		}
		else
		{
			log.info("Alert is not present....");
		}
	}
	
	//send text to alert then accept the alert
	public void acceptAlertWithText(String text)
	{
		if(isAlertPresent())
		{
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert text: " +text);
		}
	}
	
	

}
