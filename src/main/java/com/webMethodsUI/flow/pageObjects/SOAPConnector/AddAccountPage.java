package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.flowService.EditMappingPage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.CommonActions;

public class AddAccountPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(AddAccountPage.class);
	WaitHelper waitHelper;
	WebElement element;

	@FindBy(xpath = "//h1[@class='modal-title']")
	@CacheLookup
	WebElement AddAccountModelTitle;

	@FindBy(xpath = "//span[text()='Port Binding']/..//div[contains(@class,'value')]")
	@CacheLookup
	WebElement portFieldElement;

	@FindBy(xpath = "//input[@name='User']")
	@CacheLookup
	WebElement userNameElement;

	@FindBy(xpath = "//input[@name='authLabel']")
	@CacheLookup
	WebElement accountnametest;

	@FindBy(xpath = "//input[@name='Password']")
	@CacheLookup
	WebElement passwordElement;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	@CacheLookup
	WebElement addButtonElement;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement cancelbutton;

	@FindBy(xpath = "//a[contains(text(),'Projects')]")
	@CacheLookup
	WebElement ProjectsMenu;

	@FindBy(xpath = "//input[@name='URL']")
	@CacheLookup
	WebElement accountUrlElement;

	@FindBy(xpath = "//span[contains(text(),'WS Security Partner Certificate Alias')]")
	WebElement PartnerCerifcate;

	@FindBy(xpath = "//input[@name='name']")
	WebElement CertficateName;

	@FindBy(xpath = "//span[contains(text(),'flowpage')]")
	WebElement SelectCertficate;
	
	@FindBy(xpath = "//div[@class='notification-message']")
	public static WebElement notificationMessage;

	String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public AddAccountPage(WebDriver driver) throws Exception
	{

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitForElementVisible(AddAccountModelTitle, driver, "Verify add account model title is visible");

	}

	public String getModelTitle() {
		return AddAccountModelTitle.getText();
	}

	public void selectPortType(String portType) throws Exception {
		//waitForElementVisible(portFieldElement,driver,"Verify the acccont UI is loaded or not");
		click(portFieldElement, driver, "Click on portFieldElement");
		element = driver.findElement(By.xpath("//div[contains(text(),'" + portType + "')]"));
		click(element, driver, "Clicked on port  type...."+portType);

	}
	
	public void selectMultiPortType(String portType, int index) throws Exception {
		
		click(portFieldElement, driver, "Click on portFieldElement");
		element = driver.findElement(By.xpath("//div[contains(text(),'" + portType + "')]"));
		click(element, driver, "Clicked on port  type...."+portType);

	}
	
	public void enteringURL(String url) throws Exception
    {
		WebElement urlfield = findElement("//input[@aid='URL']",driver);
        clearAndEnterText(urlfield, url, driver, "Entering .." + url);
        waitForElementNotVisible(loader, driver, "wait for page load");
    }
	
	public void errorMessage(String message) throws Exception 
	 {
		 WebElement notification = findElement("//div[@class='notification-message']", driver);
		 elementContainsText(notification,message, driver, "Verify error message is visible");
	}

	public void enterUserName(String userNametxt) throws Exception
	{
		enterValue(userNameElement, userNametxt, driver, "Entering user Name: " + userNametxt);
	}

	public void enterAccountname(String userNametxt) throws Exception
	{
		enterValue(accountnametest, userNametxt, driver, "Entering user Name: " + userNametxt);
	}

	public void enterPassword(String password) throws Exception
	{
		enterValue(passwordElement, password, driver, "Entering password " + password);
	}

	public void clickOnAddButton() throws Exception {

		click(addButtonElement, driver, "clicked on add button");
		waitForElementNotVisible(loader, driver, "wait for page load");

//		WaitHelper waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElement(ProjectsMenu, ObjectReader.reader.getExplicitWait());

	}
	
	public void cancelAccount() throws Exception{
		
		WebElement element = findElement("//button[text()='Save']/preceding-sibling::button[text()='Cancel']",driver);
        click(element, driver, "click on editicon");
        waitForElementNotVisible(loader, driver, "wait for page load");    
	}
	
	public void saveAccount() throws Exception{
		
		WebElement element = findElement("//button[text()='Save']",driver);
        click(element, driver, "click on editicon");
        waitForElementNotVisible(loader, driver, "wait for page load");    
	}

	public void clickOnCancelButton() throws Exception {
		//waitForElementVisible(PartnerCerifcate,driver,"Verify cancel button is present");
		WebElement element1 = driver.findElement(By.xpath("//button[text()='Add']/preceding-sibling::button[text()='Cancel']"));
		click(element1, driver, "clicked on cancel button");
		waitForElementNotVisible(loader, driver, "wait for page load");

	}

	 public String verifythepartnercertficatelabel() throws Exception
	{
		 waitForElementVisible(PartnerCerifcate,driver,"Verify PartnerCerifcate is present");
		 return PartnerCerifcate.getText();
	}

	 public  void  clickOnCertficatePlusbutton() throws Exception {

	   		log.info("Clicking on plus button .. ..");
	   		logExtentReport(
	   		"Clicking on plus button .. ......  ");
	   		List<WebElement> element = findElements("//*[@class='material-icons add-icon-plus']",driver);
	   		click(element.get(3),driver,"click on fourth element");

	   	}
	

	 public void certficateName(String userNametxt) throws Exception
		{
			enterValue(CertficateName, userNametxt, driver, "Entering certficate  Name: " + userNametxt);
		}


	 public  void  clickOnCertficateDropDown() throws Exception {

	   		log.info("Clicking on plus button .. ..");
	   		logExtentReport(
	   		"Clicking on plus button .. ......  ");
	   		List<WebElement> element = findElements("//*[@class=' dlt-icon-caret-down look-up-icon']",driver);
	   		click(element.get(5),driver,"click on fifth element");
	   		scrollPageDown2(driver, 50);
	   		waitForElementVisible(SelectCertficate,driver,"Verify PartnerCerifcate is present");
	   		SelectCertficate.click();

	   	}

	  public void selectcertficateType(String certficateName) throws Exception {
		  List<WebElement> element = findElements("//*[@class=' dlt-icon-caret-down look-up-icon']",driver);
		  click(element.get(5),driver,"click on fifth element");
			//GenericHelper genericHelper = new GenericHelper(driver);
			//genericHelper.clickOnDropDown(element,5);
			//genericHelper.selectDropDownLink(keyType);
			//log.info("Clicked on certficate type....");
		  WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'" + certficateName + "')]"));
		  element1.click();




	}







}
