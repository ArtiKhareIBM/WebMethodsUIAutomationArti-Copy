
package com.webMethodsUI.flow.pageObjects.SOAPConnector;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.fileupload.FileUpload;

import com.webMethodsUI.flow.helper.resource.ResourceHelper;
import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class SoapConnectorLetsGetStartPage {

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

	@FindBy(xpath = "//span[contains(text(),'Browse files')]")
    @CacheLookup
    WebElement Browsetext;

	public SoapConnectorLetsGetStartPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(letsGetStartedElement, ObjectReader.reader.getExplicitWait());
		log.info("   Soap connector lets started page loaded element is visible now....");
		logExtentReport("element is visible now.... and element text is  " + letsGetStartedElement.getText());

	}

	public void enterImportURL(String importURL) {
		log.info("Entering soap connector url " + importURL);
		logExtentReport(" Entering soap connector url with url... " + importURL);
		importURLElement.sendKeys(importURL);

	}

	public void slectimportfile()
    {
    	log.info("selecting the import file option");
    	Importbutton.click();
    	waitHelper.waitForElement(Browsetext, ObjectReader.reader.getExplicitWait());
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


	public String getNewSoapConnectorTitle() {

		log.info("  Lets get Started  soap connector page" + NewSoapConnectorElement);
		logExtentReport(" .Retruning   element with name .. " + NewSoapConnectorElement.getText());

		return NewSoapConnectorElement.getText();
	}

}
