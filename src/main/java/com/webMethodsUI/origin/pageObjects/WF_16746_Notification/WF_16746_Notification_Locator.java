package com.webMethodsUI.origin.pageObjects.WF_16746_Notification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.testbase.CommonActions;

public class WF_16746_Notification_Locator extends CommonActions {
	
	WebDriver driver;
	String dockerururl;
	String adminport = "4567";
	String devport = "3456";
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	public WF_16746_Notification_Locator(WebDriver driver) {
		super();
 		this.driver = driver;
 		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-notification ']")
	@CacheLookup
	WebElement NotificationIcon;
	
	@FindBy(xpath = "//h3[normalize-space()='Notifications']")
	@CacheLookup
	WebElement notificationText;
	
	@FindBy(xpath = "//span[@class='dlt-icon dlt-icon-settings notification-settings-icon right']")
	@CacheLookup
	WebElement notificationSetting;
	
	@FindBy(xpath = "//h1[normalize-space()='Notification Settings']")
	@CacheLookup
	WebElement notificationSettingsText;
	
	@FindBy(xpath = "//div[contains(@class,'left-side')]//span[normalize-space()='Subscribe all']")
	@CacheLookup
	WebElement TopicSubscription;
	
	@FindBy(xpath = "//div[@class='right-side']//span[normalize-space()='Subscribe all']")
	@CacheLookup
	WebElement sourceSubscription;
	
	@FindBy(xpath = "//div[contains(@class,'left-side')]//span[normalize-space()='Unsubscribe all']")
	@CacheLookup
	WebElement TopicUnSubscription;
	
	@FindBy(xpath = "//div[@class='right-side']//span[normalize-space()='Unsubscribe all']")
	@CacheLookup
	WebElement sourceUnSubscription;
	
	
	
	@FindBy(xpath = "//div[@class='right-side']//div[@class='notification-pill-switch right']//span[@class='switch-label small']")
	@CacheLookup
	WebElement ToggleButtonToSubscribe;
	
	@FindBy(xpath = "//div[@class='right-side']//input[@placeholder='Search']")
	@CacheLookup
	WebElement Sourcesearchbox;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	@CacheLookup
	WebElement SaveNotificationSubscriptionButton;
	
	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	WebElement subscriptionNotificationMessage;
	
	@FindBy(xpath = "//span[@class='dlt-icon dlt-icon-close notification-close-icon right']")
	@CacheLookup
	WebElement notificationCancelbutton;
	
	public void subscribeNotification() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visible");
		click(NotificationIcon, driver, "Clikc on Notification icon");
		waitForElementVisible(notificationText, driver, "Wait for notification text visible");
		waitForElementVisible(notificationSetting, driver, "Wait for notification settings is visble");
		click(notificationSetting, driver, "Click on Notification Settings");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");
		waitForElementVisible(TopicSubscription, driver, "Wait for topic Subscription is visible");
		click(TopicSubscription, driver, "Click on topic Subscription");	
		click(sourceSubscription, driver, "Click on source subscription");
		isElementEnabled(SaveNotificationSubscriptionButton, driver, "Wait for Save button to be enabled");
		click(SaveNotificationSubscriptionButton, driver, "Click on save button ");
		waitForElementVisible(subscriptionNotificationMessage, driver, "Wait for subscribeNotification message visble", 10);
		waitForElementNotVisible(subscriptionNotificationMessage, driver, "Wait for Subscription Message not visible", 5);
		//elementContainsText(NotificationIcon, devport, driver, adminport);
		click(notificationCancelbutton, driver, "Click on close the notification tab");
		
	}
	
	public void unSubscribeNotification() throws Exception {
		/*
		 * waitForElementLoaderNotVisible(loader, driver,
		 * "Wait for loader not visible"); click(NotificationIcon, driver,
		 * "Clikc on Notification icon"); waitForElementVisible(notificationText,
		 * driver, "Wait for notification text visible");
		 * waitForElementVisible(notificationSetting, driver,
		 * "Wait for notification settings is visble");
		 */
		click(notificationSetting, driver, "Click on Notification Settings");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");
		waitForElementVisible(TopicUnSubscription, driver, "Wait for topic UnSubscription is visible");
		click(TopicUnSubscription, driver, "Click on topic Subscription");	
		click(sourceUnSubscription, driver, "Click on source subscription");
		isElementEnabled(SaveNotificationSubscriptionButton, driver, "Wait for Save button to be enabled");
		click(SaveNotificationSubscriptionButton, driver, "Click on save button ");
		waitForElementVisible(subscriptionNotificationMessage, driver, "Wait for subscribeNotification message visble", 10);
		waitForElementNotVisible(subscriptionNotificationMessage, driver, "Wait for Subscription Message not visible", 5);
		//elementContainsText(NotificationIcon, devport, driver, adminport);
		click(notificationCancelbutton, driver, "Click on close the notification tab");
		
	}
	
	
	
	public void openFlowEditor(String flowName) throws Exception {
		WebElement element = findElement("//span[normalize-space()='"+flowName+"']", driver);
		waitForElementVisible(element, driver, "Wait for "+flowName+" visible");
		click(element, driver, "Click on"+flowName);
		Thread.sleep(8000);
		driver.navigate().back();
		WebElement element2 = findElement("//span[normalize-space()='"+flowName+"']", driver);
		click(element2, driver, "Click on"+flowName);
		waitForElementLoaderNotVisible(loader, driver, "Wait for Loader is not visible");
		Thread.sleep(4000);

	}
	
	public void responseResult() throws Exception {
		WebElement severity = findElement("//div[normalize-space()='Critical']", driver);
		elementContainsText(severity, "Critical", driver, "Verify Critical is visble");
		WebElement alertID = findElement("//div[normalize-space()='alertId']", driver);
		isElementDisplayed(alertID, driver, "Verify AlertId is visible");
		WebElement channelID = findElement("//div[normalize-space()='channelId']", driver);
		isElementDisplayed(channelID, driver, "Verify channelID is visible");
		WebElement channelIDValue = findElement("//div[normalize-space()='5']", driver);
		elementContainsText(channelIDValue, "5", driver, "verify value for channel id is visble");
		
	}
	
	public void backToNotificationPage() throws Exception {
		WebElement element = findElement("//a[@title='Go back']", driver);
		click(element, driver, "Click on back link");
		
	}
	
	@FindBy(xpath = "//span[normalize-space()='WF_16746_Notification']")
	@CacheLookup
	WebElement ERTNameAtNotificatio;
	
	@FindBy(xpath = "//span[@title='testSubject']")
	@CacheLookup
	WebElement notificationSubject;
	
	@FindBy(xpath = "//span[@title='TestContent']")
	@CacheLookup
	WebElement NotificationContent;
	
	@FindBy(xpath = "//span[contains(text(),'Critical')]")
	@CacheLookup
	WebElement criticalNotification;
	
	@FindBy(xpath = "//span[normalize-space()='Certificate management']")
	@CacheLookup
	WebElement topicName;
	
	public void validateNotifiaction(String Name) throws Exception {
		click(NotificationIcon, driver, "Click on notification");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visble");
		Thread.sleep(12000);
		elementContainsText(ERTNameAtNotificatio, Name , driver, "Verify ERT name visble");
		elementContainsText(notificationSubject, "testSubject", driver, "Verify Subject is visble");
		elementContainsText(NotificationContent, "TestContent", driver, "Verify Content is visble");
		elementContainsText(criticalNotification, "Critical", driver, "Verify Content is visble");
		elementContainsText(topicName, "Certificate management", driver, "Verify Content is visble");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
