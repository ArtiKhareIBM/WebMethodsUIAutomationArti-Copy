package com.webMethodsUI.flow.utils;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ConfigReader;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RESTCustomLogFilter implements Filter {
	private StringBuilder requestBuilderLogs;
	private StringBuilder responseBuilderLogs;

	@Override
	public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
		Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
		String extentReport = ObjectReader.reader.getExtentReporting();
		requestBuilderLogs = new StringBuilder();

		if(extentReport.equalsIgnoreCase("true")) {
			requestBuilderLogs = new StringBuilder();
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("Request and Response Details:");
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("----------------------------");
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("Request method: " + objectValidation(filterableRequestSpecification.getMethod()));
			requestBuilderLogs.append(System.lineSeparator());
			requestBuilderLogs.append("Request URI: " + objectValidation(filterableRequestSpecification.getURI()));
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("Form Params: " + objectValidation(filterableRequestSpecification.getFormParams()));
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("Request Param: " + objectValidation(filterableRequestSpecification.getRequestParams()));
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("Headers: " + objectValidation(filterableRequestSpecification.getHeaders()));
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("Cookies: " + objectValidation(filterableRequestSpecification.getCookies()));
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("Proxy: " + objectValidation(filterableRequestSpecification.getProxySpecification()));
			requestBuilderLogs.append("\n");
			requestBuilderLogs.append("Body: " + objectValidation(filterableRequestSpecification.getBody()));
			requestBuilderLogs.append("\n");
			responseBuilderLogs = new StringBuilder();
			responseBuilderLogs.append("Status Code: "+response.getStatusCode());
			responseBuilderLogs.append("\n");
			responseBuilderLogs.append("Status Line: "+response.getStatusLine());
			responseBuilderLogs.append("\n");
			responseBuilderLogs.append("Response Cookies: "+response.getDetailedCookies());
			responseBuilderLogs.append("\n");
			responseBuilderLogs.append("Response Content Type: "+response.getContentType());
			responseBuilderLogs.append("\n");
			responseBuilderLogs.append("Response Headers: "+response.getHeaders());
			responseBuilderLogs.append("\n");
			responseBuilderLogs.append("Response Body: "+"\n"+response.getBody().asString());
		}
		return response;
	}

	public String getRequestBuilder() {
		if(requestBuilderLogs.length() == 0) {
			return null;
		} else {
			return requestBuilderLogs.toString();
		}
	}

	public String getResponseBuilder() {
		if(responseBuilderLogs == null) {
			return null;
		} else {
			return responseBuilderLogs.toString();
		}
	}

	public String objectValidation(Object o) {
		if (o == null)
			return null;
		else
			return o.toString();
	}

	public void cleanRequestandResponseBuilders() {
		requestBuilderLogs.setLength(0);
		responseBuilderLogs.setLength(0);
	}



}
