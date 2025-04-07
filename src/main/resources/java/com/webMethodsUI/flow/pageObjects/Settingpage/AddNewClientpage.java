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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddNewClientpage {
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

    @FindBy(xpath = "//span[@class='select-delite-caret dlt-icon-caret-down ']")
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


  public AddNewClientpage(WebDriver driver){
      super();
      this.driver = driver;
      PageFactory.initElements(driver, this);
      waitHelper = new WaitHelper(driver);
      waitHelper.waitForElement(Addnewclientheading, ObjectReader.reader.getExplicitWait());
      log.info("element is visible now....");
      logExtentReport("element is visible now.... and element text is  " +Addnewclientheading.getText());

  }


  public void EnterNameForNewClient(String Name){
      log.info("Entering Name...."+Name);
      logExtentReport("Entering Name...."+Name);
      NameFieldelement.click();
      NameFieldelement.sendKeys(Name);

  }

  public void EnteringversionField(String Version){
      log.info("Entering Version...."+Version);
      logExtentReport("Entering Version...."+Version);
      VersionFieldelement.click();
      VersionFieldelement.sendKeys(Version);

  }

  public void clickDropdown(){
      log.info("clicking dropdown");
      logExtentReport("clicking dropdown");
      waitHelper.waitForElement(dropdownlink, ObjectReader.reader.getExplicitWait());
      dropdownlink.click();

  }

  public void EnteringRedirectionURL(String Redirectionurl){
      log.info("Entering Redirectionurl...."+Redirectionurl);
      logExtentReport("Entering Redirectionurl...."+Redirectionurl);
      redirectionurlfield.click();
      redirectionurlfield.sendKeys(Redirectionurl);
  }

  public void clickingcheckbox(String Link){
      log.info("clicking check box" + Link);
      logExtentReport("clicking check box" + Link);
      WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+Link+"')]/parent::label"));
      waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
      element.click();
  }

  public boolean IsAddbuttonEnabled(){
      log.info("Verify Is Addbutton Enabled");
      logExtentReport("Verify Is Addbutton Enabled");
      return Addbutton.isEnabled();
  }

  public void clickAddbutton(){
      log.info("clicking Add button");
      logExtentReport("clicking Add button");
      waitHelper.waitForElement(Addbutton, ObjectReader.reader.getExplicitWait());
      Addbutton.click();
  }

  public boolean verifyclientIDandSecret(){
      log.info("Verify client id and Secret");
      logExtentReport("Verify client id and Secret");
      WebElement element = driver.findElement(By.xpath("//h3[contains(text(),'Client Id and Secret')]"));
      return element.isDisplayed();
  }

    public String getSuccesMessageofImportfile(){
        log.info("Getting successMessage...");
        logExtentReport("Getting successMessage...");
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(SuccessMessage, ObjectReader.reader.getExplicitWait());
        return SuccessMessage.getText();}


    public void waittillitappears(){
        WebDriverWait wait = new WebDriverWait(driver,ObjectReader.reader.getExplicitWait());
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(SuccessMessage,SuccessMessage.getText())));
    }

    public void addingadditionalurl(int index,String url){
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

    public String getclient(){
        log.info("get clientID detail");
        logExtentReport("get clientID detail");
        WebElement ele = driver.findElement(By.xpath("//label[contains(text(),'Client Secret')]/parent::div/div/div[1]/span"));
        return ele.getText();
    }

    public void EnterDescription(String Description){
       log.info("Entering Description"+Description);
       logExtentReport("Entering Description"+Description);
       descriptionelement.click();
       descriptionelement.sendKeys(Description);
    }




}
