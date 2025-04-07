package com.webMethodsUI.flow.pageObjects.Certificates;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.fileupload.FileUpload;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class KeyStorepage extends CommonActions{
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

    @FindBy(xpath = "//div[contains(text(),'JKS')]")
	@CacheLookup
	WebElement keystoretype;

    @FindBy(xpath = "//div[contains(text(),'Select Provider')]")
	@CacheLookup
	WebElement providertype;

    @FindBy(xpath = "//input[@name='Passphrase-0']")
   	@CacheLookup
   	WebElement keyalias;





    public KeyStorepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("KeyStore Page Object created");
        logExtentReport("KeyStore Page Object created");

    }

    public String EnteringKeyStoreName(String KeystoreName) throws Exception
    {
        Random objGenerator = new Random();
        int randomNumber = objGenerator.nextInt(200);
        String name = KeystoreName+randomNumber;
        enterValue(NameField, name, driver, "Entering the Name of keystore..." + KeystoreName);
        
        return name;
    }

    public void Enteringphrasecode(String Phrasepasscode) throws Exception
    {
         enterValue(PassphraseField, Phrasepasscode, driver, "Entering the passphrase of keystore..." + Phrasepasscode);

    }
    public void keyaliasphrasecode(String Phrasepasscode) throws Exception
    {
        enterValue(keyalias, Phrasepasscode, driver, "Entering the passphrase of keystore..." + Phrasepasscode);

    }

    public void EnteringwebmcloudwildField(int index,String Phrasepasscode) throws Exception
    {
    	List<WebElement> elemntArray = driver
                .findElements(By.xpath("//span[contains(text(),'webmcloudwild_new')]/parent::span/following-sibling::div/span/input"));
        WebElement element = elemntArray.get(index);
        enterValue(element, Phrasepasscode, driver, "Entering the passphrase of keystore webmcloudwilds..." + Phrasepasscode);

    }

    public void EnteringintegrationliveField(String Phrasepasscode) throws Exception
    {

        enterValue(integrationlive_ssoField, Phrasepasscode, driver, "Entering the passphrase of keystore integrationlive..." + Phrasepasscode);
    }

    public void EnteringsaglivecomField(String Phrasepasscode) throws Exception
    {

        enterValue(saglivecomField, Phrasepasscode, driver, "Entering the passphrase of keystore saglivecom..." + Phrasepasscode);
    }

    public void Enteringwebmcloudwild2Field(String Phrasepasscode) throws Exception
    {
        enterValue(webmcloudwild_newField, Phrasepasscode, driver, "Entering the passphrase of keystore webmcloudwild2..." + Phrasepasscode);

    }

    public void ClickingNextbutton() throws Exception
    {
            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Next");
    }


    public CertificatesHomepage ClickingSavebutton() throws Exception{

            GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Save");
            return new CertificatesHomepage(driver);
    }


    public void uploadKeystorefile() throws Exception
    {
            String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\wmcloud_keystore.jks");
            FileUpload fileUpload = new FileUpload(driver);
            fileUpload.fileUploadUsingInputType(Browseelement, filePath);
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


    public void selectkeystoretype(String keyType) throws Exception {

			GenericHelper genericHelper = new GenericHelper(driver);
			genericHelper.clickOnDropDown(keystoretype,0);
			genericHelper.selectDropDownLink(keyType);
			log.info("Clicked on keystore type....");

	}

    public void seletcprovidertype(String provider) throws Exception {

			GenericHelper genericHelper = new GenericHelper(driver);
			genericHelper.clickOnDropDown(providertype,0);
			genericHelper.selectDropDownLink(provider);
			log.info("Clicked on keystore type....");

	}

    public void uploadKeystorefilecommon(String filePath1 ) throws Exception{
            String filePath = ResourceHelper.getResourcePath(filePath1);
            FileUpload fileUpload = new FileUpload(driver);
            fileUpload.fileUploadUsingInputType(Browseelement, filePath);
    }

 public void uploadkeystoreAddobe() throws Exception{

        String filePath = ResourceHelper.getResourcePath("\\src\\main\\resources\\importfiles\\wstsfenterprise2021_jwt.jks");
        FileUpload fileUpload = new FileUpload(driver);
        fileUpload.fileUploadUsingInputType(Browseelement, filePath);
   }

    public void EnteringKeys(String Phrasepasscode) throws Exception
    {

        enterValue(InputfieldKeyaliase, Phrasepasscode, driver, "Entering the Keyaliase of keystore..." + Phrasepasscode);

    }

    public void EnteringDescription(String Description) throws Exception
    {
        enterValue(descriptiontextfield, Description, driver, "Entering the Description.." + Description);

    }

    public void ClickingUpdatebutton() throws Exception{
                    GenericHelper genericHelper = new GenericHelper(driver);
            genericHelper.clickButton("Update");
    }

}
