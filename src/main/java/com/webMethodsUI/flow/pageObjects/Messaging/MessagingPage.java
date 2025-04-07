package com.webMethodsUI.flow.pageObjects.Messaging;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class MessagingPage extends CommonActions{
	private WebDriver driver;
	WaitHelper waitHelper;
	
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public MessagingPage(WebDriver driver) {
		super();
		this.driver = driver;
		
		logExtentReport("Messaging page object created");
	}
	public void clickOnMessagingToggleButton() throws Exception 
	{
		WebElement element = findElement("//span[@data-testid='toggle-button-Messaging']",driver);
		click(element,driver,"Clicking on messaging toggle button");
	}
	public void clickOnButton(String buttontype) throws Exception
	{
		WebElement element = findElement("//button[contains(text(),'" + buttontype + "')]",driver);
		click(element, driver, "clicking on button: " +buttontype);
	}
	public void  enterQueueName(String value) throws Exception 
    {
		WebElement element = findElement("//input[@name='queueName']",driver);
	    clearAndEnterText(element,value,driver,"Enter queue name "+value+"");
	}
	public void  enterTopicName(String value) throws Exception 
    {
		WebElement element = findElement("//input[@name='topicName']",driver);
	    clearAndEnterText(element,value,driver,"Enter topic name "+value+"");
	}
	public void  enterSubscriberName(String value) throws Exception 
    {
		WebElement element = findElement("//input[@name='subscriberName']",driver);
	    clearAndEnterText(element,value,driver,"Enter subscriber name "+value+"");
	}
	public void clickonSharedToggleButton() throws Exception
	{
		WebElement element = findElement("//span[@class='switch-label small']", driver);
		click(element, driver,"Clicking on shared Toggle button");
	}
	public void clickonTopicTab() throws Exception
	{
		WebElement element = findElement("//a[contains(text(),'Topics')]", driver);
		click(element, driver,"Clicking on Topic tab");
	}
	public void selectDestination() throws Exception
	{
		WebElement element = findElement("(//div[@class='select2-common__placeholder css-1wa3eu0-placeholder'][normalize-space()='Please select'])[1]", driver);
		click(element, driver,"Clicking on Topic tab");
	}
	public void clickPlusIcon() throws Exception
	{
		WebElement element = findElement("//div[@class='new-destination-add-button ']", driver);
		click(element, driver,"Clicking on plus icon to add flowservice");
	}
	public void  enterFlowName(String value) throws Exception 
    {
		WebElement element = findElement("//input[@id='flowServiceName']",driver);
	    clearAndEnterText(element,value,driver,"Enter subscriber name "+value+"");
	}
	public void clickOnLabel(String label) throws Exception
	{
		WebElement element = findElement("//div[contains(text(),'"+label+"')]", driver);
		click(element, driver,"Clicking on Label" +label);
	}
	public void clickOnSaveDialogButton() throws Exception
	{
		WebElement element = findElement("(//button[@type='button'][normalize-space()='Save'])[2]",driver);
		click(element, driver, "clicking on save button: ");
	}
	public void clickonActionField() throws Exception
	{
		WebElement element = findElement("(//input[@id='step-dropdown-input'])[1]",driver);
		click(element, driver, "clicking on messaging choose an action fields");
	}
	public void clickonTypeField() throws Exception
	{
		WebElement element = findElement("(//input[@id='step-dropdown-input'])[2]",driver);
		click(element, driver, "choose messaging type fields");
	}
	public void clickonDestinationField() throws Exception
	{
		WebElement element = findElement("(//div[@class='drop-down-input-section'])[3]",driver);
		click(element, driver, "choose messaging type fields");
	}
	public void selectAction(String field) throws Exception
	{
		WebElement element = findElement("//span[contains(text(),'"+field+"')]",driver);
		click(element, driver, "Selecting the publish action for messaging" +field);
	}
	public void  enterDestinationName(String value) throws Exception 
    {
		WebElement element = findElement("//input[@name='destinationName']",driver);
	    clearAndEnterText(element,value,driver,"Enter queue name "+value+"");
	}
	public void  checkSharedQueueTopic() throws Exception 
    {
		WebElement ele = findElement("//span[contains(text(),'Shared')]",driver);
		waitForElementVisible(ele, driver, "Wait for shared icon to be visible",20);
	}
	public void  verifySharedQueueTopic(String value) throws Exception 
    {
		WebElement ele = findElement("a[title='"+value+"']",driver);
		waitForElementVisible(ele, driver, "Wait for shared queue and topic to be visible",20);
	}
	public void deletesharedQueueTopic(String fieldname) throws Exception
	{
		WebElement element = findElement("//i[@name='"+fieldname+"']",driver);
		click(element, driver, "deleteing shared queue topic" +fieldname);
	}
	

}
