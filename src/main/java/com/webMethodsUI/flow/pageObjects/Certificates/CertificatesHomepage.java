package com.webMethodsUI.flow.pageObjects.Certificates;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class CertificatesHomepage extends CommonActions
{
    private WebDriver driver;
    private Logger log = LogManager.getLogger(CertificatesHomepage.class);
    TestBase test;
    WaitHelper waitHelper;

    @FindBy(xpath = "//span[contains(text(),'Certificates')]")
    @CacheLookup
    WebElement CertificateTitlepage;

    @FindBy(xpath = "//a[contains(text(),'New certificate')]")
    @CacheLookup
    WebElement AddCertificate;

    @FindBy(xpath = "//a[contains(text(),'Keystore')]")
    @CacheLookup
    WebElement AddNewkeyStore;

    @FindBy(xpath = "//a[contains(text(),'Truststore')]")
    @CacheLookup
    WebElement AddTruststore;

    @FindBy(xpath = "//button[@class=' btn btn-link delete-btn-prmy btn-sm']")
    @CacheLookup
    WebElement flowServiceDeleteButtonElement;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;

    @FindBy(xpath = "//span[contains(text(),'Cannot delete this certificate as it is being used')]")
	WebElement CertficateDelete;




    public CertificatesHomepage(WebDriver driver) throws Exception{
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("Certificate Page Object");
        logExtentReport("Certificate Page Object created");
        waitForElementNotVisible(loader, driver, "wait for page load");
    }
    
    public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

    public KeyStorepage Addkeystore() throws Exception
    {
        click(AddCertificate, driver, "Clicking New certificate button");
        click(AddNewkeyStore, driver, "Clicking Add keyStore");
    	waitForElementNotVisible(loader, driver, "wait for page load");
        return new KeyStorepage(driver);
    }

    public TrustStorepage AddTruststore() throws Exception
    {
        log.info("Clicking Add button");
        logExtentReport("Clicking Add button" );
        //waitHelper.waitForElement(AddCertificate, ObjectReader.reader.getExplicitWait());
        //AddCertificate.click();
        click(AddCertificate, driver, "Clicking New certificate button");
        //waitHelper.waitForElement(AddTruststore, ObjectReader.reader.getExplicitWait());
        click(AddTruststore, driver, "Clicking Add keyStore");
        waitForElementNotVisible(loader, driver, "wait for page load");
        //AddTruststore.click();
        return new TrustStorepage(driver);
    }



    public void DeletingKeyStore(String KeyStoreName) throws Exception
    {
//        Random objGenerator = new Random();
//        int randomNumber = objGenerator.nextInt(100);
//        String name = "KeystoreName"+randomNumber;
        log.info("Deleting keyStore");
        logExtentReport("Deleting keyStore" );
        WebElement ele = findElement("//span[contains(text(),'"+ KeyStoreName +"')]/ancestor::div[@class='certificates-inner-content']/div/div[3]/span[2]",driver);
        click(ele, driver, "Clicking on jeystore name to delete");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();  
        click(flowServiceDeleteButtonElement, driver, "Click on delete button");
    }

    public String getSuccesMessage() throws Exception
    {
    	 WebElement ele = findElement("//div[@class='notification-message']",driver);

        waitForElementVisible(ele, driver, "Getting successMessage...");
        return SuccessMessage.getText();
    }


    public String getkeystorename() throws Exception{
        WebElement ele = findElement("//div[@class='row certificate-wrapper-inner-detail']/div[1]//span[@class='certificate-inner-title']",driver);
        return ele.getText();
    }

    public void EditCertificate(String KeyStoreName) throws Exception
    {
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+ KeyStoreName +"')]/ancestor::div[@class='certificates-inner-content']/div/div[3]/span[2]"));
        click(ele, driver, "clicking 3dot ");
        log.info("clicking Edit Button ");
        logExtentReport("clicking Edit Button " );
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();
        waitForElementNotVisible(loader, driver, "wait for page load");

    }
    
    
    public void EditFlowCertificate(String KeyStoreName) throws Exception
    {
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+ KeyStoreName +"')]/ancestor::div[@class='certificates-inner-content']/div[2]/div[3]/span[2]"));
        click(ele, driver, "clicking 3dot ");
        log.info("clicking Edit Button ");
        logExtentReport("clicking Edit Button " );
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();
        waitForElementNotVisible(loader, driver, "wait for page load");

    }
    
    public void EditWorkFlowCertificate(String KeyStoreName) throws Exception
    {
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+ KeyStoreName +"')]/ancestor::div[@class='certificates-inner-content']/div[3]/div[3]/span[2]"));
        click(ele, driver, "clicking 3dot ");
        log.info("clicking Edit Button ");
        logExtentReport("clicking Edit Button " );
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();
        waitForElementNotVisible(loader, driver, "wait for page load");

    }

    public String verifycreatedcertficate(String CertficateNAME) throws Exception
   	{
    	 WebElement ele = findElement("//span[contains(text(),'"+CertficateNAME+"')]",driver);
   		 waitForElementVisible(ele,driver,"Verify PartnerCerifcate is present");
   		 return ele.getText();
   	}

    public  void  DeletingCerficate() throws Exception {

   		log.info("Clicking on ThreeDotICon .. ..");
   		logExtentReport(
   		"Clicking on ThreeDotICon .. ......  ");
   		List<WebElement> element = findElements("//*[@class='delite-icon dlt-icon-more-menu']",driver);
   		click(element.get(0),driver,"click on first element");
   		WebElement element1 = driver.findElement(By.xpath("//span[@class='right-side-delete delete-side']"));
   		click(element1, driver, "Clicked on delete  button....");
    }
    
    public  void  DeletingSpecificCerficate(String certname) throws Exception {

   		log.info("Clicking on ThreeDotICon .. ..");
   		logExtentReport(
   		"Clicking on ThreeDotICon .. ......  ");
   		WebElement element = findElement("//div[@class='certificates-inner-content']/div/div/span[text()='"+certname+"']/ancestor::div[1]/following-sibling::div[2]/span[2]",driver);
   		click(element,driver,"click on 3 dots");
   		WebElement element1 = driver.findElement(By.xpath("//div[@class='certificates-inner-content']/div/div/span[text()='"+certname+"']/ancestor::div[1]/following-sibling::div[2]/span[2]/ul/li[2]/a"));
   		click(element1, driver, "Clicked on delete  button....");
    }
    
    
  //div[@class='certificates-inner-content']/div/div/span[text()='flowpage22Jun']/ancestor::div[1]/following-sibling::div[2]/span[2]

    public String verifytheDependancyMeaasge() throws Exception
   	{
   		 waitForElementVisible(CertficateDelete,driver,"Verify depenedanct message");
   		 return CertficateDelete.getText();
   	}


    public  void  ClickingOnCancelButton() throws Exception {
    log.info("Clicking on CancelButton .. ..");
   	logExtentReport(
   	"Clicking on CancelButton .. ......  ");
    WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
    click(element, driver, "Clicked on CancelButton....");
    }

    public  void  ClickingDeletebutton(String i, String certficatename) throws Exception {
        log.info("Clicking on Delete Button .. ..");
       	logExtentReport(
       	"Clicking on Delete Button .. ......  ");
       	log.info("Clicking on ThreeDotICon .. ..");
   		logExtentReport(
   		"Clicking on ThreeDotICon .. ......  ");
   		List<WebElement> element1 = findElements("//*[@class='delite-icon dlt-icon-more-menu']",driver);
   		click(element1.get(0),driver,"click on first element");
   		WebElement element2 = driver.findElement(By.xpath("//div[@class='certificates-inner-content']/div[1]/div[3]/span[2]/ul/li[2]/a"));
   		//WebElement element2 = driver.findElement(By.xpath("//span[@class='right-side-delete delete-side']"));
   		click(element2, driver, "Clicked on delete  button....");
   	    WebElement element5 = driver.findElement(By.xpath("//div[contains(@class,'circle-clipper')]/div[@class='circle']"));
        waitForElementVisible(element5, driver, "wait for page load");
   	    waitForElementNotVisible(loader, driver, "wait for page load");
       	//WebElement element3 = driver.findElement(By.xpath("//p[contains(text(),'Are you sure you want to delete this certificate?')]"));
       	//waitForElementVisible(element3,driver,"Verify the delete popup message");
        WebElement element4 = driver.findElement(By.xpath("//button[text()='Cancel']/preceding-sibling::button[text()='Delete']"));
        click(element4, driver, "Clicked on Delete....");
        String ele = "//div[contains(text(),'Partner certfificate "+certficatename+" deleted successfully')]";
        waitForElementNotVisible(ele,driver,"Verify PartnerCerifcate is deleted or not");
        }





	public  void  ClickingOnSaveButton() throws Exception {
        log.info("Clicking on CancelButton .. ..");
       	logExtentReport(
       	"Clicking on CancelButton .. ......  ");
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        click(element, driver, "Clicked on SaveButton....");
         String element1 = "//button[contains(text(),'Save')]";
       //WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'circle-clipper')]/div[@class='circle']"));
       //waitForElementVisible(element1, driver, "wait for page load");
       waitForElementNotVisible(element1, driver, "wait for save button is not visible");
        //if(driver.findElement((By.xpath("//div[contains(@class,'circle-clipper')]/div[@class='circle']")).size()!=0)


        }

	public  void  ClickingOnUpdateButton() throws Exception {
        log.info("Clicking on CancelButton .. ..");
       	logExtentReport(
       	"Clicking on CancelButton .. ......  ");
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
        click(element, driver, "Clicked on SaveButton....");
         String element1 = "//button[contains(text(),'Update')]";
       //WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'circle-clipper')]/div[@class='circle']"));
       //waitForElementVisible(element1, driver, "wait for page load");
       waitForElementNotVisible(element1, driver, "wait for save button is not visible");
        //if(driver.findElement((By.xpath("//div[contains(@class,'circle-clipper')]/div[@class='circle']")).size()!=0)


        }





}
