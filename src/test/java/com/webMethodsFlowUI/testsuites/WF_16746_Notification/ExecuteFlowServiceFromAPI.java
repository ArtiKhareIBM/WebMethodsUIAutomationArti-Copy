package com.webMethodsFlowUI.testsuites.WF_16746_Notification;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.webMethodsFlowUI.testsuites.CleanUpAssets.CleanAssets;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;
import com.webMethodsUI.flow.testbase.APITestCasesBaseClass;

public class ExecuteFlowServiceFromAPI  {
	
	
	//private static Logger log = LogManager.getLogger(ExecuteFlowServiceFromAPI.class);
	
       //  static String projectUID = "";
	     static String authtoken = "";
	     static String cookie = "";
	     static String csrf ="";
	     static String URL = ObjectReader.reader.getURL();
	     static String username = ObjectReader.reader.getUserName();
	     static String password = ObjectReader.reader.getPassword();
	     static String projectName ="Auto_IC_Origin_Project1";
	     static String projectName2 ="auto_ic_origin_project1";
	     static String agentID =null;
	    static boolean flag = true;
		 int iteration = 0;
		 String[] projectIDS = new String[10];
		 static String projectID = null;
		// static String ERTName ="NewErtTokentTest";
		 
	public void getAuthTokenAndCookie()
	{
		//logExtentReport("GETTING AUTHTOKEN COOKIE AND CSRF");
		//log.info("GETTING AUTHTOKEN COOKIE AND CSRF");

		RestAssured.baseURI = URL+"/enterprise/v1/user/token";
		RestAssured.urlEncodingEnabled = false;
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.header("Content-Type","applicaton/json");
		httpRequest.headers("Authorization","Basic "+base64EncodingString(username,password)+"");
		Response response = httpRequest.request(Method.GET);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		JsonPath responseJsonPath = new JsonPath(responseBody); 
		//logExtentReport(responseBody);
		Assert.assertEquals(statusCode, 200);
		authtoken = responseJsonPath.getString("output.authtoken");
		cookie = responseJsonPath.getString("output.cookie");
		csrf = responseJsonPath.getString("output.csrf");
		//logExtentReport("Authtoken "+authtoken);
		//logExtentReport("Cookie "+cookie);
		//log.info(authtoken+"   "+cookie+ "   "+csrf);
	}
	
	public static String base64EncodingString(String userName,String userPassword)
	{
			 String encodedString = null;

		try
		{
			Base64.Encoder encoder = Base64.getEncoder();
			String normalString = ""+userName+":"+userPassword+"";
			encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
	
		return encodedString;
	}
	
	public  void getERTToken(String ERTName) {
		
		//logExtentReport("Get ERT token API Invoked");
		//log.info("Get ERT token API Invoked");
		
		RestAssured.baseURI = URL+"/integration/rest/edge/runtimes";
		RestAssured.urlEncodingEnabled = false;
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.header("Content-Type","applicaton/json");
		httpRequest.header("Authtoken",authtoken);
		httpRequest.header("Cookie",cookie);
		httpRequest.header("X-Csrf-Token",csrf);
		//httpRequest.param("page", 1);
		httpRequest.queryParam("page", 1);
		httpRequest.queryParam("limit", 19);
		httpRequest.queryParam("searchKey", ERTName);
		Response response = httpRequest.request(Method.GET);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		System.out.println(statusCode +"  Status code");
		System.out.println(responseBody+"  responsebody");
		JsonPath responseJsonPath = new JsonPath(responseBody); 
		agentID =  responseJsonPath.getString("agents[0].agentID");
		System.out.println(agentID);
		//JsonPath responseJsonPath = new JsonPath(responseBody); 
		//page=1&limit=19&searchKey=newerttest
	}
	
	public void syncERT() {
		//logExtentReport("Get syncERT API Invoked");
	//	log.info("Get syncERT API Invoked");
		
		String requestBody = "{\r\n"
				+ "    \"apiEndPoint\": \"/scaffolding/sync\",\r\n"
				+ "    \"agentID\": \""+agentID+"\",\r\n"
				+ "    \"agentGroup\": \"default\",\r\n"
				+ "    \"httpMethod\": \"POST\",\r\n"
				+ "    \"input\": {\r\n"
				+ "        \"agentId\": \""+agentID+"\",\r\n"
				+ "        \"enableConnections\": true\r\n"
				+ "    }\r\n"
				+ "}";
		
		RestAssured.baseURI = URL+"/integration/rest/edge/flow/admin-proxy/";
		RestAssured.urlEncodingEnabled = false;
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.header("Content-Type","applicaton/json",ContentType.JSON );
		httpRequest.header("Authtoken",authtoken);
		httpRequest.header("Cookie",cookie);
		httpRequest.header("X-Csrf-Token",csrf);
		httpRequest.body(requestBody);
		Response response = httpRequest.request(Method.POST);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		System.out.println(statusCode +"  Status code");
		System.out.println(responseBody+"  responsebody");
		JsonPath responseJsonPath = new JsonPath(responseBody); 
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(responseJsonPath.getString("message"),"Successfully synced runtime: "+agentID+"");
		
	}
	public void ececuteFlowService() {
		
		//logExtentReport("Get ececuteFlowService API Invoked");
		//log.info("Get ececuteFlowService API Invoked");
		
		String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Values version=\"2.0\"/>";
		
		
		RestAssured.baseURI = URL+"/integration/rest/edge/flow/execute/"+projectID+"/EmitNotification";
		RestAssured.urlEncodingEnabled = false;
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.header("Content-Type","applicaton/json",ContentType.XML );
		httpRequest.header("Authtoken",authtoken);
		httpRequest.header("Cookie",cookie);
		httpRequest.header("X-Csrf-Token",csrf);
		httpRequest.queryParam("agentGroup","default");
		httpRequest.queryParam("agentID",agentID);
		httpRequest.body(requestBody);
		Response response = httpRequest.request(Method.POST);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		System.out.println(statusCode +"  Status code");
		System.out.println(responseBody+"  responsebody");
		Assert.assertEquals(statusCode, 200);
		XmlPath xmlPath = new XmlPath(responseBody);
		//Assert.assertEquals(xmlPath.get, null)
		String channelID = xmlPath.getString("Values.record.number.find { it.@name == 'channelId' }");
		String severity = xmlPath.getString("Values.record.value.find { it.@name == 'severity' }");
        String subject = xmlPath.getString("Values.record.value.find { it.@name == 'subject' }");
        String alertId = xmlPath.getString("Values.record.number.find { it.@name == 'alertId' }");
        String status = xmlPath.getString("Values.record.value.find { it.@name == '$status' }");

        // Asserting values using Hamcrest's assertThat
        assertThat(channelID, equalTo("5"));  // Assert that channelId is "5"
        assertThat(severity, equalTo("Critical"));  // Assert severity is "Critical"
        assertThat(subject, equalTo("testSubject"));  // Assert subject is "testSubject"
      //  assertThat(alertId, equalTo("151"));  // Assert alertId is "151"
        assertThat(status, equalTo("success"));  // Assert status is "success"
	}
	public void sync1() {
		String payload = "{\r\n"
				+ "    \"agentID\": \"default\",\r\n"
				+ "    \"agentGroup\": \"Default\",\r\n"
				+ "    \"apiEndPoint\": \"/scaffolding/agentManifest\",\r\n"
				+ "    \"httpMethod\": \"POST\",\r\n"
				+ "    \"input\": {\r\n"
				+ "        \"agentId\": \""+agentID+"\",\r\n"
				+ "        \"tags\": \"EmitNotification\",\r\n"
				+ "        \"services\": [\r\n"
				+ "            {\r\n"
				+ "                \"serviceName\": \"project."+projectName2+".integrations:EmitNotification\"\r\n"
				+ "            }\r\n"
				+ "        ]\r\n"
				+ "    }\r\n"
				+ "}";
		
		
		    RestAssured.baseURI = URL+"/integration/rest/edge/flow/admin-proxy";
			RestAssured.urlEncodingEnabled = false;
			RequestSpecification httpRequest = RestAssured.given(); 
			httpRequest.header("Content-Type","applicaton/json",ContentType.JSON );
			httpRequest.header("Authtoken",authtoken);
			httpRequest.header("Cookie",cookie);
			httpRequest.header("X-Csrf-Token",csrf);
			//httpRequest.queryParam("agentGroup","default");
			//httpRequest.queryParam("agentID",agentID);
			httpRequest.body(payload);
			Response response = httpRequest.request(Method.POST);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			System.out.println(statusCode +"  Status code");
			System.out.println(responseBody+"  responsebody");
			Assert.assertEquals(statusCode, 201);
		
	}
	
	public void sync2() {
		String payload = "{\r\n"
				+ "    \"apiEndPoint\": \"/package/"+projectName+"Project\",\r\n"
				+ "    \"agentID\": \"default\",\r\n"
				+ "    \"agentGroup\": \"default\",\r\n"
				+ "    \"httpMethod\": \"GET\"\r\n"
				+ "}";
		
		
		    RestAssured.baseURI = URL+"/integration/rest/edge/flow/admin-proxy/";
			RestAssured.urlEncodingEnabled = false;
			RequestSpecification httpRequest = RestAssured.given(); 
			httpRequest.header("Content-Type","applicaton/json",ContentType.JSON);
			httpRequest.header("Authtoken",authtoken);
			httpRequest.header("Cookie",cookie);
			httpRequest.header("X-Csrf-Token",csrf);
			//httpRequest.queryParam("agentGroup","default");
			//httpRequest.queryParam("agentID",agentID);
			httpRequest.body(payload);
			Response response = httpRequest.request(Method.POST);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			System.out.println(statusCode +"  Status code");
			System.out.println(responseBody+"  responsebody");
			Assert.assertEquals(statusCode, 200);
		
	}
	
	public void sync3() {
		String payload = "{\r\n"
				+ "    \"apiEndPoint\": \"/package/"+projectName+"Project\",\r\n"
				+ "    \"agentID\": \""+agentID+"\",\r\n"
				+ "    \"agentGroup\": \"default\",\r\n"
				+ "    \"httpMethod\": \"GET\"\r\n"
				+ "}";
		
		
		    RestAssured.baseURI = URL+"/integration/rest/edge/flow/admin-proxy/";
			RestAssured.urlEncodingEnabled = false;
			RequestSpecification httpRequest = RestAssured.given(); 
			httpRequest.header("Content-Type","applicaton/json",ContentType.JSON );
			httpRequest.header("Authtoken",authtoken);
			httpRequest.header("Cookie",cookie);
			httpRequest.header("X-Csrf-Token",csrf);
			//httpRequest.queryParam("agentGroup","default");
			//httpRequest.queryParam("agentID",agentID);
			httpRequest.body(payload);
			Response response = httpRequest.request(Method.POST);
			int statusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			System.out.println(statusCode +"  Status code");
			System.out.println(responseBody+"  responsebody");
			Assert.assertEquals(statusCode, 200);
		
	}
	
   public void syncConfirmtoERT() {
	   String requestPayload = "{\r\n"
	   		+ "    \"apiEndPoint\": \"/package/"+projectName+"Project\",\r\n"
	   		+ "    \"agentID\": \""+agentID+"\",\r\n"
	   		+ "    \"agentGroup\": \"default\",\r\n"
	   		+ "    \"httpMethod\": \"GET\"\r\n"
	   		+ "}";
	   
	   
	    RestAssured.baseURI = URL+"/integration/rest/edge/flow/admin-proxy/";
		RestAssured.urlEncodingEnabled = false;
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.header("Content-Type","applicaton/json",ContentType.XML );
		httpRequest.header("Authtoken",authtoken);
		httpRequest.header("Cookie",cookie);
		httpRequest.header("X-Csrf-Token",csrf);
		//httpRequest.queryParam("agentGroup","default");
		//httpRequest.queryParam("agentID",agentID);
		httpRequest.body(requestPayload);
		Response response = httpRequest.request(Method.POST);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		System.out.println(statusCode +"  Status code");
		System.out.println(responseBody+"  responsebody");
		Assert.assertEquals(statusCode, 200);
   }
	
	
	public void getProjectID(String projectName)
	{
		 int count = 0; 
		 boolean flag1 = false;
		 String projectUID = null;
		 
			//logExtentReport("GETTING Project ID");
		  //  log.info("GETTING Project ID");
			
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
			System.out.println(statusCode +"  Status code");
			System.out.println(responseBody+"  responsebody");
			JsonPath responseJsonPath = new JsonPath(responseBody); 
			//logExtentReport(responseBody);
     		Assert.assertEquals(statusCode, 200);
			
			projectUID = responseJsonPath.getString("output.projects[0].uid");
			if(projectUID!=null)
			{
				flag1 = true;
			//	logExtentReport("projectName : "+projectName+" Project ID "+projectUID);
				//log.info("projectName : "+projectName+" Project ID "+projectUID);
			}
			else
				flag = false;
				
			    flag = flag1;
			    
				projectID = projectUID;
	}
	
	//https://azsprotenant6.int-az-us.webmethods-spro.io/integration/rest/edge/flow/execute/fl4c6363b84fc2672c5b21f6/EmitNotification?agentGroup=default&agentID=79c8eded6b8d4adfabbf8b41d92da19e
	/*
	 * public static void main(String[] args) { getAuthTokenAndCookie();
	 * getERTToken(); syncERT(); getProjectID(projectName); ececuteFlowService(); //
	 * Base URI of the API
	 * 
	 * }
	 */
    
    
}
