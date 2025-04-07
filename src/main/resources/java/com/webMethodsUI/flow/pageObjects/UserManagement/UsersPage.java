package com.webMethodsUI.flow.pageObjects.UserManagement;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class UsersPage {
	WebDriver driver;
    private Logger log = LogManager.getLogger(UsersPage.class);
    WaitHelper waitHelper;
    
    @FindBy(xpath = "//h3[contains(text(),'Users')]")
    @CacheLookup
    WebElement usersList;
    
    @FindBy(xpath = "//div/span[contains(text(),'role')]")
    @CacheLookup
    WebElement roleUserName;
    
    @FindBy(xpath = "//div/span[contains(text(),'role')]/ancestor::li[@class='clearfix table-body']/div[3]/span[2]/a")
    @CacheLookup
    WebElement editRoleUserIcon;
    
  //span[contains(text(),'Email')]
    
    @FindBy(xpath = "//span[contains(text(),'Email')]")
    @CacheLookup
    WebElement emailTextElement;
    
    
    
    
    
    
    
    
    
    
    public UsersPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(roleUserName,15);
        log.info("element is visible now...." + roleUserName);
        logExtentReport("element is visible now.... and element text is  " + roleUserName.getText());

    }
    
    public String getUsersText() {
		return usersList.getText();
	}
    
    public String getEmailText() {
		return emailTextElement.getText();
	}
    
    public String getRoleUserName() {
        log.info("element is visible now....");
        logExtentReport(
                "element is visible now.... and element text is  " + roleUserName.getText());

        return roleUserName.getText();

    }
    
    public EditRoleUserPage clickEditRoleIcon()
	{
		log.info("Clicking on the edit Role  Button... ");
		logExtentReport("Clicking on the edit Role Button... ");
		editRoleUserIcon.click();
	    return new EditRoleUserPage(driver);
	}


    

}
