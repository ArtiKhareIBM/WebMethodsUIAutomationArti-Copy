package com.webMethodsUI.flow.pageObjects.workflows;

import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;


public class WorkflowHttpConnector extends CommonActions{



	private WebDriver driver;
    private Logger log = LogManager.getLogger(WorkflowCanvaspage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//input[@id='focusOn']")
    @CacheLookup
    WebElement SearchField;

    @FindBy(xpath = "//span[contains(text(),'HTTP')]")
    @CacheLookup
    WebElement HTTPconnectorimage;

    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down ']")
    @CacheLookup
    WebElement Selectactdropdown;

    @FindBy(xpath = "//span[@class='switch-label default']")
    @CacheLookup
    WebElement workflowcanvaspageelement;
   @FindBy(xpath = "//input[@class='inputElement textbox-edit']")
	@CacheLookup
	WebElement ResourcePath;

   @FindBy(xpath = "//textarea[@class='inputElement textbox-edit']")
	@CacheLookup
	WebElement bodypath;

   @FindBy(xpath = "//h1[contains(text(),'Edit Workflow Name')]")
   @CacheLookup
   WebElement Editworkflowelement;


   @FindBy(xpath = "//input[@name='Flow Name']")
   @CacheLookup
   WebElement Namefield;

   @FindBy(xpath = "//button[@class='btn btn-primary save_flow_btn right primary-btn']")
   @CacheLookup
   WebElement Savebutton;
   @FindBy(xpath = " //i[@class='flow-icons add-title-pencil mrs delite-icon dlt-icon-edit icons8 ']")
   @CacheLookup
   WebElement EditworkflowNamepencilicon;

   @FindBy(xpath = "//span[contains(text() ,'responseText')]]")
   @CacheLookup
   WebElement updateresponse;


   public WorkflowHttpConnector(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(workflowcanvaspageelement, ObjectReader.reader.getExplicitWait());

		log.info("element is visible now...." + workflowcanvaspageelement);

	}

    public void DragSeviceanddrop(String ServiceName){
        log.info("Search the Service" +ServiceName);
        logExtentReport("Search the Service" +ServiceName);
        SearchField.click();
        SearchField.sendKeys(ServiceName);
        waitHelper.waitForElement(HTTPconnectorimage, ObjectReader.reader.getExplicitWait());
        log.info("Draging the Service" +ServiceName);
        logExtentReport("Draging the Service" +ServiceName);
        WebElement Source = driver.findElement(By.xpath("//span[@title='"+ServiceName+"']"));
        WebElement Target = driver.findElement(By.xpath("//p[contains(text(),'Drag connectors on the canvas from the right panel')]"));
        waitHelper.waitForElement(Source, ObjectReader.reader.getExplicitWait());
        Actions action = new Actions(driver);
        action.clickAndHold(Source).moveToElement(Target).release().build().perform();
        log.info("Dropped Success fully");
        logExtentReport("Dropped Success fully" );
    }

    public void mappingthecontainer(String ServiceName){
        WebElement ele = driver.findElement(By.xpath("//div[@data-eventmap='metadata-clickedActivity- ("+ServiceName+")']"));
        WebElement Source = driver.findElement(By.xpath("//div[@data-eventmap='metadata-clickedActivity- ("+ServiceName+")']//parent::div/div[4]/span//*[name()='svg']//*[name()='circle']"));
        WebElement Target = driver.findElement(By.xpath("//div[@data-eventmap='stop-activity']"));
        waitHelper.waitForElement(Source, ObjectReader.reader.getExplicitWait());
        ele.click();
        Actions action = new Actions(driver);
        action.clickAndHold(Source).moveToElement(Target).release().build().perform();
        log.info("Mapped Success fully");
        logExtentReport("Mapped Success fully" );
    }

    public void gotoServiceActionpage(String ServiceName){
        log.info("Click on Service  Action page");
        logExtentReport("Click on Action page" );
        WebElement ele = driver.findElement(By.xpath("//div[@data-eventmap='metadata-clickedActivity- ("+ServiceName+")']"));
        Actions action = new Actions(driver);
        action.doubleClick(ele).build().perform();
    }
    public void ClickNextbutton() throws Exception{
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Next");
        log.info("Clicked Next button" );
        logExtentReport("Clicked Next button");
    }

    public void SelectAction(int index, String Action){
    	log.info("  Clicking on  add button in workflow page ...");

		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		log.info(" Clicking on element at index..." + index + "......" + element);
		element.click();
		WebElement SelectActiontab = driver.findElement(By.xpath("//div[@class='left left-content  width-auto' and text()='"+Action+"']"));
		waitHelper.waitForElement(SelectActiontab, ObjectReader.reader.getExplicitWait());
		SelectActiontab.click();


//        WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+Action+"')]"));
//        ele.click();
        log.info("Entered Action"+ Action);
        logExtentReport("Entered Action"+ Action);
    }

    public void enteringValuesinparameters(String fieldname,String value){
        WebElement element = driver.findElement(By.xpath("//div[@aid='"+fieldname+"']/div/input"));
        element.click();
        element.sendKeys(value);
        log.info("Entered Value in "+fieldname+ value);
        logExtentReport("Entered Value in"+fieldname+ value);
    }
    public void pastingResourcePath(String resourcePath)
	{
		log.info("Entering resource Path... " + resourcePath);
		logExtentReport("Entering resource Path ... " + resourcePath);
		ResourcePath.sendKeys(Keys.CONTROL+"v");
		ResourcePath.sendKeys(resourcePath);
	}

public void ClickAddbutton( int index) {

        log.info("  Clicking on  add button in workflow page ...");

		List<WebElement> elemntArray = driver
				.findElements(By.xpath("//button[@class='btn btn-secondary btn-sm btn-style']"));
		log.info("All input parameters are....." + elemntArray);
		WebElement element = elemntArray.get(index);
		log.info(" Clicking on element at index..." + index + "......" + element);
		element.click();
}

public void clickdropdown( int index) {

    log.info("  Clicking on  dropdown in workflow page ...");

	List<WebElement> elemntArray = driver
			.findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
	log.info("All input parameters are....." + elemntArray);
	WebElement element = elemntArray.get(index);
	log.info(" Clicking on element at index..." + index + "......" + element);
	element.click();
}
public void enterbody(String body)
{
	log.info("Entering the value body text " + body);
	logExtentReport("Creating SOAP connector with name... " + body);
	bodypath.sendKeys(body);

}

public void ClickDonebutton() throws Exception{
    GenericHelper genericHelper = new GenericHelper(driver);
    genericHelper.clickButton("Done");
    log.info("Clicked Done button" );
    logExtentReport("Clicked Done button");
}





public void EnteringFlowservicename(String FlowServiceName){

    Namefield.click();
    Namefield.clear();
    Namefield.sendKeys(FlowServiceName);


}
public void Savebutton(){
    log.info("Click on Save button");
    logExtentReport("Click on Save button");
    Savebutton.click();
}
public void clickdoneforworkflow(){
    WebElement ele = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
    ele.click();
    log.info("Clicked Done button" );
    logExtentReport("Clicked Done button");
}

public void  editworkflowname(){
    log.info("Click on edit pencil icon");
    logExtentReport("Click on edit pencil icon" );
    EditworkflowNamepencilicon.click();
}
public void ClickTestButton() throws Exception{
    GenericHelper genericHelper = new GenericHelper(driver);
    genericHelper.clickButton("Test");
    log.info("Clicked Test button" );
    logExtentReport("Clicked Test button");
}

public boolean VerifyAfterTest(){
    log.info("Verifying After Test " );
    logExtentReport("Verifying After Test");
    boolean verify = driver.findElement(By.xpath("//h1[contains(text(),'Message posted successfully')]")).isDisplayed();
    return verify;
}

public boolean verifyupdaestatus(){
    log.info("Verifying After Test " );
    logExtentReport("Verifying After Test");
    boolean verifyupdateresponse = driver.findElement(By.xpath("//span[contains(text() ,'n3')]")).isDisplayed();
    return verifyupdateresponse;


}

public boolean verifyFirstapistatus(){
    log.info("Verifying After Test " );
    logExtentReport("Verifying first api resource response");
    boolean verifyupdateresponse = driver.findElement(By.xpath("//span[contains(text() ,'data')]")).isDisplayed();
    return verifyupdateresponse;


}

}

