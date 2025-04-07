package com.webMethodsUI.flow.pageObjects.UserManagement;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webMethodsUI.flow.helper.generic.GenericHelper;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class EditRoleUserPage extends CommonActions{
	WebDriver driver;
    private Logger log = LogManager.getLogger(EditRoleUserPage.class);
    WaitHelper waitHelper;
    
    @FindBy(xpath = "//h1[contains(text(),'Edit User Role')]")
    @CacheLookup
    WebElement editUserRoleText;
    
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
    @CacheLookup
    WebElement developerRoleCancelButton;
    
    @FindBy(xpath = "//div[@class='css-xb97g8 react-select2-common__multi-value__remove']")
    @CacheLookup
    WebElement adminRoleCancelButton;
    
    @FindBy(xpath = "//div[@class='css-xb97g8 react-select2-common__multi-value__remove']")
    @CacheLookup
    WebElement WriteRoleCancelButton;
    
    
    @FindBy(xpath = " //div[contains(text(),'Assign roles')]")
    @CacheLookup
    WebElement assignRolesTextField;
    
    @FindBy(xpath = "//div[@class='react-select2-common__indicator react-select2-common__dropdown-indicator css-tlfecz-indicatorContainer']/span")
    @CacheLookup
    WebElement selectRolesDropdown;
    
    @FindBy(xpath = "//button[contains(text(),'Done')]")
    @CacheLookup
    WebElement doneButton;
    
    @FindBy(xpath = "//div[@class='react-select2-common__input']/input")
    @CacheLookup
    WebElement assignRolesInputField;
    
    
    
    
    
    
    
    
    
    
    
	
	    public EditRoleUserPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(editUserRoleText,15);
        log.info("element is visible now...." + editUserRoleText);
        logExtentReport("element is visible now.... and element text is  " + editUserRoleText.getText());

    }
	    
	    
	    public String getEditUserRoleText() {
	        log.info("element is visible now....");
	        logExtentReport(
	                "element is visible now.... and element text is  " + editUserRoleText.getText());

	        return editUserRoleText.getText();

	    }
	    
	    public void cancellingDeveloperRole(){
	        log.info("cancelling developer role..");
	        logExtentReport("cancelling developer role.... ");
	        developerRoleCancelButton.click();
	 
	    }
	    
	    public void cancellingAdminRole(){
	        log.info("cancelling admin role..");
	        logExtentReport("cancelling admin role.... ");
	        adminRoleCancelButton.click();
	 
	    }
	    
	    public void cancellingWriteRole(){
	        log.info("cancelling write role..");
	        logExtentReport("cancelling write role.... ");
	        WriteRoleCancelButton.click();
	 
	    }
	    
	    
	    
	    public void enterRoleName(String roleName)
		{
			log.info("entering role name... " + roleName);
			logExtentReport("entering role name... " + roleName);
			assignRolesTextField.sendKeys(roleName);
			
		}
	    
	    public void selectRoleType(String roleName) {
	    	log.info("entering role name... " + roleName);
			logExtentReport("entering role name... " + roleName);
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Assign Roles')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
	    	executor.executeScript("arguments[0].click();",element );
	    	
	    	//assignRolesInputField.click();
	    	assignRolesInputField.sendKeys(roleName);
	    	Actions action = new Actions(driver);
	    	action.sendKeys(Keys.ENTER).perform();
	    	
	    	
  
	     }
	    
	    
	    public UsersPage clickDoneButton() throws Exception
		{
			log.info("Clicking on the Done Button... ");
			logExtentReport("Clicking on the Done Button... ");
			GenericHelper genericObj = new GenericHelper(driver);
			genericObj.clickButton("Done");
			return new UsersPage(driver);
		}
	    
	    


		
	    
}

