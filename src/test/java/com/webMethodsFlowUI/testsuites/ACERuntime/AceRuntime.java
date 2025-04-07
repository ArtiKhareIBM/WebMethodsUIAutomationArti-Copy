package com.webMethodsFlowUI.testsuites.ACERuntime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webMethodsFlowUI.testsuites.CleanUpAssets.CleanAssets;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.pageObjects.ACERuntime.ace;
import com.webMethodsUI.flow.pageObjects.common.LoginPage;
import com.webMethodsUI.flow.pageObjects.common.NavigationMenu;
import com.webMethodsUI.flow.pageObjects.projects.HomePage;
import com.webMethodsUI.flow.pageObjects.workflows.WorkflowsPage;
import com.webMethodsUI.flow.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AceRuntime extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    NavigationMenu navigationMenuPage;
    WorkflowsPage workflowPage;
    ace ace;

    private static Logger log = LogManager.getLogger(CleanAssets.class);
	
	  String authtoken = "";
	  String cookie = "";
	  String csrf ="";
	
	  String URL = null;
	  String username = null;
      String password = null;
    String projectID = null;
     boolean flag = true;


    String projectName = "Auto_IC_Origin_ACE";


    @Test(groups = "sanity", description = "ensure login workd fine", priority = 1)
    public void loginTest() throws Exception
    {
        getApplicationUrl(ObjectReader.reader.GetdeployURL());
        loginPage = new LoginPage(driver);
        homePage = loginPage.loginToApplication(ObjectReader.reader.GetdeployUserName(), ObjectReader.reader.GetdeployPassword());
    }

    @Test(groups = "sanity", description = "Verify the searching of the api from the add api UI", priority = 2)
    public void APIsearch() throws Exception
    {
        //driver.navigate().refresh();
        ace = new ace(driver);
        ace.creatProject(projectName);
        ace.addaceruntime();
        Thread.sleep(3000);
        ace.openProject(projectName);
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Connectors ");
        navigationMenuPage.clickOnLeftPanalMainMenu("App Connect");
         ace = new ace(driver);
        ace.AddIntegration();
        ace.filtering("ibm_managed_runtimes", "ir-test-01");
        //ace.isRuntimeshowingornot();
        Thread.sleep(1000);
        Assert.assertEquals(ace.istheRuntimeNameDisabled("sales-ir"), true);
    }

    @Test(groups = "sanity", description = "Verify connector creation from the workflow page ", priority = 3)
    public void ConnectorcreationFromWorkflow() throws Exception{
        ace = new ace(driver);
        ace.closingIntegrationUi();
        navigationMenuPage = new NavigationMenu(driver);
        navigationMenuPage.clickOnSubMenu("Integrations");
        ace.CreateaceConnectorFromWorkflowPage("ibm_managed_runtimes", "ir-test-01");
        //ace.filtering("ibm_managed_runtimes", "ir-test-01");
        ace.createConnectorFromWorkflow("Rest_Call_Flow_1", "/execute-flow");
        //ace.createConnector("Rest_Call_Flow_1", "/execute-flow");
        driver.navigate().back();

    }

    @Test(groups = "sanity", description = "Verify the searching of connector based on the name", priority = 4)
        public void ConnectorSearch() throws Exception{

        ace = new ace(driver);
        navigationMenuPage.clickOnSubMenu("Connectors ");
        navigationMenuPage.clickOnLeftPanalMainMenu("App Connect");
        //ace.closingIntegrationUi();
        //ace.AddIntegration();
        //ace.filtering("ibm_managed_runtimes", "ir-test-01");
        //ace.createConnector("Rest_Call_Flow_1", "/execute-flow");
        //Thread.sleep(3000);
        ace = new ace(driver);
        ace.AddIntegration();
        ace.filtering("ibm_managed_runtimes", "sales-ir");
        ace.createConnector("CustomerDatabaseV1", "/customers");
        Thread.sleep(1000);
        ace.searchconnector("CustomerDatabaseV1");
        Assert.assertEquals(ace.istheRuntimeNameDisabled("CustomerDatabaseV1"), false);

    }

    @Test(groups = "sanity", description = "Verify the searching of connector based on the location", priority = 5)
    public void ConnectorSearchUsingLocation() throws Exception{
        ace = new ace(driver);
        ace.SearchConnectorUsingLocation("ibm_managed_runtimes");
        Assert.assertEquals(ace.istheRuntimeNameDisabled("CustomerDatabaseV1"), false);
        Assert.assertEquals(ace.istheRuntimeNameDisabled("Rest_Call_Flow_1"), false);
    }

    @Test(groups = "sanity", description = "Verify the searching of connector based on the runtime", priority = 6)
    public void ConnectorSearchUsingRuntime() throws Exception{
        ace = new ace(driver);
        ace.SearchConnectorUsingRuntime("sales-ir");
        Assert.assertEquals(ace.istheRuntimeNameDisabled("CustomerDatabaseV1"), false);
        Assert.assertEquals(ace.istheRuntimeNameDisabled("Rest_Call_Flow_1"), true);
    }

    
  @Test(groups = "sanity", description = "deeleting the created asserts", priority = 7)
  public void cleaningassert(){


            URL = ObjectReader.reader.GetdeployURL();
			 username = ObjectReader.reader.GetdeployUserName();
		     password = ObjectReader.reader.GetdeployPassword();
			
			 
		     logExtentReport("Clean assets in source tenant : "+URL);
		     log.info("Clean assets in source tenant : "+URL);
			getAuthTokenAndCookie();
            deleteExisitngAceRutnime("ir-test-01", "ibm_managed_runtimes");
             deleteExisitngAceRutnime("sales-ir", "ibm_managed_runtimes");
             getProjectID(projectName);
             deleteProject();

             
  }


    public   void deleteExisitngAceRutnime(String RunTimeName, String deploymentLocation)
	{
			logExtentReport("delete ERT from UI");
			log.info("delete ERT");
			
			RestAssured.baseURI = URL+"/integration/rest/runtimes";
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			System.out.println(httpRequest.log().all());
			httpRequest.header("Content-Type","applicaton/json");
           httpRequest .queryParam("runtimeName", RunTimeName);
            httpRequest.queryParam("deploymentLocation", deploymentLocation);
			httpRequest.header("Authtoken",authtoken);
			httpRequest.header("Cookie",cookie);
			httpRequest.header("x-csrf-token",csrf);
			Response response = httpRequest.request(Method.DELETE);
			int statusCode = response.getStatusCode();
			System.out.println("Status code   "+statusCode);
			String responseBody = response.getBody().asString();
			System.out.println("Respone bo  "+responseBody);
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			System.out.println("Response body data   "+responseJsonPath);
			logExtentReport(responseBody);
			log.info(responseBody);
			if(statusCode!=200)
			{
			
			}	

}


public   void getAuthTokenAndCookie()
	{
		logExtentReport("GETTING AUTHTOKEN COOKIE AND CSRF");
		log.info("GETTING AUTHTOKEN COOKIE AND CSRF");

		RestAssured.baseURI = URL+"/enterprise/v1/user/token";
		RestAssured.urlEncodingEnabled = false;
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.header("Content-Type","applicaton/json");
		httpRequest.headers("Authorization","Basic "+base64EncodingString(username,password)+"");
		Response response = httpRequest.request(Method.GET);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		JsonPath responseJsonPath = new JsonPath(responseBody); 
		logExtentReport(responseBody);
		Assert.assertEquals(statusCode, 200);
		authtoken = responseJsonPath.getString("output.authtoken");
		cookie = responseJsonPath.getString("output.cookie");
		csrf = responseJsonPath.getString("output.csrf");
		logExtentReport("Authtoken "+authtoken);
		logExtentReport("Cookie "+cookie);
	}

    public   void deleteProject()
	{
			logExtentReport("delete PROJECT");
			log.info("delete PROJECT");
			
			RestAssured.baseURI = URL+"/enterprise/v1/projects/"+projectID;
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			
			httpRequest.header("Content-Type","applicaton/json").
			header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf);
            httpRequest.contentType("application/json");
            String postbody = "{\"confirmProjectName\":\"Delete Auto_IC_Origin_ACE\", \"forceDelete\":true}";
            httpRequest.body(postbody);
			Response response = httpRequest.request(Method.DELETE);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			logExtentReport(responseBody);
			log.info(responseBody);
			if(statusCode!=200)
			{
			
			}	
}
public   void getProjectID(String projectName)
	{
		 int count = 0; 
		 boolean flag1 = false;
		 String projectUID = null;
		 
			logExtentReport("GETTING Project ID");
			log.info("GETTING Project ID");
			
		    RestAssured.baseURI = URL+"/enterprise/v1/projects";
		    RestAssured.urlEncodingEnabled = false;
			RequestSpecification httpRequest = RestAssured.given(); 
			
			httpRequest.header("Content-Type","applicaton/json");
			httpRequest.header("Authtoken",authtoken);
			httpRequest.header("Cookie",cookie);
//			httpRequest.headers("Authorization","Basic "+base64EncodingString(username,password)+"");
			httpRequest.param("q", projectName);
			Response response = httpRequest.request(Method.GET);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			logExtentReport(responseBody);
//			Assert.assertEquals(statusCode, 200);
			
			projectUID = responseJsonPath.getString("output.projects[0].uid");
			if(projectUID!=null)
			{
				flag1 = true;
				logExtentReport("projectName : "+projectName+" Project ID "+projectUID);
				log.info("projectName : "+projectName+" Project ID "+projectUID);
			}
			else
				flag = false;
				
			    flag = flag1;
			    
				projectID = projectUID;
	}

}
