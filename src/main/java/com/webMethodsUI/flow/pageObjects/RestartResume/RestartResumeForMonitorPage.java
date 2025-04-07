package com.webMethodsUI.flow.pageObjects.RestartResume;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.flowService.EditMappingPage;
import com.webMethodsUI.flow.testbase.CommonActions;

public class RestartResumeForMonitorPage extends CommonActions{
	private WebDriver driver;
	WaitHelper waitHelper;
	private Logger log = LogManager.getLogger(EditMappingPage.class);
	
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public RestartResumeForMonitorPage(WebDriver driver) {
		super();
		this.driver = driver;
		logExtentReport("restart resume feature validation for Monitor page");
	}
	public void importRestartResumeFlowservice() throws Exception 
	{	
			WebElement BrowseFileElement = driver.findElement(By.xpath("//input[@id='ut-flow-export']"));
	        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\RestartResume.zip");
	        FileUpload fileupload = new FileUpload(driver);
	        fileupload.fileUploadUsingInputType(BrowseFileElement,filePath);
	}
	public void  clickOnFlowOverview() throws Exception 
    {
		WebElement element = findElement("//i[@class='dlt-icon-more-menu']",driver);
	    click(element,driver,"Click on overview icon of Flowservice");
	}
	public void clickOnOverviewLink() throws Exception {
		WebElement element = findElement("//i[@class='dd-icons icons8-view-workflow']", driver);
		click(element,driver,"Click on overview link");
	}
	public void validateRestartresumeElement() throws Exception {
		WebElement element = findElement("//span[contains(text(),'Enable Flow service to be restarted')]",driver);
		waitForElementVisible(element,driver,"Verify restart resume element is vissible: ");
	}
	public void EnableRestartResume() throws Exception {
		WebElement element = findElement("//span[contains(text(),'Enable Flow service to be restarted')]", driver);
		click(element,driver,"Click on restart resume checkbox");
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	public void clickCloseButton() throws Exception {
		WebElement element = findElement("//i[contains(text(),'close')]", driver);
		waitForElementVisible(element,driver,"Verify restart resume element is vissible: ");
		click(element,driver,"Click on close button for restart resume");
	}
	public void clickOnResubmitButton() throws Exception {
		//WebElement element = findElement("//i[@title='Resume flow execution from the point it failed in the previous run']", driver);
		WebElement element = findElement("(//i[@title='Resume will start executing from the failed point of this execution if resume is enabled for this flow.It will restart execution from beginning if only restart is enabled'])[1]", driver);
		//div[@class='monitor-workflow-inner-content']/div/div[2]/span[1]/span[9]/i[2]
		click(element,driver,"Click on resubmit button");
	}
	public void clickOnRestartButton() throws Exception {
		WebElement element = findElement("//i[@title='Restart']", driver);
		click(element,driver,"Click on resubmit button");
	}
	public void enterInputValue(int index, String value) throws Exception {

		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("..Total window ........" + count);
		for (String child : allWindows) {

			if (parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				log.info(" Entering input value ...");

				List<WebElement> elemntArray = driver
						.findElements(By.xpath("//input[@type='text']"));
				log.info("All input parameters are....." + elemntArray);
				WebElement element = elemntArray.get(index);
				log.info(" Clicking on element at index..." + index + "......" + element);
				logExtentReport("Clicking on element at index..." + index + "......" + element);
				element.click();
				element.clear();
				element.sendKeys(value);

			}
		}
	}
	public void  clickRefreshButton() throws Exception 
    {
		WebElement element = findElement("//span[@title='Refresh']",driver);
		waitForElementNotVisible(loader, driver, "wait for page load");
	    click(element,driver,"Click on Refresh");
	}
	public void  clickRunButton() throws Exception 
    {
		WebElement element = findElement("//button[contains(text(),'Run')]",driver);
	    click(element,driver,"Click on Run button");
	    waitForElementNotVisible(loader, driver, "wait for page load");
	}
	public void validateSuccessResult() throws Exception {
		WebElement element = findElement("//span[@title='success']",driver);
		waitForElementNotVisible(loader, driver, "wait for page load");
		waitForElementVisible(element,driver,"Verify success result is vissible: ");
	}
	public void  goToFlowExecutionDetails(String flowname,String i) throws Exception 
    {
		WebElement element = findElement("(//a[@title='"+ flowname +"'])["+ i +"]",driver);
		waitForElementNotVisible(loader, driver, "wait for page load");
	    click(element,driver,"Click on Flowservice");
	}
	public void validateRestartButtonisVisible() throws Exception {
		WebElement element = findElement("//span[text()='Restart']",driver);
		waitForElementVisible(element,driver,"Verify restart button is vissible: ");
	}
	public void clickResumeButton() throws Exception{
		WebElement element = findElement("//span[text()='Resume']",driver);
		waitForElementVisible(element,driver,"Verify resume button is vissible: ");
		click(element,driver,"Click on Resume button in details page");
		
	}
	public void validateResumeNotVisible() throws Exception{
		//String element = "//i[@title='Restart']";
		String element = "//div[@class='table-content ']/span[1]/span/i[1]";
		waitForElementNotVisible(element, driver, "wait for page load");
		
	}
	public void validateRestartedStatus() throws Exception{
		WebElement element = findElement("//span[contains(text(),'Restarted')]",driver);
		waitForElementVisible(element,driver,"Verify restarted status is visible: ");
	}
	public void clickOnRestartButtonindetailPage() throws Exception {
		WebElement element = findElement("//span[text()='Restart']", driver);
		click(element,driver,"Click on resubmit button");
	}

}
