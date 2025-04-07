package com.webMethodsFlowUI.testsuites.RestApiHavingPackageService;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.flowService.DefineInputFieldsPage;
import com.webMethodsUI.flow.pageObjects.flowService.DefineOutputFieldsPage;
import com.webMethodsUI.flow.pageObjects.flowService.InputValuePage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.restapi.*;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;
import com.webMethodsUI.origin.pageObjects.PackageConnector.PackageConnectorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvokingRestapiusingpkgservice extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    WorkflowsPage workflowPage;
    NavigationMenu navigationMenuPage;
    PackageConnectorPage packageConnectorPage;
    GenericHelper genericHelperPage;
    RestApiHomePage restApiHomePage;
    RestApiLetsGetStartedPage restApiLetsGetStartedPage;
    RestApiBasicInfoPage restApiBasicInfoPage;
    CreatedAPIDetailsPage createdAPIDetailsPage;
    AddResourcePage addResourcePage;
    ResourcesAndMethodsPage resourcesAndMethodsPage;
    PostMethodPage postMethodPage;
    DefineInputFieldsPage defineInputFieldsPage;
    DefineOutputFieldsPage defineOutputFieldsPage;
    InputValuePage inputValuePage;
    HttpMethodPage httpMethodPage;


    String projectName = "Auto_IC_Origin_Project1";
    String url ="https://github.com/ak879753/ServicePackage";
    String packageName = "ServicePackage";
    String accountName ="abhk";
    String APIName = "UsingpackageService";
    String APIName1 = "UsingpackageprivateService";
    String resourcePath = "/abcd";
    String Servicename = "HA_rest_api";
    String Servicename1 = "HAWorkflow";
    String Servicename2 = "ForHAFlow";
    String runtime = "Cloud Designtime";
    //String data = "HA_rest_api-ServicePackage";
    String message = ".,'Note: Workflows containing a webhook and a tested Return Data on Sync Webhook action will be listed in the drop-down field.";

    @Test(groups = "sanity", description = "ensure login workd fine", priority = 1)
    public void loginTest() throws Exception
    {
        getApplicationUrl(ObjectReader.reader.getURL());
        loginPage = new LoginPage(driver);
        homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
    }

    @Test(groups = "sanity", description = "create project ", priority = 2)
    public void createProject() throws Exception
    {
        homePage.searchProject(projectName);
    }

    @Test(groups = "sanity", description = "Verify the package service listing in the rest api resource page", priority = 3)
    public void VerifyingListingofPackageservice() throws Exception {

        navigationMenuPage = new NavigationMenu(driver);
       navigationMenuPage.clickOnSubMenu("Packages");
        packageConnectorPage = new PackageConnectorPage(driver);
        packageConnectorPage.clickOnButton("Add package");
        packageConnectorPage.AddGitAccount();
        packageConnectorPage.enterGitUrl(url);
        Thread.sleep(5000);
        packageConnectorPage.selectSourceControl(accountName);
        packageConnectorPage.clickOnButton("Next");
        packageConnectorPage.ClickOnDropdown("Select an option");
        packageConnectorPage.ClickOnDropdown("main");
        packageConnectorPage.clickOnButton("Pull");
        Thread.sleep(3000);
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("APIs");
        restApiHomePage = new RestApiHomePage(driver);
        Assert.assertEquals(restApiHomePage.getAPIsPageTitle(), "APIs");
        genericHelperPage = new GenericHelper(driver);
        genericHelperPage.clickButton("Create API");
        restApiLetsGetStartedPage = new RestApiLetsGetStartedPage(driver);
        Assert.assertEquals(restApiLetsGetStartedPage.getStartedTitle(), "Let's get started!");
        navigationMenuPage = new NavigationMenu(driver);
        restApiLetsGetStartedPage = new RestApiLetsGetStartedPage(driver);
        genericHelperPage = new GenericHelper(driver);
        genericHelperPage.clickButton("Next");
        restApiBasicInfoPage = new RestApiBasicInfoPage(driver);
        Assert.assertEquals(restApiBasicInfoPage.getbasicInfoTitle(), "Basic Info");
        genericHelperPage = new GenericHelper(driver);
        restApiBasicInfoPage = new RestApiBasicInfoPage(driver);
        Assert.assertEquals(restApiBasicInfoPage.getbasicInfoTitle(), "Basic Info");
        restApiBasicInfoPage.enterRestAPIName(APIName);
        restApiBasicInfoPage.enterRestAPIVersion("6.1");
        restApiBasicInfoPage.enterRestAPIDescription("Writing REST API description using Selenium");
        restApiBasicInfoPage.clickOnSaveButton();
        resourcesAndMethodsPage =  new ResourcesAndMethodsPage(driver);
        resourcesAndMethodsPage.clickOnAddResourceButton();
        resourcesAndMethodsPage.enterPathValue(resourcePath);
        httpMethodPage = resourcesAndMethodsPage.clickOnHTTPMethod("POST");
//		httpMethodPage.enterResourceDescription("myTestDescription here");
        httpMethodPage.selectFlowService(Servicename);
        httpMethodPage.selectctRuntime(runtime);
        Thread.sleep(1000);
        //Assert.assertEquals(httpMethodPage.getMessagefromrrsourcepage(message),message);
        resourcesAndMethodsPage = httpMethodPage.clickOnDoneButton();
        Assert.assertEquals(resourcesAndMethodsPage.getResourceNameBeforeSavingResource(resourcePath),
                resourcePath);
        resourcesAndMethodsPage.clickOnSaveButton();
    }
    @Test(groups = "sanity", description = "Verify the updating of the created resource by selecting another packeg service", priority = 4)
    public void UpdateRestapiUsinganotherservice() throws Exception {
        resourcesAndMethodsPage =  new ResourcesAndMethodsPage(driver);
        restApiHomePage = resourcesAndMethodsPage.clickOnRestApiLink();
        restApiHomePage.EditRestApi(APIName);
        //resourcesAndMethodsPage.clickOnResourcebutton();
        resourcesAndMethodsPage.clickOnResourceEditButton();
        resourcesAndMethodsPage.selectinganotherservice(Servicename, Servicename1);
        Thread.sleep(1000);
        //Assert.assertEquals(httpMethodPage.getMessagefromrrsourcepage(message),message);
        resourcesAndMethodsPage.clickOnDoneButton();
        resourcesAndMethodsPage.clickOnSaveButton();


    }

    @Test(groups = "sanity", description = "Verify the private service from the package service listing or not in the rest api page", priority = 5)
    public void verifyprivateServicelisting() throws Exception {

        resourcesAndMethodsPage =  new ResourcesAndMethodsPage(driver);
        restApiHomePage = resourcesAndMethodsPage.clickOnRestApiLink();
        genericHelperPage = new GenericHelper(driver);
        genericHelperPage.clickButton("Create API");
        restApiLetsGetStartedPage = new RestApiLetsGetStartedPage(driver);
        Assert.assertEquals(restApiLetsGetStartedPage.getStartedTitle(), "Let's get started!");
        navigationMenuPage = new NavigationMenu(driver);
        restApiLetsGetStartedPage = new RestApiLetsGetStartedPage(driver);
        genericHelperPage = new GenericHelper(driver);
        genericHelperPage.clickButton("Next");
        restApiBasicInfoPage = new RestApiBasicInfoPage(driver);
        Assert.assertEquals(restApiBasicInfoPage.getbasicInfoTitle(), "Basic Info");
        genericHelperPage = new GenericHelper(driver);
        restApiBasicInfoPage = new RestApiBasicInfoPage(driver);
        Assert.assertEquals(restApiBasicInfoPage.getbasicInfoTitle(), "Basic Info");
        restApiBasicInfoPage.enterRestAPIName(APIName1);
        restApiBasicInfoPage.enterRestAPIVersion("6.1");
        restApiBasicInfoPage.enterRestAPIDescription("Writing REST API description using Selenium");
        restApiBasicInfoPage.clickOnSaveButton();
        resourcesAndMethodsPage =  new ResourcesAndMethodsPage(driver);
        resourcesAndMethodsPage.clickOnAddResourceButton();
        resourcesAndMethodsPage.enterPathValue(resourcePath);
        httpMethodPage = resourcesAndMethodsPage.clickOnHTTPMethod("POST");
        httpMethodPage.isprivateVariable(Servicename2);

//		httpMethodPage.enterResourceDescription("myTestDescription here");

    }


    }
