package com.webMethodsUI.origin.pageObjects.WF_31899_RevisitCertificates;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

import io.restassured.path.xml.XmlPath;

public class Locators extends CommonActions {
	
 String truststorePassowrd = "";
	public Locators(WebDriver driver) {
		super();
 		this.driver = driver;
 		PageFactory.initElements(driver, this);
	}
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	@FindBy(xpath = "//span[normalize-space()='Key/Certificate']")
	@CacheLookup
	WebElement certificateTab;
	
	@FindBy(xpath = "//a[normalize-space()='Runtimes']")
	@CacheLookup
	WebElement RuntimeTab;
	
	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	WebElement newButton;
	
	public void opneProjetc() throws Exception {
		WebElement ele = findElement("//a[normalize-space()='Projects']", driver);
		click(ele, driver, "Click on projetc");
		Thread.sleep(9000);
	}
	
	
	public void configureJDBCConnection() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "wait for loader is not visible");
		WebElement ele = findElement("//select[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.transactionType']", driver);
		Select select = new Select(ele);
		Thread.sleep(5000);
		select.selectByIndex(1);
		//click(ele.get(0), driver, "Click on drop down");
        String selectedValue = select.getFirstSelectedOption().getText();
        System.out.println("Selected Value: " + selectedValue);
		Thread.sleep(8000);
		WebElement ele1 = findElement("//select[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.driverType']", driver);
		Select select2 = new Select(ele1);
		Thread.sleep(5000);
		select2.selectByIndex(1);
		//click(ele.get(0), driver, "Click on drop down");
        String selectedValue2 = select2.getFirstSelectedOption().getText();
        System.out.println("Selected Value: " + selectedValue2);
		Thread.sleep(8000);
	//	WebElement ele2 = findElement("//select[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.driverType']", driver);
		//click(ele2, driver, "Click on dropdown");
		WebElement ele3 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.datasourceClass']", driver);
		enterValue(ele3, "com.wm.dd.jdbcx.oracle.OracleDataSource", driver, "ENter data source class");
		WebElement ele4 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.serverName']", driver);
		enterValue(ele4, "adapter-oracle-121-on-amazonrds.cdmjexwbzoym.us-east-1.rds.amazonaws.com", driver, "Enter server name");
		WebElement ele5 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.user']", driver);
		enterValue(ele5, "JDBC_BVT", driver, "Enter user name");
		WebElement ele6 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.password']", driver);
		enterValue(ele6, "JDBC_BVT", driver, "Enter Password");
		WebElement ele7 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.databaseName']", driver);
		enterValue(ele7, "ORCL", driver, "Enter Database name");
		WebElement ele8 =  findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.portNumber']", driver);
		enterValue(ele8, "2484", driver, "Enter port number");
		WebElement ele9 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.trustStoreAlias']", driver);
		enterValue(ele9, "DEFAULT_IS_TRUSTSTORE", driver, "Enter default truststore Name");
		WebElement ele10 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.trustStorePassword']", driver);
		enterValue(ele10, truststorePassowrd, driver, "Enter trustore password");
		WebElement ele11 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.otherProperties']", driver);
		enterValue(ele11, "driverType=thin", driver, "Enter value for other properties");
		WebElement ele12 = findElement("//input[@id='artConnection.JDBCAdapter.connection.SSL_ORCL.connectionSettings.networkProtocol']", driver);
		enterValue(ele12, "tcps", driver, "Enter network protocal");
		WebElement ele13 = findElement("//button[normalize-space()='Save']", driver);
		click(ele13, driver, "Click on save connection");
		
		
		
	}
	
	//h1[normalize-space()='Add new store']

	@FindBy(xpath = "//h1[normalize-space()='Add new store']")
	@CacheLookup
	WebElement addnewStoreText;
	
	@FindBy(xpath = "//input[@placeholder='Enter new store name']")
	@CacheLookup
	WebElement EnterNewStoreNamete;
	
	@FindBy(xpath = "//span[contains(text(),'The name provided here will create a key store and')]")
	@CacheLookup
	WebElement infoMessage;
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(xpath = "//i[@title='Manage a key store to identify your runtime(s) when connecting to external systems via HTTPS and other TLS related protocols']")
	@CacheLookup
	WebElement IdentifyInfo;
	
	@FindBy(xpath = "//i[@title='Manage a trust store to identify remote systems and users that require HTTPS connectivity into your runtime(s)']")
	@CacheLookup
	WebElement TruststoreInfo;
	
	@FindBy(xpath = "//a[contains(text(),'+ Add')]")
	@CacheLookup
	List<WebElement> CertificateSaddButton;
	
	@FindBy(xpath = "//div[@class='trust-store store-pane']//div[@class='table-cell empty-list'][normalize-space()='No certificates added.']")
	@CacheLookup
	WebElement NoCertforTruststore;
	
	@FindBy(xpath = "//div[@class='key-store store-pane']//div[@class='table-cell empty-list'][normalize-space()='No certificates added.']")
	@CacheLookup
	WebElement NoCertforKeyStore;
	
	public void defaultTruststore(String StoreName) throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement ele = findElement("//label[@for='"+StoreName+"']//span[@class='radio-btn-label-text']", driver);
		click(ele, driver, "Click on "+StoreName);
		WebElement ele1 = findElement("//h1[normalize-space()='Warning']", driver);
		elementContainsText(ele1, "Warning", driver, "Verify Warning is visible");
		WebElement ele2 = findElement("//button[normalize-space()='Update default']", driver);
		click(ele2, driver, "Click on update Default");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visible");
		//WebElement ele3 = findElement("//label[@for='ICAutomationTest']//span[@class='radio-btn-label-text']//parent::span[@class='default-decor']", driver);
		//waitForElementVisible(ele3, driver, "Wait for element visible");
		
		
		
		
		
		
	}
	
	
	public void emptyCertforKeystorPassword() throws Exception {
		SoftAssert assertion = new SoftAssert();
		StringSelection emptySelection = new StringSelection("");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(emptySelection, null);
		WebElement ele = findElement("//div[@class='key-store store-pane']//span[@title='Copy password']",driver);
		click(ele, driver, "click on copy docker command");
		String dockerururl = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		Thread.sleep(6000);
		System.out.println("password for KeyStore  "+dockerururl);
		assertion.assertNotNull("Password for keystore in not null" + dockerururl);
		
	}
	
	public void clickOnProfile() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "wait for loader not visible");
		WebElement ele = findElement("//i[@class='delite-icon dlt-icon-profile']", driver);
		click(ele, driver, "Click on profile");
		WebElement ele2 = findElement("//span[normalize-space()='Settings']", driver);
		click(ele2, driver, "click on Settings");	
		
	}
	
	public void fileUploadUsingInputType(WebElement BrowseFileElement, String filePath) throws Exception 
	{
		logExtentReport("Uploading File.. " +filePath+ " Uisng element.. "+BrowseFileElement);
		try {
		BrowseFileElement.sendKeys(filePath);
		}
		catch(Exception e)
		{
			logExtentReport(e.getMessage());
		}
		waitForElementNotVisible(loader, driver, "wait for page load");		
	}
	
	public void deleteRuntimeStore(String storeName) throws Exception {
		WebElement ele = findElement("//input[@id='"+storeName+"']/ancestor::div[@class='table-row runtimes-certificates-stores-row']//i[@title='Delete store']", driver);
		click(ele, driver, "Click on delete button of Store");
		WebElement ele1  = findElement("//h1[normalize-space()='Delete "+storeName+"']", driver);
		elementContainsText(ele1, "Delete "+storeName+"", driver, "Verify delete confirm dialog visible");
		WebElement ele2 = findElement("//button[normalize-space()='Yes']", driver);
		click(ele2, driver, "Click on yes to confirm delete runtime store");
	}
	
	public void validateCertificateTab() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "wait for loader not visible");
		elementContainsText(certificateTab, "Key/Certificate", driver, "Verify key or certificate table visible");
		click(RuntimeTab, driver, "Click on runtime tab");
		
	}
	
	public void addNewRuntimeStore(String storeName) throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "loader is not visble");
		click(newButton, driver, "Click on new add button");
		elementContainsText(addnewStoreText, "Add new store", driver, "add new text visible");
		enterValue(EnterNewStoreNamete, storeName, driver, "Enter value for store name");
		click(nextButton, driver, "Click on next button");
	}
	
	public void validateCertificatePage(String storeName) throws Exception {
		
		WebElement ele = findElement("//h1[normalize-space()='"+storeName+"']", driver);
		elementContainsText(ele, storeName, driver, "Verify Store name visible");
		waitForElementVisible(NoCertforKeyStore, driver, "No certificate for Key store visible");
		waitForElementVisible(NoCertforTruststore, driver, "No Certificate for trust store visible");
		waitForElementVisible(CertificateSaddButton.get(0), driver, "add button visible");
		waitForElementVisible(CertificateSaddButton.get(1), driver, "add button visible");
		waitForElementVisible(IdentifyInfo, driver, "Verify info message for Identify");
		waitForElementVisible(TruststoreInfo, driver, "verify info message for trust store");
	}
	
	
	
	public void emptyCertforTruststorPassword() throws Exception {
		SoftAssert assertion = new SoftAssert();
		StringSelection emptySelection = new StringSelection("");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(emptySelection, null);
		WebElement ele = findElement("//div[@class='trust-store store-pane']//span[@title='Copy password']",driver);
		click(ele, driver, "click on copy password");
		truststorePassowrd = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		Thread.sleep(6000);
		System.out.println("Password for truststore "+truststorePassowrd);
		assertion.assertNotNull("Password for truststore in not null"+ truststorePassowrd);
		
	}
	
	public void addKeyStore(String filepath) throws Exception {
		
		WebElement ele = findElement("//div[@class='key-store store-pane']//a[@class='dropdown-button certificate-button right secondary-btn small'][normalize-space()='+ Add']", driver);
		click(ele, driver, "Click on add certificate button");
		WebElement ele2 = findElement("//ul[@id='runtime-certificate-identity-store']//li//a[@href='javascript:;'][normalize-space()='Import Keystore']", driver);
		elementContainsText(ele2, "Import Keystore", driver, "Verify import keystore is visible");
		
		WebElement ele3 = findElement("//ul[@id='runtime-certificate-identity-store']//li//a[@href='javascript:;'][normalize-space()='Import Certificate']", driver);
		elementContainsText(ele3, "Import Certificate", driver, "Verify import Certificate is visible");
		
		click(ele2, driver, "Click on import certificate");
		
		WebElement ele4 = findElement("//h1[normalize-space()='Import Keystore']", driver);
		elementContainsText(ele4, "Import Keystore", driver, "Verify text is visble");
		
		
		//click(ele5, driver, "Click on browse file");
		
		//uploadFile(ele5, filepath, driver, "Upload key store to runtime store");
		WebElement ele5 = findElement("//button[normalize-space()='Browse']", driver);
		ele5.click();
		String filePath = System.getProperty("user.dir")+filepath;
		//ele5.sendKeys(filePath);
		//uploadFile("C://Users//RAJKA//Downloads//329364933.jks", "upload a file");
		 StringSelection selection = new StringSelection(filePath);
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

         // Simulate CTRL+V and Enter key presses
         Robot robot = new Robot();
         robot.delay(1000); // Wait for the dialog to appear
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         
         // Add delay to observe result (optional)
         Thread.sleep(3000);
		
		//String path2 = System.getProperty("user.dir");
		//driver.findElement(By.xpath("//button[normalize-space()='Browse']")).sendKeys(path2+"\\src\\main\\resources\\importfiles\\329364933.jks");
		
		//ele5.sendKeys(filePath);
		//fileUploadUsingInputType(ele5, filepath);
		
		//uploadSampleFileFlatfileWithNoRecordIdentifier();
		
		WebElement ele6=  findElement("//input[@name='Passphrase']", driver);
		enterValue(ele6, "changeit", driver, "Enter the password");
		
		WebElement ele7 = findElement("//button[normalize-space()='Next']", driver);
		click(ele7, driver, "Click on next button");
		
		WebElement ele8 = findElement("//div[@class='alias-list-header']", driver);
		elementContainsText(ele8,"Protect Key Aliases with Passphrases" , driver, "verify text is visible");
		
		WebElement ele9 = findElement("//span[@class='parameters-value']", driver);
		click(ele9, driver, "Click on text to check the checkbox");
		
		WebElement ele10 = findElement("//button[normalize-space()='Save']", driver);
		click(ele10, driver, "Click on save button");
		
		WebElement ele11 = findElement("//span[normalize-space()='azstagetenant1.cc.az-us.webmethodscloud-stage.com']", driver);
		elementContainsText(ele11, "azstagetenant1.cc.az-us.webmethodscloud-stage.com", driver, "Verify certificate uploaded");
		waitForElementLoaderNotVisible(loader, driver, "wait for loader");
		WebElement ele12 = findElement("//i[@title='Delete certificate/store']", driver);
		waitForElementVisible(ele12, driver, "Wait for Element visible");
		
	}
	
	public void addTrustStore(String filepath) throws Exception {
		
		WebElement ele = findElement("//div[@class='trust-store store-pane']//a[@class='dropdown-button certificate-button right secondary-btn small'][normalize-space()='+ Add']", driver);
		click(ele, driver, "Click on add certificate button");
		WebElement ele2 = findElement("//ul[@id='runtime-certificate-trust-store']//li//a[@href='javascript:;'][normalize-space()='Import Keystore']", driver);
		elementContainsText(ele2, "Import Keystore", driver, "Verify import keystore is visible");
		
		WebElement ele3 = findElement("//ul[@id='runtime-certificate-trust-store']//li//a[@href='javascript:;'][normalize-space()='Import Certificate']", driver);
		elementContainsText(ele3, "Import Certificate", driver, "Verify import Certificate is visible");
		
		click(ele2, driver, "Click on import certificate");
		
		WebElement ele4 = findElement("//h1[normalize-space()='Import Truststore']", driver);
		elementContainsText(ele4, "Import Truststore", driver, "Verify text is visble");
		
		WebElement ele5 = findElement("//button[normalize-space()='Browse']", driver);
		ele5.click();
		String filePath = System.getProperty("user.dir")+filepath;
		//ele5.sendKeys(filePath);
		//uploadFile("C://Users//RAJKA//Downloads//329364933.jks", "upload a file");
		 StringSelection selection = new StringSelection(filePath);
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

         // Simulate CTRL+V and Enter key presses
         Robot robot = new Robot();
         robot.delay(1000); // Wait for the dialog to appear
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         
         // Add delay to observe result (optional)
         Thread.sleep(3000);
		
		WebElement ele6=  findElement("//input[@name='Passphrase']", driver);
		enterValue(ele6, "manage", driver, "Enter the password");
		
		/*
		 * WebElement ele7 = findElement("//button[normalize-space()='Next']", driver);
		 * click(ele7, driver, "Click on next button");
		 * 
		 * WebElement ele8 = findElement("//div[@class='alias-list-header']", driver);
		 * elementContainsText(ele8,"Protect Key Aliases with Passphrases" , driver,
		 * "verify text is visible");
		 * 
		 * WebElement ele9 = findElement("//span[@class='parameters-value']", driver);
		 * click(ele9, driver, "Click on text to check the checkbox");
		 */
		
		WebElement ele10 = findElement("//button[normalize-space()='Save']", driver);
		click(ele10, driver, "Click on save button");
		waitForElementLoaderNotVisible(loader, driver, "loader is not visible");
		WebElement ele11 = findElement("//span[normalize-space()='is-aws2024']", driver);
		elementContainsText(ele11, "is-aws2024", driver, "Verify certificate uploaded");
		waitForElementLoaderNotVisible(loader, driver, "wait for loader");
		WebElement ele12 = findElement("//i[@title='Delete certificate/store']", driver);
		waitForElementVisible(ele12, driver, "Verify delete button visible");
		
	}
	
	public void completeKey_Trust_StoreCreation() throws Exception {
		WebElement ele  = findElement("//button[normalize-space()='Done']", driver);
		click(ele, driver, "Click on done button");
	}
	
	
	
	public void uploadSampleFileFlatfileWithNoRecordIdentifier() throws Exception
	{
		logExtentReport("uploading sample file flatfile with no record identifer..........");
		WebElement BrowseFileElement = findElement("//button[normalize-space()='Browse']",driver);
        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\329364933.jks");
        FileUpload fileupload = new FileUpload(driver);
        fileupload.fileUploadUsingInputType(BrowseFileElement,filePath);
        Thread.sleep(4000);

	}
	
	
	
	
	
	
	
	
	
	
	

}
