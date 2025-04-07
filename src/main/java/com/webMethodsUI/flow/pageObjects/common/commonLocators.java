package com.webMethodsUI.flow.pageObjects.common;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.webMethodsUI.flow.helper.wait.WaitHelper;

public class commonLocators {
	private WebDriver driver;
	private Logger log = LogManager.getLogger(commonLocators.class);
	WebElement element;

	WaitHelper waitHelper;

	/*
	 * @FindBy(xpath =
	 * "//p[text()='You have not created any parameters for this project.']")
	 * 
	 * @CacheLookup WebElement messageElemnt;
	 */
	
	public commonLocators(WebDriver driver) {
		super();
		this.driver = driver;

		PageFactory.initElements(driver, this);

	  }
	
	public String getNotificationMessage() {
		log.info("getting the text for success message...");
		WebElement messageElement = driver.findElement(By.xpath("//span[@class='notification-message'"));
		return messageElement.getText();
		
	}
	


	

	
	
}
