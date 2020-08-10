package com.NewSElTest.Base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static Logger logger1;
	
	public TestBase() 
	{
		try{
			prop = new Properties();
			FileInputStream filecon = new FileInputStream("C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/src/main/java/com/NewSElTest/config/config.properties");
			prop.load(filecon);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void intialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		logger1=Logger.getLogger("NewSelTestProj");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("newURL"));
	}
	
	public void screenCapture() throws IOException
	{
		File filesrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		File destFile = new File("C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/ScreenShot/"+timeStamp+"screnshot.png");
		FileUtils.copyFile(filesrc, destFile);
	}
	
	
	

}
