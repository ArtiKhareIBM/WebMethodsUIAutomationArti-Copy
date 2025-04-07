package com.webMethodsUI.flow.testbase;


import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.webMethodsUI.flow.pageObjects.common.LoginPage;

public class CommonActions extends TestBase
{
	private static Logger log = LogManager.getLogger(LoginPage.class);
	public static ExtentTest test;
	public WebDriver driver;
	
	//Find element
	public static WebElement findElement(String xpath,WebDriver driver) throws Exception
	{   
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(TimeoutException.class)
				.ignoring(NullPointerException.class);
		
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return element;
	}
	
	//Find elements
		public static List<WebElement> findElements(String xpath,WebDriver driver) throws Exception
		{   
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
				List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
				return element;
		}
	
	public static void waitForElementVisible(WebElement element,WebDriver driver,String testCaseName) throws Exception 
	{
		log.info(testCaseName);
		logExtentReport(testCaseName);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(TimeoutException.class)
				.ignoring(NullPointerException.class);
		
			wait.until(ExpectedConditions.visibilityOf(element)); 
			getNavigationScreen(driver);
	}
	
	
	//Method to type in textboxes
		public static void enterValue(WebElement element,String text,WebDriver driver,String testCaseName) throws Exception 
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
				wait.until(ExpectedConditions.visibilityOf(element)); 
				element.sendKeys(text);
				getNavigationScreen(driver);
		}	
		
		//Clear and add text in text box
		public static void clearAndEnterText(WebElement element,String data,WebDriver driver,String testCaseName) throws Exception
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
			wait.until(ExpectedConditions.visibilityOf(element)); 
			
			element.clear();
			element.sendKeys(data);
			getNavigationScreen(driver);
		}
		
		//Clear text in text box
		public static void clearTextBox(WebElement element,WebDriver driver,String testCaseName) throws Exception
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
			wait.until(ExpectedConditions.visibilityOf(element)); 
			
			element.clear();
			getNavigationScreen(driver);
		}

		//Click on element
		public static void click(WebElement element,WebDriver driver,String testCaseName) throws Exception
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
				 wait.until(ExpectedConditions.visibilityOf(element)); 
				 wait.until(ExpectedConditions.elementToBeClickable(element));
				 
				 Actions action = new Actions(driver);
				 action.click(element).build().perform();  
				getNavigationScreen(driver);
		}
		
		//Double click on element
		public static void doubleClick(WebElement element,WebDriver driver,String testCaseName) throws Exception
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
				 wait.until(ExpectedConditions.visibilityOf(element)); 
				 wait.until(ExpectedConditions.elementToBeClickable(element));
				 
				Actions actions = new Actions(driver);
				actions.doubleClick(element).build().perform();          
				getNavigationScreen(driver);
		}
		
		public static void elementContainsText(WebElement element,String Expected,WebDriver driver, String testCaseName) throws Exception
		{
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
			wait.until(ExpectedConditions.visibilityOf(element)); 
				 
			String actual = element.getText(); 
			
				if(actual.contains(Expected))
				{
					log.info(testCaseName);
					logExtentReport(testCaseName);
					
					logExtentReport("Actual response contents: "+"<span style='font-weight:bold;'>"+Expected+"</span>"
															+"Expected contents : "+"<span style='font-weight:bold;'>"+Expected+"</span>");
					getNavigationScreen(driver);
				}
				else
				{
					logFailedExtentReport(testCaseName);
					logExtentReport("Actual response contents : "+"<span style='font-weight:bold;'>"+actual+"</span>"
								+"Expected contents : "+"<span style='font-weight:bold;'>"+Expected+"</span>");
					getNavigationScreen(driver);
					Assert.assertEquals(actual, Expected);
				}
		}
		
		public static void stringEquals(String actual,String Expected, WebDriver driver, String testCaseName) throws Exception
		{
				if(actual.contains(Expected))
				{
					log.info(testCaseName);
					logExtentReport(testCaseName);
					logExtentReport("Actual response contents: "+"<span style='font-weight:bold;'>"+Expected+"</span>"
															+"Expected contents : "+"<span style='font-weight:bold;'>"+Expected+"</span>");
					getNavigationScreen(driver);
				}
				else
				{
					logFailedExtentReport(testCaseName);
					logExtentReport("Actual response contents : "+"<span style='font-weight:bold;'>"+actual+"</span>"
								+"Expected contents : "+"<span style='font-weight:bold;'>"+Expected+"</span>");
					getNavigationScreen(driver);
					Assert.assertEquals(actual, Expected);
				}
		}
		
		//Wait for element invisibility
		public static void waitForElementNotVisible(String xpath,WebDriver driver,String testCaseName) throws Exception
		{   
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
				getNavigationScreen(driver);
		}
		
		//Wait for element invisibility
		public static void waitForElementNotVisible(String xpath,WebDriver driver,String testCaseName,int wait_Time) throws Exception
		{ 
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(wait_Time))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
				getNavigationScreen(driver);
		}
		
		public static void waitForElementVisible(WebElement element,WebDriver driver,String testCaseName,int wait_time) throws Exception 
		{ 	
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(wait_time))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
				wait.until(ExpectedConditions.visibilityOf(element)); 
				getNavigationScreen(driver);
		}
		
		public static void selectUsingVisibleText(WebElement element,WebDriver driver, String visibleText,String testCaseName) 
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
			wait.until(ExpectedConditions.visibilityOf(element)); 
			 
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
			getNavigationScreen(driver);
		}
		
		//Mouseover on element
		
		public static void mousehover(WebElement element,WebDriver driver,String testCaseName) throws Exception
		{ 	
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);
			
			wait.until(ExpectedConditions.visibilityOf(element)); 

				Actions a = new Actions(driver);
				a.moveToElement(element).build().perform();
				getNavigationScreen(driver);
		}
		
}
