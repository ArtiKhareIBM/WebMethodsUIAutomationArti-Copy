package com.webMethodsUI.flow.helper.javaScript;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.webMethodsUI.flow.helper.wait.WaitHelper;

public class JavaScriptHelper {

	private WebDriver driver;
	private Logger log = LogManager.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		super();
		this.driver = driver;
		log.info("JavaScriptHelper has been initialized");
	}

	public Object executeScript(String script) {

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);

	}

	public Object executeScript(String script, Object... args) {

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);

	}

	public void scollToElement(WebElement element) {
		log.info("Scroll to WebElement");
		executeScript("window.scollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);

	}

	// scolling based on we co ordinates
	public void scrollToElementAndClick(WebElement element) {
		try {
			scrollToElementAndClick(element);
			element.click();
			log.info("Scolled to element and clicked. element is " + element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// scolling not based on web co ordinates
	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scollIntoView()", element);
		log.info("Scolled to element and clicked. element is " + element);

	}
	
	
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("Scolled to element and clicked. element is " + element);
	
	}
	
	
	
	public void scrollDownVertically()
	{
		log.info("Scolling vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight");
	}
	
	
	
	public void scrollUpVertically()
	{
		log.info("scolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight");
	}
	
	public void scrollDownByPixel(int pixel)
	{
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel)
	{
		executeScript("window.scrollBY(0,-"+pixel+")");
	}
	
	
	public void zoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100%' ");
	}
	
	public void zoomInBy60Percentage() {
		executeScript("document.body.style.zoom='60%' ");
	}
	
	public void clickElement(WebElement element)
	{
		executeScript("arguments[0].click()", element);
	}

    


}
