package com.webMethodsUI.flow.pageObjects.UserManagement;


import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;
import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserProfileIconPage extends CommonActions{
    WebDriver driver;
    private Logger log = LogManager.getLogger(UserProfileIconPage.class);
    WaitHelper waitHelper;
    
    @FindBy(xpath = "//a[contains(text(),'Projects')]")
    @CacheLookup
    WebElement projectTitle;

    @FindBy(xpath = "//*[@class='delite-icon dlt-icon-profile']")
    @CacheLookup
    WebElement userProfileIcon;
    
    @FindBy(xpath = "//span[contains(text(),'User management')]")
    @CacheLookup
    WebElement userManagement;

   
    //span[@title='JWT Keystore']/ancestor::div[@id='lookup-container']/span[2]/span
    //div[@data-eventmap='metadata-OpenLookUpDropdown-JWT Keystore']/span


    public UserProfileIconPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(projectTitle,15);
        log.info("element is visible now...." + projectTitle);
        logExtentReport("element is visible now.... and element text is  " + projectTitle.getText());

    }
        public void clickingUserProfile(){
        log.info("Clicking UserProfile Icon..");
        logExtentReport("Clicking UserProfile Icon ... ");
        userProfileIcon.click();
 
    }
        public RolesPage clickUserManagementTab(){
            log.info("Clicking UserManagement Tab..");
            logExtentReport("Clicking UserManagement Tab... ");
            userManagement.click();
            return new RolesPage(driver);

        }
        
        


















}
