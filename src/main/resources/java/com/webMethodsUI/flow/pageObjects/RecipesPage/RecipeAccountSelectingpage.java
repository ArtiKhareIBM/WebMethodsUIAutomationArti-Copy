package com.webMethodsUI.flow.pageObjects.RecipesPage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RecipeAccountSelectingpage {
    WebDriver driver;
    private Logger log = LogManager.getLogger(RecipeAccountSelectingpage.class);
    WaitHelper waitHelper;



    @FindBy(xpath = "//div[contains(text(),'Account configuration')]")
    @CacheLookup
    WebElement RecipepageElement;




    public RecipeAccountSelectingpage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(RecipepageElement, ObjectReader.reader.getExplicitWait());
        log.info("element is visible now...." + RecipepageElement);
        logExtentReport("element is visible now.... and element text is  " +RecipepageElement);


    }

    public void AddAccountFordifferentConnector(int index){
        log.info("Clicking Add account icon");
        logExtentReport("Clicking Add account icon");
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='material-icons']"));
        WebElement element = list.get(index);
        element.click();

    }

    public void SelectingDropdown(int index,String AccountName) throws Exception{
        log.info("Clicking Add account icon");
        logExtentReport("Clicking Add account icon");
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='select-delite-caret dlt-icon-caret-down ']"));
        WebElement element = list.get(index);
        Thread.sleep(10000);
        element.click();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink(AccountName);

    }






}
