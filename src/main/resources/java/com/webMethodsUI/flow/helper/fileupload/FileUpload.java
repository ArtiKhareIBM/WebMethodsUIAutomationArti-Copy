package com.webMethodsUI.flow.helper.fileupload;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webMethodsUI.flow.testbase.CommonActions;
public class FileUpload extends CommonActions{
	
	private WebDriver driver;
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";

	public FileUpload(WebDriver driver) {
		super();
		this.driver = driver;
	}

	
	public void fileUploadUsingInputType(WebElement BrowseFileElement, String filePath) throws Exception 
	{
		BrowseFileElement.sendKeys(filePath);
		enterValue(BrowseFileElement,filePath,driver,"Uploading File.. " +filePath+ " Uisng element.. "+BrowseFileElement);
		waitForElementNotVisible(loader, driver, "wait for page load");
		
		/* Example code to be called from test file
		WebElement BrowseFileElement = driver.findElement(By.xpath("//input[@class='file-upload hide']"));
		String filePath = ResourceHelper.getResourcePath("/src/main/resources/wsdlFiles/googleWeather.wsdl");
		*/
		
	}
	


}
