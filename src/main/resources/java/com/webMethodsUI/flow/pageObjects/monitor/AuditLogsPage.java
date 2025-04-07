package com.webMethodsUI.flow.pageObjects.monitor;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.assertion.AssertionHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.testbase.TestBase;

public class AuditLogsPage {
	private WebDriver driver;
	private Logger log = LogManager.getLogger(AuditLogsPage.class);
	WebElement element;

	WaitHelper waitHelper;

	@FindBy(xpath = "//span[contains(text(),'12h')]")
	@CacheLookup
	public static WebElement text12hElement;

	@FindBy(xpath = "//a[contains(text(),'Audit Logs')]")
	@CacheLookup
	public static WebElement auditLogsTextElement;

	@FindBy(xpath = "//input[@class='search-box-input']")
	@CacheLookup
	public static WebElement searchfieldAuditlog;



	public AuditLogsPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(text12hElement, ObjectReader.reader.getExplicitWait());

		
		log.info(" waiting   title text   in  Audit log Page...... "+text12hElement);
		logExtentReport("waiting  title text   in  Audit log Page...... "+text12hElement);
		// new TestBase().getNavigationScreen(driver);

	}

	public boolean verifyAuditLogTitleText(String Doctypexsd) {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");

		
		WebElement element = driver
				.findElement(By.xpath("//span[contains(text(),\"created new '" + Doctypexsd + "' project\")]"));
		element.getText();
		
		return element.isDisplayed();

	}

	public boolean verifyAuditLogTitleTextForCreateProject(String moduleName, String ProjectName) {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" +moduleName
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"created new '" + ProjectName
				+ "' project.\")]"));

		return element.isDisplayed();

	}
	
	
	
	public boolean verifyAuditLogTitleTextForDeletedProject(String moduleName, String ProjectName) {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + moduleName
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"deleted '" + ProjectName
				+ "' project.\")]"));
		
		
		return element.isDisplayed();

	}
	
	
	
	public boolean verifyAuditLogTitleTextForUpdateProject(String ProjectName, String documentTypeName) {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + ProjectName
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"updated '" + documentTypeName
				+ "' project.\")]"));

		return element.isDisplayed();

	}

	public boolean verifyAuditLogActionText(String ProjectName, String ActionName) {
		log.info(" Verifing  Action  text   in  Audit log Page...... ");
		logExtentReport("Verifing   Action text   in  Audit log Page...... ");
		
		
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + ProjectName
				+ "')]/parent::td/following-sibling::td[2]/span[contains(text(),'" + ActionName + "')]"));
		

		return element.isDisplayed();
		

	}

	

	public boolean verifyAuditLogForDocumentType(String Module, String documentTypeName, String projectName) {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");
		System.out.println(Module + ".............................");

		

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + Module
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"Create on " + documentTypeName
				+ " in '" + projectName + "' project.\")]"));
		
		
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");

		return element.isDisplayed();

	}

	public boolean verifyAuditLogForUpdateDocumentType(String Module, String documentTypeName, String projectName) {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");
		

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + Module
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"Update on " + documentTypeName
				+ " in '" + projectName + "' project.\")]"));
		
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");
		

		return element.isDisplayed();

	}

	public boolean verifyAuditLogForCopyDocumentType(String Module, String documentTypeName, String projectName) {
		log.info(" Verifing  title text   in  Audit log Page For Copy Document Type Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page For Copy Document Type Page...... ");
		
		
		
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + Module
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"Copy on " + documentTypeName + " in '"
				+ projectName + "' project.\")]"));
		
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");
	
		
		

		return element.isDisplayed();

	}

	public boolean verifyAuditLogForDeletedCopyDocumentType(String Module, String documentTypeName,
			String projectName) {
		log.info(" Verifing  title text   in  Audit log Page for Deleted  Copy Document Type...... ");
		logExtentReport("Verifing  title text   in  Audit log Page for Deleted  Copy Document Type...... ");

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + Module
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"Delete on " + documentTypeName + " in '"
				+ projectName + "' project.\")]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");

		return element.isDisplayed();

	}

	public boolean verifyAuditLogForDeletedDocumentType(String Module, String documentTypeName, String projectName) {
		log.info(" Verifing  title text   in  Audit log Page For Deleted DocumentType...... ");
		logExtentReport(" Verifing  title text   in  Audit log Page For Deleted DocumentType......  ");
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + Module
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"Delete on " + documentTypeName
				+ " in '" + projectName + "' project.\")]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");
		

		return element.isDisplayed();

	}
	
	
	public boolean verifyAuditLogForCreateFlowservice(String Module, String documentTypeName, String projectName) {
		log.info(" Verifing  title text  for Create flowservice   in  Audit log Page...... ");
		logExtentReport("Verifing  title text  create flowservice  in  Audit log Page...... ");
		System.out.println(Module + ".............................");

		

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + Module
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"Create on " + documentTypeName
				+ " in " + projectName + "' project.\")]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");
		

		return element.isDisplayed();

	}
	
	
	
	
	
	
	
	public boolean verifyAuditLogForCreateRESTAPI(String Module, String restAPIName, String projectName) {
		log.info(" Verifing    Audit log Page for  create Rest Api...... ");
		logExtentReport("Verifing    Audit log Page for  create Rest Api......  ");
		log.info( Module+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info( restAPIName+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info(projectName+" Verifing    Audit log Page for  create Rest Api...... ");
		

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + Module
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"Create on " + restAPIName
				+ " in '" + projectName + "' project.\")]"));
		

		return element.isDisplayed();

	}

	public void SearchAnElement(String Element){
		log.info("Search the element" +Element);
		logExtentReport("Search the element" +Element);
		searchfieldAuditlog.click();
		searchfieldAuditlog.sendKeys(Element);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

	}



	public void Searchclearfield(){
		log.info("clear the element" );
		logExtentReport("clear the element");
		searchfieldAuditlog.click();
		searchfieldAuditlog.clear();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	
	
	
	
	

}
