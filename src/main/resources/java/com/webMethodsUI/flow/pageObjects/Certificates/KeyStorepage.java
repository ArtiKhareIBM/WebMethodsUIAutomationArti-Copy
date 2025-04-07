package com.webMethodsUI.flow.pageObjects.Certificates;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

public class KeyStorepage {
    private WebDriver driver;
    private Logger log = LogManager.getLogger(KeyStorepage.class);
    TestBase test;
    WaitHelper waitHelper;

    @FindBy(xpath = "//h1[contains(text(),'keystore certificate')]")
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

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/input[1]")
    @CacheLookup
    WebElement InputfieldKeyaliase;


    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/span[1]/input[1]")
    @CacheLookup
    WebElement webmcloudwild_newField;

    @FindBy(xpath = "//span[contains(text(),'integrationlive_sso')]/parent::span/following-sibling::div/span/input")
    @CacheLookup
    WebElement integrationlive_ssoField;

    @FindBy(xpath = "//span[contains(text(),'saglive.com')]/parent::span/following-sibling::div/span/input")
    @CacheLookup
    WebElement saglivecomField;


    @FindBy(xpath = "//span[contains(text(),'webmcloudwild_new')]/parent::span/following-sibling::div/span/input")
    @CacheLookup
    WebElement webmcloudwild_new2Field;

    @FindBy(xpath = "//textarea[@name='Description']")
    @CacheLookup
    WebElement descriptiontextfield;

    @FindBy(xpath = "//input[@value='JKS']")
	@CacheLookup
	WebElement keystoretype;

    @FindBy(xpath = "//input[@value='Select Provider']")
	@CacheLookup
	WebElement providertype;

    @FindBy(xpath = "//input[@name='Passphrase-0']")
   	@CacheLookup
   	WebElement keyalias;





    public KeyStorepage(WebDriver driver){
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
    public void keyaliasphrasecode(String Phrasepasscode){
        log.info("Entering the passphrase of keystore..." + Phrasepasscode);
        logExtentReport("Entering the passphrase of keystore..." + Phrasepasscode);
        keyalias.click();
        keyalias.sendKeys(Phrasepasscode);
    }

    public void EnteringwebmcloudwildField(int index,String Phrasepasscode){
        log.info("Entering the passphrase of keystore webmcloudwilds..." + Phrasepasscode);
        logExtentReport("Entering the passphrase of keystore webmcloudwilds..." + Phrasepasscode);
        List<WebElement> elemntArray = driver
                .findElements(By.xpath("//span[contains(text(),'webmcloudwild_new')]/parent::span/following-sibling::div/span/input"));
        log.info("All input parameters are....." + elemntArray);
        WebElement element = elemntArray.get(index);
        element.click();
        element.sendKeys(Phrasepasscode);
    }

    public void EnteringintegrationliveField(String Phrasepasscode){
        log.info("Entering the passphrase of keystore integrationlive..." + Phrasepasscode);
        logExtentReport("Entering the passphrase of keystore integrationlive.." + Phrasepasscode);
        integrationlive_ssoField.click();
        integrationlive_ssoField.sendKeys(Phrasepasscode);
    }

    public void EnteringsaglivecomField(String Phrasepasscode){
        log.info("Entering the passphrase of keystore saglivecom..." + Phrasepasscode);
        logExtentReport("Entering the passphrase of keystore saglivecom..." + Phrasepasscode);
        saglivecomField.click();
        saglivecomField.sendKeys(Phrasepasscode);
    }
    public void Enteringwebmcloudwild2Field(String Phrasepasscode){
        log.info("Entering the passphrase of keystore webmcloudwild2..." + Phrasepasscode);
        logExtentReport("Entering the passphrase of keystore webmcloudwild2.." + Phrasepasscode);
        webmcloudwild_newField.click();
        webmcloudwild_newField.sendKeys(Phrasepasscode);
    }

    public void ClickingNextbutton(){
        try {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Next");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



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


    public void uploadKeystorefile(){
        try {
            String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\wmcloud_keystore.jks");
            FileUpload fileUpload = new FileUpload(driver);
            fileUpload.fileUploadUsingInputType(Browseelement, filePath);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void selectkeystoretype(String keyType) {

		try {

			GenericHelper genericHelper = new GenericHelper(driver);
			genericHelper.clickOnDropDown(keystoretype,0);
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
    public void uploadKeystorefilecommon(String filePath1 ){
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
 public void uploadkeystoreAddobe(){

    try {
        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\wstsfenterprise2021_jwt.jks");
        FileUpload fileUpload = new FileUpload(driver);
        fileUpload.fileUploadUsingInputType(Browseelement, filePath);
    }
        catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

    }}


    public void EnteringKeys(String Phrasepasscode){
        log.info("Entering the Keyaliase of keystore..." + Phrasepasscode);
        logExtentReport("Entering the Keyaliase of keystore..." + Phrasepasscode);
        InputfieldKeyaliase.click();
        InputfieldKeyaliase.sendKeys(Phrasepasscode);

    }

    public void EnteringDescription(String Description){
        log.info("Entering the Description.." + Description);
        logExtentReport("Entering the Description.." + Description);
        descriptiontextfield.click();
        descriptiontextfield.sendKeys(Description);

    }

    public void ClickingUpdatebutton(){
        try {

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Update");

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }



    }


}
