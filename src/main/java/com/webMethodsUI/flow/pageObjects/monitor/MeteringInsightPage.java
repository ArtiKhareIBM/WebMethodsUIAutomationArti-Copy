package com.webMethodsUI.flow.pageObjects.monitor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class MeteringInsightPage extends CommonActions{
	private WebDriver driver;
	WaitHelper waitHelper;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public MeteringInsightPage(WebDriver driver) {
		super();
		this.driver = driver;
		logExtentReport("MeteringInsight page created");
	}
	public void clickRefreshButton() throws Exception{
		WebElement element = findElement("//span[contains(@class, 'anticon anticon-sync')]", driver);
		click(element, driver, "Click refresh button");
	}
	public void validateLabel(String level) throws Exception{
		WebElement ele = findElement("//span[contains(text(),'" +level+ "')]", driver);
		waitForElementVisible(ele,driver,"Verify project menu is visible");
	}
	public void validateTabulerColumn() throws Exception{
		WebElement element = findElement("//td[contains(@class,'insights-table-cell')]", driver);
		waitForElementVisible(element,driver,"Verify highlight table column is loading properly");
	}
	public void getValueForTransaction() throws Exception{
		int num1 = 1;
		WebElement element = findElement("//td[contains(@class,'insights-table-cell')][4]",driver);
        String getValue= getText(element,driver,"Transactioncount");
        getValue = getValue.replace(",","");
        int num2 = Integer.parseInt(getValue);
        verifyValueIsGreater(num1,num2,driver,"comparing the transaction count is greater then 1");
	}
	public void getValueForReportTransaction() throws Exception{
		int num1 = 1;
		WebElement element = findElement("//td[contains(@class,'insights-table-cell')][5]",driver);
        String getValue= getText(element,driver,"Transactioncount");
        getValue = getValue.replace(",","");
        int num2 = Integer.parseInt(getValue);
        verifyValueIsGreater(num1,num2,driver,"comparing the transaction count is greater then 1");
	}
	public void getValueForExecution() throws Exception{
		int num1 = 100;
		WebElement element = findElement("//td[contains(@class,'insights-table-cell')][5]",driver);
        String getValue= getText(element,driver,"Executioncount");
        getValue = getValue.replace(",","");
        int num2 = Integer.parseInt(getValue);
        verifyValueIsGreater(num1,num2,driver,"comparing the execution count is greater then 100");
	}
	public void clickonButton(String button) throws Exception 
	{
		WebElement element = findElement("//button[contains(text(),'" +button+ "')]",driver);
		click(element,driver,"Clicking on Button.. " +element);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	public void clickFilterTab() throws Exception {
		WebElement element = findElement("//button[contains(@class,'dlt-filter__button')]", driver);
		click(element, driver, "clicking on filter Tab");
	}
	public void selectProject(String projectname) throws Exception
    {
		WebElement element = findElement("//*[contains(text(),'" + projectname + "')]",driver);
		click(element,driver,"Clicking on Flowservice filter " + projectname);
    }
	public void verifyProject(String projectname) throws Exception{
		WebElement element = findElement("//td[@title= '" +projectname+ "'][1]",driver);
		waitForElementVisible(element,driver,"Verify Project name is visible in highLight table");
	}
    public void clickApplyButton() throws Exception {
    	WebElement element = findElement("//div[@class='dlt-filter-actions']//button[contains(text(),'Apply')]", driver);
    	click(element, driver, "Clicking on Apply button..");
    }
    public void clickResetButton() throws Exception{
    	WebElement element = findElement("//button[contains(text(),'Reset')]", driver);
    	click(element, driver, "Clicking on Reset button");
    }
    public void clickTypeFilter() throws Exception{
    	WebElement element = findElement("//div[contains(text(),'Transaction count')]", driver);
    	click(element, driver, "Clicking on the Type filter");
    }
    public void verifyTransactionCount() throws Exception {
    	WebElement element = findElement("//input[@value='1']", driver);
    	waitForElementVisible(element, driver, "lower transaction count is showing properly" );
    }
    public void selectType(String type) throws Exception{
    	WebElement element = findElement("//*[contains(text(),'" +type+ "')]",driver);
		click(element,driver,"Clicking on Flowservice filter " + type);
    }
    public void validateTypeLevel(String typelevel) throws Exception{
    	WebElement element = findElement("//label[contains(text(),'" +typelevel+ "')]", driver);
    	waitForElementVisible(element,driver,"Verify type level is visible in highLight table");
    }
    public void setCountValue(String inputValue) throws Exception 
	{	
		WebElement element = findElement("//input[@placeholder='1 - 100']",driver);
		enterValue(element,inputValue,driver,"setting value for Count with...... " +inputValue);
	}
    public void clickNextPage() throws Exception {
    	WebElement element = findElement("//span[contains(@class, 'dlt-icon-chevron-circle-right pagination-icon false')]", driver);
    	click(element, driver, "clicking on the next button for Pagination");
    }
    public void validatePagination(String selecteditem) throws Exception{
    	WebElement element =findElement("//div[contains(text(),'" +selecteditem+ "')]", driver);
    	waitForElementVisible(element,driver,"Verify next page for pagination is visible");
    }
    public void itemPerPage(String value) throws Exception{
    	WebElement element = findElement("//select[contains(@class,'dlt-select-input')]", driver);
    	selectValueFromDropDown(element,value, driver, "selecting the Item per page from drop down say" +value);
    }
    public void tabulerFields(String columnname) throws Exception{
    	WebElement element = findElement("//th[contains(text(),'" +columnname+ "')]", driver);
    	waitForElementVisible(element,driver,"Verify table data " +columnname+ " are visible");
    }
    public void customTimeRangeButton() throws Exception{
    	WebElement element = findElement("//span[contains(@class, 'calender-monitor-icon')]", driver);
    	click(element, driver, "Clicking on the custom time range button");
    }
    public void verifyYear() throws Exception {
    	WebElement element = findElement("//th[contains(text(), '2024')]", driver);
    	waitForElementVisible(element,driver,"2024 year is persent");
    }
    public void clickCancelApplyButton(String buttontype) throws Exception {
    	WebElement element = findElement("//button[contains(@class,'" +buttontype+ "')]", driver);
    	click(element, driver, "clicking on Apply or Cancel button");
    }
    public void validateDate() throws Exception {
    	WebElement element = findElement("//div[@class='date-time-selected-value']//span[contains(text(),'2024')]", driver);
    	waitForElementVisible(element,driver,"Insights for: 2024 year is persent");
    }
    public void validatebuttonDisabled(String buttondown) throws Exception {
    	WebElement element = findElement("//button[contains(@class,'"+buttondown+"')]", driver);
    	isElementDisabled(element, driver,"transaction button is disabled");
    }
    public void clickOnFilterTab(String filtertype) throws Exception{
    	WebElement element = findElement("//div[contains(text(),'"+filtertype+"')]", driver);
    	click(element, driver, "Clicking on the filter tab");
    }
    public void verifyTypefilterData(String type) throws Exception{
		WebElement element = findElement("//td[@title= '" +type+ "'][1]",driver);
		waitForElementVisible(element,driver,"Verify service type is not visible in page");
	}
    public void clickOnService() throws Exception{
    	WebElement element = findElement("//div[contains(@id,'react-select-4-option-1')]", driver);
    	click(element, driver, "Clicking on the service tab");
    }
    public void SelectService() throws Exception{
    	WebElement element = findElement("//span[contains(text(),'Select services')]", driver);
    	click(element, driver, "Clicking on the service tab");
    }
    public void ClickDownloadButton() throws Exception{
    	WebElement element = findElement("//button[contains(text(),'Download Reports')]", driver);
    	click(element, driver, "Clicking on download button");
    }
    
    /*Below is specific to Top Consumer page*/
    
    public void validateHeading(String headingname) throws Exception {
    	WebElement element = findElement("//h4[contains(text(), '" +headingname+ "')]", driver);
    	waitForElementVisible(element, driver,"heading is present for " +headingname);
    }
    public void validateGraph() throws Exception {
    	WebElement element = findElement("//canvas[@class='chartjs-render-monitor']", driver);
    	waitForElementVisible(element, driver,"graph is loading properly");
    }

}
