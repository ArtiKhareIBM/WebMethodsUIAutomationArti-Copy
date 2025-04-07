package com.webMethodsFlowUI.testsuites.PRBvt;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.assertion.AssertionHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.flowService.EditMappingPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceCanvasPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServicePage;
import com.webMethodsUI.flow.pageObjects.flowService.SetValuePage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class PrBvtTestSuite extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	NavigationMenu navigationMenuPage;
	WorkflowsPage workflowPage;
	FlowServicePage flowServicePage;
	FlowServiceCanvasPage flowServiceCanvasPage;
	EditMappingPage editMappingPage;
	SetValuePage setValuePage;
	
	String projectName ="PRBVT_IC";
	String flowServiceName = "SampleFlow";
	String serviceType = "Math";
	String serviceName = "addInts";
	
	@Test(groups = "sanity", description = "ensure login worked fine", priority = 1)
	public void loginTest() throws Exception 
	{
		getApplicationUrl(ObjectReader.reader.getURL());
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
	}
	@Test(groups = "sanity", description = "create project ", priority = 2)
	public void createProject() throws Exception 
	{
		workflowPage = homePage.createProject(projectName);
		
	}
	@Test(groups = "sanity", description = "create flow service with add ints Success Result", priority = 3)
	public void createFlowServicewithAddIntsService() throws Exception {

		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnTreeSubMenu("Flow services");
		flowServicePage = new FlowServicePage(driver);
		
		flowServiceCanvasPage = flowServicePage.clickOnAddFreshFlowServiceButton();
		flowServiceCanvasPage.closeFlowServiceInfoDialogIfExists();
		Assert.assertEquals(flowServiceCanvasPage.getflowServiceSubTitle(), "Start creating the Flow service");

		flowServiceCanvasPage.enterFlowServiceTitle(flowServiceName);
		flowServiceCanvasPage.enterFlowSeviceDescription("TestFlowService Description here");
		flowServiceCanvasPage.enterFlowFirstStepAndSelect(serviceType,"SERVICES");
		boolean status = flowServiceCanvasPage.isSelectOperationDropDownVisible(0);
		AssertionHelper.verifyTestStatus(status);
		flowServiceCanvasPage.selectService(serviceName);
	}

	@Test(groups = "sanity", description = "map the inputs for flow service....", priority = 4)
	public void editMappingForFlowService() throws Exception {

		flowServiceCanvasPage = new FlowServiceCanvasPage(driver);
		editMappingPage = flowServiceCanvasPage.clickOnEditMappingIcon();

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

	}
	@Test(groups = "sanity", description = "Delete the Flow service.....", priority = 5)
	public void deleteFlowService1() throws Exception 
	{
		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnMainMenu("Projects");
		homePage = new HomePage(driver);
		homePage.searchProject(projectName);
		navigationMenuPage.clickOnSubMenu("Integrations");
		navigationMenuPage.clickOnTreeSubMenu("Flow services");
		flowServicePage.deleteFlowService(flowServiceName);
		flowServicePage = new FlowServicePage(driver);
		//flowServicePage.VerifynoFlowServiceCreatedMessage();

   }
   @Test(groups = "sanity", description = "Delete the project.....", priority = 6)
	public void deleteProject() throws Exception 
	{
		   navigationMenuPage.clickOnHomePage();
	       homePage = new HomePage(driver);
	       homePage.deleteProject(projectName);
	}
	

}
