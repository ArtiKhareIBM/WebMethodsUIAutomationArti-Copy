package com.webMethodsUI.flow.pageObjects.ListenerPage;

import java.util.List;

import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ListenerPage extends CommonActions{
	private WebDriver driver;
	private Logger log = LogManager.getLogger(ListenerPage.class);
	TestBase test;

	WaitHelper waitHelper;
	
	
	@FindBy(xpath = "//button[contains(text(),'New listener')]")
	@CacheLookup
	WebElement newListenerButtonElement;
	
	@FindBy(xpath = "//span[@class='no-listener'][text()='No Listeners created yet!']")
	@CacheLookup
	WebElement noListenerLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Enabled')]")
	@CacheLookup
	WebElement EnableState;
	
	@FindBy(xpath = "//span[contains(text(),'Disabled')]")
	@CacheLookup
	WebElement DisableState;
	
	@FindBy(xpath = "//label[contains(@class,'switch')]")
	@CacheLookup
	WebElement EnableButton;
	
	@FindBy(xpath = "//button[contains(text(),'Enable')]")
	@CacheLookup
	WebElement clickEnableButton;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	@FindBy(xpath = "//span[@title='Listeners'][text()='Listeners']/../span[contains(@class,'icon-chevron-down')]")
	@CacheLookup
	WebElement listenerTab;
	

public ListenerPage(WebDriver driver) throws Exception 
{
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);
	Thread.sleep(5000);
	waitForElementNotVisible(loader, driver, "wait for page load",45);
//	waitForElementVisible(newListenerButtonElement, driver, "Wait for listener page to load");
}

public void noListenerCreatedLabel() throws Exception 
{
	waitForElementNotVisible(loader, driver, "wait for page load",45);
	waitForElementVisible(noListenerLabel, driver, "Verify no listener created message is visible");
}

public String getNewListenerButtonElement() throws Exception 
{
	return getText(newListenerButtonElement, driver, "Get text of new listener button element");
}

public void clickOnNewListenerButton() throws Exception 
{
	click(newListenerButtonElement, driver, "Clicking on  Add listener  Button ...");
	waitForElementNotVisible(loader, driver, "wait for page load");
}

public void searchListener(String listenerName) throws Exception
{
	WebElement searcheElement = findElement("//input[@placeholder='Search']",driver);
	click(searcheElement,driver,"Searching listener");
	enterValue(searcheElement,listenerName, driver, "search"+listenerName);
    waitForElementNotVisible(loader, driver, "wait for page load");
}

public void verifyStateAndStatus(String listenerName,String state, String status) throws Exception
{
	WebElement lisState = findElement("//div[contains(@aid,'"+listenerName+"')]//div[3]//span[contains(@data-testid,'label')]/span",driver);
	String stateText = lisState.getText();
	log.info("Valus of listener state : "+stateText);
	WebElement lisStatus = findElement("//div[contains(@aid,'"+listenerName+"')]//div[4]//span[contains(@class,'listener-list')]/span",driver);
	String statusText = lisStatus.getText();
	log.info("Valus of listener status : "+statusText);
	
	if(state.equals(stateText) && status.equals(statusText))
	{
		log.info("State and Status are in sync");
		logExtentReport("Actual response contents: "+"<span style='font-weight:bold;'>"+stateText+statusText+"</span>"
				+" Expected contents : "+"<span style='font-weight:bold;'>"+stateText+statusText+"</span>");
		getNavigationScreen(driver);
	}
	else 
	{
		logExtentReport("Actual response contents : "+"<span style='font-weight:bold;'>"+stateText+statusText+"</span>"
				+"Expected contents : "+"<span style='font-weight:bold;'>"+stateText+statusText+"</span>");
		getNavigationScreen(driver);
		Assert.assertEquals(state, status);
	}
	//stringEquals(stateText,"DISABLED",driver,"State and status");
}

public void verifyRefreshIcon(String listenerName) throws Exception{
	
	WebElement refreshIcon = findElement("//div[contains(@aid,'"+listenerName+"')]//div[5]/span[@title='Refresh']",driver);
	waitForElementVisible(refreshIcon,driver,"Refresh icon is visible");
	refreshIcon.click();
	
}

public void clickOnEnableButton(String listenerName) throws Exception 
{
	WebElement stateButton = findElement("//span[text()='"+listenerName+"']/ancestor::div//div[@title='Disabled Listener']/div/label[contains(@class,'switch')]",driver);
	click(stateButton, driver, "Clicking to enable listener ...");
	click(clickEnableButton, driver, "Click on Enable button on popup");
	waitForElementNotVisible(loader, driver, "wait for page load",45);
	waitForElementVisible(EnableState, driver, "Wait for state to set to enabled state");
}

public void clickOnDisableButton(String listenerName) throws Exception 
{
	WebElement stateButton = findElement("//span[text()='"+listenerName+"']/ancestor::div//div[@title='Enabled Listener']/div/label[contains(@class,'switch')]",driver);
	click(stateButton, driver, "Clicking to disable listener ...");
	waitForElementLoaderNotVisible(loader, driver, "wait for page load");
	waitForElementVisible(DisableState, driver, "Wait for state to set to disabled state");
}

public void ExpandFlowserviceArrowIcon(int index) 
{
	logExtentReport(" Clicking on arrow icon ..." +index);	
	List<WebElement> elemntArray = driver
			.findElements(By.xpath("//span[@class='sub-title delite-icon dlt-icon-chevron-right']"));
	WebElement element = elemntArray.get(index);
	element.click();	
}

public void ExpandTriggerArrowIcon(int index) 
{
	logExtentReport(" Clicking on arrow icon ..." +index);	
	List<WebElement> elemntArray = driver
			.findElements(By.xpath("//span[@class='sub-title delite-icon dlt-icon-chevron-right']"));	
	WebElement element = elemntArray.get(index);
	element.click();
}

public void navigateToListener() throws Exception
{
	click(listenerTab, driver, "Clicking to listener tab ...");
	waitForElementNotVisible(loader, driver, "wait for page load",30);
}


}

