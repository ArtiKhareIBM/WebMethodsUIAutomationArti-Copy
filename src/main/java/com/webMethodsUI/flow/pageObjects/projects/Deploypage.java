package com.webMethodsUI.flow.pageObjects.projects;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class Deploypage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(Deploypage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//h3[contains(text(),'Name the Project')]")
    @CacheLookup
    public static WebElement deploypTitlepage;

    @FindBy(xpath = "//input[@class='inputElement  filled required-field']")
    @CacheLookup
    public static WebElement RenameprojectField;


    @FindBy(xpath = "//button[contains(text(),'Save and continue')]")
    @CacheLookup
    public static WebElement SaveAndcontinuebutton;


    public Deploypage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(deploypTitlepage, ObjectReader.reader.getExplicitWait());

        log.info("element is visible now....");

    }

    public Deployconfigurationpage clickSaveAndcontinuebutton() throws Exception
    {
        click(SaveAndcontinuebutton, driver, "Clicking Save And continue button");
        return new Deployconfigurationpage(driver);
    }

    public void Renametheproject(String reProjectName) throws Exception{

        clearAndEnterText(RenameprojectField, reProjectName, driver, "Entering new projectName" + reProjectName);
    }


}
