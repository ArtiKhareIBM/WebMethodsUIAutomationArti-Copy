package com.webMethodsUI.flow.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.webMethodsUI.flow.testbase.TestBase;

public class ExtentManager
{
	private static ExtentReports extent;
	private static ExtentSparkReporter htmlReporter ;
	
	private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "Report";
	private static String reportFileName ="IC Features UI Automation Report-"+todaysDate()+".html";
	private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
	
	public static ExtentReports getInstance() 
	{
		if(extent == null) 
		{
			return createInstance();
		}
		else {
			return extent;
		}
			
	}
	
	
	public synchronized static ExtentReports createInstance() 
	{
		
		 // ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		 String fileName = getReportPath(reportFilepath);
         htmlReporter = new ExtentSparkReporter(fileName);
       // extent = new ExtentReports();
        //extent.attachReporter(htmlReporter);
        
       // htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
      //  htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
       // htmlReporter.setAppendExisting(true);
        htmlReporter.config().enableTimeline(true);
        htmlReporter.config().setCSS(fileName);
 
//        extent.setSystemInfo("UI build version",System.getProperty("BuildVersion"));
//		extent.setSystemInfo("Selenium version",getConfigData("seleniumVersion"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Browser used",System.getProperty("Browser"));
		extent.setSystemInfo("Operating System",System.getProperty("os.name").toLowerCase());
		extent.setSystemInfo("HostName","WMIO");
		
        return extent;
		
	}
	
	   //Create the report path
    private static String getReportPath (String path) 
    {
    	File testDirectory = new File(path);
        if (!testDirectory.exists())
        {
        	if (testDirectory.mkdir())
        	{
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            }
        	else 
            {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } 
        else 
        {
            //System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
    
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

}
