package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddAccountPage;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ClientCertificateConfigurationpage extends CommonActions{


    WebDriver driver;
    private Logger log = LogManager.getLogger(ClientCertificateConfigurationpage.class);

    @FindBy(xpath = "//span[contains(text(),'Two-way SSL Security Mode')]")
    @CacheLookup
    WebElement configurationheading;

    @FindBy(xpath = "//*[@id='material-select-id']")
    @CacheLookup
    WebElement securitymodedropdown;

//    @FindBy(xpath = "//button[contains(text(),'Apply')]")
//    @CacheLookup
//    WebElement Applybutton;

    @FindBy(xpath = "//*[contains(@class,'dlt-icon-chevron-right')]")
    @CacheLookup
    WebElement certificateexpandicon;


//    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
//    @CacheLookup
//    WebElement Proceedbutton;


    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    @CacheLookup
    WebElement Cancelbutton;


    public ClientCertificateConfigurationpage(WebDriver driver) {

        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        log.info("Client certificate page object is created");
        logExtentReport("Client certificate page object is created");
    }

    public void SelectSecuritymode(String Link) throws Exception 
    {
        click(securitymodedropdown, driver, "Click on dropdown");
        WebElement element = findElement("//div[contains(text(),'" + Link + "')]",driver);
        click(element, driver, "Select .."+Link);
        waitForElementNotVisible(loader, driver, "wait for page load");

    }
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

    public TenantCertificatepage goingtotenentCertificatepage() throws Exception 
    {

        WebElement element = findElement("//a[contains(text(),'Tenant certificate')]",driver);
        click(element, driver, "Select Tenant Certificate");
    	waitForElementNotVisible(loader, driver, "wait for page load");
        return new TenantCertificatepage(driver);
    } 

    public UserCertificatepage goingtoUserCertificatepage() throws Exception 
    {
        WebElement element = findElement("//a[contains(text(),'User certificate')]",driver);
        click(element, driver, "Select User Certificate");
    	waitForElementNotVisible(loader, driver, "wait for page load");

        return new UserCertificatepage(driver);
    }

    public void ApplyProceedbutton() throws Exception 
    {
    	 WebElement element1 = findElement("//button[contains(text(),'Apply')]",driver);
        click(element1, driver, "click Apply button");
        WebElement element2 = findElement("//button[contains(text(),'Proceed')]",driver);
        click(element2, driver, "click Proceed button");
    }


    public boolean ApplybuttonVisible() throws Exception 
    {
    	 WebElement Applybutton = findElement("//button[contains(text(),'Apply')]",driver);
         waitForElementVisible(Applybutton, driver, "verify Apply button is visible");

        return Applybutton.isDisplayed();
    }

    public boolean CancelbuttonVisible() {
        log.info("verify Cancel button is visible");
        logExtentReport("verify Cancel button is visible");
        return Cancelbutton.isDisplayed();
    }


    public String getSuccesMessageofImportfile() throws Exception {
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        waitForElementVisible(SuccessMessage, driver, "Wait for SuccessMessage to visible");
        return SuccessMessage.getText();
    }

    public boolean ClientCertificateIsVisible() throws Exception {
        log.info("verify Client Certificate is visible");
        logExtentReport("verify Client Certificate button is visible");
        WebElement element = findElement("//span[contains(text(),'Client certificate')]",driver);
        return element.isDisplayed();
    }

    public boolean UsageMessgae() throws Exception {
        log.info("verify usage information visible");
        logExtentReport("verify usage information is visible");
        WebElement element = findElement("//div[@class='inline-message']",driver);
        return element.isDisplayed();
    }

    public boolean Verfifylistsof2sslmodes() throws Exception {

        WebElement element1 = findElement("//*[contains(@class,'dlt-icon-chevron-right')]",driver);
        return element1.isDisplayed();
    }

    public boolean VerifyTenantlevelUserlevel() throws Exception 
    {
        log.info("verify the tenant level and userlevel is  visible ");
        logExtentReport("verify the tenant level and userlevel is  visible");
        WebElement element1 = findElement("//a[contains(text(),'User certificate')]/parent::li",driver);
        return element1.isDisplayed();
//        WebElement element2 = findElement("//a[contains(text(),'Tenant certificate')]/parent::li",driver);
//        return element2.isDisplayed();

    }

    public void waittillitappears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ObjectReader.reader.getExplicitWait()));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(SuccessMessage, SuccessMessage.getText())));
    }

    public void expandicon() 
    {
        certificateexpandicon.click();
    }
 

    public boolean OauthIsVisible() {
        log.info("verify OAuth 2.0 is visible");
        logExtentReport("verify OAuth 2.0 button is visible");
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'OAuth 2.0')]"));
        return element.isDisplayed();
    }
    
	public static KeyStore generateKeystore(String keystoreFilePath,String keystorePassword)
	{
		KeyStore keyStore = null;
		SSLConfig config = null;
		try 
		{
			logExtentReport("loading keystore");
	        keyStore = KeyStore.getInstance("jks");
	        keyStore.load(
	                new FileInputStream(keystoreFilePath),
	                keystorePassword.toCharArray());

	    } catch (Exception ex) 
		{
	        System.out.println("Error while loading keystore >>>>>>>>>");
	        logFailedExtentReport("Error while loading keystore >>>>>>>>>");
	        ex.printStackTrace();
	    }
			return keyStore;
	}
    
	public static void Make2waySSLInvocation(String URL,KeyStore keystore) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException
	{
		
		try
		{
			logExtentReport("Test 2 way SSL for service invocation with user certficate");
			KeyStore keyStore = keystore;
		SSLConfig config = null;
		String keystorePassword = "changeit";
		int port = 8443;
		
		RestAssured.baseURI = URL;
		if (keystore != null) 
	    {

	        @SuppressWarnings("deprecation")
			org.apache.http.conn.ssl.SSLSocketFactory clientAuthFactory = new org.apache.http.conn.ssl.SSLSocketFactory(keyStore, keystorePassword);

	        // set the config in rest assured
	        config = new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames();
	
	    }
		RestAssured.config = RestAssuredConfig.config().sslConfig(config).httpClient(HttpClientConfig.httpClientConfig()
	                    .setParam("http.socket.timeout",60000)
	                    .setParam("http.connection.timeout", 60000));
		
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.port(port);
		httpRequest.header("Content-Type","application/json");	
	//	httpRequest.headers("Authorization","Basic "+base64EncodingString(ObjectReader.reader.getUserName(),ObjectReader.reader.getPassword())+"");
		
		//	httpRequest.auth().basic(ObjectReader.reader.getUserName(),ObjectReader.reader.getPassword());
		Response response = httpRequest.request(io.restassured.http.Method.POST);
		String responseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();
		logExtentReport(responseBody);
		logExtentReport("Status code: "+Integer.toString(statusCode));
		Assert.assertEquals(statusCode, 200);
	}
	catch(Exception e)
	{
		logFailedExtentReport(e.getMessage());
	}
	
	}
}