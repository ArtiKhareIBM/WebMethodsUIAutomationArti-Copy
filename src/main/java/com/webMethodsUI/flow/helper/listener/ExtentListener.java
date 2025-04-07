package com.webMethodsUI.flow.helper.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.webMethodsUI.flow.utils.ExtentManager;
import com.webMethodsUI.flow.utils.ExtentTestManager;

//listen events and log extent report
public class ExtentListener extends  ExtentTestManager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result)
	{
		ExtentTestManager.startTest(result.getMethod().getDescription());
		
		//Assign test category
		for (String group : result.getMethod().getGroups())
		{
			test.assignCategory(group);
		}	
	}

	@Override
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("");
		System.out.println(Result.getMethod().getDescription()+" : PASSED");
		System.out.println("");
	}

	@Override
	public void onTestFailure(ITestResult Result) 
	{
		System.out.println("");
		System.out.println(Result.getMethod().getDescription()+" : FAILED");
		System.out.println("");
		
//		Reporter.setCurrentTestResult(Result);
//		if(Result.getMethod().getRetryAnalyzer().retry(Result))
//			Result.setStatus(ITestResult.SKIP);
//		Reporter.setCurrentTestResult(null);
		
	}

	@Override
	public void onTestSkipped(ITestResult Result) 
	{
		System.out.println("");
        ExtentTestManager.startTest(Result.getMethod().getDescription());
		
		//Assign test category
		for (String group : Result.getMethod().getGroups())
		{
			test.assignCategory(group);
		}	
		
		System.out.println(Result.getMethod().getDescription()+" : SKIPPED");
		ExtentTestManager.getTest().log(Status.SKIP, "TEST CASE SKIPPED DUE TO FAILURES IN PREVIOUS TESTS");
		System.out.println("");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
}
