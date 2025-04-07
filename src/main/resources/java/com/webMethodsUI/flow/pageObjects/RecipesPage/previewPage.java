package com.webMethodsUI.flow.pageObjects.RecipesPage;

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

public class previewPage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(recipesWorkflowAndFlowServicepage.class);
    WaitHelper waitHelper;


    @FindBy(xpath = "//button[contains(text(),'Use Recipe')]")
    @CacheLookup
    WebElement previewpage;

    @FindBy(xpath = "//i[@class='dlt-icon-arrow-left']")
    @CacheLookup
    WebElement clickbackbutton;


    public previewPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(previewpage, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now...." + previewpage);
        logExtentReport("element is visible now.... and element text is  " + previewpage);
    }


public recipesWorkflowAndFlowServicepage clickbackarrow(){
    log.info("clicking back arrow button");
    logExtentReport("clicking back arrow button" );
    clickbackbutton.click();
    return new recipesWorkflowAndFlowServicepage(driver);
}

    public boolean VerifyrequiredImage(String Element){
        log.info("Verifyied the element");
        logExtentReport("Verifyied the element");
        WebElement element = driver.findElement(By.xpath("//i[@class='"+Element+"']"));
        waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
        return element.isDisplayed();
    }


}
