
package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import java.io.File;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.fileupload.FileUpload;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;

public class SoapConnectorLetsGetStartPage extends CommonActions{

	WebDriver driver;
	private Logger log = LogManager.getLogger(SoapConnectorLetsGetStartPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//h1[@class='inner-content-title']")
	@CacheLookup
	WebElement letsGetStartedElement;

	@FindBy(xpath = "//input[@placeholder='Provide a url']")
	@CacheLookup
	WebElement importURLElement;

	@FindBy(xpath = "//span[contains(text(),'New SOAP Connector')]")
	@CacheLookup
	WebElement NewSoapConnectorElement;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement saveButtonElement;

	@FindBy(xpath = "//span[contains(text(),'Import from file')]")
	@CacheLookup
	WebElement Importbutton;

	@FindBy(xpath = "//input[@class='file-upload hide']")
    @CacheLookup
    WebElement Browseelement;
	
	@FindBy(xpath = "//input[@class='hide']")
    @CacheLookup
    WebElement browseMultipleFile;

	@FindBy(xpath = "//span[contains(text(),'Browse file')]")
    @CacheLookup
    WebElement Browsetext;

	public SoapConnectorLetsGetStartPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		elementContainsText(letsGetStartedElement, "Let's get started!", driver, "Verify title element is visible");

	}

	public void enterImportURL(String importURL) 
	{
		log.info("Entering soap connector url " + importURL);
		logExtentReport(" Entering soap connector url with url... " + importURL);
		importURLElement.sendKeys(importURL);
	}

	public void slectimportfile() throws Exception
    {
    	click(Importbutton, driver, "Select Import from file option");
    	WebElement element1 = findElement("//span[contains(text(),'Primary WSDL File')]", driver);
    	waitForElementVisible(element1, driver, "Verify Primary WSDL File title is visible");
    	WebElement element2 = findElement("//button/span[text()='Browse file']", driver);
    	waitForElementVisible(element2, driver, "Verify Browse File button is visible");
    	WebElement element3 = findElement("//span[text()='Browse file(s)']/../../button", driver);
    	waitForElementVisible(element3, driver, "Verify Browse File(s) button is visible in drag and drop area");
    	WebElement disabledDragAndDrop = findElement("//*[contains(@class,'dragdrop-disabled-state')]", driver);
    	waitForElementVisible(disabledDragAndDrop, driver, "Verify drag and drop area is disabled");
    	
    }

	public void uploadsoapconnectorFile(String filePath1 ){
        try {
            String filePath = ResourceHelper.getResourcePath(filePath1);
            //waitHelper.waitForElement(Browseelement, ObjectReader.reader.getExplicitWait());
            FileUpload fileUpload = new FileUpload(driver);
            fileUpload.fileUploadUsingInputType(Browseelement, filePath);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
	
	public void uploadPrimayFile(String filepath,String FileName) throws Exception
	{
        String filePath = ResourceHelper.getResourcePath(filepath);
        FileUpload fileUpload = new FileUpload(driver);
        fileUpload.fileUploadUsingInputType(Browseelement, filePath);
        WebElement element1 = findElement("//span[@class='file-name']", driver);
        elementContainsText(element1,FileName, driver, "Verify uploaded file name is visible");
    	WebElement element2 = findElement("//button/span[text()='Browse file(s)']", driver);
       	Assert.assertTrue(element2.isEnabled(), "Verify browse files button is enabled in drag and drop area");

    }
	
	public void uploadMultipleFiles(String filepath) throws Exception
	{
		
        String filePath = ResourceHelper.getResourcePath(filepath);
        File file =  new File(filePath);
        String fileList[] = file.list();
        for(int i=0; i<fileList.length; i++) 
        {
            String fileName = fileList[i];
            FileUpload fileUpload = new FileUpload(driver);
            fileUpload.fileUploadUsingInputType(browseMultipleFile, filePath+fileName);
         }
    }


	public String getNewSoapConnectorTitle() {

		log.info("  Lets get Started  soap connector page" + NewSoapConnectorElement);
		logExtentReport(" .Retruning   element with name .. " + NewSoapConnectorElement.getText());

		return NewSoapConnectorElement.getText();
	}

}
