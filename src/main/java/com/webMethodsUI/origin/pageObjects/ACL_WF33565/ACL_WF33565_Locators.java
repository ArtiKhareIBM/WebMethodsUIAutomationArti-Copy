package com.webMethodsUI.origin.pageObjects.ACL_WF33565;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.webMethodsUI.flow.helper.wait.WaitHelper;
import com.webMethodsUI.flow.pageObjects.SOAPConnector.AddAccountPage;
import com.webMethodsUI.flow.pageObjects.flowService.EditMappingPage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.CommonActions;

public class ACL_WF33565_Locators extends CommonActions{
	
	WebDriver driver;
	private Logger log = LogManager.getLogger(ACL_WF33565_Locators.class);
	WaitHelper waitHelper;
	WebElement element;
	String dockerururl;
	String adminport = "4567";
	String devport = "3456";
	public String loader = "//div[contains(@class,'circle-clipper')]/div[@class='circle']";
	
	
	@FindBy(xpath = "//a[normalize-space()='Integration Runtimes']")
	@CacheLookup
	WebElement IntegrationRuntimes;
	
	@FindBy(xpath = "//a[@title='Register Edge Runtime']")
	@CacheLookup
	WebElement AddERTButton;
	
	@FindBy(xpath = "//h2[normalize-space()='Create new Edge Runtime']")
	@CacheLookup
	WebElement CreateNewERTText;
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	@CacheLookup
	WebElement ERTNextButton;
	
	@FindBy(xpath = "//h2[normalize-space()='Get Edge Runtime Image']")
	@CacheLookup
	WebElement ERTImageText;
	
	@FindBy(xpath = "//h1[normalize-space()='Register Edge Runtime']")
	@CacheLookup
	WebElement RegisterEdgeRuntimeText;
	
	@FindBy(xpath = "//span[@class='es-field-label']")
	@CacheLookup
	WebElement AccessPermissionText;
	
	@FindBy(xpath = "//div[contains(@class,'es-access')]//span[contains(text(),'Private')]")
	@CacheLookup
	WebElement  DefaultVisibilityPrivate;
	
	@FindBy(xpath = "//span[contains(text(),'Public')]")
	@CacheLookup
	WebElement visibilityPublic;
	
	@FindBy(xpath = "//span[contains(@aid,'runtimeACL')]")
	@CacheLookup
	WebElement accessToggleButton;
	
	@FindBy(xpath = "//i[@class='delite-icon dlt-icon-plus']")
	@CacheLookup
	WebElement createProjectPlusButton;
	
	//@FindBy(xpath = "//span[normalize-space()='"+ERTName+"']/ancestor::div[@class='card-content  ']//span[contains(@title,'Private runtime')]")
	//@CacheLookup
	//WebElement PrivateRuntimes;
	
	//@FindBy(xpath = "//span[normalize-space()='"+ERTName+"']/ancestor::div[@class='card-content  ']//span[contains(@title,'Public runtime')]")
	//@CacheLookup
	//WebElement publicRuntimes;
	//@FindBy(xpath = "//input[@id='step-dropdown-input']")
	@FindBy(xpath = "//input[@id='first-flow-step']")
	@CacheLookup
	WebElement selectOperationDropDownElemnt;

	@FindBy(xpath = "//input[@id='new-project']")
	@CacheLookup
	WebElement ProjectName;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	@CacheLookup
	WebElement createButton;

	@FindBy(xpath = "//div[@class='notification-alert success']")
	@CacheLookup
	WebElement createProjectSuccessMessage;


	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	@CacheLookup
	public static WebElement projectDeleteButtonElement;

	@FindBy(xpath = "//div[@class='notification-message']")
	@CacheLookup
	public static WebElement notificationMessage;

	@FindBy(xpath = "//button[@class='driver-close-btn']")
	@CacheLookup
	WebElement DescribeFlowInfoDialogElement;
	

	public void closeFlowServiceInfoDialogIfExists() throws Exception
	{
		try
		{
			if (DescribeFlowInfoDialogElement.isDisplayed())
				click(DescribeFlowInfoDialogElement,driver,"Closing the info dialog");
		}
		catch(Exception e)
		{

		}
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='Demo_Adp_Edge']/ancestor::div[@class='card-content  ']//i[@class=' dlt-icon-more-menu']")
	@CacheLookup
	WebElement ERTUpdateLink;
	
	@FindBy(xpath = "//ul[contains(@class,'es-card-actions show-card-action')]//span[contains(@class,'title')][normalize-space()='Edit']")
	@CacheLookup
	WebElement EditERTButton;
	
	@FindBy(xpath = "//ul[contains(@class,'es-card-actions show-card-action')]//span[contains(@class,'title')][normalize-space()='Deregister']")
	@CacheLookup
	WebElement ERTDeregisterbutton;
	
	@FindBy(xpath = "//ul[contains(@class,'es-card-actions show-card-action')]//span[contains(@class,'title')][normalize-space()='Restart']")
	@CacheLookup
	WebElement ERTRestartbutton;
	
	@FindBy(xpath = "//ul[contains(@class,'es-card-actions show-card-action')]//span[contains(@class,'title')][normalize-space()='Add Instance']")
	@CacheLookup
	WebElement AddInstance;
	
	@FindBy(xpath = "//span[normalize-space()='You do not have the runtime access permission.']")
	@CacheLookup
	WebElement accessPermissionMessage;
	
	@FindBy(xpath = "//input[@name='edgeServerName']")
	@CacheLookup
	WebElement enterERTName;
	
	@FindBy(xpath = "//button[normalize-space()='Start Pairing']")
	@CacheLookup
	WebElement startPairing;
	
	@FindBy(xpath = "//a[@title='Copy']")
	@CacheLookup
	WebElement  CopyDockercommands;
	
	@FindBy(xpath = "//input[@id='ut-flowservice-desc']")
	@CacheLookup
	WebElement flowServiceDescElement;
	
	@FindBy(xpath = "//input[@id='ut-input-field-displayname']")
	@CacheLookup
	WebElement flowServiceTitleElement;
	
	public WorkflowsPage createProject(String projectName) throws Exception 
	{
		WebElement element= findElement("//a[normalize-space()='Projects']", driver);
		click(element, driver, "CLick on projetcs link");
		waitForElementVisible(createProjectPlusButton, driver, "Wait for Create button visble");
		click(createProjectPlusButton,driver,"Click on Add Project Button");
		enterValue(this.ProjectName,projectName,driver,"Entering Project Name " +projectName);
		click(createButton,driver,"Click createProject Button");
		elementContainsText(notificationMessage,"Project created successfully.",driver,"Verify project created successfully message is visible");
//		waitForElementNotVisible(loader, driver, "wait for page load");
		return new WorkflowsPage(driver);
	}
	
	public void openProject(String ProjectName) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath("//span[contains(@class,'project-name')][contains(text(),'" + ProjectName + "')]"));
		click(element,driver,"Clicking on Project " + element);
		waitForElementNotVisible(loader, driver, "wait for page load");
		
	}

    public void startDockerContainer(String port) {
        try {
        	
            //String command = 
        	System.out.println(dockerururl);
        	String replaced = dockerururl.replaceFirst("5555", port);
        	System.out.println(replaced);
        	String[] command2 = {"cmd.exe", "/c", replaced.toString()};
          	// String[] command2 = {"cmd.exe", "/c","docker run -p 5555:5555 -d -e SAG_IS_CLOUD_REGISTER_URL=https://azsprotenant6.int-az-us.webmethods-spro.io -e SAG_IS_EDGE_CLOUD_ALIAS=EdgeRuntime_ERTWithAdminUser -e SAG_IS_CLOUD_REGISTER_TOKEN=3109c9122e5145c2876c96526ffba4c7698c95119d82463d978599c5d7649176 --name=ERTWithAdminUser iregistry.infra.webmethods.io/aim/msr-edge-runtime:latest"};

            ProcessBuilder processBuilder = new ProcessBuilder(command2);
           // processBuilder.directory(new File("C:\\WMIOAutomationNew\\WebMethodsUIAutomation"));
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Container ID: " + line);
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startDockerContainerdev() {
        try {
        	
            //String command = 
        	System.out.println(dockerururl);
        	String replaced2 = dockerururl.replaceFirst("5555", devport);
        	System.out.println(replaced2);
        	String[] command2 = {"cmd.exe", "/c", replaced2.toString()};
          	// String[] command2 = {"cmd.exe", "/c","docker run -p 5555:5555 -d -e SAG_IS_CLOUD_REGISTER_URL=https://azsprotenant6.int-az-us.webmethods-spro.io -e SAG_IS_EDGE_CLOUD_ALIAS=EdgeRuntime_ERTWithAdminUser -e SAG_IS_CLOUD_REGISTER_TOKEN=3109c9122e5145c2876c96526ffba4c7698c95119d82463d978599c5d7649176 --name=ERTWithAdminUser iregistry.infra.webmethods.io/aim/msr-edge-runtime:latest"};

            ProcessBuilder processBuilder = new ProcessBuilder(command2);
           // processBuilder.directory(new File("C:\\WMIOAutomationNew\\WebMethodsUIAutomation"));
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Container ID: " + line);
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void stopDockerContainer(String containerName) {
        try {
            String[] command = {"docker", "stop", containerName};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
            process.waitFor();

            String[] removeCommand = {"docker", "rm", containerName};
            ProcessBuilder removeBuilder = new ProcessBuilder(removeCommand);
            Process removeProcess = removeBuilder.start();
            removeProcess.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void stopspecificContainer(String namePrefix)
    {
    try {
    List<String> containerIds = new ArrayList<>();
    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c","docker ps -a --format \"{{.ID}} {{.Names}}\" | findstr ^"+namePrefix+"_");
    builder.redirectErrorStream(true);
    Process process = builder.start();

    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(" ");
        if (parts.length > 0) {
            containerIds.add(parts[0]);  // First part is the container ID
        }
        
    }
    for (String containerId : containerIds) {
        stopDockerContainer1(containerId);
        removeDockerContainer(containerId);
    }
    }
    catch(Exception e) {
    	e.getMessage();
    }
   
    }

// Step 2: Stop Docker container by ID
  public static void stopDockerContainer1(String containerId) throws IOException {
    ProcessBuilder builder = new ProcessBuilder("docker", "stop", containerId);
    builder.redirectErrorStream(true);
    Process process = builder.start();

    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);  // Output the result of docker stop command
    }

    System.out.println("Stopped container: " + containerId);
}
// Step 2: Stop Docker container by ID
  public static void removeDockerContainer(String containerId) throws IOException {
    ProcessBuilder builder = new ProcessBuilder("docker", "stop", containerId);
    builder.redirectErrorStream(true);
    Process process = builder.start();

    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);  // Output the result of docker stop command
    }

    System.out.println("Stopped container: " + containerId);
}
    
       
	
     public ACL_WF33565_Locators(WebDriver driver) {
    	 super();
 		this.driver = driver;
 		PageFactory.initElements(driver, this);
	}
     
    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu active')]//i[contains(@class,'delete-blue')]/following-sibling::*[@class='menu-title'][text()='Delete']")
 	@CacheLookup
 	public WebElement FlowServiceDeleteOption;
    
    @FindBy(xpath = "//h1[text()='Confirm Delete ?']")
	@CacheLookup
	public WebElement FlowServiceconfirmDeletePopUP;
    
    @FindBy(xpath = "//button[text()='Delete']")
	@CacheLookup
	public WebElement deleteButton;
    
 	public void deleteFlowService(String flowServiceName) throws Exception 
 	{
 		WebElement FlowServicesMoreMenu = findElement("//*[contains(@class,'title-flow-name')][text()='"+flowServiceName+"']/ancestor::div[@class='top-section']/following-sibling::div[@class='bottom-section']//i[contains(@class,'more-menu')]",driver);
 		click(FlowServicesMoreMenu,driver,"Click FlowServices MoreMenu");
 		waitForElementNotVisible(loader, driver, "wait for page load");
 		waitForElementVisible(FlowServiceDeleteOption, driver, "Wait for delete button visble");
 		click(FlowServiceDeleteOption,driver,"Click on FlowService delete button");
 		waitForElementNotVisible(loader, driver, "wait for page load");
 		waitForElementVisible(FlowServiceconfirmDeletePopUP,driver,"Verify flow service delete confirm popup is visible");
 		click(deleteButton,driver,"Click on delete button");
// 		elementContainsText(notificationMessage,flowServiceName+" deleted successfully.",driver,"Verify FlowService deleted successfully. message is visible");
 		elementContainsText(notificationMessage,"Flow service deleted successfully.",driver,"Verify FlowService deleted successfully. message is visible");
 		waitForElementNotVisible(loader, driver, "wait for page load",45);
 	}
 	
 	public void deleteProject2(String name) throws Exception {
 		WebElement element= findElement("//a[normalize-space()='Projects']", driver);
		click(element, driver, "CLick on projetcs link");
		WebElement searcheElement = driver.findElement(By.xpath("//input[@type='search']"));
		click(searcheElement, driver, "Cicking on search project field");
		enterValue(searcheElement, name, driver, "Entering project name in search box: "+name);
		click(searchicon, driver, "Clicking on searchicon to search project");
		waitForElementNotVisible(loader, driver, "wait for page load");
		
		
 	}
 	
 	public void deleteProject(String projectNametxt) throws Exception 
	{
			WebElement projectEllipsisElement = driver.findElement(By.xpath("//span[contains(text(),'" + projectNametxt
					+ "')]/parent::h2/../../../following-sibling::div/a[@aid='projectCardMenuBtn']"));
			scrollPageToElement(driver,projectEllipsisElement);
			click(projectEllipsisElement,driver,"Click on projectpanel more menu");
			Thread.sleep(1000);
			WebElement deleteprojectbtn = driver.findElement(By.xpath("//a[@name='"+projectNametxt+"-delete']"));
//			
			Thread.sleep(1000);
			click(deleteprojectbtn,driver,"Clicking on delete button");
			waitForElementVisible(projectDeleteButtonElement,driver,"Verify project delete button is present");
			doubleClick(projectDeleteButtonElement,driver,"Clicking on homeLogo.. ");

			waitForElementVisible(notificationMessage,driver,"Verify Project deleted successfully. message is present");
			elementContainsText(notificationMessage,"Project deleted successfully.",driver,"Verify Project deleted successfully. message is present");
			waitForElementNotVisible(loader, driver, "wait for page load",45);
	}
 	
 	public void afterExecutionBackToProject() throws Exception {
 		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");
 		driver.navigate().back();
 		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visble");
 		
 	}
 	
	
	public void switchIntegrationRuntimes() throws Exception {
		log.info("Waiting for Integration Runtimes to visible");
		click(IntegrationRuntimes, driver, "Click on Integration runtimes");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loder not visible");
		
	}
	
	public void addNewERT() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loder not visible");
		waitForElementVisible(AddERTButton, driver, "wait for loder not visible", 30);
		click(AddERTButton, driver, "Click on Add ERT button");
		click(ERTNextButton, driver, "Click next button");
		waitForElementVisible(ERTImageText, driver, "Wait for Get Edge Runtime Image visible");
		click(ERTNextButton, driver, "Click next button");
	}
	
	public void validateAccessPermission() throws Exception {
		waitForElementVisible(RegisterEdgeRuntimeText, driver, "Wait for Register Edge Runtime visible");
		elementContainsText(AccessPermissionText, "Access", driver, "Verify Access is visible");
		elementContainsText(DefaultVisibilityPrivate, "Private", driver, "Verify Private is visible");
	}
	
	public void validateAccessPermissionNotShown() throws Exception {
		waitForElementVisible(RegisterEdgeRuntimeText, driver, "Wait for Register Edge Runtime visible");
		//elementContainsText(AccessPermissionText, "Access", driver, "Verify Access is visible");
		//elementContainsText(DefaultVisibilityPrivate, "Private", driver, "Verify Private is visible");
		//waitForElementNotVisible(AccessPermissionText.getText(), driver, "Verify Access Text not visble", 0);
		//Assert.assertEquals(AccessPermissionText.getText(), null);
		//accessPermissionMessage.
	}
	
	public void enable() throws Exception {
		click(accessToggleButton, driver, "Click on toggle button to enable public runtime");
		elementContainsText(visibilityPublic, "Public", driver, "Verify access permission Public is visible");
		
	}
	
	public void Disable() throws Exception {
		click(accessToggleButton, driver, "Click on toggle button to enable public runtime");
		elementContainsText(DefaultVisibilityPrivate, "Private", driver, "Verify access permission Private is visible");
		
	}
	
	public void accesspermisionafterERTRegisterPublic(String ERTName) throws Exception {
		WebElement element = findElement("//span[normalize-space()='"+ERTName+"']", driver) ;
		waitForElementVisible(element, driver, ERTName+" visible");
		Thread.sleep(4000);
		waitForElementNotVisible(loader, driver, "Wait for loader is not visble");
		WebElement PrivateIcon = findElement("//span[normalize-space()='"+ERTName+"']/ancestor::div[@class='card-content  ']//span[contains(@title,'Public runtime')]", driver);
		waitForElementVisible(PrivateIcon, driver, "Verify this ERT is Private");
		
	}
	
	public void accesspermisionafterERTRegisterPrivate(String ERTName) throws Exception {
		WebElement element = findElement("//span[normalize-space()='"+ERTName+"']", driver) ;
		waitForElementVisible(element, driver, ERTName+" visible");
		Thread.sleep(4000);
		waitForElementNotVisible(loader, driver, "Wait for loader is not visble");
		WebElement PrivateIcon = findElement("//span[normalize-space()='"+ERTName+"']/ancestor::div[@class='card-content  ']//span[contains(@title,'Private runtime')]", driver);
		waitForElementVisible(PrivateIcon, driver, "Verify this ERT is Private");
		
	}
	
	public void sendERTName(String Name) throws Exception {
		enterValue(enterERTName, Name, driver, "Enter the ERT name");
		click(ERTNextButton, driver, "Click next button");
		Thread.sleep(5000);
		waitForElementVisible(startPairing, driver, "Wait for start Pairing");
		click(startPairing, driver, "Click on start pairing");
		WebElement element = findElement("//span[@class='cmd-snippet']", driver);
		System.out.println(element.getText());
		WebElement eleurl = findElement("//span[normalize-space()='SAG_IS_CLOUD_REGISTER_URL']", driver);
		System.out.println(eleurl.getText());
		WebElement eleToken = findElement("//span[normalize-space()='SAG_IS_CLOUD_REGISTER_TOKEN']", driver);
		System.out.println(eleToken.getText());
		//command = element.getText();
		//WebElement tokenID = findElement("//code/br[3]", driver);
		//System.out.println(tokenID);
		//System.out.println(tokenID.getText());
		click(CopyDockercommands, driver, "click on copy docker command");
		dockerururl = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		Thread.sleep(3000);
		System.out.println(dockerururl);
		
	}
	
	public void logout() throws Exception
	{
		//driver.navigate().refresh();
		WebElement PROFILE = findElement("//i[@class='delite-icon dlt-icon-profile']", driver);
		waitForElementVisible(PROFILE, driver, "Wait for user profile visible", 10);
		click(PROFILE, driver, "Click on PROFILE link");
		WebElement logout = findElement("//span[contains(text(),'Log out')]", driver);
		click(logout, driver, "Click on logout link");
		driver.manage().deleteAllCookies();
		driver.close();
		
	}
	
	public void checkERTEnable(String name) throws Exception {
		WebElement elementEnabled = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//span[contains(text(), 'Enabled')]", driver);
		elementContainsText(elementEnabled, "Enabled", driver, "Verify ERT is enabled");
		//WebElement element = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//span[@class='switch-handle small']", driver);
		//click(element, driver, "Click on toggle button to disable");
	}
	
	public void ERTmanageAdmin(String name) throws Exception {
		WebElement elementEdit = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//i[@class=' dlt-icon-more-menu']", driver);
		click(elementEdit, driver, "Click on Edit button");
		waitForElementLoaderNotVisible(loader, driver, "loader is not visble");
		elementContainsText(AddInstance, "Add Instance", driver, "Verify Add Instance visible");
		elementContainsText(ERTDeregisterbutton, "Deregister", driver, "Verify Deregister is visble");
		elementContainsText(ERTRestartbutton, "Restart", driver, "Verify Restart is visible");
		elementContainsText(EditERTButton, "Edit", driver, "Verify Edit button is visible");
		//WebElement OwnerName = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//strong[@class='es-owner-name']", driver);
		//elementContainsText(OwnerName, "ICFeaturesAdmin User", driver, "Verify admin owner name is visible");
	}
	
	public void ERTmanageDev(String name) throws Exception {
		WebElement elementEdit = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//i[@class=' dlt-icon-more-menu']", driver);
		click(elementEdit, driver, "Click on Edit button");
		waitForElementLoaderNotVisible(loader, driver, "loader is not visble");
		elementContainsText(AddInstance, "Add Instance", driver, "Verify Add Instance visible");
		elementContainsText(ERTDeregisterbutton, "Deregister", driver, "Verify Deregister is visble");
		elementContainsText(ERTRestartbutton, "Restart", driver, "Verify Restart is visible");
		elementContainsText(EditERTButton, "Edit", driver, "Verify Edit button is visible");
		WebElement OwnerName = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//strong[@class='es-owner-name']", driver);
		elementContainsText(OwnerName, "ICFeaturesDev Usertest", driver, "Verify dev owner name is visible");
	}
	
	public void deregisterERT(String name) throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loder not visible");
		waitForElementVisible(AddERTButton, driver, "wait for loder not visible", 30);
		WebElement elementEdit = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//i[@class=' dlt-icon-more-menu']", driver);
		click(elementEdit, driver, "Click on Edit button");
		waitForElementLoaderNotVisible(loader, driver, "loader is not visble");
		Thread.sleep(5000);
		click(ERTDeregisterbutton, driver, "Deregister the ERT");
		WebElement element = findElement("//button[normalize-space()='deregister']", driver);
		click(element, driver, "Confirm to deregister the ERT");
		waitForElementLoaderNotVisible(loader, driver, "wait for loader not visible");
		//WebElement deRegisterMessage = findElement("//div[@class='notification-message']", driver);
		//elementContainsText(deRegisterMessage, "Edge Runtime deregistered successfully.", driver, "Verify message is visible");
		//WebElement ertDeleted = findElement("//span[normalize-space()='"+name+"']",driver);
		//elementNotVisible(ertDeleted.toString(), driver, "ERT "+name+" not visible");
		//boolean titletext = findElement("//span[normalize-space()='\"+name+\"']", driver).isDisplayed();
		//Assert.assertFalse(titletext, "ERT "+name+" not visible");
		
	}
	
	public int permissionMessage() throws Exception {
		//WebElement element = findElement("//span[normalize-space()='"+ERTName+"']", driver);
		//click(element, driver, "Click on private ERT");
		//waitForElementVisible(accessPermissionMessage, driver, "Wait for access ERT message notification visible");
		List<WebElement> count = findElements("//span[contains(@title,'Private runtime')]", driver);
		return count.size();
		//elementNotVisible(element.toString(), driver, "Verify Private ERT not visble");
	}
	
	public void ERTSuccess() throws Exception {
		WebElement element = findElement("//p[@class='es-succ-desc']", driver);
		waitForElementVisible(element, driver, "Wait for ERT success message visble ", 120);
		WebElement closeButton = findElement("//button[normalize-space()='Close']", driver);
		click(closeButton, driver, "Click on close button");
	}
	
	public void createFlowService() throws Exception {
		WebElement flowService = findElement("//a[normalize-space()='Flow services']", driver);
		click(flowService, driver, "Click on Flow services");
		WebElement element = findElement("//*[@class='new-btn delite-icon dlt-icon-plus']", driver);
		click(element, driver, "Click on create new flowserviceButton");
		List<WebElement> DAF = findElements("//div[contains(@class,'flow-type ')]", driver);
		click(DAF.get(1), driver, "Click on DAF flowservices");
		WebElement CreateButton = findElement("//button[normalize-space()='Create']", driver);
		click(CreateButton, driver, "Click on Create button");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visible");
		closeFlowServiceInfoDialogIfExists();
		WebElement startCreatingFlowMessage = findElement("//h2[normalize-space()='Start creating the Flow service']", driver);
		waitForElementVisible(startCreatingFlowMessage, driver, "wait for element viable");
		
		
	}
	@FindBy(xpath = "//span[@class=' delite-icon dlt-icon-search searchbox-search-icon']")
	@CacheLookup
	public static WebElement searchicon;
	
	public void searchProject(String ProjectName) throws Exception
	{
		WebElement element= findElement("//a[normalize-space()='Projects']", driver);
		click(element, driver, "CLick on projetcs link");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader not visible");
		WebElement searcheElement = driver.findElement(By.xpath("//input[@type='search']"));
		waitForElementVisible(searcheElement, driver, "Wait for search button visible");
		click(searcheElement, driver, "Cicking on search project field");
		enterValue(searcheElement, ProjectName, driver, "Entering project name in search box: "+ProjectName);
		click(searchicon, driver, "Clicking on searchicon to search project");
		waitForElementNotVisible(loader, driver, "wait for page load");
		WebElement element2 = findElement("//span[contains(@class,'project-name')][contains(text(),'" + ProjectName + "')]",driver);
		click(element2,driver,"Clicking on Project " + element2);
		waitForElementNotVisible(loader, driver, "wait for page load");
	}
	public void enterFlowServiceTitle(String flowServiceName) throws Exception
	{
		clearAndEnterText(flowServiceTitleElement,flowServiceName,driver,"Entering flow service title:  " + flowServiceName);
		
	}
	
	public void selectRuntimes(String name) throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement element = findElement("//span[contains(@class,'display-value')]", driver);
		click(element, driver, "Click on runtime dropdown");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement searchERT = findElement("//input[@placeholder='Search Runtime']", driver);
		enterValue(searchERT, name, driver, "Search ERT "+name);
		WebElement selectERT =  findElement("//span[contains(@title,'"+name+"')]", driver);
		click(selectERT, driver, "Click on ERTName");
		
		
	}
	
	public void openERT(String ERTname) throws Exception {
		WebElement addInstanceSuccess = findElement("//button[normalize-space()='done']", driver);
		waitForElementVisible(addInstanceSuccess, driver, "Wait for Add instance sucess and Done button visible", 150);
		click(addInstanceSuccess, driver, "Click on Done button");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loder is not visible");
		WebElement ele = findElement("//span[normalize-space()='"+ERTname+"']", driver);
		click(ele, driver, "Click on "+ERTname);
		
	}
	
	public void instanceValidation() throws Exception {
		WebElement element = findElement("//span[@title='Private runtime']", driver);
		waitForElementVisible(element, driver, "Wait for Security icon visble", 10);
		WebElement addinstanceButton = findElement("//button[normalize-space()='Add Instance']", driver);
	    isElementEnabled(addinstanceButton, driver, "Verify if button is enabled");
	    List<WebElement> restartButton = findElements("//img[@title='Restart']", driver);
	    isElementEnabled(restartButton.get(0), driver, "Verify Restart button visible");
	    isElementEnabled(restartButton.get(1), driver, "Verify Restart button visible");
	    List<WebElement> deleteButton = findElements("//img[@title='Delete']", driver);
	    isElementEnabled(deleteButton.get(0), driver, "Verify Delete button visible");
	    isElementEnabled(deleteButton.get(1), driver, "Verify Delete button visible");
	    
		
	}
	
	public void returnIntegrationRuntime(String ERTname) throws Exception {
		WebElement backbutton =  findElement("//a[@title='Go back']", driver);
		click(backbutton, driver, "Click on back button");
		WebElement ele = findElement("//span[normalize-space()='"+ERTname+"']", driver);
		waitForElementVisible(ele, driver, ERTname+" Visible", 10);
	}
	
	public void multiInstanceManageERT(String name) throws Exception {
		WebElement ele = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//span[normalize-space()='2/2 Running']",driver);
		waitForElementVisible(ele, driver, "Wait for element Visible", 30);
		elementContainsText(ele,"2/2 Running" , driver, "Verify 2/2 running state");
		WebElement elementEdit = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//i[@class=' dlt-icon-more-menu']", driver);
		click(elementEdit, driver, "Click on Edit button");
		waitForElementLoaderNotVisible(loader, driver, "loader is not visble");
		//elementContainsText(AddInstance, "Add Instance", driver, "Verify Add Instance visible");
		elementContainsText(ERTDeregisterbutton, "Deregister", driver, "Verify Deregister is visble");
		elementContainsText(EditERTButton, "Edit", driver, "Verify Edit button is visible");
		//elementNotVisible(ERTRestartbutton.toString(), driver, "Verify Restart button not visible");
		//elementNotVisible(AddInstance.toString(), driver, "Verify Add Instance not visible");
		
	}
	
	public void AddNewInstance(String name) throws Exception {
		WebElement elementEdit = findElement("//span[normalize-space()='"+name+"']/ancestor::div[@class='card-content  ']//i[@class=' dlt-icon-more-menu']", driver);
		click(elementEdit, driver, "Click on Edit button");
		waitForElementLoaderNotVisible(loader, driver, "loader is not visble");
		elementContainsText(AddInstance, "Add Instance", driver, "Verify Add Instance visible");
		click(AddInstance, driver, "Click on add instance button");
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		click(CopyDockercommands, driver, "click on copy docker command");
		dockerururl = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		Thread.sleep(3000);
		System.out.println(dockerururl);
	}
	
	public void selectService(String serviceName) throws Exception
	{
		//click(selectOperationDropDownElemnt,driver,"Clicking on select operation dropdown...");
		enterValue(selectOperationDropDownElemnt, serviceName, driver, serviceName);
		WebElement setcurrentdate = findElement("//span[normalize-space()='"+serviceName+"']", driver);
		click(setcurrentdate, driver, "Click on service Name");
		//WebElement element = findElement("//span[contains(text(),'" + serviceName + "')]",driver);
		//waitForElementVisible(element,driver,"Wait for operation list");
		//click(element,driver,"selecting custom service...."+element);
	}
	
	@FindBy(xpath = "//img[contains(@class,'view-pipeline')]")
	@CacheLookup
	List<WebElement> editMappingElement;
	
	public EditMappingPage clickOnEditMappingIcon() throws Exception
	{
		click(editMappingElement.get(0),driver,"Click on edit mapping");
		waitForElementNotVisible(loader, driver, "wait for page load");
		return new EditMappingPage(driver);
	}
	
	public void doubleClickOnChildParamName(String paramName) throws Exception 
	{
		WebElement element = findElement("//span[contains(@class,'child-node')][contains(text(),'" + paramName + "')]",driver);
		doubleClick(element,driver,"double clicking on child parameter.. " + paramName);
	}
	
	public void setValue(String paramName, String value) throws Exception 
	{
		WebElement element = findElement("//label[contains(text(),'"+paramName+"')]/ancestor::div/flow-input-control//div/textarea",driver);
		enterValue(element,value,driver,"Entering Input Value " +value);
	}
	@FindBy(xpath = "//div[@class='btn-groups flow-modal-footer']/button[3]")
	@CacheLookup
	WebElement saveButtonElement;
	public void clickOnSave() throws Exception 
	{	
		click(saveButtonElement,driver,"Clicking on Save...");
	}
	
	@FindBy(xpath = "//a[@class='ut-icon-cloud-sync ng-star-inserted']")
	@CacheLookup
	WebElement SyncFlowService;
	
	@FindBy(xpath = "//a[@class='ut-icon-action-bar_run ng-star-inserted']")
	@CacheLookup
	WebElement RunFlowService;
	
	public void saveButton() throws Exception {
		WebElement save = findElement("//a[@class='ut-icon-action-bar_save ng-star-inserted dropdown']", driver);
		isElementEnabled(save, driver, "Wait for Save button enabled");
		click(save, driver, "Click on save button ");
		Thread.sleep(9000);
	}
	
	public void flowsericeSyncAndRun() throws Exception {
		isElementEnabled(SyncFlowService, driver, "Wait for sync button to be enabled");
		click(SyncFlowService, driver, "Click on sync button to sync ERT");
		Thread.sleep(7000);
		WebElement eleel = findElement("//span[contains(text(),'Success')]", driver);
		waitForElementVisible(eleel, driver, "Wait for Success message for Sync visible", 10);
		Thread.sleep(7000);
		click(RunFlowService, driver, "Click on run button");
	}
	
	public void successMessage() throws Exception {
		WebElement message= findElement("//span[contains(text(),' Run Successful ')]", driver);
		waitForElementVisible(message, driver, "Wait for Run success visible",30);
		elementContainsText(message, "Run Successful", driver, "Verify message successful");
	}
	
	public int privateERTCountWithDevUser() throws Exception {
		List<WebElement> element = findElements("//span[@title='Private runtime']", driver);
		return element.size();
		
	}
	
	public void openFlowService() throws Exception {
		waitForElementLoaderNotVisible(loader, driver, "Wait for loader is not visible");
		WebElement flowService = findElement("//a[normalize-space()='Flow services']", driver);
		click(flowService, driver, "Click on Flow services");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
