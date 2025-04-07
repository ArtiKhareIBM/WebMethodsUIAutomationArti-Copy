package com.webMethodsFlowUI.testsuites.OauthFeature;

import com.webMethodsUI.flow.helper.assertion.AssertionHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.pageObjects.Settingpage.*;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.flowService.*;
import com.webMethodsUI.flow.pageObjects.monitor.AuditLogsPage;
import com.webMethodsUI.flow.pageObjects.monitor.MonitorPage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.restapi.*;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OauthVerification extends TestBase {
    HomePage homePage;
    ClientCertificateConfigurationpage configurationpage;
    TenantCertificatepage tenantCertificatepage;
    UserCertificatepage usercrtificatepg;
    LoginPage loginPage;
    Oauthclientregistrationhomepage oauthclientregistrationhomepage;
    AddNewClientpage addNewClientpage;
    ScopemanagementHomepage scopemanagementHomepage;
    AssociateScopepage associateScopepage;
    AddNewScopepage addNewScopepage;
    WorkflowsPage workflowPage;
    FlowServicePage flowServicePage;
    FlowServiceCanvasPage flowServiceCanvasPage;
    EditMappingPage editMappingPage;
    SetValuePage setValuePage;
    NavigationMenu navigationMenuPage;
    FlowServiceOverViewDatepage overviewpage;
    RestApiHomePage restApiHomePage;
    RestApiLetsGetStartedPage restApiLetsGetStartedPage;
    RestApiBasicInfoPage restApiBasicInfoPage;
    ResourcesAndMethodsPage resourcesAndMethodsPage;
    HttpMethodPage httpMethodPage;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMM");
  		LocalDateTime now = LocalDateTime.now();
  		String currentDateMonth = dtf.format(now);
//  		String projectName = "ICUI_"+currentDateMonth+"Oauth";


  		String projectName = "ICUI_AutomationProject3";
    String clientName = "ICUI_Oauthclientreg";
    String version = "1";
    String ClientName = "ICUI_Oauthclientregtest";
    String ClientName1 = "ICUI_Oauthclientregtestimplicit";
    String ScopeName = "ICUI_Scopetest";
    String serviceType = "Math";
    String serviceName = "addInts";
    String flowServiceName = "Oauth_AddIntsFS";
    String restApiName = "Oauth_RAD";
    String versionValue = "1";
    String restApidescription = "Rest api description here....";
    String resourcePathName = "/myTestpath";
    String ScopeNameRAD = "ICUI_ScopeRAD";
    String ScopeNameDifferent = "ICUI_CustomScope";
    String ScopeNameMultiple = "ICUI_ScopeMultipleService";
    String DefaultflowServiceName = "DefaultTestFlow";
    String implicitclient = "ICUI_Impliciteclientgranttype";
    String clientcredentialgrant = "CredentialGranttype";
    String Resourceownerpassword = "ICUI_ResourceOwnerPasswordClient";
    String Allgranttype = "AllgranttypeClient";
    String OauthClient = "ICUI_OauthClientTest";
    String AssociatedScope = "ICUI_AssociatedScopeNew";


    boolean status;

    @Test(groups = "sanity1", description = "ensure login workd fine", priority = 1)
    public void loginTest() throws Exception {

    	getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
    }

    @Test(groups = "sanity1", description = "Verify the oauth2.0 tab is visible in the setting page", priority = 2)
    public void BIC_T6276_Verifytheoauthtabisvisible() throws Exception
    {
        homePage = new HomePage(driver);
        configurationpage = homePage.clickSettinglink();
        configurationpage = new ClientCertificateConfigurationpage(driver);
        Assert.assertTrue(configurationpage.OauthIsVisible());
    }

    @Test(groups = "sanity1", description = "Verify the 'Client registration','Scope management','Token management' tab are visible or not under the oauth2.0 tab", priority = 3)
    public void BIC_T6277VerifyclientregistrationscopemanagementAndTokenManagementpage() throws Exception
    {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickOnTreeMainMenu("OAuth 2.0");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        Assert.assertTrue(oauthclientregistrationhomepage.ClientRegistrationIsVisible());
        Assert.assertTrue(oauthclientregistrationhomepage.ScopeManagementIsVisible());
        Assert.assertTrue(oauthclientregistrationhomepage.TokenManagementIsVisible());
    }

    @Test(groups = "sanity1", description = "Verify the client can create with different version with same name.", priority = 4)
    public void BIC_T6278Verifytheclientcancreatewithdifferentversionwithsamename() throws Exception 
    {
        oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(clientName);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Authorization Code Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        addNewClientpage = oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(clientName);
        addNewClientpage.EnteringversionField("2");
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper1 = new GenericHelper(driver);
        genericHelper1.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Authorization Code Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(clientName+"("+version+")");
        oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+clientName+", version "+version+".");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(clientName+"(2)");
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+clientName+", version 2.");
    }

    @Test(groups = "sanity1", description = "Verify the client can create with duplicate redirection URL", priority = 5)
    public void BIC_T6279VerifytheClientCanCreateWithDuplicateRedirectionURL() throws Exception {
        oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(clientName);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.addingadditionalurl(0,"https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Authorization Code Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        Assert.assertEquals(addNewClientpage.getSuccesMessageofImportfile(),"Duplicate redirection URLs are not allowed.");
        addNewClientpage.waittillitappears();
        genericHelper.clickButton("Cancel");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);

    }

    @Test(groups = "sanity1", description = "Verify the client can create with multiple redirection url.", priority = 6)
    public void BIC_T6280VerifyTheClientCanCreateWithMultipleRedirectionURl() throws Exception {
        oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(ClientName);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.addingadditionalurl(0,"https://www.postman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Authorization Code Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
    }

    @Test(groups = "sanity1", description = "After client creation verify the consumer ID and client sceret are generating or not", priority = 7)
    public void BIC_T6281AfterClientCreationVerifyTheConsumerIDAndClientSceretAreGeneratingOrNot() throws Exception{
        addNewClientpage = oauthclientregistrationhomepage.Editclient(ClientName+"("+version+")");
        addNewClientpage = new AddNewClientpage(driver);
        Assert.assertTrue(addNewClientpage.verifyclientIDandSecret());
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.clickButton("Cancel");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(ClientName+"("+version+")");
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+ClientName+", version "+version+".");
    }

    @Test(groups = "sanity1", description = "Verify the consumer id and client secret are changing or not while editing the client.", priority = 8)
    public void BIC_T6282Verify_the_consumer_id_and_client_secret_changing_or_not_while_editing_the_client() throws Exception {
        oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(ClientName1);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Authorization Code Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        addNewClientpage = oauthclientregistrationhomepage.Editclient(ClientName1+"("+version+")");
        addNewClientpage = new AddNewClientpage(driver);
        String a1 = addNewClientpage.getclient();
        addNewClientpage.EnterDescription("Go Corona Go Corona");
        GenericHelper genericHelper1 = new GenericHelper(driver);
        genericHelper1.clickButton("Update");
        driver.navigate().refresh();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        addNewClientpage = oauthclientregistrationhomepage.Editclient(ClientName1+"("+version+")");
        addNewClientpage = new AddNewClientpage(driver);
        String a2 = addNewClientpage.getclient();
        Assert.assertEquals(a2,a1);
        GenericHelper genericHelper2 = new GenericHelper(driver);
        genericHelper2.clickButton("Cancel");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(ClientName1+"("+version+")");
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+ClientName1+", version "+version+".");
       

    }

    @Test(groups = "sanity1", description = "verify the invoked flow and rest api are visible inside the project tree", priority = 9)
    public void BIC_T6283_BICT684verifytheinvoked_flow_and_rest_api_are_visible_inside_project_tree() throws Exception {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickOnHomePage();
        homePage = new HomePage(driver);
        configurationpage = homePage.clickSettinglink();
        configurationpage = new ClientCertificateConfigurationpage(driver);
        Assert.assertTrue(configurationpage.OauthIsVisible());
        NavigationMenu navigationMenu2 = new NavigationMenu(driver);
        navigationMenu2.clickOnTreeMainMenu("OAuth 2.0");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        navigationMenu2.clickOnTreeMainMenu("Scope Management");
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        addNewScopepage = scopemanagementHomepage.addnewscopebutton();
        addNewScopepage = new AddNewScopepage(driver);
        addNewScopepage.EnterNameForNewClient(ScopeName);
        addNewScopepage.selectingScopeFromproject(projectName);
        Assert.assertTrue(addNewScopepage.ServicesAreIsVisible("Flow Services"));
        Assert.assertTrue(addNewScopepage.ServicesAreIsVisible("REST APIs"));
        GenericHelper genericHelper2 = new GenericHelper(driver);
        genericHelper2.clickButton("Cancel");


    }

    @Test(groups = "sanity1", description = "Verify the service URL contain project ID or not ", priority = 10)
    public void BIC_T6285_T6292_T6286Verifytheservice_URL_contain_project_ID_or_not () throws Exception 
    {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        homePage =  navigationMenu.clickOnHomePage();
        homePage.searchProject(projectName);
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Integrations");
        navigationMenuPage.clickOnTreeSubMenu("Flow services");
        flowServicePage = new FlowServicePage(driver);
        flowServiceCanvasPage = flowServicePage.clickOnAddFreshFlowServiceButton();
        Assert.assertEquals(flowServiceCanvasPage.getflowServiceSubTitle(), "Start creating the Flow service");

        flowServiceCanvasPage.closeFlowServiceInfoDialogIfExists();
        flowServiceCanvasPage.enterFlowServiceTitle(flowServiceName);
        flowServiceCanvasPage.enterFlowSeviceDescription("TestFlowService Description here");
        flowServiceCanvasPage.enterFlowFirstStepAndSelect(serviceType,"SERVICES");
        boolean status = flowServiceCanvasPage.isSelectOperationDropDownVisible(0);
        AssertionHelper.verifyTestStatus(status);
        flowServiceCanvasPage.selectService(serviceName);
        editMappingPage = flowServiceCanvasPage.clickOnEditMappingIcon();
//        Assert.assertTrue(editMappingPage.isEditMappingTitleVisible());

        // set value for num1
        editMappingPage.doubleClickOnChildParamName("num1");
        setValuePage = new SetValuePage(driver);
        setValuePage.setValue("num1", "5");
        setValuePage.clickOnSave();

        // set value for num2
        editMappingPage = new EditMappingPage(driver);
        editMappingPage.doubleClickOnChildParamName("num2");
        setValuePage = new SetValuePage(driver);
        setValuePage.setValue("num2", "10");
        setValuePage.clickOnSave();
        editMappingPage = new EditMappingPage(driver);
        Assert.assertTrue(editMappingPage.verifyValueSetForParameters("num1"));
        Assert.assertTrue(editMappingPage.verifyValueSetForParameters("num2"));
        flowServiceCanvasPage = new FlowServiceCanvasPage(driver);
        flowServiceCanvasPage.clickOnRunButton();
        Assert.assertTrue(flowServiceCanvasPage.isRunSuccessMessageDisplayed());
        Assert.assertTrue(flowServiceCanvasPage.verifyDirectResultValue("value", "15"));
        flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
        flowServicePage = new FlowServicePage(driver);
        overviewpage = flowServicePage.gointoOverviewPage(flowServiceName);
        overviewpage = new FlowServiceOverViewDatepage(driver);
        overviewpage.clickcheckbox();
        overviewpage =   new FlowServiceOverViewDatepage(driver);
        overviewpage.closethescreen();
        NavigationMenu navigationMenu1 = new NavigationMenu(driver);
        navigationMenu1.clickOnHomePage();
        homePage = new HomePage(driver);
        configurationpage = homePage.clickSettinglink();
        configurationpage = new ClientCertificateConfigurationpage(driver);
        Assert.assertTrue(configurationpage.OauthIsVisible());
        NavigationMenu navigationMenu2 = new NavigationMenu(driver);
        navigationMenu2.clickOnTreeMainMenu("OAuth 2.0");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        navigationMenu2.clickOnTreeMainMenu("Scope Management");
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        addNewScopepage = scopemanagementHomepage.addnewscopebutton();
        addNewScopepage = new AddNewScopepage(driver);
        addNewScopepage.EnterNameForNewClient(ScopeName);
        Thread.sleep(2000);
        addNewScopepage.selectingScopeFromproject(projectName);
        addNewScopepage.selectingScopeFromServices("Flow Services",1);
        addNewScopepage.clickingcheckboxofrequiredService(flowServiceName,0);
        addNewScopepage.ClickAddButton();
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        Thread.sleep(2000);
        scopemanagementHomepage.DeleteScope(ScopeName);

    }

    @Test(groups = "sanity1", description = "Verify the scope can create with integration first rad or not", priority = 11)
    public void BIC_T6287Verify_the_scope_can_create_with_integration_first_rad() throws Exception {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickOnHomePage();
        homePage = new HomePage(driver);
        homePage.openProject(projectName);
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("APIs");
        restApiHomePage = new RestApiHomePage(driver);
        restApiLetsGetStartedPage = restApiHomePage.clickOnCreateApiButton();
        Assert.assertEquals(restApiLetsGetStartedPage.getCreateFromScratchLabel(),
                "Create from scratch / Design new API");
        restApiBasicInfoPage = restApiLetsGetStartedPage.clickOnNext();
        restApiBasicInfoPage.enterName(restApiName);
        restApiBasicInfoPage.enterVersion(versionValue);
        restApiBasicInfoPage.enterDescription(restApidescription);
        restApiBasicInfoPage.clickOnSaveButton();
        resourcesAndMethodsPage =  new ResourcesAndMethodsPage(driver);
        Assert.assertEquals(resourcesAndMethodsPage.getresourcesAndMethodsTitle(), "Resources and Methods");
        resourcesAndMethodsPage = new ResourcesAndMethodsPage(driver);
        resourcesAndMethodsPage.clickOnAddResourceButton();
        resourcesAndMethodsPage.enterPathValue(resourcePathName);
        httpMethodPage = resourcesAndMethodsPage.clickOnHTTPMethod("POST");
//        httpMethodPage.enterResourceDescription("myTestDescription here");
        Thread.sleep(200);
        httpMethodPage.selectFlowService(flowServiceName);
        Thread.sleep(4000);
        resourcesAndMethodsPage = httpMethodPage.clickOnDoneButton();
        Thread.sleep(2000);
        Assert.assertEquals(resourcesAndMethodsPage.getResourceNameBeforeSavingResource(resourcePathName),
                resourcePathName);
        resourcesAndMethodsPage.clickOnSaveButton();
        Assert.assertEquals(resourcesAndMethodsPage.getCreatedResourceName(resourcePathName), resourcePathName);
        restApiHomePage = resourcesAndMethodsPage.clickOnRestApiLink();
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnHomePage();
        homePage = new HomePage(driver);
        configurationpage = homePage.clickSettinglink();
        configurationpage = new ClientCertificateConfigurationpage(driver);
        Assert.assertTrue(configurationpage.OauthIsVisible());
        NavigationMenu navigationMenu2 = new NavigationMenu(driver);
        navigationMenu2.clickOnTreeMainMenu("OAuth 2.0");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        navigationMenu2.clickOnTreeMainMenu("Scope Management");
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        addNewScopepage = scopemanagementHomepage.addnewscopebutton();
        addNewScopepage = new AddNewScopepage(driver);
        addNewScopepage.EnterNameForNewClient(ScopeNameRAD);
        addNewScopepage.selectingScopeFromproject(projectName);
        addNewScopepage.selectingScopeFromServices("REST APIs",1);
        addNewScopepage.selectingScopeFromServices(restApiName,2);
        addNewScopepage.selectingScopeFromServices(resourcePathName,3);
        addNewScopepage.clickingcheckboxofrequiredService(flowServiceName,0);
        addNewScopepage.ClickAddButton();
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        scopemanagementHomepage.DeleteScope(ScopeNameRAD);
        Assert.assertEquals(scopemanagementHomepage.getSuccesMessageofImportfile(),"Deleted scope "+ScopeNameRAD+" successfully.");
     
    }

    @Test(groups = "sanity1", description = "Verify the scope can create by selecting multiple services.", priority = 12)
    public void BIC_T6289_BIC_T6318Verify_the_scope_can_create_by_selecting_multiple_services() throws Exception {
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        addNewScopepage = scopemanagementHomepage.addnewscopebutton();
        addNewScopepage = new AddNewScopepage(driver);
        addNewScopepage.EnterNameForNewClient(ScopeNameMultiple);
        Thread.sleep(2000);
        addNewScopepage.selectingScopeFromproject(projectName);
        addNewScopepage.selectingScopeFromServices("Flow Services",1);
        addNewScopepage.clickingcheckboxofrequiredService(flowServiceName,0);
        addNewScopepage = new AddNewScopepage(driver);
        addNewScopepage.selectingScopeFromServices("REST APIs",1);
        addNewScopepage.selectingScopeFromServices(restApiName,2);
        addNewScopepage.selectingScopeFromServices(resourcePathName,3);
        addNewScopepage.clickingcheckboxofrequiredService(flowServiceName,1);
        addNewScopepage.ClickAddButton();
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        scopemanagementHomepage.DeleteScope(ScopeNameMultiple);
        Assert.assertEquals(scopemanagementHomepage.getSuccesMessageofImportfile(),"Deleted scope "+ScopeNameMultiple+" successfully.");
       

    }

    @Test(groups = "sanity1", description = "Verify the scope can be created by selecting services from different project(means one service from default and one from custom project).", priority = 13)
    public void BIC_T6290VerifytheScopeCanBeCreatedBySelectingServicesFromDifferentProject() throws Exception 
    {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickOnHomePage();
        homePage = new HomePage(driver);
        homePage.searchProject("Default");
        //homePage.openProject("Default");
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Integrations");
        navigationMenuPage.clickOnTreeSubMenu("Flow services");
        flowServicePage = new FlowServicePage(driver);
        flowServiceCanvasPage = flowServicePage.clickOnAddFreshFlowServiceButton();
        Assert.assertEquals(flowServiceCanvasPage.getflowServiceSubTitle(), "Start creating the Flow service");

//        flowServiceCanvasPage.closeFlowServiceInfoDialogIfExists();
        flowServiceCanvasPage.enterFlowServiceTitle(DefaultflowServiceName);
        flowServiceCanvasPage.enterFlowSeviceDescription("TestFlowService Description here");
        flowServiceCanvasPage.enterFlowFirstStepAndSelect(serviceType,"SERVICES");
        boolean status = flowServiceCanvasPage.isSelectOperationDropDownVisible(0);
        AssertionHelper.verifyTestStatus(status);
        flowServiceCanvasPage.selectService(serviceName);
        editMappingPage = flowServiceCanvasPage.clickOnEditMappingIcon();
//        Assert.assertTrue(editMappingPage.isEditMappingTitleVisible());

        // set value for num1
        editMappingPage.doubleClickOnChildParamName("num1");
        setValuePage = new SetValuePage(driver);
        setValuePage.setValue("num1", "5");
        setValuePage.clickOnSave();

        // set value for num2
        editMappingPage = new EditMappingPage(driver);
        editMappingPage.doubleClickOnChildParamName("num2");
        setValuePage = new SetValuePage(driver);
        setValuePage.setValue("num2", "10");
        setValuePage.clickOnSave();
        editMappingPage = new EditMappingPage(driver);
        Assert.assertTrue(editMappingPage.verifyValueSetForParameters("num1"));
        Assert.assertTrue(editMappingPage.verifyValueSetForParameters("num2"));
        flowServiceCanvasPage = new FlowServiceCanvasPage(driver);
        flowServiceCanvasPage.clickOnRunButton();
        Assert.assertTrue(flowServiceCanvasPage.isRunSuccessMessageDisplayed());
        Assert.assertTrue(flowServiceCanvasPage.verifyDirectResultValue("value", "15"));
        flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
        flowServicePage = new FlowServicePage(driver);
        overviewpage = flowServicePage.gointoOverviewPage(DefaultflowServiceName);
        overviewpage = new FlowServiceOverViewDatepage(driver);
        overviewpage.clickcheckbox();
        overviewpage =   new FlowServiceOverViewDatepage(driver);
        overviewpage.closethescreen();
        flowServicePage = new FlowServicePage(driver);

        navigationMenuPage  = new NavigationMenu(driver);
        navigationMenuPage.clickOnHomePage();
        homePage = new HomePage(driver);
        configurationpage = homePage.clickSettinglink();
        configurationpage = new ClientCertificateConfigurationpage(driver);
        Assert.assertTrue(configurationpage.OauthIsVisible());
        NavigationMenu navigationMenu2 = new NavigationMenu(driver);
        navigationMenu2.clickOnTreeMainMenu("OAuth 2.0");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        navigationMenu2.clickOnTreeMainMenu("Scope Management");
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        addNewScopepage = scopemanagementHomepage.addnewscopebutton();
        addNewScopepage.EnterNameForNewClient(ScopeNameDifferent);
        Thread.sleep(2000);
        addNewScopepage.selectingScopeFromproject(projectName);
        addNewScopepage.selectingScopeFromServices("Flow Services",1);
        addNewScopepage.clickingcheckboxofrequiredService(flowServiceName,0);
        addNewScopepage = new AddNewScopepage(driver);
        addNewScopepage.selectingScopeFromproject("Default");
        addNewScopepage.selectingScopeFromServices("Flow Services",1);
        addNewScopepage.clickingcheckboxofrequiredService(DefaultflowServiceName,0);
        addNewScopepage.ClickAddButton();
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        scopemanagementHomepage.DeleteScope(ScopeNameDifferent);
        Assert.assertEquals(scopemanagementHomepage.getSuccesMessageofImportfile(),"Deleted scope "+ScopeNameDifferent+" successfully.");
        
    }

    @Test(groups = "sanity1", description = "Verify the scope creation from the client registration page.", priority = 14)
    public void BIC_T6291Verifythescopecreationfromtheclientregistrationpage() throws Exception 
    {
    	  NavigationMenu navigationMenu = new NavigationMenu(driver);
          navigationMenu.clickOnHomePage();
          homePage = new HomePage(driver);
          configurationpage = homePage.clickSettinglink();
          configurationpage = new ClientCertificateConfigurationpage(driver);
          Assert.assertTrue(configurationpage.OauthIsVisible());
          NavigationMenu navigationMenu2 = new NavigationMenu(driver);
          navigationMenu2.clickOnTreeMainMenu("OAuth 2.0");
          oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        addNewClientpage = oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(OauthClient);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Authorization Code Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.Associatetheclientwithscope(OauthClient+"("+version+")");
        associateScopepage = new AssociateScopepage(driver);
        addNewScopepage = associateScopepage.AssociatenewScope();
        addNewScopepage = new AddNewScopepage(driver);
        addNewScopepage.EnterNameForNewClient(AssociatedScope);
        Thread.sleep(2000);
        addNewScopepage.selectingScopeFromproject(projectName);
        addNewScopepage.selectingScopeFromServices("Flow Services",1);
        addNewScopepage.clickingcheckboxofrequiredService(flowServiceName,0);
        Assert.assertTrue(addNewScopepage.VerifyAssociatebuttonenabled());
        addNewScopepage.ClickAssociatebutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);


    }

    @Test(groups = "sanity1", description = "Verify the scope can be delete which is already mapped with the client.", priority = 15)
    public void BIC_T6297Verify_the_scope_can_be_delete_which_is_already_mapped_with_the_client() throws Exception {
       NavigationMenu navigationMenu2 = new NavigationMenu(driver);
       Thread.sleep(2000);
       navigationMenu2.clickOnTreeMainMenu("Scope Management");
       scopemanagementHomepage = new ScopemanagementHomepage(driver);
       Assert.assertFalse(scopemanagementHomepage.DeleteButtonVisible(AssociatedScope));
       GenericHelper genericHelper = new GenericHelper(driver);
       genericHelper.clickButton("Cancel");
       //scopemanagementHomepage = new ScopemanagementHomepage(driver);
    }

    @Test(groups = "sanity1", description = "verify the scope creation with invalid character", priority = 16)
    public void BIC_T6295verify_the_scope_creation_withinvalidcharacter() throws Exception{
        scopemanagementHomepage = new ScopemanagementHomepage(driver);
        addNewScopepage = scopemanagementHomepage.addnewscopebutton();
        addNewScopepage.EnterNameForNewClient("@12354");
        Assert.assertTrue(addNewScopepage.Errormsgforinvalidletter());
        driver.navigate().refresh();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(OauthClient+"("+version+")");
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+OauthClient+", version "+version+".");
      
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnTreeMainMenu("Scope Management");
        scopemanagementHomepage.DeleteScope(AssociatedScope);
        Assert.assertEquals(scopemanagementHomepage.getSuccesMessageofImportfile(),"Deleted scope "+AssociatedScope+" successfully.");
      

    }

    @Test(groups = "sanity1", description = "Generate the access token and run the rest api which created using work flow using grant type 'Implicit grant' and verify the execution is successful or not.", priority = 17)
    public void BIC_T6308whichcreatedusingwork_flow_using_grant_type_Implicit_grant() throws Exception {
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnTreeMainMenu("Client Registration");
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        addNewClientpage = oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(implicitclient);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("public");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Implicit Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(implicitclient+"("+version+")");
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+implicitclient+", version "+version+".");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
    }

    @Test(groups = "sanity1", description = "Generate the access token and run the rest api which created using work flow using grant type 'Client credentials grant' and verify the execution is successful or not", priority = 18)
    public void BIC_T6309which_created_using_work_flow_using_grant_type_Client_credentials_grant() throws Exception{
        addNewClientpage = oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(clientcredentialgrant);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Client Credentials Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(clientcredentialgrant+"("+version+")");
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+clientcredentialgrant+", version "+version+".");
      


    }

    @Test(groups = "sanity1", description = "Generate the access token and run the rest api which created using work flow using grant type 'Resources owner password credentials grant' and verify the execution is successful or not", priority = 19)
    public void BIC_T6310whichcreatedusing_work_flow_using_grant_typeResources_owner_password_credentials_grant() throws Exception{
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        addNewClientpage = oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(Resourceownerpassword);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Resource Owner Password Credentials Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(Resourceownerpassword+"("+version+")");
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+Resourceownerpassword+", version "+version+".");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);

    }


    @Test(groups = "sanity1", description = "Run the flow service with all 4 grant type and verify the execution is successfull or not.", priority = 20)
    public void BIC_T6311Run_the_flow_service_with_all_4_grant_type_and_verify_the_execution_is_successfull() throws Exception{
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        addNewClientpage = oauthclientregistrationhomepage.addnewclient();
        addNewClientpage = new AddNewClientpage(driver);
        addNewClientpage.EnterNameForNewClient(Allgranttype);
        addNewClientpage.EnteringversionField(version);
        addNewClientpage.clickDropdown();
        GenericHelper genericHelper = new GenericHelper(driver);
        genericHelper.selectDropDownLink("confidential");
        addNewClientpage.EnteringRedirectionURL("https://www.getpostman.com/oauth2/callback");
        addNewClientpage.clickingcheckbox("Authorization Code Grant");
        addNewClientpage.clickingcheckbox("Resource Owner Password Credentials Grant");
        addNewClientpage.clickingcheckbox("Client Credentials Grant");
        addNewClientpage.clickingcheckbox("Implicit Grant");
        addNewClientpage.clickingcheckbox("Never Expires");
        addNewClientpage.clickingcheckbox("Unlimited");
        Assert.assertTrue(addNewClientpage.IsAddbuttonEnabled());
        addNewClientpage.clickAddbutton();
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Client Id And Client Secret generated for new client added.");
      

    }
    @Test(groups = "sanity1", description = "Search field working", priority = 21)
    public void Searchfieldworking() throws Exception
    {
        oauthclientregistrationhomepage.Searchrequiredclient("Testxyzkjh");
        Assert.assertTrue(oauthclientregistrationhomepage.emptyclientmessage());
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.Searchrequiredclient(Allgranttype);
        //Assert.assertFalse(oauthclientregistrationhomepage.emptyclientmessage());
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);
        oauthclientregistrationhomepage.DeleteClient(Allgranttype+"("+version+")");
       oauthclientregistrationhomepage.getSuccesMessageofImportfile("Successfully removed client "+Allgranttype+", version "+version+".");
      
        oauthclientregistrationhomepage = new Oauthclientregistrationhomepage(driver);

    }



    @Test(groups = "sanity1", description = "Delete Creaed Assets", priority = 22)
    public void DeleteCreaedAssets() throws Exception {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickOnHomePage();
        homePage = new HomePage(driver);
        homePage.openProject("Default");
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Integrations");
        navigationMenuPage.clickOnTreeSubMenu("Flow services");
        flowServicePage = new FlowServicePage(driver);
        flowServicePage.deleteFlowService(DefaultflowServiceName);
        Thread.sleep(2000);
        //flowServicePage.VerifynoFlowServiceCreatedMessage();
        NavigationMenu navigationMenu1 = new NavigationMenu(driver);
        navigationMenu1.clickOnHomePage();
        homePage = new HomePage(driver);
        homePage.openProject(projectName);
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("APIs");
        restApiHomePage = new RestApiHomePage(driver);
        restApiHomePage.deleteRestAPI(restApiName);
//        Assert.assertEquals(restApiHomePage.isRestAPIExists(), "No APIs created yet!");
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Integrations");
        navigationMenuPage.clickOnTreeSubMenu("Flow services");
        flowServicePage = new FlowServicePage(driver);
        flowServicePage.deleteFlowService(flowServiceName);
    //    flowServicePage.VerifynoFlowServiceCreatedMessage();
//        NavigationMenu navigationMenu3 = new NavigationMenu(driver);
//        navigationMenu3.clickOnHomePage();
//        homePage = new HomePage(driver);
//        homePage.deleteProject(projectName);
    }
    @Test(groups = "sanity", description = "Verifing enable http interface in audit logs", priority = 23)
	public void verifyAuditLogTOEnableHTTPForFlow() throws Exception 
	{
	
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		navigationMenu.clickOnMainMenu("Monitor");
		MonitorPage monitorPage = new MonitorPage(driver);
		monitorPage.expandGeneralArrowIcon();
		monitorPage.clickOnAuditLogLabel();
	    monitorPage.clickOnUsagesLabel();
	    Thread.sleep(1000);
	    monitorPage.clickOnAuditLogLabel();

		AuditLogsPage auditLogsPage = new AuditLogsPage(driver);
		auditLogsPage.Searchclearfield();
		auditLogsPage.SearchAnElement("Expose as REST");
		auditLogsPage.verifyAuditLogActionText(projectName,flowServiceName,"FlowService", "Expose as REST");
	}

}
