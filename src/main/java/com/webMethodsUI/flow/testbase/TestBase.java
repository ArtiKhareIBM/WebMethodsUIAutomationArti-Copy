package com.webMethodsUI.flow.testbase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.webMethodsUI.flow.helper.browserConfigurations.BrowserType;
import com.webMethodsUI.flow.helper.browserConfigurations.ChromeBrowser;
import com.webMethodsUI.flow.helper.browserConfigurations.FireFoxBrowser;
import com.webMethodsUI.flow.helper.browserConfigurations.IEexplorerBrowser;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.browserConfigurations.config.PropertyReader;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.utils.ExtentManager;



public class TestBase
{ 
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = LogManager.getLogger(TestBase.class);
	public static File reportDirectory; 
	
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static BrowserType currentBrowserType;
	
	//File seprator variable 
	public static String fileSeperator = System.getProperty("file.separator");
	
	@BeforeSuite
	public void beforeSuite() 
	{  
		extent = ExtentManager.getInstance();
	} 
	
	// Before running all the tests this beforeTest will be called and browser will get intilialized
	@BeforeTest
	public void beforeTest() throws Exception 
	{
		ObjectReader.reader = new PropertyReader();
		reportDirectory = new File(ResourceHelper.getResourcePath("/src/main/resources/screenshots"));
//		setUpDriver(ObjectReader.reader.getBrowserType()); 
	} 
	
	@BeforeClass
	public void beforeClass() throws Exception 
	{
		test = extent.createTest(getClass().getSimpleName());
		setUpDriver(ObjectReader.reader.getBrowserType()); 
		extentTest.set(test);
	} 
	
	@BeforeMethod
	public void beforeMethod(Method method) 
	{
		test.log(Status.INFO, "<span style='font-weight:bold;style='font-size:50pt'>"+ method.getName() + "  test started</span>");
		extentTest.set(test);
	} 
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception 
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			Throwable t= result.getThrowable();
			TestBase.getNavigationScreenOnFailure(driver);
			TestBase.logFailedExtentReport(t.getMessage());
//			captureConsoleMessages(driver,"\""+result.getMethod().getDescription()+"\"",currentBrowserType); 
//			test.log(Status.FAIL, "<span style='font-weight:bold;style='font-size:30pt'>"+ result.getName() + "  is failed</span>" );
//			extentTest.set(test);
			TestBase.logFailedExtentReport("<span style='font-weight:bold;style='font-size:50pt'>"+ result.getName() + " is Failed</span>");
			TestBase.logFailedExtentReport("-----------------------------");
		}
		
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, "<span style='font-weight:bold;style='font-size:50pt'>"+ result.getName() + "  is passed</span>");
			extentTest.set(test);
//			TestBase.logExtentReport("<span style='font-weight:bold;style='font-size:50pt'>"+ result.getName() + "  is passed</span>");
			TestBase.logExtentReport("-----------------------------");
			//		TestBase.getNavigationScreen(driver);
			
		} 
		else if (result.getStatus() == ITestResult.SKIP) 
		{
//			test.log(Status.SKIP, "<span style='font-weight:bold;style='font-size:30pt'>"+ result.getName() + "  is skipped</span>");
//			extentTest.set(test);
			TestBase.logSkipExtentReport("<span style='font-weight:bold;style='font-size:30pt'>"+ result.getName() + "  is skipped</span>");
		}
		extent.flush();
	} 
	public  WebDriver getBrowserObject(String browserType) throws Exception 
	{
		//TestBase.currentBrowserType = browserType;
		try 
		{ 
			switch (browserType.toLowerCase())
			{
			case  "firefox":
				//LogManager.getLogger("org.openqa.selenium.remote").log;
				FirefoxOptions ff1 = new FirefoxOptions();
				//((ChromiumOptions<ChromeOptions>) ff1).setExperimentalOption("ExcludeSwitches", Collections.singletonList("enable-automation"));
				ff1.addArguments("--window-size=1920,1080");
				ff1.addArguments("--disable-extensions");
				ff1.addArguments("--log-level=3");
				ff1.addArguments("--silent");
				
				//String geckoDriverPath = System.getProperty("user.dir")+"/BrowserDrivers/GeckoDriver.exe";
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,System.getProperty("user.dir")+fileSeperator+"FirefoxDriverlogs.logs");
				//System.setProperty("webdriver.gecko.driver", geckoDriverPath);
				//WebDriverManager.firefoxdriver().setup();
				//driver = new FirefoxDriver(ff1);
					 
				return new FirefoxDriver();

			case   "firefoxheadless":
				//Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
				FirefoxOptions ff2 = new FirefoxOptions();
				ff2.addArguments("-headless");
				//String geckoDriverPath1 = System.getProperty("user.dir")+"/BrowserDrivers/GeckoDriver.exe";
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,System.getProperty("user.dir")+fileSeperator+"FirefoxDriverlogs.logs");
				///System.setProperty("webdriver.gecko.driver", geckoDriverPath1);
				return new FirefoxDriver(ff2);

			case   "chrome":
				//String browser = getInputData("browser");
				//Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
				//System.setProperty("webdriver.chrome.driver",absoluteFilePath(fileSeperator+"BrowserDrivers"+fileSeperator+getInputData("browser")).getAbsolutePath());	
				//System.setProperty("webdriver.chrome.args", "--disable-logging");
				//System.setProperty("webdriver.chrome.silentOutput", "true");	
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory",absoluteFilePath(fileSeperator+"DownloadedFiles").getAbsolutePath());
				ChromeOptions c1 = new ChromeOptions();
				//c1.setExperimentalOption("prefs", prefs);
				//c1.addArguments("--remote-allow-origins=*");
				c1.addArguments("--window-size=1920,1080");
//				c1.addArguments("--incognito");
				c1.addArguments("--disable-extensions");
				c1.addArguments("--log-level=3");
				c1.addArguments("--silent");
				c1.addArguments("--disable-infobars");	
				//c1.setExperimentalOption("ExcludeSwitches", Collections.singletonList("enable-automation"));
//				c1.addArguments("--profile-directory=AutoUser");
				
				//if(getCurrentPlatform().contains("Windows"))
				//{
				//	c1.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
				//}
				return new ChromeDriver(c1);

			case   "chromeheadless":
				//Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
				//System.setProperty("webdriver.chrome.driver", absoluteFilePath(fileSeperator+"BrowserDrivers"+fileSeperator+getInputData("browser")).getAbsolutePath());
				//System.setProperty("webdriver.chrome.args", "--disable-logging");
				//System.setProperty("webdriver.chrome.silentOutput", "true");
				Map<String, Object> prefs2 = new HashMap<String, Object>();
				prefs2.put("download.default_directory",absoluteFilePath("/DownloadedFiles").getAbsolutePath());
				ChromeOptions c2 = new ChromeOptions();
				c2.setExperimentalOption("prefs", prefs2);
				//c2.addArguments("--remote-allow-origins=*");
				c2.addArguments("--headless");
				c2.addArguments("--no-sandbox");
				c2.addArguments("--disable-gpu");
				c2.addArguments("--window-size=1920,1080");
				c2.addArguments("--incognito");
				c2.addArguments("--disable-extensions");
				c2.addArguments("--log-level=3");
				c2.addArguments("--silent");
				c2.addArguments("--disable-infobars");
				//if(getCurrentPlatform().contains("Windows"))
				//{
				//	c2.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
				//}
				return new ChromeDriver(c2);
				
			case   "localchrome":
				//Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
				//System.setProperty("webdriver.chrome.driver",absoluteFilePath(fileSeperator+"BrowserDrivers"+fileSeperator+getInputData("browser")).getAbsolutePath());	
				System.setProperty("webdriver.chrome.args", "--disable-logging");
				System.setProperty("webdriver.chrome.silentOutput", "true");				
				Map<String, Object> prefs3 = new HashMap<String, Object>();
				prefs3.put("download.default_directory",absoluteFilePath(fileSeperator+"DownloadedFiles").getAbsolutePath());
				ChromeOptions c3 = new ChromeOptions();
				c3.setExperimentalOption("debuggerAddress", "localhost:8090");
				c3.addArguments("--window-size=1920,1080");
				//c1.addArguments("--incognito");
				c3.addArguments("--disable-extensions");
				c3.addArguments("--log-level=3");
				c3.addArguments("--silent");
				c3.addArguments("--disable-infobars");			   
				if(getCurrentPlatform().contains("Windows"))
				{
					c3.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
				}
				return new ChromeDriver(c3);

			default: throw new Exception("Invalid driver type " + browserType + "!");
			}
		 

			}   catch (Exception e) {
				log.info(e.getMessage());
				throw e; 
				} 
		} 
	
	// This method will launch the browser
	public void setUpDriver(BrowserType browserType) throws Exception 
	{
//		String chromeDriverVersion = "89.0.4389.23"; 
//		WebDriverManager.chromedriver().browserVersion(chromeDriverVersion).setup();
		//WebDriverManager.chromedriver().clearDriverCache().setup();
		//WebDriverManager.chromedriver().setup();
		@SuppressWarnings("deprecation") ChromeBrowser chrome = ChromeBrowser.class.newInstance();
		// set options for chrome browser
		ChromeOptions option = chrome.getChromeOptions();
		option.setAcceptInsecureCerts(true);
//		option.addArguments("headless");
		option.addArguments("--start-maximized");
//		option.addArguments("--window-size=1920x1080");
		option.addArguments("--remote-allow-origins=*");
		
        driver = new ChromeDriver(option);
		
//         driver = getBrowserObject(browserType);
        
		log.info(driver);
		log.info("Initilize Web Driver: " + driver.hashCode());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
	} 
	
	
	public static String captureScreen(String fileName, WebDriver driver) 
	{
		String imgstr = null;
		try 
		{
			if (driver == null)
			{
				//log.info("driver is null");
				return null;
			}
			if (fileName == "") {
				fileName = "Screenshot";
			}
			File destFile = null;
			Calendar calendar = Calendar.getInstance();
//			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss_SS");
			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_hh_mm_ss_SS");
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
			destFile = new File(reportDirectory + "/" + fileName + "_" + formatter.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
			+ "'height='100' width='100'/></a>"); 
			imgstr = imageToBase64String(destFile.getAbsolutePath());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return imgstr; 
	}
	
	public static void logExtentReport(String logInfo)
	{
		test.log(Status.INFO, logInfo); 
		extentTest.set(test);
	}
	
	public static void logSkipExtentReport(String logInfo)
	{
		test.log(Status.SKIP, logInfo); 
		extentTest.set(test);
	} 
	
	public static void logFailedExtentReport(String logInfo)
	{
		test.log(Status.FAIL, logInfo); 
		extentTest.set(test);
	}

	
	//Convert image to base64 string
		public static String imageToBase64String(String filePath)
		{
			String base64 = "";
	
			try
			{
				InputStream iSteamReader = new FileInputStream(filePath);
				byte[] imageBytes = IOUtils.toByteArray(iSteamReader);
				base64 = Base64.getEncoder().encodeToString(imageBytes);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	
			return base64;
		}
	public synchronized void getApplicationUrl(String url) 
	{
		log.info("Navigating to URL" +url);
		logExtentReport("Navigating to......." +url);
		driver.get(url); 
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}
	
	public static void getNavigationScreen(WebDriver driver) 
	{
		
		//log.info("capturing ui navigation screen");
		String imgstr = captureScreen("", driver); 
		try {
			test.info("<span style='font-weight:bold;style='font-size:30pt'>Expand screenshot: </span>",MediaEntityBuilder.createScreenCaptureFromBase64String(imgstr).build());
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
		}
	}
	
	public static void getNavigationScreenOnFailure(WebDriver driver) 
	{
		//log.info("capturing ui navigation screen");
		String imgstr = captureScreen("", driver); 
		try {
			test.fail("<span style='font-weight:bold;style='font-size:30pt'>Expand screenshot: </span>",MediaEntityBuilder.createScreenCaptureFromBase64String(imgstr).build());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	//Method to return absolute file path based on environment
	public static File absoluteFilePath(String relativeFilePath)
	{
		File file = null; 
	
		if(getCurrentPlatform().contains("Windows"))
		{
			file = new File(System.getProperty("user.dir")+relativeFilePath);
		}
		else if(getCurrentPlatform().contains("nix")||getCurrentPlatform().contains("nux")||getCurrentPlatform().contains("aix"))
		{
			file = new File(System.getProperty("user.dir")+relativeFilePath);
		}
		else if(getCurrentPlatform().contains("mac"))
		{
			file = new File(System.getProperty("user.home")+relativeFilePath);
		}
	
		return file;
	}
	
	//Method to fetch current platform
	public static String getCurrentPlatform()
	{
		return System.getProperty("os.name");
	}
	
//	 private int count = 0; 
//
//	  private int maxCount = 1;
//
//	  @Override
//	  public boolean retry(ITestResult result) { 
//
//	    if(count < maxCount) {  
//
//	       count++;
//
//	       return true;        
//
//	    }        
//
//	    return false; 
//	  }
//	  
	  	//Capture all JS console messages
		public static void captureConsoleMessages(WebDriver driver,String testCaseName,BrowserType browser) throws Exception
		{ 
		try
		{
			switch (browser) 
			{
				case Chrome:
					    //Collect console errors if any
						LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

						if(logEntries.getAll().size()!=0)
						{
							//Create file
							//File file = new File(System.getProperty("user.dir")+"/ConsoleMessages/allConsoleMessages.html");
							File file = new File(absoluteFilePath(fileSeperator+"ConsoleMessages"+fileSeperator+"allConsoleMessages.html").getAbsolutePath());
							FileWriter fileWrite = new FileWriter(file, true);
							BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);

							//Create printwriter object
							PrintWriter write = new PrintWriter(bufferedWrite);
							file.createNewFile();
							write.flush();
							write.println("<TABLE border=1 width = 100%><TR><TH bgcolor="+"#644987"+"  width="+"5%"+"><font color="+"white"+">Log Level</font></TH><TH bgcolor="+"#644987"+" width="+"95%"+"><font color="+"white"+">Console messages after executing "+testCaseName+" test case</font></TH></TR>");

							for (LogEntry entry : logEntries) 
							{
								write.println("<TR><TD Align=Center><PRE>"+entry.getLevel()+"</PRE></TD><TD><PRE>"+entry.getMessage()+"</PRE></TD></Tr>");  
							}

							write.println("</TABLE><br><hr><br>");
							write.close(); 
							test.log(Status.FAIL,"ConsoleError Link : <a href='"+file+"'>ConsoleError Link</a>");
						}
						else
						{
							//File file = new File(System.getProperty("user.dir")+"/ConsoleMessages/allConsoleMessages.html");
							File file = new File(absoluteFilePath(fileSeperator+"ConsoleMessages"+fileSeperator+"allConsoleMessages.html").getAbsolutePath());
							FileWriter fileWrite = new FileWriter(file, true);
							BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);

							//Create printwriter object
							PrintWriter write = new PrintWriter(bufferedWrite);
							file.createNewFile();
							write.flush();
							write.println("<TABLE border=1 width = 100%><TR><TH bgcolor="+"#644987"+" width="+"5%"+"><font color="+"white"+">Log Level</font></TH><TH bgcolor="+"#644987"+" width="+"95%"+"><font color="+"white"+">Console messages after executing "+testCaseName+" test case</font></TH></TR>");
							write.println("<TR><TD Align=Center colspan="+"2"+"><PRE>NO CONSOLE MESSAGES FOUND</PRE></TD></Tr>");
							write.println("</TABLE><br><hr><br>");
							write.close();
							
							test.log(Status.FAIL,"ConsoleError Link : <a href='"+file+"'>ConsoleError Link</a>");
						}
						
				  default:	throw new Exception("Driver not found: " + browser.name()); 
				}
			}
				catch(Exception e)
				{
					System.out.println("Unable to write console error messages in file" +e.getMessage());
				}  
			}
				
		//Clear console error text file
		public static void clearTheFile() throws IOException 
		{
			FileWriter fwOb = new FileWriter(System.getProperty("user.dir")+fileSeperator+"ConsoleMessages"+fileSeperator+"allConsoleMessages.html", false); 
			PrintWriter pwOb = new PrintWriter(fwOb, false);
			pwOb.flush();
			pwOb.close();
			fwOb.close();
		}
		
		@AfterClass
		public void afterTest() 
		{		
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
		}
		
		public static String base64EncodingString(String userName,String userPassword)
		{
				 String encodedString = null;

			try
			{
				Base64.Encoder encoder = Base64.getEncoder();
				String normalString = ""+userName+":"+userPassword+"";
				encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
			}
			catch(Exception e)
			{
			System.out.println(e.getMessage());
			}
		
			return encodedString;
		}
	
		
		//Return todays date
		public static String todaysDate()
		{
			DateFormat currentDate;
			Calendar currentMonth;
			DateFormat currentYear;
			String date;

			currentDate = new SimpleDateFormat("dd");
			currentMonth = Calendar.getInstance();
			currentYear = new SimpleDateFormat("yyyy");
			date = currentDate.format(new Date())+new SimpleDateFormat("MMM").format(currentMonth.getTime())+currentYear.format(new Date()).toString();

			return date.toString();
		}
		
		@AfterSuite
		public void afterSuite() 
		{  
			extent.flush();
		} 
		
}