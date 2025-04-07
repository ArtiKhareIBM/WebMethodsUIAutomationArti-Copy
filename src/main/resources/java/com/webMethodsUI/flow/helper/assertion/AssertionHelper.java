package com.webMethodsUI.flow.helper.assertion;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.testng.Assert;



public class AssertionHelper {

	private static Logger log = LogManager.getLogger(AssertionHelper.class);

	public static void verifyTest(String actual, String expected) {
		log.info("Verifying text:" +actual +"with " +expected);
		Assert.assertEquals(actual, expected);
	}

	public static void makeTrue() {
		log.info("making script PASS");
		Assert.assertTrue(true);
	}

	public static void makeTrue(String message) {
		log.info("making script PASS   " +message);
		Assert.assertTrue(true, message);
	}

	public static void makeFalse() {
		log.info("making script FAIL");
		Assert.assertTrue(false);
	}

	public static void makeFalse(String message) {
		log.info("making script FAIL  " +message);
		Assert.assertTrue(false, message);
	}

	public static void verifyTrue(boolean status) {

		Assert.assertTrue(status);

	}

	public static void verifyFalse(boolean status) {

		Assert.assertFalse(status);

	}

	public static void verifyNull(String str) {
		log.info("Verify Object is null  and object is ..." +str);
		Assert.assertNull(str);
	}

	public static void verifyNotNull(String str) {
		log.info("Verifying Object is not null....and the object is....." +str);
		Assert.assertNotNull(str);
	}
	
	public static void fail() {
		Assert.assertTrue(false);
	}
	
	public static void pass() {
		Assert.assertTrue(true);
	}
		
	
	public static void verifyTestStatus(boolean status)
	{
		if(status)
		{
			pass();
		}
		else {
			fail();
		}
	}

}
