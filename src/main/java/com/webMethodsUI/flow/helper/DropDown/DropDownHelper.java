package com.webMethodsUI.flow.helper.DropDown;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.webMethodsUI.flow.testbase.CommonActions;
import com.webMethodsUI.flow.testbase.TestBase;

public class DropDownHelper extends CommonActions{

	private WebDriver driver;
	private Logger log = LogManager.getLogger(DropDownHelper.class);
	Select select;

	public DropDownHelper(WebDriver driver) 
	{
		super();
		this.driver = driver;
		log.info("Dropdown helper object is created.....");
		logExtentReport("Dropdown helper object is created.....");
	}

	public void selectUsingValue(WebElement element, String value) {
		select = null;
		select = new Select(element);
		select.selectByValue(value);
		log.info("Selecting drop down by value..." + value);
	}

	public void selectUsingIndex(WebElement element, int index) {
		select = null;
		select = new Select(element);
		select.selectByIndex(index);
		log.info("Selecting drop down by index..." + index);

	}

	public void selectUsingVisibleText(WebElement element, String visibleText) {
		select = null;
		select = new Select(element);
		select.selectByVisibleText(visibleText);
		
		log.info("select using visible text...." +visibleText);
	}
	
	public void deSelectUsingValue(WebElement element, String value)
	{
		select = null;
		select = new Select(element);
		select.deselectByValue(value);
		log.info("De select value by Value....." +value);
		
	}
	
	public void deSelectUsingIndex(WebElement element, int index) {
		select = null;
		select = new Select(element);
		select.deselectByIndex(index);
		log.info("De Selecting drop down by index..." + index);

	}
	
	public void deSelectUsingVisibleText(WebElement element, String visibleText) {
		select = null;
		select = new Select(element);
		select.deselectByVisibleText(visibleText);
		log.info("De select using visible text...." +visibleText);
	}
	
	public List<String> getAllDropDownData(WebElement element)
	{
		select = null;
		select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		
		for(WebElement ele : elementList)
		{
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		
		
		return valueList;
	}
	
	
	


}
