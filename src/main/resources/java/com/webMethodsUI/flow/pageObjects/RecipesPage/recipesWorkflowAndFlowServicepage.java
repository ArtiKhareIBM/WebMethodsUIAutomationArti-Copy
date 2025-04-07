package com.webMethodsUI.flow.pageObjects.RecipesPage;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class recipesWorkflowAndFlowServicepage extends CommonActions{
    WebDriver driver;

    @FindBy(xpath = "//input[@class='search-box-input']")
    @CacheLookup
    WebElement recipepage;


    @FindBy(xpath = "//div[@title='Uploads the Small File from Amazon S3 to Adobe Experience Platform.']/parent::div/div[3]/a[contains(text(),'Preview')]")
    @CacheLookup
    WebElement previewlink;


    public recipesWorkflowAndFlowServicepage(WebDriver driver)
    {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logExtentReport("Recipes PageObject created");
    }

    public void clickpreviewbutton() throws Exception{
    	click(previewlink,driver,"clicking preview button of Uploads the Small File from Amazon S3 to Adobe Experience Platform.");
    }

    public boolean VerifyTotalRecipe() throws Exception
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Locating element by link text and store in variable "Element"
        WebElement Element = findElement("//span[contains(text(),'47')]",driver);
        waitForElementVisible(Element,driver,"Verify element is visible.. "+Element);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        boolean b1 = Element.isDisplayed();
        return b1;
    }

    public void ScrollUp()
    {
        logExtentReport("Scroll UP the page ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Locating element by link text and store in variable "Element"
        js.executeScript("arguments[0].scrollIntoView();",recipepage);

    }
    public void EnterinSearchox(String Search) throws Exception
    {
        click(recipepage,driver,"Click on Button.. "+recipepage);
        enterValue(recipepage,Search,driver,"Enter the description.. " +Search);
        WebElement ele = findElement("(//span[@class=\' delite-icon dlt-icon-search searchbox-search-icon\'])[2]",driver);
        click(ele,driver,"Click on Button.. "+ele);
    }

    public boolean VerifyrequiredImage(String Element) throws Exception
    {
        WebElement element = findElement("//i[@class='"+Element+"']",driver);
        waitForElementVisible(element,driver,"Verify element is visible.. "+element);
        return element.isDisplayed();
    }
}
