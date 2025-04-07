package com.webMethodsFlowUI.Integration.testsuites;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webMethodsUI.flow.appSwitcher.pageObjects.apps;
import com.webMethodsUI.flow.helper.assertion.AssertionHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.mycloud.PageObjects.MycloudPage;
import com.webMethodsUI.flow.pageObjects.PredefinedConnector.AccountPage;
import com.webMethodsUI.flow.pageObjects.PredefinedConnector.ConnectorsHomepage;
import com.webMethodsUI.flow.pageObjects.PredefinedConnector.WorkSpanAccountpage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddAccountPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddDocumentPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddResourcesPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.ConnectorsPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.DefineRESTConnectorPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.HeadersPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.RESTConnectorPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.RequestMethodPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.ResourcesPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.ResponseBodyPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.ResponseMethodPage;
import com.webMethodsUI.flow.pageObjects.RESTConnector.operationlistpage;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.flowService.CustomActionAccountPage;
import com.webMethodsUI.flow.pageObjects.flowService.CustomActionConfirmationPage;
import com.webMethodsUI.flow.pageObjects.flowService.CustomActionOperationPage;
import com.webMethodsUI.flow.pageObjects.flowService.DefineInputFieldsPage;
import com.webMethodsUI.flow.pageObjects.flowService.DefineOutputFieldsPage;
import com.webMethodsUI.flow.pageObjects.flowService.EditMappingPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceCanvasPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServicePage;
import com.webMethodsUI.flow.pageObjects.flowService.InputValuePage;
import com.webMethodsUI.flow.pageObjects.flowService.SetValuePage;
import com.webMethodsUI.flow.pageObjects.projects.Deployconfigurationpage;
import com.webMethodsUI.flow.pageObjects.projects.Deploypage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.projects.publishprojectpage;
import com.webMethodsUI.flow.pageObjects.restapi.CreatedAPIDetailsPage;
import com.webMethodsUI.flow.pageObjects.restapi.HttpMethodPage;
import com.webMethodsUI.flow.pageObjects.restapi.PostMethodPage;
import com.webMethodsUI.flow.pageObjects.restapi.ResourcesAndMethodsPage;
import com.webMethodsUI.flow.pageObjects.restapi.RestApiBasicInfoPage;
import com.webMethodsUI.flow.pageObjects.restapi.RestApiHomePage;
import com.webMethodsUI.flow.pageObjects.restapi.RestApiLetsGetStartedPage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class CloudContainer extends TestBase
{ 
		LoginPage loginPage;
	    HomePage homePage;
	    WorkflowsPage workflowPage;
	    NavigationMenu navigationMenuPage;
	    GenericHelper genericHelperPage;
	    FlowServicePage flowServicePage;
	    FlowServiceCanvasPage flowServiceCanvasPage; 
	    ConnectorsHomepage connectorhp;
	    WorkSpanAccountpage workspanaccountpage;
	    EditMappingPage editMappingPage;
	    SetValuePage setValuePage;
	    AccountPage accountPage;
	    CustomActionAccountPage customActionAccountPage;
		CustomActionOperationPage customActionOperationPage;
		CustomActionConfirmationPage customActionConfirmationPage;
		operationlistpage operationlistPage;
		  publishprojectpage publishProjectpg;
		    Deployconfigurationpage deployconfigurationpage;
	    

	public static String fileSeperator = System.getProperty("file.separator");
	
		String projectName = "ICUI_AutomationProject5";
//		String projectName1 = "ICUI_AutomationProject4";
	
	
		String ApplicationName = "webMethods Cloud Container";
		String AccountName = "CloudContainer";
		String flowServiceName = "CloudContainer";
	 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMM");
		LocalDateTime now = LocalDateTime.now();
		String currentDateMonth = dtf.format(now);
		String customOperationName = "customOperationName" + currentDateMonth;
	 

	  boolean status;


	    @Test(groups = "sanity1", description = "ensure login workd fine", priority = 1)
	    public void loginTest() throws Exception 
	    {

	        getApplicationUrl(ObjectReader.reader.getURL());
	        loginPage = new LoginPage(driver);

	        // login to application
	        homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	    }
	    
	    @Test(groups = "sanity", description = "create project ", priority = 2)
	    public void createProject() throws Exception 
	    {
//	    	homePage.searchProject(projectName);
	        workflowPage = homePage.createProject(projectName);
	     //   Assert.assertEquals(workflowPage.getWorkFlowMessage(), "No Workflows created yet!");
	       
	    }

	    @Test(groups = "sanity", description = "EnsureConnector page is loaded And Search Sales Force crm connector ", priority = 3)
	    public void ensureConnectorPageLoadedAndSearchconnector() throws Exception {

	        navigationMenuPage = new NavigationMenu(driver);
	        navigationMenuPage.clickOnSubMenu("Connectors");
	        connectorhp = new ConnectorsHomepage(driver);
	        Assert.assertEquals(connectorhp.getConnectorsTitle(), "Predefined Connectors");
	        connectorhp.AddaccountforConnectors(ApplicationName);
	        accountPage = new AccountPage(driver);
	    }
	    
	    
	    @Test(groups = "sanity", description = "Add Account of Cloud Container", priority = 4)
	    public void AddAccountOfCloudContainer() throws Exception 
	    {
	    	accountPage.enteringAccountName(AccountName);
	    	accountPage.enteringServerURL("https://devrealm2.cc.aw-us.webmethodscloud-dev.com");
	    	accountPage.EnteringCCUserName("wmioicqa");
	    	accountPage.enteringPassword("SAGmanage@12345678");
	    	Thread.sleep(5000);
	        connectorhp = accountPage.ClickingAddbutton();
	          //Assert.assertTrue(connectorhp.VerifyAccountpresent(ApplicationName));
	        connectorhp.getSuccesMessage();
	    }
	    
	    @Test(groups = "sanity", description = "Ensure no flow services created By default", priority = 5)
	    public void verifyNoFlowServicesByDefault() throws Exception 
	    {

	        navigationMenuPage = new NavigationMenu(driver);
	        navigationMenuPage.clickOnSubMenu("Integrations");
	        navigationMenuPage.clickOnTreeSubMenu("Flow services");
	        flowServicePage = new FlowServicePage(driver);
	        flowServicePage.VerifynoFlowServiceCreatedMessage();

	    }

	    @Test(groups = "sanity", description = "create flow service", priority = 6)
	    public void createFlowService() throws Exception {

	        flowServicePage = new FlowServicePage(driver);
	        flowServiceCanvasPage = flowServicePage.clickOnAddFreshFlowServiceButton();
	        flowServiceCanvasPage.closeFlowServiceInfoDialogIfExists();
	        Assert.assertEquals(flowServiceCanvasPage.getflowServiceSubTitle(), "Start creating the Flow service");

	    }
	    
	    @Test(groups = "sanity", description = "Configure SalesForceCRM connector in flowservice", priority = 7)
	    public void CreateFlowserviceWithWorkSpanConnector() throws Exception 
	    {
	    	flowServiceCanvasPage.enterFlowServiceTitle(flowServiceName);
			flowServiceCanvasPage.enterFlowSeviceDescription("TestFlowService Description here");
			flowServiceCanvasPage.enterFlowFirstStepAndSelect(ApplicationName,"APPS");
			boolean status = flowServiceCanvasPage.isSelectOperationDropDownVisible(0);
			AssertionHelper.verifyTestStatus(status);

	    }
	    
		@Test(groups = "sanity", description = "Navigate to Add custom operation page", priority = 8)
		public void NavigateToCustomOperationPage() throws Exception 
		{
			customActionAccountPage = flowServiceCanvasPage.navigateToCustomOperation();
		}

		@Test(groups = "sanity", description = "Add custom Action Account details...", priority = 9)
		public void addCustomOperationAccountDetails() throws Exception 
		{
			customActionAccountPage.selectAccount1(AccountName);
			customActionAccountPage.enterCustomOperationName(customOperationName);
			customActionAccountPage.enterCustomOperationDescription("Cloud container operation");
			customActionOperationPage = customActionAccountPage.clickNextButton();
//			Assert.assertEquals(customActionOperationPage.getcustomOperationStepTitle(), "Select the Operation");
		}


	    @Test(groups = "sanity", description = "Add custom Action Operation details...", priority = 10)
		public void CustomActionOperationDetails() throws Exception 
	    {
			customActionOperationPage.clickOnOperationName("Execute");
			customActionConfirmationPage = customActionOperationPage.clickNextButton();
//			Assert.assertEquals(customActionConfirmationPage.getconfirmActionTitle(), "Confirm Action");

		}
	    
	    @Test(groups = "sanity", description = "Select Bussiness Object...", priority = 11)
		public void selectBussinessObject() throws Exception 
	    {
			customActionOperationPage.selectBussinessObject();
			customActionConfirmationPage = customActionOperationPage.clickNextButton();
//			Assert.assertEquals(customActionConfirmationPage.getconfirmActionTitle(), "Confirm Action");

		}
	    
	    @Test(groups = "sanity", description = "Select Data Fields...", priority = 12)
	  		public void selectDataFields() throws Exception 
	  	    {
//	    	customActionOperationPage = new CustomActionOperationPage(driver);
	    		customActionOperationPage.selectDataFields();
	  			customActionConfirmationPage = customActionOperationPage.clickNextButton();
//	  			Assert.assertEquals(customActionConfirmationPage.getconfirmActionTitle(), "Confirm Action");

	  		}

	    @Test(priority = 13, groups = "sanity", description = "verify custom Action conformation details(Operation Name)")
		public void verifyConfirmActionPageDetails() throws Exception 
	    {
			customActionConfirmationPage.verifycustomOperationName(customOperationName);
			customActionConfirmationPage.verifycustomOperationDescription("Cloud container operation");
			customActionConfirmationPage.verifycustomOperationAccount(AccountName);
			customActionConfirmationPage.verifycustomOperationService(ApplicationName);
			customActionConfirmationPage.verifyOperationName("execute");
			customActionConfirmationPage.clickOnDoneButton();
		}
	    
	    @Test(priority = 14, groups = "sanity", description = "map the input parameters.....")
		public void mapInputParameter() throws Exception 
		{
			editMappingPage = flowServiceCanvasPage.clickOnEditMappingIcon();
			editMappingPage.expandParentNodeWithName("myinput");
			editMappingPage.doubleClickOnChildParamName("a");
			editMappingPage.setInputValue("a", "100");
			editMappingPage.clickOnSave();
			editMappingPage = new EditMappingPage(driver);
			editMappingPage.doubleClickOnChildParamName("b");
			editMappingPage.setInputValue("b", "200");
			editMappingPage.clickOnSave();
			editMappingPage = new EditMappingPage(driver);
			Assert.assertTrue(editMappingPage.verifyValueSetForParameters("a"));
			Assert.assertTrue(editMappingPage.verifyValueSetForParameters("b"));
	   }
	    
		@Test( priority = 15, groups = "sanity", description = "run the flow service and verify the success message.....")
		public void runFlowServiceRunSuccessMessage() throws Exception 
		{
			
			flowServiceCanvasPage = new FlowServiceCanvasPage(driver);
			flowServiceCanvasPage.clickOnRunButton();
			Assert.assertTrue(flowServiceCanvasPage.isRunSuccessMessageDisplayed());
			Assert.assertTrue(flowServiceCanvasPage.verifyDirectResultValue("value", "300"));
		}
		
//		@Test( priority = 16, groups = "sanity", description = "Publish project with cloud container connector")
//		public void publishProject() throws Exception 
//		{
//			flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
//			NavigationMenu navigationMenu = new NavigationMenu(driver);
//			navigationMenu.clickOnHomePage();
//			homePage = new HomePage(driver);
//			
//	        publishProjectpg = homePage.clickingpublishprojectOption(projectName);
//	        publishProjectpg.AssetTobeselect("FlowServices");
//	        publishProjectpg.ClickingNextbutton();
//	        Assert.assertTrue(publishProjectpg.verifyConfirmdepencies());
//	        // Assert.assertEquals(publishProjectpg.verifyRestApi(connectorName),connectorName);
//	        publishProjectpg.ClickingNextbutton();
//	        Assert.assertTrue(publishProjectpg.verifypublicSettingTitle());
//	        publishProjectpg.EnteringName("CloudContainer publoish/Deploy Test");
//	        publishProjectpg.selectingEnviroment(ObjectReader.reader.GetdeployURL());
//	        Thread.sleep(2000);
//	        publishProjectpg.ClickingPublishtbutton();
//	        Assert.assertEquals(publishProjectpg.getSuccesMessage(), "Project Published Successfully");
//		}
//		
//		@Test( priority = 17, groups = "sanity", description = "deploy project with cloud container connector")
//		public void deployProject() throws Exception 
//		{
//		
//			  Set<String> handler = driver.getWindowHandles();
//		        Iterator<String> it = handler.iterator();
//		        String parentwindowid = it.next();
//		        String childwindowid = it.next();
//		        driver.switchTo().window(childwindowid);
//		        loginPage = new LoginPage(driver);
//		        loginPage.Enterthrow2nduserurl();
//		        
//		        homePage = new HomePage(driver);
//		        homePage.openProject(projectName);
//		        Deploypage deplypg = new Deploypage(driver);
//		        deplypg.Renametheproject(projectName);
//		        deployconfigurationpage = deplypg.clickSaveAndcontinuebutton();
//		        deployconfigurationpage.ClickingNextbutton();
//		        Assert.assertTrue(deployconfigurationpage.verifyConfiguretriggertabTitle());
//		        deployconfigurationpage.ClickingNextbutton();
//		        Assert.assertTrue(deployconfigurationpage.verifyConfigureparameterstabTitle());
//		        deployconfigurationpage.clickingDeploybutton();
//		        Assert.assertEquals(deployconfigurationpage.getSuccesMessage(), "Project deployed successfully");
//
//			
//		}
		
		// deleting first flowservice
		@Test(priority = 16, groups = "sanity", description = "Delete the Flow service.....")
		public void deleteFlowService() throws Exception 
		{
			flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
			flowServicePage = new FlowServicePage(driver);
			flowServicePage.deleteFlowService(flowServiceName);
			flowServicePage = new FlowServicePage(driver);
			//flowServicePage.VerifynoFlowServiceCreatedMessage();
		}
		
		@Test(groups = "sanity",priority = 18, description = "verify Execution Of Existing CloudContainer Connector")
		public void verifyExecutionOfExistingCloudContainerConnector() throws Exception 
		{

			NavigationMenu navigationMenu = new NavigationMenu(driver);
			navigationMenu.clickOnHomePage();
			homePage = new HomePage(driver);
			homePage.openProject("IC_Assets");
			NavigationMenu navigationMenu1 = new NavigationMenu(driver);
			navigationMenu1.clickOnTreeSubMenu("Flow services");
			 flowServicePage = new FlowServicePage(driver);
			 flowServiceCanvasPage =  flowServicePage.clickFlowServiceName("CloudContainer");
			 flowServiceCanvasPage.clickOnRunButton();
		
				Assert.assertTrue(flowServiceCanvasPage.isRunSuccessMessageDisplayed());
				Assert.assertTrue(flowServiceCanvasPage.verifyDirectResultValue("value", "300"));
			 
//			homePage.deleteProject(projectName);
		}



		@Test( priority = 19, groups = "sanity", description = "Validate manage environment")
		public void manageEnvironment() throws Exception 
		{
			flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
			NavigationMenu navigationMenu = new NavigationMenu(driver);
			navigationMenu.clickOnAppSwitcherMenu();
			apps apps1 = new apps(driver);
			apps1.verifyApps("webMethods.io Integration", 7);
			apps1.goToMycloud("Software AG Cloud", 0);
			MycloudPage mycloud = new MycloudPage(driver);
			mycloud.verifySagcloudImage();
			Thread.sleep(1000);
			mycloud.verifySubscribedProducts("webMethods.io Integration");
			
		}
}
