package com.webMethodsFlowUI.PartnerCertficate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webMethodsUI.flow.helper.assertion.AssertionHelper;
import com.webMethodsUI.flow.helper.assertion.VerificationHelper;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.helper.generic.GenericHelper;
import com.webMethodsUI.flow.helper.javaScript.JavaScriptHelper;
import com.webMethodsUI.flow.pageObjects.Certificates.CertificatesHomepage;
import com.webMethodsUI.flow.pageObjects.Certificates.KeyStorepage;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.AddAccountPage;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.AvailablePredefinedOperationPage;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.DefineSoapConnector;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.InputSignaturePage;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.OperationList;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.OutputSignaturePage;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.SOAPConnectorHomePage;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.SoapConnectorLetsGetStartPage;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.TestOperationInputPage;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.TestOperationResultPage;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.flowService.DefineInputFieldsPage;
import com.webMethodsUI.flow.pageObjects.flowService.DefineOutputFieldsPage;
import com.webMethodsUI.flow.pageObjects.flowService.EditMappingPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServiceCanvasPage;
import com.webMethodsUI.flow.pageObjects.flowService.FlowServicePage;
import com.webMethodsUI.flow.pageObjects.flowService.InputValuePage;
import com.webMethodsUI.flow.pageObjects.flowService.SetValuePage;
import com.webMethodsUI.flow.pageObjects.monitor.FlowServiceExecutionDataValidation;
import com.webMethodsUI.flow.pageObjects.monitor.FlowServiceExecutionpage;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.soapapi.APIDetailsPage;
import com.webMethodsUI.flow.pageObjects.soapapi.SoapApiBasicInfoPage;
import com.webMethodsUI.flow.pageObjects.soapapi.SoapApiHomePage;
import com.webMethodsUI.flow.pageObjects.soapapi.SoapApiLetsGetStartedPage;
import com.webMethodsUI.flow.pageObjects.soapapi.SoapApiOperationsPage;
import com.webMethodsUI.flow.pageObjects.workflows.EditworkflowName;
import com.webMethodsUI.flow.pageObjects.workflows.SoapConnectorWorkActionpage;
import com.webMethodsUI.flow.pageObjects.workflows.StartBuildingyourWorkflowpage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowCanvaspage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

public class PartnerCertficateSoapConnector extends TestBase {
	HomePage homePage;
    WorkflowsPage workflowPage;
    FlowServiceCanvasPage flowServiceCanvasPage;
    EditMappingPage editMappingPage;
    NavigationMenu navigationMenuPage;
    VerificationHelper verificationHelper;

    SetValuePage setValuePage;
    FlowServicePage flowServicePage;
    DefineInputFieldsPage defineInputFieldsPage;
    DefineOutputFieldsPage defineOutputFieldsPage;

    SoapApiHomePage soapApiHomePage;
    APIDetailsPage apiDetailsPage;
    SOAPConnectorHomePage soapConnectorHomePage;
    SoapConnectorLetsGetStartPage soapConnectorLetsGetStartPage;
    AvailablePredefinedOperationPage availablePredefinedOperationPage;
    InputSignaturePage inputSignaturePage;
    OutputSignaturePage outputSignaturePage;
    TestOperationInputPage testOperationInputPage;
    TestOperationResultPage testOperationResultPage;
    JavaScriptHelper javaScriptHelper;
    SOAPConnectorHomePage soapconnectorHomePage;
    SoapApiLetsGetStartedPage soapApiLetsGetStartedPage;
    SoapApiBasicInfoPage soapApiBasicInfoPage;
    SoapApiOperationsPage soapApiOperationsPage;
    StartBuildingyourWorkflowpage startBuildingyourWorkflowpage;
    WorkflowCanvaspage workflowcanvaspg;
    KeyStorepage key;
    AddAccountPage add;
    SoapConnectorWorkActionpage soapConnectorWorkActionpage;
    
    
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd");
    SimpleDateFormat sdf1 = new SimpleDateFormat("MMM");
    String Todadate = sdf.format(date);
    String currentMonth = sdf1.format(date);
    
    
    String CertficateNAME = "Connectorpage"+Todadate+currentMonth;
    String CertficateNAME1 = "flowpage"+Todadate+currentMonth;
    String CertficateNAME2 = "Workflowpage"+Todadate+currentMonth;
    CertificatesHomepage cert;
    EditworkflowName editworkflowName;
    String soapworkflowname = "PartnerCert";
    FlowServiceExecutionDataValidation flowServiceExecutionDataValidation;

    LoginPage loginPage;
    
	String projectName = "ICUI_AutomationProjectCert";
	String URL = "http://1.1.1.1/xml/SOAP_server/ndfdXMLserver.php";
	
    String SoapConnectorName = "PartnerCertficateConnector";
    String description = "Description";
    String path = "\\\\\\\\src\\\\\\\\main\\\\\\\\resources\\\\\\\\importfiles\\\\\\\\cldp.crt";
    String path1 = "\\\\\\\\src\\\\\\\\main\\\\\\\\resources\\\\\\\\importfiles\\\\\\\\metering.crt";
    String path2 = "\\\\\\\\src\\\\\\\\main\\\\\\\\resources\\\\\\\\importfiles\\\\\\\\vna (2).crt";
    String ApplicationName = "PartnerCertficateConnector";
    String flowServiceName = "Partnercertflow";
    String accountName = SoapConnectorName + "_1";
    
    

    @Test(groups = "sanity1", description = "ensure login workd fine", priority = 1)
    public void loginTest() throws Exception {

        getApplicationUrl(ObjectReader.reader.getURL());
        loginPage = new LoginPage(driver);

        // login to application homePage =
        homePage = loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
    }

    // create project

    @Test(groups = "sanity", description = "create project ", priority = 2)
    public void createProject() throws Exception {

        workflowPage = homePage.createProject(projectName);
//		Assert.assertEquals(workflowPage.getWorkFlowMessage(), "No Workflows created yet!");

   }

    @Test(groups = "sanity", description = "Add a soap connector.", priority = 3)
    public void VerifyingThePartnerCertficateLabel() throws Exception{

        NavigationMenu navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Connectors");

        navigationMenuPage.clickOnLeftPanalMainMenu("SOAP");

        SOAPConnectorHomePage soapConnectorHomePage = new SOAPConnectorHomePage(driver);
        driver.navigate().refresh();
        SOAPConnectorHomePage soapConnectorHomePage1 = new SOAPConnectorHomePage(driver);
        Assert.assertTrue(soapConnectorHomePage1.verifyAddConnectorButton());

        GenericHelper genericHelperPage = new GenericHelper(driver);
        genericHelperPage.clickButton("Add Connector");


        SoapConnectorLetsGetStartPage startSoapConnectorPage = new SoapConnectorLetsGetStartPage(driver);

        startSoapConnectorPage.enterImportURL("https://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php?wsdl");
        Assert.assertEquals(startSoapConnectorPage.getNewSoapConnectorTitle(), "New SOAP Connector");
        GenericHelper genericHelperPage1 = new GenericHelper(driver);
        genericHelperPage1.clickButton("Next");



        DefineSoapConnector defineSoapConnector = new DefineSoapConnector(driver);
        defineSoapConnector.enterSOAPConnectorName(SoapConnectorName);
        defineSoapConnector.enterSOAPConnectorDescription(description);
        defineSoapConnector.enterUsername(ObjectReader.reader.getUserName());
        defineSoapConnector.enterPassword(ObjectReader.reader.getPassword());
        defineSoapConnector.clicksavebutton();
        //adding acccount
        OperationList operationList1 = new OperationList(driver);
        operationList1.clickSoapConnectorLink();

        //WebDriverWait wait = new WebDriverWait(driver, 60);
        soapConnectorHomePage.clickOnAddAccount1(SoapConnectorName);
		AddAccountPage addAccountPage = new AddAccountPage(driver);
		addAccountPage = new AddAccountPage(driver);
		Assert.assertEquals(addAccountPage.getModelTitle(), "Add Account");
		addAccountPage.selectPortType("ndfdXMLPort");
        addAccountPage.enteringURL(URL);
		Assert.assertEquals(addAccountPage.verifythepartnercertficatelabel(), "WS Security Partner Certificate Alias");
		//addAccountPage.clickOnCancelButton();
		addAccountPage.clickOnAddButton();



}

    @Test(groups = "sanity", description = "Verify the field 'Partner Certificate Alias' are getting listed or not for the new soap account creation of the existing soap connector.", priority = 4)
    public void VerifyingThePartnerCertficateLabelNewAccountExistingConnector() throws Exception{
    	SOAPConnectorHomePage soapConnectorHomePage2 = new SOAPConnectorHomePage(driver);
    	soapConnectorHomePage2.clickOnAddAccount1(SoapConnectorName);
		AddAccountPage addAccountPage = new AddAccountPage(driver);
		addAccountPage = new AddAccountPage(driver);
		Assert.assertEquals(addAccountPage.getModelTitle(), "Add Account");
		addAccountPage.selectPortType("ndfdXMLPort");
        addAccountPage.enteringURL(URL);
		Assert.assertEquals(addAccountPage.verifythepartnercertficatelabel(), "WS Security Partner Certificate Alias");
		addAccountPage.clickOnCertficatePlusbutton();
		addAccountPage.certficateName(CertficateNAME);
		key = new KeyStorepage(driver);
		key.uploadTrustorefilecommon(path);
		cert = new CertificatesHomepage(driver);
        cert.ClickingOnSaveButton();
		addAccountPage.clickOnAddButton();
    }

    
    @Test(groups = "sanity", description = "Verify the partner certificate creation from the account page which opened from the connector page and. verify that getting listed or not in the certificate page.", priority = 5)
    public void VerifyCertificateConfigurationPage() throws Exception{
    	navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Configurations");
		cert = new CertificatesHomepage(driver);
		cert.verifycreatedcertficate(CertficateNAME);   	
    }
    
    @Test(groups = "sanity", description = "Verify the field 'Partner Certificate Alias ' are getting listed or not while editing the existing soap account", priority = 6)
    public void CreatingCertificateFromConnectorpage() throws Exception{
    	NavigationMenu navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Connectors");
        navigationMenuPage.clickOnLeftPanalMainMenu("SOAP");
        Thread.sleep(2000);
        SOAPConnectorHomePage soapConnectorHomePage1 = new SOAPConnectorHomePage(driver);
        soapConnectorHomePage1.clickOnapplicontiondetailicon(SoapConnectorName);
    	soapConnectorHomePage1.EditAccount(accountName);
    	   	
    	//soapConnectorHomePage.clickOnAddAccount1(SoapConnectorName);
		AddAccountPage addAccountPage = new AddAccountPage(driver);
		addAccountPage = new AddAccountPage(driver);
		Assert.assertEquals(addAccountPage.getModelTitle(), "Edit Account");	
		addAccountPage.selectPortType("ndfdXMLPort");
        addAccountPage.enteringURL(URL);
		Assert.assertEquals(addAccountPage.verifythepartnercertficatelabel(), "WS Security Partner Certificate Alias");
//		addAccountPage.clickOnCertficatePlusbutton();
//		addAccountPage.certficateName(CertficateNAME);
//		key = new KeyStorepage(driver);
//		key.uploadTrustorefilecommon(path);
//		cert = new CertificatesHomepage(driver);
        //cert.ClickingOnSaveButton();
        //Thread.sleep(1000);
		cert.ClickingOnCancelButton();
    }
    
    @Test(groups = "sanity", description = "Update the certificate from the certificate page and soap connector operation execution which using partner certificate.", priority = 7)
    public void UpdateCertificateConfigurationPage() throws Exception{
    	navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Configurations");
		cert = new CertificatesHomepage(driver);
		cert.verifycreatedcertficate(CertficateNAME);
		cert.EditCertificate(CertficateNAME);
		key = new KeyStorepage(driver);
		key.uploadTrustorefilecommon(path1);
		cert = new CertificatesHomepage(driver);
        cert.ClickingOnUpdateButton();
    }
    
    @Test(groups = "sanity", description = "Verify the soap connector operation execution which using partner certificate.", priority = 8)
    public void ExecuteConnectorWithPartnerCertificate() throws Exception{
    	NavigationMenu navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Connectors");
        navigationMenuPage.clickOnLeftPanalMainMenu("SOAP");
        soapConnectorHomePage = new SOAPConnectorHomePage(driver);
		
		soapConnectorHomePage.clickOnOperationButton(SoapConnectorName);
		AvailablePredefinedOperationPage availablePredefinedOperationPage = new AvailablePredefinedOperationPage(driver);
		Assert.assertTrue(availablePredefinedOperationPage.verifyShowSignatureElement());

        availablePredefinedOperationPage.clickOnTestOperationButton1(1);
        TestOperationInputPage testOperationInputPage = new TestOperationInputPage(driver);
        testOperationInputPage.selectAccount(accountName);
        testOperationInputPage.clickOnRunButton();
//        testOperationInputPage.VerifyFailureTestoperation();
        //Assert.assertTrue(testOperationInputPage.VerifySuccestestoperation());
        testOperationInputPage.clickOnBackButton();
        testOperationInputPage.clickOnCancelButton();
        driver.navigate().refresh();        
    }
    
//
    @Test(groups = "sanity", description = "Verify the partner certificate creation from the account page which opened from the flow service page and verify that getting listed or not in the certificate page", priority = 9)
    public void CreatingCertificateFromflowpage() throws Exception{

    	navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Integrations");
        navigationMenuPage.clickOnTreeSubMenu("Flow services");
        flowServicePage = new FlowServicePage(driver);
        flowServiceCanvasPage = flowServicePage.clickOnAddFreshFlowServiceButton();
        flowServiceCanvasPage.closeFlowServiceInfoDialogIfExists();
        Assert.assertEquals(flowServiceCanvasPage.getflowServiceSubTitle(), "Start creating the Flow service");
        flowServiceCanvasPage.enterFlowServiceTitle(flowServiceName);
        flowServiceCanvasPage.enterFlowSeviceDescription("TestFlowService Description here");
        flowServiceCanvasPage.enterFlowFirstStepAndSelect(ApplicationName,"APPS");
        //flowServiceCanvasPage.EnterConnectorNameWithversion(ApplicationName,"1");
        boolean status = flowServiceCanvasPage.isSelectOperationDropDownVisible(0);
        AssertionHelper.verifyTestStatus(status);
        flowServiceCanvasPage.selectOperationFromDropDown("ndfdXMLPortType_CornerPoints",0);
        //flowServiceCanvasPage.selectAccount("Configure Accounts");
        flowServiceCanvasPage.clickingAccounttabForManualcreation();
        AddAccountPage addAccountPage = new AddAccountPage(driver);
        addAccountPage.selectPortType("ndfdXMLPort");
        addAccountPage.enteringURL(URL);
        Assert.assertEquals(addAccountPage.verifythepartnercertficatelabel(), "WS Security Partner Certificate Alias");
		addAccountPage.clickOnCertficatePlusbutton();
		addAccountPage.certficateName(CertficateNAME1);
		key = new KeyStorepage(driver);
		key.uploadTrustorefilecommon(path1);
		cert = new CertificatesHomepage(driver);
		cert.ClickingOnSaveButton();
		//Thread.sleep(1000);
		 //driver.navigate().refresh();
		//AddAccountPage addAccountPage1 = new AddAccountPage(driver);
		//Thread.sleep(1000);
		//Assert.assertEquals(addAccountPage.verifythepartnercertficatelabel(), "WS Security Partner Certificate Alias");
		addAccountPage.clickOnCertficateDropDown();
		addAccountPage.clickOnAddButton();
		Thread.sleep(1000);
		flowServiceCanvasPage.SaveFlowService();
		flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
		navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Configurations");
		cert = new CertificatesHomepage(driver);
		cert.verifycreatedcertficate(CertficateNAME1);
    }
    
    
    @Test(groups = "sanity", description = "Update the certificate from the certificate page and verify the flow service execution having soap connector which using partner certificate.", priority = 10)
    public void UpdateFlowCertificateConfigurationPage() throws Exception{
    	navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Configurations");
		cert = new CertificatesHomepage(driver);
		cert.verifycreatedcertficate(CertficateNAME1);
		cert.EditFlowCertificate(CertficateNAME1);
		key = new KeyStorepage(driver);
		key.uploadTrustorefilecommon(path);
		cert = new CertificatesHomepage(driver);
        cert.ClickingOnUpdateButton();
    }
    
   
    @Test(groups = "sanity", description = "Verify the flow service execution having soap connector which using partner certificate.", priority = 12)
    public void ExecuteFlowService() throws Exception{

        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Integrations");
        navigationMenuPage.clickOnTreeSubMenu("Flow services");
        
        flowServicePage = new FlowServicePage(driver);
		flowServiceCanvasPage = new FlowServiceCanvasPage(driver);
		flowServiceExecutionDataValidation= new FlowServiceExecutionDataValidation(driver);
		flowServiceExecutionDataValidation.clickOnFlowService(flowServiceName);
		flowServiceCanvasPage.clickOnRunButton();
		flowServicePage = flowServiceCanvasPage.clickOnBackArrowLink();
    }
    
    @Test(groups = "sanity", description = "Verify the partner certificate creation from the account page which opened from the workflow   page and configuration page  and verify that getting listed or not in the certificate page", priority = 11)
    public void CreatingCertficateFromWorkflowpage() throws Exception{

    	 navigationMenuPage = new NavigationMenu(driver);
         navigationMenuPage.clickOnSubMenu("Integrations");
         navigationMenuPage.clickOnLeftPanalMainMenu("Workflows");
         workflowPage = new WorkflowsPage(driver);
         startBuildingyourWorkflowpage = workflowPage.Addeorkflowicon();
         startBuildingyourWorkflowpage = new StartBuildingyourWorkflowpage(driver);
         workflowcanvaspg = startBuildingyourWorkflowpage.clickonCreateNewworkflow();
         workflowcanvaspg = new WorkflowCanvaspage(driver);
         driver.navigate().refresh();
         workflowcanvaspg.DragSoapCommonSeviceanddrop(SoapConnectorName, SoapConnectorName);
         workflowcanvaspg.mappingthecontainer(SoapConnectorName);
         workflowcanvaspg.gotoServiceActionpage(SoapConnectorName);
         soapConnectorWorkActionpage = new SoapConnectorWorkActionpage(driver);
         soapConnectorWorkActionpage.SelectAction("ndfdXMLPortType_CornerPoints");
         soapConnectorWorkActionpage.ClickConnectButton();
         //soapConnectorWorkActionpage.selectAccount("ndfdXMLPort");
         //Thread.sleep(2000);
         //soapConnectorWorkActionpage.selectPortType("ndfdXMLPort");
         //Thread.sleep(1000);
         AddAccountPage addAccountPage = new AddAccountPage(driver);
         //Thread.sleep(3000);
         //addAccountPage.selectPortType("ndfdXMLPort");
         addAccountPage.selectPortType("ndfdXMLPort");
         addAccountPage.enteringURL(URL);
         addAccountPage.clickOnCertficatePlusbutton();
         addAccountPage.certficateName(CertficateNAME2);
 		key = new KeyStorepage(driver);
 		key.uploadTrustorefilecommon(path2);
 		cert = new CertificatesHomepage(driver);
 		cert.ClickingOnSaveButton();
 		addAccountPage.clickOnCancelButton();
 		soapConnectorWorkActionpage = new SoapConnectorWorkActionpage(driver);
 		soapConnectorWorkActionpage.clickOnCancelButton();
         workflowcanvaspg = new WorkflowCanvaspage(driver);
        // Assert.assertTrue(workflowcanvaspg.verifyServiceaction());
         editworkflowName = workflowcanvaspg.editworkflowname();
         editworkflowName = new EditworkflowName(driver);
         editworkflowName.EnteringWorkFlowName(soapworkflowname);
         editworkflowName.ClickDonebutton();
         workflowcanvaspg.Savebutton();
         workflowPage = workflowcanvaspg.bacckArrowicon();
         navigationMenuPage = new NavigationMenu(driver);
         navigationMenuPage.clickOnSubMenu("Configurations");
         cert = new CertificatesHomepage(driver);
         cert.verifycreatedcertficate(CertficateNAME2);
    }
    
    
    @Test(groups = "sanity", description = "Update the certificate from the certificate page and verify the workflow execution having soap connector which using partner certificate..", priority = 13)
    public void UpdateWorkFlowCertificateConfigurationPage() throws Exception{
    	navigationMenuPage = new NavigationMenu(driver);
		navigationMenuPage.clickOnSubMenu("Configurations");
		cert = new CertificatesHomepage(driver);
		cert.verifycreatedcertficate(CertficateNAME1);
		cert.EditFlowCertificate(CertficateNAME1);
		key = new KeyStorepage(driver);
		key.uploadTrustorefilecommon(path1);
		cert = new CertificatesHomepage(driver);
        cert.ClickingOnUpdateButton();
    }
    
    
    @Test(groups = "sanity", description = "Verify the partner certificate creation from the account page which opened from the workflow   page and configuration page  and verify that getting listed or not in the certificate page", priority = 14)
    public void UpdateConnectorwsdl() throws Exception{
     	NavigationMenu navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Connectors");
        navigationMenuPage.clickOnLeftPanalMainMenu("SOAP");
        SOAPConnectorHomePage soapConnectorHomePage = new SOAPConnectorHomePage(driver);
        //driver.navigate().refresh();
        //SOAPConnectorHomePage soapConnectorHomePage1 = new SOAPConnectorHomePage(driver);
        soapConnectorHomePage.EditConnector(SoapConnectorName);
        DefineSoapConnector EditSoapConnectorPage = new DefineSoapConnector(driver);
        EditSoapConnectorPage.enterSOAPConnectorDescription("Edited the Application");
        EditSoapConnectorPage.SelectOverrideWSDL();
        EditSoapConnectorPage.enterImportURL("http://www.w3schools.com/xml/tempconvert.asmx?WSDL");
        //DefineSoapConnector defineSoapConnector = new DefineSoapConnector(driver);;
        EditSoapConnectorPage.clicksavebutton();
        EditSoapConnectorPage.clickconfirmsavebutton();
        Assert.assertEquals(EditSoapConnectorPage.getSuccesMessageofImportfile(),"Successfully updated the connector!");
//        soapconnectorHomePage.waittillitappears();
    }
    
    
    @Test(groups = "sanity", description = "Delete all the assets created", priority = 15)
    public void DeleteCreatedAssets() throws Exception{
    	navigationMenuPage = new NavigationMenu(driver);
    	navigationMenuPage.clickOnSubMenu("Integrations");
    	navigationMenuPage.clickOnLeftPanalMainMenu("Workflows");
    	workflowPage.deleteworkFlowService(soapworkflowname);
    	//Assert.assertEquals(workflowPage.getProjectDeleteMessage(),"Workflow deleted successfully.");
    	Thread.sleep(1000);
    	navigationMenuPage.clickOnTreeSubMenu("Flow services");
    	flowServicePage.deleteFlowService(flowServiceName);
    	//flowServicePage.VerifynoFlowServiceCreatedMessage();
    	Thread.sleep(1000);
    	NavigationMenu navigationMenuPage = new NavigationMenu(driver);
    	navigationMenuPage.clickOnSubMenu("Connectors");
    	Thread.sleep(2000);
    	navigationMenuPage.clickOnLeftPanalMainMenu("SOAP");
    	SOAPConnectorHomePage soapConnectorHomePage = new SOAPConnectorHomePage(driver);
    	soapConnectorHomePage.DeleteSoapconnector(SoapConnectorName);
    	Thread.sleep(2000);
    	//Assert.assertEquals(soapConnectorHomePage.getSoapConnectorEmptyMessage(), "No connector(s) created yet!");
    	//NavigationMenu navigationMenuPage = new NavigationMenu(driver);
    	navigationMenuPage.clickOnSubMenu("Configurations");
    	cert = new CertificatesHomepage(driver);
    	cert.ClickingDeletebutton("1", CertficateNAME1);
    	driver.navigate().refresh();
    	Thread.sleep(1000);
    	//	navigationMenuPage.clickOnSubMenu("Connectors");
    	//	navigationMenuPage.clickOnSubMenu("Configurations");
    	cert.ClickingDeletebutton("2", CertficateNAME);
    	//	navigationMenuPage.clickOnSubMenu("Connectors");
    	//	navigationMenuPage.clickOnSubMenu("Configurations");
    	driver.navigate().refresh();
    	Thread.sleep(1000);
    	cert.ClickingDeletebutton("3", CertficateNAME2);
    	Thread.sleep(2000);
    	navigationMenuPage.clickOnHomePage();
    	homePage = new HomePage(driver);
    	homePage.deleteProject(projectName);
    }
}

