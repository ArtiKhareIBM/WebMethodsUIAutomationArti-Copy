package com.webMethodsUI.flow.pageObjects.monitor;

import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboardpage extends CommonActions {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='dashboard-card dashboard-card-total']")
    @CacheLookup
    WebElement DashboardElement;

    public Dashboardpage(WebDriver driver) 
    {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logExtentReport("Dashboard PageObjectCreated");
    }
}
