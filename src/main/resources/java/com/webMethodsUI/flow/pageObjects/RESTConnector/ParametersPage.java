package com.webMethodsUI.flow.pageObjects.RESTConnector;

import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class ParametersPage extends CommonActions{

	WebDriver driver;

	@FindBy(xpath = "//div[contains(text(),'Parameters')]")
	@CacheLookup
	WebElement parametersHeader;

	@FindBy(xpath = "//input[@placeholder='Name your Parameter']")
	@CacheLookup
	WebElement parameterName;

	@FindBy(xpath = "//input[@placeholder='Type a Value']")
	@CacheLookup
	WebElement parameterValue;

	@FindBy(xpath = "//*[text()='Parameter Type']/..//div/input[contains(@id,'input')]")
	@CacheLookup
	public List<WebElement> parameterType;
	
	@FindBy(xpath = "//*[text()='Mandatory']/..//div/input[contains(@id,'input')]")
	@CacheLookup
	public List<WebElement> Mandatory;

	@FindBy(xpath = "//*[text()='Mandatory']/..//div/input[contains(@id,'input')]")
	@CacheLookup
	public List<WebElement> isMandatory;

	GenericHelper genericHelper;

	public ParametersPage(WebDriver driver) throws Exception {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logExtentReport("Parameters PageObject created");
		waitForElementVisible(parametersHeader,driver,"Verify parametersHeader is visible");
	}

	public void enterParameterName(String parameterName) throws Exception {
		enterValue(this.parameterName,parameterName,driver,"Entering parameter Name.. " +parameterName);
	}

	public void enterparameterValue(String parameterValue) throws Exception {
		enterValue(this.parameterValue,parameterValue,driver,"Entering parameter Value.. " +parameterValue);
	}

	public void selectParameterType(String parameterTypeValue,int i) throws Exception {
		genericHelper = new GenericHelper(driver);
		List<WebElement> element = findElements("//*[text()='Parameter Type']/..//div[text()='Select Parameter type']",driver);
		WebElement newEle = element.get(i);
		genericHelper.clickOnDropDown(newEle,i);
		genericHelper.selectDropDownLink(parameterTypeValue);
	}

	public void selectMandatoryValue(String MandatoryValue,int i) throws Exception {
		genericHelper = new GenericHelper(driver);
		List<WebElement> element = findElements("//*[text()='Mandatory']/../div/div/div/div[contains(@class,'singleValue')]",driver);
		WebElement newEle = element.get(i);
		genericHelper.clickOnDropDown(newEle,i);
		genericHelper.selectDropDownLink(MandatoryValue);
	}
}
