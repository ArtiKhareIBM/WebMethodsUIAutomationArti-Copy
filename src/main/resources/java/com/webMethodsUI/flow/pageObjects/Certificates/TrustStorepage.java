package com.webMethodsUI.flow.pageObjects.Certificates;

import java.util.Random;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class TrustStorepage {

    private WebDriver driver;
    private Logger log = LogManager.getLogger(TrustStorepage.class);
    TestBase test;
    WaitHelper waitHelper;

    @FindBy(xpath = "//h1[contains(text(),'truststore certificate')]")
    @CacheLookup
    WebElement KeystoreTitlepage;

    @FindBy(xpath = "//input[@aid='Name']")
    @CacheLookup
    WebElement NameField;

    @FindBy(xpath = "//input[@aid='Passphrase']")
    @CacheLookup
    WebElement PassphraseField;

    @FindBy(xpath = "//input[@id='myRecipiesfileInput']")
    @CacheLookup
    WebElement Browseelement;

    @FindBy(xpath = "//textarea[@name='Description']")
    @CacheLookup
    WebElement descriptiontextfield;

    @FindBy(xpath = "//input[@value='JKS']")
	@CacheLookup
	WebElement trustoretype;

    @FindBy(xpath = "//input[@value='Select Provider']")
	@CacheLookup
	WebElement providertype;


    public TrustStorepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(KeystoreTitlepage, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now...." + KeystoreTitlepage);
        logExtentReport("Element is visible");
    }



    public void EnteringKeyStoreName(String KeystoreName){
        Random objGenerator = new Random();
        int randomNumber = objGenerator.nextInt(200);
        String name = KeystoreName+randomNumber;
        log.info("Entering the Name of keystore..." + KeystoreName);
        logExtentReport("Entering the Name of keystore..." + KeystoreName);
        NameField.click();
        NameField.sendKeys(name);
    }


    public void Enteringphrasecode(String Phrasepasscode){
        log.info("Entering the passphrase of keystore..." + Phrasepasscode);
        logExtentReport("Entering the passphrase of keystore..." + Phrasepasscode);
        PassphraseField.click();
        PassphraseField.sendKeys(Phrasepasscode);
    }
    public CertificatesHomepage ClickingSavebutton(){
        try {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Save");
            return new CertificatesHomepage(driver);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new CertificatesHomepage(driver);
        }



    }

    public void uploadTrustfile(){
        try {
            String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\wmcloud_truststore.jks");
            FileUpload fileUpload = new FileUpload(driver);
            fileUpload.fileUploadUsingInputType(Browseelement, filePath);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void selecttrustoretype(String keyType) {

		try {

			GenericHelper genericHelper = new GenericHelper(driver);
			genericHelper.clickOnDropDown(trustoretype,0);
			genericHelper.selectDropDownLink(keyType);
			log.info("Clicked on keystore type....");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    public void seletcprovidertype(String provider) {

		try {

			GenericHelper genericHelper = new GenericHelper(driver);
			genericHelper.clickOnDropDown(providertype,0);
			genericHelper.selectDropDownLink(provider);
			log.info("Clicked on keystore type....");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    public void uploadTrustorefilecommon(String filePath1 ){
        try {
            String filePath = ResourceHelper.getResourcePath(filePath1);
            FileUpload fileUpload = new FileUpload(driver);
            fileUpload.fileUploadUsingInputType(Browseelement, filePath);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }


    public void EnteringDescription(String Description){
        log.info("Entering the Description.." + Description);
        logExtentReport("Entering the Description.." + Description);
        descriptiontextfield.click();
        descriptiontextfield.sendKeys(Description);

    }



}
