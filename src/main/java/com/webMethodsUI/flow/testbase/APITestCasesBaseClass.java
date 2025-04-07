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
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITestCasesBaseClass
{ 
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = LogManager.getLogger(APITestCasesBaseClass.class);
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
//		setUpDriver(ObjectReader.reader.getBrowserType()); 
		extentTest.set(test);
	} 
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, "<span style='font-weight:bold;style='font-size:30pt'>"+ method.getName() + "  test started</span>");
		extentTest.set(test);
	} 
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception 
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			captureConsoleMessages(driver,"\""+result.getMethod().getDescription()+"\"",currentBrowserType); 
//			APITestCasesBaseClass.getNavigationScreenOnFailure(driver);
			test.log(Status.FAIL, "<span style='font-weight:bold;style='font-size:30pt'>"+ result.getName() + "  is failed</span>");
			extentTest.set(test);
			APITestCasesBaseClass.logFailedExtentReport(result.getName());
			
		}
		
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, "<span style='font-weight:bold;style='font-size:30pt'>"+ result.getName() + "  is passed</span>");
			extentTest.set(test);
			APITestCasesBaseClass.logExtentReport(result.getName());
	//		TestBase.getNavigationScreen(driver);
			
		} 
		else if (result.getStatus() == ITestResult.SKIP) 
		{
			test.log(Status.SKIP, "<span style='font-weight:bold;style='font-size:30pt'>"+ result.getName() + "  is skipped</span>");
			extentTest.set(test);
			APITestCasesBaseClass.logSkipExtentReport(result.getName());
		}
		extent.flush();
	} 
	public  WebDriver getBrowserObject(BrowserType browserType) throws Exception 
	{
		APITestCasesBaseClass.currentBrowserType = browserType;
		try 
		{ 
			switch (browserType) 
			{
				case Chrome:
					// get Object of Chrome browser class
					@SuppressWarnings("deprecation") ChromeBrowser chrome = ChromeBrowser.class.newInstance();
					// set options for chrome browser
					ChromeOptions option = chrome.getChromeOptions();
					option.setAcceptInsecureCerts(true);
					option.addArguments("headless");
					option.addArguments("--window-size=1920x1080");
					option.addArguments("--remote-allow-origins=*");
					return chrome.getChromeDriver(option);
					
				case Firefox:
					@SuppressWarnings("deprecation") FireFoxBrowser firefox = FireFoxBrowser.class.newInstance();
					FirefoxOptions options = firefox.getFireFoxOptions();
					return firefox.getFireDriver(options); 
				case IEexplorer:
					@SuppressWarnings("deprecation") IEexplorerBrowser ie = IEexplorerBrowser.class.newInstance();
					//InternetExplorerOptions cap = ie.getIExplorerCapabilities();
					//return ie.getIExplorerDriver(cap); 
					
			default:
				throw new Exception("Driver not found: " + browserType.name()); 
				} 
			}   catch (Exception e) {
				log.info(e.getMessage());
				throw e; 
				} 
		} 
	
	// This method will launch the browser
	public void setUpDriver(BrowserType browserType) throws Exception 
	{
		driver = getBrowserObject(browserType);
		log.info(driver);
		log.info("Initilize Web Driver: " + driver.hashCode());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
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
				fileName = "blank";
			}
			File destFile = null;
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
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
			test.fail("Click on below button to expand screenshot: ",MediaEntityBuilder.createScreenCaptureFromBase64String(imgstr).build());
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
//		
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
		
		public static KeyStore generateKeystore(String keystoreFilePath,String keystorePassword)
		{
			KeyStore keyStore = null;
			SSLConfig config = null;
			try 
			{
		        keyStore = KeyStore.getInstance("jks");
		        keyStore.load(
		                new FileInputStream(keystoreFilePath),
		                keystorePassword.toCharArray());

		    } catch (Exception ex) {
		        System.out.println("Error while loading keystore >>>>>>>>>");
		        ex.printStackTrace();
		    }
				return keyStore;
		}
		
		public static void Make2waySSLInvocation(String URL,KeyStore keystore) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException
		{
			
			try
			{
				KeyStore keyStore = null;
			SSLConfig config = null;
			String keystorePassword = "changeit";
			int port = 8443;
			
			RestAssured.baseURI = URL;
			if (keystore != null) 
		    {

		        @SuppressWarnings("deprecation")
				org.apache.http.conn.ssl.SSLSocketFactory clientAuthFactory = new org.apache.http.conn.ssl.SSLSocketFactory(keyStore, keystorePassword);

		        // set the config in rest assured
		        config = new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames();
		
		    }
			RestAssured.config = RestAssuredConfig.config().sslConfig(config);
			
		
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.port(port);
		httpRequest.header("Content-Type","application/json");	
//		httpRequest.headers("Authorization","Basic "+base64EncodingString(ObjectReader.reader.getUserName(),ObjectReader.reader.getPassword())+"");
		
		//	httpRequest.auth().basic(ObjectReader.reader.getUserName(),ObjectReader.reader.getPassword());
		Response response = httpRequest.request(io.restassured.http.Method.POST);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String responseBody = response.getBody().asString();
		JsonPath responseJsonPath = new JsonPath(responseBody); 
		logExtentReport(responseBody);
		}
		catch(Exception e)
		{
			logFailedExtentReport(e.getMessage());
		}
		
		}	
}

