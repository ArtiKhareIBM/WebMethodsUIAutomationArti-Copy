package com.webMethodsUI.flow.pageObjects.RESTConnector;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class IOsignaturepage extends CommonActions{
    WebDriver driver;

    @FindBy(xpath = "//h1[@class='modal-title']")
    @CacheLookup
    WebElement iopageheading;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    @CacheLookup
    WebElement closebutton;

    @FindBy(xpath = "//div[contains(text(),'OUTPUT')]")
    @CacheLookup
    WebElement outputTitleElement;

    @FindBy(xpath = "//i[@class='tree-icon dlt-icon-plus']")
    @CacheLookup
    WebElement plusIconElement;

    @FindBy(xpath = "//span[@class='show-hide-panel'][contains(text(),'$connection')]")
    @CacheLookup
    WebElement DynamicConnectionsignature;


   public IOsignaturepage(WebDriver driver) throws Exception{
       super();
       this.driver = driver;
       PageFactory.initElements(driver, this);
       logExtentReport("IOsignature PageObject created");
       waitForElementVisible(iopageheading,driver,"Verify iopageheading is visible");

   }

   public void expandheader(int index) throws Exception
   {
       List<WebElement> elemntArray = findElements("//span[contains(text(),'requestHeaders')]/ancestor::div[@class='tree-context showBorder']/preceding-sibling::div[@class='tree-icon-container']/span/i",driver);
       WebElement element = elemntArray.get(index);    
       click(element,driver,"Expand header at index.. "+index);
   }
   
    public void expandicon(int index,String parameters) throws Exception
    {
        List<WebElement> elemntArray = findElements("//span[contains(text(),'"+parameters+"')]//ancestor::div[@class='tree-node tree-branch']/div/span",driver);
        WebElement element = elemntArray.get(index);
        click(element,driver,"Expand icon at index.. "+index);
    }


   public String VerifyAddedHeader(String NewHeader) throws Exception
   {
       WebElement element = findElement("//span[@class='show-hide-panel'][contains(text(),'"+NewHeader+"')]",driver);
       waitForElementVisible(element,driver,"Verify Addedheader is visible.. "+element);
       return element.getText();
   }

   public void closeiopage() throws Exception
   {
       click(closebutton,driver,"Click on close button");
   }

    public  void clickOnOutput() throws Exception 
    {
    	click(outputTitleElement,driver,"Click on OUTPUT Link");
    }

    public boolean VerifyField(String Field) throws Exception
    {
        WebElement Element = findElement("//span[contains(text(),'"+Field+"')]",driver);
    	waitForElementVisible(Element,driver,"Verify field is visible.. "+Element);
    	return true;
    }

    public void clickOnPlusIcon() throws Exception 
    {
        click(plusIconElement,driver,"Click on plus icon on inputoutput signature page");
    }
    
    public String getconnectionsignature() throws Exception 
    {
		 waitForElementVisible(DynamicConnectionsignature,driver,"Verify DynamicConnectionsignature is present");
		 return DynamicConnectionsignature.getText();
	 }

    public boolean is$connectionisdisabled() 
    {
    	boolean status = false;
    	if(driver.getPageSource().contains("$connection"))
    	{
    	    logExtentReport("$connection is dispalyed" );
            status = true;
    	}
    	else
    		{
    		    logExtentReport("$connection is not dispalyed" );

    		}
    	return status;
    	}
 
}





