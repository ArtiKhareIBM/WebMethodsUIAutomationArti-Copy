package com.webMethodsUI.flow.pageObjects.UserManagement;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.TestBase;

public class AddRolePage {
	WebDriver driver;
    private Logger log = LogManager.getLogger(AddRolePage.class);
    WaitHelper waitHelper;
    
    @FindBy(xpath = "//h1[contains(text(),'Add Role')]")
    @CacheLookup
    WebElement addRoleText;
    
    @FindBy(xpath = "//input[@aid='Role Name']")
    @CacheLookup
    WebElement roleNameTextField;
    
    @FindBy(xpath = "//textarea[@aid='Description']")
    @CacheLookup
    WebElement descriptionTextField;
    
    
    @FindBy(xpath = "//input[@placeholder='Search']")
    @CacheLookup
    WebElement searchTextField;
    
    @FindBy(xpath = "//label[@for='write']")
    @CacheLookup
    WebElement writePermission;
    
    @FindBy(xpath = "//span[@data-testid='execute']")
    @CacheLookup
    WebElement executePermission;
    
    
    
    
    
    @FindBy(xpath = "//button[contains(text(),'Done')]")
    @CacheLookup
    WebElement doneButton;
    
    
    
    
    
    public AddRolePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(addRoleText,15);
        log.info("element is visible now...." + addRoleText);
        logExtentReport("element is visible now.... and element text is  " + addRoleText.getText());

    }
    
    public void enterRoleName(String roleName)
	{
		log.info("Creating New Role with name... " + roleName);
		logExtentReport("Creating New Role with name... " + roleName);
		roleNameTextField.sendKeys(roleName);
		
	}
    
    public void enterRoleNameDescription(String roleNameDescription)
	{
		log.info("Creating New Role with description... " + roleNameDescription);
		logExtentReport("Creating New Role with description... " + roleNameDescription);
		descriptionTextField.sendKeys(roleNameDescription);
		
	}
    
    
    public void searchProjectName(String searchProjectName)
	{
		log.info("searching the project name that we are going to give the permission... " + searchProjectName);
		logExtentReport("searching the project name that we are going to give the permission... " + searchProjectName);
		searchTextField.sendKeys(searchProjectName);
		
	}
    
    public void clickWritePermissionCheckbox()
	{
		log.info("Clicking on the write permission checkbox... ");
		logExtentReport("Clicking on the Write Permission check box... ");
		writePermission.click();
	    
	}
    
    public void UncheckExecutePermissionCheckbox()
	{
		log.info("Unchecking on the execute permission checkbox... ");
		logExtentReport("Unchecking on the execute permission checkbox... ");
		executePermission.click();
	    
	}
    
    public RolesPage clickDoneButton() throws Exception
	{
		log.info("Clicking on the Done Button... ");
		logExtentReport("Clicking on the Done Button... ");
		GenericHelper genericObj = new GenericHelper(driver);
		genericObj.clickButton("Done");
		return new RolesPage(driver);
	}
    
    
    
   
    
    
    
    

}
