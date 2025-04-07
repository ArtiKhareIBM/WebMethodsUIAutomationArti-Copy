package com.webMethodsUI.flow.pageObjects.restapi;

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

public class PostMethodPage extends CommonActions{
	WebDriver driver;
	private Logger log = LogManager.getLogger(PostMethodPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//h1[contains(text(),'POST')]")
	@CacheLookup
	WebElement postMethodTitleElement;
	
    @FindBy(xpath = "//textarea[@placeholder='Provide a short description for the specified resource and method']")
	@CacheLookup
	WebElement addDescriptionElement;
    

	@FindBy(xpath = "//div[@class='css-151xaom-placeholder react-select2-common__placeholder']")
	@CacheLookup
	WebElement selectFlowServiceDropdownElement;
	
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement clickDoneButtonElement;
	
	@FindBy(xpath = "//span[@class='material-icons icon-arrow-right right']")
	@CacheLookup
	WebElement clickUpArrowElement;
	
	
	
	public PostMethodPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(postMethodTitleElement, ObjectReader.reader.getExplicitWait());
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +postMethodTitleElement.getText());

	}
	public String getpostMethodTitle() {
		log.info("element is visible now....");
		logExtentReport("element is visible now.... and element text is  " +postMethodTitleElement.getText());
		return postMethodTitleElement.getText();
	}
	
	public void enterDescription(String description)
	{
		log.info("Entering the path with description... " + description);
		logExtentReport("Entering the path with description... " + description);
		addDescriptionElement.sendKeys(description);
		
	} 
	
	public void selectFlowservice(String flowservice) throws Exception {
		log.info("Selecting using visible text... " +flowservice);
		logExtentReport("Selecting using visible text... " +flowservice);
		waitHelper.waitForElement(selectFlowServiceDropdownElement, ObjectReader.reader.getExplicitWait());
		selectFlowServiceDropdownElement.click();
		GenericHelper genericHelper = new GenericHelper(driver);
		genericHelper.selectDropDownLink(flowservice);
		
		
		//DropDownHelper authDropDown = new DropDownHelper(driver);
		//authDropDown.selectUsingIndex(AuthenticationType, index);
		
	}
	public void clickUpArrowIcon() {
		log.info("clicking up arrow icon....");
		logExtentReport("clicking up arrow icon...........  ");
		waitHelper.waitForElement(clickUpArrowElement, ObjectReader.reader.getExplicitWait());
        clickUpArrowElement.click();
	}

	
	
	
    
    
	

}
