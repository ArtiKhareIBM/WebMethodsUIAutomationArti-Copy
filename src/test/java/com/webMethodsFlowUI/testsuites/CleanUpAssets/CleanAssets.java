package com.webMethodsFlowUI.testsuites.CleanUpAssets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.testbase.APITestCasesBaseClass;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CleanAssets extends APITestCasesBaseClass
{
	private static Logger log = LogManager.getLogger(CleanAssets.class);
	
	  String authtoken = "";
	  String cookie = "";
	  String csrf ="";
	
	  String URL = null;
	  String username = null;
	  String password = null;
	
	 String projectID = null;
	 boolean flag = true;
	 int iteration = 0;
	 List<String> ERTID = new ArrayList<String>();
//	 String projectName = null;
	 

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMM");
	LocalDateTime now = LocalDateTime.now();
	String currentDateMonth = dtf.format(now);
	 
	 String projectName = "ICAPI_";
	 String ERTName = "ICFeatures_";
//	 String projectName2 = "ICUI_"+currentDateMonth;
//	 String projectName2 = "JUL25";
	//String displayname = "vna";


	 
	 
	 String[] projectIDS = new String[10];
	 int index = 0;
	

	 @Test(groups = "sanity", description = "CleanUp API assets in source tenant", priority = 0)
		public   void CleanAPIAutomationAssets()
		{
			 projectName = ObjectReader.reader.getprojectName();
			
			 URL = ObjectReader.reader.getURL();
			 username = ObjectReader.reader.getUserName();
		     password = ObjectReader.reader.getPassword();
			
			 
		     logExtentReport("Clean assets in source tenant : "+URL);
		     log.info("Clean assets in source tenant : "+URL);
			getAuthTokenAndCookie();
			deletegitAccount();
		     
		   while(flag && iteration < 30)
		   {
			iteration++;
			logExtentReport("iteration "+iteration);
			log.info("iteration "+iteration);
			getAuthTokenAndCookie();
			getProjectID(projectName);
			getERTID(ERTName);
			if(flag)
			{
			logExtentReport(projectID);
			deleteAllKeyStores();
			deleteAllPartnerCertificate();
			deleteAllRADS();
			deleteAllWorkFlows();
			deleteAllFlowServices();
			deleteAllTriggers();
			deleteProject();
			//deleteExisitngERT();
			}
			else
			{
				logExtentReport("Project with the name "+projectName+ " doesn't exist or the project got cleanedup");
			}
		   }
		}
	
	@Test(groups = "sanity", description = "CleanUp API assets in target tenant", priority = 1)
	public   void CleanAutomationAssetsInTargetTenant()
	{
		flag = true;
		
		int iteration = 0;

		 projectName = ObjectReader.reader.getprojectName();
		 URL = ObjectReader.reader.GetdeployURL();
		 username = ObjectReader.reader.GetdeployUserName();
	     password = ObjectReader.reader.GetdeployPassword();
	     log.info("Clean assets in target tenant : "+URL);
	     logExtentReport("Clean assets in target tenant");
		getAuthTokenAndCookie();
		 deletegitAccount();

	     
	   while(flag && iteration < 30)
	   {
		iteration++;
		logExtentReport("iteration "+iteration);
		log.info("iteration "+iteration);
		getAuthTokenAndCookie();
		getProjectID(projectName);
		//getERTID(ERTName);
		if(flag)
		{
		logExtentReport(projectID);
		deleteAllKeyStores();
		deleteAllRADS();
		deleteAllWorkFlows();
		deleteAllFlowServices();
		deleteAllTriggers();
		deleteProject();
		//deleteExisitngERT();
		}
		else
		{
			logExtentReport("Project with the name "+projectName+ " doesn't exist or the project got cleanedup");
		}
	   }
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
	
	
	public   void deleteExisitngERT(String ertID)
	{
			logExtentReport("delete ERT from UI");
			log.info("delete ERT");
			
			RestAssured.baseURI = URL+"integration/rest/edge/runtimes/"+ertID+"/deregister";
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			System.out.println(httpRequest.log().all());
			httpRequest.header("Content-Type","applicaton/json");
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
		
	public   void deleteAllKeyStores()
	{
		Boolean flag = true;
		int count = 0; 
		
		while(flag)
		{
			
			logExtentReport("delete all Keystores");
			log.info("delete all Keystores");
			
			RestAssured.baseURI = URL+"/integration/rest/advancedSecurity/keystore";
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			
			httpRequest.header("Content-Type","applicaton/json").
			header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf)
			.queryParam("projectName", projectID);
			Response response = httpRequest.request(Method.GET);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			logExtentReport(responseBody);
			logExtentReport(httpRequest.request().toString());
//			Assert.assertEquals(statusCode, 200);
	
	if(statusCode == 200)	 
	{		 
			String keyStoreName = responseJsonPath.getString("integration.serviceData.keyStores["+count+"].keyStoreName");
			
		    if(keyStoreName != null)	
		    {
				
				  RestAssured.baseURI = URL+"/integration/rest/advancedSecurity/keystore/"+keyStoreName;
				  RestAssured.urlEncodingEnabled = false;
					httpRequest = RestAssured.given(); 
					
					httpRequest.header("Content-Type","applicaton/json").
					header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf)
					.param("projectName", projectID);
					response = httpRequest.request(Method.DELETE);
					statusCode = response.getStatusCode();
					responseBody = response.getBody().asString();
					responseJsonPath = new JsonPath(responseBody); 
					logExtentReport(responseBody);
//					Assert.assertEquals(statusCode, 200);
					if(statusCode != 200)	 
						count++;
		    }
		    else
		    	flag = false;
		}
	else
		flag = false;
		}
}
	
	public   void deleteAllPartnerCertificate()
	{
		Boolean flag = true;
		int count = 0; 
		
		while(flag)
		{
			
			logExtentReport("delete all Partner Certificate");
			log.info("delete all Partner Certificate");
			
			RestAssured.baseURI = URL+"/integration/rest/advancedSecurity/certificate";
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			
			httpRequest.header("Content-Type","applicaton/json").
			header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf)
			.queryParam("projectName", projectID);
			Response response = httpRequest.request(Method.GET);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			logExtentReport(responseBody);
			logExtentReport(httpRequest.request().toString());
//			Assert.assertEquals(statusCode, 200);
	
	if(statusCode == 200)	 
	{		 
			String partnerCertificateName = responseJsonPath.getString("integration.serviceData.partnerCertificates["+count+"].name");
			
		    if(partnerCertificateName != null)	
		    {
				
				  RestAssured.baseURI = URL+"/integration/rest/advancedSecurity/certificate/"+partnerCertificateName;
				  RestAssured.urlEncodingEnabled = false;
					httpRequest = RestAssured.given(); 
					
					httpRequest.header("Content-Type","applicaton/json").
					header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf)
					.param("projectName", projectID);
					response = httpRequest.request(Method.DELETE);
					statusCode = response.getStatusCode();
					responseBody = response.getBody().asString();
					responseJsonPath = new JsonPath(responseBody); 
					logExtentReport(responseBody);
//					Assert.assertEquals(statusCode, 200);
					if(statusCode != 200)	 
						count++;
		    }
		    else
		    	flag = false;
		}
	else
		flag = false;
		}
}
	
	
	
	public   void deleteAllRADS()
	{
		Boolean flag = true;
		int count = 0; 
		
		while(flag)
		{
			
			logExtentReport("delete all RADS");
			log.info("delete all RADS");
			
			RestAssured.baseURI = URL+"/integration/rest/rad";
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			
			httpRequest.header("Content-Type","applicaton/json").
			header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf)
			.queryParam("projectName", projectID);
			Response response = httpRequest.request(Method.GET);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			logExtentReport(responseBody);
			log.info(responseBody);
			logExtentReport(httpRequest.request().toString());
//			Assert.assertEquals(statusCode, 200);
		if(statusCode == 200)
		{
			String radName = responseJsonPath.getString("integration.serviceData.rads["+count+"].radName");
			String isSwaggerFirst = responseJsonPath.getString("integration.serviceData.rads["+count+"].isSwaggerFirst");
			String stageName = responseJsonPath.getString("integration.serviceData.stageName");
			
		    if(radName != null)	
		    {
				
				  RestAssured.baseURI = URL+"/integration/rest/rad/"+radName;
				  RestAssured.urlEncodingEnabled = false;
					httpRequest = RestAssured.given(); 
					
					httpRequest.header("Content-Type","applicaton/json").
					header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf)
					.param("stageName", stageName).param("isSwaggerFirst", isSwaggerFirst).param("projectName", projectID);
					response = httpRequest.request(Method.DELETE);
					statusCode = response.getStatusCode();
					responseBody = response.getBody().asString();
					responseJsonPath = new JsonPath(responseBody); 
					logExtentReport(responseBody);
					log.info(responseBody);
					if(statusCode != 200)
					{
						count++;
					}
//					Assert.assertEquals(statusCode, 200);
		    }
		    else
		    	flag = false;
		}
		else
			flag = false;
		
		}
}
	
	
	public   void deleteAllWorkFlows()
	{
		Boolean flag = true;
		int count = 0; 
		
		while(flag)
		{
			logExtentReport("delete all work flow");
			log.info("delete all work flow");
			
			RestAssured.baseURI = URL+"/enterprise/v1/flows";
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			
			httpRequest.header("Content-Type","applicaton/json").
			header("Authtoken",authtoken).header("Cookie",cookie).header("project_uid",projectID).header("X-Csrf-Token",csrf);
			Response response = httpRequest.request(Method.GET);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			JsonPath responseJsonPath = new JsonPath(responseBody); 
//			logExtentReport(responseBody);
//			Assert.assertEquals(statusCode, 200);
			 
			String wfsCount = responseJsonPath.getString("output.count");
			
			int wfCount = Integer.parseInt(wfsCount);
		    if(wfCount > 0)	
		    {
				String wfName = responseJsonPath.getString("output.objects[0].name");
				logExtentReport("Workflow name: " +wfName);
				
				String wfUID = responseJsonPath.getString("output.objects[0].uid");
				logExtentReport(wfUID);
				
				  RestAssured.baseURI = URL+"/enterprise/v1/flows/"+wfUID;
				  RestAssured.urlEncodingEnabled = false;
					httpRequest = RestAssured.given(); 
					
					httpRequest.header("Content-Type","applicaton/json").
					header("Authtoken",authtoken).header("Cookie",cookie).header("project_uid",projectID);
					response = httpRequest.request(Method.DELETE);
					statusCode = response.getStatusCode();
					responseBody = response.getBody().asString();
					responseJsonPath = new JsonPath(responseBody); 
					logExtentReport(responseBody);
//					Assert.assertEquals(statusCode, 200);
				
		    }
		    else
		    	flag = false;
		}
		
}
	
	
	public   void deleteAllFlowServices()
	{
		Boolean flag = true;
		int count = 0; 
		
		while(flag)
		{
			logExtentReport("delete all flow services");
			log.info("delete all flow services");
			
			RestAssured.baseURI = URL+"/integration/rest/ut-flow/flow-metadata/"+projectID;
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			
			httpRequest.header("Content-Type","applicaton/json").
			header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf);
			Response response = httpRequest.request(Method.GET);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			logExtentReport(responseBody);
//			Assert.assertEquals(statusCode, 200);
			if(statusCode == 200)
			{
			 
			String flowsCount = responseJsonPath.getString("integration.serviceData.count");
			
			int flowCount = Integer.parseInt(flowsCount);
		    if(flowCount > count)	
		    {
				String flowName = responseJsonPath.getString("integration.serviceData.flows["+count+"].name");
				logExtentReport("Flow name is "+flowName);
				log.info("Flow name is "+flowName);
				
				  RestAssured.baseURI = URL+"/integration/rest/ut-flow/flowservice/"+projectID+"/"+flowName;
				  RestAssured.urlEncodingEnabled = false;
					httpRequest = RestAssured.given(); 
					
					httpRequest.header("Content-Type","applicaton/json").
					header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf);
					response = httpRequest.request(Method.DELETE);
					statusCode = response.getStatusCode();
					responseBody = response.getBody().asString();
					responseJsonPath = new JsonPath(responseBody); 
					logExtentReport(responseBody);
					log.info(responseBody);
					if(statusCode != 200)
						count++;
//					Assert.assertEquals(statusCode, 200);
				
		    }
		    else
		    	flag = false;
			}
			else
				flag = false;
		}
			
}
	
	public   void deleteAllTriggers()
	{
		Boolean flag = true;
		int count = 0;		
		
		while(flag)
		{
			logExtentReport("delete all Triggers");
			log.info("delete all Triggers");
			
			RestAssured.baseURI = URL+"/enterprise/v1/user/triggers";
			RestAssured.urlEncodingEnabled = false;
			RestAssured.config=RestAssuredConfig.config()
		            .httpClient(HttpClientConfig.httpClientConfig()
		                    .setParam("http.socket.timeout",60000)
		                    .setParam("http.connection.timeout", 60000));
			RequestSpecification httpRequest = RestAssured.given(); 
			
			httpRequest.header("Content-Type","applicaton/json").
			header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf).header("Project_uid",projectID);
			Response response = httpRequest.request(Method.GET);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			logExtentReport(responseBody);
//			Assert.assertEquals(statusCode, 200);
			if(statusCode == 200)
			{
			 
			String uid = responseJsonPath.getString("output[0].triggers["+count+"].uid");
					
		    if(uid != null)	
		    {
				  RestAssured.baseURI = URL+"/enterprise/v1/user/triggers/"+uid;
				  RestAssured.urlEncodingEnabled = false;
				  httpRequest = RestAssured.given(); 
					
					httpRequest.header("Content-Type","applicaton/json").
					header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf).header("Project_uid",projectID);
					response = httpRequest.request(Method.DELETE);
					statusCode = response.getStatusCode();
					responseBody = response.getBody().asString();
					responseJsonPath = new JsonPath(responseBody); 
					logExtentReport(responseBody);
					log.info(responseBody);
					if(statusCode != 200)
					{
						count++;
					}
//					Assert.assertEquals(statusCode, 200);
		    }
		    else
		    	flag = false;
		}
		else
			flag = false;
		
		}
}

public void deletegitAccount(){


	logExtentReport("delete the used git account");
	log.info("delete the used git account");

	RestAssured.baseURI = URL+"/integration/rest/vcs/git";
	RestAssured.urlEncodingEnabled = false;
	RestAssured.config=RestAssuredConfig.config()
			.httpClient(HttpClientConfig.httpClientConfig()
					.setParam("http.socket.timeout",60000)
					.setParam("http.connection.timeout", 60000));
	RequestSpecification httpRequest = RestAssured.given();
	httpRequest.header("Authtoken",authtoken).header("Cookie",cookie).header("X-Csrf-Token",csrf);
	httpRequest.contentType("application/json");
	String postbody = "{\"displayName\":\"vna\"}";
	httpRequest.body(postbody);
	logExtentReport(RestAssured.baseURI);
	log.info(RestAssured.baseURI);
	Response response = httpRequest.request(Method.DELETE);
	int statusCode = response.getStatusCode();
	String responseBody = response.getBody().asString();
	JsonPath responseJsonPath = new JsonPath(responseBody);
	logExtentReport(responseBody);
	log.info(responseBody);
	if(statusCode == 204)
	{
		logExtentReport("deleted the used git account");
		log.info("deleted the used git account");
	}
	else {
		logFailedExtentReport("git account not deleted");
		log.info("not able to delete the git account");
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
	
	public   void getERTID(String Name)
	{
		 int count = 0; 
		 boolean flag1 = false;
		 String projectUID = null;
		 List<String> agentIdsToDelete = new ArrayList<>();
		 
			logExtentReport("GETTING ERT ID");
			log.info("GETTING ERT ID");
			//System.out.println("Before get runtime method called");
		    RestAssured.baseURI = URL+"/integration/rest/runtimes";
		    RestAssured.urlEncodingEnabled = false;
			RequestSpecification httpRequest = RestAssured.given(); 
			//System.out.println("after end pioint executed"+ httpRequest.toString());
			httpRequest.header("Content-Type","applicaton/json");
			httpRequest.header("Authtoken",authtoken);
			httpRequest.header("Cookie",cookie);
			httpRequest.header("X-Csrf-Token",csrf);
//			httpRequest.headers("Authorization","Basic "+base64EncodingString(username,password)+"");
			httpRequest.param("page", 1);
			httpRequest.param("limit", 19);
			httpRequest.param("searchKey", ERTName);
			Response response = httpRequest.request(Method.GET);
			System.out.println(response);
			int statusCode = response.getStatusCode();
			//System.out.println("Statuc code "+statusCode);
			String responseBody = response.getBody().asString();
			//System.out.println("Response body "+responseBody);
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			logExtentReport(responseBody);
//			Assert.assertEquals(statusCode, 200);
			//String jsonPathExpression = "$[?(@.name=='" + ERTName + "')].agentID";
			//projectUID = responseJsonPath.getString("output.projects[0].uid");
			//responseJsonPath.setRootPath("$");
			//String ERTagentId = responseJsonPath.getString("agents.find { it.name == '" + ERTName + "' }.agentID"); 
			 agentIdsToDelete = responseJsonPath
	                .getList("agents.findAll { it.name.startsWith('"+ERTName+"') }.agentID");
			System.out.println("List of ERT with name  "+agentIdsToDelete);
			if(agentIdsToDelete!=null)
			{
				//flag1 = true;
				//logExtentReport("ERTName : "+ERTName+" Project ID "+agentIdsToDelete);
				//log.info("ERTName : "+ERTName+" Project ID "+agentIdsToDelete);
				for (String agentID : agentIdsToDelete) {
					deleteExisitngERT(agentID);
				}
				//getERTID(ERTName);
			}
			else {
				//flag = false;
				
			    //flag = flag1;
			    
				//ERTID = agentIdsToDelete;
				logExtentReport("There is not ERT present");
				log.info("There is not ERT present to delete");
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

}
