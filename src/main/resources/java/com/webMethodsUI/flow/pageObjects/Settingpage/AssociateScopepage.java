package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssociateScopepage {

    WebDriver driver;
    private Logger log = LogManager.getLogger(AddNewScopepage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//span[contains(text(),'Service URLs')]")
    @CacheLookup
    WebElement Associatescopeelement;


    @FindBy(xpath = "//button[contains(text(),'Associate Existing Scopes')]")
    @CacheLookup
    WebElement AssociateExistingscopebutton;


    @FindBy(xpath = "//button[@id='associateScopeButton']")
    @CacheLookup
    WebElement associatescopebutton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    @CacheLookup
    WebElement Cancelbutton;

    //span[contains(text(),'TestScope')]/ancestor::div[@class='single-rest-api-row row']/div[1]/div[@class='custom-chbox fixed-radio-btn']/label

    @FindBy(xpath = "//button[contains(text(),'Associate New Scopes')]")
    @CacheLookup
    WebElement associatenewscopebutton;



    @FindBy(xpath = "//span[@class='dlt-icon-close']")
    @CacheLookup
    WebElement closebutton;


    @FindBy(xpath = " //div[@aid='associate-existing-oauth-scope']/div/div[1]/h1")
    @CacheLookup
    WebElement dialogboxheading;


    public AssociateScopepage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(Associatescopeelement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now.... and element text is  " + Associatescopeelement.getText());
        logExtentReport(
                "Resource Title element is visible now.... and text is  " + Associatescopeelement.getText());


    }

    public void clickAssociateexistingbutton(){
        log.info("clicking Associate existing scope button");
        logExtentReport("clicking Associate existing scope button");
        waitHelper.waitForElement(AssociateExistingscopebutton, ObjectReader.reader.getExplicitWait());
        AssociateExistingscopebutton.click();
        waitHelper.waitForElement(dialogboxheading, ObjectReader.reader.getExplicitWait());

    }


    public AddNewScopepage AssociatenewScope(){
        log.info("clicking Associate new scope button");
        logExtentReport("clicking Associate new scope button");
        waitHelper.waitForElement(associatenewscopebutton, ObjectReader.reader.getExplicitWait());
        associatenewscopebutton.click();
        return new AddNewScopepage(driver);
    }

    public void checkcheckboxofScope(String ScopeName) {
        log.info("clicking the check box" + ScopeName);
        logExtentReport("clicking the check box" + ScopeName);
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + ScopeName + "')]/ancestor::div[@class='single-rest-api-row row']/div[1]/div[@class='custom-chbox fixed-radio-btn']/label"));
        waitHelper.waitForElement(ele, ObjectReader.reader.getExplicitWait());
        ele.click();

        if (associatescopebutton.isEnabled()) {
            associatescopebutton.click();
        } else {
            Cancelbutton.click();
        }


    }

    public void backtohomepage(){
        waitHelper.waitForElement(closebutton, ObjectReader.reader.getExplicitWait());
        closebutton.click();
        log.info("Screen closed");
        logExtentReport("Screen closed");
    }



}
