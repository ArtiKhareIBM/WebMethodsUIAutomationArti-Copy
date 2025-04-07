package com.webMethodsUI.flow.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WaitHelper {
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(WaitHelper.class);


	public WaitHelper(WebDriver driver) {
		super();
		this.driver = driver;
		log.info("WaitHelper Object created....");
	}

	/**
	 * This is implicitWait method
	 * @param i
	 * @param unit
	 */
	
	public void setImplicitWait(long i, TimeUnit unit)
	{
		log.info("Implicit wait has been set to: " +i);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}
	
	/**
	 * This will help us to get WebDriver wait object
	 * @param TimeOutInSeconds
	 * @param pollingEveryMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryMiliSec) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.pollingEvery(Duration.ofMillis(pollingEveryMiliSec));
		//igonre the below exceptions untill the mentioned time(wait)
		//wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
		
	}
	/**
	 * This method will make sure elemnt is visible
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryMiliSec
	 */
	
	public void waitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryMiliSec)
	{
		log.info("waiting for: " +element +" for" +timeOutInSeconds +" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryMiliSec);
		wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Elemnt is visible now");
	}
	
	
	/**
	 * This method will makes element is clickable
	 * @param element
	 * @param timeOutInSeconds
	 */
	
	public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
		
		log.info("waiting for: " +element +" for" +timeOutInSeconds +" seconds");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Elemnt is clickable now");
	}
	
	/**
	 * wait untill perticular element dissappear
     * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForElementNotPresent(WebElement element, int timeOutInSeconds) {
		log.info("waiting for: " +element +" for" +timeOutInSeconds +" seconds");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Elemnt is invisible now");
		return status;
	
		
	}
	/**
	 * Wait for untill frame is switched
	 * @param element
	 * @param timeOutInSeconds
	 */
	
	public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds) {
		log.info("waiting for: " +element +" for" +timeOutInSeconds +" seconds");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is available now and switched");
		
	}
	
	/**
	 * This method will give us FluentWait Object
	 * @param timeOutInSeconds
	 * @param pollingEveryMiliSec
	 * @return
	 */
	private FluentWait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryMiliSec)
	{
		 FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(timeOutInSeconds))
				 .pollingEvery(Duration.ofMillis(pollingEveryMiliSec)).ignoring(NoSuchElementException.class);
		 return fwait;
	}
	
	
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryMiliSec) {
		
		FluentWait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryMiliSec);
        fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
		
	}
	
	
	public void waitForElement(WebElement element, int timeOutInSeconds)
	{
		log.info("waiting for :" +element.toString() +" for :" +timeOutInSeconds +"seconds");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now.....");
	}
	
	public void pageLoadTime(long timeout, TimeUnit unit) {
		log.info("Wait for page to load for:  " +unit +"  seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
		
		
	}
	
	public static void waitForElementVisible(String locator,WebDriver dr,String testCaseName) throws Exception 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(90));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			 
			
		} 
		catch (TimeoutException e) 
		{
			
		}	
	 }

	
	
	

}
