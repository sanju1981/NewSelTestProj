package com.NewSElTest.utility;



import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter("C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/test-output/"+repName);
		htmlReporter.loadXMLConfig("C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/extent-config.xml");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("enviorment", "QA");
		extent.setSystemInfo("user", "Sanjit");
		
		htmlReporter.config().setDocumentTitle("SelTestProject");
		htmlReporter.config().setReportName("Automation ORGHRM Project");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		String screenshotpath="C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/ScreenShot/"+timeStamp+"screnshot.png";
				
		
		if(screenshotpath.contains("2020"))
		{
			try
			{
				logger.fail("Screenshot is below==>:"+logger.addScreenCaptureFromPath(screenshotpath));
							
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
