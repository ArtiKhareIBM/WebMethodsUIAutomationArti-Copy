package com.webMethodsUI.flow.pageObjects.monitor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class MonitorPageFilter extends CommonActions{
	private WebDriver driver;
	WaitHelper waitHelper;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public MonitorPageFilter(WebDriver driver) {
		super();
		this.driver = driver;

		logExtentReport("Monitor page filter created");
	}
	
	public void clickOnMonitorFilter(String filter) throws Exception 
	{
		WebElement element = findElement("//*[contains(text(),'" + filter + "')]",driver);
		click(element,driver,"Clicking on filter " + filter);
		//waitForElementNotVisible(loader, driver, "wait for page load");
	}
	
	public void SelectExecutionsource(String ExecSource) throws Exception
    {
 
		WebElement element = findElement("//*[contains(text(),'" + ExecSource + "')]",driver);
		click(element,driver,"Clicking on filter " + ExecSource);
     
    }
	public void SelectProject(String Projectname) throws Exception
    {
		Thread.sleep(5000);
		WebElement element = findElement("//*[contains(text(),'" + Projectname + "')]",driver);
		click(element,driver,"Clicking on filter " + Projectname);
     
    }
	public void SelectExecutionResult(String execstatus) throws Exception
    {
 
		WebElement element = findElement("//label[contains(text(),'" + execstatus + "')]",driver);
		click(element,driver,"Clicking on Flowservice filter " + execstatus);
     
    }
	public void SelectExecutionStatus(String status) throws Exception
    {
 
		WebElement element = findElement("//*[contains(text(),'" + status + "')]",driver);
		click(element,driver,"Clicking on Flowservice filter " + status);
     
    }
	
	public void  clickApplyButton() throws Exception 
    {
		WebElement element = findElement("//button[contains(text(),'Apply')]",driver);
	    click(element,driver,"Click on Apply button");
	    waitForElementNotVisible(loader, driver, "wait for page load");
	}
	public void  clickFlowService() throws Exception 
    {
		//WebElement element = findElement("//*[@class=\"single-workflow-log\"]",driver);
		WebElement element = findElement("//div[contains(@class, 'table-content')]/span[1]/span[1]/span/a",driver);
	    click(element,driver,"Click on Flowservice");
	}
	public void  clickFlowServiceName(String flowname) throws Exception 
    {
		WebElement element = findElement("//*[contains(text(),'" + flowname + "')]",driver);
	    click(element,driver,"Click on Flowservice");
	    waitForElementNotVisible(loader, driver, "wait for page load");
	}
	public void  verifyTransactionCount(String transactioncount, String validate) throws Exception 
    {
		WebElement element = findElement("//*[text()='Transaction count']/following-sibling::*[@class=\"activity-log-value\"]",driver);
		elementContainsText(element, "1", driver, "validatingtransactioncount");
	}
	
	public void  verifyContextID(String contextID) throws Exception 
    {
		WebElement element = findElement("//*[text()='Context Id']/ancestor::div/div[@class='activity-log-value']",driver);
		elementContainsText(element,contextID, driver, "VALIDATING CONTEXT ID");
	}
	
	public void  enterContextID(String value) throws Exception 
    {
		WebElement element = findElement("//input[@name='contextID']",driver);
	    clearAndEnterText(element,value,driver,"Enter context ID "+value+"");
	}
	
	public void  noLogs() throws Exception 
    {
		WebElement element = findElement("//div[contains(@class,'table-data')]",driver);
	    elementContainsText(element,"No execution logs",driver,"Verify no logs data is present");
	}
 
}
