package com.webMethodsUI.flow.utils;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.webMethodsUI.flow.helper.browserConfigurations.config.ConfigReader;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;

public class BaseRestAutomation {
	public static HashMap<Thread,String> tlRequestResponse= new HashMap<Thread,String>(); 
	Filter logFilter;
	
	/**
	 * Constructor which initializes the RequestSpecification
	 */
	public BaseRestAutomation(){ 
 		if(relaxedHTTPSValidation.equals("true")) {
			logFilter = new RESTCustomLogFilter();
			requestSpecification = RestAssured.given().relaxedHTTPSValidation().filter(logFilter);;
			}
		else {
			logFilter = new RESTCustomLogFilter();
			requestSpecification = RestAssured.given().filter(logFilter);
			
		}
	}
	
	String relaxedHTTPSValidation = ObjectReader.reader.getHTTPS_Relaxed_validation();
	int DEFAULT_REST_READ_TIMEOUT_MS = ObjectReader.reader.getDefaultReadConnectionTimeOut();
	int DEFAULT_REST_CONNECTION_TIMEOUT_MS = ObjectReader.reader.getDefaultconnectionTimeOut();


	Response response = null;
	protected RequestSpecification requestSpecification = null;

	public JSONObject jsonFileReader(String filePath) {
		JSONObject json = null;
		try {
			Reader reader = new InputStreamReader(new FileInputStream(filePath));
			json = (JSONObject) JSONValue.parse(reader);
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	public void setRequestURL(String URL) 
	{
		requestSpecification.baseUri(URL);
	}

	public void setRequestHeaders(HashMap<String, ?> requestHeaders) 
	{
		requestSpecification.headers(requestHeaders);
	}
	
	/**
	 * Sets the headers to the request specification
	 * 
	 * @param requestHeaders HashMap of header parameters to be configured in REST-assured RequestSpecification
	 * Example requestHeaders = "accept=application/json,content-type=application/json" 
	 *
	 */
	public void setRequestHeaders(String requestHeaders) {
		requestSpecification.headers(generateHashMap(requestHeaders));
	}

	/**
	 * Generates Hashmap using String which contains a list of keys and value pairs separated with a comma. This method gets called request builder methods
	 * 
	 * @param keyValueList  Example value:key1=value1,key2=value2,key3=value3
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> generateHashMap(String keyValueList) {
		String[] queryKeyAndValues = null;
		HashMap<String, String> queryParamsMap = new HashMap<String, String>();
		if(keyValueList!=null) {
			if(keyValueList.contains(",")) {
				queryKeyAndValues = keyValueList.split(",");
			}else if(keyValueList.contains("&")) {
				queryKeyAndValues = keyValueList.split("&");
			}else if(keyValueList.contains(";")) {
				queryKeyAndValues = keyValueList.split(";");
			}else {
				queryKeyAndValues = new String[1];
				queryKeyAndValues[0]=keyValueList;
			}

			for (String queryKeyAndValue : queryKeyAndValues) {
			    String delimiter = null;

			    if (queryKeyAndValue.contains("=")) {
			        delimiter = "=";
			    } else if (queryKeyAndValue.contains(":")) {
			        delimiter = ":";
			    } else {
			        throw new RuntimeException(queryKeyAndValue + " Please pass the key and value separated with \"=\" or \":\"");
			    }

			    String[] keyValue = queryKeyAndValue.split(delimiter, 2); // Limit the split to 2 parts
			    queryParamsMap.put(keyValue[0], keyValue.length == 2 && keyValue[1] != null ? keyValue[1] : "");
			}
		}
		return queryParamsMap;
	}
	
	
	/**
	 * Verifies the response code. Compares the response code with the expected response code
	 * 
	 * @param  expectedResponseCode  Expected response code as int
	 * 
	 */ 
	public void verifyResponseCode(int expectedResponseCode) {
		if(response!=null) {
			assertEquals(expectedResponseCode, response.getStatusCode());
		} else {
			throw new AssertionError(
					("Response is null"));				
		}
	}
	
	
	public void setRequestBody(String requestBody) 
	{
		requestSpecification.body(requestBody);
	}

	/**
	 * POST REST call.
	 * Pre-requisite: requestSpecification has to be configured using URL and 
	 * other applicable request details like headers, request body, and query parameters using setter methods	 * 
	 */
	public void post() {	
		extentRequestLogging();
		setDefaultHttpRequestTimeouts();
 		response= requestSpecification    
				.when()
				.post();
		extentResponseLogging();
		setValuesToTlRequestResponse();	
		resetRequestSpecification();
	}
	
	private void extentRequestLogging() {
		String extentLogging = ObjectReader.reader.getExtentLogging();
		if(extentLogging.equalsIgnoreCase("true")) {
			requestSpecification.log().all();
		}
	}
	
	private void setDefaultHttpRequestTimeouts(){
		setHttpConnectionAndResponseReadTimeout(DEFAULT_REST_CONNECTION_TIMEOUT_MS,DEFAULT_REST_READ_TIMEOUT_MS);
	}
	
	/**
	 * Sets the connection and response read timeout values
	 * @param connectionTimeout
	 * @param readTimeout
	 *   
	 */
	public void setHttpConnectionAndResponseReadTimeout(int connectionTimeout, int readTimeout) {
		String connectionTimeoutSet = extractTimeoutAssignedFromHttpCofing("http.connection.timeout");
		String socketTimeout = extractTimeoutAssignedFromHttpCofing("http.socket.timeout");
		if(connectionTimeoutSet.equals("0") || connectionTimeoutSet == null || 
				socketTimeout.equals("0") || socketTimeout == null ) {
			requestSpecification.config(RestAssuredConfig.config()
					.httpClient(HttpClientConfig.httpClientConfig()
							.setParam("http.connection.timeout", connectionTimeout)
							.setParam("http.socket.timeout", readTimeout)));
		}

	}
	
	private String extractTimeoutAssignedFromHttpCofing(String timeoutParameter) {
        //Extract existing http configuration values
		FilterableRequestSpecification httpRequest = (FilterableRequestSpecification) requestSpecification;
         String input = httpRequest.getConfig().getHttpClientConfig().params().toString();
        String timeoutValue = "0";
        // Remove the braces
        input = input.substring(1, input.length() - 1);

        // Split the string into key-value pairs
        String[] keyValuePairs = input.split(", (?=http\\.)");
        Map<String, String> configMap = new HashMap<String, String>();

        // Populate the map
        for (String pair : keyValuePairs) {
            int index = pair.indexOf('=');
            String key = pair.substring(0, index).trim();
            String value = pair.substring(index + 1).trim();
            configMap.put(key, value);
        }

        // Check if http.socket.timeout key is present
        if (configMap.containsKey(timeoutParameter)) {
        	timeoutValue = configMap.get(timeoutParameter);
         }
		return timeoutValue;  
    }
	
	private void extentResponseLogging() {
		String extentLogging = ObjectReader.reader.getExtentLogging();
		if(extentLogging.equalsIgnoreCase("true")) {
			response.then().log().all();
		}
	}
	
	
	public void setValuesToTlRequestResponse() {
		Thread thread = java.lang.Thread.currentThread(); 
		RESTCustomLogFilter customLogFilter = (RESTCustomLogFilter) logFilter;
		tlRequestResponse.put(thread, customLogFilter.getRequestBuilder()+"\n"+customLogFilter.getResponseBuilder());
	}
	
	public void resetRequestSpecification() {
		if(relaxedHTTPSValidation.equals("true")) {
			logFilter = new RESTCustomLogFilter();
			requestSpecification = RestAssured.given().relaxedHTTPSValidation().filter(logFilter);;
			}
		else {
			logFilter = new RESTCustomLogFilter();
			requestSpecification = RestAssured.given().filter(logFilter);
		}
	}
	
	/**
	 * Delete REST call.
	 * Pre-requisite: requestSpecification has to be configured using URL and 
	 * other applicable request details like headers, request body, and query parameters using setter methods	 * 
	 */
	public void delete() {
		extentRequestLogging();
		setDefaultHttpRequestTimeouts();
		response= requestSpecification   
				.when()
				.delete();
		extentResponseLogging();
		setValuesToTlRequestResponse();
		resetRequestSpecification();
	}
	
}
