package com.NewSElTest.util;



import org.openqa.selenium.JavascriptExecutor;

import com.NewSElTest.Base.TestBase;

public class utilOperation extends TestBase {
	
	public static String getPageTitle() throws Exception
	{
		try {
			System.out.println(String.format("The title of the page is==>>"+driver.getTitle()));
			return driver.getTitle();			
		}catch(Exception e)
		{
			throw new Exception(String.format("The current page titile is==>"+driver.getTitle()));
		}
		
	}
	
	public static void windowScroll()
	{
		JavascriptExecutor JS=(JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,500)");
	}
	
	
}
