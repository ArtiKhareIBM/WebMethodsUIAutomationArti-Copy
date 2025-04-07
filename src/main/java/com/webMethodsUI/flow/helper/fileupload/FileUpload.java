package com.webMethodsUI.flow.helper.fileupload;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import java.lang.reflect.InvocationTargetException;
public class FileUpload extends CommonActions{
	
	private WebDriver driver;
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public FileUpload(WebDriver driver) {
		super();
		this.driver = driver;
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

}
