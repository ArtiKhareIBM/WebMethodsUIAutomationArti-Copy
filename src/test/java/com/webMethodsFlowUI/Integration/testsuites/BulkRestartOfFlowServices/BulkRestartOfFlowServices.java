package com.webMethodsFlowUI.Integration.testsuites.BulkRestartOfFlowServices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.assertion.AssertionHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.RESTConnector.AddAccountPage;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.flowService.EditMappingPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceCanvasPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceOverViewDatepage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServicePage;
import com.webMethodsUI.flow.pageObjects.monitor.MonitorPageFilter;
import com.webMethodsUI.flow.pageObjects.monitor.RestartFlowServices;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class BulkRestartOfFlowServices extends TestBase 
{
    LoginPage loginPage;
    HomePage homePage;
    WorkflowsPage workflowPage;
    NavigationMenu navigationMenuPage;
    FlowServicePage flowServicePage;
	FlowServiceCanvasPage flowServiceCanvasPage;
	EditMappingPage editMappingPage;
	AddAccountPage addAccountPage;
	FlowServiceOverViewDatepage overView;
	MonitorPageFilter monitorPageFilter;
    boolean status;
    

	String projectName = "ICUI_AutomationProjectBRS";	
	
	String flowServiceName1 = "GetCurrentDate";
	String flowServiceName2 = "Devrest";
	
	@Test( priority = 1, groups = "sanity", description = "ensure login workd fine")
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	} 

	@Test( priority = 2, groups = "sanity", description = "create project ")
	public void createProject() throws Exception 
	{
		workflowPage = homePage.createProject(projectName);
		//homePage.searchProject(projectName);
	}
	
	@Test( priority = 3, groups = "sanity", description = "Ensure no flow services created By default")
	public void createFlowService() throws Exception 
	{
		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnTreeSubMenu("Flow services");
		flowServicePage = new FlowServicePage(driver);
//		flowServicePage.VerifynoFlowServiceCreatedMessage();
		flowServiceCanvasPage = flowServicePage.clickOnAddFreshFlowServiceButton();
		flowServiceCanvasPage.closeFlowServiceInfoDialogIfExists();
		Assert.assertEquals(flowServiceCanvasPage.getflowServiceSubTitle(), "Start creating the Flow service");
		flowServiceCanvasPage.enterFlowServiceTitle(flowServiceName1);
		flowServiceCanvasPage.enterFlowSeviceDescription("TestFlowService Description here");
		flowServiceCanvasPage.enterFlowFirstStepAndSelect("Date","SERVICES");
		boolean status = flowServiceCanvasPage.isSelectOperationDropDownVisible(0);
		AssertionHelper.verifyTestStatus(status);
		flowServiceCanvasPage.selectOperation("getCurrentDate",0);
		flowServiceCanvasPage.clickAddNewStep();
		flowServiceCanvasPage = new FlowServiceCanvasPage(driver);
		flowServiceCanvasPage.enterFlowFirstStepAndSelect("Flow","SERVICES");
		flowServiceCanvasPage.selectOperation("logCustomMessage",1);
		editMappingPage = flowServiceCanvasPage.clickOnEditMappingIconWithIndex(1);
		 editMappingPage.clickInputField(0, "date");

	     editMappingPage.clickInputField(1, "message");

	     editMappingPage.clickMapLink();
	     
	     flowServiceCanvasPage = new FlowServiceCanvasPage(driver);
		 flowServiceCanvasPage.SaveFlowService();
		
	}
	
	@Test( priority = 4, groups = "sanity", description = "import Rest Connector flow service")
	public void importRestConnector() throws Exception 
	{
		flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
		flowServicePage = flowServicePage.ImportFlowServiceWithoutOperation("RC_GetUser", "\\src\\main\\resources\\importfiles\\RC_GetUser.zip");
		flowServicePage.ImportSuccessMessage("RC_GetUser");
		flowServiceCanvasPage = flowServicePage.clickFlowServiceName("RC_GetUser");
		flowServiceCanvasPage.accountConfigurationNotFound(0);
		flowServiceCanvasPage.hoverOnFlowStep("users");
		flowServiceCanvasPage.clickingAccounttabForManualcreation();
		addAccountPage = new AddAccountPage(driver);
		addAccountPage.clickOnAddButton();
		flowServiceCanvasPage.updateFlowService();

	}
	
	@Test( priority = 5, groups = "sanity", description = "import Soap Connector flow service")
	public void importSoapConnector() throws Exception 
	{
		flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
		flowServicePage = new FlowServicePage(driver);
		flowServicePage = flowServicePage.ImportFlowServiceWithoutOperation("Multiport_WSDL", "\\src\\main\\resources\\importfiles\\Multiport_WSDL.zip");
		flowServicePage.ImportSuccessMessage("Multiport_WSDL");
		flowServiceCanvasPage = flowServicePage.clickFlowServiceName("Multiport_WSDL");
		flowServiceCanvasPage.accountConfigurationNotFound(0);
		flowServiceCanvasPage.hoverOnFlowStep("Customer_wsdl_multiport");
		flowServiceCanvasPage.clickingAccounttabForManualcreation();
		addAccountPage = new AddAccountPage(driver);
		addAccountPage.selectPortType("VS_IncidentCOB1https");
		addAccountPage.clickOnAddButton();
		flowServiceCanvasPage.updateFlowService();

	}
	
	@Test( priority = 6, groups = "sanity", description = "Enable Restart")
	public void enablRestart() throws Exception 
	{
		flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
		overView = flowServicePage.gointoOverviewPage("Multiport_WSDL");
		overView.enableRestart();
		overView.closethescreen();
		
		flowServicePage = new FlowServicePage(driver);
		overView = flowServicePage.gointoOverviewPage("RC_GetUser");
		overView.enableRestart();
		overView.closethescreen();
		
		flowServicePage = new FlowServicePage(driver);
		overView = flowServicePage.gointoOverviewPage(flowServiceName1);
		overView.enableRestart();
		overView.closethescreen();

	}
	
	@Test( priority = 7, groups = "sanity", description = "Enable Restart")
	public void runTheFlowServices() throws Exception 
	{
		flowServicePage = new FlowServicePage(driver);
		flowServiceCanvasPage = flowServicePage.clickFlowServiceName(flowServiceName1);
		flowServiceCanvasPage.clickOnRunButton();
		Assert.assertTrue(flowServiceCanvasPage.isRunSuccessMessageDisplayed());
		Assert.assertTrue(flowServiceCanvasPage.verifyDirectResultValue("date", ":"));
		
		flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
		flowServicePage = new FlowServicePage(driver);
		flowServiceCanvasPage = flowServicePage.clickFlowServiceName("RC_GetUser");
		flowServiceCanvasPage.clickOnRunButton();
		Assert.assertTrue(flowServiceCanvasPage.isRunSuccessMessageDisplayed());
		Assert.assertTrue(flowServiceCanvasPage.verifyDirectResultValue("status", "200"));
		Assert.assertTrue(flowServiceCanvasPage.verifyDirectResultValue("statusMessage", "OK"));
		
		flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
		flowServicePage = new FlowServicePage(driver);
		flowServiceCanvasPage = flowServicePage.clickFlowServiceName("Multiport_WSDL");
		flowServiceCanvasPage.clickOnRunButton();
		Assert.assertTrue(flowServiceCanvasPage.isFailureMessageDisplayed());
		Assert.assertTrue(flowServiceCanvasPage.verifyfailureMessage("bad_certificate"));
		

	}
	
	@Test( priority = 8, groups = "sanity", description = "Enable Restart")
	public void validateMonitoring() throws Exception 
	{
		flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnMainMenu("Monitor");
		navigationMenuPage.clickOnTreeMainTab("Flow service execution");
		 navigationMenuPage.clickOnTreeMainMenu("Filters");
		 monitorPageFilter = new MonitorPageFilter(driver);
		 monitorPageFilter.clickOnMonitorFilter("Select projects");
		 monitorPageFilter.SelectProject(projectName);
		 monitorPageFilter.clickApplyButton();
		 RestartFlowServices restartflowservice = new RestartFlowServices(driver);
		 restartflowservice.verifyCheckBoxIsVisibleToRestart("Multiport_WSDL");
		 restartflowservice.verifyCheckBoxIsVisibleToRestart("RC_GetUser");
		 restartflowservice.verifyCheckBoxIsVisibleToRestart(flowServiceName1);
		 
		 restartflowservice.SelectBatchFlowServices(flowServiceName1, 1, "item");
		 restartflowservice.SelectBatchFlowServices("RC_GetUser", 2, "items");
		 restartflowservice.SelectBatchFlowServices("Multiport_WSDL", 3, "items");
		 restartflowservice.submitBulkFlowservicesToRestart();
		 restartflowservice.clickOK();
		 restartflowservice.verifyRestartSubmittedMessage("Your request is submitted.");
		 restartflowservice.verifyRestartProccessedMessage("Your request to resubmit bulk executions has been processed successfully. Kindly refresh to get the latest executions summary.");
		 Thread.sleep(2000);
	}	
	
	@Test( priority = 9, groups = "sanity", description = "Delete Flow and project")
	public void deleteFlowAndProject() throws Exception 
	{
		 navigationMenuPage.clickOnHomePage();
		 homePage.searchProject(projectName);
		 navigationMenuPage.clickOnTreeSubMenu("Flow services");
		 flowServicePage = new FlowServicePage(driver);
		 flowServicePage.deleteFlowService("Multiport_WSDL");
		 flowServicePage = new FlowServicePage(driver);
		 flowServicePage.deleteFlowService(flowServiceName1);
		 flowServicePage = new FlowServicePage(driver);
		 flowServicePage.deleteFlowService("RC_GetUser");	     
	}
}
