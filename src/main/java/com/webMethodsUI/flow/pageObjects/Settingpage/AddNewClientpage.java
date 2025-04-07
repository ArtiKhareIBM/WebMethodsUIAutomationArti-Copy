package com.webMethodsUI.flow.pageObjects.Settingpage;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddNewClientpage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(AddNewClientpage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//input[@name='description']")
    @CacheLookup
    WebElement descriptionelement;


    @FindBy(xpath = "//input[@name='name']")
    @CacheLookup
    WebElement NameFieldelement;


    @FindBy(xpath = "//input[@name='version']")
    @CacheLookup
    WebElement VersionFieldelement;

    @FindBy(xpath = "//span[@class='delite-icon dlt-icon-caret-down']")
    @CacheLookup
    WebElement dropdownlink;

    @FindBy(xpath = "//input[@name='primaryRedirectionUrls']")
    @CacheLookup
    WebElement redirectionurlfield;


    @FindBy(xpath = "//button[@class='btn btn-danger btn-sm delete-btn-prmy primary-btn']")
    @CacheLookup
    WebElement Addbutton;


    @FindBy(xpath = "//h3[contains(text(),'Client Management')]")
    @CacheLookup
    WebElement Addnewclientheading;

    @FindBy(xpath = "//div[@class='notification-message']")
    @CacheLookup
    WebElement SuccessMessage;

    //span[contains(text(),'Authorization Code Grant')]/parent::label

    //span[contains(text(),'Never Expires')]/parent::label



//h3[contains(text(),'Client Id and Secret')]


  public AddNewClientpage(WebDriver driver) throws Exception{
      super();
      this.driver = driver;
      PageFactory.initElements(driver, this);
      waitForElementVisible(Addnewclientheading, driver, "Wait for Addnewclientheading is visible");

  }


  public void EnterNameForNewClient(String Name) throws Exception
  {
      enterValue(NameFieldelement, Name, driver, "Entering client Name...."+Name);      

  }

  public void EnteringversionField(String Version) throws Exception
  {
   
      enterValue(VersionFieldelement, Version, driver, "Entering Version...."+Version);   
  }

  public void clickDropdown() throws Exception
  {
      click(dropdownlink, driver, "clicking dropdown");
  }

  public void EnteringRedirectionURL(String Redirectionurl) throws Exception
  {
      enterValue(redirectionurlfield, Redirectionurl, driver, "Entering Redirectionurl...."+Redirectionurl);
  }

  public void clickingcheckbox(String Link) throws Exception
  {

      WebElement element = findElement("//span[contains(text(),'"+Link+"')]/parent::label",driver);

      click(element, driver, "clicking check box" + Link);
  }

  public boolean IsAddbuttonEnabled() throws Exception
  {
      log.info("Verify Is Addbutton Enabled");
      logExtentReport("Verify Is Addbutton Enabled");
      return Addbutton.isEnabled();

  }

  public void clickAddbutton() throws Exception
  {
      click(Addbutton, driver, "clicking Add button");
  }

  public boolean verifyclientIDandSecret() throws Exception
  {
      log.info("Verify client id and Secret");
      logExtentReport("Verify client id and Secret");
      WebElement element = findElement("//h3[contains(text(),'Client Id and Secret')]",driver);
      return element.isDisplayed();
  }

    public String getSuccesMessageofImportfile() throws Exception
    {
       return getText(SuccessMessage, driver, "Getting successMessage...");
    }


    public void waittillitappears() throws Exception
    {
        String SuccessMessage = "//div[@class='notification-message']";
        waitForElementNotVisible(SuccessMessage, driver, "Wait for element not visible", 20);
    }

    public void addingadditionalurl(int index,String url)
    {
        log.info("clicking addurl button");
        logExtentReport("clicking addurl button");
        WebElement element = driver.findElement(By.xpath("//a[@class='primary-color pad-top delite-icon dlt-icon-plus']"));
        element.click();
        List<WebElement> elemntArray = driver
                .findElements(By.xpath("//input[@name='secondaryRedirectionUrls']"));
        log.info("All input parameters are....." + elemntArray);
        WebElement element1 = elemntArray.get(index);
        element1.click();
        element1.sendKeys(url);


    }

    public String getclient() throws Exception
    {
        log.info("get clientID detail");
        logExtentReport("get clientID detail");
        WebElement ele = driver.findElement(By.xpath("//label[contains(text(),'Client Secret')]/parent::div/div/div[1]/span"));
        return ele.getText();
    }

    public void EnterDescription(String Description) throws Exception
    {
       log.info("Entering Description"+Description);
       logExtentReport("Entering Description"+Description);
       descriptionelement.click();
       descriptionelement.sendKeys(Description);
    }




}
