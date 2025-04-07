package com.webMethodsUI.flow.helper.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

//call this RetryListener whenever you wants rerun the tests from testng xml file
public class RetryListener implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		   IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		   if(retry == null)
		   {
			   //set the analyser for Retry class
			   annotation.setRetryAnalyzer(Retry.class);
		   }
	}
	
	
	
	

}
