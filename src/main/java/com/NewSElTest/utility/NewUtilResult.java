package com.NewSElTest.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.NewSElTest.Base.TestBase;

public class NewUtilResult extends TestBase implements ITestListener {
	
	@Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("The name of the testcase failed is :"+Result.getName());
    try {
		screenCapture();
	} catch (IOException e) {
		e.printStackTrace();
	}
    }

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The name of the testcase start is :"+result.getName());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase success is :"+result.getName());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is :"+result.getName());	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The name of the testcase success percntage is :"+result.getName());	
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("The name of the testcase start is :"+context.getName());	
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("The name of the testcase Finsih is :"+context.getName());	
	}
	
	

	
}
