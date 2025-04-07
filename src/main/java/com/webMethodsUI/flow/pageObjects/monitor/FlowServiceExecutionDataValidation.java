package com.webMethodsUI.flow.pageObjects.monitor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class FlowServiceExecutionDataValidation extends CommonActions{
	private WebDriver driver;
	WaitHelper waitHelper;
	
	
	@FindBy(xpath = "//span[contains(@class,'icon-chevron-down')]/following-sibling::span[text()='Overview']")
	@CacheLookup
	WebElement OverviewDownIcon;
	
	@FindBy(xpath = "//span[contains(@class,'icon-chevron-up')]/following-sibling::span[text()='Overview']")
	@CacheLookup
	WebElement OverviewUpIcon;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public FlowServiceExecutionDataValidation(WebDriver driver) {
		super();
		this.driver = driver;
		logExtentReport("FlowServiceExecution DataValidation page object created");
		
	}
	
	public void clikOnDayAndWeekButton(String button) throws Exception{
		WebElement element = findElement("//span[contains(text(),'" +button+ "')]", driver);
		click(element, driver, "Clicking on  button " + button);
	}
	
	public void validateElementinpage(String elementname) throws Exception{
		WebElement element = findElement("//span[contains(text(),'"+ elementname +"')]", driver);
		waitForElementVisible(element,driver,"Verify this element is vissible: "+elementname);
	}
	public void validateResultMessage(String message) throws Exception{
		WebElement element = findElement("//*[text()='Status']/following-sibling::*[contains(text(),'"+ message +"')]", driver);
		waitForElementVisible(element,driver,"Verify this element is vissible: "+message);
	}
	public void validateProcessedDocument(String docprocess) throws Exception{
		WebElement element = findElement("//*[text()='Successful Documents']/following-sibling::*[contains(text(),'"+ docprocess +"')]", driver);
		waitForElementVisible(element,driver,"Verify this element is vissible: "+docprocess);
	}
	
	public void  clickRefreshButton() throws Exception 
    {
		WebElement element = findElement("//span[@title='Refresh']",driver);
	    click(element,driver,"Click on Refresh");
	}
	public void validateExecutionSource(String execution) throws Exception{
        WebElement element = findElement("//*[text()='"+ execution +"']", driver);
        waitForElementVisible(element,driver,"Verify this element is vissible: "+execution);
    }
	
	public void setValueInput(String inputValue) throws Exception 
	{	
		WebElement element = findElement("//input[contains(@class,'p-dropdown-label')][@placeholder='Select pick list choices']",driver);
		enterValue(element,inputValue,driver,"setting value with...... " +inputValue);
	}
	
	public void setValueForIncrementedBy(String inputValue) throws Exception 
	{	
		WebElement element = findElement("//textarea[@placeholder='Enter value here']",driver);
		enterValue(element,inputValue,driver,"setting value with...... " +inputValue);
	}
	public void setValueForSecond(String inputValue) throws Exception 
	{	
		WebElement element = findElement("//input[@placeholder='Select pick list choices']",driver);
		enterValue(element,inputValue,driver,"setting value with...... " +inputValue);
	}
	public void  clickModifyRetentionButton() throws Exception 
    {
		WebElement element = findElement("//a[contains(text(),'Modify Retention Period')]",driver);
	    click(element,driver,"Click on Modify retention link.");
	}
	public void setValueForRetentionPeriod(String inputValue) throws Exception
	{
		WebElement element = findElement("//input[@id='retention-period']",driver);
		enterValue(element,inputValue,driver,"setting the value with...." +inputValue);
	}
	public void  clickSaveButton() throws Exception 
    {
		WebElement element = findElement("//button[contains(text(),'Save')]",driver);
	    click(element,driver,"Click save button.");
	}
	public void validateRetentionperiodupdated() throws Exception{
		WebElement element = findElement("//div[text()='FlowService Execution Results are stored for the maximum of ']/../div[text()='25']/../div[text()=' days.']", driver);
		waitForElementVisible(element,driver,"Verify this element is vissible: ");
	}
	public void clickSettingButton() throws Exception{
		WebElement element = findElement("//span[@class='delite-icon dlt-icon-settings']",driver);
	    click(element,driver,"Click setting button");
	}
	public void validateSettingElement(String settingelement) throws Exception{
		WebElement element = findElement("//span[contains(text(),'"+ settingelement +"')]",driver);
		waitForElementVisible(element,driver,"Verify this element is vissible: " +settingelement);
	}
	public void  verifyDashboardFlowService(String flowservicetext, String i) throws Exception 
    {
		WebElement element = findElement("(//a[contains(text(),'"+ flowservicetext +"')])["+ i +"]",driver);
		waitForElementVisible(element,driver,"Verify this element is vissible: " +flowservicetext);
	}
	public void clickOnFlowService(String flowservicename) throws Exception{
		WebElement element = findElement("//span[contains(text(),'"+flowservicename+"')]",driver);
	    click(element,driver,"Click on flow service");
	    waitForElementNotVisible(loader, driver, "wait for page load");
	}
	public int getValueForTransaction() throws Exception 
    {
		WebElement element = findElement("//div/span[@class='total-execution-count']",driver);
		String getValue= getText(element,driver,"totalexecutioncount");
		int value = Integer.parseInt(getValue);
		return value;
	}
	public int getValueForSuccessTransaction() throws Exception 
    {
		WebElement element = findElement("//div[@class='successful-executions']",driver);
        String getValue= getText(element,driver,"successfulexecutioncount");

        String number="";
         for(int i=0;i<getValue.length();i++)
         {
             if(getValue.charAt(i+1)!='S')
             {
               number = number+getValue.charAt(i);
             }
             else
             break;
         }
        int value = Integer.parseInt(number);
        return value;
	}
	public int getValueForfailedTransaction() throws Exception 
    {
		WebElement element = findElement("//div[@class='failed-executions']",driver);
        String getValue= getText(element,driver,"successfulexecutioncount");

        String number="";
         for(int i=0;i<getValue.length();i++)
         {
             if(getValue.charAt(i+1)!='F')
             {
               number = number+getValue.charAt(i);
             }
             else
             break;
         }
        int value = Integer.parseInt(number);
        return value;
	}
	public void validateTransactionValue(int value1 , int value2) throws Exception 
    {
		verifyValueIsGreater(value1,value2,driver,"comparing the execution count");
	}
	public void clickOnDownloadButton(String buttonname) throws Exception{
		WebElement element = findElement("//a[contains(text(),'"+ buttonname +"')]",driver);
		waitForElementVisible(element,driver,"Verify download button click: " + buttonname);
		
	}
	
	public void ExpandOverview() throws Exception
	{
		try
		{
			if(OverviewDownIcon.isDisplayed())
				click(OverviewDownIcon,driver,"Clicking on Overview down icon to expand Overview");
		}
		catch(Exception e)
		{
				logExtentReport("Overview is Expanded");
		}
	}
	
	public void CollapseOverview() throws Exception
	{
		try
		{
			if(OverviewUpIcon.isDisplayed())
				click(OverviewUpIcon,driver,"Clicking on Overview up icon to collapse Overview");
		}
		catch(Exception e)
		{
			logExtentReport("Overview is collapsed");
		}
	}
	

}
