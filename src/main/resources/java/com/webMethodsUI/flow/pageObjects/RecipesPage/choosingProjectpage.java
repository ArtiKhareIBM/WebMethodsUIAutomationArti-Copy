package com.webMethodsUI.flow.pageObjects.RecipesPage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class choosingProjectpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(choosingProjectpage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = " //h1[contains(text(),'Save as')]")
    @CacheLookup
    WebElement saveagPage;

    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down ']")
    @CacheLookup
    WebElement dropdownlink;

    @FindBy(xpath = "//input[@class='search-input-inner']")
    @CacheLookup
    WebElement projectInput;


    @FindBy(xpath = " //input[@aid='Name']")
    @CacheLookup
    WebElement Namefield;


    public choosingProjectpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(saveagPage, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now...." + saveagPage);
        logExtentReport("element is visible now.... and element text is  " +saveagPage);


    }


    public void clicktheDropdown(String ProjectName) throws Exception{
        log.info("clicking on drop down");
        logExtentReport("clicking on drop down" );
        dropdownlink.click();
        waitHelper.waitForElement(projectInput, ObjectReader.reader.getExplicitWait());
        projectInput.sendKeys(ProjectName);
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink(ProjectName);
    }

    public void enteringNameField(String FlowserviceName){
        log.info("Entering FlowserviceName"+FlowserviceName);
        logExtentReport("Entering FlowserviceName"+FlowserviceName);
        Namefield.click();
        Namefield.sendKeys(FlowserviceName);
    }


    public void clickSaveButton() throws Exception{
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Save");
    }







}
