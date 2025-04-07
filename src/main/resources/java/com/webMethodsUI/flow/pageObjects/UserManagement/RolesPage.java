package com.webMethodsUI.flow.pageObjects.UserManagement;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class RolesPage {
	WebDriver driver;
    private Logger log = LogManager.getLogger(RolesPage.class);
    WaitHelper waitHelper;
    
    @FindBy(xpath = "//h3[contains(text(),'Roles')]")
    @CacheLookup
    WebElement rolesHeadingText;
    
    @FindBy(xpath = "//div[@class='settings-tab-container clearfix']/ul/li/a/span[contains(text(),'Roles')]")
    @CacheLookup
    WebElement rolesTab;
    
    @FindBy(xpath = "//div[@class='settings-tab-container clearfix']/ul/li/a/span[contains(text(),'Users')]")
    @CacheLookup
    WebElement usersTab;
    
    @FindBy(xpath = "//button[contains(text(),'New Role')]")
    @CacheLookup
    WebElement newRoleButton;
    
    @FindBy(xpath = "//span[contains(text(),'This is only write permission for a project')]/parent::div/div//i[@class='dd-icons delite-icon dlt-icon-delete icon-mr']")
    @CacheLookup
    WebElement deleteWriteRoleIconElement;
    
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    @CacheLookup
    WebElement deleteRoleButtonElement;
    
    
    
    
    
    
    
    public RolesPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(rolesTab,15);
        log.info("element is visible now...." + rolesTab);
        logExtentReport("element is visible now.... and element text is  " + rolesTab.getText());

    }
    
    public String getRolesText() {
		return rolesHeadingText.getText();
	}
    
    public void ClickRolesText() {
		 rolesHeadingText.click();
	}
    
    public void ClickRolesTab() {
    	rolesTab.click();
	}
    
    
    
    public void ClickDeleteWriteRoleICon() {
    	deleteWriteRoleIconElement.click();
	}
    
    public void ClickDeleteRoleButton() {
    	deleteRoleButtonElement.click();
	}
    
    
    
    
    public AddRolePage clickAddNewRoleButton()
	{
		log.info("Clicking on the New Role  Button... ");
		logExtentReport("Clicking on the New Role Button... ");
		newRoleButton.click();
	    return new AddRolePage(driver);
	}
    
    public UsersPage clickUsersTab()
	{
		log.info("Clicking on the Users Tab  Button... ");
		logExtentReport("Clicking on the Users Tab Button... ");
		usersTab.click();
	    return new UsersPage(driver);
	}

    
    
}
