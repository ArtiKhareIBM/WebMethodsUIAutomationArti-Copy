package com.webMethodsUI.flow.testbase;


import java.io.File;

import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
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
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.utils.ExtentTestManager;

import net.bytebuddy.asm.Advice.Enter;

public class CommonActions extends TestBase
{
	private static Logger log = LogManager.getLogger(LoginPage.class);
	public static ExtentTest test;
	public WebDriver driver;

	//Find element
	public static WebElement findElement(String xpath,WebDriver driver) throws Exception
	{
		log.info("Fetching webelement at runtime "+xpath);
		logExtentReport("Fetching webelement at runtime "+xpath);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(TimeoutException.class)
				.ignoring(NullPointerException.class);

			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return element;
	}

	public static WebElement findElementBasedOnTime(String xpath,WebDriver driver, int  time) throws Exception
	{
		log.info("Fetching webelement at runtime "+xpath);
		logExtentReport("Fetching webelement at runtime "+xpath);
		
                //@SuppressWarnings("Convert2Diamond")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofMillis(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(TimeoutException.class)
				.ignoring(NullPointerException.class);

			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return element;
	}
	
	
	
	
	public static WebElement findElementByID(String ID,WebDriver driver) throws Exception
	{   
		log.info("Fetching webelement at runtime "+ID);
		logExtentReport("Fetching webelement at runtime "+ID);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(TimeoutException.class)
				.ignoring(NullPointerException.class);
		
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
			return element;
	}

	//Find elements
		public static List<WebElement> findElements(String xpath,WebDriver driver) throws Exception
		{
			log.info("Fetching webelement at runtime "+xpath);
			logExtentReport("Fetching webelement at runtime "+xpath);
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class)
					.ignoring(IndexOutOfBoundsException.class);

				List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
				return element;
		}

	public  void waitForElementVisible(WebElement element,WebDriver driver,String testCaseName) throws Exception
	{
		log.info(testCaseName);
		logExtentReport(testCaseName);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(TimeoutException.class)
				.ignoring(NullPointerException.class);

			wait.until(ExpectedConditions.visibilityOf(element));
			getNavigationScreen(driver);
	}


	//Method to type in textboxes
		public synchronized void enterValue(WebElement element,String text,WebDriver driver,String testCaseName) throws Exception
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);

				wait.until(ExpectedConditions.visibilityOf(element));
				element.sendKeys(text);
				getNavigationScreen(driver);
		}
		
		//Method to type in textboxes
				public synchronized void enterValue2(WebElement element,String text,WebDriver driver,String testCaseName) throws Exception
				{
					log.info(testCaseName);
					logExtentReport(testCaseName);

					Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
							.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
							.ignoring(StaleElementReferenceException.class)
							.ignoring(ElementClickInterceptedException.class)
							.ignoring(TimeoutException.class)
							.ignoring(NullPointerException.class);

						wait.until(ExpectedConditions.visibilityOf(element));
						element.sendKeys(text+""+Keys.ENTER);
						getNavigationScreen(driver);
				}

		//Clear and add text in text box
		public void clearAndEnterText(WebElement element,String data,WebDriver driver,String testCaseName) throws Exception
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
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
		public void clearTextBox(WebElement element,WebDriver driver,String testCaseName) throws Exception
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);

			wait.until(ExpectedConditions.visibilityOf(element));

			element.clear();
			getNavigationScreen(driver);
		}
		


		//Click on element
		public void click(WebElement element,WebDriver driver,String testCaseName) throws Exception
		{
			 log.info(testCaseName);
			 logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
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
		public void doubleClick(WebElement element,WebDriver driver,String testCaseName) throws Exception
		{

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);

				 wait.until(ExpectedConditions.visibilityOf(element));
				 wait.until(ExpectedConditions.elementToBeClickable(element));

				Actions actions = new Actions(driver);
				actions.doubleClick(element).build().perform();
				log.info(testCaseName);
				logExtentReport(testCaseName);
				getNavigationScreen(driver);
		}

		public void elementContainsText(WebElement element,String Expected,WebDriver driver, String testCaseName) throws Exception
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

			String actual = element.getText();

				if(actual.contains(Expected))
				{
					logExtentReport("Actual response contents: "+"<span style='font-weight:bold;'>"+Expected+"</span>"
															+" Expected contents : "+"<span style='font-weight:bold;'>"+Expected+"</span>");
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

		public void stringEquals(String actual,String Expected, WebDriver driver, String testCaseName) throws Exception
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
		public void waitForElementNotVisible(String xpath,WebDriver driver,String testCaseName) throws Exception
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);

				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
				getNavigationScreen(driver);
		}

		public void waitForElementLoaderNotVisible(String xpath,WebDriver driver,String testCaseName) throws Exception
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
		public void waitForElementNotVisible(String xpath,WebDriver driver,String testCaseName,int wait_Time) throws Exception
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
		
		//Wait for element invisibility
				public void waitForElementNotVisible(WebElement xpath,WebDriver driver,String testCaseName,int wait_Time) throws Exception
				{
					log.info(testCaseName);
					logExtentReport(testCaseName);

					Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(wait_Time))
							.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
							.ignoring(StaleElementReferenceException.class)
							.ignoring(ElementClickInterceptedException.class)
							.ignoring(TimeoutException.class)
							.ignoring(NullPointerException.class);

						//wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));
					    wait.until(ExpectedConditions.invisibilityOf(xpath));
						getNavigationScreen(driver);
				}

		public void waitForElementVisible(WebElement element,WebDriver driver,String testCaseName,int wait_time) throws Exception
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
		
		public static void elementNotVisible(String locator,WebDriver tempDriver,String testCaseName) throws Exception
		{
			Wait<WebDriver> wait = new FluentWait<WebDriver>(tempDriver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);		

			
				boolean test = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));

//				fluentWait(element, tempDriver, testCaseName);

				if(test!=false)
				{
					getNavigationScreen(tempDriver);
				}
				
				else
				{
					ExtentTestManager.getTest().fail(testCaseName);
					getNavigationScreen(tempDriver);
				}
			
		}
		public void selectUsingVisibleText(WebElement element,WebDriver driver, String visibleText,String testCaseName)
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
		
		public void isElementEnabled(WebElement element,WebDriver driver,String testCaseName)
		{
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);

			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isEnabled())
			{
				logExtentReport("<span style='font-weight:bold;style='font-size:30pt'>Element is enabled</span>");
				getNavigationScreen(driver);
			}
			else
			{
				logFailedExtentReport("<span style='font-weight:bold;style='font-size:30pt'>Element is disabled</span>");
				getNavigationScreenOnFailure(driver);

			}


		}
		
		public boolean isElementDisplayed(WebElement element,WebDriver driver,String testCaseName)
		{
			boolean result = false;
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);

			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed())
			{
				logExtentReport("<span style='font-weight:bold;style='font-size:50pt'>Element is displayed</span>");
				getNavigationScreen(driver);
				result=true;
			}
			else
			{
				logFailedExtentReport("<span style='font-weight:bold;style='font-size:50pt'>Element is not displayed</span>");
				getNavigationScreen(driver);
				result=false;
			}
			return result;

		}
		
		public void isElementDisabled(WebElement element,WebDriver driver,String testCaseName)
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
			if(element.isEnabled())
			{
				logFailedExtentReport("<span style='font-weight:bold;style='font-size:30pt'>Element is disabled</span>");

			}
			else
			{
				logExtentReport("<span style='font-weight:bold;style='font-size:30pt'>Element is enabled</span>");

			}


		}

		//Mouseover on element

		public void mousehover(WebElement element,WebDriver driver,String testCaseName) throws Exception
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
		
		public static void mouseHoverAndClick(WebElement element,WebDriver tempDriver,String testCaseName) throws Exception
		{    
			log.info(testCaseName);
			logExtentReport(testCaseName);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(tempDriver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(ElementClickInterceptedException.class)
					.ignoring(TimeoutException.class)
					.ignoring(NullPointerException.class);

			wait.until(ExpectedConditions.visibilityOf(element));

			   Actions builder = new Actions(tempDriver);
			   builder.moveToElement(element).click(element);    
			   builder.perform(); 
				getNavigationScreen(tempDriver);     
		}

		public void selectValueFromDropDown(WebElement element,String option,WebDriver driver,String testCaseName) throws Exception
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

				Select ddValue = new Select(element);
				ddValue.selectByVisibleText(option);
				getNavigationScreen(driver);
		}

		  public static void verifyDownloadedFile(String filename) throws InterruptedException
		    {
		        File file;
		        Thread.sleep(5000);
		        String filePath = System.getProperty("user.dir")+"//DownloadedFiles//";

		        try
		        {
//		            String tmpFolderPath = System.getProperty("java.io.tmpdir");
//		            String expectedFileName = "Some_file_name.ext";

		            file = new File(filePath + filename);


		            if (file.exists())
		            {
//		                file.delete();
//		                ExtentTestManager.getTest().pass("Downloaded File is Present and deleted");
		                log.info("Downloaded File is Present");
		    			logExtentReport("Downloaded File is Present");
		            }
		            else
		            {
//		                ExtentTestManager.getTest().fail("Error on deleting file. File may not be exist");
		                log.info("Downloaded File is not Present");
		                logFailedExtentReport("Downloaded File is not Present");
		            }
		        }
		        catch(Exception e)
		        {
//		            ExtentTestManager.getTest().fail("Error on deleting file.");
		            log.info("Error on searching for file.");
	    			logExtentReport("Error on searching for file.");
		        }
		    }
		  
		  public static void verifyDownloadedFilewithext(String fileExt) throws InterruptedException
		    {
		        File file;
		        Thread.sleep(5000);
		        String filePath = System.getProperty("user.dir")+"//DownloadedFiles//";

		        try
		        {
		            file = new File(filePath + fileExt);


		            if (file.exists())
		            {
//		                file.delete();
//		                ExtentTestManager.getTest().pass("Downloaded File is Present and deleted");
		                log.info("Downloaded File with ext is Present");
		    			logExtentReport("Downloaded File with ext is Present");
		            }
		            else
		            {
//		                ExtentTestManager.getTest().fail("Error on deleting file. File may not be exist");
		                log.info("Downloaded File is not Present");
		                logFailedExtentReport("Downloaded File is not Present");
		            }
		        }
		        catch(Exception e)
		        {
//		            ExtentTestManager.getTest().fail("Error on deleting file.");
		            log.info("Error on searching for file.");
	    			logExtentReport("Error on searching for file.");
		        }
		    }

		  public static void deleteDownloadedFile(String filename) throws InterruptedException
		    {
		        File file;
		        Thread.sleep(5000);
		        String filePath = System.getProperty("user.dir")+"//DownloadedFiles//";
		        try
		        {
//		            String tmpFolderPath = System.getProperty("java.io.tmpdir");
//		            String expectedFileName = "Some_file_name.ext";

		            file = new File(filePath + filename);

		            if (file.exists())
		            {
		                file.delete();
//		                ExtentTestManager.getTest().pass("Downloaded File is Present and deleted");
		                log.info("Downloaded File is Present and deleted");
		    			logExtentReport("Downloaded File is Present and deleted");
		            }
		            else
		            {
//		                ExtentTestManager.getTest().fail("Error on deleting file. File may not be exist");
		                log.info("Downloaded File is not Present");
		                logFailedExtentReport("Downloaded File is not Present to delete");
		            }
		        }
		        catch(Exception e)
		        {
//		            ExtentTestManager.getTest().fail("Error on deleting file.");
		            log.info("Error on deleting file.");
	    			logExtentReport("Error on deleting file.");
		        }
		    }
		  
		  public static void deleteDownloadedFiles() throws InterruptedException
		    {
		        File file;
		        String filePath = System.getProperty("user.dir")+"//DownloadedFiles//";
		        try
		        {
		            file = new File(filePath);
		            
		            FileUtils.cleanDirectory(file);
		            
		                log.info("Downloaded files folder is cleanedup");
		    			logExtentReport("Downloaded files folder is cleanedup");
		  
		        }
		        catch(Exception e)
		        {
//		            ExtentTestManager.getTest().fail("Error on deleting file.");
		            log.info("Error on cleaning up downloadedfiles directory.");
	    			logExtentReport("Error on cleaning up downloadedfiles directory..");
		        }
		    }


		//Scroll page to the element
          public static void scrollPageToElement(WebDriver driver,WebElement element) throws Exception
          {
              try
              {
                  Actions actions = new Actions(driver);
                  actions.moveToElement(element).build().perform();
                  log.info("Scroll page to the element");
                  logExtentReport("Scroll page to the element");
                  getNavigationScreen(driver);
              }
              catch(Exception e)
              {
                  log.info("<span style='font-weight:bold;'>"+e.getMessage()+"</span>");
                  logExtentReport("<span style='font-weight:bold;'>"+e.getMessage()+"</span>");
                  getNavigationScreenOnFailure(driver);
                  Assert.fail("Element with XPATH: "+element+" not visible to scroll");
              }
          }

          //Scroll page down according to the passed int count
          public static void scrollPageDown2(WebDriver tempDriver,int count)
          {
              Actions a = new Actions(tempDriver);



            try
              {
                  for(int i=0;i<=count;i++)
                  {
                      a.sendKeys(Keys.ARROW_DOWN).build().perform();
                  }



                 log.info("Scroll page down");
                  logExtentReport("Scroll page down");

              }
              catch(Exception e)
              {
                    log.info("Couldn't Scroll page down");
                      logExtentReport("Couldn't Scroll page down");
                      }
          }

		  public static void verifyValueIsGreater(int value1, int value2,WebDriver driver,String testCaseName) throws Exception
          {
              try
              {
                  if (value2>value1)
                  {
                       log.info(testCaseName);
                       logExtentReport(testCaseName);
                       getNavigationScreen(driver);
                  }
                  else
                  {
                       log.error(testCaseName);
                       logFailedExtentReport(testCaseName);
                       getNavigationScreenOnFailure(driver);
                  }
              }
              catch(Exception e)
              {
                   log.info("<span style='font-weight:bold;'>"+e.getMessage()+"</span>");
                   logFailedExtentReport("<span style='font-weight:bold;'>"+e.getMessage()+"</span>");
                   getNavigationScreenOnFailure(driver);
              }

          }

      public static String getText(WebElement element,WebDriver driver,String testCaseName) throws Exception
      {
          try
          {
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                      .pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
                      .ignoring(StaleElementReferenceException.class)
                      .ignoring(ElementClickInterceptedException.class)
                      .ignoring(TimeoutException.class)
                      .ignoring(NullPointerException.class);

              wait.until(ExpectedConditions.visibilityOf(element));


            if (element.getText()==null)
              {
                 log.error(testCaseName);
                 logFailedExtentReport(testCaseName);
                 getNavigationScreenOnFailure(driver);

             }
              else
              {
                  log.info(testCaseName);
                   logExtentReport(testCaseName);
                   getNavigationScreen(driver);

              }

          }
          catch(Exception e)
          {
              log.error(testCaseName);
              logFailedExtentReport("<span style='font-weight:bold;'>"+e.getMessage()+"</span>");
              getNavigationScreenOnFailure(driver);
          }

          return element.getText();
      }

}
