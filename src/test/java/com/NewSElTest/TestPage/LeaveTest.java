package com.NewSElTest.TestPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NewSElTest.Base.TestBase;
import com.NewSElTest.page.LeavePage;
import com.NewSElTest.page.LoginPage;
import com.NewSElTest.util.utilOperation;
@Listeners(com.NewSElTest.utility.Reporting.class)
public class LeaveTest extends TestBase {
	
	LoginPage lopo;
	LeavePage lepe;
	utilOperation utilop;
	
	public LeaveTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		intialization();
		lopo=new LoginPage();
		lopo.clicksignIn(prop.getProperty("newUser"), prop.getProperty("passw"));
		lepe=new LeavePage();
		utilop=new utilOperation();
	}
		
	@Test(priority=1)
	public void VerifyToDate() throws InterruptedException
	{
		String leaveTitle = lepe.validateFormDate();
		Assert.assertEquals(leaveTitle, "2020-02-14");
		String todateTitle = lepe.validateToDate();
		Assert.assertEquals(todateTitle, "2021-04-26");
	}
	@Test(priority=2)
	public void verifyCheckStstus() throws InterruptedException
	{
		lepe.validateFormDate();
		lepe.validateToDate();
		lepe.verifyLeaveStatus();
	}
	@Test(priority=3)
	public void validateConfigure() throws Throwable 
	{
		lepe.verifyConfigure();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
