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
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class AuditLogsPage extends CommonActions{
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



	public AuditLogsPage(WebDriver driver) throws Exception 
	{

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitForElementVisible(text12hElement, driver, " waiting   title text   in  Audit log Page...... "+text12hElement);


	}

	public boolean verifyAuditLogTitleText(String Doctypexsd) throws Exception 
	{

		WebElement element = findElement("//span[contains(text(),\"created new '" + Doctypexsd + "' project\")]",driver);
		getText(element, driver, " Verifing  title text   in  Audit log Page...... ");
		
		return element.isDisplayed();

	}

	public boolean verifyAuditLogTitleTextForCreateProject(String moduleName, String ProjectName) throws Exception 
	{
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");

		WebElement element = findElement("//*[contains(text(),'" +moduleName
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"created new '" + ProjectName
				+ "' project\")]",driver);

		return element.isDisplayed();

	}
	
	
	public boolean verifyAuditLogTitleTextForDeletedProject(String moduleName, String ProjectName) throws Exception {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");

		WebElement element = findElement("//*[contains(text(),'" + moduleName
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"deleted '" + ProjectName
				+ "' project\")]",driver);
		
		
		return element.isDisplayed();

	}
	
	
	
	public boolean verifyAuditLogTitleTextForUpdateProject(String ProjectName, String documentTypeName) throws Exception {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");

		WebElement element = findElement("//*[contains(text(),'" + ProjectName
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"updated '" + documentTypeName
				+ "' project\")]",driver);

		return element.isDisplayed();

	}

	public boolean verifyAuditLogActionText(String ProjectName,String connectorName,String module, String ActionName) throws Exception {
		
		WebElement element = findElement("(//*[contains(text(),'"+module+"')]/parent::td/following-sibling::td/span[@class='flow-details']"
				+"[text()='"+ObjectReader.reader.getUserName()+" performs "+ActionName+" on "+connectorName+" in "+ProjectName+" project']"
				+"/ancestor::td/following-sibling::td/span[contains(text(),'"+ActionName+"')])[1]",driver);
		
		return isElementDisplayed(element, driver, "Verifing Action text in  Audit log Page...... ");	
	}

	

	public boolean verifyAuditLogForDocumentType(String documentTypeName, String projectName) {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Create on " + documentTypeName
				+ " in '" + projectName + "' project\")]"));
		
		
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");

		return element.isDisplayed();

	}

	public boolean verifyAuditLogForUpdateDocumentType(String documentTypeName, String projectName) {
		log.info(" Verifing  title text   in  Audit log Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Update on " + documentTypeName
				+ " in " + projectName + " project\")]"));
		
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");
		

		return element.isDisplayed();

	}

	public boolean verifyAuditLogForCopyDocumentType(String Module, String documentTypeName, String projectName) {
		log.info(" Verifing  title text   in  Audit log Page For Copy Document Type Page...... ");
		logExtentReport("Verifing  title text   in  Audit log Page For Copy Document Type Page...... ");
		
		
		
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + Module
				+ "')]/parent::td/following-sibling::td[1]/span[contains(text(),\"Copy on " + documentTypeName + " in "
				+ projectName + " project\")]"));
		
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
				+ projectName + "' project\")]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");

		return element.isDisplayed();

	}

	public boolean verifyAuditLogForDeletedDocumentType(String documentTypeName, String projectName) {
		log.info(" Verifing  title text   in  Audit log Page For Deleted DocumentType...... ");
		logExtentReport(" Verifing  title text   in  Audit log Page For Deleted DocumentType......  ");
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Delete on " + documentTypeName
				+ " in " + projectName + " project\")]"));
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
				+ " in " + projectName + "' project\")]"));
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		log.info(" waiting  title text   in  Audit log Page...... ");
		logExtentReport("waiting   title text   in  Audit log Page...... ");
		

		return element.isDisplayed();

	}
	
	
	
	
	
	
	
	public boolean verifyAuditLogForCreateRESTAPI(String restAPIName, String projectName) {
		log.info(" Verifing    Audit log Page for  create Rest Api...... ");
		logExtentReport("Verifing    Audit log Page for  create Rest Api......  ");
		//log.info( Module+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info( restAPIName+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info(projectName+" Verifing    Audit log Page for  create Rest Api...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Create on " + restAPIName
				+ " in " + projectName + " project\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForUpdateRESTAPI(String restAPIName, String projectName) {
		log.info(" Verifing    Audit log Page for  update Rest Api...... ");
		logExtentReport("Verifing    Audit log Page for  update Rest Api......  ");
		//log.info( Module+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info( restAPIName+" Verifing    Audit log Page for  update Rest Api...... ");
		log.info(projectName+" Verifing    Audit log Page for update Rest Api...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Update on " + restAPIName
				+ " in " + projectName + " project\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForDeleteRESTAPI(String restAPIName, String projectName) {
		log.info(" Verifing    Audit log Page for  delete Rest Api...... ");
		logExtentReport("Verifing    Audit log Page for  delete Rest Api......  ");
		//log.info( Module+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info( restAPIName+" Verifing    Audit log Page for  delete Rest Api...... ");
		log.info(projectName+" Verifing    Audit log Page for delete Rest Api...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Delete on " + restAPIName
				+ " in " + projectName + " project\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForCreateKeyandTruststore(String keyandtruststoreName) {
		log.info(" Verifing    Audit log Page for  Create Key and truststore...... ");
		logExtentReport("Verifing    Audit log Page for  Create Key and truststore......  ");
		//log.info( Module+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info( keyandtruststoreName+" Verifing    Audit log Page for  Create Key and truststore...... ");
		log.info(keyandtruststoreName+" Verifing    Audit log Page for Create Key and truststore...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Create on " + keyandtruststoreName
				+ "\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForUpdateKeyandTruststore(String keyandtruststoreName) {
		log.info(" Verifing    Audit log Page for  Update Key and truststore...... ");
		logExtentReport("Verifing    Audit log Page for  Update Key and truststore......  ");
		//log.info( Module+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info( keyandtruststoreName+" Verifing    Audit log Page for  Update Key and truststore...... ");
		log.info(keyandtruststoreName+" Verifing    Audit log Page for Update Key and truststore...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Update on " + keyandtruststoreName
				+ "\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForDeleteKeyandTruststore(String keyandtruststoreName) {
		log.info(" Verifing    Audit log Page for  delete Key and truststore...... ");
		logExtentReport("Verifing    Audit log Page for  delete Key and truststore......  ");
		//log.info( Module+" Verifing    Audit log Page for  create Rest Api...... ");
		log.info( keyandtruststoreName+" Verifing    Audit log Page for  delete Key and truststore...... ");
		log.info(keyandtruststoreName+" Verifing    Audit log Page for delete Key and truststore...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Delete on " + keyandtruststoreName
				+ "\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForRestartFlowFlow(String flowservicename, String projectName) {
		log.info(" Verifing    Audit log Page for  restart enable...... ");
		logExtentReport("Verifing    Audit log Page for restart enable......  ");
		log.info( flowservicename+" Verifing    Audit log Page for restart enable...... ");
		log.info(projectName+" Verifing    Audit log Page for restart enable...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Enable for Restart on " + flowservicename
				+ " in " + projectName + " project\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForImportFlow(String flowservicename, String projectName) {
		log.info(" Verifing    Audit log Page for  import flow...... ");
		logExtentReport("Verifing   Audit log Page for import flow......  ");
		log.info( flowservicename+" Verifing    Audit log Page for import flow...... ");
		log.info(projectName+" Verifing Audit log Page for import flow...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Import on " + flowservicename
				+ " in " + projectName + " project\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogToEnableHTTPForFlow(String flowservicename, String projectName) {
		log.info(" Verifing    Audit log Page for  enable http interface flow...... ");
		logExtentReport("Verifing   Audit log Page for  enable http interface flow......  ");
		log.info( flowservicename+" Verifing    Audit log Page for  enable http interface flow...... ");
		log.info(projectName+" Verifing Audit log Page for  enable http interface flow...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Expose as REST on " + flowservicename
				+ " in " + projectName + " project\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForAddAccount(String accountname, String projectName) {
		log.info(" Verifing    Audit log Page for adding account...... ");
		logExtentReport("Verifing   Audit log Page for adding account......  ");
		log.info( accountname+" Verifing    Audit log Page for adding account...... ");
		log.info(projectName+" Verifing Audit log Page for adding account...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Create on " + accountname
				+ " in " + projectName + " project\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForDeleteAccount(String accountname, String projectName) {
		log.info(" Verifing    Audit log Page for deleting account...... ");
		logExtentReport("Verifing   Audit log Page for deleting account......  ");
		log.info( accountname+" Verifing   Audit log Page for deleting account...... ");
		log.info(projectName+" Verifing Audit log Page for deleting account...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Delete on " + accountname
				+ " in " + projectName + " project\")]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForAddRole(String rolename) {
		log.info(" Verifing    Audit log Page for adding role...... ");
		logExtentReport("Verifing   Audit log Page for adding role......  ");
		log.info( rolename+" Verifing    Audit log Page for adding role...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Create on " + rolename + ".\" )]"));
		

		return element.isDisplayed();

	}
	public boolean verifyAuditLogForDeleteRole(String rolename) {
		log.info(" Verifing    Audit log Page for deleting role...... ");
		logExtentReport("Verifing   Audit log Page for deleting role......  ");
		log.info( rolename+" Verifing    Audit log Page for deleting role...... ");
		

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),\"Create on " + rolename + ".\" )]"));
		

		return element.isDisplayed();

	}
	

	public void SearchAnElement(String Element)
	{
		log.info("Search the element" +Element);
		logExtentReport("Search the element" +Element);
		searchfieldAuditlog.click();
		searchfieldAuditlog.sendKeys(Element);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

	}



	public void Searchclearfield()
	{
		log.info("clear the element" );
		logExtentReport("clear the element");
		searchfieldAuditlog.click();
		searchfieldAuditlog.clear();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	
	
	
	
	

}
